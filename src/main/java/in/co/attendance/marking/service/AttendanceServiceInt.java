package in.co.attendance.marking.service;

import java.util.List;

import in.co.attendance.marking.dto.AttendanceDTO;
import in.co.attendance.marking.dto.UserDTO;
import in.co.attendance.marking.exception.DuplicateRecordException;


public interface AttendanceServiceInt {

	public long add(AttendanceDTO dto) throws DuplicateRecordException;

	public void delete(AttendanceDTO dto);

	public AttendanceDTO findBypk(long pk);
	
	public AttendanceDTO findByUserId(UserDTO id);

	public void update(AttendanceDTO dto) throws DuplicateRecordException;

	public List<AttendanceDTO> list();

	public List<AttendanceDTO> list(int pageNo, int pageSize);

	public List<AttendanceDTO> search(AttendanceDTO dto);

	public List<AttendanceDTO> search(AttendanceDTO dto, int pageNo, int pageSize);
	  

}
