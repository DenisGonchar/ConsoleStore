package com.epam.honchar.command;

import com.epam.honchar.services.OderServiceImpl;

import java.text.ParseException;
import java.util.Scanner;

public class FoundOrdersInRangeCommand extends Command {
    private OderServiceImpl oderServiceImpl;
    private Scanner scanner;

    public FoundOrdersInRangeCommand(OderServiceImpl oderServiceImpl, Scanner scanner) {
        this.oderServiceImpl = oderServiceImpl;
        this.scanner = scanner;
    }

    @Override
    public String execute() throws ParseException {
        System.out.println("Input first date (dd-MM-yyyy HH:mm:ss)");
        String date1 = scanner.nextLine();
        System.out.println("Input second date (dd-MM-yyyy HH:mm:ss)");
        String date2 = scanner.nextLine();
        return oderServiceImpl.orderInSpecifiedRange(date1, date2);
    }
}
