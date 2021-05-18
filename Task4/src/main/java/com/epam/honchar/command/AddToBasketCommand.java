package com.epam.honchar.command;

import com.epam.honchar.entity.ListProducts;
import com.epam.honchar.services.BasketServiceImpl;

import java.util.Scanner;

public class AddToBasketCommand extends Command {
    private BasketServiceImpl basketServiceImpl;
    private ListProducts listProducts;
    private Scanner scanner;

    public AddToBasketCommand(BasketServiceImpl basketServiceImpl, ListProducts listProducts, Scanner scanner) {
        this.basketServiceImpl = basketServiceImpl;
        this.listProducts = listProducts;
        this.scanner = scanner;
    }

    @Override
    public String execute() {
        System.out.println("Input name car...");
        String name = scanner.nextLine();
        basketServiceImpl.addToBasket(listProducts.getCarByName(name));
        return "Car added in basket";
    }

}
