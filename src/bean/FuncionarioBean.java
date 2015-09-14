package bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import modelo.Empresa;
import modelo.Funcionario;
import dao.EmpresaDAO;
import dao.FuncionarioDAO;

@ManagedBean
@ViewScoped
public class FuncionarioBean implements Serializable {

	private static final long serialVersionUID = 8003518321002959920L;

	private Funcionario funcionario;
	private List<Funcionario> funcionarios;
	private List<Empresa> empresas;

	public FuncionarioBean() {
		funcionarios = FuncionarioDAO.listarTodos();
		empresas = EmpresaDAO.listarTodas();
	}

	public void novoFuncionario() {
		this.funcionario = new Funcionario();
	}

	public void salvar() {
		FuncionarioDAO.salvar(funcionario);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Funcionário cadastrado com sucesso!"));
		funcionarios = FuncionarioDAO.listarTodos();
		funcionario = null;
	}

	public void editar(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public void cancelar() {
		this.funcionario = null;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

}
