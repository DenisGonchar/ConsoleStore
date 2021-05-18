package com.epam.honchar.command;

import com.epam.honchar.entity.ListProducts;

public class ShowAllCarsCommand extends Command {
    private ListProducts listProducts;

    public ShowAllCarsCommand(ListProducts listProducts) {
        this.listProducts = listProducts;
    }

    @Override
    public String execute() {
        return listProducts.getAllCars();
    }
}
