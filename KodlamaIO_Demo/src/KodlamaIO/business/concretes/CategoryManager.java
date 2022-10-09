package KodlamaIO.business.concretes;

import java.util.ArrayList;

import KodlamaIO.business.abstracts.CategoryService;
import KodlamaIO.core.logging.abstracts.Logger;
import KodlamaIO.dataAccess.abstracts.CategoryDao;
import KodlamaIO.entities.Category;

public class CategoryManager implements CategoryService{

	private CategoryDao categoryDao;	
	private Logger[] loggers;
	
	public CategoryManager(CategoryDao categoryDao, Logger[] loggers) {
		
		this.categoryDao = categoryDao;
		this.loggers = loggers;
	}

	@Override
	public void add(Category category) throws Exception {
		if(!categoryDao.isExist(category.getCategoryName())){		
			
			categoryDao.add(category);

			for (Logger logger : loggers) {
				logger.log(category.getCategoryName()+ " kategorisi veritabanina eklendi");
			}
		}else {
			throw new Exception("Kategori ismi tekrar edemez");
		}
		
	}

	@Override
	public void delete(Category category) {	
		if(!categoryDao.isExist(category.getCategoryName())){
			System.err.println(category.getCategoryName()+" Veritabaninda bulunmadigindan silinemedi !!!.");
		}else {
			categoryDao.delete(category);
			for (Logger logger : loggers) {
				logger.log(category.getCategoryName()+ " kategorisi veritabanindan silindi.");
			}
		}
			
				
	}

	@Override
	public void update(Category category) throws Exception {
		if(!categoryDao.isExist(category.getCategoryName())){
			System.err.println(category.getCategoryName()+" Veritabaninda bulunmadigindan güncellenemedi !!!.");
			add(category);
		}else {
			categoryDao.update(category);
			for (Logger logger : loggers) {
				logger.log(category.getCategoryName()+ " kategorisi veritabaninda güncellendi.");
			}
		}
		
	}

	@Override
	public ArrayList<Category> getCategories() {
		// TODO Auto-generated method stub
		return categoryDao.getCategories();
	}



}
