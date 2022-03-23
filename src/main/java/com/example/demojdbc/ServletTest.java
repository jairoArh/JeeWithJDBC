package com.example.demojdbc;

import com.example.logic.Student;
import com.example.logic.TypeGender;
import com.example.persistence.StudentDAOFactoty;
import com.example.persistence.StudentDAOImpl;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "servletTest", value = "/servlet-test")
public class ServletTest extends HttpServlet {
    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json");
        List<Student> students = Arrays.asList(new Student("43563","Barrera Pinto","Daniela", TypeGender.FEMENINO,"Sogamoso", LocalDate.of(2000, Month.AUGUST,25),"danielita2000@gmail.com",450_000),
                new Student("65747","Martinez Salcedo","Juan José", TypeGender.FEMENINO,"Duitama", LocalDate.of(1986, Month.MAY,10),"lola@gmail.com",450_000),
                new Student("23464","Lopez Herrera","Maria Alejandra", TypeGender.MASCULINO,"Paipa", LocalDate.of(1990, Month.DECEMBER,18),"maaleja@gmail.com",450_000));

        Gson gson = new Gson();
        String stAux = gson.toJson( students );
        String code = request.getParameter("code");
        try(
                PrintWriter out = response.getWriter();
                ){
            out.println(stAux);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        String code = request.getParameter("code");
        String surname = request.getParameter("surname");
        String name = request.getParameter("name");
        try( PrintWriter out = response.getWriter()){
            out.println( code + " " + surname + " " + name );
        }
    }
}
