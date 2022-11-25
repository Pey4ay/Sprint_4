package QuestionCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class HomePageQuestion {
    private WebDriver driver;
    //Локатор для куки кнопки
    private By cookieButton = By.className("App_CookieButton__3cvqF");
    //Локатор для вопроса - Сколько это стоит? И как оплатить?
    private String firstQuestion = ".//div[@class='accordion__heading'][%s]";
    //Локатор для ответа на вопрос firstQuestion
    private String firstAnswer = ".//div[@class='accordion__panel'][%s]";

    public HomePageQuestion(WebDriver driver){
        this.driver = driver;
    }

    //Метод с кнопкой куки
    public void clickCookieButton(){
        driver.findElement(cookieButton).click();
    }
    //Метод который получает текст из первого вопроса
    public String clickFirstQuestion(String questionNumber){
        WebElement firstQuestionElement = driver.findElement(By.xpath(String.format(firstQuestion, questionNumber)));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", firstQuestionElement);
        driver.findElement(By.xpath(String.format(firstQuestion, questionNumber))).click();
        return driver.findElement(By.xpath(String.format(firstAnswer, questionNumber))).getText();
    }

}
