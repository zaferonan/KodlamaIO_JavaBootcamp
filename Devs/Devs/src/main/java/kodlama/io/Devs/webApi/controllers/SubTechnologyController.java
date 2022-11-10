package kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs.business.abstracts.SubTechnologyService;
import kodlama.io.Devs.business.requests.CreateSubTechnologyRequest;
import kodlama.io.Devs.business.requests.UpdateSubTechnologyRequest;
import kodlama.io.Devs.business.responses.GetSubTechnologyResponse;

@RestController
@RequestMapping("/api/subTechnology")
public class SubTechnologyController {

	private SubTechnologyService subTechnologyService;

	@Autowired
	public SubTechnologyController(SubTechnologyService subTechnologyService) {
		
		this.subTechnologyService = subTechnologyService;
	}
	
	@GetMapping("/getAll")
	public List<GetSubTechnologyResponse> getAll() {
		return subTechnologyService.getAll();
	}
	
	@PostMapping("/add")
	public void add(CreateSubTechnologyRequest createSubTechnologyRequest) throws RuntimeException {
		subTechnologyService.add(createSubTechnologyRequest);
	}
	
	@DeleteMapping("/delete")
	public void delete(int  subTechnologyId)throws RuntimeException {
		subTechnologyService.delete(subTechnologyId);
		
	}

	@PostMapping("/update")
	public void update(UpdateSubTechnologyRequest updateSubTechnologyRequest)throws RuntimeException {
		subTechnologyService.update(updateSubTechnologyRequest);
		
	}

	@GetMapping("/get")
	public GetSubTechnologyResponse getById(int id)throws RuntimeException {
		
		return subTechnologyService.getById(id);
	}
}
