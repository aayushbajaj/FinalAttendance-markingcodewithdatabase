package in.co.attendance.marking.form;

import javax.validation.constraints.NotEmpty;

import org.springframework.util.unit.DataUnit;

import in.co.attendance.marking.dto.BaseDTO;
import in.co.attendance.marking.dto.UserDTO;
import in.co.attendance.marking.util.DataUtility;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginForm extends BaseForm {

	@NotEmpty(message = "Email Id is required")
	private String emailId;
	@NotEmpty(message = "Password is required")
	private String password;
	

	@Override
	public BaseDTO getDTO() {
		UserDTO bean=new UserDTO();
		bean.setEmailId(DataUtility.getStringData(emailId));
		bean.setPassword(password);
		return bean;
	}

	@Override
	public void populate(BaseDTO bdto) {
		UserDTO entity=(UserDTO) bdto;
		emailId=String.valueOf(entity.getEmailId());
		password=entity.getPassword();
	}

}
