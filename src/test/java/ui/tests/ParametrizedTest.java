package ui.tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import ui.page.MenuEl;
import ui.page.contact.AddNewContactWindow;
import ui.page.contact.ContactPage;
import ui.page.login.LoginPage;
import ui.utils.DataProviders;
import org.testng.annotations.Test;

import java.util.Map;

public class ParametrizedTest extends TestBase{
    Faker faker = new Faker();
    MenuEl menu;
    AddNewContactWindow addNewContactWindow;
    ContactPage contactPage;
    LoginPage loginPage;

    @BeforeMethod
    public void precondition() {
        loginPage = new LoginPage(driver);
        loginPage.getLogin(EMAIL, PASSWORD);
    }

    @Test(dataProvider = "newContact", dataProviderClass = DataProviders.class)
    public void addNewContactDataProvider(String firstName, String lastName, String about) {
        menu = new MenuEl(driver);
        menu.clickToAddNewContactMenuLink();
        addNewContactWindow = new AddNewContactWindow(driver);
        addNewContactWindow.fillData(firstName, lastName, about);
        contactPage = new ContactPage(driver);

        Map<String, String> info = contactPage.getInfo();

        Assert.assertEquals(info.get("first name"), firstName);
        Assert.assertEquals(info.get("last name"), lastName);
        Assert.assertEquals(info.get("contact description"), about);
    }

    @Test(dataProvider = "newContactWithCSV", dataProviderClass = DataProviders.class)
    public void addNewContactDataProviderCsv(String firstName, String lastName, String about) {
        menu = new MenuEl(driver);
        menu.clickToAddNewContactMenuLink();
        addNewContactWindow = new AddNewContactWindow(driver);
        addNewContactWindow.fillData(firstName, lastName, about);
        contactPage = new ContactPage(driver);

        Map<String, String> info = contactPage.getInfo();

        Assert.assertEquals(info.get("first name"), firstName);
        Assert.assertEquals(info.get("last name"), lastName);
        Assert.assertEquals(info.get("contact description"), about);
    }


}
