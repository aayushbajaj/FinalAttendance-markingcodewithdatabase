package in.co.attendance.marking.form;

import javax.validation.constraints.NotEmpty;

import in.co.attendance.marking.dto.BaseDTO;
import in.co.attendance.marking.dto.EnrollDTO;
import in.co.attendance.marking.dto.SessionDTO;
import in.co.attendance.marking.dto.UserDTO;
import in.co.attendance.marking.dto.UserFeedbackDTO;
import in.co.attendance.marking.util.DataUtility;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserFeedBackForm extends BaseForm {
	
	@NotEmpty(message = "Subject is required")
	private String subject;
	@NotEmpty(message = "Message is required")
	private String message;
	private String sessionId;
	private String userId;

	@Override
	public BaseDTO getDTO() {
		UserFeedbackDTO bean=new UserFeedbackDTO();
		bean.setId(id);
		bean.setSubject(subject);
		bean.setMessage(message);
		bean.setSessionId(DataUtility.getLong(sessionId));
		bean.setUserId(DataUtility.getLong(userId));
		bean.setCreatedBy(createdBy);
		bean.setModifiedBy(modifiedBy);
		bean.setCreatedDatetime(createdDateTime);
		bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}

	@Override
	public void populate(BaseDTO bDto) {
		UserFeedbackDTO bean=(UserFeedbackDTO)bDto;
		id=bean.getId();
		subject=bean.getSubject();
		message=bean.getMessage();
		sessionId=String.valueOf(bean.getSessionId());
		userId=String.valueOf(bean.getUserId());
		createdBy=bean.getCreatedBy();
		modifiedBy=bean.getModifiedBy();
		createdDateTime=bean.getCreatedDatetime();
		modifiedDateTime=bean.getModifiedDatetime();
	}

}
