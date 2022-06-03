package by.htp.ticket.main;


import by.htp.ticket.bean.TicketList;
import by.htp.ticket.service.DataAnalysis;
import by.htp.ticket.service.ReadingTicketJson;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            TicketList ticketList;
            while (true) {
                System.out.println("Введите путь к файлу:");
                try {
                    String path = reader.readLine();
                    //path = "src/main/resources/tickets.json";
                    ticketList = ReadingTicketJson
                            .parse(path);
                    break;
                } catch (Exception e) {
                    System.out.println("Неверный путь к файлу.");
                }
            }

            System.out.println("Среднее время полета между городами Владивосток и Тель-Авив : "
                    + DataAnalysis.getAvg(ticketList,
                    "Владивосток",
                    "Тель-Авив"));

            System.out.println("90-й процентиль времени полета между городами  Владивосток и Тель-Авив : "
                    + DataAnalysis.getPercentile(ticketList,
                    90,
                    "Владивосток",
                    "Тель-Авив"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
