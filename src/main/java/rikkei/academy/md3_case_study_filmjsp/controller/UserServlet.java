package rikkei.academy.md3_case_study_filmjsp.controller;

import rikkei.academy.md3_case_study_filmjsp.model.usermodel.Role;
import rikkei.academy.md3_case_study_filmjsp.model.usermodel.RoleName;
import rikkei.academy.md3_case_study_filmjsp.model.usermodel.User;
import rikkei.academy.md3_case_study_filmjsp.service.role.IRoleService;
import rikkei.academy.md3_case_study_filmjsp.service.role.RoleServiceIMPL;
import rikkei.academy.md3_case_study_filmjsp.service.user.IUserService;
import rikkei.academy.md3_case_study_filmjsp.service.user.UserServiceIMPL;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

@WebServlet(value = {"/", "/users"})
public class UserServlet extends HttpServlet {

    private IRoleService roleService = new RoleServiceIMPL();
    private IUserService userService = new UserServiceIMPL();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String action = request.getParameter("action");
        if(action==null){
            action="";
        }
        switch (action){
            case "register":
                showFormRegister(request,response);
                break;
            case "login":
                showFormLogin(request,response);
                break;
            case "logout":
                logOut(request,response);
                break;
            case "change_avatar":
                showUpLoadAvatar(request,response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String action = request.getParameter("action");
        if(action==null){
            action="";
        }
        switch (action){
            case "register":
                try {
                    actionRegister(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "login":
                actionLogin(request,response);
                break;
            case "change_avatar":
                actionUpLoadAvatar(request,response);
                break;
        }
    }

    public void destroy() {
    }

    public void showUpLoadAvatar(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/upload/upload.avatar.jsp");
        dispatcher.forward(request,response);
    }
    public void actionUpLoadAvatar(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String avatar = request.getParameter("avatar");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int id = user.getId();
        userService.changeAvatar(id,avatar);
        request.setAttribute("avatar",avatar);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/profile/profile.jsp");
        dispatcher.forward(request,response);

    }

    public void showFormRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/form-login/register.jsp");
        dispatcher.forward(request,response);
    }
    public void actionRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String role = "user";
        Set<String> strRole = new HashSet<>();
        Set<Role> roles = new HashSet<>();
        strRole.add(role);
        strRole.forEach(role1->{
            switch (role1){
                case "admin":
                    Role adminRole = roleService.findByName(RoleName.ADMIN);
                    roles.add(adminRole);
                    break;
                case "pm":
                    Role pmRole = roleService.findByName(RoleName.PM);
                    roles.add(pmRole);
                    break;
                default:
                    Role userRole = roleService.findByName(RoleName.USER);
                    roles.add(userRole);
            }
        });
        System.out.println("roles set ---> "+roles);
        String name = request.getParameter("name");
        String username = request.getParameter("username");
        if(userService.existedByUsername(username)){
            request.setAttribute("message", "The username existed! Please try again!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/form-login/register.jsp");
            dispatcher.forward(request,response);

        }
        String email = request.getParameter("email");
        if(userService.existedByEmail(email)){
            request.setAttribute("message", "The email existed! Please try again!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/form-login/register.jsp");
            dispatcher.forward(request,response);

        }
        String password = request.getParameter("password");
        String confirm_pass = request.getParameter("repeat_pass");
        if(!password.equals(confirm_pass)){
            request.setAttribute("message", "The password do not match!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/form-login/register.jsp");
            dispatcher.forward(request,response);
            return;
        }
        User user = new User(name,username,email,password,roles);
        userService.save(user);
        request.setAttribute("success", "Create user success!!");
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/form-login/register.jsp");
        dispatcher.forward(request,response);
    }

    public void showFormLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/form-login/login.jsp");
        dispatcher.forward(request,response);
    }
    public void actionLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.findByUsernameAndPassword(username,password);
        String pageJSP = "";
        if(user!=null){
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            System.out.println("get userlogin ---> "+session.getAttribute("user"));
            pageJSP = "WEB-INF/profile/profile.jsp";
        } else {
            pageJSP = "WEB-INF/form-login/login.jsp";
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(pageJSP);
        dispatcher.forward(request,response);
    }


    public void logOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if(session!=null){
            session.removeAttribute("user");
            session.invalidate();
            response.sendRedirect("index.jsp");
        }
    }
}