package com.railway.action;

import com.opensymphony.xwork2.ActionSupport;
import com.railway.dao.TrainDAO;

public class DeleteTrainAction extends ActionSupport {

    private int id;

    @Override
    public String execute() {

        TrainDAO dao = new TrainDAO();

        if (dao.deleteTrain(id)) {
            return SUCCESS;
        }

        return ERROR;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}