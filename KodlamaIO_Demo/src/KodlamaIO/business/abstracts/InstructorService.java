package KodlamaIO.business.abstracts;

import java.util.ArrayList;

import KodlamaIO.entities.Category;
import KodlamaIO.entities.Course;
import KodlamaIO.entities.Instructor;

public interface InstructorService {

	public void add(Instructor instructor) throws Exception;
	public void delete(Instructor instructor);
	public void update(Instructor instructor) throws Exception;
	public ArrayList<Instructor> getInstructors();

}
