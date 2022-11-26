package order;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class FirstFormOrderPage {
    private WebDriver driver;

    //Локатор для поля "Имя"
    private By nameField = By.xpath(".//input[@placeholder='* Имя']");
    //Локатор для поля "Фамилия"
    private By secondNameField = By.xpath(".//input[@placeholder='* Фамилия']");
    //Локатор для поля "адрес"
    private By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Локатор для поля "Телефон:..."
    private By telephoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Локатор для поля "Станция метро"
    private By chooseMetroStationField = By.xpath(".//input[@placeholder='* Станция метро']");

    //Нажатие кнопки выбора станции метро (всегда выбирается первая, так как в условии не стоит выбора цвета ветки)
    private By chooseFirstMetroStationField = By.className("select-search__select");

    //Локатор для кнопки "Далее" на странице оформления заказа
    private By nextStepButton = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button");

    public FirstFormOrderPage(WebDriver driver){
        this.driver = driver;
    }

    //Метод ожидания загрузки формы
    public void waitForLoadOrderForm() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public void sendInformationForOrder(String name, String secondName, String address, String telephonenumber, String metroStation){
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(secondNameField).sendKeys(secondName);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(telephoneField).sendKeys(telephonenumber);
        driver.findElement(chooseMetroStationField).sendKeys(metroStation);
        driver.findElement(chooseFirstMetroStationField).click();
    }

    //Метод с кнопкой, которая переключает на следующую страницу заказа отправляет данные о заказе
    public void clickNextStepButton(){
        driver.findElement(nextStepButton).click();
    }
}
