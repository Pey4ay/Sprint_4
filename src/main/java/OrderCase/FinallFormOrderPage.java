package OrderCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FinallFormOrderPage {
    private WebDriver driver;
    //Локатор для нажатия кнопки "Да" на финальном этапе заказа
    private By yesButtonForOrder = By.xpath(".//button[text()='Да']");
    //Локатор для кнопки просмотра заказа
    //private By checkStatusOrder = By.xpath(".//button[text()='Посмотреть статус']");
    public FinallFormOrderPage(WebDriver driver){
        this.driver = driver;
    }

    //Метод с кнопкой финального соглашения по отправке (кнопка "Да")
    public void clickYesButtonForOrder(){
        driver.findElement(yesButtonForOrder).click();
    }

}
