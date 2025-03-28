package com.Servlet;

import com.DB.DBCon;
import com.Dao.todoDao;
import com.entity.entities;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(value = "/updateTodo" , name = "updateTodo" )
public class updateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String username = req.getParameter("username");
        String todo = req.getParameter("todo");
        String status = req.getParameter("status");
        todoDao dao = new todoDao(DBCon.connectionProvider());

        com.entity.entities t = new entities();
        t.setId(id);
        t.setName(username);
        t.setTodo(todo);
        t.setStatus(status);
        boolean b = dao.updateTodo(t);

        HttpSession session = req.getSession();

        if (b){
            session.setAttribute("successMsg", "Todo Updated Successfully");
            resp.sendRedirect("index.jsp");
        }else {
            session.setAttribute("failMsg", "Something Wrong on Server ! ");
            resp.sendRedirect("index.jsp");
        }

    }
}
