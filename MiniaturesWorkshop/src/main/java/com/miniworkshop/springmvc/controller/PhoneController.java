package com.miniworkshop.springmvc.controller;

import java.util.List;
import java.util.Locale;

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

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.miniworkshop.springmvc.model.Phone;

import com.miniworkshop.springmvc.service.PhoneService;


@Controller
@RequestMapping("/phones")
@SessionAttributes("roles")
public class PhoneController {

	@Autowired
	PhoneService phoneService;

	@Autowired
	MessageSource messageSource;

	@Autowired
	PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;

	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;

	@RequestMapping(value = { "/show-phones" }, method = RequestMethod.GET)
	public String showPhones(ModelMap model) {

		List<Phone> phones = phoneService.findAllPhones();
		model.addAttribute("phones", phones);
		model.addAttribute("loggedinuser", getPrincipal());
		return "listOfPhones";
	}

	@RequestMapping(value = { "/show-phone-{ownerID}" }, method = RequestMethod.GET)
	public String showPhoneByOwner(@PathVariable int ownerID, ModelMap model) {
		List<Phone> phones = phoneService.findByOwner(ownerID);
		model.addAttribute("phones", phones);
		model.addAttribute("loggedinuser", getPrincipal());
		return "listOfPhones";
	}


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

	@RequestMapping(value = { "/newphone-{ownerID}" }, method = RequestMethod.GET)
	public String newPhone(@PathVariable int ownerID, ModelMap model) {
		Phone phone = new Phone();
		model.addAttribute("phone", phone);
		model.addAttribute("ownerID", ownerID);
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", getPrincipal());
		return "regNewPhone";
	}

	@RequestMapping(value = { "/newphone-{ownerID}" }, method = RequestMethod.POST)
	public String newPhone(@Valid Phone phone, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "regNewPhone";
		}
		phoneService.save(phone);
		model.addAttribute("success",
				"Phone " + phone.getAreaCode() + " " + phone.getPhoneNumber() + " saved successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		return "registrationsuccess";

	}

	@RequestMapping(value = { "/edit-phone-{id}" }, method = RequestMethod.GET)
	public String editPhone(@PathVariable long id, ModelMap model) {
		Phone phone = phoneService.findById(id);
		model.addAttribute("phone", phone);
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", getPrincipal());
		return "regNewPhone";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * updating user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit-phone-{id}" }, method = RequestMethod.POST)
	public String editPhone(@Valid Phone phone, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "regNewPhone";
		}
		 phoneService.updatePhone(phone);
		model.addAttribute("success",
				"Phone " + phone.getAreaCode() + " " + phone.getPhoneNumber() + " saved successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		return "registrationsuccess";

	}
	
	@RequestMapping(value = { "/delete-phone-{id}" }, method = RequestMethod.GET)
	public String deletePhone(@PathVariable long id) {
		phoneService.deleteById(id);
		return "redirect:/show-phones";
	}
}