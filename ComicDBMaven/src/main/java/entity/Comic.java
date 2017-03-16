package entity;

import org.hibernate.annotations.Table;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Boo on 12.03.2017.
 */
@Entity
@Table(appliesTo = "Comic")
public class Comic {
    @Id
    @Column
    @GeneratedValue
    private int id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    @Enumerated(value = EnumType.ORDINAL)
    private Status status;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "comic_types", joinColumns = {
            @JoinColumn(name = "comic_id", nullable = false) },
            inverseJoinColumns = { @JoinColumn(name = "type_id",
                    nullable = false) })
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
