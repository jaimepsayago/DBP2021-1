package pucese.edu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/reloj")
public class Reloj extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Reloj() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Calendar calendar = GregorianCalendar.getInstance(); //variable con la fecha de hoy
		
String formato = request.getParameter("formato");//obtener parametros desde la url o la vista/pagina web
String hora;

		if ("12".equals(formato)) {
			//formatos del reloj
			 hora = String.format("%s:%s:%s:%s", 
					calendar.get(Calendar.HOUR_OF_DAY),
					calendar.get(Calendar.MINUTE),
					calendar.get(Calendar.SECOND),
					calendar.get(Calendar.AM_PM) == 0 ? "am" : "pm"
					);
			 
		}else {
			 hora = String.format("%s:%s:%s", 
						calendar.get(Calendar.HOUR_OF_DAY),
						calendar.get(Calendar.MINUTE),
						calendar.get(Calendar.SECOND)
				
						);
		}
			
		
	
		
		//imprimir los datos con formato
		out.print(hora);

		out.flush();//obliga al servidor a mostrar la informacion
		
		
		
	}
	
}
