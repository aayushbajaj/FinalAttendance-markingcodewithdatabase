package in.co.attendance.marking.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.co.attendance.marking.dao.UserFeedBackDAOInt;
import in.co.attendance.marking.dto.UserDTO;
import in.co.attendance.marking.dto.UserFeedbackDTO;
import in.co.attendance.marking.exception.DuplicateRecordException;






@Service
public class UserFeedBackServiceImpl implements UserFeedBackServiceInt {

	private static Logger log=Logger.getLogger(UserFeedBackServiceImpl.class.getName());
	
	@Autowired
	private UserFeedBackDAOInt dao;
	
	
	
	@Override
	@Transactional
	public long add(UserFeedbackDTO dto) throws DuplicateRecordException {
		log.info("UserFeedbackServiceImpl Add method start");
		long pk=dao.add(dto);
		log.info("UserFeedbackServiceImpl Add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(UserFeedbackDTO dto) {
		log.info("UserFeedbackServiceImpl Delete method start");
		dao.delete(dto);
		log.info("UserFeedbackServiceImpl Delete method end");
		
	}

	@Override
	@Transactional
	public UserFeedbackDTO findBypk(long pk) {
		log.info("UserFeedbackServiceImpl findBypk method start");
		UserFeedbackDTO dto=dao.findBypk(pk);
		log.info("UserFeedbackServiceImpl findBypk method end");
		return dto;
	}
	
	@Override
	@Transactional
	public UserFeedbackDTO findByUserId(UserDTO uDto) {
		log.info("UserFeedbackServiceImpl findByUserId method start");
		UserFeedbackDTO dto=dao.findByUserId(uDto);
		log.info("UserFeedbackServiceImpl findByUserId method end");
		return dto;
	}

	
	@Override
	@Transactional
	public void update(UserFeedbackDTO dto) throws DuplicateRecordException {
		log.info("UserFeedbackServiceImpl update method start");
		dao.update(dto);
		log.info("UserFeedbackServiceImpl update method end");
	}

	@Override
	@Transactional
	public List<UserFeedbackDTO> list() {
		log.info("UserFeedbackServiceImpl list method start");
		List<UserFeedbackDTO> list=dao.list();
		log.info("UserFeedbackServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<UserFeedbackDTO> list(int pageNo, int pageSize) {
		log.info("UserFeedbackServiceImpl list method start");
		List<UserFeedbackDTO> list=dao.list(pageNo, pageSize);
		log.info("UserFeedbackServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<UserFeedbackDTO> search(UserFeedbackDTO dto) {
		log.info("UserFeedbackServiceImpl search method start");
		List<UserFeedbackDTO> list=dao.search(dto);
		log.info("UserFeedbackServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<UserFeedbackDTO> search(UserFeedbackDTO dto, int pageNo, int pageSize) {
		log.info("UserFeedbackServiceImpl search method start");
		List<UserFeedbackDTO> list=dao.search(dto, pageNo, pageSize);
		log.info("UserFeedbackServiceImpl search method end");
		return list;
	}

	

	
}
