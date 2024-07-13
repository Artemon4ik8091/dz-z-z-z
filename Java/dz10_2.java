import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        String operation = request.getParameter("operation");
        double num1 = Double.parseDouble(request.getParameter("num1"));
        double num2 = Double.parseDouble(request.getParameter("num2"));
        double result = 0;

        switch(operation){
            case "add":
                result = num1 + num2;
                break;
            case "subtract":
                result = num1 - num2;
                break;
            case "multiply":
                result = num1 * num2;
                break;
            case "divide":
                result = num1 / num2;
                break;
            case "power":
                result = Math.pow(num1, num2);
                break;
            case "percentage":
                result = (num1 * num2) / 100;
                break;
            default:
                response.getWriter().println("Invalid operation");
                return;
        }

        response.getWriter().println("Result: " + result);
    }
}