package edu.guap.dtsalgo.coursework.valueobj;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TicketNo implements Comparable<FlightNo> {
    private String number;

    public TicketNo(String number) {
        setNumber(number);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        Pattern p = Pattern.compile("^\\d{9}$");
        Matcher m = p.matcher(number);
        if (m.matches()) {
            this.number = number;
        } else {
            throw new IllegalArgumentException("Wrong ticket id! Must be XXXXXXXXX , where X - digit.");
        }

    }

    @Override
    public int compareTo(FlightNo o) {
        return number.compareTo(o.getNumber());
    }

    @Override
    public String toString() {
        return "TicketNo{" +
                "number='" + number + '\'' +
                '}';
    }
}
