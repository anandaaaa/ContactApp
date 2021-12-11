package in.myproject.anand.bindings;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ContactForm {
	
	private Integer contactId;
	private String contactName;
	private Long contactNo;
	private String contactEmail;
	private String activeSW;
	@Override
	public String toString() {
		return "ContactForm [contactId=" + contactId + ", contactName=" + contactName + ", contactNo=" + contactNo
				+ ", contactEmail=" + contactEmail + ", activeSW=" + activeSW + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + "]";
	}
	private LocalDate createdDate;
	private LocalDate updatedDate;
}
