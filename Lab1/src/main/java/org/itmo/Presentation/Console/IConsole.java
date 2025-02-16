package org.itmo.Presentation.Console;

/**
 * The IConsole interface represents the console interface for interacting with the application.
 * It defines methods to start and end the console session.
 */
public interface IConsole {

    /**
     * Starts the console session.
     * This method should handle user input and execute corresponding commands.
     */
    void startWork();

    /**
     * Ends the console session.
     * This method should perform cleanup tasks and terminate the console session.
     */
    void endWork();
}