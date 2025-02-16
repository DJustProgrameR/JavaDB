/**
 * The Bank class represents a bank entity.
 * It implements the IBank interface.
 */
package org.itmo.Business.Entities.Bank;

import org.itmo.Business.Entities.Account.IAccount;
import org.itmo.Business.Entities.CentralBank.ICentralBank;
import org.itmo.Business.Entities.Client.IClient;
import org.itmo.Business.Models.Records.*;
import org.itmo.Business.Services.Builders.Account.AccountBuilder;
import org.itmo.Business.Services.Builders.Account.IAccountBuilder;
import org.itmo.Business.Services.Builders.Client.ClientBuilder;
import org.itmo.Business.Services.Builders.Client.IClientBuilder;
import org.itmo.Business.Services.TimeAccelerationMechanism.ITimeAccelerationMechanism;
import org.itmo.Data.IDatabase;

import java.math.BigDecimal;
import java.util.Date;

/**
 * The Bank class represents a bank entity.
 * It implements the IBank interface.
 */
public class Bank implements IBank {

    /** The number of clients associated with the bank. */
    private int amountOfClients;

    /** The ID of the bank. */
    private int bankID;

    /** The interest rate for debit accounts. */
    private BigDecimal debitAccountInterest;

    /** The interest rate for deposit accounts. */
    private BigDecimal depositAccountInterest;

    /** The credit account limit. */
    private BigDecimal creditAccountLimit;

    /** The commission charged for credit accounts. */
    private BigDecimal creditAccountCommission;

    /** The maximum sum allowed for unverified transactions. */
    private BigDecimal maxUnverifiedTransactionSum;

    /** The owner of the bank. */
    private ICentralBank owner;

    /** The database associated with the bank. */
    private IDatabase database;

    /** The time acceleration mechanism used by the bank. */
    private ITimeAccelerationMechanism timeAccelerationMechanism;

    /**
     * Constructs a Bank object with the provided creation data, owner, database, and time acceleration mechanism.
     *
     * @param data                      The creation data for the bank.
     * @param owner                     The owner of the bank.
     * @param database                  The database associated with the bank.
     * @param timeAccelerationMechanism The time acceleration mechanism used by the bank.
     */
    public Bank(BankCreationRecord data, ICentralBank owner, IDatabase database, ITimeAccelerationMechanism timeAccelerationMechanism) {
        amountOfClients=0;
        bankID=data.bankID();
        debitAccountInterest=data.debitAccountInterest();
        depositAccountInterest=data.depositAccountInterest();
        creditAccountLimit=data.creditAccountLimit();
        creditAccountCommission=data.creditAccountCommission();
        maxUnverifiedTransactionSum=data.maxUnverifiedTransactionSum();
        this.owner = owner;
        this.database = database;
        this.timeAccelerationMechanism = timeAccelerationMechanism;
    }

    /**
     * Accrues interest to all accounts in the bank.
     */
    @Override
    public void accrueInterest() {
        for(IAccount account:database.getAccounts()){
            account.accrueDebitInterest(debitAccountInterest);
            account.accrueDepositInterest(depositAccountInterest);
        }
    }

    /**
     * Charges fees to all accounts in the bank.
     */
    @Override
    public void chargeFee() {
        for(IAccount account:database.getAccounts()){
            account.chargeFee(creditAccountCommission);
        }
    }

    /**
     * Creates a new client for the bank.
     *
     * @param data The creation data for the client.
     * @return     A string containing information about the created client.
     */
    @Override
    public String createClient(ClientCreationRecord data) {
        amountOfClients++;
        IClientBuilder clientBuilder = new ClientBuilder();
        IClient client = clientBuilder.setClientID(amountOfClients).setBankID(bankID).setConsoleParams(data).setOwner(this).build();
        database.addNewClient(client);
        return "clientID: "+amountOfClients+'\n';
    }

    /**
     * Creates a new account for a client.
     *
     * @param data The creation data for the account.
     */
    @Override
    public void createAccount(AccountCreationRecord data) {
        IAccountBuilder accountBuilder = new AccountBuilder();
        IAccount account = accountBuilder.setAccountID(data.accountID()).setBankID(bankID).setClientID(data.clientID()).setConsoleParams(data).build();
        database.addNewAccount(account);
    }

