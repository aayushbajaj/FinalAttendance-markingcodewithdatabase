package in.co.attendance.marking.form;

import javax.validation.constraints.NotEmpty;

import in.co.attendance.marking.dto.AdminDTO;
import in.co.attendance.marking.dto.BaseDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminForm extends BaseForm {

	@NotEmpty(message = "First Name is required")
	private String firstName;

	@NotEmpty(message = "LastName is required")
	private String lastName;

	@NotEmpty(message = "Email is required")
	private String email;

	@NotEmpty(message = "Password is required")
	private String password;


	@NotEmpty(message = "Age is required")
	private String age;

	@NotEmpty(message = "Gender is required")
	private String gender;

	@NotEmpty(message = "Contact is required")
	private String contactNo;
	
	private long adminId;
	
	@NotEmpty(message ="Status is required")
	private String status;

	@Override
	public BaseDTO getDTO() {
		AdminDTO bean = new AdminDTO();
		bean.setId(id);
		bean.setAdminId(adminId);
		bean.setFirstName(firstName);
		bean.setLastName(lastName);
		bean.setEmailId(email);
		bean.setAge(age);
		bean.setGender(gender);
		bean.setStatus(status);
		bean.setContactNo(contactNo);
		bean.setPassword(password);
		bean.setCreatedBy(createdBy);
		bean.setModifiedBy(modifiedBy);
		bean.setCreatedDatetime(createdDateTime);
		bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}

	@Override
	public void populate(BaseDTO baseBean) {
		AdminDTO bean = (AdminDTO) baseBean;
		id = bean.getId();
		status=bean.getStatus();
		adminId=bean.getAdminId();
		firstName = bean.getFirstName();
		lastName = bean.getLastName();
		email = bean.getEmailId();
		password = bean.getPassword();
		contactNo = bean.getContactNo();
		age = bean.getAge();
		gender = bean.getGender();
		createdBy = bean.getCreatedBy();
		modifiedBy = bean.getModifiedBy();
		createdDateTime = bean.getCreatedDatetime();
		modifiedDateTime = bean.getModifiedDatetime();
	}

}
