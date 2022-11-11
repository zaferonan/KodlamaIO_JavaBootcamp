package kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Devs.business.requests.CreateLanguageRequest;
import kodlama.io.Devs.business.requests.UpdateLanguageRequest;
import kodlama.io.Devs.business.responses.GetLanguageResponse;

@RestController
@RequestMapping("/api/languages")
public class LanguageController {
	
	private LanguageService languageService;

	@Autowired
	public LanguageController(LanguageService langugeService) {
		
		this.languageService = langugeService;
	}
	
	@GetMapping("/getAll")
	public List<GetLanguageResponse> getAll() {
		
		return languageService.getAll();
	}
	
	@GetMapping("/get" )
	public GetLanguageResponse getById(@RequestParam int languageId) throws Exception {
		
		return languageService.getById(languageId);
	}
	

    @PostMapping("/add")
    public void add(@RequestBody CreateLanguageRequest createLanguageRequest) throws Exception{
        languageService.add(createLanguageRequest);
    }
	

	

	@DeleteMapping("/delete")
	public void delete(@RequestParam int languageId) throws Exception {
		languageService.delete(languageId);
	}
	
	
	@PostMapping("/update")
	public void update(@RequestBody UpdateLanguageRequest updateLanguageRequest) throws Exception {		
		languageService.update(updateLanguageRequest);
	}
	

}
