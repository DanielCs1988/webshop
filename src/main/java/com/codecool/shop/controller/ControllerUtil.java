package com.codecool.shop.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

public class ControllerUtil extends HttpServlet {

    public static String requestJsonProcessor(HttpServletRequest req) throws IOException {
        StringBuilder rawData = new StringBuilder();
        BufferedReader reader = req.getReader();
        String input;

        while ((input = reader.readLine()) != null) {
            rawData.append(input);
        }

        return rawData.toString();
    }
}
