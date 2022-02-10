package esportsrest.api;

import esportsrest.database.Repository;
import esportsrest.database.entitites.Game;
import esportsrest.database.entitites.Team;
import esportsrest.database.entitites.Tournament;
import esportsrest.database.entitites.Player;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
@Path("esports")
public class EsportsDataService {
    @Inject
    protected Repository repo;

    //region tournaments
    @Path("tournaments")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tournament> getTournaments() {
        return repo.getTournaments();
    }

    @Path("tournaments/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Tournament getTournament(@PathParam("id") long id) {
        return repo.getTournament(id);
    }

    @Path("tournaments/name/{name}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Tournament getTournamentByName(@PathParam("name") String name) {
        return repo.getTournamentByName(name);
    }

    @Path("tournaments")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createOrUpdateTournament(Tournament tournament) {
        Tournament t = repo.createOrUpdateTournament(tournament);
        if(t != null){
            return Response.status(200).build();
        }
        return Response.status(204).build();
    }

    @Path("tournaments/{id}")
    @DELETE
    @Transactional
    public void deleteTournament(@PathParam("id") long id) {
        repo.deleteTournament(id);
    }
    //endregion


    //region players
    @Path("players")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Player> getPlayers() {
        return repo.getPlayers();
    }

    @Path("players/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Player getPlayer(@PathParam("id") long id) {
        return repo.getPlayer(id);
    }

    @Path("players/name/{name}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Player getPlayerByName(@PathParam("name") String name) {
        return repo.getPlayerByName(name);
    }

    @Path("players")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createOrUpdatePlayer(Player player) {
        Player p = repo.createOrUpdatePlayer(player);
        if(p != null){
            return Response.status(200).build();
        }
        return Response.status(204).build();
    }

    @Path("players/{id}")
    @DELETE
    public void deletePlayer(@PathParam("id") long id) {
        repo.deletePlayer(id);
    }
    //endregion

    //region teams
    @Path("teams")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Team> getTeams() {
        return repo.getTeams();
    }

    @Path("teams/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Team getTeam(@PathParam("id") long id) {
        return repo.getTeam(id);
    }

    @Path("teams/name/{name}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Team getTeamByName(@PathParam("name") String name) {
        return repo.getTeamByName(name);
    }

    @Path("teams")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createOrUpdateTeam(Team team) {
        Team t = repo.createOrUpdateTeam(team);
         if(t != null){
            return Response.status(200).build();
         }
         return Response.status(204).build();
    }

    @Path("teams/{id}")
    @DELETE
    @Transactional
    public void deleteTeam(@PathParam("id") long id) {
        repo.deleteTeam(id);
    }
    //endregion

    //region games
    @Path("games/{id}")
    @DELETE
    public void deleteGame(@PathParam("id") long id) {
        repo.deleteGame(id);
    }

    @Path("games/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Game getGame(@PathParam("id") long id) {
        return repo.getGame(id);
    }

    @Path("games")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createOrUpdateGame(Game game) {
        Game g = repo.createOrUpdateGame(game);
        if(g != null){
            return Response.status(200).build();
        }
        return Response.status(204).build();
    }
    //endregion
}