package in.co.attendance.marking.service;

import java.util.List;

import in.co.attendance.marking.dto.AdminDTO;
import in.co.attendance.marking.exception.DuplicateRecordException;




public interface AdminServiceInt {

	public long add(AdminDTO dto) throws DuplicateRecordException;

	public void delete(AdminDTO dto);

	public AdminDTO findBypk(long pk);

	public AdminDTO findByEmail(String email);

	public void update(AdminDTO dto) throws DuplicateRecordException;

	public List<AdminDTO> list();

	public List<AdminDTO> list(int pageNo, int pageSize);

	public List<AdminDTO> search(AdminDTO dto);

	public List<AdminDTO> search(AdminDTO dto, int pageNo, int pageSize);

	public AdminDTO authentication(AdminDTO dto);
	
	  public boolean changePassword(Long id, String oldPassword, String newPassword);
	  
	  public boolean forgetPassword(String login);
	  
	  public long register(AdminDTO dto) throws DuplicateRecordException;

}
