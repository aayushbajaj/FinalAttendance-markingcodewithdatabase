package in.co.attendance.marking.service;

import java.util.List;

import in.co.attendance.marking.dto.SessionDTO;
import in.co.attendance.marking.exception.DuplicateRecordException;


public interface SessionServiceInt {

	public long add(SessionDTO dto) throws DuplicateRecordException;

	public void delete(SessionDTO dto);

	public SessionDTO findBypk(long pk);

	public void update(SessionDTO dto) throws DuplicateRecordException;

	public List<SessionDTO> list();

	public List<SessionDTO> list(int pageNo, int pageSize);

	public List<SessionDTO> search(SessionDTO dto);

	public List<SessionDTO> search(SessionDTO dto, int pageNo, int pageSize);
	  

}
