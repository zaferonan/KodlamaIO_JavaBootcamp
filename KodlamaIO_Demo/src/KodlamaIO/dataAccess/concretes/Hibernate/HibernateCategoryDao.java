package KodlamaIO.dataAccess.concretes.Hibernate;


import java.util.ArrayList;

import KodlamaIO.dataAccess.abstracts.CategoryDao;
import KodlamaIO.entities.Category;

public class HibernateCategoryDao implements CategoryDao {

	

	@Override
	public void add(Category category) {
		categoriesDB.add(category);
		System.out.println(category.getCategoryName()+" Hibernate ile veritabanina eklendi.");
		
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
		System.out.println(category.getCategoryName()+" Hibernate ile veritabaninda guncellendi.");
		
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
		System.out.println(category.getCategoryName()+" Hibernate ile veritabanindan silindi ");
		
	}

	@Override
	public ArrayList<Category> getCategories() {
		// Veritabanında bulunan kategori verilerini döner
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
