package model.users;

import model.database.TopicsDatabase;
import model.elements.Topic;

import javax.persistence.criteria.CriteriaBuilder;

public class Guest { // клас описує актора "гість"
    private String name = "Guest";

    public String getName() {
        return name;
    }
}
