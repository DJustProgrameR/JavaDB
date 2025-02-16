package org.itmo.Presentation.Commands;

/**
 * The ICommand interface represents a command that can be executed.
 */
public interface ICommand extends Runnable {
    /**
     * Gets the name of the command.
     *
     * @return The name of the command.
     */
    String getName();
}