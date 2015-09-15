package dao;
import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import modelo.Funcionario;


public class FuncionarioDAO implements Serializable{

	private static final long serialVersionUID = -4320226523578749133L;

	public void salvar(Funcionario funcionario){
		EntityManager manager = JpaUtil.createEntityManager();
		
		manager.getTransaction().begin();
		manager.merge(funcionario);
		manager.getTransaction().commit();
		manager.close();
	}
	
	public List<Funcionario> listarTodos(){
		EntityManager manager = JpaUtil.createEntityManager();
		List<Funcionario> funcionarios = manager.createQuery("from Funcionario", Funcionario.class).getResultList();
		manager.close();
		return funcionarios;
	}
	
}
