package KodlamaIO.dataAccess.concretes.JDBC;

import java.util.ArrayList;

import KodlamaIO.dataAccess.abstracts.InstructorDao;
import KodlamaIO.entities.Instructor;

public class JdbcInstructorDao implements InstructorDao {

	@Override
	public void add(Instructor instructor) {
		instructorDB.add(instructor);
		System.out.println(instructor.getName()+" JDBC ile veritabanina eklendi.");
		
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
		System.out.println(instructor.getName()+" JDBC ile veritabaninda guncellendi.");
		
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
		System.out.println(instructor.getName()+" JDBC ile veritabanindan silindi.");
		
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
