import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MathOperationsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String operation = request.getParameter("operation");
        String param1 = request.getParameter("number1");
        String param2 = request.getParameter("number2");
        String param3 = request.getParameter("number3");

        int num1 = Integer.parseInt(param1);
        int num2 = Integer.parseInt(param2);
        int num3 = Integer.parseInt(param3);

        int result = 0;

        switch (operation) {
            case "max":
                result = Math.max(num1, Math.max(num2, num3));
                break;
            case "min":
                result = Math.min(num1, Math.min(num2, num3));
                break;
            case "average":
                result = (num1 + num2 + num3) / 3;
                break;
        }

        response.getWriter().println("<html>");
        response.getWriter().println("<head><title>Math Operations Calculator</title></head>");
        response.getWriter().println("<body>");
        response.getWriter().println("<h2>Numbers Entered:</h2>");
        response.getWriter().println("<p>Number 1: " + num1 + "</p>");
        response.getWriter().println("<p>Number 2: " + num2 + "</p>");
        response.getWriter().println("<p>Number 3: " + num3 + "</p>");
        response.getWriter().println("<h2>Result:</h2>");
        response.getWriter().println("<p style='color:blue; font-size:20px;'><strong>" + result + "</strong></p>");
        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
    }
}