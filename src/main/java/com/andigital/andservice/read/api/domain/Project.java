package com.andigital.andservice.read.api.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

/**
 * Created by aditeja on 5/23/2017.
 */
@Document(collection = "project")
public class Project {
    @Id
    private String id;

    private String title;
    private String client_id;
    private String planned_budget;
    private String role;
    private String start_date;
    private String end_date;
    private ArrayList<Users> users;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getPlanned_budget() {
        return planned_budget;
    }

    public void setPlanned_budget(String planned_budget) {
        this.planned_budget = planned_budget;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public ArrayList<Users> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<Users> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", client_id='" + client_id + '\'' +
                ", planned_budget='" + planned_budget + '\'' +
                ", role='" + role + '\'' +
                ", start_date='" + start_date + '\'' +
                ", end_date='" + end_date + '\'' +
                ", users=" + users +
                '}';
    }
}
