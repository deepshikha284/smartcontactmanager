package com.smart.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "topic")
public class Topic {

    @Id
    private String id;
    private String topicName;
    private String topicDesc;

    @ManyToOne
    @JsonIgnore
    private Course course;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicDesc() {
        return topicDesc;
    }

    public void setTopicDesc(String topicDesc) {
        this.topicDesc = topicDesc;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
