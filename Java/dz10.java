import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QuoteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String quote = "Bad programmers worry about the code. Good programmers worry about data structures and their relationships";

        response.getWriter().println("<html>");
        response.getWriter().println("<head><title>Quote by Linus Torvalds</title></head>");
        response.getWriter().println("<body>");
        response.getWriter().println("<h2>Quote by Linus Torvalds</h2>");
        response.getWriter().println("<p>" + quote + "</p>");
        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
    }
}