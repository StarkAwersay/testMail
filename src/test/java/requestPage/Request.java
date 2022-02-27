package requestPage;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Request {
    public static Response requestFromSite(String baseUri, String basePath) {
        Response response = given()
                .baseUri(baseUri)
                .contentType(ContentType.JSON)
                .when().get(basePath);
        return response;
    }
}
