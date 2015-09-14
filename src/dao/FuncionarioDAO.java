package dao;
import java.util.List;

import javax.persistence.EntityManager;

import modelo.Funcionario;


public class FuncionarioDAO {

	public static void salvar(Funcionario funcionario){
		EntityManager manager = JpaUtil.createEntityManager();
		
		manager.getTransaction().begin();
		manager.merge(funcionario);
		manager.getTransaction().commit();
		manager.close();
	}
	
	public static List<Funcionario> listarTodos(){
		EntityManager manager = JpaUtil.createEntityManager();
		List<Funcionario> funcionarios = manager.createQuery("from Funcionario", Funcionario.class).getResultList();
		manager.close();
		return funcionarios;
	}
	
}
