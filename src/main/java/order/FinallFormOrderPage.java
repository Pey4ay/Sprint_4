package order;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FinallFormOrderPage {
    private WebDriver driver;
    //Локатор для нажатия кнопки "Да" на финальном этапе заказа
    private By yesButtonForOrder = By.xpath(".//button[text()='Да']");
    //Локатор для кнопки просмотра заказа
    private By statusOrder = By.xpath(".//button[text()='Посмотреть статус']");
    public FinallFormOrderPage(WebDriver driver){
        this.driver = driver;
    }
    //Метод с кнопкой финального соглашения по отправке (кнопка "Да")
    public void clickYesButtonForOrder(){
        driver.findElement(yesButtonForOrder).click();
    }
    //Метод который возвращает наличие формы статуса заказа
    public List<WebElement> checkStatusOrder(){
        List<WebElement> elements = driver.findElements(statusOrder);
        return elements;
    }

}
