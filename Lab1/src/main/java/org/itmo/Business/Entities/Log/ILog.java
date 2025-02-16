/**
 * The ILog interface represents a log entry in the banking system.
 */
package org.itmo.Business.Entities.Log;

import java.math.BigDecimal;

/**
 * The ILog interface represents a log entry in the banking system.
 */
public interface ILog {

    /**
     * Displays the log information.
     * @return A string representing the log information.
     */
    String displayLog();

    /**
     * Checks if the log has the specified ID.
     * @param logID The ID to check.
     * @return True if the log has the specified ID, false otherwise.
     */
    boolean checkByID(int logID);

    /**
     * Declines the transaction associated with the log.
     */
    void decline();

    /**
     * Retrieves the sum associated with the log.
     * @return The sum associated with the log.
     */
    BigDecimal getSum();
}