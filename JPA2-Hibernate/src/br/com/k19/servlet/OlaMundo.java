package br.com.k19.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @WebService("/OlaMundo")
public class OlaMundo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {

		// processando regras de negócio e gerando conteúdo
		PrintWriter writer = resp.getWriter();
		writer.println("<html><body><h1>Olá Mundo</h1></body></html>");
	}

}
