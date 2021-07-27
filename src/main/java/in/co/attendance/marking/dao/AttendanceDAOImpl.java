package in.co.attendance.marking.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.attendance.marking.dto.AttendanceDTO;
import in.co.attendance.marking.dto.UserDTO;

@Repository
public class AttendanceDAOImpl implements AttendanceDAOInt {

	private static Logger log = Logger.getLogger(AttendanceDAOImpl.class.getName());

	@Autowired
	private EntityManager entityManager;

	@Override
	public long add(AttendanceDTO dto) {
		log.info("AttendanceDAOImpl Add method Start");
		Session session = entityManager.unwrap(Session.class);
		long pk = (long) session.save(dto);
		log.info("AttendanceDAOImpl Add method End");
		return pk;
	}

	@Override
	public void delete(AttendanceDTO dto) {
		log.info("AttendanceDAOImpl Delete method Start");
		entityManager.remove(entityManager.contains(dto) ? dto : entityManager.merge(dto));
		log.info("AttendanceDAOImpl Delete method End");

	}

	@Override
	public AttendanceDTO findBypk(long pk) {
		log.info("AttendanceDAOImpl FindByPk method Start");
		Session session = entityManager.unwrap(Session.class);
		AttendanceDTO dto = (AttendanceDTO) session.get(AttendanceDTO.class, pk);
		log.info("AttendanceDAOImpl FindByPk method End");
		return dto;
	}
	
	@Override
	public AttendanceDTO findByUserId(UserDTO uDto) {
		log.info("AttendanceDAOImpl findByUserId method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(AttendanceDTO.class);
		criteria.add(Restrictions.eq("user", uDto));
		AttendanceDTO dto = (AttendanceDTO) criteria.uniqueResult();
		log.info("AttendanceDAOImpl findByUserId method End");
		return dto;
	}

	@Override
	public void update(AttendanceDTO dto) {
		log.info("AttendanceDAOImpl Update method Start");
		Session session = entityManager.unwrap(Session.class);
		session.merge(dto);
		log.info("AttendanceDAOImpl update method End");
	}

	@Override
	public List<AttendanceDTO> list() {
		return list(0, 0);
	}

	@Override
	public List<AttendanceDTO> list(int pageNo, int pageSize) {
		log.info("AttendanceDAOImpl List method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<AttendanceDTO> query = session.createQuery("from AttendanceDTO", AttendanceDTO.class);
		List<AttendanceDTO> list = query.getResultList();
		log.info("AttendanceDAOImpl List method End");
		return list;
	}

	@Override
	public List<AttendanceDTO> search(AttendanceDTO dto) {
		return search(dto, 0, 0);
	}

	@Override
	public List<AttendanceDTO> search(AttendanceDTO dto, int pageNo, int pageSize) {
		log.info("AttendanceDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		StringBuffer hql = new StringBuffer("from AttendanceDTO as u where 1=1 ");
		if (dto != null) {
			if (dto.getId() > 0) {
				hql.append("and u.id = " + dto.getId());
			}
			if (dto.getSessionId() > 0) {
				hql.append("and u.sessionId = " + dto.getSessionId());
			}
			/*
			 * if (dto.getType() != null && dto.getType().length() > 0) {
			 * hql.append("and u.type like '%" + dto.getType() + "%'"); }
			 */		
			}
		Query<AttendanceDTO> query = session.createQuery(hql.toString(), AttendanceDTO.class);
		if (pageNo > 0) {
			pageNo = (pageNo - 1) * pageSize;
			query.setFirstResult(pageNo);
			query.setMaxResults(pageSize);
		}
		List<AttendanceDTO> list = query.getResultList();
		log.info("AttendanceDAOImpl Search method End");
		return list;
	}

	

}
