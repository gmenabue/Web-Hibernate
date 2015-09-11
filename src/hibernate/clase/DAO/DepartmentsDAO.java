package hibernate.clase.DAO;

import java.util.List;

import hibernate.clase.DTO.Departments;
import interfaces.InterfaceDAO;

public class DepartmentsDAO extends SuperDAO implements InterfaceDAO<DepartmentsDAO> {

	@Override
	public boolean create(DepartmentsDAO g) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DepartmentsDAO read(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DepartmentsDAO update(DepartmentsDAO g) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Object id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<DepartmentsDAO> read_all() {
		@SuppressWarnings("unchecked")
		List<DepartmentsDAO> list = getSession().createSQLQuery("select * from DEPARTMENTS").addEntity(Departments.class).list();
		return list;
	}
	
	public List<Departments> read_all2(int department_id) {
		String consulta = "select * from DEPARTMENTS WHERE DEPARTMENT_ID = " + department_id;
		@SuppressWarnings("unchecked")
		List<Departments> list = getSession().createSQLQuery(consulta).addEntity(Departments.class).list();
		return list;
		
	}

	

}
