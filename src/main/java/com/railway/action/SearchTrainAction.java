package com.railway.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.railway.dao.TrainDAO;
import com.railway.model.Train;

public class SearchTrainAction extends ActionSupport {

    private String source;
    private String destination;

    private List<Train> trainList;

    @Override
    public String execute() {

        TrainDAO dao = new TrainDAO();

        trainList = dao.searchTrains(source, destination);

        if (trainList != null && !trainList.isEmpty()) {
            return SUCCESS;
        } else {
            addActionError("No Trains Found");
            return ERROR;
        }
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public List<Train> getTrainList() {
        return trainList;
    }

    public void setTrainList(List<Train> trainList) {
        this.trainList = trainList;
    }
}