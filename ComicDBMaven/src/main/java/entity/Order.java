package entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Boo on 12.03.2017.
 */
public class Order {
    @Id
    @GeneratedValue
    @Column
    private int id;
  /*  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = ) */
    private List<Comic> comicList;
    @Column
    private boolean paid;
    @Column
    private Date date;
    @Column
    private String comment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Comic> getComicList() {
        return comicList;
    }

    public void setComicList(List<Comic> comicList) {
        this.comicList = comicList;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isPaid() {
        return paid;
    }
    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
