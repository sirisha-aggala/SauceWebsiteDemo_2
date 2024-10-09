package StepDefinition;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.firefox.FirefoxOptions;

import pageObjects.LoginBasePage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.cucumber.java.en.*;

import pageObjects.LoginBasePage;


import java.sql.DriverManager;



public class LoginStepDef {
    //WebDriver driver;
  //  FirefoxOptions firefoxoptions = new FirefoxOptions();
       //System.setProperty ("webdriver.chrome.driver",".\\chromedriver.exe" );

       WebDriver driver  = new ChromeDriver();

    LoginBasePage loginPgObj = new LoginBasePage(driver);



    @Given("user launches the url of the application")
    public void user_launches_the_url_of_the_application() throws InterruptedException {
        loginPgObj.getURL("https://www.saucedemo.com/");

    }

    @When("enters valid credentials as username and password as below")
    public void enters_valid_credentials_as_username_and_password_as_below(DataTable dataTable) {
        System.out.println("In datatable method");
        List<List<String>> testdata = dataTable.asLists(String.class);
        for (List<String> s: testdata)
        {
            System.out.println("In For loop");
            String expmsg = "Epic sadface: Sorry, this user has been locked out.";
            String errmsg = " ";
            loginPgObj.loginToSauceDemo(s.get(0),s.get(1));
            loginPgObj.click_on_login();
            if (driver.getCurrentUrl().compareTo("https://www.saucedemo.com/") == 0)
            {
                errmsg = driver.findElement(By.xpath("//h3[@data-test=\"error\"]")).getText();
                Assert.assertEquals(expmsg,errmsg);

            }
            else
            {
                driver.findElement(By.xpath("//button[@id=\"react-burger-menu-btn\"]")).click();
                driver.findElement(By.xpath("//a[text()='Logout']")).click();
            }

        }

    }





    @When("enters valid credentials as {string} and {string}")
    public void enters_valid_credentials_as_and(String string, String string2) {
        loginPgObj.loginToSauceDemo(string,string2);
        String Currenturl = driver.getCurrentUrl();
        System.out.println("Current Url in loginToSauceDemo method : " + Currenturl);


    }

    @When("click on Login button")
    public void click_on_login_button() throws InterruptedException {

      loginPgObj.click_on_login();
        System.out.println("In When 2");
        Thread.sleep(5000);

       String cart_count = loginPgObj.add_to_cart();
        System.out.println("cart count is : " +cart_count);


        //Go back to the products page
       //loginPgObj.go_back_to_products();
       // Thread.sleep(3000);



    }

    @Then("usershould be able to land on home page of the application")
    public void usershould_be_able_to_land_on_home_page_of_the_application() {
        driver.close();
        System.out.println("In Then");
        //driver.navigate().back();


    }



}

