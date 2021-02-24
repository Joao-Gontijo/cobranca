package cobranca.entidade;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Boleto {

	@Id	
	private String codigo;
	
	private String descricao;
	private double valor;
	
	
	@ManyToOne
	private Cliente cliente;
	@ManyToOne
	private Servico servico;
	
	public Boleto() {
		// TODO Auto-generated constructor stub
	}
	

	public Boleto(String codigo, String descricao, double valor, Cliente cliente, Servico servico) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.valor = valor;
		this.cliente = cliente;
		this.servico = servico;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Servico getServico() {
		return servico;
	}
	
	public void setServico(Servico servico) {
		this.servico = servico;
	}
}
