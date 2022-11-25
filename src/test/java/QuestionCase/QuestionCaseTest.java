package QuestionCase;


import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class QuestionCaseTest {
    private WebDriver driver;
    private final String numberQuestion;
    private final String firstAnswer;
    private final boolean isThisAnswer;

    public QuestionCaseTest(String numberQuestion, String firstAnswer, boolean isThisAnswer){
        this.numberQuestion = numberQuestion;
        this.firstAnswer = firstAnswer;
        this.isThisAnswer = isThisAnswer;
    }

    @Parameterized.Parameters
    public static Object[][] getQuestion(){
        return new Object[][]{
                {"1", "Сутки — 400 рублей. Оплата курьеру — наличными или картой.", true},
                {"2", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", true},
                {"3", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", true},
                {"4", "Только начиная с завтрашнего дня. Но скоро станем расторопнее.", true},
                {"5", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", true},
                {"6", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", true},
                {"7", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", true},
                {"8", "Да, обязательно. Всем самокатов! И Москве, и Московской области.", true},
        };
    }

    @Test
    public void checkActivity() {
        // драйвер для браузера Chrome
        driver = new FirefoxDriver();
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomePageQuestion homePageQuestion = new HomePageQuestion(driver);
        homePageQuestion.clickCookieButton();
        boolean checkFirstQuestion = firstAnswer.equals(homePageQuestion.clickFirstQuestion(numberQuestion));
        assertEquals(isThisAnswer, checkFirstQuestion);
    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}