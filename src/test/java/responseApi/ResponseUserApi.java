package responseApi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ResponseUserApi {
    public static RequestSpecification returnRequestSpecification() {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://reqres.in/api");
        requestSpecification.basePath("/users");
        requestSpecification.contentType(ContentType.JSON);
        return requestSpecification;
    }

    public static String getEmail(String first_Name, String last_Name) {
        Response response = getAllUsers();
        String textResponse =
                response.jsonPath()
                        .getString("data.find{(it.first_name=='" + first_Name + "')&&" + "(it.last_name =='" + last_Name + "')}.email");
        return textResponse;
    }

    public static String getEmailPagination(String first_Name, String last_Name) {
        int total_page = getAllUsers()
                .jsonPath().getInt("total_pages");
        for (int i = 1; total_page > i - 1; ++i) {
            Response response = getUsersByPage(i);
            String textResponse = response.jsonPath()
                    .getString("data.find{(it.first_name=='" + first_Name + "')&&" + "(it.last_name =='" + last_Name + "')}.email");
            if (textResponse != null) {
                return textResponse;
            }
        }
        return "Почта с такими данными не найдена";
    }

    public static Response getUsersByPage(int numberPage) {
        RequestSpecification requestSpecification = returnRequestSpecification();
        Response response = given(requestSpecification)
                .when().get("?page=" + numberPage);
        return response;
    }

    public static Response getAllUsers() {
        RequestSpecification requestSpecification = returnRequestSpecification();

        Response response = given(requestSpecification)
                .when().get();
        return response;
    }
}
