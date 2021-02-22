package cobranca.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cobranca.controlador.acao.AcaoCarregaDadosBoleto;
import cobranca.controlador.acao.AcaoExcluirBoleto;
import cobranca.controlador.acao.AcaoListagemBoletos;
import cobranca.controlador.acao.AcaoSalvaBoletos;

@WebServlet(urlPatterns = "/boletos")
public class BoletoControlador extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String acao = req.getParameter("acao");
		String codigo = req.getParameter("codigo");
		if(acao != null) {
			if(acao.equals("editar")) {
				AcaoCarregaDadosBoleto acaoCarregaDadosBoleto = new AcaoCarregaDadosBoleto(req);
				String pagina = acaoCarregaDadosBoleto.executa();
				RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
				dispatcher.forward(req, resp);
			}
			if(acao.equals("excluir")) {
				if(codigo != null) {
					String pagina = new AcaoExcluirBoleto(req).executa();
					RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
					dispatcher.forward(req, resp);
				}
			}
		} else {
			String pagina = new AcaoListagemBoletos(req).executa();
			RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
			dispatcher.forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pagina = new AcaoSalvaBoletos(req).executa();
		RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
		dispatcher.forward(req, resp);
	}
}
