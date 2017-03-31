package entity;

import java.util.List;

/**
 * Created by Boo on 12.03.2017.
 */
public class Comic {

    private int id;
    private String name;
    private String description;
    private Status status;

    private List<ComicType> comicTypeList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<ComicType> getComicTypeList() {
        return comicTypeList;
    }

    public void setComicTypeList(List<ComicType> comicTypeList) {
        this.comicTypeList = comicTypeList;
    }
}
