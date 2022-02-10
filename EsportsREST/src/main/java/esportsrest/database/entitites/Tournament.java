package esportsrest.database.entitites;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="tournament")
public class Tournament {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private long id;

    private String name;

    @OneToMany(mappedBy = "id")
    private List<Team> teams;

    @OneToMany(mappedBy = "id")
    private List<Game> games;

    @OneToOne
    private Team winner;

    public Tournament() { }

    public Tournament(String name, List<Team> teams, List<Game> games, Team winner) {
        this.name = name;
        this.teams = teams;
        this.games = games;
        this.winner = winner;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public List<Game> getGames() {
        return games;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public Team getWinner() {
        return winner;
    }

    public void setWinner(Team winner) {
        this.winner = winner;
    }
}
