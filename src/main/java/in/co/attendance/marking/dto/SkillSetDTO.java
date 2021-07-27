package in.co.attendance.marking.dto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="SKILL_SET")
@Getter
@Setter
public class SkillSetDTO extends BaseDTO {

	@Column(name = "SKILL_ID")
	private long skillId;
	@Column(name = "TYPE",length = 225)
	private String type;
	@Column(name = "DESCRIPTION",length = 225)
	private String description;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "skill")
	private Set<SessionDTO> sessions;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "skill")
	private Set<TrainerDTO> trainers;
	
	
	
	@Override
	public String getKey() {
		return String.valueOf(id);
	}
	@Override
	public String getValue() {
		return String.valueOf(skillId);
	}

}
