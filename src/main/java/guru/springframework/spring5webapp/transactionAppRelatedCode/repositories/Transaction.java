package guru.springframework.spring5webapp.transactionAppRelatedCode.repositories;

import guru.springframework.spring5webapp.transactionAppRelatedCode.model.Account;
import guru.springframework.spring5webapp.transactionAppRelatedCode.model.Category;
import guru.springframework.spring5webapp.transactionAppRelatedCode.model.Recurrence;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @NotNull
    private Double sum;
    @NotNull
    private Date date;
    private Boolean isPending;

    @ManyToOne
    @JoinColumn(name="idCategory", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name="idAccount", nullable = false)
    private Account account;

    @ManyToOne
    @JoinColumn(name="idRecurrence", nullable = true)
    private Recurrence recurrence;


    /* Constructors */
    public Transaction() {
    }

    public Transaction(String name, @NotNull Double sum, @NotNull Date date, Boolean isPending) {
        this.name = name;
        this.sum = sum;
        this.date = date;
        this.isPending = isPending;
    }

    public Transaction(String name, @NotNull Double sum, @NotNull Date date, Boolean isPending,
                       Category category, Account account, Recurrence recurrence) {
        this.name = name;
        this.sum = sum;
        this.date = date;
        this.isPending = isPending;
        this.category = category;
        this.account = account;
        this.recurrence = recurrence;
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

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getPending() {
        return isPending;
    }

    public void setPending(Boolean pending) {
        isPending = pending;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Recurrence getRecurrence() {
        return recurrence;
    }

    public void setRecurrence(Recurrence recurrence) {
        this.recurrence = recurrence;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sum=" + sum +
                ", date=" + date +
                ", isPending=" + isPending +
//                ", category=" + category +
//                ", account=" + account +
                ", recurrence=" + recurrence +
                '}';
    }
}
