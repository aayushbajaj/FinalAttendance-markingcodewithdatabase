package in.co.attendance.marking.form;


import javax.validation.constraints.NotEmpty;

import in.co.attendance.marking.dto.AdminDTO;
import in.co.attendance.marking.dto.BaseDTO;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AdminForgetPasswordForm extends BaseForm {

	@NotEmpty(message = "Email is required")
	private String email;
	
	

	@Override
	public BaseDTO getDTO() {
		AdminDTO dto = new AdminDTO();
		dto.setEmailId(email);
		return dto;
	}

	@Override
	public void populate(BaseDTO bDto) {
		
	}

}
