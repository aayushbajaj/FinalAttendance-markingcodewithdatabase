package in.co.attendance.marking.form;

import javax.validation.constraints.NotEmpty;

import org.springframework.util.unit.DataUnit;

import in.co.attendance.marking.dto.AdminDTO;
import in.co.attendance.marking.dto.BaseDTO;
import in.co.attendance.marking.dto.UserDTO;
import in.co.attendance.marking.util.DataUtility;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminLoginForm extends BaseForm {

	@NotEmpty(message = "Email Id is required")
	private String emailId;
	@NotEmpty(message = "Password is required")
	private String password;
	

	@Override
	public BaseDTO getDTO() {
		AdminDTO bean=new AdminDTO();
		bean.setEmailId(DataUtility.getStringData(emailId));
		bean.setPassword(password);
		return bean;
	}

	@Override
	public void populate(BaseDTO bdto) {
		AdminDTO entity=(AdminDTO) bdto;
		emailId=String.valueOf(entity.getEmailId());
		password=entity.getPassword();
	}

}
