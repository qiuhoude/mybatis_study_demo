package com.houde.bean;

/**
 * Created by Administrator on 2017/4/27 0027.
 */
public class Message {

    private Integer id;
    private String command;
    private String description;
    private String content;


    public Message() {
    }

    public Message(Integer id, String command, String description, String content) {
        this.id = id;
        this.command = command;
        this.description = description;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
