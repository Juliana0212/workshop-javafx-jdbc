package model.services;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentService {

	private DepartmentDao dao = DaoFactory.createDepartmentDao(); // Acessar bancos de dados atraves do dao

	// Métodos
	
	public List<Department> findAll() { // Acessar bancos de dados atraves do dao
		return dao.findAll();
	}
	
	public void saveOrUpdate (Department obj) { //Inserir ou atualizar o Department existente
		if (obj.getId() == null) {
			dao.insert(obj);
		}
		else {
			dao.update(obj);
		}
	}
}
