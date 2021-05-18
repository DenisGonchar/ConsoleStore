package com.epam.honchar.editior;

import com.epam.honchar.command.CommandContainer;
import com.epam.honchar.entity.Car;
import com.epam.honchar.entity.ListProducts;
import com.epam.honchar.lists.BasketList;
import com.epam.honchar.lists.OderList;
import com.epam.honchar.repositories.BasketRepositoryImpl;
import com.epam.honchar.repositories.BasketRepository;
import com.epam.honchar.repositories.OderRepository;
import com.epam.honchar.repositories.OderRepositoryImpl;
import com.epam.honchar.services.BasketServiceImpl;
import com.epam.honchar.services.OderServiceImpl;

import java.text.ParseException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.Scanner;
import java.util.Map;

public class Editor {
    private Map<String, Car> products = new LinkedHashMap<>();
    private Map<Date, List<Car>> oder = new TreeMap<>();
    private BasketList basketList = new BasketList(products);
    private OderList oderList = new OderList(oder, basketList);
    private BasketRepository basketRepository = new BasketRepositoryImpl(basketList);
    private OderRepository oderRepository = new OderRepositoryImpl(oderList);
    private BasketServiceImpl basketServiceImpl = new BasketServiceImpl(basketRepository);
    private OderServiceImpl oderServiceImpl = new OderServiceImpl(oderRepository);
    private ListProducts listProducts = new ListProducts();
    private Scanner scanner = new Scanner(System.in);
    private CommandContainer commandContainer = new CommandContainer(basketServiceImpl, oderServiceImpl, listProducts, scanner);

    public void init() throws ParseException {
        commandContainer.init();
        System.out.println("Press any key to start...");
        String command = scanner.nextLine();
        while (!command.equals("Stop!")) {
            System.out.println("This is List of Command(If you want to exit, input - Stop!) :");
            commandContainer.getKey();
            System.out.println("\nInput command:");
            command = scanner.nextLine();
            System.out.println(commandContainer.getCommand(command).execute());
        }
        System.out.println("By!");
    }
}
