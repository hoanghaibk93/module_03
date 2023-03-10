import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

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
                try{
                    result = firstNumber / secondNumber;
                } catch (ArithmeticException e){
                    e.getMessage();
                }
                break;
            default:
                System.out.println("Check again");
                break;
        }
//        PrintWriter printWriter = response.getWriter();
//        printWriter.print("<h1>Result:</h1>");
//        printWriter.print("<h3>" + firstNumber + " "+ operator+ " " + secondNumber + " = " + result + "</h3>");
        request.setAttribute("resultCalculator", result);
        request.setAttribute("first", firstNumber);
        request.setAttribute("second", secondNumber);
        request.setAttribute("operatorCalculator", operator);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
