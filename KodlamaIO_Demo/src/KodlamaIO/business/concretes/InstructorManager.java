package KodlamaIO.business.concretes;

import java.util.ArrayList;

import KodlamaIO.business.abstracts.InstructorService;
import KodlamaIO.core.logging.abstracts.Logger;
import KodlamaIO.dataAccess.abstracts.InstructorDao;
import KodlamaIO.entities.Instructor;

public class InstructorManager implements InstructorService {

	private InstructorDao instructorDao;
	private Logger[] loggers;
	
	public InstructorManager(InstructorDao instructorDao, Logger[] loggers) {		
		this.instructorDao = instructorDao;
		this.loggers = loggers;
	}

	@Override
	public void add(Instructor instructor) throws Exception {
		if(!instructorDao.isExist(instructor.getName())){		


			instructorDao.add(instructor);

			for (Logger logger : loggers) {
				logger.log(instructor.getName()+ " Egitmen olarak veritabanina eklendi.");
			}
		}else {
			throw new Exception("Egitmen ismi tekrar edemez");
		}
		
	}

	@Override
	public void delete(Instructor instructor) {
		if(!instructorDao.isExist(instructor.getName())){
			System.err.println(instructor.getName()+" Veritabaninda bulunmadigindan silinemedi !!!.");
			
		}else {
			instructorDao.delete(instructor);
			for (Logger logger : loggers) {
				logger.log(instructor.getName()+ " Egitmen olarak veritabanindan silindi.");
			}
		}
		
	}

	@Override
	public void update(Instructor instructor) throws Exception {
		if(!instructorDao.isExist(instructor.getName())){
			System.err.println(instructor.getName()+" Veritabaninda bulunmadigindan guncellenemedi !!!.");
			add(instructor);
		}else {
			instructorDao.update(instructor);
			for (Logger logger : loggers) {
				logger.log(instructor.getName()+ " Egitmen olarak veritabaninda guncellendi.");
			}
		}
		
	}

	@Override
	public ArrayList<Instructor> getInstructors() {
		// TODO Auto-generated method stub
		return instructorDao.getInstructors();
	}


}