    /**
     * Makes a transaction within the bank or with another bank.
     *
     * @param data      The creation data for the transaction.
     * @param verified  Indicates whether the transaction is verified.
     */
    @Override
    public void makeTransaction(LogCreationRecord data, boolean verified) {
        if(data.fromBankID()==0){
            database.getAccountByIDs(data.toClientID(), data.toAccountID()).makeTransaction(data);
        } else if(data.toBankID()==0){
            if(database.getAccountByIDs(data.fromClientID(), data.fromAccountID()).checkTransaction(data,maxUnverifiedTransactionSum,creditAccountLimit,verified)){
                database.getAccountByIDs(data.fromClientID(), data.fromAccountID()).makeTransaction(data);
            }
        } else {
            if(data.fromBankID() == bankID){
                if(database.getAccountByIDs(data.fromClientID(), data.fromAccountID()).checkTransaction(data,maxUnverifiedTransactionSum,creditAccountLimit,verified)){
                    if(data.toBankID() == bankID){
                        database.getAccountByIDs(data.fromClientID(),data.fromAccountID()).makeTransaction(data);
                        database.getAccountByIDs(data.toClientID(),data.toAccountID()).makeTransaction(data);
                    } else {
                        database.getAccountByIDs(data.fromClientID(),data.fromAccountID()).makeTransaction(data);
                        owner.makeTransaction(data);
                    }
                }
            } else {
                database.getAccountByIDs(data.toClientID(),data.toAccountID()).makeTransaction(data);
            }
        }
    }

    /**
     * Declines a transaction based on the provided record.
     *
     * @param data The record containing information about the transaction to be declined.
     */
    @Override
    public void declineTransaction(DeclineTransactionRecord data) {
        database.getAccountByIDs(data.clientID1(),data.accountID1()).declineTransaction(data.logID1(), -1);
        if(data.clientID2()!=0){
            database.getAccountByIDs(data.clientID2(),data.accountID2()).declineTransaction(data.logID2(), 1);
        }
    }

    /**
     * Sets a new commission for credit accounts and notifies clients about the change.
     *
     * @param commission The new commission for credit accounts.
     */
    @Override
    public void newCreditAccountCommission(BigDecimal commission) {
        creditAccountCommission = commission;
        for(IClient client:database.getClients()){
            client.receiveMessage("newCreditAccountCommission - "+commission+'\n');
        }
    }

    /**
     * Sets a new credit limit for accounts and notifies clients about the change.
     *
     * @param limit The new credit limit.
     */
    @Override
    public void newCreditLimit(BigDecimal limit) {
        creditAccountLimit = limit;
        for(IClient client:database.getClients()){
            client.receiveMessage("newCreditLimit - "+limit+'\n');
        }
    }

    /**
     * Sets a new interest rate for debit accounts and notifies clients about the change.
     *
     * @param interest The new interest rate for debit accounts.
     */
    @Override
    public void newDebitInterest(BigDecimal interest) {
        debitAccountInterest = interest;
        for(IClient client:database.getClients()){
            client.receiveMessage("newDebitInterest - "+interest+'\n');
        }
    }

    /**
     * Sets a new interest rate for deposit accounts and notifies clients about the change.
     *
     * @param interest The new interest rate for deposit accounts.
     */
    @Override
    public void newDepositInterest(BigDecimal interest) {
        depositAccountInterest = interest;
        for(IClient client:database.getClients()){
            client.receiveMessage("newDepositInterest - "+interest+'\n');
        }
    }

    /**
     * Sets a new maximum sum for unverified transactions and notifies clients about the change.
     *
     * @param maxSum The new maximum sum for unverified transactions.
     */
    @Override
    public void newMaxUnverifiedTransactionSum(BigDecimal maxSum) {
        maxUnverifiedTransactionSum = maxSum;
        for(IClient client:database.getClients()){
            client.receiveMessage("newMaxUnverifiedTransactionSum - "+maxSum+'\n');
        }
    }

    /**
     * Checks if the bank matches the provided bank ID.
     *
     * @param bankID The bank ID to check against.
     * @return       True if the bank matches the provided bank ID, otherwise false.
     */
    @Override
    public boolean checkByBankID(int bankID) {
        return this.bankID==bankID;
    }

    /**
     * Displays the logs associated with a specific account.
     *
     * @param accountID The ID of the account.
     * @param clientID  The ID of the client.
     * @return          A string containing the logs associated with the specified account.
     */
    @Override
    public String displayAccountLogs(int accountID, int clientID) {
        return database.getAccountByIDs(clientID,accountID).displayAccount();
    }

    /**
     * Retrieves the client associated with the given client ID.
     *
     * @param clientID The ID of the client.
     * @return         The client associated with the given ID.
     */
    @Override
    public IClient getClient(int clientID) {
        return database.getClientByID(clientID);
    }

    /**
     * Accelerates time and calculates the total sum by the end day.
     *
     * @param clientID The ID of the client.
     * @param accountID The ID of the account.
     * @param today     The current date.
     * @param endDay    The end date.
     * @return          A string containing the total sum by the end day.
     */
    @Override
    public String accelerateTime(int clientID, int accountID, Date today, Date endDay) {
        return "total by the day "+endDay.toString()+" is: "+timeAccelerationMechanism.countSum(database.getAccountByIDs(clientID,accountID).getStatus(debitAccountInterest,depositAccountInterest,creditAccountCommission), today,endDay).toString()+'\n';
    }
}
