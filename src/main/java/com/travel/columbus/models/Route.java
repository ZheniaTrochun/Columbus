package com.travel.columbus.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Route {

    @Id
    @GeneratedValue
    @Column(name = "route_id")
    @NotNull
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;

    @Embedded
    private List<Coordinates> coordinatesList;

    public Route(User user, List<Coordinates> coordinatesList) {
        this.user = user;
        this.coordinatesList = coordinatesList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Coordinates> getCoordinatesList() {
        return coordinatesList;
    }

    public void setCoordinatesList(List<Coordinates> coordinatesList) {
        this.coordinatesList = coordinatesList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Route route = (Route) o;

        if (id != null ? !id.equals(route.id) : route.id != null) return false;
        if (user != null ? !user.equals(route.user) : route.user != null) return false;
        return coordinatesList != null ? coordinatesList.equals(route.coordinatesList) : route.coordinatesList == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (coordinatesList != null ? coordinatesList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", user=" + user +
                ", coordinatesList=" + coordinatesList +
                '}';
    }
}
