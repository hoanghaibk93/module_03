import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;

@WebServlet(name = "CalculatorServlet", value = "/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float firstNumber = Float.parseFloat(request.getParameter("first"));
        float secondNumber = Float.parseFloat(request.getParameter("second"));
        float result = 0;
        PrintWriter writer = response.getWriter();
        String operator = request.getParameter("Operator");
        switch (operator) {
            case "Addition":
                result = firstNumber + secondNumber;
                break;
            case "Subtraction":
                result = firstNumber - secondNumber;
                break;
            case "Multiplication":
                result = firstNumber * secondNumber;
                break;
            case "Division":
                if (secondNumber != 0) {
                    result = firstNumber / secondNumber;
                } else {
                    try {
                        throw new ArithmeticException("Error: /by zero");
                    } catch (ArithmeticException e) {
                        writer.println(e.getMessage());
                    }
                }
                break;
            default:
                throw new RuntimeException();
        }
        request.setAttribute("resultCalculator", result);
        request.setAttribute("first", firstNumber);
        request.setAttribute("second", secondNumber);
        request.setAttribute("operatorCalculator", operator);
        if (operator.equals("Division") && secondNumber == 0) {
        } else {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}
