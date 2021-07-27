package in.co.attendance.marking.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="USER_FEEDBACK")
@Getter
@Setter
public class UserFeedbackDTO extends BaseDTO{

	@Column(name="SUBJECT",length = 225)
	private String subject;
	
	@Column(name="MESSAGE",length = 225)
	private String message;
	
	@ManyToOne
	@JoinColumn(name="SESSION",nullable = false)
	private SessionDTO session;
	
	@ManyToOne
	@JoinColumn(name="USER",nullable = false)
	private UserDTO user;
	
	private long sessionId;
	private long userId;
	
	@Override
	public String getKey() {
		return null;
	}

	@Override
	public String getValue() {
		return null;
	}

}
