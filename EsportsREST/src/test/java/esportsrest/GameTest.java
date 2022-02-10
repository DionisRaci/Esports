package esportsrest;

import esportsrest.database.entitites.Game;
import esportsrest.database.entitites.Team;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class GameTest {
    @Test
    public void testCreate() {
        RestAssured.defaultParser = Parser.JSON;

        //region Preparing data
        Team t = given()
                .when().get("/esports/teams/{id}", 2)
                .as(Team.class);

        Team t1 = given()
                .when().get("/esports/teams/{id}", 1)
                .as(Team.class);
        //endregion

        Game g = new Game();

        g.setFirstTeam(t);
        g.setSecondTeam(t1);
        g.setWinner(t);
        System.out.println(given()
                .contentType(ContentType.JSON)
                .body(g)
                .when()
                .post("/esports/games")
                .then()
                .statusCode(200));
    }

    @Test
    public void testGet() {
        given()
                .when().get("/esports/games/{id}", 1)
                .then()
                .statusCode(200);
    }
}
