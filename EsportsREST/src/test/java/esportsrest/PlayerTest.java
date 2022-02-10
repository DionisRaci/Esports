package esportsrest;

import esportsrest.database.entitites.Player;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class PlayerTest {
    @Test
    public void testCreate() {
        Player p = new Player();
        p.setName("Jame");
        System.out.println(given()
                .contentType(ContentType.JSON)
                .body(p)
                .when()
                .post("/esports/players")
                .then()
                .statusCode(200));
    }

    @Test
    public void testGet() {
        Player p = new Player();
        p.setName("Yekindar");
        given()
                .contentType(ContentType.JSON)
                .body(p)
                .when()
                .post("/esports/players")
                .then()
                .statusCode(200);

        given()
                .when().get("/esports/players/name/{name}", "Yekindar")
                .then()
                .statusCode(200);
    }

    @Test
    public void testDelete() {
        Player p = given()
                .when().get("/esports/players/name/{name}", "Yekindar")
                .as(Player.class);

        given()
                .when().delete("/esports/players/{id}", p.getId())
                .then()
                .statusCode(204);

        Player p1 = given()
                .when().get("/esports/players/name/{name}", "Jame")
                .as(Player.class);

        given()
                .when().delete("/esports/players/{id}", p1.getId())
                .then()
                .statusCode(204);
    }
}
