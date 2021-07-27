package in.co.attendance.marking.service;

import java.util.List;

import in.co.attendance.marking.dto.SkillSetDTO;
import in.co.attendance.marking.exception.DuplicateRecordException;


public interface SkillSetServiceInt {

	public long add(SkillSetDTO dto) throws DuplicateRecordException;

	public void delete(SkillSetDTO dto);

	public SkillSetDTO findBypk(long pk);

	public SkillSetDTO findByType(String type);

	public void update(SkillSetDTO dto) throws DuplicateRecordException;

	public List<SkillSetDTO> list();

	public List<SkillSetDTO> list(int pageNo, int pageSize);

	public List<SkillSetDTO> search(SkillSetDTO dto);

	public List<SkillSetDTO> search(SkillSetDTO dto, int pageNo, int pageSize);
	  

}
