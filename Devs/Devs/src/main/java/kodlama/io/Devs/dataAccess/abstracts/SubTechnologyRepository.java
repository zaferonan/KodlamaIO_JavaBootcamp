package kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.Devs.entities.concretes.SubTechnology;

public interface SubTechnologyRepository extends JpaRepository<SubTechnology, Integer> {

	SubTechnology findBySubTechnologyId(int subTechnologyId);
	
	List<SubTechnology> getByLanguage_languageId(int languageId);
}
