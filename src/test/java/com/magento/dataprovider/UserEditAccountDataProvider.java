package com.magento.dataprovider;

import org.testng.annotations.DataProvider;

public class UserEditAccountDataProvider {

    @DataProvider(name = "validFirstName")
    public Object[][] validFirstName() {
        return new Object[][]{
                {"david123@gmail.com", "david1234", "John"}
        };
    }

    @DataProvider(name = "validLastName")
    public Object[][] editValidLastName() {
        return new Object[][]{
                {"david123@gmail.com", "david1234", "Nguyen"}
        };
    }

    @DataProvider(name = "validEmail")
    public Object[][] editValidEmail() {
        return new Object[][]{
                {"david123@gmail.com", "david1234", "newemail123@gmail.com"}
        };
    }

    @DataProvider(name = "changePassword")
    public Object[][] changePassword() {
        return new Object[][]{
                {"newemail123@gmail.com", "david1234", "newpass789"}
        };
    }

    @DataProvider(name = "emptyRequiredFields")
    public Object[][] emptyRequiredFields() {
        return new Object[][]{
                {"newemail123@gmail.com", "newpass789"}
        };
    }

    @DataProvider(name = "invalidEmailFormat")
    public Object[][] invalidEmailFormat() {
        return new Object[][]{
                {"newemail123@gmail.com", "newpass789", "david123@gmail"}
        };
    }

    @DataProvider(name = "wrongCurrentPassword")
    public Object[][] wrongCurrentPassword() {
        return new Object[][]{
                {"newemail123@gmail.com", "newpass789", "david123"}
        };
    }

    @DataProvider(name = "mismatchNewPassword")
    public Object[][] mismatchNewPassword() {
        return new Object[][]{
                {"newemail123@gmail.com", "newpass789", "david123", "david123" + System.currentTimeMillis()}
        };
    }

}
