package in.co.attendance.marking.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.attendance.marking.dto.SessionDTO;
import in.co.attendance.marking.util.DataUtility;

@Repository
public class SessionDAOImpl implements SessionDAOInt {

	private static Logger log = Logger.getLogger(SessionDAOImpl.class.getName());

	@Autowired
	private EntityManager entityManager;

	@Override
	public long add(SessionDTO dto) {
		log.info("SessionDAOImpl Add method Start");
		Session session = entityManager.unwrap(Session.class);
		dto.setSessionId(maxSessionId());
		long pk = (long) session.save(dto);
		log.info("SessionDAOImpl Add method End");
		return pk;
	}

	@Override
	public void delete(SessionDTO dto) {
		log.info("SessionDAOImpl Delete method Start");
		entityManager.remove(entityManager.contains(dto) ? dto : entityManager.merge(dto));
		log.info("SessionDAOImpl Delete method End");

	}

	@Override
	public SessionDTO findBypk(long pk) {
		log.info("SessionDAOImpl FindByPk method Start");
		Session session = entityManager.unwrap(Session.class);
		SessionDTO dto = (SessionDTO) session.get(SessionDTO.class, pk);
		log.info("SessionDAOImpl FindByPk method End");
		return dto;
	}

	@Override
	public void update(SessionDTO dto) {
		log.info("SessionDAOImpl Update method Start");
		Session session = entityManager.unwrap(Session.class);
		session.merge(dto);
		log.info("SessionDAOImpl update method End");
	}

	@Override
	public List<SessionDTO> list() {
		return list(0, 0);
	}

	@Override
	public List<SessionDTO> list(int pageNo, int pageSize) {
		log.info("SessionDAOImpl List method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<SessionDTO> query = session.createQuery("from SessionDTO", SessionDTO.class);
		List<SessionDTO> list = query.getResultList();
		log.info("SessionDAOImpl List method End");
		return list;
	}

	@Override
	public List<SessionDTO> search(SessionDTO dto) {
		return search(dto, 0, 0);
	}

	@Override
	public List<SessionDTO> search(SessionDTO dto, int pageNo, int pageSize) {
		log.info("SessionDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		StringBuffer hql = new StringBuffer("from SessionDTO as u where 1=1 ");
		if (dto != null) {
			if (dto.getId() > 0) {
				hql.append("and u.id = " + dto.getId());
			}
			if (dto.getSkillId() > 0) {
				hql.append("and u.skillId = " + dto.getSkillId());
			}
			if (dto.getSessionId() > 0) {
				hql.append("and u.sessionId = " + dto.getSessionId());
			}
			if (dto.getSessionType() != null && dto.getSessionType().length() > 0) {
				hql.append("and u.sessionType like '%" + dto.getSessionType() + "%'");
			}

		}
		Query<SessionDTO> query = session.createQuery(hql.toString(), SessionDTO.class);
		if (pageNo > 0) {
			pageNo = (pageNo - 1) * pageSize;
			query.setFirstResult(pageNo);
			query.setMaxResults(pageSize);
		}
		List<SessionDTO> list = query.getResultList();
		log.info("SessionDAOImpl Search method End");
		return list;
	}

	@Override
	public long maxSessionId() {
		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("select max(sessionId) from SessionDTO");
		List list = query.list();
		long id = DataUtility.getLong(String.valueOf(list.get(0)));
		if (id == 0) {
			return 401010;
		} else {
			return id + 1;
		}

	}

}
