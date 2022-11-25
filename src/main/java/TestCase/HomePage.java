package TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage {
    private WebDriver driver;
    //Локатор для кнопки "Заказать" на главной странице
    private By goToOrderButton = By.xpath(".//button[text()='Заказать']");
    //Локатор для куки кнопки
    private By cookieButton = By.className("App_CookieButton__3cvqF");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    //Метод с кнопкой куки
    public void clickCookieButton(){
        driver.findElement(cookieButton).click();
    }

    //Метод который нажимает на кнопку заказа
    public void clickOrderButton(){
        driver.findElement(goToOrderButton).click();
    }


}
