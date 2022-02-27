package responseApi;

import io.restassured.response.Response;

import static constants.Constants.basePath;
import static constants.Constants.baseUri;
import static io.restassured.RestAssured.request;
import static requestPage.Request.requestFromSite;

public class GetEmail {
    public static String getEmail(String first_Name, String last_Name) {
        Response response = requestFromSite(baseUri, basePath);
        String textResponse =
                response.jsonPath()
                        .getString("data.find{(it.first_name=='" + first_Name + "')&&" + "(it.last_name =='" + last_Name + "')}.email");
        return textResponse;
    }

}
