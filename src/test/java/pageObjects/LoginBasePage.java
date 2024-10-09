package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.sql.DriverManager;

import java.util.concurrent.TimeUnit;
import java.time.Duration;

public class LoginBasePage {

    WebDriver driver;

    public LoginBasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);


    }


    @FindBy(id = "user-name")
    WebElement webEle_Username;

    @FindBy(id = "password")
    WebElement webEle_password;


    @FindBy(id = "login-button")
    WebElement webEle_loginbutton;

    @FindBy(xpath = "//button[contains(@id,\"to-products\")]")
    public WebElement webEle_backToProducts;


    /*  private By webEle_Username = By.id("user-name");
      private By webEle_password = By.id("password");
      private By webEle_loginbutton = By.id("login-button");
      private By webELe_backToProducts = By.xpath("//button[contains(@id,\"to-products\")]");
     */
    public void getURL(String url) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", ".\\chrome.exe");
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        String title = driver.getTitle();
        System.out.println("title : " + title);
        System.out.println("in getURL method in Login Base Page");
        Thread.sleep(3000);
    }

    public void loginToSauceDemo(String username, String password) {
        webEle_Username.sendKeys(username);
        webEle_password.sendKeys(password);


    }


    public void click_on_login() {
        webEle_loginbutton.click();
    }


    public String add_to_cart() throws InterruptedException {
        String str = "SIrisha";
        //change filter i.e, select an item from the dropdown box for price/name filter
        WebElement SwiftyDropbox = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select"));
        Actions actions = new Actions(driver);
        actions.scrollToElement(SwiftyDropbox).perform();
        Thread.sleep(3000);
        System.out.println("found element in drop box");
        String dropitemstring = SwiftyDropbox.getText();
        System.out.println("found string in drop box : " + dropitemstring);
        boolean avlbldis = SwiftyDropbox.isDisplayed();
        System.out.println("is element hilo displayed? " + avlbldis);
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[3]")).click();
        Thread.sleep(3000);

        boolean dis =driver.findElement(By.xpath("//a[contains(text(),'Facebook')]")).isDisplayed();
        System.out.println("is facebook displayed on viewport: " +dis);


        // To scroll t the bottom of the page
        Actions act = new Actions(driver);
        act.scrollByAmount(0, 1878);
        Thread.sleep(4000);
        //boolean dis = driver.findElement(By.xpath("//a[contains(text(),'Facebook')]")).isDisplayed();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Facebook')]"))).click();

      //  System.out.println("is facebook displayed on viewport: " +dis);
        Thread.sleep(4000);
        return str;
    }

    /*
        //To bring a product to viewport
        //to find onesie product which is out of viewport and to click it
        WebElement sauceonesie= driver.findElement(By.xpath("//a[@data-test=\"item-2-title-link\"]"));
        Actions actions2 = new Actions(driver);
        actions2.scrollToElement(sauceonesie).perform();
       Thread.sleep(3000);
        System.out.println("Before clicking on the onesie product");
        driver.findElement(By.xpath("//a[@data-test=\"item-2-title-link\"]")).click();
        System.out.println("After clicking on the onesie product");
        Thread.sleep(3000);
        //   add to the cart and check if the count on the cart is incremented
        driver.findElement(By.name("add-to-cart")).click();
        String s3 = driver.findElement(By.xpath("//span[contains(@class,'badge')]")).getText();
        System.out.println("String S3: " +s3);
        return s3; */


        public void go_back_to_products ()
        {
            webEle_backToProducts.click();

        }
    }
