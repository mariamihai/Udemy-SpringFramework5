package guru.springframework.spring5webapp.transactionAppRelatedCode.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String location;
    @NotNull
    private String timeZone;

    @OneToMany(mappedBy = "user")
    private Set<Category> categories;


    /* Constructors */
    public User() {
    }

    public User(String username, String password, String location, String timeZone) {
        this.username = username;
        this.password = password;
        this.location = location;
        this.timeZone = timeZone;
    }

    public User(String username, String password, String location, String timeZone, Set<Category> categories) {
        this.username = username;
        this.password = password;
        this.location = location;
        this.timeZone = timeZone;
        this.categories = categories;
    }


    /* Getters and Setters */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", location='" + location + '\'' +
                ", timeZone='" + timeZone + '\'' +
                '}';
    }
}
