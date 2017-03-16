package entity;

import org.hibernate.annotations.Table;

import javax.persistence.*;

/**
 * Created by Boo on 12.03.2017.
 */
@Entity
@Table(appliesTo = "types")
public class ComicType{
        @Id
        @GeneratedValue
        @Column
        private int id;
        @Column
        @Enumerated(value = EnumType.ORDINAL)
        private EnumComicType type;
        @Column
        private String description;

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public EnumComicType getType() {
                return type;
        }

        public void setType(EnumComicType type) {
                this.type = type;
        }
}


