package edu.guap.dtsalgo.coursework.valueobj;


public class Ticket implements Comparable<Ticket>{
    private PassportId passportId;
    private FlightNo flightNo;
    private TicketNo ticketNo;

    public Ticket(PassportId passportId, FlightNo flightNo, TicketNo ticketNo) {
        this.passportId = passportId;
        this.flightNo = flightNo;
        this.ticketNo = ticketNo;
    }

    public PassportId getPassportId() {
        return passportId;
    }

    public void setPassportId(PassportId passportId) {
        this.passportId = passportId;
    }

    public FlightNo getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(FlightNo flightNo) {
        this.flightNo = flightNo;
    }

    public TicketNo getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(TicketNo ticketNo) {
        this.ticketNo = ticketNo;
    }

    @Override
    public int compareTo(Ticket o) {
        return ticketNo.compareTo(o.getFlightNo());
    }
}
