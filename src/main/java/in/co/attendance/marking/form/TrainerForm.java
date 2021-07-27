package in.co.attendance.marking.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import in.co.attendance.marking.dto.BaseDTO;
import in.co.attendance.marking.dto.TrainerDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrainerForm extends BaseForm {


	
	private long trainerId;
	@NotEmpty(message = "Name is required")
	private String name;
	@NotEmpty(message = "Contact No is required")
	private String contactNo;
	@NotEmpty(message = "Email is required")
	private String email;
	
	@Min(value = 1, message  = "Session is required")
	private long sessionId;
	@Min(value=1, message = "Skill set is required")
	private long skillId;
	
	@Override
	public BaseDTO getDTO() {
		TrainerDTO bean=new TrainerDTO();
		bean.setId(id);
		bean.setName(name);
		bean.setContactNo(contactNo);
		bean.setEmail(email);
		bean.setSessionId(sessionId);
		bean.setSkillId(skillId);
		bean.setCreatedBy(createdBy);
		bean.setModifiedBy(modifiedBy);
		bean.setCreatedDatetime(createdDateTime);
		bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}

	@Override
	public void populate(BaseDTO bDto) {
		TrainerDTO bean=(TrainerDTO)bDto;
		id=bean.getId();
		name=bean.getName();
		contactNo=bean.getContactNo();
		email=bean.getEmail();
		sessionId=bean.getSessionId();
		skillId=bean.getSkillId();
		createdBy=bean.getCreatedBy();
		modifiedBy=bean.getModifiedBy();
		createdDateTime=bean.getCreatedDatetime();
		modifiedDateTime=bean.getModifiedDatetime();
	}

}
