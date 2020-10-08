package model.services;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class SellerService {

	private SellerDao dao = DaoFactory.createSellerDao(); // Acessar bancos de dados atraves do dao

	// Métodos

	public List<Seller> findAll() { // Acessar bancos de dados atraves do dao
		return dao.findAll();
	}

	public void saveOrUpdate(Seller obj) { // Inserir ou atualizar o Seller existente
		if (obj.getId() == null) {
			dao.insert(obj);
		} else {
			dao.update(obj);
		}
	}

	public void remove(Seller obj) { // Remover um departamento do banco de dados
		dao.deleteById(obj.getId());
	}

}
