package org.itmo.Data.Repository.Account;

import org.itmo.Business.Entities.AccountType;
import java.util.Date;

public interface IAccountRepository {
    void AddNewAccount(int clientID, AccountType accountType, double balance, Date dateOfClosing, Double additionalAmount);
    int GetClinetIDByID(int ID);
    void SetClinetIDByID(int ID);
    AccountType GetTypeByID(int ID);
    void SetTypeByID(int ID);
    double GetBalanceByID(int ID);
    void SetBalanceByID(int ID);
    Date GetDateOfClosingByID(int ID);
    void SetDateOfClosingByID(int ID);
    Double GetAdditionalAmountByID(int ID);
    void SetAdditionalAmountByID(int ID);
}
