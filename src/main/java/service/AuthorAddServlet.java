package service;
import entity.AuthorBean;
import entity.BookBean;
import repository.Repos;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/admin/book/addAuthor")
public class AuthorAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookIdStr = req.getParameter("book_id");
        String authorIdStr = req.getParameter("author_id");
        long bookId = Long.valueOf(bookIdStr);
        long authorId = Long.valueOf(authorIdStr);
        BookBean book = Repos.bookRepo.find(bookId);
        AuthorBean author = Repos.authorRepo.find(authorId);
        book.getAuthors().add(author);
        Repos.bookRepo.update(book);
        resp.sendRedirect(req.getContextPath()+"/admin/book");
    }
}
