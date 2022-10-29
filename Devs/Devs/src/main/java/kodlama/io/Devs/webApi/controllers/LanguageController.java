package kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Devs.entities.concretes.Language;

@RestController
@RequestMapping("/api/languages")
public class LanguageController {
	
	private LanguageService languageService;

	@Autowired
	public LanguageController(LanguageService langugeService) {
		
		this.languageService = langugeService;
	}
	
	@GetMapping("/getAll")
	public List<Language> getAll() {
		
		return languageService.getAll();
	}
	
	@GetMapping("/get/{languageId}" )
	public ResponseEntity<Language> getById(@PathVariable int languageId) {
		
		return ResponseEntity.ok(languageService.getById(languageId));
	}
	

    @PostMapping("/add")
    public void add(@RequestBody Language language){
        languageService.add(language);
    }
	

	
	@PostMapping("/delete/{languageId}-{languageName}")
	public void delete(@PathVariable int languageId,@PathVariable String languageName) {
		languageService.delete(new Language(languageId,languageName));
	}
	@PostMapping("/delete")
	public void delete(@RequestBody Language language) {
		languageService.delete(language);
	}
	
	@PostMapping("/update/{languageId}-{languageName}")
	public void update(@PathVariable int languageId,@PathVariable String languageName) {
		
		languageService.update(new Language(languageId,languageName));
	}
	@PostMapping("/update")
	public void update(@RequestBody Language language) {
		
		languageService.update(language);
	}
	

}
