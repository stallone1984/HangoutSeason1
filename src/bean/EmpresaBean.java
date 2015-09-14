package bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.EmpresaDAO;
import modelo.Empresa;

@ManagedBean
@SessionScoped
public class EmpresaBean {

	private Empresa empresa = new Empresa();
	private List<Empresa> empresasCadastradas = new ArrayList<Empresa>();
	
	public EmpresaBean(){
		empresasCadastradas = EmpresaDAO.listarTodas();
	}

	public String salvar(){
		//empresasCadastradas.add(empresa);
		EmpresaDAO.salvar(empresa);
		empresasCadastradas = EmpresaDAO.listarTodas();
		empresa = new Empresa();
		return "listagem_empresa?faces-redirect=true";
	}
	
	public String editar(Empresa empresa){
		this.empresa = empresa;
		return "cadastro_empresa?faces-redirect=true";
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<Empresa> getEmpresasCadastradas() {
		return empresasCadastradas;
	}

	public void setEmpresasCadastradas(List<Empresa> empresasCadastradas) {
		this.empresasCadastradas = empresasCadastradas;
	}

}
