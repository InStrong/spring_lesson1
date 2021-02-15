package com.geekbrains.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "HomeworkServlet", urlPatterns = "/homework")
public class HomeworkServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(HomeworkServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Log: GET");
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            productList.add(new Product(i + 1,  UUID.randomUUID().toString(), (int) ( Math.random() * 3000)));
            resp.getWriter().printf("<html><body><h2>" + productList.get(i).getId() + " " + productList.get(i).getTitle() + " " + productList.get(i).getCost() + "</h2></body></html>");
        }


    }

}