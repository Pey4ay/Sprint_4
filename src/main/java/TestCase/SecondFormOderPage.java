package TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecondFormOderPage {
    private WebDriver driver;

    //Локатор для выбора даты привоза самоката
    private By editDateOrder = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    //Локатор для клика по календарю
    private String clickEditDateOrder = ".//div[text()='%s']";

    //Локатор для выбора срока аренды
    private By clickdaysForRent = By.className("Dropdown-placeholder");

    //Локатор для передачи количества дней аренды
    private String daysForRentSend = ".//div[@class='Dropdown-menu']/div[text()='%s']";

    //Локатор для выбора цвета
    private String chooseColor = ".//div[@class='Order_Checkboxes__3lWSI']/label[text()='%s']";

    //Локатор для комментарий курьеру
    private By commentForCourier = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    //Локатор для кнопки оформления заказа
    private By orderSamokatButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM'][last()]");

    public SecondFormOderPage(WebDriver driver){
        this.driver = driver;
    }

    //Метод который передает информацию о дате заказа, цвете и количестве дней аренды
    public void sendInformationAboutSamokatOrder(String dateOrder, String daysForRent, String color, String comment){
        //драйверы для ввода даты начала аренды
        driver.findElement(editDateOrder).sendKeys(dateOrder);
        driver.findElement(By.xpath(String.format(clickEditDateOrder, dateOrder.substring(0, 2)))).click();
        //Драйверы для выбора срока аренды
        driver.findElement(clickdaysForRent).click();
        driver.findElement(By.xpath(String.format(daysForRentSend, daysForRent))).click();
        //Драйвер для выбора цвета самоката
        driver.findElement(By.xpath(String.format(chooseColor,color))).click();
        //Драйвер для комментария
        driver.findElement(commentForCourier).sendKeys(comment);
    }

    //Метод с кнопкой, которая отправляет полностью все данные
    public void clickOrderSamokatButton(){
        driver.findElement(orderSamokatButton).click();
    }
}
