package com.epam.honchar.command;

import com.epam.honchar.services.OderServiceImpl;

import java.text.ParseException;
import java.util.Scanner;

public class AddToOderCommand extends Command {
    private OderServiceImpl oderServiceImpl;
    private Scanner scanner;

    public AddToOderCommand(OderServiceImpl oderServiceImpl, Scanner scanner) {
        this.oderServiceImpl = oderServiceImpl;
        this.scanner = scanner;
    }

    @Override
    public String execute() throws ParseException {
        System.out.println("input date(dd-MM-yyyy HH:mm:ss)...");
        String date = scanner.nextLine();
        oderServiceImpl.addToOder(date);
        return "Car added in oder!";
    }
}
