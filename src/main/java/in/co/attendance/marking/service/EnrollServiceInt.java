package in.co.attendance.marking.service;

import java.util.List;

import in.co.attendance.marking.dto.EnrollDTO;
import in.co.attendance.marking.dto.UserDTO;
import in.co.attendance.marking.exception.DuplicateRecordException;


public interface EnrollServiceInt {

	public long add(EnrollDTO dto) throws DuplicateRecordException;

	public void delete(EnrollDTO dto);

	public EnrollDTO findBypk(long pk);
	
	public EnrollDTO findByUserId(UserDTO id);

	public void update(EnrollDTO dto) throws DuplicateRecordException;

	public List<EnrollDTO> list();

	public List<EnrollDTO> list(int pageNo, int pageSize);

	public List<EnrollDTO> search(EnrollDTO dto);

	public List<EnrollDTO> search(EnrollDTO dto, int pageNo, int pageSize);
	  

}
