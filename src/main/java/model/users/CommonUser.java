package model.users;

import model.database.TopicsDatabase;
import model.database.UsersDatabase;
import model.elements.Post;
import model.elements.Topic;

import javax.persistence.criteria.CriteriaBuilder;

public class CommonUser extends Guest{ // клас описує актора "зареєстрований користувач"
    private String name;
    private String password;


    public CommonUser(String name, String password) {
        this.name = name;
        this.password = password;
        UsersDatabase.addUser(name, this);
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
