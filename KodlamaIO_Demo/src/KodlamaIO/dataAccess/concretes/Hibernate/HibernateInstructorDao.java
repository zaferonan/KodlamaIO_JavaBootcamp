package KodlamaIO.dataAccess.concretes.Hibernate;

import java.util.ArrayList;

import KodlamaIO.dataAccess.abstracts.InstructorDao;
import KodlamaIO.entities.Course;
import KodlamaIO.entities.Instructor;

public class HibernateInstructorDao implements InstructorDao {

	@Override
	public void add(Instructor instructor) {
		instructorDB.add(instructor);
		System.out.println(instructor.getName()+" Hibernate ile veritabanina eklendi.");
		
	}

	@Override
	public void update(Instructor instructor) {
		for (int i = 0; i < instructorDB.size(); i++) {
			if(instructorDB.get(i).getName().equals(instructor.getName())) {
				instructorDB.remove(i);
				instructorDB.add(instructor);
				break;
			}
		}
		System.out.println(instructor.getName()+" Hibernate ile veritabaninda guncellendi.");
		
	}

	@Override
	public void delete(Instructor instructor) {
		if(instructorDB.contains(instructor))
			instructorDB.remove(instructor);
		else {
			for (int i = 0; i < instructorDB.size(); i++) {
				if(instructorDB.get(i).getName().equals(instructor.getName())) {
					instructorDB.remove(i);
					break;
				}
			}
		}
		System.out.println(instructor.getName()+" Hibernate ile veritabanindan silindi.");
		
	}

	@Override
	public ArrayList<Instructor> getInstructors() {
		// TODO Auto-generated method stub
		return instructorDB;
	}

	@Override
	public boolean isExist(String instructorName) {
		ArrayList<Instructor> instructors=getInstructors();
		for (Instructor instructor : instructors) {
			if(instructor.getName().equals(instructorName)) {
				return true;
			}
		}
		return false;
	}

}
