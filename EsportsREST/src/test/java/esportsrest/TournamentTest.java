package esportsrest;

import esportsrest.database.entitites.Team;
import esportsrest.database.entitites.Tournament;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Type;
import java.util.List;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class TournamentTest {
    @Test
    public void testCreate() {
        Team[] teams = given()
                .contentType(ContentType.JSON)
                .get("/esports/teams")
                .as(Team[].class);

        Tournament t = new Tournament("PGL Stockholm", List.of(teams), null, teams[0]);

        System.out.println("________________________________________________________");
        System.out.println(teams.length);
        System.out.println("________________________________________________________");

        System.out.println(given()
                .contentType(ContentType.JSON)
                .body(t)
                .when()
                .post("/esports/tournaments")
                .then()
                .statusCode(200));
    }

    @Test
    public void testGet() {
        given()
                .when().get("/esports/tournaments/name/{name}", "Blast")
                .then()
                .statusCode(200);


        given()
                .when().get("/esports/tournaments/{id}", 0)
                .then()
                .statusCode(200);
    }

    @Test
    public void testDelete() {
        Tournament t = given()
                .when().get("/esports/tournaments/name/{name}", "PGL Stockholm")
                .as(Tournament.class);

        given()
                .when().delete("/esports/tournaments/{id}", t.getId())
                .then()
                .statusCode(204);
    }
}
