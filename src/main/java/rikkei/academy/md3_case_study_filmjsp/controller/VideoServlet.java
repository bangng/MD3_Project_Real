package rikkei.academy.md3_case_study_filmjsp.controller;

import rikkei.academy.md3_case_study_filmjsp.model.categorymodel.Categories;
import rikkei.academy.md3_case_study_filmjsp.model.videomodel.Video;
import rikkei.academy.md3_case_study_filmjsp.service.categoty.CategoryServiceIMPL;
import rikkei.academy.md3_case_study_filmjsp.service.categoty.ICategoryService;
import rikkei.academy.md3_case_study_filmjsp.service.video.IVideoService;
import rikkei.academy.md3_case_study_filmjsp.service.video.VideoServiceIMPL;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet( value = {"/video"})
public class VideoServlet extends HttpServlet {
    private IVideoService videoService = new VideoServiceIMPL();
    private ICategoryService categoryService = new CategoryServiceIMPL();

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
            case "editV":
                showFormEditV(request,response);
                break;
            case "deleteV":
                showFormDeleteV(request,response);
                break;
            default:
                showListVideo(request,response);
        }
    }

    private void showFormDeleteV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        videoService.remove(id);
        request.setAttribute("message","Delete success!!");
        request.setAttribute("videoList",videoService.findAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/videos/listV.jsp");
        dispatcher.forward(request,response);
    }

    private void showFormEditV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Video video = videoService.findById(id);

        request.setAttribute("videoList",video);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/videos/editV.jsp");
        dispatcher.forward(request,response);

    }

    private void showFormCreateV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        categoryService.findAll();
        request.setAttribute("categoriesList",categoryService.findAll());
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
                try {
                    actionCreateV(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "editV":
                actionEditV(request,response);
                break;
            case "deleteV":
                actionDeleteV(request,response);
                break;

        }
    }

    private void actionDeleteV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        videoService.remove(id);
        request.setAttribute("message","Delete success!!");
        request.setAttribute("videoList",videoService.findAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/videos/listV.jsp");
        dispatcher.forward(request,response);
    }

    private void actionEditV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String newVideoName = request.getParameter("videoName");
        String dateByVideo = request.getParameter("dateByVideo");
        String country = request.getParameter("country");
        Video video = new Video(id,newVideoName,dateByVideo,country);
        videoService.updateVideo(video);
        request.setAttribute("message","update success!!");
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/videos/editV.jsp");
        dispatcher.forward(request,response);
    }

    private void actionCreateV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String videoName = request.getParameter("videoName");
        String dateByVideo = request.getParameter("dateByVideo");
        String country = request.getParameter("country");
        Set<Categories> categories = new HashSet<>();

        Video video = new Video(videoName,dateByVideo,country,categories);
        video.setVideoName(videoName);
        video.setDateByVideo(dateByVideo);
        video.setCountry(country);
        video.setCategoriesSet(categories);
        videoService.save(video);
        request.setAttribute("message", "Success");
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/videos/createV.jsp");
        dispatcher.forward(request, response);

    }
}
