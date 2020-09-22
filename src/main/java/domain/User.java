package domain;

import jdk.nashorn.internal.objects.annotations.Getter;

import javax.persistence.*;

public class User {
    private Long id;
    private String name;
    private String content;

    public User(Long id, String name, String content) {
        this.id = id;
        this.name = name;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }




}