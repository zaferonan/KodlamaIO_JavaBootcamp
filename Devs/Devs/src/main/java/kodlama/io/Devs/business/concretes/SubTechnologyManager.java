package kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.SubTechnologyService;
import kodlama.io.Devs.business.requests.CreateSubTechnologyRequest;
import kodlama.io.Devs.business.requests.UpdateSubTechnologyRequest;
import kodlama.io.Devs.business.responses.GetLanguageResponse;
import kodlama.io.Devs.business.responses.GetSubTechnologyResponse;
import kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Devs.dataAccess.abstracts.SubTechnologyRepository;
import kodlama.io.Devs.entities.concretes.SubTechnology;

@Service
public class SubTechnologyManager implements SubTechnologyService {

	private SubTechnologyRepository subTechnologyRepository;
	private LanguageRepository languageRepository;

	@Autowired
	public SubTechnologyManager(SubTechnologyRepository subTechnologyRepository,
			LanguageRepository languageRepository) {

		this.subTechnologyRepository = subTechnologyRepository;
		this.languageRepository = languageRepository;
	}

	@Override
	public List<GetSubTechnologyResponse> getAll() {

		List<GetSubTechnologyResponse> responses = new ArrayList<GetSubTechnologyResponse>();
		for (SubTechnology subTechnology : subTechnologyRepository.findAll()) {
			GetSubTechnologyResponse response = new GetSubTechnologyResponse();
			response.setSubTechnologyId(subTechnology.getSubTechnologyId());
			response.setSubTechnologyName(subTechnology.getSubTechnologyName());
			response.setGetLanguageResponse(new GetLanguageResponse(subTechnology.getLanguage().getLanguageId(),
					subTechnology.getLanguage().getLanguageName()));
			responses.add(response);
		}
		return responses;
	}

	@Override
	public void add(CreateSubTechnologyRequest createSubTechnologyRequest) throws RuntimeException {
	
		SubTechnology subTechnology = new SubTechnology();
		subTechnology.setSubTechnologyName(createSubTechnologyRequest.getSubTechnologyName());
		subTechnology.setLanguage(languageRepository.findByLanguageId(createSubTechnologyRequest.getLanguage_id()));
		
		isExistByName(subTechnology.getSubTechnologyName());
		isExistedLanguage(createSubTechnologyRequest.getLanguage_id());

		subTechnologyRepository.save(subTechnology);

	}

	@Override
	public void delete(int subTechnologyId) throws RuntimeException {
		isExistById(subTechnologyId);
		subTechnologyRepository.deleteById(subTechnologyId);

	}

	@Override
	public void update(UpdateSubTechnologyRequest updateSubTechnologyRequest) {
		SubTechnology subTechnology = new SubTechnology();
		subTechnology.setSubTechnologyId(updateSubTechnologyRequest.getSubTechnologyId());
		subTechnology.setSubTechnologyName(updateSubTechnologyRequest.getSubTechnologyName());
		subTechnology.setLanguage(languageRepository.findByLanguageId(updateSubTechnologyRequest.getLanguage_id()));

		isExistById(subTechnology.getSubTechnologyId());
		isNameEmpty(subTechnology.getSubTechnologyName());
		isExistedLanguage(subTechnology.getLanguage().getLanguageId());

		subTechnologyRepository.save(subTechnology);

	}

	@Override
	public GetSubTechnologyResponse getById(int id)throws RuntimeException {
		
		isExistById(id);
		
		SubTechnology subTechnology=subTechnologyRepository.findBySubTechnologyId(id);
		
		GetSubTechnologyResponse getSubTechnologyResponse=new GetSubTechnologyResponse();
		getSubTechnologyResponse.setSubTechnologyId(id);
		getSubTechnologyResponse.setSubTechnologyName(subTechnology.getSubTechnologyName());
		getSubTechnologyResponse.setGetLanguageResponse(new GetLanguageResponse(subTechnology.getLanguage().getLanguageId(),subTechnology.getLanguage().getLanguageName()));
		
		return getSubTechnologyResponse;
	}

	private void isExistedLanguage(@NotNull int language_id) throws RuntimeException {
		if (languageRepository.findByLanguageId(language_id) == null) {

			throw new RuntimeException("Language is not exist.");
		}

	}

	private void isExistByName(String subTechnologyName) throws RuntimeException {
	
		if (subTechnologyRepository.findAll().stream().filter(a -> a.getSubTechnologyName().equals(subTechnologyName)).findAny().orElse(null) != null) {
			
			throw new RuntimeException(subTechnologyName + " is already exist");
		}

	}

	private void isExistById(int subTechnologyId) throws RuntimeException {
		if (subTechnologyRepository.findBySubTechnologyId(subTechnologyId) == null) {
			throw new RuntimeException("There is no " + subTechnologyId + " in database.");
		}

	}

	private void isNameEmpty(String subTechnologyName)throws RuntimeException {
		if (subTechnologyName.equals("")) {
			throw new RuntimeException("Subtechnology name can not be empty.");
		}

	}

}
