package in.co.attendance.marking.dao;

import java.util.List;

import in.co.attendance.marking.dto.AdminDTO;



public interface AdminDAOInt {

	public long add(AdminDTO dto);
	
	public void delete(AdminDTO dto);
	
	public AdminDTO findBypk(long pk);
	
	public AdminDTO findByEmail(String email);
	
	public void update(AdminDTO dto);
	
	public List<AdminDTO> list();
	
	public List<AdminDTO>list(int pageNo,int pageSize);
	
	public List<AdminDTO> search(AdminDTO dto);
	
	public List<AdminDTO> search(AdminDTO dto,int pageNo,int pageSize);
	
	public AdminDTO authentication(AdminDTO dto);
	
	public long maxAdminId();
}
