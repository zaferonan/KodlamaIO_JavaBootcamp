package KodlamaIO.entities;

import java.util.ArrayList;

public class Category {

	private int id;
	private String categoryName;
	private ArrayList<Course> courses;
	
	public Category(int id, String categoryName) {
		this.id = id;
		this.categoryName = categoryName;
		this.courses=new ArrayList<>();
	}
	
	public Category(int id, String categoryName, ArrayList<Course> courses) {
		this.id = id;
		this.categoryName = categoryName;
		this.courses = courses;
	}

	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public void addCourse(Course course) {
		this.courses.add(course);
	}
	public int getId() {
		return id;
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}
	
	
}
