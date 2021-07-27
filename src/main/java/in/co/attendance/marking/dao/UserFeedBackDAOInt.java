package in.co.attendance.marking.dao;

import java.util.List;

import in.co.attendance.marking.dto.UserFeedbackDTO;
import in.co.attendance.marking.dto.UserDTO;



public interface UserFeedBackDAOInt {

	public long add(UserFeedbackDTO dto);
	
	public void delete(UserFeedbackDTO dto);
	
	public UserFeedbackDTO findBypk(long pk);
	
	public UserFeedbackDTO findByUserId(UserDTO udto);
	
	public void update(UserFeedbackDTO dto);
	
	public List<UserFeedbackDTO> list();
	
	public List<UserFeedbackDTO>list(int pageNo,int pageSize);
	
	public List<UserFeedbackDTO> search(UserFeedbackDTO dto);
	
	public List<UserFeedbackDTO> search(UserFeedbackDTO dto,int pageNo,int pageSize);
	
}
