package com.epam.honchar.command;

import com.epam.honchar.entity.ListProducts;
import com.epam.honchar.services.BasketServiceImpl;

import java.util.Scanner;

public class DeleteCarFromBasketCommand extends Command {
    private BasketServiceImpl basketServiceImpl;
    private ListProducts listProducts;
    private Scanner scanner;

    public DeleteCarFromBasketCommand(BasketServiceImpl basketServiceImpl, ListProducts listProducts, Scanner scanner) {
        this.basketServiceImpl = basketServiceImpl;
        this.listProducts = listProducts;
        this.scanner = scanner;
    }

    @Override
    public String execute() {
        System.out.println("Input name car, what you want to delete from basket...");
        String name = scanner.nextLine();
        basketServiceImpl.removeFromBasket(listProducts.getCarByName(name));
        return "This Car removed from Basket!";
    }
}
