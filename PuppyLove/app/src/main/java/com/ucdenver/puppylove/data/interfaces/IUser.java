package com.ucdenver.puppylove.data.interfaces;

public interface IUser {
    boolean login(String username, String password);
    boolean resetPassword(String email);
    void createAccount();
}
