package ui.page.contact;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Map;

public class ContactPage {
    WebDriver driver;

    public ContactPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@id='contact-first-name']")
    WebElement firstNameField;

    @FindBy(xpath = "//div[@id='contact-last-name']")
    WebElement lastNameField;

    @FindBy(xpath = "//div[@id='contact-description']")
    WebElement contactDescription;

    @FindBy(xpath = "//button[@id=\"btn-edit-contact\"]")
    WebElement editContactButton;

    @FindBy(xpath = "//button[@id=\"btn-edit-contact\"]")
    WebElement firstNameFieldEdit;

    @FindBy(xpath = "//input[@name=\"input-ec-lastName\"]")
    WebElement lastNameFieldEdit;

    @FindBy(xpath = "//textarea[@name=\"input-ec-description\"]")
    WebElement contactDescriptionFieldEdit;

    @FindBy(xpath = "//button[normalize-space()=\"Save\"]")
    WebElement saveButtonEditContact;

    // int x = 1
    // List<Integer> list = new ArrayList();
    // [1, 2, 5, 13, 34, 89]
//    Map<String, String> map
//    [{key: value}, {key: value}, {key: value}]
//    [{"Имя": "Константин"}, {"Фамилия": Замотаев}, {"Возраст": "37"}]


    public Map<String, String> getInfo() {
        Map<String, String> info = new HashMap<>();
        info.put("first name", firstNameField.getText());
        info.put("last name", lastNameField.getText());
        info.put("contact description", contactDescription.getText());
        return info;
    }

    public void editContact(String firsName, String lastName, String about) {
        editContactButton.click();
        firstNameFieldEdit.clear();
        firstNameFieldEdit.sendKeys(firsName);
        lastNameFieldEdit.clear();
        lastNameFieldEdit.sendKeys(lastName);
        contactDescriptionFieldEdit.clear();
        contactDescriptionFieldEdit.sendKeys(about);
        saveButtonEditContact.click();
    }

}
