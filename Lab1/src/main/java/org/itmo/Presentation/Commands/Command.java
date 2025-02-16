/**
 * The Command class represents a generic command.
 * It implements the ICommand interface.
 */
package org.itmo.Presentation.Commands;

import java.util.Scanner;

/**
 * The Command class represents a generic command.
 * It implements the ICommand interface.
 */
public class Command implements ICommand {

    /** The name of the command. */
    protected String name;

    /** The Scanner object for input. */
    protected Scanner input;

    /**
     * Retrieves the name of the command.
     *
     * @return The name of the command.
     */
    @Override
    public String GetName() {
        return name;
    }

    /**
     * Runs the command.
     */
    @Override
    public void run() {

    }

    /**
     * Pauses execution for the specified number of milliseconds.
     *
     * @param milliseconds The number of milliseconds to wait.
     */
    protected void waitFor(int milliseconds){
        try {
            // Sleep for the specified number of milliseconds
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            // Handle interrupted exception
            e.printStackTrace();
        }
    }
}