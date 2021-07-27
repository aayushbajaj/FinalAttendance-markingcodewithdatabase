package in.co.attendance.marking.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name="ENROLL")
public class EnrollDTO extends BaseDTO {
	
	@ManyToOne
	@JoinColumn(name="SESSION",nullable = false)
	private SessionDTO session;
	@ManyToOne
	@JoinColumn(name="USER",nullable = false)
	private UserDTO user;
	@Column(name="Status",length = 225)
	private String status;
	
	private long sessionId;
	private long userId;
	
	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}

}
