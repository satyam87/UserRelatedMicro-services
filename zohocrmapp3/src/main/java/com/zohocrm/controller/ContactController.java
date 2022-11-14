package com.zohocrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zohocrm.entities.Contact;
import com.zohocrm.services.ContactService;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;
	//Here we can generate constructor using field that will also work
	@RequestMapping("/listAllContact")
	public String listAllContact(Model model){
		List<Contact> Contacts = contactService.getAllContacts();
		model.addAttribute("contacts", Contacts);
		return "list_contact";
	}
	
}
