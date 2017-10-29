package com.travel.columbus.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    @NotNull
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private String hashedPass;
    @NotNull
    private Double salt;

    @OneToMany
    private List<Route> routes;

    public User(Integer id, String name, String hashedPass, Double salt, List<Route> routes) {
        this.id = id;
        this.name = name;
        this.hashedPass = hashedPass;
        this.salt = salt;
        this.routes = routes;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHashedPass() {
        return hashedPass;
    }

    public void setHashedPass(String hashedPass) {
        this.hashedPass = hashedPass;
    }

    public Double getSalt() {
        return salt;
    }

    public void setSalt(Double salt) {
        this.salt = salt;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (hashedPass != null ? !hashedPass.equals(user.hashedPass) : user.hashedPass != null) return false;
        if (salt != null ? !salt.equals(user.salt) : user.salt != null) return false;
        return routes != null ? routes.equals(user.routes) : user.routes == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (hashedPass != null ? hashedPass.hashCode() : 0);
        result = 31 * result + (salt != null ? salt.hashCode() : 0);
        result = 31 * result + (routes != null ? routes.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hashedPass='" + hashedPass + '\'' +
                ", salt=" + salt +
                ", routes=" + routes +
                '}';
    }
}
