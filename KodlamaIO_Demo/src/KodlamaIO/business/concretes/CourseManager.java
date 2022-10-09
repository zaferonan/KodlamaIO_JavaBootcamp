package KodlamaIO.business.concretes;

import java.util.ArrayList;

import KodlamaIO.business.abstracts.CourseService;
import KodlamaIO.core.logging.abstracts.Logger;
import KodlamaIO.dataAccess.abstracts.CourseDao;
import KodlamaIO.entities.Course;

public class CourseManager implements CourseService{

	private CourseDao courseDao;
	private Logger[] loggers;
	
	public CourseManager(CourseDao courseDao, Logger[] loggers) {
		
		this.courseDao = courseDao;
		this.loggers = loggers;
	}

	@Override
	public void add(Course course) throws Exception {
		// iş kuralları
		 
		if(!courseDao.isExist(course.getCourseName())){			
		
			if (course.getPrice() < 0) {
			
				throw new Exception("Kurs fiyati 0'dan kucuk olamaz!!");
			}

			courseDao.add(course);

			for (Logger logger : loggers) {
				logger.log(course.getCourseName()+" Kursu veritabanina eklendi.");
			}
		}else {
			throw new Exception("Kurs ismi tekrar edemez");
		}
		
	}

	@Override
	public void delete(Course course) {
		if(!courseDao.isExist(course.getCourseName())){
			System.err.println(course.getCourseName()+" Veritabaninda bulunmadigindan silinemedi !!!.");
		}else {
			courseDao.delete(course);
			for (Logger logger : loggers) {
				logger.log(course.getCourseName()+" Kursu veritabanindan silindi.");
			}
		}
		
	}

	@Override
	public void update(Course course) throws Exception {
		if(!courseDao.isExist(course.getCourseName())){
			System.err.println(course.getCourseName()+" Veritabaninda bulunmadigindan guncellenemedi !!!.");
			add(course);
		}else {
			courseDao.update(course);
			for (Logger logger : loggers) {
				logger.log(course.getCourseName()+" Kursu veritabaninda guncellendi.");
			}
		}
		
	}

	@Override
	public ArrayList<Course> getCourses() {
		// TODO Auto-generated method stub
		return courseDao.getCourses();
	}


}
