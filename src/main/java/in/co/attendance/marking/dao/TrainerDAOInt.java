package in.co.attendance.marking.dao;

import java.util.List;

import in.co.attendance.marking.dto.TrainerDTO;



public interface TrainerDAOInt {

	public long add(TrainerDTO dto);
	
	public void delete(TrainerDTO dto);
	
	public TrainerDTO findBypk(long pk);
	
	public TrainerDTO findByEmail(String email);
	
	public void update(TrainerDTO dto);
	
	public List<TrainerDTO> list();
	
	public List<TrainerDTO>list(int pageNo,int pageSize);
	
	public List<TrainerDTO> search(TrainerDTO dto);
	
	public List<TrainerDTO> search(TrainerDTO dto,int pageNo,int pageSize);
	
	public long maxTrainerId();
}
