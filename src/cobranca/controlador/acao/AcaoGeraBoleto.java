package cobranca.controlador.acao;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfWriter;

import cobranca.entidade.Boleto;
import cobranca.entidade.Contrato;
import cobranca.services.BoletoDAO;
import cobranca.services.ContratoDAO;
import cobranca.util.Utilitario;

public class AcaoGeraBoleto {

	private HttpServletRequest req;

	public AcaoGeraBoleto(HttpServletRequest req) {
		this.req = req;
	}

	public String executa() {

		String idContrato = req.getParameter("id");
		
		Contrato contrato = new ContratoDAO().getContrato(Long.parseLong(idContrato));

//		List<Contrato> lista = new ContratoDAO().lista();
		
		Boleto boleto = new Boleto();
		Date data = new Date();
		boleto.setData(data);
		boleto.setCodigo(Utilitario.geraCodigo());
		boleto.setContrato(contrato);

		BoletoDAO bdao = new BoletoDAO();
		bdao.salvar(boleto);

		Document documento = new Document(PageSize.A4, 210, 297, 0, 0);

		try {
			PdfWriter pdf = PdfWriter.getInstance(documento, new FileOutputStream("boleto.pdf"));
			documento.open();

			Paragraph pnome = new Paragraph("Nome do cliente: " + boleto.getContrato().getCliente().getNome());
//			Paragraph pcodigoContrato = new Paragraph("Numero de Contrato: " + boleto.getContrato().getCodigo());
			Paragraph pservico = new Paragraph("Servico: " + boleto.getContrato().getServico().getNome());

			Barcode128 code = new Barcode128();
			code.setCode(boleto.getCodigo());
			Image img = code.createImageWithBarcode(pdf.getDirectContent(), BaseColor.BLACK, BaseColor.BLACK);

			img.scalePercent(300);

			documento.add(pnome);
//			documento.add(pcodigoContrato);
			documento.add(pservico);

			documento.add(img);
			documento.close();

			try {
				Desktop.getDesktop().open(new File("boleto.pdf"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			
		}
		
		String pagina = new AcaoRetornaContratos(req).executa();
		return pagina;
	}
}
