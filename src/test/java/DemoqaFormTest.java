import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DemoqaFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }


    @Test
    void formTest() {

        //заполнение формы
        open("/automation-practice-form");
        $("#firstName").setValue("Daria"); //имя
        $("#lastName").setValue("Test"); //фамилия
        $("#userEmail").setValue("daria@test.com"); //почта
        $("#genterWrapper").$(byText("Female")).click(); //пол
        $("#userNumber").setValue("8900900999"); //телефон
        $("#dateOfBirthInput").click(); //открыть календарь
        $(".react-datepicker__year-select").$("option[value='1990']").click(); //год
        $(".react-datepicker__month-select").$("option[value='1']").click(); //месяц
        $(".react-datepicker__day--023").click(); //день
        $("#subjectsInput").setValue("Art").pressEnter(); // предметы
        $("#hobbiesWrapper").$(byText("Sports")).click(); // хобби
        $("#uploadPicture").uploadFromClasspath("tst.jpg"); // добавить файл
        $("#currentAddress").setValue("World"); // адрес
        $("#react-select-3-input").setValue("NCR").pressEnter(); // штат
        $("#react-select-4-input").setValue("Del").pressEnter(); // город
        $("#submit").click();


        //проверка
        $(".table-responsive").shouldHave(text("Daria Test"));
        $(".table-responsive").shouldHave(text("daria@test.com"));
        $(".table-responsive").shouldHave(text("Female"));
        $(".table-responsive").shouldHave(text("8900900999"));
        $(".table-responsive").shouldHave(text("23 February,1990"));
        $(".table-responsive").shouldHave(text("Art"));
        $(".table-responsive").shouldHave(text("Sport"));
        $(".table-responsive").shouldHave(text("tst.jpg"));
        $(".table-responsive").shouldHave(text("World"));
        $(".table-responsive").shouldHave(text("NCR Delhi"));

        System.out.println("Победа!");
    }
}
