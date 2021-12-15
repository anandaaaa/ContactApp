package in.myproject.anand.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.myproject.anand.bindings.ContactForm;
import in.myproject.anand.entity.Contact;
import in.myproject.anand.repository.ContactRepository;

@Service
public class ContactServiceImpl implements IContactService {

	@Autowired
	public ContactRepository repo;
	
	@Override
	public String saveContact(ContactForm form) {
		Contact entity=new Contact();
		BeanUtils.copyProperties(form, entity);
		entity.setActiveSW("y");
		Contact save = repo.save(entity);
		if(save.getContactId()!=null)
		{
			return "SUCCESS";

		}
		return "FAILED";
		
	}

	@Override
	public List<ContactForm> viewAllContacts() {
	
		List<ContactForm> form =new ArrayList<>();
		List<Contact> findAll = repo.findAll();
		
		for(Contact contact:findAll)
		{
			ContactForm contactform= new ContactForm();
			BeanUtils.copyProperties(contact, contactform);
			form.add(contactform);
		}
		return form;
	}

	@Override
	public ContactForm editContact(Integer contactId) {
		Optional<Contact> findById = repo.findById(contactId);
		if(findById.isPresent())
		{
			Contact contact = findById.get();
			ContactForm form=new ContactForm();
			BeanUtils.copyProperties(contact, form);
			return form;
		}
		
		return null;
	}

	@Override
	public List<ContactForm> deleteContact(Integer contactId) {
		repo.deleteById(contactId);
		return viewAllContacts();
	}

}
