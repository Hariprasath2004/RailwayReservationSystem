package com.railway.action;

import org.mindrot.jbcrypt.BCrypt;

import com.opensymphony.xwork2.ActionSupport;
import com.railway.dao.UserDAO;
import com.railway.model.User;

public class RegisterAction extends ActionSupport {

    private String name;
    private String email;
    private String password;

    @Override
    public String execute() {

        User user = new User();

        user.setName(name);
        user.setEmail(email);

        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        user.setPasswordHash(hashedPassword);

        UserDAO dao = new UserDAO();

        boolean success = dao.register(user);

        if (success) {
            return SUCCESS;
        } else {
            addActionError("Registration Failed");
            return ERROR;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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