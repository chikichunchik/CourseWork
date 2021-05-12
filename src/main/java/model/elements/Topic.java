package model.elements;

import model.users.Administrator;
import java.util.Collection;
import java.util.HashMap;

public class Topic { // клас, що описує сутність теми, кожна тема містить у собі HashMap дописів
    private String theme;
    private String startMessage;
    private Administrator author;
    private Integer id;
    private HashMap<Integer, Post> posts = new HashMap<>();
    private Integer nextPostId = 1;

    public Topic(String theme, String startMessage, Administrator author) {
        this.theme = theme;
        this.startMessage = startMessage;
        this.author = author;
    }

    public void addPost(Post post){
        posts.put(nextPostId, post);
        post.setId(nextPostId++);
    }

    public void deletePost(Integer postId){
        posts.remove(postId);
    }

    public String getTheme() {
        return theme;
    }

    public String getStartMessage() {
        return startMessage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Collection<Post> getPosts(){
        return this.posts.values();
    }

    public Administrator getAuthor() {
        return author;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public void setStartMessage(String startMessage) {
        this.startMessage = startMessage;
    }
}
