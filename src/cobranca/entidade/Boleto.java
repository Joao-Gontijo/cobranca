package cobranca.entidade;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Boleto {

	@Id
	private long id;

	private String codigo;

	@ManyToOne
	private Contrato contrato;

	public Boleto() {

	}

	public Boleto(String codigo, Contrato contrato) {
		super();
		this.codigo = codigo;
		this.contrato = contrato;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Contrato getContrato() {
		return contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}
}
