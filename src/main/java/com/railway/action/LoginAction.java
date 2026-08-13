package com.railway.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.mindrot.jbcrypt.BCrypt;

import com.opensymphony.xwork2.ActionSupport;
import com.railway.dao.UserDAO;
import com.railway.model.User;

public class LoginAction extends ActionSupport implements SessionAware {

    private String email;
    private String password;

    private Map<String, Object> session;

    @Override
    public String execute() {

        UserDAO dao = new UserDAO();

        User user = dao.getUserByEmail(email);

        if (user != null) {

            if (BCrypt.checkpw(password, user.getPasswordHash())) {

                // Save Logged-in User Details
                session.put("userId", user.getId());
                session.put("userName", user.getName());
                session.put("email", user.getEmail());

                System.out.println("=================================");
                System.out.println("LOGIN SUCCESS");
                System.out.println("User ID   : " + user.getId());
                System.out.println("User Name : " + user.getName());
                System.out.println("=================================");

                return SUCCESS;

            } else {

                addActionError("Invalid Password");
                return ERROR;

            }

        } else {

            addActionError("User Not Found");
            return ERROR;

        }

    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}