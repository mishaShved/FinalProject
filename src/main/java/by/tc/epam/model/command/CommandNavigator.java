package by.tc.epam.model.command;

import by.tc.epam.model.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandNavigator {

    private static CommandNavigator ourInstance = new CommandNavigator();
    private final Map<String, Command> navigator;

    public static CommandNavigator getInstance() {
        return ourInstance;
    }

    private CommandNavigator() {

        navigator = new HashMap<>();
        navigator.put("login", new LoginCommand());
        navigator.put("registration", new RegistrationCommand());
        navigator.put("deposit", new DepositCommand());
        navigator.put("withdraw", new WithdrawCommand());
        navigator.put("createEvent", new EventCreateCommand());
        navigator.put("showEvents", new GetAllEventsCommand());
        navigator.put("showEventsBySport", new GetEventsBySportTypeCommand());
        navigator.put("createOdd", new CreateOddCommand());

    }

    public Command getCommand(String commandName){

        return navigator.get(commandName);
    }
}
