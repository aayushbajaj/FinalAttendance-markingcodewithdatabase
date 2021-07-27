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

import in.co.attendance.marking.dto.SkillSetDTO;
import in.co.attendance.marking.util.DataUtility;

@Repository
public class SkillSetDAOImpl implements SkillSetDAOInt {

	private static Logger log = Logger.getLogger(SkillSetDAOImpl.class.getName());

	@Autowired
	private EntityManager entityManager;

	@Override
	public long add(SkillSetDTO dto) {
		log.info("SkillSetDAOImpl Add method Start");
		Session session = entityManager.unwrap(Session.class);
		dto.setSkillId(maxSkillSetId());
		long pk = (long) session.save(dto);
		log.info("SkillSetDAOImpl Add method End");
		return pk;
	}

	@Override
	public void delete(SkillSetDTO dto) {
		log.info("SkillSetDAOImpl Delete method Start");
		entityManager.remove(entityManager.contains(dto) ? dto : entityManager.merge(dto));
		log.info("SkillSetDAOImpl Delete method End");

	}

	@Override
	public SkillSetDTO findBypk(long pk) {
		log.info("SkillSetDAOImpl FindByPk method Start");
		Session session = entityManager.unwrap(Session.class);
		SkillSetDTO dto = (SkillSetDTO) session.get(SkillSetDTO.class, pk);
		log.info("SkillSetDAOImpl FindByPk method End");
		return dto;
	}

	@Override
	public SkillSetDTO findByType(String type) {
		log.info("SkillSetDAOImpl FindByLogin method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(SkillSetDTO.class);
		criteria.add(Restrictions.eq("type", type));
		SkillSetDTO dto = (SkillSetDTO) criteria.uniqueResult();
		log.info("SkillSetDAOImpl FindByLogin method End");
		return dto;
	}

	@Override
	public void update(SkillSetDTO dto) {
		log.info("SkillSetDAOImpl Update method Start");
		Session session = entityManager.unwrap(Session.class);
		session.merge(dto);
		log.info("SkillSetDAOImpl update method End");
	}

	@Override
	public List<SkillSetDTO> list() {
		return list(0, 0);
	}

	@Override
	public List<SkillSetDTO> list(int pageNo, int pageSize) {
		log.info("SkillSetDAOImpl List method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<SkillSetDTO> query = session.createQuery("from SkillSetDTO", SkillSetDTO.class);
		List<SkillSetDTO> list = query.getResultList();
		log.info("SkillSetDAOImpl List method End");
		return list;
	}

	@Override
	public List<SkillSetDTO> search(SkillSetDTO dto) {
		return search(dto, 0, 0);
	}

	@Override
	public List<SkillSetDTO> search(SkillSetDTO dto, int pageNo, int pageSize) {
		log.info("SkillSetDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		StringBuffer hql = new StringBuffer("from SkillSetDTO as u where 1=1 ");
		if (dto != null) {
			if (dto.getId() > 0) {
				hql.append("and u.id = " + dto.getId());
			}
			if (dto.getType() != null && dto.getType().length() > 0) {
				hql.append("and u.type like '%" + dto.getType() + "%'");
			}
		}
		Query<SkillSetDTO> query = session.createQuery(hql.toString(), SkillSetDTO.class);
		if (pageNo > 0) {
			pageNo = (pageNo - 1) * pageSize;
			query.setFirstResult(pageNo);
			query.setMaxResults(pageSize);
		}
		List<SkillSetDTO> list = query.getResultList();
		log.info("SkillSetDAOImpl Search method End");
		return list;
	}

	

	@Override
	public long maxSkillSetId() {
		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("select max(skillId) from SkillSetDTO");
		List list = query.list();
		long id = DataUtility.getLong(String.valueOf(list.get(0)));
		if (id == 0) {
			return 301010;
		} else {
			return id + 1;
		}

	}

}
