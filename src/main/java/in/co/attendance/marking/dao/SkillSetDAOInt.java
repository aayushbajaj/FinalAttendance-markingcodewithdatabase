package in.co.attendance.marking.dao;

import java.util.List;

import in.co.attendance.marking.dto.SkillSetDTO;



public interface SkillSetDAOInt {

	public long add(SkillSetDTO dto);
	
	public void delete(SkillSetDTO dto);
	
	public SkillSetDTO findBypk(long pk);
	
	public SkillSetDTO findByType(String type);
	
	public void update(SkillSetDTO dto);
	
	public List<SkillSetDTO> list();
	
	public List<SkillSetDTO>list(int pageNo,int pageSize);
	
	public List<SkillSetDTO> search(SkillSetDTO dto);
	
	public List<SkillSetDTO> search(SkillSetDTO dto,int pageNo,int pageSize);
	
	public long maxSkillSetId();
}
