package model.database;

import model.elements.Topic;

import java.util.HashMap;

public class TopicsDatabase { // імітація бази даних тем за допомогою HashMap

    private static int nextId = 1;
    static private HashMap<Integer, Topic> database = new HashMap<>();

    public static void addTopic(Topic topic){
        database.put(nextId, topic);
        topic.setId(nextId++);
    }

    public static void deleteTopic(Integer id){
        database.remove(id);
    }

    public static Topic getTopic(Integer id){
        return database.get(id);
    }

    public static HashMap<Integer, Topic> getDatabase() {
        return database;
    }
}
