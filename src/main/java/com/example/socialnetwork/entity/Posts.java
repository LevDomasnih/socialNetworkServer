package com.example.socialnetwork.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Users owner;

    public Posts() {
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Users getOwner() {
        return owner;
    }

    public void setOwner(Users owner) {
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
