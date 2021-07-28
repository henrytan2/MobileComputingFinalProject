package com.ucdenver.puppylove.data.interfaces;

public interface IUser {
    boolean accountExists(String email);

    com.ucdenver.puppylove.data.models.User login(String username, String password);

    void resetPassword(String username, String email, String password);

    com.ucdenver.puppylove.data.requests.User.CreateAccountResponse createAccount(String username, String password, String firstName, String lastName,
                                                                                  String email, String phone, String occupation);

    void editProfile(int id, String firstName, String lastName, String phone, String occupation);

    com.ucdenver.puppylove.data.models.User fetchByUserName(String username);
}
