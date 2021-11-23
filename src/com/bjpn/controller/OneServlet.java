package com.bjpn.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OneServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String wstr= request.getParameter("w");
        String hstr= request.getParameter("h");
        float w = Float.valueOf(wstr);
        float h = Float.valueOf(hstr);
        float bmi = w/(h*h);

        String msg="";
        if(bmi<=18.5){
            msg = "较瘦";
        }else if(bmi>18.5 &&bmi<=23.9){
            msg = "正常";
        }else if(bmi>24 && bmi<=27){
            msg = "较胖";
        }else{
            msg = "肥胖";
        }
        msg = name +" bmi:"+ msg;
        request.setAttribute("key1",msg);
        request.getRequestDispatcher("/index2.jsp").forward(request,response);
    }
}
