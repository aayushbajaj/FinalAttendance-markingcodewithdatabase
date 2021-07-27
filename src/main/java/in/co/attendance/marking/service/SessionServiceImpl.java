package in.co.attendance.marking.service;

import java.util.List;
import java.util.logging.Logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.co.attendance.marking.dao.SessionDAOInt;
import in.co.attendance.marking.dao.SkillSetDAOInt;
import in.co.attendance.marking.dto.SessionDTO;
import in.co.attendance.marking.exception.DuplicateRecordException;






@Service
public class SessionServiceImpl implements SessionServiceInt {

	private static Logger log=Logger.getLogger(SessionServiceImpl.class.getName());
	
	@Autowired
	private SessionDAOInt dao;
	
	@Autowired
	private SkillSetDAOInt skillDao;
	
	@Override
	@Transactional
	public long add(SessionDTO dto) throws DuplicateRecordException {
		log.info("SessionServiceImpl Add method start");
		dto.setSkill(skillDao.findBypk(dto.getSkillId()));
		long pk=dao.add(dto);
		log.info("SessionServiceImpl Add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(SessionDTO dto) {
		log.info("SessionServiceImpl Delete method start");
		dao.delete(dto);
		log.info("SessionServiceImpl Delete method end");
		
	}

	@Override
	@Transactional
	public SessionDTO findBypk(long pk) {
		log.info("SessionServiceImpl findBypk method start");
		SessionDTO dto=dao.findBypk(pk);
		log.info("SessionServiceImpl findBypk method end");
		return dto;
	}

	
	@Override
	@Transactional
	public void update(SessionDTO dto) throws DuplicateRecordException {
		log.info("SessionServiceImpl update method start");
		dto.setSkill(skillDao.findBypk(dto.getSkillId()));
		dao.update(dto);
		log.info("SessionServiceImpl update method end");
	}

	@Override
	@Transactional
	public List<SessionDTO> list() {
		log.info("SessionServiceImpl list method start");
		List<SessionDTO> list=dao.list();
		log.info("SessionServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<SessionDTO> list(int pageNo, int pageSize) {
		log.info("SessionServiceImpl list method start");
		List<SessionDTO> list=dao.list(pageNo, pageSize);
		log.info("SessionServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<SessionDTO> search(SessionDTO dto) {
		log.info("SessionServiceImpl search method start");
		List<SessionDTO> list=dao.search(dto);
		log.info("SessionServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<SessionDTO> search(SessionDTO dto, int pageNo, int pageSize) {
		log.info("SessionServiceImpl search method start");
		List<SessionDTO> list=dao.search(dto, pageNo, pageSize);
		log.info("SessionServiceImpl search method end");
		return list;
	}

	
}
