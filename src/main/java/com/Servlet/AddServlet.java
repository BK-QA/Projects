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

@WebServlet("/to_do")
public class AddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String todo = req.getParameter("todo");
        String status = req.getParameter("status");

        todoDao dao = new todoDao(DBCon.connectionProvider());
        boolean addedTodo = dao.add_todo(username, todo, status);

        HttpSession session = req.getSession();
        if (addedTodo) {
            session.setAttribute("successMsg", "Todo Added Successfully");
            resp.sendRedirect("index.jsp");
        } else {
            session.setAttribute("failMsg", "Something Wrong on Server ! ");
            resp.sendRedirect("index.jsp");
        }
    }
}
