package by.tc.epam.model.command;

import by.tc.epam.model.command.impl.*;
import by.tc.epam.model.command.impl.go_to_page.*;
import by.tc.epam.model.command.impl.post.*;

import java.util.HashMap;
import java.util.Map;

public class CommandNavigator {

    private static CommandNavigator ourInstance = new CommandNavigator();
    private final Map<String, Command> navigator;
    private final static String DEFAULT_COMMAND = "goToStartPage";

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
        navigator.put("goToCreateOddPage", new GoToCreateOddPageCommand());
        navigator.put("showOdds", new GetOddsByEventCommand());
        navigator.put("createStacke", new CreateStackeCommand());
        navigator.put("showStakes", new ShowStakesCommand());
        navigator.put("setScore", new SetScoreCommand());
        navigator.put("goToSetScorePage", new GoToSetScorePage());
        navigator.put("goToDepositWithdrawPage", new GoToDepositWithdrawPage());
        navigator.put("goToCreateEventPage", new GoToCreateEventPage());
        navigator.put("goToStartPage", new GoToStartPage());
    }

    public Command getCommand(String commandName){
        if(commandName == null || commandName.equals("")){
            commandName = DEFAULT_COMMAND;
        }
        return navigator.get(commandName);
    }
}
