package com.uyghur.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{

    @Override
    public void addAccount() {
        System.out.println(getClass()+": Doing my DB work: Adding a membership account");

    }

    @Override
    public void goToSleep() {
        System.out.println(getClass()+": Go to sleep");

    }
}
