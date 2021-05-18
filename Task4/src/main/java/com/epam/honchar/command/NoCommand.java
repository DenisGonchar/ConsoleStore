package com.epam.honchar.command;

public class NoCommand extends Command {
    @Override
    public String execute() {
        return "This is not Command!";
    }
}
