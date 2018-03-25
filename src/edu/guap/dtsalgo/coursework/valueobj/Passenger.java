package edu.guap.dtsalgo.coursework.valueobj;

public class Passenger {

    private PassportId passportId;
    private String issuedBy;
    private String fullName;
    private String birthDate;

    public Passenger(PassportId passportId, String issuedBy, String fullName, String birthDate) {
        this.passportId = passportId;
        this.issuedBy = issuedBy;
        this.fullName = fullName;
        this.birthDate = birthDate;
    }

    public PassportId getPassportId() {
        return passportId;
    }

    public void setPassportId(PassportId passportId) {
        this.passportId = passportId;
    }

    public String getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "passportId=" + passportId +
                ", issuedBy='" + issuedBy + '\'' +
                ", fullName='" + fullName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }
}
