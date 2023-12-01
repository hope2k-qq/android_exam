package com.example.android_exam;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class User {
    @Expose
    @PrimaryKey
    @SerializedName("id")
    private int id;
    @Expose
    @ColumnInfo(name = "full_name")
    @SerializedName("name")
    private String name;
    @Expose
    @ColumnInfo(name = "email")
    @SerializedName("email")
    private String email;
    @Expose
    @ColumnInfo(name = "phone_number")
    @SerializedName("phone")
    private String phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
