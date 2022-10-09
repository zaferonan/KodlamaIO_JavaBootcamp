package KodlamaIO.dataAccess.concretes.JDBC;

import java.util.ArrayList;

import KodlamaIO.dataAccess.abstracts.CourseDao;
import KodlamaIO.entities.Category;
import KodlamaIO.entities.Course;

public class JdbcCourseDao implements CourseDao{

	@Override
	public void add(Course course) {
		coursesDB.add(course);
		System.out.println(course.getCourseName()+" JDBC ile veritabanina eklendi.");
		
	}

	@Override
	public void update(Course course) {
		for (int i = 0; i < coursesDB.size(); i++) {
			if(coursesDB.get(i).getCourseName().equals(course.getCourseName())) {
				coursesDB.remove(i);
				coursesDB.add(course);
				break;
			}
		}
		System.out.println(course.getCourseName()+" JDBC ile veritabaninda guncellendi.");
		
	}

	@Override
	public void delete(Course course) {
		if(coursesDB.contains(course))
			coursesDB.remove(course);
		else {
			for (int i = 0; i < coursesDB.size(); i++) {
				if(coursesDB.get(i).getCourseName().equals(course.getCourseName())) {
					coursesDB.remove(i);
					break;
				}
			}
		}
		System.out.println(course.getCourseName()+" JDBC ile veritabanindan silindi.");
		
	}

	@Override
	public ArrayList<Course> getCourses() {
		// TODO Auto-generated method stub
		return coursesDB;
	}

	@Override
	public boolean isExist(String courseName) {
		ArrayList<Course> courses=getCourses();
		for (Course course : courses) {
			if(course.getCourseName().equals(courseName)) {
				return true;
			}
		}
		return false;
	}

}
