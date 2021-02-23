package EASi.Test.API.demo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
@Data // Lombok: adds getters and setters
public class System {

    public System(String name, String lcid) {
        this.name = name;
        this.lcid = lcid;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private final String name;

    private String lcid;

}
