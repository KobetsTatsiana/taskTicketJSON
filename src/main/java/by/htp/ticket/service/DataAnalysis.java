package by.htp.ticket.service;

import by.htp.ticket.bean.Ticket;
import by.htp.ticket.bean.TicketList;
import org.apache.commons.math3.stat.descriptive.rank.Percentile;

import java.time.Duration;
import java.util.OptionalDouble;

public class DataAnalysis {
    public static Duration getAvg(TicketList ticketList, String placeOfDeparture, String placeOfArrival) {

        OptionalDouble avg = ticketList
                .getTickets()
                .stream()
                .filter(ticket -> {
                    if (ticket.getPlaceOfDeparture().equals(placeOfDeparture)
                            && ticket.getPlaceOfArrival().equals(placeOfArrival)) {
                        return true;
                    } else
                        return ticket.getPlaceOfDeparture().equals(placeOfArrival)
                                && ticket.getPlaceOfArrival().equals(placeOfDeparture);
                }).map(Ticket::getDuration)
                .mapToDouble(Duration::getSeconds)
                .average();

        Duration avgDuration = Duration.ofSeconds((long) avg.getAsDouble());
        return avgDuration;
    }

    public static Duration getPercentile(TicketList ticketList, double percentileValue, String placeOfDeparture, String placeOfArrival) {

        double[] array = ticketList
                .getTickets()
                .stream()
                .filter(ticket -> {
                    if (ticket.getPlaceOfDeparture().equals(placeOfDeparture)
                            && ticket.getPlaceOfArrival().equals(placeOfArrival)) {
                        return true;
                    } else
                        return ticket.getPlaceOfDeparture().equals(placeOfArrival)
                                && ticket.getPlaceOfArrival().equals(placeOfDeparture);
                }).map(Ticket::getDuration)
                .mapToDouble(Duration::getSeconds)
                .toArray();

        Percentile percentile = new Percentile();
        percentile.setData(array);
        Duration percentileDuration = Duration.ofSeconds((long) percentile.evaluate(percentileValue));

        return percentileDuration;
    }
}
