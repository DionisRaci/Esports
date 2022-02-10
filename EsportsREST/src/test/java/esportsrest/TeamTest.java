package esportsrest;

import esportsrest.database.entitites.Team;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class TeamTest {
    @Test
    public void testCreate() {
        Team t = new Team();
        t.setName("Virtus Pro");
        System.out.println(given()
                .contentType(ContentType.JSON)
                .body(t)
                .when()
                .post("/esports/teams")
                .then()
                .statusCode(200));
    }

    @Test
    public void testGet() {
        Team t = new Team();
        t.setName("NAVI");
        given()
                .contentType(ContentType.JSON)
                .body(t)
                .when()
                .post("/esports/teams")
                .then()
                .statusCode(200);

        given()
                .when().get("/esports/teams/name/{name}", "NAVI")
                .then()
                .statusCode(200);
    }

    @Test
    public void testDelete() {
        Team t = given()
                .when().get("/esports/teams/name/{name}", "Virtus Pro")
                        .as(Team.class);

        given()
                .when().delete("/esports/teams/{id}", t.getId())
                .then()
                .statusCode(204);

        Team t1 = given()
                .when().get("/esports/teams/name/{name}", "NAVI")
                .as(Team.class);

        given()
                .when().delete("/esports/teams/{id}", t1.getId())
                .then()
                .statusCode(204);
    }
}
