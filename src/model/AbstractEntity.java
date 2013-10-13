package model;

import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @SequenceGenerator(name="my_seq", sequenceName="SEQ_1", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="my_seq")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int i) {
        this.id = i;
    }


}
