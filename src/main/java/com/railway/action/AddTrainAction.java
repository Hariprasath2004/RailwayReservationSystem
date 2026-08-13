package com.railway.action;

import java.sql.Date;
import java.sql.Time;

import com.opensymphony.xwork2.ActionSupport;
import com.railway.dao.TrainDAO;
import com.railway.model.Train;

public class AddTrainAction extends ActionSupport {

    private String trainNo;
    private String trainName;
    private String source;
    private String destination;
    private String journeyDate;
    private String departureTime;
    private String arrivalTime;
    private int totalSeats;
    private double fare;

    @Override
    public String execute() {

        Train train = new Train();

        train.setTrainNo(trainNo);
        train.setTrainName(trainName);
        train.setSource(source);
        train.setDestination(destination);
        train.setJourneyDate(java.sql.Date.valueOf(journeyDate));

        train.setDepartureTime(java.sql.Time.valueOf(departureTime + ":00"));

        train.setArrivalTime(java.sql.Time.valueOf(arrivalTime + ":00"));
        train.setTotalSeats(totalSeats);
        train.setAvailableSeats(totalSeats);
        train.setFare(fare);

        TrainDAO dao = new TrainDAO();

        if (dao.addTrain(train)) {

            addActionMessage("Train Added Successfully");

            return SUCCESS;
        }

        addActionError("Failed To Add Train");

        return ERROR;
    }

    public String getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(String trainNo) {
        this.trainNo = trainNo;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
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

    public String getJourneyDate() {
        return journeyDate;
    }

    public void setJourneyDate(String journeyDate) {
        this.journeyDate = journeyDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }
}