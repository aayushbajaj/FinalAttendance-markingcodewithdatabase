package in.co.attendance.marking.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.attendance.marking.dto.UserFeedbackDTO;
import in.co.attendance.marking.dto.UserDTO;

@Repository
public class UserFeedBackDAOImpl implements UserFeedBackDAOInt {

	private static Logger log = Logger.getLogger(UserFeedBackDAOImpl.class.getName());

	@Autowired
	private EntityManager entityManager;

	@Override
	public long add(UserFeedbackDTO dto) {
		log.info("UserFeedbackDAOImpl Add method Start");
		Session session = entityManager.unwrap(Session.class);
		long pk = (long) session.save(dto);
		log.info("UserFeedbackDAOImpl Add method End");
		return pk;
	}

	@Override
	public void delete(UserFeedbackDTO dto) {
		log.info("UserFeedbackDAOImpl Delete method Start");
		entityManager.remove(entityManager.contains(dto) ? dto : entityManager.merge(dto));
		log.info("UserFeedbackDAOImpl Delete method End");

	}

	@Override
	public UserFeedbackDTO findBypk(long pk) {
		log.info("UserFeedbackDAOImpl FindByPk method Start");
		Session session = entityManager.unwrap(Session.class);
		UserFeedbackDTO dto = (UserFeedbackDTO) session.get(UserFeedbackDTO.class, pk);
		log.info("UserFeedbackDAOImpl FindByPk method End");
		return dto;
	}
	
	@Override
	public UserFeedbackDTO findByUserId(UserDTO uDto) {
		log.info("UserFeedbackDAOImpl findByUserId method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(UserFeedbackDTO.class);
		criteria.add(Restrictions.eq("user", uDto));
		UserFeedbackDTO dto = (UserFeedbackDTO) criteria.uniqueResult();
		log.info("UserFeedbackDAOImpl findByUserId method End");
		return dto;
	}

	@Override
	public void update(UserFeedbackDTO dto) {
		log.info("UserFeedbackDAOImpl Update method Start");
		Session session = entityManager.unwrap(Session.class);
		session.merge(dto);
		log.info("UserFeedbackDAOImpl update method End");
	}

	@Override
	public List<UserFeedbackDTO> list() {
		return list(0, 0);
	}

	@Override
	public List<UserFeedbackDTO> list(int pageNo, int pageSize) {
		log.info("UserFeedbackDAOImpl List method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<UserFeedbackDTO> query = session.createQuery("from UserFeedbackDTO", UserFeedbackDTO.class);
		List<UserFeedbackDTO> list = query.getResultList();
		log.info("UserFeedbackDAOImpl List method End");
		return list;
	}

	@Override
	public List<UserFeedbackDTO> search(UserFeedbackDTO dto) {
		return search(dto, 0, 0);
	}

	@Override
	public List<UserFeedbackDTO> search(UserFeedbackDTO dto, int pageNo, int pageSize) {
		log.info("UserFeedbackDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		StringBuffer hql = new StringBuffer("from UserFeedbackDTO as u where 1=1 ");
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
		Query<UserFeedbackDTO> query = session.createQuery(hql.toString(), UserFeedbackDTO.class);
		if (pageNo > 0) {
			pageNo = (pageNo - 1) * pageSize;
			query.setFirstResult(pageNo);
			query.setMaxResults(pageSize);
		}
		List<UserFeedbackDTO> list = query.getResultList();
		log.info("UserFeedbackDAOImpl Search method End");
		return list;
	}

	

}
