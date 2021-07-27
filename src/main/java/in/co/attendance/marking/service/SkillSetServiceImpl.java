package in.co.attendance.marking.service;

import java.util.List;
import java.util.logging.Logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.co.attendance.marking.dao.SkillSetDAOInt;
import in.co.attendance.marking.dto.SkillSetDTO;
import in.co.attendance.marking.exception.DuplicateRecordException;






@Service
public class SkillSetServiceImpl implements SkillSetServiceInt {

	private static Logger log=Logger.getLogger(SkillSetServiceImpl.class.getName());
	
	@Autowired
	private SkillSetDAOInt dao;
	
	
	
	@Override
	@Transactional
	public long add(SkillSetDTO dto) throws DuplicateRecordException {
		log.info("SkillSetServiceImpl Add method start");
		SkillSetDTO existDTO=dao.findByType(dto.getType());
		if(existDTO !=null)
			throw new DuplicateRecordException("Type Already Exist");
		long pk=dao.add(dto);
		log.info("SkillSetServiceImpl Add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(SkillSetDTO dto) {
		log.info("SkillSetServiceImpl Delete method start");
		dao.delete(dto);
		log.info("SkillSetServiceImpl Delete method end");
		
	}

	@Override
	@Transactional
	public SkillSetDTO findBypk(long pk) {
		log.info("SkillSetServiceImpl findBypk method start");
		SkillSetDTO dto=dao.findBypk(pk);
		log.info("SkillSetServiceImpl findBypk method end");
		return dto;
	}

	@Override
	@Transactional
	public SkillSetDTO findByType(String type) {
		log.info("SkillSetServiceImpl findBySkillSetName method start");
		SkillSetDTO dto=dao.findByType(type);
		log.info("SkillSetServiceImpl findBySkillSetName method end");
		return dto;
	}

	@Override
	@Transactional
	public void update(SkillSetDTO dto) throws DuplicateRecordException {
		log.info("SkillSetServiceImpl update method start");
		SkillSetDTO existDTO=dao.findByType(dto.getType());
		if(existDTO !=null && dto.getId()!=existDTO.getId())
			throw new DuplicateRecordException("Type is Already Exist");
		dao.update(dto);
		log.info("SkillSetServiceImpl update method end");
	}

	@Override
	@Transactional
	public List<SkillSetDTO> list() {
		log.info("SkillSetServiceImpl list method start");
		List<SkillSetDTO> list=dao.list();
		log.info("SkillSetServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<SkillSetDTO> list(int pageNo, int pageSize) {
		log.info("SkillSetServiceImpl list method start");
		List<SkillSetDTO> list=dao.list(pageNo, pageSize);
		log.info("SkillSetServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<SkillSetDTO> search(SkillSetDTO dto) {
		log.info("SkillSetServiceImpl search method start");
		List<SkillSetDTO> list=dao.search(dto);
		log.info("SkillSetServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<SkillSetDTO> search(SkillSetDTO dto, int pageNo, int pageSize) {
		log.info("SkillSetServiceImpl search method start");
		List<SkillSetDTO> list=dao.search(dto, pageNo, pageSize);
		log.info("SkillSetServiceImpl search method end");
		return list;
	}

	
}
