package by.tc.epam.controller.command;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class CommandNavigator {

    private static CommandNavigator ourInstance = new CommandNavigator();
    private final Map<String, Command> navigator;
    private final static String DEFAULT_COMMAND = "goToStartPage";

    public static CommandNavigator getInstance() {
        return ourInstance;
    }

    private CommandNavigator() {

        navigator = new HashMap<>();

        FileInputStream fis;
        Properties property = new Properties();

        try {
            fis = new FileInputStream("/home/misha/Desktop/FinalProject/src/main/resources/command_resource/commandList.properties");
            property.load(fis);

            Enumeration<?> commandNames = property.propertyNames();
            String currentCommandClassName;
            String currentCommandName;

            while(commandNames.hasMoreElements()){

                currentCommandName = (String)commandNames.nextElement();
                currentCommandClassName = property.getProperty(currentCommandName);
                navigator.put(currentCommandName, (Command) Class.forName(currentCommandClassName).newInstance());

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Command getCommand(String commandName){
        if(commandName == null || commandName.equals("")){
            commandName = DEFAULT_COMMAND;
        }
        return navigator.get(commandName);
    }
}
