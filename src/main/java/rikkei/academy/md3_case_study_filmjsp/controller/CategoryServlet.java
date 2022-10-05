package rikkei.academy.md3_case_study_filmjsp.controller;

import rikkei.academy.md3_case_study_filmjsp.model.categorymodel.Categories;
import rikkei.academy.md3_case_study_filmjsp.service.categoty.CategoryServiceIMPL;
import rikkei.academy.md3_case_study_filmjsp.service.categoty.ICategoryService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(value = {"/", "/cate"})
public class CategoryServlet extends HttpServlet {
    private ICategoryService categorySerVice = new CategoryServiceIMPL();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "createC":
                showFormCreateC(request,response);
                break;
            case "editC":
                showFormEditC(request,response);
                break;
            case "deleteC":
                showFormDeleteC(request,response);
                break;

            default:
                showListCate(request, response);

        }

    }

    private void showFormDeleteC(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Categories categories = categorySerVice.findById(id);
        request.setAttribute("categories",categories);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/categories/deleteC.jsp");
        dispatcher.forward(request,response);

    }

    private void showFormEditC(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Categories categories = categorySerVice.findById(id);
        request.setAttribute("categories",categories);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/categories/editC.jsp");
        dispatcher.forward(request,response);
    }

    private void showFormCreateC(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/categories/createC.jsp");
        dispatcher.forward(request,response);
    }

    private void showListCate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        List<Categories> categoriesList = categorySerVice.findAll();

        request.setAttribute("categoriesList", categoriesList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/categories/listC.jsp");
        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";

        }
        switch (action) {
            case "createC":
                actionCreateC(request, response);
                break;
            case "editC":
                actionEditC(request,response);
                break;
            case "deleteC":
                actionDeleteC(request,response);
                break;

        }

    }

    private void actionDeleteC(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        categorySerVice.remove(id);
        request.setAttribute("message","Delete success!!");
        request.setAttribute("categories",categorySerVice.findAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/categories/listC.jsp");
        dispatcher.forward(request,response);



    }

    private void actionEditC(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String newCategory = request.getParameter("category");
        Categories categories = new Categories(id,newCategory);
        categorySerVice.updateCategory(categories);

        request.setAttribute("message","update success!!");
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/categories/editC.jsp");
        dispatcher.forward(request,response);

    }

    private void actionCreateC(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String category = request.getParameter("category");

        Categories categories = new Categories(category);
        categories.setCategory(category);
        categorySerVice.save(categories);
        System.out.println(categories);
        request.setAttribute("message", "Success");
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/categories/createC.jsp");
        dispatcher.forward(request, response);


    }

}