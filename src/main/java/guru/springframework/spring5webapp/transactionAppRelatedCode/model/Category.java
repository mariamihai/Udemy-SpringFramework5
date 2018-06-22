package guru.springframework.spring5webapp.transactionAppRelatedCode.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String name;
    // TODO - check enum is set correctly
    @NotNull
    private CategoryType type;
    // TODO - make sure it works correctly
    @NotNull
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name="idUser", nullable = false)
    private User user;


    // TODO - constrcuctors, getters & setters, equals, hashCode, toString

}
