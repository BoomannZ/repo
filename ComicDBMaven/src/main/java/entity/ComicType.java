package entity;


/**
 * Created by Boo on 12.03.2017.
 */
public class ComicType{

        private int id;

        private EnumComicType type;
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


