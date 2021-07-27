package in.co.attendance.marking.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="TRAINER")
@Getter
@Setter
public class TrainerDTO extends BaseDTO {
	
	@Column(name="TRAINER_ID")
	private long trainerId;
	@Column(name="NAME",length = 225)
	private String name;
	@Column(name="CONTACT_NO",length = 225)
	private String contactNo;
	@Column(name="EMAIL",length = 225)
	private String email;
	
	@ManyToOne
	@JoinColumn(name="SESSION",nullable = false)
	private SessionDTO session;
	
	@ManyToOne
	@JoinColumn(name="SKILL",nullable = false)
	private SkillSetDTO skill;
	
	
	private long sessionId;
	
	private long skillId;

	@Override
	public String getKey() {
		return String.valueOf(id);
	}

	@Override
	public String getValue() {
		return name;
	}

}
