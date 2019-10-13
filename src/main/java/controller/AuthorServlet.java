package controller;

import entity.AuthorBean;
import entity.BookBean;
import repository.Repos;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/admin/author")
public class AuthorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookIdStr = req.getParameter("book_id");
        if (bookIdStr == null) {
            List<AuthorBean> authors = Repos.authorRepo.findAll();
            req.setAttribute("authors", authors);
            //TODO dodać atrybut z danymi do formularza
            req.getRequestDispatcher("/author/authors.jsp").forward(req, resp);
        } else {
            long bookId = Long.valueOf(bookIdStr);
            BookBean bookBean = Repos.bookRepo.find(bookId);
            req.setAttribute("book", bookBean);
            req.setAttribute("authors", Repos.authorRepo.findAll());
            req.getRequestDispatcher("/author/authors.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String country = req.getParameter("country");
        AuthorBean authorBean = new AuthorBean();
        authorBean.setName(name);
        authorBean.setCountry(country);
        Repos.authorRepo.save(authorBean);

        String bookIdStr = req.getParameter("book_id");
        resp.sendRedirect(req.getContextPath()+"/admin/author"+(bookIdStr != null? "?book_id="+bookIdStr:""));
    }
}
