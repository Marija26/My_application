package controller;

import dao.UserDao;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Admin on 06.07.2017.
 */
public class UserController extends HttpServlet {
    private UserDao dao;
    private static final String USER_LIST = "userList.jsp";
    private static final String USER_EDIT = "userEdit.jsp";

    public UserController() {
        this.dao = new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String forward = "";
        String action = req.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {
            int userId = Integer.parseInt(req.getParameter("userId"));
            dao.deleteUser(userId);
            forward = USER_LIST;
            req.setAttribute("users", dao.getAllUsers());
        } else if (action.equalsIgnoreCase("edit")) {
            forward = USER_EDIT;
            int userId = Integer.parseInt(req.getParameter("userId"));
            User user = dao.getUserById(userId);
            req.setAttribute("user", user);
        } else if (action.equalsIgnoreCase("listUser")) {
            forward = USER_LIST;
            req.setAttribute("users", dao.getAllUsers());
        } else forward = USER_EDIT;

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(forward);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));
        try{
            Date dob = new SimpleDateFormat("MM/dd/yyyy").parse(req.getParameter("dob"));
            user.setDob(dob);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setEmail(req.getParameter("email"));
        String userId = req.getParameter("userid");
        if(userId == null || userId.isEmpty()){
            dao.addUser(user);
        }else {
            user.setUserid(Integer.parseInt(userId));
            dao.updateUser(user);
        }

        RequestDispatcher rd = req.getRequestDispatcher(USER_LIST);
        req.setAttribute("users", dao.getAllUsers());
        rd.forward(req, resp);
    }
}
