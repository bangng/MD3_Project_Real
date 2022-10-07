package rikkei.academy.md3_case_study_filmjsp.controller;

import rikkei.academy.md3_case_study_filmjsp.service.user.IUserService;
import rikkei.academy.md3_case_study_filmjsp.service.user.UserServiceIMPL;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet( name = "UploadVideoServlet", value = "/mp3" )
public class ServletCreateMP3Controller extends HttpServlet {
    IUserService userService = new UserServiceIMPL();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                showUploadMP3(response,request);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                actionUploadMP3(request,response);
                break;
        }

    }
    public void showUploadMP3(HttpServletResponse response ,HttpServletRequest request) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/upload/upload.file.jsp");
        dispatcher.forward(request,response);
    }
    public void actionUploadMP3(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String mp3 = request.getParameter("mp3");
        request.setAttribute("mp3",mp3);
        userService.createVideo(mp3);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/index.jsp");
        dispatcher.forward(request,response);
    }
}
