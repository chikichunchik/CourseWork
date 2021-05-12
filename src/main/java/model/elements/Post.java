package model.elements;

import model.users.CommonUser;

public class Post { // клас, що описує сутність допису у темі
    private String message;
    private CommonUser author;
    private Integer id;

    public Post(String message, CommonUser author) {
        this.message = message;
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public CommonUser getAuthor() {
        return author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
