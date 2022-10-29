package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.entities.concretes.Language;


public interface LanguageService {

	public List<Language> getAll();
	public void add(Language language);
	public void delete(Language language);
	public void update(Language language);
	public Language getById(int languageId);
}
