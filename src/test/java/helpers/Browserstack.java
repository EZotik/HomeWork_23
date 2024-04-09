package helpers;

import static io.restassured.RestAssured.given;

public class Browserstack {
    // curl -u "bsuser_0MUuRs:zyZ7RzqPmuwy1EYz6dyq" -X GET "https://api.browserstack.com/app-automate/sessions/c5d37c104b9e822d38fe9e583911c217be3f5d64.json"
    // automation_session.video_url

    public static String videoUrl(String sessionId) {
        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic("bsuser_0MUuRs", "zyZ7RzqPmuwy1EYz6dyq")
                .get(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}
