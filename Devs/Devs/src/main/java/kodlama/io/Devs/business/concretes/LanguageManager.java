package kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Devs.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService{

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
		if(isExistByName(language.getLanguageName())) {
			throw new RuntimeException(language.getLanguageName()+" is already exist.");
		}else if(isExistById(language.getLanguageId())) {
			update(language);			
		}else if(language.getLanguageName().equals("")) {
			throw new RuntimeException("Language name can not be null.");
			
		}else {
			languageRepository.add(language);
		}
	}


	@Override
	public void delete(Language language) {
		if(isExist(language)) {
			languageRepository.delete(language);
		}else {
			throw new RuntimeException(language.getLanguageName()+" is not exist.");
		}		
	}


	@Override
	public void update(Language language) {		
		if(isExistById(language.getLanguageId())) {
			if(!language.getLanguageName().equals(""))
				languageRepository.update(language);
			else
				throw new RuntimeException("Language name can not be null.");
				
		}else {
			add(language);
		}
		
	}


	@Override
	public Language getById(int languageId) {
		Language language=languageRepository.getById(languageId);
		if(language!=null) {
			return language;
		}else {
			throw new RuntimeException(languageId+" is not an existed id.");
		}
		 
	}
	
	private boolean isExist(Language language) {
		List<Language> languages=languageRepository.getAll();
		for (Language language2 : languages) {
			if(language2.equals(language)) {
				return true;
			}
		}
		return false;	
		
	}


	private boolean isExistByName(String languageName) {
		List<Language> languages=languageRepository.getAll();
		for (Language language2 : languages) {
			if(language2.getLanguageName().equals(languageName)) {
				return true;
			}
		}
		return false;
	}


	private boolean isExistById(int languageId) {
		List<Language> languages=languageRepository.getAll();
		for (Language language2 : languages) {
			if(language2.getLanguageId()==(languageId)) {
				return true;
			}
		}
		return false;
	}



}
