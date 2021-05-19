package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTests  {

    @BeforeAll
    static void setStartConfig() {
        Configuration.startMaximized = true;
    }

    @Test
    void successfulSubmitFormTest() {
        open("https://demoqa.com/automation-practice-form");

        $("[id=firstName]").setValue("Artsiom");
        $("[id=lastName]").setValue("Rusau");
        $("[id=userEmail]").setValue("123@test.com");
        $("[for=gender-radio-1]").click();
        $("[id=userNumber]").setValue("1234567890");

        //BirthDate
        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1993");
        $("[aria-label='Choose Monday, July 26th, 1993']").click();
        //BirthDate

        $("[id=subjectsInput]").setValue("ph").pressEnter();
        $("[for=hobbies-checkbox-2]").click();
        $("[id=currentAddress]").setValue("Belarus, Minsk");
        $("[id=react-select-3-input]").setValue("NCR").pressEnter();
        $("[id=react-select-4-input]").setValue("Del").pressEnter();
        $("[id=submit]").click();


        $(".table-responsive").shouldHave(text("Artsiom Rusau"), text("123@test.com"),
                text("Male"), text("1234567890"), text("26 July,1993"), text("Physics"),
                text("Reading"), text("Belarus, Minsk"),
                text("NCR Delhi"));

    }
}
