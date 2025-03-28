package com.Servlet;

import com.DB.DBCon;
import com.Dao.todoDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "deleteTodo", value = "/deleteTodo")
public class deleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        com.Dao.todoDao dao = new todoDao(DBCon.connectionProvider());

        boolean b = dao.deleteToDoById(id);
        HttpSession session = req.getSession();

        if (b) {
            session.setAttribute("successMsg", "Todo Deleted Successfully");
            resp.sendRedirect("index.jsp");
        } else {
            session.setAttribute("failMsg", "Something Wrong on Server ! ");
            resp.sendRedirect("index.jsp");
        }
    }
}
