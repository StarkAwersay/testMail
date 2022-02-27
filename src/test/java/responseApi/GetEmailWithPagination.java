package responseApi;

import io.restassured.response.Response;

import static constants.Constants.*;
import static requestPage.Request.requestFromSite;

import java.io.IOException;

public class GetEmailWithPagination {
    public static String getEmailPagination(String first_Name, String last_Name) {
        int total_page = requestFromSite(baseUri, basePath)
                .jsonPath().getInt("total_pages");
        for (int i = 1; total_page > i - 1; ++i) {
            Response response = requestFromSite((baseUri), (newBasePath) + i);
            String textResponse = response.jsonPath()
                    .getString("data.find{(it.first_name=='" + first_Name + "')&&" + "(it.last_name =='" + last_Name + "')}.email");
            if (textResponse != null) {
                return textResponse;
            }
        }
        return "Почта с такими данными не найдена";
    }
}
