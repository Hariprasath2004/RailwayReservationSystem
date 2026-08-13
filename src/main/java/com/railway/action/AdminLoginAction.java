package com.railway.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.mindrot.jbcrypt.BCrypt;

import com.opensymphony.xwork2.ActionSupport;
import com.railway.dao.AdminDAO;
import com.railway.model.Admin;

public class AdminLoginAction extends ActionSupport implements SessionAware {

    private String email;
    private String password;

    private Map<String, Object> session;

    @Override
    public String execute() {

        AdminDAO dao = new AdminDAO();

        Admin admin = dao.getAdminByEmail(email);

        if (admin != null) {

            if (BCrypt.checkpw(password, admin.getPasswordHash())) {

                session.put("adminId", admin.getId());
                session.put("adminName", admin.getName());

                System.out.println("=================================");
                System.out.println("ADMIN LOGIN SUCCESS");
                System.out.println("Admin : " + admin.getName());
                System.out.println("=================================");

                return SUCCESS;

            } else {

                addActionError("Invalid Password");
                return ERROR;

            }

        } else {

            addActionError("Admin Not Found");
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