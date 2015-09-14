package dao;
import java.util.List;

import javax.persistence.EntityManager;

import modelo.Empresa;


public class EmpresaDAO {

	public static void salvar(Empresa empresa){
		EntityManager manager = JpaUtil.createEntityManager();
		
		manager.getTransaction().begin();
		manager.merge(empresa);
		manager.getTransaction().commit();
		manager.close();
	}
	
	public static List<Empresa> listarTodas(){
		EntityManager manager = JpaUtil.createEntityManager();
		List<Empresa> empresas = manager.createQuery("from Empresa", Empresa.class).getResultList();
		manager.close();
		return empresas;
	}
	
	public static void main(String[] args) {
		Empresa empresa = new Empresa();
		empresa.setNome("Empresa Teste 1");
		empresa.setCnpj("12.444.162/0001-06");
		salvar(empresa);
	}
}
