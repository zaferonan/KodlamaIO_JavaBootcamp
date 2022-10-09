package KodlamaIO.dataAccess.abstracts;

import java.util.ArrayList;

import KodlamaIO.entities.Category;
import KodlamaIO.entities.Course;
import KodlamaIO.entities.Instructor;

public interface InstructorDao {
	public void add(Instructor instructor);
	public void update(Instructor instructor);
	public void delete(Instructor instructor);
	public ArrayList<Instructor> getInstructors();
	public boolean isExist(String instructorName);
	
	// Reel veritabanı bağlantısı yapılmadığı için gerçekleme amacı ile
	// InstructorDB listesinde veriler tutulacak
	
	public static ArrayList<Instructor> instructorDB= new ArrayList<>();
}
