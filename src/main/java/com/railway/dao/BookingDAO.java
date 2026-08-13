package com.railway.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.railway.config.DBConnection;
import com.railway.model.Booking;

public class BookingDAO {

    // ===========================
    // BOOK TICKET
    // ===========================

    public boolean bookTicket(Booking booking) {

        boolean status = false;

        Connection con = null;

        try {

            con = DBConnection.getConnection();

            // Transaction Start
            con.setAutoCommit(false);

            // -----------------------------
            // Check Available Seats
            // -----------------------------

            String seatSql =
                    "SELECT available_seats FROM trains WHERE id=?";

            PreparedStatement seatPs =
                    con.prepareStatement(seatSql);

            seatPs.setInt(1, booking.getTrainId());

            ResultSet rs = seatPs.executeQuery();

            if (rs.next()) {

                int seats = rs.getInt("available_seats");

                if (seats <= 0) {

                    rs.close();
                    seatPs.close();

                    con.rollback();
                    con.close();

                    return false;

                }

            }

            rs.close();
            seatPs.close();

            // -----------------------------
            // Insert Booking
            // -----------------------------

            String pnr = "PNR" + System.currentTimeMillis();

            String bookingSql =
                    "INSERT INTO bookings " +
                    "(pnr,user_id,train_id,passenger_name,passenger_age,passenger_gender,status) " +
                    "VALUES(?,?,?,?,?,?,?)";

            PreparedStatement bookingPs =
                    con.prepareStatement(bookingSql);

            bookingPs.setString(1, pnr);
            bookingPs.setInt(2, booking.getUserId());
            bookingPs.setInt(3, booking.getTrainId());
            bookingPs.setString(4, booking.getPassengerName());
            bookingPs.setInt(5, booking.getAge());
            bookingPs.setString(6, booking.getGender());
            bookingPs.setString(7, "BOOKED");

            int rows = bookingPs.executeUpdate();

            bookingPs.close();

            // -----------------------------
            // Reduce Seat
            // -----------------------------

            String updateSeat =
                    "UPDATE trains SET available_seats = available_seats - 1 WHERE id=?";

            PreparedStatement updatePs =
                    con.prepareStatement(updateSeat);

            updatePs.setInt(1, booking.getTrainId());

            updatePs.executeUpdate();

            updatePs.close();

            con.commit();

            status = rows > 0;

        }

        catch (Exception e) {

            try {

                if (con != null)
                    con.rollback();

            } catch (Exception ex) {
            }

            e.printStackTrace();

        }

        finally {

            try {

                if (con != null) {

                    con.setAutoCommit(true);
                    con.close();

                }

            } catch (Exception e) {
            }

        }

        return status;

    }

    // ===========================
    // MY BOOKINGS
    // ===========================

    public List<Booking> getMyBookings(int userId) {

        List<Booking> bookingList = new ArrayList<>();

        String sql =
                "SELECT * FROM bookings WHERE user_id=? ORDER BY booked_at DESC";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Booking booking = new Booking();

                booking.setBookingId(rs.getInt("id"));
                booking.setPnr(rs.getString("pnr"));
                booking.setUserId(rs.getInt("user_id"));
                booking.setTrainId(rs.getInt("train_id"));
                booking.setPassengerName(rs.getString("passenger_name"));
                booking.setAge(rs.getInt("passenger_age"));
                booking.setGender(rs.getString("passenger_gender"));
                booking.setStatus(rs.getString("status"));
                booking.setBookingDate(rs.getTimestamp("booked_at"));

                bookingList.add(booking);

            }

