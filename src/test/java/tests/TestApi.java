package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static constants.Constants.*;
import static responseApi.GetEmail.getEmail;
import static responseApi.GetEmailWithPagination.getEmailPagination;

public class TestApi {
    @Test
    public void TestApi() {
        String email = getEmail(firstName, lastName);
        Assert.assertEquals(email, MailConstant);
    }
    @Test
    public void TestApiPagination(){
        String paginationEmail = getEmailPagination(otherFirstName,otherLastName);
        Assert.assertEquals(paginationEmail,paginationEmailConstant);
    }

}
