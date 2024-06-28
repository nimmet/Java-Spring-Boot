package com.uyghur.aopdemo.dao;

import com.uyghur.aopdemo.Account;

public interface AccountDAO {

    void addAccount(Account account, boolean vipFlag);

    boolean doWork();
}
