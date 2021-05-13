package model.users;

import model.database.UsersDatabase;

public class CommonUser extends Guest{ // клас описує актора "зареєстрований користувач"
    private String name;
    private String password;


    public CommonUser(String name, String password) {
        this.name = name;
        this.password = password;
        UsersDatabase.addUser(name, this);
    }

    @Override
    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
