package com.railway.action;

import com.opensymphony.xwork2.ActionSupport;
import com.railway.dao.BookingDAO;

public class CancelTicketAction extends ActionSupport {

    private int bookingId;

    @Override
    public String execute() {
    	System.out.println("Booking ID = " + bookingId);

        BookingDAO dao = new BookingDAO();

        boolean result = dao.cancelTicket(bookingId);

        if (result) {
            return SUCCESS;
        } else {
            addActionError("Ticket Cancel Failed");
            return ERROR;
        }
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }
}