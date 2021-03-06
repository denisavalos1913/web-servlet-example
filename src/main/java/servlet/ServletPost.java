package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletPost extends HttpServlet {

	private static final long serialVersionUID = -1641096228274971485L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// set response headers
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		// Creacion Formulario HTML via PrintWriter
		PrintWriter writer = response.getWriter();
		writer.append("<!DOCTYPE html>\r\n")
			  .append("<html>\r\n")
			  .append("		<head>\r\n")
			  .append("			<title>Formulario ingreso del nombre</title>\r\n")
			  .append("		</head>\r\n")
			  .append("		<body>\r\n")
			  .append("			<form action=\"welcome\" method=\"POST\">\r\n")
			  .append("				Ingrese su nombre: \r\n")
			  .append("				<input type=\"text\" name=\"user\" />\r\n")
			  .append("				<input type=\"submit\" value=\"Submit\" />\r\n")
			  .append("			</form>\r\n")
			  .append("		</body>\r\n")
			  .append("</html>\r\n");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String user = request.getParameter("user");
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		// Creacion HTML de respuesta
		PrintWriter writer = response.getWriter();
		writer.append("<!DOCTYPE html>\r\n")
			  .append("<html>\r\n")
			  .append("		<head>\r\n")
			  .append("			<title>Mensaje de bienvenida</title>\r\n")
			  .append("		</head>\r\n")
			  .append("		<body>\r\n");
		if (user != null && !user.trim().isEmpty()) {
			writer.append("	Bienvenido " + user + ".\r\n");
			writer.append("	Fin, has completado la operacion.\r\n");
		} else {
			writer.append("	No ingresaste ningun nombre!\r\n");
		}
		writer.append("		</body>\r\n")
			  .append("</html>\r\n");
	}	
	
}
