package in.myproject.anand.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.myproject.anand.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Integer> {
	
	

}
