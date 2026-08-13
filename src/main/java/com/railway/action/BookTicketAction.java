package com.railway.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.railway.dao.BookingDAO;
import com.railway.model.Booking;

@SuppressWarnings("deprecation")
public class BookTicketAction extends ActionSupport implements SessionAware {

    private int trainId;
    private String passengerName;
    private int age;
    private String gender;

    private Map<String, Object> session;

    @Override
    public String execute() {

        Integer userId = (Integer) session.get("userId");

        if (userId == null) {

            addActionError("Session Expired. Please Login Again.");
            return ERROR;
        }

        Booking booking = new Booking();

        booking.setUserId(userId);
        booking.setTrainId(trainId);
        booking.setPassengerName(passengerName);
        booking.setAge(age);
        booking.setGender(gender);

        BookingDAO dao = new BookingDAO();

        boolean result = dao.bookTicket(booking);

        if (result) {

            return SUCCESS;

        } else {

            addActionError("Booking Failed");
            return ERROR;

        }
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}