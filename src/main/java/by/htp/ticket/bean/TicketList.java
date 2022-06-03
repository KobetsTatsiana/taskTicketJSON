package by.htp.ticket.bean;

import java.util.List;

public class TicketList {
    private List<Ticket> tickets;

    public TicketList() {
    }

    public TicketList(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return "TicketList{" +
                "tickets=" + tickets +
                '}';
    }
}

