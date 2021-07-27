package in.co.attendance.marking.service;

import java.util.List;

import in.co.attendance.marking.dto.UserFeedbackDTO;
import in.co.attendance.marking.dto.UserDTO;
import in.co.attendance.marking.exception.DuplicateRecordException;


public interface UserFeedBackServiceInt {

	public long add(UserFeedbackDTO dto) throws DuplicateRecordException;

	public void delete(UserFeedbackDTO dto);

	public UserFeedbackDTO findBypk(long pk);
	
	public UserFeedbackDTO findByUserId(UserDTO id);

	public void update(UserFeedbackDTO dto) throws DuplicateRecordException;

	public List<UserFeedbackDTO> list();

	public List<UserFeedbackDTO> list(int pageNo, int pageSize);

	public List<UserFeedbackDTO> search(UserFeedbackDTO dto);

	public List<UserFeedbackDTO> search(UserFeedbackDTO dto, int pageNo, int pageSize);
	  

}
