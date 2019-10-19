package controller;

import entity.BookBean;
import entity.Cart;
import entity.RentBean;
import entity.UserBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.registry.infomodel.User;
import java.io.IOException;

@WebServlet(urlPatterns = "/rent")
public class RentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserBean user = (UserBean) req.getSession().getAttribute("user");
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        for (BookBean item: cart.getBooks()){
            RentBean rent = new RentBean();
            rent.setBook(item);
            rent.setUser(user);

        }
    }
}
