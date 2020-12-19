package cobranca.controlador.acao;

import javax.servlet.http.HttpServletRequest;

import cobranca.entidade.Servico;
import cobranca.services.ServicoDAO;

public class AcaoSalvaServicos {
	
	private HttpServletRequest req;

	public AcaoSalvaServicos(HttpServletRequest req) {
		this.req = req;
	}
	
	public String executa() {
		
		Servico servico = new Servico();
		ServicoDAO dao = new ServicoDAO();
		
		String idString = req.getParameter("id"); //Não tá chegando nada aqui

		System.out.println("OLHA O ID AQUIIIIIII " + idString);
		
		String nome = req.getParameter("input-nome");
		servico.setNome(nome);
		dao.salvar(servico);
		
		String pagina = new AcaoListagemServicos(req).executa();
		return pagina;
	}
}
