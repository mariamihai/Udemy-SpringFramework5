package guru.springframework.spring5webapp.transactionAppRelatedCode.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    @Enumerated(EnumType.STRING)
    private CategoryTypeEnum type;
    // TODO - make sure tinyint is used in mysql
    @NotNull
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name="idUser", nullable = false)
    private User user;


    /* Constructors */
    public Category() {
    }

    public Category(@NotNull String name, @NotNull CategoryTypeEnum type, @NotNull Boolean isActive) {
        this.name = name;
        this.type = type;
        this.isActive = isActive;
    }

    public Category(@NotNull String name, @NotNull CategoryTypeEnum type, @NotNull Boolean isActive, User user) {
        this.name = name;
        this.type = type;
        this.isActive = isActive;
        this.user = user;
    }


    /* Getters and Setters */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryTypeEnum getType() {
        return type;
    }

    public void setType(CategoryTypeEnum type) {
        this.type = type;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", isActive=" + isActive +
//                ", user=" + user +
                '}';
    }
}
