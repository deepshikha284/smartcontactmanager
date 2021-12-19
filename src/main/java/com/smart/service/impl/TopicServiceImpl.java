package com.smart.service.impl;

import com.smart.dao.TopicRepository;
import com.smart.entities.Topic;
import com.smart.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getAllTopics() {
        List<Topic> topics = new ArrayList<>();
        for (Topic topic : topicRepository.findAll()) {
            topics.add(topic);
        }
        return topics;
    }

    public Topic getTopic(String id) {
        //  return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        Optional<Topic> topic = topicRepository.findById(id);
        return topic.get();
    }

    public void addTopic(Topic topic) {
        // topics.add(topic);
        topicRepository.save(topic);
    }

    public void updateTopic(Topic topic) {
        //for(int i=0; i<topics.size(); i++){
        //  Topic t=topics.get(i);
        // if (t.getId().equals(id)){
        //    topics.set(i, topic);
        //   return;
        topicRepository.save(topic);
    }

    public void deleteTopic(String id) {
        //topics.removeIf(t -> t.getId().equals(id));
        topicRepository.deleteById(id);
    }
}
