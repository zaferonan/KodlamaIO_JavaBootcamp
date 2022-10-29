package kodlama.io.Devs.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.LanguageService;
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
	public List<Language> getAll() {

		return languageRepository.getAll();
	}

	@Override
	public void add(Language language) {
		if (isExistByName(language.getLanguageName())) {
			throw new RuntimeException(language.getLanguageName() + " is already exist.");
		} else if (isExistById(language.getLanguageId())) {
			update(language);
		} else if (language.getLanguageName().equals("")) {
			throw new RuntimeException("Language name can not be null.");

		} else {
			languageRepository.add(language);
		}
	}

	@Override
	public void delete(Language language) {
		if (isExist(language)) {
			languageRepository.delete(language);
		} else {
			throw new RuntimeException(language.getLanguageName() + " is not exist.");
		}
	}

	@Override
	public void update(Language language) {
		if (isExistById(language.getLanguageId())) {
			if (!language.getLanguageName().equals(""))
				languageRepository.update(language);
			else
				throw new RuntimeException("Language name can not be null.");

		} else {
			add(language);
		}

	}

	@Override
	public Language getById(int languageId) {
		Language language = languageRepository.getById(languageId);
		if (language != null) {
			return language;
		} else {
			throw new RuntimeException(languageId + " is not an existed id.");
		}

	}

	private boolean isExist(Language language) {
		if (languageRepository.getAll().stream().filter(a -> a.equals(language)).findAny().orElse(null) != null) {
			return true;
		}

		return false;

	}

	private boolean isExistByName(String languageName) {		
		if (languageRepository.getAll().stream().filter(a -> a.getLanguageName().equals(languageName)).findAny().orElse(null)!=null) {
			System.err.println("asdas");
			return true;
		}

		return false;
	}

	private boolean isExistById(int languageId) {

		if (languageRepository.getAll().stream().filter(a -> a.getLanguageId() == languageId).findAny().orElse(null) != null) {
			return true;
		}

		return false;
	}

}
