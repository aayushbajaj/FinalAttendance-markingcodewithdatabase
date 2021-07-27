package in.co.attendance.marking.form;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import in.co.attendance.marking.dto.BaseDTO;
import in.co.attendance.marking.dto.SessionDTO;
import in.co.attendance.marking.dto.SkillSetDTO;
import in.co.attendance.marking.util.DataUtility;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SessionForm extends BaseForm {

	private long sessionId;
	@NotEmpty(message = "Description is required")
	private String description;
	@NotEmpty(message = "Date is required")
	private String date;
	@NotEmpty(message = "Time is required")
	private String time;
	@NotEmpty(message = "Slot is required")
	private String slot;
	@Min(value = 1, message = "Skill Set is required")
	private long skillId;
	
	private SkillSetDTO skills;
	
	@NotEmpty(message = "Session Type is required")
	private String sessionType;

	@Override
	public BaseDTO getDTO() {
		SessionDTO bean = new SessionDTO();
		bean.setId(id);
		bean.setSessionId(sessionId);
		bean.setDescription(description);
		bean.setDate(DataUtility.getDate(date));
		bean.setTime(time);
		bean.setSlot(slot);
		bean.setSkillId(skillId);
		bean.setSkill(skills);
		bean.setSessionType(sessionType);
		bean.setCreatedBy(createdBy);
		bean.setModifiedBy(modifiedBy);
		bean.setCreatedDatetime(createdDateTime);
		bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}

	@Override
	public void populate(BaseDTO bDto) {
		SessionDTO bean=(SessionDTO)bDto;
		id=bean.getId();
		description=bean.getDescription();
		date=DataUtility.getDateString(bean.getDate());
		time=bean.getTime();
		slot=bean.getSlot();
		sessionType=bean.getSessionType();
		skillId=bean.getSkillId();
		sessionId=bean.getSessionId();
		createdBy=bean.getCreatedBy();
		modifiedBy=bean.getModifiedBy();
		createdDateTime=bean.getCreatedDatetime();
		modifiedDateTime=bean.getModifiedDatetime();
		skills=bean.getSkill();
	}

}
