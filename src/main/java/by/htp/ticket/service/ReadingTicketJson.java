package by.htp.ticket.service;

import by.htp.ticket.bean.TicketList;
import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ReadingTicketJson {
    public static TicketList parse(String path) throws IOException {

        Gson gson = new Gson();
        String json = FileUtils.readFileToString(new File(path), StandardCharsets.UTF_8);
        TicketList ticketList = gson.fromJson(json, TicketList.class);

        return ticketList;
    }
}

