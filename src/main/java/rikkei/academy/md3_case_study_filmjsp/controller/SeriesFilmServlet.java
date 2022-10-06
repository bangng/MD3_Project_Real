package rikkei.academy.md3_case_study_filmjsp.controller;

import rikkei.academy.md3_case_study_filmjsp.model.categorymodel.Categories;
import rikkei.academy.md3_case_study_filmjsp.model.seriesfilm.SeriesFilm;
import rikkei.academy.md3_case_study_filmjsp.service.seriesfilm.ISeriesFilmService;
import rikkei.academy.md3_case_study_filmjsp.service.seriesfilm.SeriesFilmServiceIMPL;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(value = "/series")
public class SeriesFilmServlet extends HttpServlet {
    private ISeriesFilmService seriesFilmService = new SeriesFilmServiceIMPL();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "createS":
                showFormCreateS(request,response);
                break;
            case "editS":
                showFormEditS(request,response);
                break;
            case "deleteS":
                showFormDeleteS(request,response);
                break;
            default:
                showListSeriesFilm(request,response);
        }
    }
    private void showFormDeleteS(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        SeriesFilm seriesFilm = seriesFilmService.findById(id);
        request.setAttribute("seriesFilm",seriesFilm);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/seriesfilm/deleteS.jsp");
        dispatcher.forward(request,response);
    }
    private void showFormEditS(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        SeriesFilm seriesFilm = seriesFilmService.findById(id);
        request.setAttribute("seriesFilm",seriesFilm);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/seriesfilm/editS.jsp");
        dispatcher.forward(request,response);
    }

    private void showFormCreateS(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/seriesfilm/createS.jsp");
        dispatcher.forward(request,response);
    }
    private void showListSeriesFilm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<SeriesFilm> seriesFilmList = seriesFilmService.findAll();
        request.setAttribute("seriesFilmList",seriesFilmList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/seriesfilm/listS.jsp");
        dispatcher.forward(request,response);

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "createS":
                try {
                    actionCreateS(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "editS":
                actionEditS(request,response);
                break;
            case "deleteS":
                actionDeleteS(request,response);
                break;
        }
    }
    private void actionDeleteS(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        seriesFilmService.remove(id);
        request.setAttribute("message","delete success!!!");
        request.setAttribute("seriesFilmList",seriesFilmService.findAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/seriesfilm/listS.jsp");
        dispatcher.forward(request,response);
    }

    private void actionEditS(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String newSeriesFilm = request.getParameter("seriesName");
        SeriesFilm seriesFilm = new SeriesFilm(id,newSeriesFilm);
        seriesFilmService.updateVideo(seriesFilm);
        request.setAttribute("message","update success!!");
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/seriesfilm/editS.jsp");
        dispatcher.forward(request,response);
    }
    private void actionCreateS(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String seriesName = request.getParameter("seriesName");
        SeriesFilm seriesFilm = new SeriesFilm(seriesName);
        seriesFilm.setSeriesName(seriesName);
        seriesFilmService.save(seriesFilm);
        request.setAttribute("message", "Success");
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/seriesfilm/createS.jsp");
        dispatcher.forward(request, response);
    }
}
