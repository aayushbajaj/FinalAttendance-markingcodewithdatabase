package in.co.attendance.marking.service;

import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.co.attendance.marking.dao.SessionDAOInt;
import in.co.attendance.marking.dao.SkillSetDAOInt;
import in.co.attendance.marking.dao.TrainerDAOInt;
import in.co.attendance.marking.dto.TrainerDTO;
import in.co.attendance.marking.exception.DuplicateRecordException;

@Service
public class TrainerServiceImpl implements TrainerServiceInt {

	private static Logger log = Logger.getLogger(TrainerServiceImpl.class.getName());

	@Autowired
	private TrainerDAOInt dao;

	@Autowired
	private SessionDAOInt sessionDao;

	@Autowired
	private SkillSetDAOInt skillDao;

	@Override
	@Transactional
	public long add(TrainerDTO dto) throws DuplicateRecordException {
		log.info("TrainerServiceImpl Add method start");
		TrainerDTO existDTO = dao.findByEmail(dto.getEmail());
		if (existDTO != null)
			throw new DuplicateRecordException("Email Id Already Exist");
		dto.setSkill(skillDao.findBypk(dto.getSkillId()));
		dto.setSession(sessionDao.findBypk(dto.getSessionId()));
		long pk = dao.add(dto);
		log.info("TrainerServiceImpl Add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(TrainerDTO dto) {
		log.info("TrainerServiceImpl Delete method start");
		dao.delete(dto);
		log.info("TrainerServiceImpl Delete method end");

	}

	@Override
	@Transactional
	public TrainerDTO findBypk(long pk) {
		log.info("TrainerServiceImpl findBypk method start");
		TrainerDTO dto = dao.findBypk(pk);
		log.info("TrainerServiceImpl findBypk method end");
		return dto;
	}

	@Override
	@Transactional
	public TrainerDTO findByEmail(String email) {
		log.info("TrainerServiceImpl findByTrainerName method start");
		TrainerDTO dto = dao.findByEmail(email);
		log.info("TrainerServiceImpl findByTrainerName method end");
		return dto;
	}

	@Override
	@Transactional
	public void update(TrainerDTO dto) throws DuplicateRecordException {
		log.info("TrainerServiceImpl update method start");
		TrainerDTO existDTO = dao.findByEmail(dto.getEmail());
		if (existDTO != null && dto.getId() != existDTO.getId())
			throw new DuplicateRecordException("Email Id Already Exist");

		dto.setSkill(skillDao.findBypk(dto.getSkillId()));
		dto.setSession(sessionDao.findBypk(dto.getSessionId()));
		dao.update(dto);
		log.info("TrainerServiceImpl update method end");
	}

	@Override
	@Transactional
	public List<TrainerDTO> list() {
		log.info("TrainerServiceImpl list method start");
		List<TrainerDTO> list = dao.list();
		log.info("TrainerServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<TrainerDTO> list(int pageNo, int pageSize) {
		log.info("TrainerServiceImpl list method start");
		List<TrainerDTO> list = dao.list(pageNo, pageSize);
		log.info("TrainerServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<TrainerDTO> search(TrainerDTO dto) {
		log.info("TrainerServiceImpl search method start");
		List<TrainerDTO> list = dao.search(dto);
		log.info("TrainerServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<TrainerDTO> search(TrainerDTO dto, int pageNo, int pageSize) {
		log.info("TrainerServiceImpl search method start");
		List<TrainerDTO> list = dao.search(dto, pageNo, pageSize);
		log.info("TrainerServiceImpl search method end");
		return list;
	}

}
