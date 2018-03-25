package edu.guap.dtsalgo.coursework.valueobj;

public class Flight implements Comparable<Flight> {

    private FlightNo number;
    private String company;
    private String departure;
    private String arrival;
    private String departureDate;
    private String arrivalDate;
    private int totalSeats;
    private int freeSeats;

    public Flight(FlightNo number, String company, String departure, String arrival, String departureDate, String arrivalDate, int totalSeats) {
        this.number = number;
        this.company = company;
        this.departure = departure;
        this.arrival = arrival;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.totalSeats = totalSeats;
        this.freeSeats = totalSeats;
    }

    public FlightNo getNumber() {
        return number;
    }

    public void setNumber(FlightNo number) {
        this.number = number;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getFreeSeats() {
        return freeSeats;
    }

    public void setFreeSeats(int freeSeats) {
        this.freeSeats = freeSeats;
    }

    @Override
    public int compareTo(Flight o) {
        return number.compareTo(o.getNumber());
    }
}
