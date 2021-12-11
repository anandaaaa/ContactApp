package in.myproject.anand.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.myproject.anand.bindings.ContactForm;
import in.myproject.anand.service.IContactService;

@RestController
public class ContactRest {
	
	@Autowired
	private IContactService service;
	
	@PostMapping("/save")
	public String savecontacts(@RequestBody ContactForm contactform) {
		System.out.println(contactform);
		 String saveContact = service.saveContact(contactform);
		 return saveContact;
	}
	
	@GetMapping("/contacts")
	public List<ContactForm> viewContacts() {
		return service.viewAllContacts();
	}
	
	@GetMapping("/edit/{contactId}")
	public ContactForm EditContacts(@PathVariable Integer contactId ) {
		return service.EditContact(contactId);
	}
	
	
	@DeleteMapping("/delete/{contactId}")
	public List<ContactForm> deleteContacts(@PathVariable Integer contactId ) {
		return service.deleteContact(contactId);
	}
	
	
	
	

}
