import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;

@WebServlet("/add")
public class Controller extends HttpServlet {
    private static final String operand1 = "operand1";
    private static final String operand2 = "operand2";

    public Controller() {
    }
    /*
    Modify SO that the result of the addition operation will be evaluated
    right after entering valid input without explicitly submitting the parameters by pressing <Enter> or clicking the button.
    The evaluation should be based on AJAX – i.e. it should be started by JavaScript right after one of the input text field loses focus
     */

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String input1=request.getParameter(operand1);
        String input2=request.getParameter(operand2);

        BigInteger para1=new BigInteger(input1);
        BigInteger para2=new BigInteger(input2);

        BigInteger sum=para1.add(para2);

        PrintWriter writer= response.getWriter();
        writer.println(sum);
        writer.close();



//        int param1 = Integer.parseInt(request.getParameter(operand1));
//        int param2 = Integer.parseInt(request.getParameter(operand2));
//
//

       // Model model = new Logic(param1, param2).getModel();


//        ServletContext context = getServletContext();
//        request.setAttribute("model", model);
//
//        RequestDispatcher dispatcher = context.getRequestDispatcher("/result");
//        dispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)throws  ServletException, IOException{
        service(request,response);
    }

}