package guru.springframework.spring5webapp.transactionAppRelatedCode.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Recurrence {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private Integer dayOfWeek;
    private Integer dayOfMonth;
    private Integer monthOfYear;
    private Date endDate;


    /* Constructors */
    public Recurrence() {
    }

    public Recurrence(Integer dayOfWeek, Integer dayOfMonth, Integer monthOfYear, Date endDate) {
        this.dayOfWeek = dayOfWeek;
        this.dayOfMonth = dayOfMonth;
        this.monthOfYear = monthOfYear;
        this.endDate = endDate;
    }


    /* Getters and Setters */
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Integer getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Integer getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(Integer dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public Integer getMonthOfYear() {
        return monthOfYear;
    }

    public void setMonthOfYear(Integer monthOfYear) {
        this.monthOfYear = monthOfYear;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recurrence that = (Recurrence) o;
        return Objects.equals(Id, that.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }

    @Override
    public String toString() {
        return "Recurrence{" +
                "Id=" + Id +
                ", dayOfWeek='" + dayOfWeek + '\'' +
                ", dayOfMonth='" + dayOfMonth + '\'' +
                ", monthOfYear='" + monthOfYear + '\'' +
                ", endDate=" + endDate +
                '}';
    }
}
