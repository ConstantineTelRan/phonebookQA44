package api.tests.contact;

import api.EndPoint;
import api.model.contact.ContactDto;
import api.tests.ApiBase;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UpdateContactTest extends ApiBase {
    Response response;
    int id;
    ContactDto contactDto;
    ContactDto updateContactDto;

    @BeforeMethod
    public void precondition() {
        contactDto = new ContactDto();
        contactDto.setFirstName(faker.name().firstName());
        contactDto.setLastName(faker.name().lastName());
        contactDto.setDescription(faker.lorem().sentence(4));

        response = doPostRequest(contactDto, EndPoint.ADD_NEW_CONTACT, 201);
        id = response.jsonPath().getInt("id");
    }

    @AfterMethod
    public void afterTest() {
        doDeleteRequest(id, EndPoint.DELETE_CONTACT_BY_CONTACT_ID, 200);
    }

    @Test
    public void updateContactTest() {
        updateContactDto = new ContactDto();
        updateContactDto.setId(id);
        updateContactDto.setFirstName(faker.name().firstName());
        updateContactDto.setLastName(faker.name().lastName());
        updateContactDto.setDescription(faker.lorem().sentence(4));

        doPutRequest(updateContactDto, EndPoint.UPDATE_CONTACT, 200);
        response = doGetRequestWithParam(id, EndPoint.GET_CONTACT_BY_CONTACT_ID, 200);

        Assert.assertEquals(response.jsonPath().getInt("id"), updateContactDto.getId());
        Assert.assertEquals(response.jsonPath().getString("firstName"), updateContactDto.getFirstName());
        Assert.assertEquals(response.jsonPath().getString("lastName"), updateContactDto.getLastName());
        Assert.assertEquals(response.jsonPath().getString("description"), updateContactDto.getDescription());

        Assert.assertNotEquals(response.jsonPath().getString("firstName"), contactDto.getFirstName());
    }


}
