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
//		String idString = req.getParameter("id");
		String nome = req.getParameter("input-nome");
		ServicoDAO dao = new ServicoDAO();
		
//		Long id = Long.parseLong(idString);
//		servico.setId(id);
		servico.setNome(nome);
		dao.salvar(servico);
		
		String pagina = new AcaoListagemServicos(req).executa();
		return pagina;
	}
}
