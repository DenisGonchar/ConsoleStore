package com.epam.honchar.command;

import java.text.ParseException;

public abstract class Command {
    public abstract String execute() throws ParseException;
}
