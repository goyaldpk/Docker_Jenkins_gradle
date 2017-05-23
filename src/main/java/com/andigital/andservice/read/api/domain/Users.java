package com.andigital.andservice.read.api.domain;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by aditeja on 5/23/2017.
 */
@Document
public class Users {

    private String user_id;
    private String role;
    private String start_date;
    private String end_date;
    private String extension_request;

    public Users(){}
    public Users(String user_id,String role,String start_date,String end_date,String extension_request){
        this.user_id=user_id;
        this.role=role;
        this.start_date=start_date;
        this.end_date=end_date;
        this.extension_request=extension_request;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
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

    public String getExtension_request() {
        return extension_request;
    }

    public void setExtension_request(String extension_request) {
        this.extension_request = extension_request;
    }

    @Override
    public String toString() {
        return "Users{" +
                "user_id='" + user_id + '\'' +
                ", role='" + role + '\'' +
                ", start_date='" + start_date + '\'' +
                ", end_date='" + end_date + '\'' +
                ", extension_request='" + extension_request + '\'' +
                '}';
    }
}
