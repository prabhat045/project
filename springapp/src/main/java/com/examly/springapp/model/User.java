package com.examly.springapp.model;

import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "users",uniqueConstraints = {
    @UniqueConstraint(columnNames = {"username"}),
    @UniqueConstraint(columnNames = {"email"}),
    @UniqueConstraint(columnNames = {"mobileNumber"})
})
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    @Column(name="email")
    private @NotBlank String email;

    @Column(name="password")
    private @NotBlank String password;

    @Column(name="username")
    private @NotBlank String username;

    @Column(name="mobileNumber")
    private @NotBlank String mobileNumber;

    @Column(name="active")
    private @NotBlank boolean active;

    @Column(name="role")
    private @NotBlank String role;

    User(){}
    User(String email,String password,String username,String mobileNumber,boolean active,String role){
        this.email = email;
        this.password = password;
        this.username = username;
        this.active = active;
        this.mobileNumber = mobileNumber;
        this.role = role;
    }
    public void setId(Long id){
        this.id = id;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setMobileNumber(String mobileNumber){
        this.mobileNumber = mobileNumber;
    }

    public void setRole(String role){
        this.role = role;
    }

    public void setActive(boolean active){
        this.active = active;
    }

    public String getEmail(){
        return this.email;
    }

    public String getPassword(){
        return this.password;
    }

    public String getUsername(){
        return this.username;
    }

    public String getMobileNumber(){
        return this.mobileNumber;
    }

    public String getRole(){
        return this.role;
    }

    public boolean getActive(){
        return this.active;
    }

    public Long getId(){
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) &&
                Objects.equals(password, user.password);
    }
}
