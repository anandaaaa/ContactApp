package in.myproject.anand.service;

import java.util.List;

import in.myproject.anand.bindings.ContactForm;

public interface IContactService {
	
	public String saveContact(ContactForm form);
	public List<ContactForm> viewAllContacts();
	public ContactForm editContact(Integer contactId);
	public List<ContactForm> deleteContact(Integer contactId);
	

}
