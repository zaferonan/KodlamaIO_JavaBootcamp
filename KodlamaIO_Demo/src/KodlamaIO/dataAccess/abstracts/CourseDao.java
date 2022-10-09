package KodlamaIO.dataAccess.abstracts;

import java.util.ArrayList;

import KodlamaIO.entities.Category;
import KodlamaIO.entities.Course;


public interface CourseDao {
	public void add(Course course);
	public void update(Course course);
	public void delete(Course course);
	public ArrayList<Course> getCourses();
	public boolean isExist(String courseName);
	
	// Reel veritabanı bağlantısı yapılmadığı için gerçekleme amacı ile
	// coursesDB listesinde veriler tutulacak
	
	public static ArrayList<Course> coursesDB= new ArrayList<>();
}
