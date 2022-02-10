package esportsrest.database.entitites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PlayerStats {
    @GeneratedValue
    @Id
    private long id;

    private int season;

    public PlayerStats() { }

    public PlayerStats(long id, int season) {
        this.id = id;
        this.season = season;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }
}
