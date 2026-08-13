package com.railway.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.railway.config.DBConnection;
import com.railway.model.Train;

import redis.clients.jedis.Jedis;
import com.railway.util.RedisUtil;

public class TrainDAO {

    public List<Train> searchTrains(String source, String destination) {
    	Jedis jedis = RedisUtil.getConnection();

    	String cacheKey = source + "_" + destination;

    	String cachedValue = jedis.get(cacheKey);

    	if (cachedValue != null) {
    	    System.out.println("Data fetched from Redis: " + cachedValue);
    	} else {
    	    System.out.println("Data fetched from PostgreSQL");
    	}

        List<Train> trains = new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM trains WHERE LOWER(source)=LOWER(?) AND LOWER(destination)=LOWER(?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, source);
            ps.setString(2, destination);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Train t = new Train();

                t.setId(rs.getInt("id"));
                t.setTrainNo(rs.getString("train_no"));
                t.setTrainName(rs.getString("train_name"));
                t.setSource(rs.getString("source"));
                t.setDestination(rs.getString("destination"));
                t.setJourneyDate(rs.getDate("journey_date"));
                t.setDepartureTime(rs.getTime("departure_time"));
                t.setArrivalTime(rs.getTime("arrival_time"));
                t.setAvailableSeats(rs.getInt("available_seats"));


                trains.add(t);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!trains.isEmpty()) {
            jedis.set(cacheKey, "Search completed");
        }

        jedis.close();

        return trains;
    }
    public boolean addTrain(Train train) {

        boolean status = false;

        String sql = "INSERT INTO trains "
                + "(train_no, train_name, source, destination, journey_date, departure_time, arrival_time, seats_available, fare, available_seats) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, train.getTrainNo());
            ps.setString(2, train.getTrainName());
            ps.setString(3, train.getSource());
            ps.setString(4, train.getDestination());
            ps.setDate(5, train.getJourneyDate());
            ps.setTime(6, train.getDepartureTime());
            ps.setTime(7, train.getArrivalTime());
            ps.setInt(8, train.getTotalSeats());      // seats_available
            ps.setDouble(9, train.getFare());
            ps.setInt(10, train.getAvailableSeats());

            status = ps.executeUpdate() > 0;

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
    public List<Train> getAllTrains() {

        List<Train> trains = new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM trains ORDER BY id";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Train t = new Train();

                t.setId(rs.getInt("id"));
                t.setTrainNo(rs.getString("train_no"));
                t.setTrainName(rs.getString("train_name"));
                t.setSource(rs.getString("source"));
                t.setDestination(rs.getString("destination"));
                t.setJourneyDate(rs.getDate("journey_date"));
                t.setDepartureTime(rs.getTime("departure_time"));
                t.setArrivalTime(rs.getTime("arrival_time"));

                t.setTotalSeats(rs.getInt("seats_available"));

                t.setAvailableSeats(rs.getInt("available_seats"));

                t.setFare(rs.getDouble("fare"));

                trains.add(t);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        

        return trains;
    }
   
    public boolean deleteTrain(int id) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            con.setAutoCommit(false);

            // First delete bookings
            String sql1 = "DELETE FROM bookings WHERE train_id=?";

            PreparedStatement ps1 = con.prepareStatement(sql1);

            ps1.setInt(1, id);

            ps1.executeUpdate();

            ps1.close();

            // Then delete train
            String sql2 = "DELETE FROM trains WHERE id=?";

            PreparedStatement ps2 = con.prepareStatement(sql2);

            ps2.setInt(1, id);

            status = ps2.executeUpdate() > 0;

            ps2.close();

            con.commit();

            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return status;
    }
    
}