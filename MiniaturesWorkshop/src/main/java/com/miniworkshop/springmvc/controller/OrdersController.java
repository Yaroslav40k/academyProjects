package com.miniworkshop.springmvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.miniworkshop.springmvc.dao.OrderDeatilsDAO;
import com.miniworkshop.springmvc.model.Faction;
import com.miniworkshop.springmvc.model.GameSystem;
import com.miniworkshop.springmvc.model.Manufacturer;
import com.miniworkshop.springmvc.model.Miniature;
import com.miniworkshop.springmvc.model.Order;
import com.miniworkshop.springmvc.model.OrderDetails;
import com.miniworkshop.springmvc.model.User;
import com.miniworkshop.springmvc.service.BaseService;
import com.miniworkshop.springmvc.service.FactionService;
import com.miniworkshop.springmvc.service.GameSystemService;
import com.miniworkshop.springmvc.service.ManufacturerService;
import com.miniworkshop.springmvc.service.MiniatureService;
import com.miniworkshop.springmvc.service.OrderDetailsService;
import com.miniworkshop.springmvc.service.OrderService;
import com.miniworkshop.springmvc.service.UserService;

@Controller
@RequestMapping("/orders")

@SessionAttributes("roles")

public class OrdersController {

	@Autowired
	UserService userService;

	@Autowired
	MiniatureService miniatureService;

	@Autowired
	FactionService factionService;

	@Autowired
	GameSystemService gameSystemService;

	@Autowired
	ManufacturerService manufacturerService;

	@Autowired
	BaseService baseService;

	@Autowired
	OrderDetailsService orderDetailsService;

	@Autowired
	OrderService orderService;

	@RequestMapping(value = { "/choosePainter" }, method = RequestMethod.GET)
	public String choosePainter(ModelMap model) {

		User user = userService.findBySSO(getPrincipal());
		List<Order> paintersOrders = orderService.findOrdersByCustomer(user.getId());

		model.addAttribute("paintersOrders", paintersOrders);
		model.addAttribute("loggedinuser", user);

		return "choosePainter";
	}

	@RequestMapping(value = { "/stage1" }, method = RequestMethod.GET)
	public String showManufacturers(ModelMap model) {

		User user = userService.findBySSO(getPrincipal());

		Order possibleOrder = orderService.findCurrentOrder(user.getId());
		if (possibleOrder == null) {
			possibleOrder = new Order();
			possibleOrder.setCustomerId(user.getId());
			possibleOrder.setPainterId(1);
			possibleOrder.setOrderStatus("CREATING");
			orderService.saveOrder(possibleOrder);
		}

		List<Manufacturer> manufList = manufacturerService.findAllManufacturers();
		model.addAttribute("manufacturers", manufList);

		model.addAttribute("loggedinuser", user);

		return "makeOrderStage1";
	}

	@RequestMapping(value = { "/stage2-{manuf_id}" }, method = RequestMethod.GET)
	public String showGameSystems(ModelMap model, @PathVariable String manuf_id) {

		User user = userService.findBySSO(getPrincipal());
		model.addAttribute("loggedinuser", user);

		List<GameSystem> gameSystemsList = gameSystemService.findAllGameSystemsByManuf(Integer.parseInt(manuf_id));
		model.addAttribute("gameSystems", gameSystemsList);

		return "makeOrderStage2";
	}

	@RequestMapping(value = { "/stage3-{gs_id}" }, method = RequestMethod.GET)
	public String showFactions(@PathVariable String gs_id, ModelMap model) {

		User user = userService.findBySSO(getPrincipal());
		model.addAttribute("loggedinuser", user);

		List<Faction> factionsList = factionService.findAllFactionsByGS(Integer.parseInt(gs_id));
		model.addAttribute("factions", factionsList);

		return "makeOrderStage3";
	}

	@RequestMapping(value = { "/stage4-{faction_id}" }, method = RequestMethod.GET)
	public String showMiniatures(@PathVariable String faction_id, ModelMap model) {

		User user = userService.findBySSO(getPrincipal());
		model.addAttribute("loggedinuser", user);

		List<Miniature> miniatureList = miniatureService.findAllMiniaturesByFaction(Integer.parseInt(faction_id));
		model.addAttribute("miniatures", miniatureList);

		return "makeOrderStage4";
	}

	@RequestMapping(value = { "/stage5-{miniature_id}" }, method = RequestMethod.GET)
	public String showMiniatureOption(@PathVariable String miniature_id, ModelMap model) {

		User user = userService.findBySSO(getPrincipal());
		model.addAttribute("loggedinuser", user);

		Order currentOrder = orderService.findCurrentOrder(user.getId());

		Miniature chosenMiniature = miniatureService.findMiniatureById(Integer.parseInt(miniature_id));
		model.addAttribute("miniature", chosenMiniature);

		OrderDetails orderDetails = new OrderDetails();
		orderDetails.setOrderId(currentOrder.getOrder_id());
		model.addAttribute("orderDetails", orderDetails);
		model.addAttribute("edit", false);
		return "makeOrderStage5";
	}

	@RequestMapping(value = { "/stage5-{miniature_id}" }, produces = "text/plain;charset=UTF-8", method = RequestMethod.POST)
	public String showMiniatureOption(@Valid OrderDetails orderDetails, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "makeOrder";
		}

