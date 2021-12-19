package com.smart.service;

import com.smart.entities.Topic;

import java.util.List;

public interface TopicService {
    public List<Topic> getAllTopics();

    public Topic getTopic(String id);

    public void addTopic(Topic topic);

    public void updateTopic(Topic topic);

    public void deleteTopic(String id);
}
