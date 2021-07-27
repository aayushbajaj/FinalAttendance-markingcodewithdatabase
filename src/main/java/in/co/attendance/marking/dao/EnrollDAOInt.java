package in.co.attendance.marking.dao;

import java.util.List;

import in.co.attendance.marking.dto.EnrollDTO;
import in.co.attendance.marking.dto.UserDTO;



public interface EnrollDAOInt {

	public long add(EnrollDTO dto);
	
	public void delete(EnrollDTO dto);
	
	public EnrollDTO findBypk(long pk);
	
	public EnrollDTO findByUserId(UserDTO udto);
	
	public void update(EnrollDTO dto);
	
	public List<EnrollDTO> list();
	
	public List<EnrollDTO>list(int pageNo,int pageSize);
	
	public List<EnrollDTO> search(EnrollDTO dto);
	
	public List<EnrollDTO> search(EnrollDTO dto,int pageNo,int pageSize);
	
}