		int miniatureId = orderDetails.getMiniatureId();
		Miniature miniature = miniatureService.findMiniatureById(miniatureId);
		orderDetailsService.saveOrderDetails(orderDetails);

		model.addAttribute("factionId", miniature.getFactionId());
		model.addAttribute("redirectPath", "/orders/stage4-" + miniature.getFactionId());
		model.addAttribute("success", orderDetails.getMinisQuantity() + " " + miniature.getMiniatureName() + "/s" + " added to your chart successfully");
		return "successWindow";
	}

	@RequestMapping(value = { "/chart" }, method = RequestMethod.GET)
	public String showChart(ModelMap model) {

		User user = userService.findBySSO(getPrincipal());
		model.addAttribute("loggedinuser", user);
		Order currentOrder = orderService.findCurrentOrder(user.getId());
		if (currentOrder != null) {
			List<OrderDetails> miniaturesDetailsToOrder = orderDetailsService.findAllOrderDetailsByOrder(currentOrder.getOrder_id());
			Map<OrderDetails, Miniature> orderedMiniatures = new HashMap<>();
			int totalSum = 0;
			for (Iterator iterator = miniaturesDetailsToOrder.iterator(); iterator.hasNext();) {
				OrderDetails detail = (OrderDetails) iterator.next();
				totalSum += detail.getMinisAvgPrice();
				orderedMiniatures.put(detail, (miniatureService.findMiniatureById(((OrderDetails) detail).getMiniatureId())));
			}
			model.addAttribute("orderedMiniatures", orderedMiniatures);
			model.addAttribute("totalSum", totalSum);
			model.addAttribute("orderNumber", currentOrder.getOrder_id());
		}
		return "chart";
	}

	@RequestMapping(value = { "/updateDetail-{order_detail_id}" }, method = RequestMethod.GET)
	public String updateMiniatureOption(@PathVariable String order_detail_id, ModelMap model) {

		User user = userService.findBySSO(getPrincipal());
		model.addAttribute("loggedinuser", user);

		Order currentOrder = orderService.findCurrentOrder(user.getId());

		OrderDetails orderDetails = orderDetailsService.findOrderDeatilsById(Integer.parseInt(order_detail_id));

		Miniature chosenMiniature = miniatureService.findMiniatureById(orderDetails.getMiniatureId());
		model.addAttribute("miniature", chosenMiniature);

		orderDetails.setOrderId(currentOrder.getOrder_id());
		model.addAttribute("orderDetails", orderDetails);
		model.addAttribute("edit", true);
		return "makeOrderStage5";
	}

	@RequestMapping(value = { "/updateDetail-{order_detail_id}" }, method = RequestMethod.POST)
	public String updateMiniatureOption(@Valid OrderDetails orderDetails, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "makeOrder";
		}

		int miniatureId = orderDetails.getMiniatureId();
		Miniature miniature = miniatureService.findMiniatureById(miniatureId);
		orderDetailsService.updateOrderDetails(orderDetails);
		System.out.println(orderDetails + "/////////////////////////////////////////////////////////");
		model.addAttribute("factionId", miniature.getFactionId());
		model.addAttribute("redirectPath", "/orders/chart");
		model.addAttribute("success", orderDetails.getMinisQuantity() + " " + miniature.getMiniatureName() + "/s" + "updated successfully");
		return "successWindow";
	}

	@RequestMapping(value = { "/deleteDetail-{order_detail_id}" }, method = RequestMethod.GET)
	public String deleteOrderDetail(@PathVariable String order_detail_id, ModelMap model) {

		orderDetailsService.deleteOrderDetailsById(Integer.parseInt(order_detail_id));
		model.addAttribute("success", "Deleted successfully");
		return "successWindow";
	}

	@RequestMapping(value = { "/completeOrder-{order_id}" }, method = RequestMethod.GET)
	public String completeOrder(@PathVariable String order_id, ModelMap model) {

		Order completeOrder = orderService.findOrderById(Integer.parseInt(order_id));
		completeOrder.setOrderStatus("CONFIRMED");

		orderService.updateOrder(completeOrder);
		model.addAttribute("redirectPath", "/chart");
		model.addAttribute("success", " Order confirmed! Your painter is preparing for work");
		return "successWindow";
	}

	@RequestMapping(value = { "/orderControl-{order_id}" }, method = RequestMethod.GET)
	public String showOrderControl(@PathVariable String order_id, ModelMap model) {

		User user = userService.findBySSO(getPrincipal());
		model.addAttribute("loggedinuser", user);
		Order currentOrder = orderService.findOrderById(Integer.parseInt(order_id));

		List<OrderDetails> miniaturesDetailsToOrder = orderDetailsService.findAllOrderDetailsByOrder(currentOrder.getOrder_id());
		Map<OrderDetails, Miniature> orderedMiniatures = new HashMap<>();
		int totalSum = 0;
		for (Iterator iterator = miniaturesDetailsToOrder.iterator(); iterator.hasNext();) {
			OrderDetails detail = (OrderDetails) iterator.next();
			totalSum += detail.getMinisAvgPrice();
			orderedMiniatures.put(detail, (miniatureService.findMiniatureById(((OrderDetails) detail).getMiniatureId())));

			model.addAttribute("orderedMiniatures", orderedMiniatures);
			model.addAttribute("totalSum", totalSum);
			model.addAttribute("orderNumber", currentOrder.getOrder_id());
		}
		return "orderControl";
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

}
