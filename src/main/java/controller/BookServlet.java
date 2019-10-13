package controller;

import entity.BookBean;
import repository.Repos;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/admin/book")
public class BookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<BookBean> books = Repos.bookRepo.findAll();
        req.setAttribute("books", books);
        req.getRequestDispatcher("/book/books.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String ISBN = req.getParameter("ISBN");
        String publicationYearStr = req.getParameter("publicationYear");
        BookBean bookBean = BookBean.builder().ISBN(ISBN).title(title).publicationYear(Integer.valueOf(publicationYearStr)).build();
        Repos.bookRepo.save(bookBean);
        resp.sendRedirect(req.getContextPath()+"/admin/book");
    }
}
