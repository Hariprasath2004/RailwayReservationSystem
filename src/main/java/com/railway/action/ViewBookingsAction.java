package com.railway.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.railway.dao.BookingDAO;
import com.railway.model.Booking;

public class ViewBookingsAction extends ActionSupport {

    private List<Booking> bookingList;

    @Override
    public String execute() {

        BookingDAO dao = new BookingDAO();

        bookingList = dao.getAllBookings();

        return SUCCESS;
    }

    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }
}