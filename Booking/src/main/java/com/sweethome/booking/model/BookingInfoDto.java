package com.sweethome.booking.model;


import java.util.Date;

public class BookingInfoDto {
    private Integer numOfRooms;
    private Date fromDate;
    private Date toDate;
    private String aadharNumber;

    public Integer getNumOfRooms() {
        return numOfRooms;
    }

    public void setNumOfRooms(Integer numOfRooms) {
        this.numOfRooms = numOfRooms;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadhaarNumber) {
        this.aadharNumber = aadhaarNumber;
    }



    @Override
    public String toString() {
        return "BookingInfoDto{" +
                "numOfRooms=" + numOfRooms +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", aadhaarNumber='" + aadharNumber + '\'' +
                '}';
    }


}
