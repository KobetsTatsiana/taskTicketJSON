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
                System.out.println("Введи путь к файлу tickets.json:"); //src/main/resources/tickets.json
                try {
                    String path = reader.readLine();
                    ticketList = ReadingTicketJson
                            .parse(path);
                    break;
                } catch (Exception e) {
                    System.out.println("Неверный путь. Попробуй еще раз)");
                }
            }

            System.out.println("1. Среднее время полета между городами Владивосток и Тель-Авив: "
                    + DataAnalysis.getAvg(ticketList,
                    "Владивосток",
                    "Тель-Авив"));

            System.out.println("2. 90-й процентиль времени полета между городами Владивосток и Тель-Авив: "
                    + DataAnalysis.getPercentile(ticketList,
                    90,
                    "Владивосток",
                    "Тель-Авив"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
