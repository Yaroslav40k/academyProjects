package com.miniworkshop.springmvc.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.miniworkshop.springmvc.dao.MiniatureDAOImpl;
import com.miniworkshop.springmvc.model.Miniature;
import com.miniworkshop.springmvc.model.Phone;
import com.miniworkshop.springmvc.model.User;
import com.miniworkshop.springmvc.model.UserProfile;
import com.miniworkshop.springmvc.service.MiniatureService;
import com.miniworkshop.springmvc.service.MiniatureServiceImpl;
import com.miniworkshop.springmvc.service.PhoneService;
import com.miniworkshop.springmvc.service.UserProfileService;
import com.miniworkshop.springmvc.service.UserService;

@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class AppController {

	@Autowired
	UserService userService;

	@Autowired
	PhoneService phoneService;
	
	@Autowired
	MiniatureService miniatureService;

	@Autowired
	UserProfileService userProfileService;

	@Autowired
	MessageSource messageSource;

	@Autowired
	PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;

	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;


	
	@RequestMapping(value = { "/aboutMe" }, method = RequestMethod.GET)
	public String showAboutMe(ModelMap model) {
		
		List<String> someList = new LinkedList<String>();
		Miniature spaceMarine  = miniatureService.findMiniatureById(1);
		List<Miniature> spaceMarines = new  ArrayList<Miniature>();
		spaceMarines.add(spaceMarine);
		System.out.println(spaceMarine);
		model.addAttribute("spaceMarines", spaceMarines);
		
		
		User user = userService.findBySSO(getPrincipal());	
		model.addAttribute("loggedinuser", user);
		return "aboutMe";
	}
	
	
	@RequestMapping(value = { "/contacts" }, method = RequestMethod.GET)
	public String showContacts(ModelMap model) {
		
		
		User user = userService.findBySSO(getPrincipal());	
		model.addAttribute("loggedinuser", user);
		return "contacts";
	}
	
	@RequestMapping(value = { "/galleryMain" }, method = RequestMethod.GET)
	public String showgalleryMain(ModelMap model) {
		
		
		User user = userService.findBySSO(getPrincipal());	
		model.addAttribute("loggedinuser", user);
		return "galleryMain";
	}
	
	@RequestMapping(value = { "/paymentDelivery" }, method = RequestMethod.GET)
	public String showPaymentAndTransport(ModelMap model) {
		
		
		User user = userService.findBySSO(getPrincipal());	
		model.addAttribute("loggedinuser", user);
		return "paymentDelivery";
	}
	
	
	@RequestMapping(value = {"/", "/home" }, method = RequestMethod.GET)
	public String showHome(ModelMap model) {
		User user = userService.findBySSO(getPrincipal());	
		model.addAttribute("loggedinuser", user);
		return "home";
	}
	
	@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	public String listUsers(ModelMap model) {

		List<User> users = userService.findAllUsers();
		model.addAttribute("users", users);
		return "userslist";
	}

	/**
	 * This method will provide the medium to add a new user.
	 */
	@RequestMapping(value = { "/newuser" }, method = RequestMethod.GET)
	public String newUser(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("edit", false);
		
		return "registration";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * saving user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/newuser" }, method = RequestMethod.POST)
	public String saveUser(@Valid User user, BindingResult result, ModelMap model) {


		/*
		 * Preferred way to achieve uniqueness of field [sso] should be implementing
		 * custom @Unique annotation and applying it on field [sso] of Model class
		 * [User].
		 * 
		 * Below mentioned peace of code [if block] is to demonstrate that you can fill
		 * custom errors outside the validation framework as well while still using
		 * internationalized messages.
		 * 
		 */
		if (!userService.isUserSSOUnique(user.getId(), user.getSsoId())) {
			FieldError ssoError = new FieldError("user", "ssoId", messageSource.getMessage("non.unique.ssoId",
					new String[] { user.getSsoId() }, Locale.getDefault()));
			result.addError(ssoError);
			return "registration";
		}

		if(user.getUserProfiles().size()<1) {
			Set<UserProfile> userProfiles =  new HashSet<UserProfile>();
			userProfiles.add(userProfileService.findByType("USER"));
			user.setUserProfiles(userProfiles);
		}
		userService.saveUser(user);

		model.addAttribute("success",
				"User " + user.getFirstName() + " " + user.getLastName() + " registered successfully");
		return "SuccessWindow";
	}

	/**
	 * This method will provide the medium to update an existing user.
	 */
	@RequestMapping(value = { "/edit-user-{ssoId}" }, method = RequestMethod.GET)
	public String editUser(@PathVariable String ssoId, ModelMap model) {
		User user = userService.findBySSO(ssoId);
		model.addAttribute("user", user);
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", getPrincipal());
		return "registration";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * updating user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit-user-{ssoId}" }, method = RequestMethod.POST)
	public String updateUser(@Valid User user, BindingResult result, ModelMap model, @PathVariable String ssoId) {

		if (result.hasErrors()) {
			return "registration";
		}

		/*
		 * //Uncomment below 'if block' if you WANT TO ALLOW UPDATING SSO_ID in UI which
		 * is a unique key to a User. if(!userService.isUserSSOUnique(user.getId(),
		 * user.getSsoId())){ FieldError ssoError =new
		 * FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new
		 * String[]{user.getSsoId()}, Locale.getDefault())); result.addError(ssoError);
		 * return "registration"; }
		 */

		userService.updateUser(user);

		model.addAttribute("success",
				"User " + user.getFirstName() + " " + user.getLastName() + " updated successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		return "SuccessWindow";
	}

	/**
	 * This method will delete an user by it's SSOID value.
	 */
	@RequestMapping(value = { "/delete-user-{ssoId}" }, method = RequestMethod.GET)
	public String deleteUser(@PathVariable String ssoId) {
		userService.deleteUserBySSO(ssoId);
		return "redirect:/list";
	}

	/**
	 * This method will provide UserProfile list to views
	 */
	@ModelAttribute("role")
	public UserProfile initializeProfile() {
		System.out.println("IN USERPROF INIT");
		return userProfileService.findByType("USER");
	}
	/**
	 * This method will provide UserProfiles list to views
	 */
	@ModelAttribute("roles")
	public List<UserProfile> initializeProfiles() {
		System.out.println("IN USERPROFS INIT");
		return userProfileService.findAll();
	}

	/**
	 * This method handles Access-Denied redirect.
	 */
	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("loggedinuser", getPrincipal());
		return "accessDenied";
	}

	/**
	 * This method handles login GET requests. If users is already logged-in and
	 * tries to goto login page again, will be redirected to list page.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(ModelMap model) {
		if (isCurrentAuthenticationAnonymous()) {
			return "login";
		} else {			
			User user = userService.findBySSO(getPrincipal());
			model.addAttribute("loggedinuser", user);
			return "home";
		}
	}

	/**
	 * This method handles logout requests. Toggle the handlers if you are
	 * RememberMe functionality is useless in your app.
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			// new SecurityContextLogoutHandler().logout(request, response, auth);
			persistentTokenBasedRememberMeServices.logout(request, response, auth);
			SecurityContextHolder.getContext().setAuthentication(null);
		}
		return "home";
	}

	/**
	 * This method returns the principal[user-name] of logged-in user.
	 */
	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}

	/**
	 * This method returns true if users is already authenticated [logged-in], else
	 * false.
	 */
	private boolean isCurrentAuthenticationAnonymous() {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authenticationTrustResolver.isAnonymous(authentication);
	}

}