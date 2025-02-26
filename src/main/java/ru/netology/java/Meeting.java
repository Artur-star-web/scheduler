package ru.netology.java;


public class Meeting extends Task {


    protected String topic;
    protected String project;
    protected String start;

    public Meeting(int id, String topic, String project, String start) {
        super(id);
        this.topic = topic;
        this.project = project;
        this.start = start;
    }

    public String getTopic() {
        return topic;
    }

    public String getProject() {
        return project;
    }

    public String getStart() {
        return start;
    }

    @Override
    public boolean matches(String query) {
        boolean resultTopic = topic.contains(query);
        boolean resultProject = project.contains(query);
        System.out.println("Meeting: тема '" + topic + "' содержит '" + query + "'? -> " + resultTopic);
        System.out.println("Meeting: проект '" + project + "' содержит '" + query + "'? -> " + resultProject);
        return resultTopic || resultProject;
    }
}
