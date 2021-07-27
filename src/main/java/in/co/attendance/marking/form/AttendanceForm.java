package in.co.attendance.marking.form;

import javax.validation.constraints.NotEmpty;

import in.co.attendance.marking.dto.AttendanceDTO;
import in.co.attendance.marking.dto.BaseDTO;
import in.co.attendance.marking.dto.EnrollDTO;
import in.co.attendance.marking.dto.SessionDTO;
import in.co.attendance.marking.dto.UserDTO;
import in.co.attendance.marking.util.DataUtility;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttendanceForm extends BaseForm {
	
	private String status;
	private String sessionId;
	private String userId;
	private UserDTO user;
	private SessionDTO session;

	@Override
	public BaseDTO getDTO() {
		AttendanceDTO bean=new AttendanceDTO();
		bean.setId(id);
		bean.setStatus(status);
		bean.setSession(session);
		bean.setUser(user);
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
		AttendanceDTO bean=(AttendanceDTO)bDto;
		id=bean.getId();
		status=bean.getStatus();
		session=bean.getSession();
		user=bean.getUser();
		sessionId=String.valueOf(bean.getSessionId());
		userId=String.valueOf(bean.getUserId());
		createdBy=bean.getCreatedBy();
		modifiedBy=bean.getModifiedBy();
		createdDateTime=bean.getCreatedDatetime();
		modifiedDateTime=bean.getModifiedDatetime();
	}

}
