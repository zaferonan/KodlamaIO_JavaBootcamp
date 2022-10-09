package KodlamaIO.entities;

public class Course {

	private int id;
	private String courseName;
	private double price;
	private Instructor instructor;
	private String courseDetails;
	

	
	public Course(int id, String courseName, double price, Instructor instructor) {
		
		this.id = id;
		this.courseName = courseName;
		this.price = price;
		this.instructor = instructor;
		
	}



	public Course(int id, String courseName, double price, Instructor instructor, String courseDetails,
			Category courseCategory) {
		
		this.id = id;
		this.courseName = courseName;
		this.price = price;
		this.instructor = instructor;
		this.courseDetails = courseDetails;
		
	}


	public String getCourseName() {
		return courseName;
	}
	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Instructor getInstructor() {
		return instructor;
	}
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	public String getCourseDetails() {
		return courseDetails;
	}
	public void setCourseDetails(String courseDetails) {
		this.courseDetails = courseDetails;
	}
	public int getId() {
		return id;
	}


	
}
