package kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Devs.business.requests.CreateLanguageRequest;
import kodlama.io.Devs.business.requests.UpdateLanguageRequest;
import kodlama.io.Devs.business.responses.GetLanguageResponse;
import kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Devs.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {

	LanguageRepository languageRepository;

	@Autowired
	public LanguageManager(LanguageRepository languageRepository) {

		this.languageRepository = languageRepository;
	}

	@Override
	public List<GetLanguageResponse> getAll() {

		List<GetLanguageResponse> responses = new ArrayList();
		for (Language language : languageRepository.findAll()) {
			GetLanguageResponse response = new GetLanguageResponse();
			response.setLanguageId(language.getLanguageId());
			response.setLanguageName(language.getLanguageName());
			responses.add(response);
		}
		return responses;
	}

	@Override
	public void add(CreateLanguageRequest createLanguageRequest) throws Exception {

		Language language = new Language();
		language.setLanguageName(createLanguageRequest.getLanguageName());

		isExistByName(language.getLanguageName());
		isNameEmpty(language.getLanguageName());

		languageRepository.save(language);

	}

	private void isNameEmpty(String languageName) throws Exception {
		if (languageName.equals("")) {
			throw new RuntimeException("Language name can not be empty.");
		}

	}

	@Override
	public void delete(int languageId) throws Exception {
		isExistById(languageId);
		languageRepository.deleteById(languageId);
	}

	@Override
	public void update(UpdateLanguageRequest updateLanguageRequest) {
		Language language = languageRepository.findByLanguageId(updateLanguageRequest.getLanguageId());
		if (language != null) {
			if (!updateLanguageRequest.getLanguageName().equals("")) {

				language.setLanguageName(updateLanguageRequest.getLanguageName());
				languageRepository.save(language);
			} else
				throw new RuntimeException("Language name can not be null.");

		} else {
			throw new RuntimeException("Language name can not be null.");
		}

	}

	@Override
	public GetLanguageResponse getById(int languageId) throws Exception {
		isExistById(languageId);
		
		Language language = languageRepository.findByLanguageId(languageId);

		return new GetLanguageResponse(languageId, language.getLanguageName());

	}

	private boolean isExist(Language language) {
		if (languageRepository.findAll().stream().filter(a -> a.equals(language)).findAny().orElse(null) != null) {
			return true;
		}

		return false;

	}

	private void isExistByName(String languageName) throws Exception {
		if (languageRepository.findAll().stream().filter(a -> a.getLanguageName().equals(languageName)).findAny()
				.orElse(null) != null) {

			throw new RuntimeException(languageName + " is already exist.");
		}

	}

	private void isExistById(int languageId) throws Exception {

		if (languageRepository.findByLanguageId(languageId) == null) {
			throw new RuntimeException("There is no " + languageId + " in database.");
		}

	}

}
