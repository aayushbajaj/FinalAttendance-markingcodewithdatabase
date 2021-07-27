package in.co.attendance.marking.form;

import javax.validation.constraints.NotEmpty;

import in.co.attendance.marking.dto.BaseDTO;
import in.co.attendance.marking.dto.SkillSetDTO;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SkillSetForm extends BaseForm {
	
	private long skillId;
	@NotEmpty(message ="Type is required")
	private String type;
	@NotEmpty(message ="Description is required")
	private String description;
	
	@Override
	public BaseDTO getDTO() {
		SkillSetDTO dto=new SkillSetDTO();
		dto.setId(id);
		dto.setSkillId(skillId);
		dto.setType(type);
		dto.setDescription(description);
		dto.setCreatedBy(createdBy);
		dto.setModifiedBy(modifiedBy);
		dto.setCreatedDatetime(createdDateTime);
		dto.setModifiedDatetime(modifiedDateTime);
		return dto;
	}

	@Override
	public void populate(BaseDTO bDto) {
		SkillSetDTO bean=(SkillSetDTO)bDto;
		id=bean.getId();
		skillId=bean.getSkillId();
		type=bean.getType();
		description=bean.getDescription();
		createdBy=bean.getCreatedBy();
		modifiedBy=bean.getModifiedBy();
		createdDateTime=bean.getCreatedDatetime();
		modifiedDateTime=bean.getModifiedDatetime();
	}

}
