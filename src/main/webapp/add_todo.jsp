<%--
  Created by IntelliJ IDEA.
  User: Bilal Khan
  Date: 3/18/2025
  Time: 7:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page errorPage="component/error.jsp" %>

<html>
<head>
    <title>Add Todo</title>
</head>
<%@include file="component/all_css_boot_nav.jsp" %>
<body>
<%@include file="component/navbar.jsp" %>
<div class="container ">
    <div class="row p-5 m-2">
        <div class="col-md-6 offset-md-3">
            <div class="card">
                <div class="card-body shadow-lg bg-body rounded">
                    <%

                    %>
                    <h2 class="text-center text-success fw-bold">Add ToDo</h2>
                    <form action="to_do" method="post">
                        <div class="mb-3">
                            <label for="exampleInputEmail1" class="form-label text-dark">Name</label>
                            <input type="text" class="form-control" id="exampleInputEmail1"
                                   aria-describedby="emailHelp" name="username" placeholder="Enter your name" required>
                            <%--                <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>--%>
                        </div>

                        <div class="mb-3">
                            <label for="exampleInputPassword1" class="form-label text-dark text-wrap">Todo</label>
                            <input type="text" class="form-control" id="exampleInputPassword1" name="todo"
                                   placeholder="Enter your task " required>
                        </div>
                        <select class="form-select p-2" aria-label="Default select example" name="status">
                            <option selected>Status</option>
                            <option value="Complete">Completed</option>
                            <option value="Pending....">---Pending---</option>
                        </select>

                        <div class="text-center p-4 m-2">
                            <button type="submit" class="btn btn-outline-primary">Add</button>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

