package com.railway.action;

import com.opensymphony.xwork2.ActionSupport;
import com.railway.dao.BookingDAO;
import com.railway.model.Booking;

public class SearchPNRAction extends ActionSupport {

    private String pnr;

    private Booking booking;

    @Override
    public String execute() {

        BookingDAO dao = new BookingDAO();

        booking = dao.getBookingByPNR(pnr);

        if (booking != null) {
            return SUCCESS;
        } else {
            addActionError("PNR Not Found");
            return ERROR;
        }

    }

    public String getPnr() {
        return pnr;
    }

    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

}