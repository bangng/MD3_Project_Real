package rikkei.academy.md3_case_study_filmjsp.controller;

import rikkei.academy.md3_case_study_filmjsp.model.videomodel.Video;
import rikkei.academy.md3_case_study_filmjsp.service.video.IVideoService;
import rikkei.academy.md3_case_study_filmjsp.service.video.VideoServiceIMPL;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet( value = {"/video"})
public class VideoServlet extends HttpServlet {
    private IVideoService videoService = new VideoServiceIMPL();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "createV":
                showFormCreateV(request,response);

                break;
            default:
                showListVideo(request,response);
        }
    }

    private void showFormCreateV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/videos/createV.jsp");
        dispatcher.forward(request,response);
    }

    private void showListVideo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Video> videoList = videoService.findAll();

        request.setAttribute("videoList", videoList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/videos/listV.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "createV":
                actionCreateV(request,response);

                break;

        }
    }

    private void actionCreateV(HttpServletRequest request, HttpServletResponse response) {
    }
}
