package com.smoothiecorner.cli;

import com.smoothiecorner.Main;

public class CommandFactory {

    public static CommandFactory instance = new CommandFactory();

    public static CommandFactory getInstance() {
        return instance;
    }

    public static Command getCommand( String command) {
        if (command == null) {
            return null;
        }
        String[] order = command.split(" ");
        String name = order[0];

        switch (name) {
            case "exit":
                return (c) -> {
                    System.exit(0);
                };
            case "print" :
                return (c) -> {
                    Main.printMenu();
                };
            default:
                return new OrderCommand();
        }
    }
}
