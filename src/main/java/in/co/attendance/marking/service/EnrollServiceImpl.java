package in.co.attendance.marking.service;

import java.util.List;
import java.util.logging.Logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.co.attendance.marking.dao.EnrollDAOInt;
import in.co.attendance.marking.dto.EnrollDTO;
import in.co.attendance.marking.dto.UserDTO;
import in.co.attendance.marking.exception.DuplicateRecordException;






@Service
public class EnrollServiceImpl implements EnrollServiceInt {

	private static Logger log=Logger.getLogger(EnrollServiceImpl.class.getName());
	
	@Autowired
	private EnrollDAOInt dao;
	
	
	
	@Override
	@Transactional
	public long add(EnrollDTO dto) throws DuplicateRecordException {
		log.info("EnrollServiceImpl Add method start");
		long pk=dao.add(dto);
		log.info("EnrollServiceImpl Add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(EnrollDTO dto) {
		log.info("EnrollServiceImpl Delete method start");
		dao.delete(dto);
		log.info("EnrollServiceImpl Delete method end");
		
	}

	@Override
	@Transactional
	public EnrollDTO findBypk(long pk) {
		log.info("EnrollServiceImpl findBypk method start");
		EnrollDTO dto=dao.findBypk(pk);
		log.info("EnrollServiceImpl findBypk method end");
		return dto;
	}
	
	@Override
	@Transactional
	public EnrollDTO findByUserId(UserDTO uDto) {
		log.info("EnrollServiceImpl findByUserId method start");
		EnrollDTO dto=dao.findByUserId(uDto);
		log.info("EnrollServiceImpl findByUserId method end");
		return dto;
	}

	
	@Override
	@Transactional
	public void update(EnrollDTO dto) throws DuplicateRecordException {
		log.info("EnrollServiceImpl update method start");
		dao.update(dto);
		log.info("EnrollServiceImpl update method end");
	}

	@Override
	@Transactional
	public List<EnrollDTO> list() {
		log.info("EnrollServiceImpl list method start");
		List<EnrollDTO> list=dao.list();
		log.info("EnrollServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<EnrollDTO> list(int pageNo, int pageSize) {
		log.info("EnrollServiceImpl list method start");
		List<EnrollDTO> list=dao.list(pageNo, pageSize);
		log.info("EnrollServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<EnrollDTO> search(EnrollDTO dto) {
		log.info("EnrollServiceImpl search method start");
		List<EnrollDTO> list=dao.search(dto);
		log.info("EnrollServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<EnrollDTO> search(EnrollDTO dto, int pageNo, int pageSize) {
		log.info("EnrollServiceImpl search method start");
		List<EnrollDTO> list=dao.search(dto, pageNo, pageSize);
		log.info("EnrollServiceImpl search method end");
		return list;
	}

	

	
}
