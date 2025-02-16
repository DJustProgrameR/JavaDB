package org.itmo.Data.Repository.AccountLog;

public interface IAccountLogRepository {
    IAccountLogRepository GetAllAccountLogsByBankIDAccountID(int bankID, int accountID);
    void AddNewLog();
}
