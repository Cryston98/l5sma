package com.example.fragmentapp.Model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class UserModel implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int ID;
    private String email;
    private String password;
    private String username;
    static int countUser=0;

    public UserModel(String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;
        countUser++;
    }

    @NonNull
    public int getID() {
        return ID;
    }
    public void setID(@NonNull int ID) {
        this.ID = ID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "ID=" + ID +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public static int getCountUser() {
        return countUser;
    }
}
