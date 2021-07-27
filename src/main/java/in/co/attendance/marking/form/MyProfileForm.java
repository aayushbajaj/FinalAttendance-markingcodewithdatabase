package in.co.attendance.marking.form;
import javax.validation.constraints.NotEmpty;

import in.co.attendance.marking.dto.BaseDTO;
import in.co.attendance.marking.dto.UserDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyProfileForm extends BaseForm {

	@NotEmpty(message = "First Name is required")
	private String firstName;
	
	@NotEmpty(message = "LastName is required")
	private String lastName;
	
	@NotEmpty(message = "Email is required")
	private String email;
	
	@NotEmpty(message = "MobileNo is required")
	private String mobileNo;
	
	
	public BaseDTO getDTO() {
		UserDTO entity = new UserDTO();
		entity.setFirstName(firstName);
		entity.setLastName(lastName);
		return entity;
	}

	
	public void populate(BaseDTO bDto) {
		UserDTO entity = (UserDTO) bDto;
		firstName = entity.getFirstName();
		lastName = entity.getLastName();

	}

	

}
