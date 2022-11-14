package com.zohocrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrm.entities.Billing;
import com.zohocrm.entities.Contact;
import com.zohocrm.entities.Lead;
import com.zohocrm.services.BillingService;
import com.zohocrm.services.ContactService;

@Controller
public class BillingController {
	
	@Autowired
	private ContactService contactService;
	@Autowired
	private BillingService billingService;
	

	@RequestMapping("/generateBill")
	public String viewBillingPage(@RequestParam("id") long id, Model model) {
		
		Contact contact=contactService.getContactById(id);
		model.addAttribute("contact", contact);
		
		return "generate_bill";
	}
	
	@RequestMapping("/saveBill")
	public String saveLead(@ModelAttribute("bill")Billing bill,Model model) {
		billingService.saveBillPage(bill);
		model.addAttribute("bill", bill);
		List<Contact> Contacts = contactService.getAllContacts();
		model.addAttribute("contacts", Contacts);
		return "list_contact";
	}
}
