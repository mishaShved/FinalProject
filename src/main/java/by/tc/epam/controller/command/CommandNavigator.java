package by.tc.epam.controller.command;

import by.tc.epam.util.ConstantContainer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class CommandNavigator {

    private static CommandNavigator ourInstance = new CommandNavigator();
    private final Map<String, Command> navigator;


    public static CommandNavigator getInstance() {
        return ourInstance;
    }

    /**
     * constructor read all properties from file and
     * create hashMap to navigate request
     */
    private CommandNavigator() {

        navigator = new HashMap<>();

        InputStream inputStream;
        Properties property = new Properties();

        try {

            inputStream = this.getClass().getClassLoader().getResourceAsStream("/command_resource/commandList.properties");
            property.load(inputStream);

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
            commandName = ConstantContainer.DEFAULT_COMMAND;
        }
        return navigator.get(commandName);
    }
}
