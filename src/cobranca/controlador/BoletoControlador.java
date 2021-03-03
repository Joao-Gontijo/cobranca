package cobranca.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cobranca.controlador.acao.AcaoRetornaContratos;
import cobranca.controlador.acao.AcaoGeraBoleto;

@WebServlet(urlPatterns = "/boletos")
public class BoletoControlador extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String acao = req.getParameter("acao");
		String id = req.getParameter("id");
		
		if(acao != null) {
			if(acao.equals("gerar")) {
				if(id != null) {
					String pagina = new AcaoGeraBoleto(req).executa();
					RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
					dispatcher.forward(req, resp);
				}
			}
			if(acao.equals("contratos")) {
				String pagina = new AcaoRetornaContratos(req).executa();
				RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
				dispatcher.forward(req, resp);
			}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}
