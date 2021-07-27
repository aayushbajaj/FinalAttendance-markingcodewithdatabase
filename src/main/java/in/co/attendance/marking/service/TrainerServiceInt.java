package in.co.attendance.marking.service;

import java.util.List;

import in.co.attendance.marking.dto.TrainerDTO;
import in.co.attendance.marking.exception.DuplicateRecordException;




public interface TrainerServiceInt {

	public long add(TrainerDTO dto) throws DuplicateRecordException;

	public void delete(TrainerDTO dto);

	public TrainerDTO findBypk(long pk);

	public TrainerDTO findByEmail(String email);

	public void update(TrainerDTO dto) throws DuplicateRecordException;

	public List<TrainerDTO> list();

	public List<TrainerDTO> list(int pageNo, int pageSize);

	public List<TrainerDTO> search(TrainerDTO dto);

	public List<TrainerDTO> search(TrainerDTO dto, int pageNo, int pageSize);


}
