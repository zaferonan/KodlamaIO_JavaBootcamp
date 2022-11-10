package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.business.requests.CreateSubTechnologyRequest;
import kodlama.io.Devs.business.requests.UpdateSubTechnologyRequest;
import kodlama.io.Devs.business.responses.GetSubTechnologyResponse;


public interface SubTechnologyService {

	public List<GetSubTechnologyResponse> getAll();
	public void add(CreateSubTechnologyRequest createSubTechnologyRequest)throws RuntimeException;
	public void delete(int subTechnologyId)throws RuntimeException;
	public void update(UpdateSubTechnologyRequest updateSubTechnologyRequest)throws RuntimeException;
	public GetSubTechnologyResponse getById(int id)throws RuntimeException;
	
	
}
