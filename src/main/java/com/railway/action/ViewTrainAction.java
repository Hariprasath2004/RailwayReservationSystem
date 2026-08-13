package com.railway.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.railway.dao.TrainDAO;
import com.railway.model.Train;

public class ViewTrainAction extends ActionSupport {

    private List<Train> trainList;

    @Override
    public String execute() {

        TrainDAO dao = new TrainDAO();

        trainList = dao.getAllTrains();

        return SUCCESS;
    }

    public List<Train> getTrainList() {
        return trainList;
    }

    public void setTrainList(List<Train> trainList) {
        this.trainList = trainList;
    }
}