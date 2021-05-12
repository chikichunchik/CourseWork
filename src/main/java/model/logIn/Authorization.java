package model.logIn;

import model.database.UsersDatabase;

public class Authorization { // перевірка даних при вході в аккаунт
    public static boolean isUserExists(String name){
        return UsersDatabase.getUser(name) != null;
    }

    public static boolean isPasswordCorrect(String name, String password){
        return UsersDatabase.getUser(name).getPassword().equals(password);
    }
}