            rs.close();
            ps.close();
            con.close();

        }

        catch (Exception e) {

            e.printStackTrace();

        }

        return bookingList;

    }

    // ===========================
    // CANCEL TICKET
    // ===========================

    public boolean cancelTicket(int bookingId) {

        boolean status = false;

        Connection con = null;

        try {

            con = DBConnection.getConnection();

            con.setAutoCommit(false);

            // Check booking status & train id
            String checkSql =
                    "SELECT train_id, status FROM bookings WHERE id=?";

            PreparedStatement checkPs =
                    con.prepareStatement(checkSql);

            checkPs.setInt(1, bookingId);

            ResultSet rs = checkPs.executeQuery();

            int trainId = 0;

            if (rs.next()) {

                trainId = rs.getInt("train_id");

                String bookingStatus = rs.getString("status");

                // Already cancelled
                if ("CANCELLED".equals(bookingStatus)) {

                    rs.close();
                    checkPs.close();

                    con.rollback();
                    con.close();

                    return false;

                }

            } else {

                rs.close();
                checkPs.close();

                con.rollback();
                con.close();

                return false;

            }

            rs.close();
            checkPs.close();

            // Cancel booking
            String cancelSql =
                    "UPDATE bookings SET status='CANCELLED' WHERE id=?";

            PreparedStatement cancelPs =
                    con.prepareStatement(cancelSql);

            cancelPs.setInt(1, bookingId);

            int rows = cancelPs.executeUpdate();

            cancelPs.close();

            // Increase seat
            String seatSql =
                    "UPDATE trains SET available_seats = available_seats + 1 WHERE id=?";

            PreparedStatement seatPs =
                    con.prepareStatement(seatSql);

            seatPs.setInt(1, trainId);

            seatPs.executeUpdate();

            seatPs.close();

            con.commit();

            status = rows > 0;

        } catch (Exception e) {

            try {

                if (con != null)
                    con.rollback();

            } catch (Exception ex) {
            }

            e.printStackTrace();

        } finally {

            try {

                if (con != null) {

                    con.setAutoCommit(true);
                    con.close();

                }

            } catch (Exception e) {
            }

        }

        return status;

    }
 // ===========================
 // SEARCH BY PNR
 // ===========================

 public Booking getBookingByPNR(String pnr) {

     Booking booking = null;

     String sql = "SELECT * FROM bookings WHERE pnr=?";

     try {

         Connection con = DBConnection.getConnection();

         PreparedStatement ps = con.prepareStatement(sql);

         ps.setString(1, pnr);

         ResultSet rs = ps.executeQuery();

         if (rs.next()) {

             booking = new Booking();

             booking.setBookingId(rs.getInt("id"));
             booking.setPnr(rs.getString("pnr"));
             booking.setUserId(rs.getInt("user_id"));
             booking.setTrainId(rs.getInt("train_id"));
             booking.setPassengerName(rs.getString("passenger_name"));
             booking.setAge(rs.getInt("passenger_age"));
             booking.setGender(rs.getString("passenger_gender"));
             booking.setStatus(rs.getString("status"));
             booking.setBookingDate(rs.getTimestamp("booked_at"));

         }

         rs.close();
         ps.close();
         con.close();

     } catch (Exception e) {

         e.printStackTrace();

     }

     return booking;

 }
//===========================
//VIEW ALL BOOKINGS (ADMIN)
//===========================

public List<Booking> getAllBookings() {

  List<Booking> bookingList = new ArrayList<>();

  String sql = "SELECT * FROM bookings ORDER BY booked_at DESC";

  try {

      Connection con = DBConnection.getConnection();

      PreparedStatement ps = con.prepareStatement(sql);

      ResultSet rs = ps.executeQuery();

      while (rs.next()) {

          Booking booking = new Booking();

          booking.setBookingId(rs.getInt("id"));
          booking.setPnr(rs.getString("pnr"));
          booking.setUserId(rs.getInt("user_id"));
          booking.setTrainId(rs.getInt("train_id"));
          booking.setPassengerName(rs.getString("passenger_name"));
          booking.setAge(rs.getInt("passenger_age"));
          booking.setGender(rs.getString("passenger_gender"));
          booking.setStatus(rs.getString("status"));
          booking.setBookingDate(rs.getTimestamp("booked_at"));

          bookingList.add(booking);

      }

      rs.close();
      ps.close();
      con.close();

  } catch (Exception e) {

      e.printStackTrace();

  }

  return bookingList;
}
}