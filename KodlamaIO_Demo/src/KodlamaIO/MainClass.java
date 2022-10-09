package KodlamaIO;

import java.util.ArrayList;

import KodlamaIO.business.abstracts.CategoryService;
import KodlamaIO.business.abstracts.CourseService;
import KodlamaIO.business.abstracts.InstructorService;
import KodlamaIO.business.concretes.CategoryManager;
import KodlamaIO.business.concretes.CourseManager;
import KodlamaIO.business.concretes.InstructorManager;
import KodlamaIO.core.logging.abstracts.Logger;
import KodlamaIO.core.logging.concretes.DatabaseLogger;
import KodlamaIO.core.logging.concretes.FileLogger;
import KodlamaIO.core.logging.concretes.MailLogger;
import KodlamaIO.dataAccess.concretes.Hibernate.HibernateCategoryDao;
import KodlamaIO.dataAccess.concretes.Hibernate.HibernateCourseDao;
import KodlamaIO.dataAccess.concretes.Hibernate.HibernateInstructorDao;
import KodlamaIO.dataAccess.concretes.JDBC.JdbcCategoryDao;
import KodlamaIO.dataAccess.concretes.JDBC.JdbcCourseDao;
import KodlamaIO.dataAccess.concretes.JDBC.JdbcInstructorDao;
import KodlamaIO.entities.*;


public class MainClass {

	public static void main(String[] args) throws Exception {
		Logger[] loggers1 = { new DatabaseLogger(), new FileLogger() };
		Logger[] loggers2 = { new DatabaseLogger(), new FileLogger(),new MailLogger() };
		
		Instructor engindemirog= new Instructor("Engin Demirog");
		
		Category cat1=new Category(1, "Programlama");
		Category cat2=new Category(2, "Kategori2");
		Category cat3=new Category(3, "Kategori3");
		Category cat1Tekrar=new Category(4, "Programlama");
		
		
		Course java=new Course(1, "(2022) Yazilim Gelistirici Yetistirme Kampi - JAVA", 0.0, engindemirog);
		Course javaReact=new Course(2, "Yazilim Gelistirici Yetistirme Kampi (JAVA & REACT)", 1000, engindemirog);
		Course javaTekrar=new Course(3, "(2022) Yazilim Gelistirici Yetistirme Kampi - JAVA", 0.0, engindemirog);
		Course angularNegativePrice=new Course(4, "Yazilim Gelistirici Yetistirme Kampi", -100, engindemirog);
		
		InstructorService instructorManager=new InstructorManager(new HibernateInstructorDao(), loggers2);
		InstructorService instructorManager2=new InstructorManager(new JdbcInstructorDao(), loggers1);
				
		CourseService courseManager=new CourseManager(new HibernateCourseDao(), loggers1);
		CourseService courseManager2=new CourseManager(new JdbcCourseDao(), loggers2);
		
		CategoryService categoryManager=new CategoryManager(new HibernateCategoryDao(), loggers1);
		CategoryService categoryManager2=new CategoryManager(new JdbcCategoryDao(), loggers2);
		
		instructorManager.add(engindemirog);		
		//Eğitimci isim tekrar kontrolü:
		//instructorManager2.add(new Instructor("Engin Demirog"));
		System.out.println("--------------------------------");		
				
		courseManager.add(java);
		System.out.println("--------------------------------");
		//Kurs ismi tekrar kontrolü:
		//courseManager.add(javaTekrar);
		System.out.println("--------------------------------");
		courseManager2.add(javaReact);
		System.out.println("--------------------------------");
		//Kurs fiyatı negatif olamaz kontrolü:
		//courseManager2.add(angularNegativePrice);
		
		cat1.addCourse(java);
		cat1.addCourse(javaReact);
		System.out.println("--------------------------------");
		categoryManager.add(cat1);
		System.out.println("--------------------------------");
		categoryManager2.add(cat2);
		System.out.println("--------------------------------");
		categoryManager2.add(cat3);
		System.out.println("--------------------------------");
		//Kategori ismi tekrar kontrolü:		
		//categoryManager.add(cat1Tekrar);
		System.out.println("--------------------------------");
		
		
	
		for (Category category : categoryManager.getCategories()) {
			System.out.println(category.getCategoryName());
			ArrayList<Course> courses=category.getCourses();
			if(!courses.isEmpty()) {
				for (Course course : courses) {
					System.out.println(" - "+course.getCourseName());
				}
			}
		}
		
	}
}
