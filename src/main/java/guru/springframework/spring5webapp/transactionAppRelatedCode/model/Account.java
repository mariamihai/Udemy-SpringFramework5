package guru.springframework.spring5webapp.transactionAppRelatedCode.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private Double initialSum;
    // TODO - Currency Code
    @NotNull
    private String currency;
    // TODO - make sure tinyint is used in mysql
    @NotNull
    private Boolean isClosed;

    @ManyToOne
    @JoinColumn(name="idUser", nullable = false)
    private User user;


    /* Constructors */
    public Account() {
    }

    public Account(@NotNull String name, @NotNull Double initialSum, @NotNull String currency, @NotNull Boolean isClosed) {
        this.name = name;
        this.initialSum = initialSum;
        this.currency = currency;
        this.isClosed = isClosed;
    }

    public Account(@NotNull String name, @NotNull Double initialSum, @NotNull String currency, @NotNull Boolean isClosed, User user) {
        this.name = name;
        this.initialSum = initialSum;
        this.currency = currency;
        this.isClosed = isClosed;
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

    public Double getInitialSum() {
        return initialSum;
    }

    public void setInitialSum(Double initialSum) {
        this.initialSum = initialSum;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Boolean getClosed() {
        return isClosed;
    }

    public void setClosed(Boolean closed) {
        isClosed = closed;
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
        Account account = (Account) o;
        return Objects.equals(id, account.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", initialSum=" + initialSum +
                ", currency='" + currency + '\'' +
                ", isClosed=" + isClosed +
//                ", user=" + user +
                '}';
    }
}
