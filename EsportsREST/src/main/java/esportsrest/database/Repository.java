package esportsrest.database;

import esportsrest.database.entitites.Game;
import esportsrest.database.entitites.Team;
import esportsrest.database.entitites.Tournament;
import esportsrest.database.entitites.Player;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class Repository {
    @Inject
    protected EntityManager em;

    //region Tournaments
    public List<Game> getTournamentGames(long id) {
        return em.find(Tournament.class, id).getGames();
    }

    public List<Tournament> getTournaments() {
        return em.createQuery("SELECT t FROM Tournament t", Tournament.class).getResultList();
    }

    public Tournament getTournament(long id) {
        return em.find(Tournament.class, id);
    }

    @Transactional
    public Tournament createOrUpdateTournament(Tournament tournament) {
        if (getTournamentByName(tournament.getName()) == null){
            return em.merge(tournament);
        }
        return null;
    }

    @Transactional
    public void deleteTournament(long id) {
        em.remove(em.find(Tournament.class, id));
    }

    public Tournament getTournamentByName(String name) {
        try {
            Tournament t = em.createQuery("SELECT t FROM Tournament t WHERE t.name = :value", Tournament.class)
                    .setParameter("value", name).getSingleResult();
            return t;
        } catch (Exception e){
            return null;
        }
    }
    //endregion

    //region Games
    @Transactional
    public Game createOrUpdateGame(Game game) {
        return em.merge(game);
    }

    public Game getGame(long id) {
        return em.find(Game.class, id);
    }
    //endregion

    //region Players
    public void deleteGame(long id) {
        em.remove(em.find(Game.class, id));
    }

    public List<Player> getPlayers() {
        return em.createQuery("SELECT p FROM Player p", Player.class).getResultList();
    }

    public Player getPlayer(long id) {
        return em.find(Player.class, id);
    }

    @Transactional
    public Player createOrUpdatePlayer(Player player) {
        if (getPlayerByName(player.getName()) == null){
            return em.merge(player);
        }
        return null;
    }

    public Player getPlayerByName(String name) {
        try {
            Player p = em.createQuery("SELECT p FROM Player p WHERE p.name = :value", Player.class)
                    .setParameter("value", name).getSingleResult();
            return p;
        } catch (Exception e){
            return null;
        }
    }

    @Transactional
    public void deletePlayer(long id) {
        em.remove(em.find(Player.class, id));
    }
    //endregion

    //region Teams
    @Transactional
    public Team createOrUpdateTeam(Team team) {
        if (getTeamByName(team.getName()) == null){
            return em.merge(team);
        }
        return null;
    }

    public List<Team> getTeams() {
        return em.createQuery("SELECT t FROM Team t", Team.class).getResultList();
    }

    public Team getTeam(long id) {
        return em.find(Team.class, id);
    }

    public void deleteTeam(long id) {
        em.remove(em.find(Team.class, id));
    }

    public Team getTeamByName(String name) {
        try {
            Team t = em.createQuery("SELECT t FROM Team t WHERE t.name = :value", Team.class)
                    .setParameter("value", name).getSingleResult();
            return t;
        } catch (Exception e){
            return null;
        }
    }
    //endregion
}
