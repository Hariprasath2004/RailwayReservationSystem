package com.railway.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.railway.dao.BookingDAO;
import com.railway.model.Booking;

public class MyBookingsAction extends ActionSupport implements SessionAware {

    private Map<String, Object> session;

    private List<Booking> bookingList;

    @Override
    public String execute() {

        Integer userId = (Integer) session.get("userId");

        if (userId == null) {

            addActionError("Please Login First");
            return ERROR;

        }

        BookingDAO dao = new BookingDAO();

        bookingList = dao.getMyBookings(userId);

        return SUCCESS;
    }

    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

}