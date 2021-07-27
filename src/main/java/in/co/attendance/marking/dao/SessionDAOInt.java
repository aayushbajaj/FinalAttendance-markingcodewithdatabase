package in.co.attendance.marking.dao;

import java.util.List;

import in.co.attendance.marking.dto.SessionDTO;



public interface SessionDAOInt {

	public long add(SessionDTO dto);
	
	public void delete(SessionDTO dto);
	
	public SessionDTO findBypk(long pk);
	
	public void update(SessionDTO dto);
	
	public List<SessionDTO> list();
	
	public List<SessionDTO>list(int pageNo,int pageSize);
	
	public List<SessionDTO> search(SessionDTO dto);
	
	public List<SessionDTO> search(SessionDTO dto,int pageNo,int pageSize);
	
	public long maxSessionId();
}
