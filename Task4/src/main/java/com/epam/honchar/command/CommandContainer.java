package com.epam.honchar.command;

import com.epam.honchar.entity.ListProducts;
import com.epam.honchar.lists.BasketList;
import com.epam.honchar.services.BasketServiceImpl;
import com.epam.honchar.services.OderServiceImpl;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CommandContainer {
    private Map<String, Command> commands = new TreeMap<>();
    private BasketServiceImpl basketServiceImpl;
    private OderServiceImpl oderServiceImpl;
    private ListProducts listProducts;
    private Scanner scanner;

    public CommandContainer(BasketServiceImpl basketServiceImpl, OderServiceImpl oderServiceImpl, ListProducts listProducts, Scanner scanner) {
        this.basketServiceImpl = basketServiceImpl;
        this.oderServiceImpl = oderServiceImpl;
        this.listProducts = listProducts;
        this.scanner = scanner;
    }

    public void init() {
        commands.put("addToBasket", new AddToBasketCommand(basketServiceImpl, listProducts, scanner));
        commands.put("addToOder", new AddToOderCommand(oderServiceImpl, scanner));
        commands.put("deleteCarFromBasket", new DeleteCarFromBasketCommand(basketServiceImpl, listProducts, scanner));
        commands.put("foundOrdersInRange", new FoundOrdersInRangeCommand(oderServiceImpl, scanner));
        commands.put("orderNearDate", new OrderNearDateCommand(oderServiceImpl, scanner));
        commands.put("showAllCars", new ShowAllCarsCommand(listProducts));
        commands.put("showBasket", new ShowBasketCommand(basketServiceImpl));
        commands.put("noCommand", new NoCommand());
    }

    public Command getCommand(String commandName) {
        if (commandName == null || !commands.containsKey(commandName)) {
            return commands.get("noCommand");
        }
        return commands.get(commandName);
    }

    public void getKey() {
        for (String key : commands.keySet()) {
            if (!key.equals("noCommand")) {
                System.out.print(key + " ");
            }
        }
    }


}
