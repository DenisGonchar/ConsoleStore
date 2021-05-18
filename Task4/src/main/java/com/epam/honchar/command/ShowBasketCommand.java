package com.epam.honchar.command;

import com.epam.honchar.services.BasketServiceImpl;

public class ShowBasketCommand extends Command {

    private BasketServiceImpl basketServiceImpl;

    public ShowBasketCommand(BasketServiceImpl basketServiceImpl) {
        this.basketServiceImpl = basketServiceImpl;
    }

    @Override
    public String execute() {
        return basketServiceImpl.basketToString();
    }
}
