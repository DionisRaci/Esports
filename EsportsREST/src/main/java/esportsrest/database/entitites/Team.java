package esportsrest.database.entitites;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Team")
public class Team {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private long id;

    private String name;

    public Team() { }

    @OneToMany
    private List<Player> players;

    public Team(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
