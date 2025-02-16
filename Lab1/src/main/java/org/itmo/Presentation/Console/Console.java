package org.itmo.Presentation.Console;

import org.itmo.Presentation.Commands.CommandLoader.ICommandLoader;
import org.itmo.Presentation.Commands.ICommand;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Console class represents the console interface for interacting with the application.
 * It provides methods to start and end the console session, as well as handle user input.
 */
public class Console implements IConsole {

    private boolean working = true;
    private boolean logged = true;
    private Scanner scanner;
    private ICommandLoader commandLoader;
    private ICommand logInCommand;
    private ICommand logOutCommand;
    private ArrayList<ICommand> userCommands;

    /**
     * Constructs a new Console object.
     * @param commandLoader The command loader responsible for loading commands.
     */
    public Console(ICommandLoader commandLoader) {
        this.commandLoader = commandLoader;
        scanner = new Scanner(System.in);
        commandLoader.setInput(scanner);
        logInCommand = this.commandLoader.getLogInCommand(userCommands);
        logOutCommand = this.commandLoader.getLogOutCommand(userCommands, logged);
    }

    /**
     * Starts the console session.
     * Waits for user input and executes corresponding commands.
     */
    @Override
    public void startWork() {
        Scanner sc = new Scanner(System.in);
        while (working) {
            System.out.print("Log in - 1\nExit program - 2");
            int answer = sc.nextInt();
            clearScreen();
            switch (answer) {
                case 1:
                    logInCommand.run();
                    break;
                case 2:
                    endWork();
                    continue;
            }
            logged = true;
            while(logged){
                for (int i = 1; i < userCommands.size(); i++) {
                    System.out.print(userCommands.get(i - 1).getName() + " - " + i);
                }
                answer = sc.nextInt();
                userCommands.get(answer-1).run();
                System.out.print("Print any key to do smth else");
                String anyKey = sc.next();
                clearScreen();
            }
        }
    }

    /**
     * Ends the console session.
     * Sets the working flag to false.
     */
    @Override
    public void endWork() {
        working = false;
    }

    /**
     * Pauses the execution of the current thread for the specified number of milliseconds.
     * @param milliseconds The number of milliseconds to wait.
     */
    private void waitFor(int milliseconds){
        try {
            // Sleep for specified milliseconds
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            // Handle interrupted exception
            e.printStackTrace();
        }
    }

    /**
     * Clears the console screen.
     */
    private void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}