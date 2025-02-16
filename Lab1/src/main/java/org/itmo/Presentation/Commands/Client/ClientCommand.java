/**
 * The ClientCommand class represents a command related to client operations.
 * It extends the Command class, inheriting its properties and behaviors.
 */
package org.itmo.Presentation.Commands.Client;

import org.itmo.Business.Entities.Client.IClient;
import org.itmo.Presentation.Commands.Command;

/**
 * The ClientCommand class represents a command related to client operations.
 * It extends the Command class, inheriting its properties and behaviors.
 */
public class ClientCommand extends Command {

    /** The client object associated with this command. */
    protected IClient client;

}