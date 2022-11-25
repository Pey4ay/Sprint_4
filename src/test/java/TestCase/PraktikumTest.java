package TestCase;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PraktikumTest {
    private WebDriver driver;

    @Test
    public void checkActivity() {
        // драйвер для браузера Chrome
        driver = new ChromeDriver();
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

        //Первичный набор тестовых данных
        String name = "Иван";
        String secondName = "Иванов";
        String address = "Ленинский";
        String telephonenumber = "+79998887766";
        String metroStation = "Черкизовская ";
        String dateOrder = "30.12.2022"; //Дату необходимо вводить в формате 00.00.0000
        String daysForRent = "сутки"; //Дни необходимо использовате те, которые в списке выбора на сайте
        String color = "чёрный жемчуг"; //Цвет выбирается из чекбокса на сайте
        String comment = "Купите по пути колу 0,5";

        HomePage homePage = new HomePage(driver);
        //Убираем вопрос о куки
        homePage.clickCookieButton();
        //Переходем к форме заказа
        homePage.clickOrderButton();

        FirstFormOrderPage firstFormOrderPage = new FirstFormOrderPage(driver);
        //Ждём загрузки формы
        firstFormOrderPage.waitForLoadOrderForm();
        //Заполняем первую форму
        firstFormOrderPage.sendInformationForOrder(name, secondName, address, telephonenumber, metroStation);
        //Переходим на вторую форму
        firstFormOrderPage.clickNextStepButton();

        SecondFormOderPage secondFormOderPage = new SecondFormOderPage(driver);
        //Заполняем вторую форму
        secondFormOderPage.sendInformationAboutSamokatOrder(dateOrder, daysForRent, color, comment);

    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}