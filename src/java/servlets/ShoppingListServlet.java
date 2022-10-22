/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author musta
 */
public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("test");
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        String action = req.getParameter("action");
        
        if (action != null && action.equals("logout")) {
            session.invalidate();
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(req, resp);
            return;
        }
        
        if(username == null || username.equals("")) {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(req, resp);
            return;
        }
        
        ArrayList<String> items = (ArrayList<String>) session.getAttribute("items");
        if(items == null)
            items = new ArrayList<String>();
        session.setAttribute("items", items);
        
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(req, resp);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String action = req.getParameter("action");
        
        if(action != null && action.equals("login")) {
            session.setAttribute("username", req.getParameter("username"));
            System.out.println(req.getParameter("username"));
            resp.sendRedirect("");
            return;
        }
        if(action != null && action.equals("add")) {
            ArrayList<String> items = (ArrayList<String>) session.getAttribute("items");
            items.add(req.getParameter("item"));
            session.setAttribute("items", items);
            resp.sendRedirect("");
            return;
        }
        if(action != null && action.equals("delete")) {
            ArrayList<String> items = (ArrayList<String>) session.getAttribute("items");
            items.remove(Integer.parseInt(req.getParameter("item")));
            session.setAttribute("items", items);
            resp.sendRedirect("");
            System.out.println(req.getParameter("item"));
            return;
        }
    }
    
    
}