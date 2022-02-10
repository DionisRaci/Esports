package esportsrest.database.entitites;

import javax.persistence.*;

@Entity
@Table(name="game")
public class Game {
    @GeneratedValue
    @Id
    private long id;

    @OneToOne
    private Team firstTeam;

    @OneToOne
    private Team secondTeam;

    @OneToOne
    private Team winner;

    public Game() { }

    public Game(long id, Team firstTeam, Team secondTeam, Team winner) {
        this.id = id;
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
        this.winner = winner;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Team getFirstTeam() {
        return firstTeam;
    }

    public void setFirstTeam(Team firstTeam) {
        this.firstTeam = firstTeam;
    }

    public Team getSecondTeam() { return secondTeam; }

    public void setSecondTeam(Team secondTeam) { this.secondTeam = secondTeam; }

    public Team getwinner() { return winner; }

    public void setWinner(Team winner) { this.winner = winner; }
}
