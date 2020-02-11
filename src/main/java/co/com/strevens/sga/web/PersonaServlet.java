
package co.com.strevens.sga.web;

import co.com.strevens.sga.domain.Persona;
import co.com.strevens.sga.servicio.PersonaService;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/personas")
public class PersonaServlet extends HttpServlet{
    
    @Inject
    PersonaService personaService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Persona> personas = personaService.listarPersona();
        System.out.println("personas" + personas);
        request.setAttribute("personas", personas);//personas usado en el jsp
        request.getRequestDispatcher("/listadoPersonas.jsp").forward(request, response);
        
    }
}
