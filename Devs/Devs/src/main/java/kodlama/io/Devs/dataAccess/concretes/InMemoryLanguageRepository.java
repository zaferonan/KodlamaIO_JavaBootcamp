package kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Devs.entities.concretes.Language;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository{

	List<Language> languages;
	
	public InMemoryLanguageRepository() {
		languages=new ArrayList<>();
		languages.add(new Language(1, "Java"));
		languages.add(new Language(2, "C++"));
		languages.add(new Language(3, "C#"));
		languages.add(new Language(4, "Pyhton"));
	}

	@Override
	public List<Language> getAll() {
		
		return languages;
	}

	@Override
	public void add(Language language) {
		this.languages.add(language);
		
	}

	@Override
	public void delete(Language language) {
		this.languages.remove(language);
		
	}

	@Override
	public void update(Language language) {
		Language thisLanguage=getById(language.getLanguageId());
		thisLanguage.setLanguageName(language.getLanguageName());
		
	}

	@Override
	public Language getById(int languageId) {
		for (Language language : languages) {
			if(language.getLanguageId()==languageId) {				
				return language;
			}
		}
		return null;
	}

}
