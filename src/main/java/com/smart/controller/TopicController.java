package com.smart.controller;

import com.smart.entities.Topic;
import com.smart.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping("/topics")
    @ResponseBody
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    @GetMapping("/topics/{id}")
    public ResponseEntity<?> getTopic(@PathVariable String id) {
        try {
            return new ResponseEntity<Topic>(topicService.getTopic(id), new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(id + " is not found in our database, please try with valid input", new HttpHeaders(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/topics")
    public void addTopic(@RequestBody Topic topic) {
        topicService.addTopic(topic);
    }

    @PutMapping("/topics")
    public void updateTopic(@RequestBody Topic topic) {
        topicService.updateTopic(topic);
    }

    @DeleteMapping("/topics/{id}")
    public void deleteTopic(@PathVariable String id) {
        topicService.deleteTopic(id);
    }
}
