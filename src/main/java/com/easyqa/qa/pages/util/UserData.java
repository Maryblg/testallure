package com.easyqa.qa.pages.util;

import io.qameta.allure.Step;

public class UserData {
    private String userName;
    private String userPassword;
    private String authPage;

    public UserData(String userName, String userPassword, String authPage) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.authPage = authPage;

    }

    @Step
    public String getUserName() {
        return this.userName;
    }

    @Step
    public String getUserPassword() {
        return this.userPassword;
    }

    @Step
    public String getAuthPage() {
        return this.authPage;
    }
}
