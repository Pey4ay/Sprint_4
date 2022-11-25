package OrderCase;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class OrderCaseTest {
    private WebDriver driver;
    private final String name;
    private final String secondName;
    private final String address;
    private final String telephonenumber;
    private final String metroStation;
    private final String dateOrder;
    private final String daysForRent;
    private final String color;
    private final String comment;
    private final boolean checkResultTest;

    public OrderCaseTest(String name, String secondName, String address, String telephonenumber, String metroStation, String dateOrder, String daysForRent, String color, String comment, boolean checkResultTest) {
        this.name = name;
        this.secondName = secondName;
        this.address = address;
        this.telephonenumber = telephonenumber;
        this.metroStation = metroStation;
        this.dateOrder = dateOrder;
        this.daysForRent = daysForRent;
        this.color = color;
        this.comment = comment;
        this.checkResultTest = checkResultTest;
    }

    @Parameterized.Parameters
    public static Object[][] getCities() {
        //Сгенерируй тестовые данные (нам нужно название городов и результат поиска)
        return new Object[][]{
                {"Иван", "Иванов", "Ленинский", "+79998887766", "Черкизовская ", "30.11.2022", "сутки", "чёрный жемчуг", "Купите по пути колу 0,5", true},
                {"Петр", "Петров", "Брежневский", "+79997776655", "Черкизовская ", "31.12.2022", "двое суток", "серая безысходность", "Купите по пути спрайт 0,5", true},
        };
    }

    @Test
    public void checkActivity() {
        // драйвер для браузера Chrome
        driver = new FirefoxDriver();
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
        //Создаем объекты наших страниц
        HomePage homePage = new HomePage(driver);
        FirstFormOrderPage firstFormOrderPage = new FirstFormOrderPage(driver);
        SecondFormOderPage secondFormOderPage = new SecondFormOderPage(driver);
        FinallFormOrderPage finallFormOrderPage = new FinallFormOrderPage(driver);
        //___________________________________________________________
        //В данном блоке осуществляется работа со стартовой страницей
        //Убираем вопрос о куки
        homePage.clickCookieButton();
        //Переходем к форме заказа
        homePage.clickOrderButton();
        //-----------------------------------------------------------
        //В данном блоке осуществляется работа с первой формой заказа
        //Ждём загрузки формы
        firstFormOrderPage.waitForLoadOrderForm();
        //Заполняем первую форму
        firstFormOrderPage.sendInformationForOrder(name, secondName, address, telephonenumber, metroStation);
        //Переходим на вторую форму
        firstFormOrderPage.clickNextStepButton();
        //-----------------------------------------------------------
        //В данном блоке осуществляется работа второй формы заказа
        //Заполняем вторую форму
        secondFormOderPage.sendInformationAboutSamokatOrder(dateOrder, daysForRent, color, comment);
        secondFormOderPage.clickOrderSamokatButton();
        //-----------------------------------------------------------
        //Нажимаем кнопку согласия на заказ
        finallFormOrderPage.clickYesButtonForOrder();
        //___________________________________________________________
        //Тест будет выполнен, если мы обнаружим форму с сообщением о том, что заказ оформлен
        List<WebElement> elements = driver.findElements(By.xpath(".//button[text()='Посмотреть статус']"));
        assertEquals(checkResultTest, elements.size() != 0);
    }
    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}