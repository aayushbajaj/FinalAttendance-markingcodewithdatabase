
package in.co.attendance.marking.dto;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "SESSION")
@Getter
@Setter
public class SessionDTO extends BaseDTO {

	@Column(name = "SESSION_ID")
	private long sessionId;
	
	@Column(name = "DESCRIPTION",length = 225)
	private String description;
	
	@Column(name = "DATE")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Column(name = "TIME",length = 225)
	private String time;
	@Column(name = "SLOT",length = 225)
	private String slot;
	
	@Column(name = "SESSION_TYPE",length = 225)
	private String sessionType;
	
	@ManyToOne
	@JoinColumn(name="SKILL",nullable = false)
	private SkillSetDTO skill;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "session")
	private Set<TrainerDTO> trainers;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "session")
	private Set<EnrollDTO> enrolls;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "session")
	private Set<AttendanceDTO> attendancs;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "session")
	private Set<UserFeedbackDTO> userFeedBacks;
	
	private long skillId;

	@Override
	public String getKey() {
		return String.valueOf(id);
	}
	@Override
	public String getValue() {
		return String.valueOf(sessionId);
	}

}
