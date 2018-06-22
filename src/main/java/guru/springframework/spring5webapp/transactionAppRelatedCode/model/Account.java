package guru.springframework.spring5webapp.transactionAppRelatedCode.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private Double initialSum;
    // TODO - enum?
    @NotNull
    private String currency;
    // TODO - check is boolean
    @NotNull
    private Boolean isClosed;

    @ManyToOne
    @JoinColumn(name="idUser", nullable = false)
    private User user;


    // TODO - constrcuctors, getters & setters, equals, hashCode, toString

}
