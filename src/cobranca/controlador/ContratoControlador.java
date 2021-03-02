package cobranca.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cobranca.controlador.acao.AcaoCarregaDadosContrato;
import cobranca.controlador.acao.AcaoClienteContrato;
import cobranca.controlador.acao.AcaoExcluirContrato;
import cobranca.controlador.acao.AcaoListagemContratos;
import cobranca.controlador.acao.AcaoNovoContrato;
import cobranca.controlador.acao.AcaoSalvaContratos;

@WebServlet(urlPatterns = "/contratos")
public class ContratoControlador extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String acao = req.getParameter("acao");
		String id = req.getParameter("id");
		String cnpj = req.getParameter("cnpj");
		
		if(acao != null) {
//			if(acao.equals("editar")) {
//				AcaoCarregaDadosContrato acaoCarregaDadosBoleto = new AcaoCarregaDadosContrato(req);
//				String pagina = acaoCarregaDadosBoleto.executa();
//				RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
//				dispatcher.forward(req, resp);
//			}
			if(acao.equals("excluir")) {
				if(id != null) {
					String pagina = new AcaoExcluirContrato(req).executa();
					RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
					dispatcher.forward(req, resp);
				}
			}
			if(acao.equals("contratos")) {
				if(cnpj != null) {
					String pagina = new AcaoClienteContrato(req).executa();
					RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
					dispatcher.forward(req, resp);
				}
			}
			if(acao.equals("novoContrato")) {
					String pagina = new AcaoNovoContrato(req).executa();
					RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
					dispatcher.forward(req, resp);
			}
		} else {
			String pagina = new AcaoListagemContratos(req).executa();
			RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
			dispatcher.forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pagina = new AcaoSalvaContratos(req).executa();
		RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
		dispatcher.forward(req, resp);
	}
}
