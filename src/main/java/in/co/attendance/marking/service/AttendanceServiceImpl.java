package in.co.attendance.marking.service;

import java.util.List;
import java.util.logging.Logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.co.attendance.marking.dao.AttendanceDAOInt;
import in.co.attendance.marking.dto.AttendanceDTO;
import in.co.attendance.marking.dto.UserDTO;
import in.co.attendance.marking.exception.DuplicateRecordException;






@Service
public class AttendanceServiceImpl implements AttendanceServiceInt {

	private static Logger log=Logger.getLogger(AttendanceServiceImpl.class.getName());
	
	@Autowired
	private AttendanceDAOInt dao;
	
	
	
	@Override
	@Transactional
	public long add(AttendanceDTO dto) throws DuplicateRecordException {
		log.info("AttendanceServiceImpl Add method start");
		long pk=dao.add(dto);
		log.info("AttendanceServiceImpl Add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(AttendanceDTO dto) {
		log.info("AttendanceServiceImpl Delete method start");
		dao.delete(dto);
		log.info("AttendanceServiceImpl Delete method end");
		
	}

	@Override
	@Transactional
	public AttendanceDTO findBypk(long pk) {
		log.info("AttendanceServiceImpl findBypk method start");
		AttendanceDTO dto=dao.findBypk(pk);
		log.info("AttendanceServiceImpl findBypk method end");
		return dto;
	}
	
	@Override
	@Transactional
	public AttendanceDTO findByUserId(UserDTO uDto) {
		log.info("AttendanceServiceImpl findByUserId method start");
		AttendanceDTO dto=dao.findByUserId(uDto);
		log.info("AttendanceServiceImpl findByUserId method end");
		return dto;
	}

	
	@Override
	@Transactional
	public void update(AttendanceDTO dto) throws DuplicateRecordException {
		log.info("AttendanceServiceImpl update method start");
		dao.update(dto);
		log.info("AttendanceServiceImpl update method end");
	}

	@Override
	@Transactional
	public List<AttendanceDTO> list() {
		log.info("AttendanceServiceImpl list method start");
		List<AttendanceDTO> list=dao.list();
		log.info("AttendanceServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<AttendanceDTO> list(int pageNo, int pageSize) {
		log.info("AttendanceServiceImpl list method start");
		List<AttendanceDTO> list=dao.list(pageNo, pageSize);
		log.info("AttendanceServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<AttendanceDTO> search(AttendanceDTO dto) {
		log.info("AttendanceServiceImpl search method start");
		List<AttendanceDTO> list=dao.search(dto);
		log.info("AttendanceServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<AttendanceDTO> search(AttendanceDTO dto, int pageNo, int pageSize) {
		log.info("AttendanceServiceImpl search method start");
		List<AttendanceDTO> list=dao.search(dto, pageNo, pageSize);
		log.info("AttendanceServiceImpl search method end");
		return list;
	}

	

	
}
