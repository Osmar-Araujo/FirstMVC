package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import javax.el.*;

import model.Usuario;


@WebServlet("/ShowUserServlet")
public class ShowUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ShowUserServlet() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pUser = request.getParameter("user");
		String pSenha = request.getParameter("senha");
		String pModo = request.getParameter("modo");
		
		System.out.println("User = "+pUser);
		System.out.println("Senha = "+pSenha);
		System.out.println("Modo = "+pModo);
		
		String pagina = "/erro.jsp";
		
		if (pUser.equals("Osmar") && pSenha.equals("1234")) {
			Usuario u = new Usuario();
			u.setId(1010);
			u.setUsername("osmar");
			u.setFullname("Osmar Araujo");
			u.setEmail("osmar@osmararaujo.com.br");
			request.setAttribute("Usuario", u);
			
			if (pModo.equals("html")) {
			request.setAttribute("Usuario", u);
			pagina = "/ok.jsp";
			}else {
				Gson gson = new Gson();
				String resultado = gson.toJson(u);
				request.setAttribute("UsuarioJSON", resultado);
				pagina = "/result.jsp";
			}
		}
		
		RequestDispatcher dispatcher;
		dispatcher = getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}

}
