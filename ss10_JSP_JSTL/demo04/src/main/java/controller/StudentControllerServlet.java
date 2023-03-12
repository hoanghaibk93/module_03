package controller;

import model.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentControllerServlet", value = "/student")
public class StudentControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(6,"HaiTT","09/11/1990",1,6.0));
        studentList.add(new Student(6,"TrungDC","09/11/1990",0,7.0));
        studentList.add(new Student(6,"CongNT","09/11/1990",1,8.0));
        studentList.add(new Student(6,"TienTT","09/11/1990",1,9.0));
        studentList.add(new Student(6,"HaiTT","09/11/1990",1,10.0));
        request.setAttribute("listStudent",studentList);
        request.getRequestDispatcher("/view/list.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
