package com.codecool.shop.controller;

import com.codecool.shop.dao.UserDao;
import com.codecool.shop.dao.implementation.UserDaoPSQL;
import com.codecool.shop.model.PasswordStorage;
import com.codecool.shop.model.User;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/webshop/login"})
public class UserLoginController extends HttpServlet {

    private Gson gson = new Gson();
    private UserDao userDataStore = new UserDaoPSQL();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String input = req.getParameter("user");
        User currentUser = gson.fromJson(input, User.class);
        PrintWriter out = resp.getWriter();
        boolean passwordIsValid = PasswordStorage.verifyPassword(currentUser.getPassword(), userDataStore.find(currentUser.getName()).getPassword());
        if(userDataStore.find(currentUser.getName()) == null || !passwordIsValid) {
            out.print(gson.toJson(null));
        }
        else {
            out.print(gson.toJson(userDataStore.find(currentUser.getName())));
        }
    }
}