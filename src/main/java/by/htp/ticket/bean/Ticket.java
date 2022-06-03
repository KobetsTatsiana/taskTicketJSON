package by.htp.ticket.bean;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ticket {
    private String placeOfDeparture;
    private String departureDate;
    private String departureTime;
    private String placeOfArrival;
    private String arrivalDate;
    private String arrivalTime;

    public Ticket() {
    }

    public Ticket(String placeOfDeparture, String departureDate, String departureTime, String placeOfArrival, String arrivalDate, String arrivalTime) {
        this.placeOfDeparture = placeOfDeparture;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.placeOfArrival = placeOfArrival;
        this.arrivalDate = arrivalDate;
        this.arrivalTime = arrivalTime;
    }

    public String getPlaceOfDeparture() {
        return placeOfDeparture;
    }

    public void setPlaceOfDeparture(String placeOfDeparture) {
        this.placeOfDeparture = placeOfDeparture;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getPlaceOfArrival() {
        return placeOfArrival;
    }

    public void setPlaceOfArrival(String placeOfArrival) {
        this.placeOfArrival = placeOfArrival;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "placeOfDeparture='" + placeOfDeparture + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", placeOfArrival='" + placeOfArrival + '\'' +
                ", arrivalDate='" + arrivalDate + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                '}';
    }

    public Duration getDuration() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy H:mm"); //RUS

        LocalDateTime departure = LocalDateTime.parse(departureDate + " " + departureTime, formatter);
        LocalDateTime arrival = LocalDateTime.parse(arrivalDate + " " + arrivalTime, formatter);

        Duration durationOFFlight = Duration.between(departure, arrival);
        return durationOFFlight;
    }

}
