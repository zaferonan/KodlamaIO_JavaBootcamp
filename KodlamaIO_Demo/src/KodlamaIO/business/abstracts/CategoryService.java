package KodlamaIO.business.abstracts;

import java.util.ArrayList;

import KodlamaIO.entities.Category;
import KodlamaIO.entities.Course;

public interface CategoryService {

	public void add(Category category) throws Exception;
	public void delete(Category category);
	public void update(Category category) throws Exception;
	public ArrayList<Category> getCategories();
}
