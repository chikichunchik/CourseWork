package model.registration;

import model.database.UsersDatabase;

public class Validation { // перевідкаданих при реєстрації
    public static boolean isPasswordAvailable(String password){
        if(password.length() < 8){
            return false;
        }
        return true;
    }

    public static boolean isNicknameAvailable(String nickname){
        if(UsersDatabase.getUser(nickname) != null){
            return false;
        }
        return true;
    }
}
