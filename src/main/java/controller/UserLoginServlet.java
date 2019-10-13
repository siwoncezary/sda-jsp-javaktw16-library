package controller;

import repository.Repos;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

@WebServlet("/user/login")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.getRequestDispatcher("/user/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String login = req.getParameter("login");
       String password = req.getParameter("password");
       AtomicBoolean logged = new AtomicBoolean(false);
       Repos.userRepo.findByLogin(login).ifPresent(user->{
            if (password != null){
                if (password.equals(user.getPassword())){
                    req.getSession().setAttribute("user", user);
                    try {
                        logged.set(true);
                        resp.sendRedirect(req.getContextPath()+"/");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
       });
       if (!logged.get()){
           resp.sendRedirect(req.getContextPath()+"/error.html");
       }
    }
}
