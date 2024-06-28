package com.uyghur.aopdemo.dao;

import com.uyghur.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{

    @Override
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass()+": Doing my DB work: Adding an account");

    }

    @Override
    public boolean doWork() {
        System.out.println(getClass()+": do work()");

        return false;
    }
}
