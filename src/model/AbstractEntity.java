package model;

import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @SequenceGenerator(name="my_seq", sequenceName="SEQ_1", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="my_seq")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
