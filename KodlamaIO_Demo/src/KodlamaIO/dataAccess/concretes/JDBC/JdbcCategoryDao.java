package KodlamaIO.dataAccess.concretes.JDBC;

import java.util.ArrayList;

import KodlamaIO.dataAccess.abstracts.CategoryDao;
import KodlamaIO.entities.Category;

public class JdbcCategoryDao implements CategoryDao{

	@Override
	public void add(Category category) {
		categoriesDB.add(category);
		System.out.println(category.getCategoryName()+" JDBC ile veritabanina eklendi.");
		
	}

	@Override
	public void update(Category category) {
		for (int i = 0; i < categoriesDB.size(); i++) {
			if(categoriesDB.get(i).getCategoryName().equals(category.getCategoryName())) {
				categoriesDB.remove(i);
				categoriesDB.add(category);
				break;
			}
		}
		System.out.println(category.getCategoryName()+" JDBC ile veritabaninda guncellendi.");
		
	}

	@Override
	public void delete(Category category) {
		if(categoriesDB.contains(category))
			categoriesDB.remove(category);
		else {
			for (int i = 0; i < categoriesDB.size(); i++) {
				if(categoriesDB.get(i).getCategoryName().equals(category.getCategoryName())) {
					categoriesDB.remove(i);
					break;
				}
			}
		}
		System.out.println(category.getCategoryName()+" JDBC ile veritabanindan silindi.");
		
	}

	@Override
	public ArrayList<Category> getCategories() {
		// TODO Auto-generated method stub
		return categoriesDB;
	}



	@Override
	public boolean isExist(String categoryName) {
		ArrayList<Category> categories=getCategories();
		for (Category category : categories) {
			if(category.getCategoryName().equals(categoryName)) {
				return true;
			}
		}
		return false;
	}

}
