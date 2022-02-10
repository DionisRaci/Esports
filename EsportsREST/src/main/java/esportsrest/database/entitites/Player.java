package esportsrest.database.entitites;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "player")
public class Player implements Serializable {
    @GeneratedValue
    @Id
    private long id;

    private String name;

    @OneToMany
    private List<PlayerStats> playerStats;

    public Player() { }

    public Player(long id, String name, List<PlayerStats> rating) {
        this.id = id;
        this.name = name;
        this.playerStats = playerStats;
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

    public List<PlayerStats> getPlayerStats() {
        return playerStats;
    }

    public void setPlayerStats(List<PlayerStats> rating) {
        this.playerStats = playerStats;
    }
}
