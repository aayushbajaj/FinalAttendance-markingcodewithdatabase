package in.co.attendance.marking.dao;

import java.util.List;

import in.co.attendance.marking.dto.AttendanceDTO;
import in.co.attendance.marking.dto.UserDTO;



public interface AttendanceDAOInt {

	public long add(AttendanceDTO dto);
	
	public void delete(AttendanceDTO dto);
	
	public AttendanceDTO findBypk(long pk);
	
	public AttendanceDTO findByUserId(UserDTO udto);
	
	public void update(AttendanceDTO dto);
	
	public List<AttendanceDTO> list();
	
	public List<AttendanceDTO>list(int pageNo,int pageSize);
	
	public List<AttendanceDTO> search(AttendanceDTO dto);
	
	public List<AttendanceDTO> search(AttendanceDTO dto,int pageNo,int pageSize);
	
}
