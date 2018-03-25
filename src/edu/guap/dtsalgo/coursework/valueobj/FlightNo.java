package edu.guap.dtsalgo.coursework.valueobj;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FlightNo implements Comparable<FlightNo> {
    private String number;

    public FlightNo(String number) {
        setNumber(number);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        Pattern p = Pattern.compile("^[a-zA-Z]{3}-\\d{3}$");
        Matcher m = p.matcher(number);
        if (m.matches()) {
            this.number = number;
        } else {
            throw new IllegalArgumentException("Wrong flight id! Must be WWW-XXX , where W - letter and X - digit.");
        }

    }

    @Override
    public int compareTo(FlightNo o) {
        return number.compareTo(o.getNumber());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FlightNo flightNo = (FlightNo) o;

        return number != null ? number.equals(flightNo.number) : flightNo.number == null;

    }

    @Override
    public int hashCode() {
        return number != null ? number.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "FlightNo{" +
                "number='" + number + '\'' +
                '}';
    }
}