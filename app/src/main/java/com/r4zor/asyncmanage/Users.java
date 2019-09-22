package com.r4zor.asyncmanage;

public class Users {
    private int id;
    private String name;
//    private String email;

    public Users(int id, String name) {
        this.id = id;
        this.name = name;
      //  this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // public String getEmail() { return email; }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public void setEmail(String email) {
//        this.email = email;
//    }

}
