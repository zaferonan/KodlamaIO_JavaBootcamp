package KodlamaIO.business.abstracts;

import java.util.ArrayList;

import KodlamaIO.entities.Category;
import KodlamaIO.entities.Course;

public interface CourseService {
	public void add(Course course) throws Exception;
	public void delete(Course course);
	public void update(Course course) throws Exception;
	public ArrayList<Course> getCourses();

	
}
