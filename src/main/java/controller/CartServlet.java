package controller;

import entity.BookBean;
import entity.Cart;
import repository.Repos;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/cart/add","/cart/remove","/cart/content"})
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getRequestURI();
        if(path.endsWith("add")){
           String idStr = req.getParameter("book_id");
           long id = Long.parseLong(idStr);
           BookBean book = Repos.bookRepo.find(id);
           Cart cart = (Cart) req.getSession().getAttribute("cart");
           if (book != null) {
               cart.add(book);
           }
           resp.sendRedirect(req.getContextPath()+"/book");
        }
        if(path.endsWith("remove")){
            String idStr = req.getParameter("book_id");
            long id = Long.valueOf(idStr);
            BookBean book = Repos.bookRepo.find(id);
            Cart cart = (Cart) req.getSession().getAttribute("cart");
            cart.remove(book);
            resp.sendRedirect(req.getContextPath()+"/book");
        }
        if(path.endsWith("content")){

        }
    }
}
