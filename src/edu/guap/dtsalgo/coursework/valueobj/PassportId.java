package edu.guap.dtsalgo.coursework.valueobj;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PassportId implements Comparable<PassportId> {
    private String id;

    public PassportId(String id) {
        setId(id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        Pattern p = Pattern.compile("^\\d{4}-\\d{6}$");
        Matcher m = p.matcher(id);
        if (m.matches()) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("Wrong passport id! Must be XXXX-XXXXXX , where X - digit.");
        }
    }

    @Override
    public int compareTo(PassportId o) {
        return id.compareTo(o.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PassportId that = (PassportId) o;

        return id != null ? id.equals(that.id) : that.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "PassportId{" +
                "id='" + id + '\'' +
                '}';
    }
}