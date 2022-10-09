package KodlamaIO.dataAccess.abstracts;

import java.util.ArrayList;

import KodlamaIO.entities.Category;
import KodlamaIO.entities.Course;


public interface CategoryDao {
	
	public void add(Category category);
	public void update(Category category);
	public void delete(Category category);
	public ArrayList<Category> getCategories();
	public boolean isExist(String categoryName);
	
	// Reel veritabanı bağlantısı yapılmadığı için gerçekleme amacı ile
	// CategoriesDB listesinde veriler tutulacak
	
	public static ArrayList<Category> categoriesDB= new ArrayList<>();
}
