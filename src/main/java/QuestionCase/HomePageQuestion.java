package QuestionCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class HomePageQuestion {
    private WebDriver driver;
    //Локатор для куки кнопки
    private By cookieButton = By.className("App_CookieButton__3cvqF");
    //Локатор для вопросов
    private String question = ".//div[@class='accordion']/div[%s]/div/div";
    //Локатор для ответа на вопрос question
    private String answer = ".//div[@class='accordion']/div[%s]/div[2]/p";

    public HomePageQuestion(WebDriver driver){
        this.driver = driver;
    }

    //Метод с кнопкой куки
    public void clickCookieButton(){
        driver.findElement(cookieButton).click();
    }
    //Метод который ищет нужный вопрос и извлекает ответ
    public String clickQuestion(String questionNumber){
        WebElement firstQuestionElement = driver.findElement(By.xpath(String.format(question, questionNumber))); //подставляем в локатор номер вопроса
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", firstQuestionElement); //скролим до необходимого вопроса
        driver.findElement(By.xpath(String.format(question, questionNumber))).click();//кликаем для открытия ответа на вопрос
        return driver.findElement(By.xpath(String.format(answer, questionNumber))).getText(); //возвращаем ответ на вопрос
    }

}
