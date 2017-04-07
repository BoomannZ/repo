package entity;

import java.util.Date;
import java.util.List;

/**
 * Created by Boo on 12.03.2017.
 */
public class Order {

    private int id;
    private List<Comic> comicList;

    private boolean paid;

    private Date date;

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
