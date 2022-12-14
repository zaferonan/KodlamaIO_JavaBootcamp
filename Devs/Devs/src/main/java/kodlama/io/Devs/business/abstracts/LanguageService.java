package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.business.requests.CreateLanguageRequest;
import kodlama.io.Devs.business.requests.UpdateLanguageRequest;
import kodlama.io.Devs.business.responses.GetLanguageResponse;


public interface LanguageService {

	public List<GetLanguageResponse> getAll();
	public void add(CreateLanguageRequest createLanguageRequest) throws Exception;
	public void delete(int languageId) throws Exception;
	public void update(UpdateLanguageRequest updateLanguageRequest) throws Exception;
	public GetLanguageResponse getById(int languageId) throws Exception;
}
