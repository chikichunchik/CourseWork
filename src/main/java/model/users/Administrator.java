package model.users;

import model.database.TopicsDatabase;
import model.elements.Topic;

public class Administrator extends CommonUser{ // клас описує актора "адміністратор форуму"

    public Administrator(String name, String password) {
        super(name, password);
    }

}
