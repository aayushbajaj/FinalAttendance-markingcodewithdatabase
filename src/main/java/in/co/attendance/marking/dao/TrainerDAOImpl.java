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

import in.co.attendance.marking.dto.TrainerDTO;
import in.co.attendance.marking.util.DataUtility;

@Repository
public class TrainerDAOImpl implements TrainerDAOInt {

	private static Logger log = Logger.getLogger(TrainerDAOImpl.class.getName());

	@Autowired
	private EntityManager entityManager;

	@Override
	public long add(TrainerDTO dto) {
		log.info("TrainerDAOImpl Add method Start");
		Session session = entityManager.unwrap(Session.class);
		dto.setTrainerId(maxTrainerId());
		long pk = (long) session.save(dto);
		log.info("TrainerDAOImpl Add method End");
		return pk;
	}

	@Override
	public void delete(TrainerDTO dto) {
		log.info("TrainerDAOImpl Delete method Start");
		entityManager.remove(entityManager.contains(dto) ? dto : entityManager.merge(dto));
		log.info("TrainerDAOImpl Delete method End");

	}

	@Override
	public TrainerDTO findBypk(long pk) {
		log.info("TrainerDAOImpl FindByPk method Start");
		Session session = entityManager.unwrap(Session.class);
		TrainerDTO dto = (TrainerDTO) session.get(TrainerDTO.class, pk);
		log.info("TrainerDAOImpl FindByPk method End");
		return dto;
	}

	@Override
	public TrainerDTO findByEmail(String email) {
		log.info("TrainerDAOImpl FindByLogin method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(TrainerDTO.class);
		criteria.add(Restrictions.eq("email", email));
		TrainerDTO dto = (TrainerDTO) criteria.uniqueResult();
		log.info("TrainerDAOImpl FindByLogin method End");
		return dto;
	}

	@Override
	public void update(TrainerDTO dto) {
		log.info("TrainerDAOImpl Update method Start");
		Session session = entityManager.unwrap(Session.class);
		session.merge(dto);
		log.info("TrainerDAOImpl update method End");
	}

	@Override
	public List<TrainerDTO> list() {
		return list(0, 0);
	}

	@Override
	public List<TrainerDTO> list(int pageNo, int pageSize) {
		log.info("TrainerDAOImpl List method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<TrainerDTO> query = session.createQuery("from TrainerDTO", TrainerDTO.class);
		List<TrainerDTO> list = query.getResultList();
		log.info("TrainerDAOImpl List method End");
		return list;
	}

	@Override
	public List<TrainerDTO> search(TrainerDTO dto) {
		return search(dto, 0, 0);
	}

	@Override
	public List<TrainerDTO> search(TrainerDTO dto, int pageNo, int pageSize) {
		log.info("TrainerDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		StringBuffer hql = new StringBuffer("from TrainerDTO as u where 1=1 ");
		if (dto != null) {
			if (dto.getId() > 0) {
				hql.append("and u.id = " + dto.getId());
			}
			
			if (dto.getName() != null && dto.getName().length() > 0) {
				hql.append("and u.name like '%" + dto.getName() + "%'");
			}
		}
		Query<TrainerDTO> query = session.createQuery(hql.toString(), TrainerDTO.class);
		if (pageNo > 0) {
			pageNo = (pageNo - 1) * pageSize;
			query.setFirstResult(pageNo);
			query.setMaxResults(pageSize);
		}
		List<TrainerDTO> list = query.getResultList();
		log.info("TrainerDAOImpl Search method End");
		return list;
	}

	

	@Override
	public long maxTrainerId() {
		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("select max(trainerId) from TrainerDTO");
		List list = query.list();
		long id = DataUtility.getLong(String.valueOf(list.get(0)));
		if (id == 0) {
			return 30001001;
		} else {
			return id + 1;
		}

	}

}
