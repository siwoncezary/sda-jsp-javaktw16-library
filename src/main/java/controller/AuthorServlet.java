package controller;

import entity.AuthorBean;
import repository.Repos;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/author")
public class AuthorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String country = req.getParameter("country");
        name = "ADAM SLODOWY";
        country = "POLAND";
        AuthorBean authorBean = new AuthorBean();
        authorBean.setName(name);
        authorBean.setCountry(country);
        Repos.authorRepo.save(authorBean);
    }
}
