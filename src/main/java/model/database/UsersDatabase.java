package model.database;

import java.util.HashMap;

import model.users.Administrator;
import model.users.CommonUser;

public class UsersDatabase { // імітація бази даних зареєстрованих користувачів за допомогою HashMap
    static private HashMap<String, CommonUser> database = new HashMap<>();
    static {
        database.put("admin", new Administrator("admin", "admin"));
    }

    public static void addUser(String name, CommonUser user){
        if (database.get(name) == null){
            database.put(name, user);
        } else {
            throw new IllegalArgumentException("User already exists");
        }
    }

    public static void deleteUser(String name){
        if (database.get(name) != null){
            database.remove(name);
        } else {
            throw new IllegalArgumentException("No such user");
        }
    }

    public static CommonUser getUser(String name){
        return database.get(name);
    }

    
}
