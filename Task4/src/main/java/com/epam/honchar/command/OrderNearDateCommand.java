package com.epam.honchar.command;

import com.epam.honchar.services.OderServiceImpl;

import java.text.ParseException;
import java.util.Scanner;

public class OrderNearDateCommand extends Command {
    private OderServiceImpl oderServiceImpl;
    private Scanner scanner;

    public OrderNearDateCommand(OderServiceImpl oderServiceImpl, Scanner scanner) {
        this.oderServiceImpl = oderServiceImpl;
        this.scanner = scanner;
    }

    @Override
    public String execute() throws ParseException {
        System.out.println("Input date(dd-MM-yyyy HH:mm:ss):");
        String date = scanner.nextLine();
        return oderServiceImpl.orderNearestDate(date).toString();
    }
}
