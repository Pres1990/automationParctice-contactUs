package com.filipWojiechowski;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class contactUs {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pres\\Desktop\\selenium\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        if(driver.getTitle().equals("My Store")){ // Check main page
            System.out.println("Main page name is correct: " + driver.getTitle());
        }else{
            System.out.println("Main page name is incorrect: " +driver.getTitle());
        }

        driver.findElement(By.xpath("//*[@id='contact-link']")).click(); // go to the contact us page

        if(driver.getTitle().equals("Contact us - My Store")){ // check contact page
            System.out.println("Contact page name is correct: " + driver.getTitle());
        }else {
            System.out.println("Contact page name is incorrect:" + driver.getTitle());
        }

        Select s = new Select(driver.findElement(By.xpath("//*[@name='id_contact']"))); //select option from the dropmenu
        s.selectByValue("2");
        if (driver.findElement(By.xpath("//*[@id='desc_contact2']")).isDisplayed()) { //check visibility of the message
            System.out.println("Message is Displayed");

            String message = driver.findElement(By.id("desc_contact2")).getText(); //check message
            if (message.equals("For any question about a product, an order")) {
                System.out.println("Message is correct: " + message);
            } else {
                System.out.println("Message is incorrect" + message);
            }

        }else if(driver.findElement(By.xpath("//*[@id='desc_contact1']")).isDisplayed()) {
            String message = driver.findElement(By.id("desc_contact1")).getText();
            System.out.println("Wrong message is displayed: " + message);
        }
        else if(!driver.findElement(By.xpath("//*[@id='desc_contact2']")).isDisplayed()){
            System.out.println("Message is not displayed");
        }
        driver.findElement(By.xpath("//*[@id='email']")).sendKeys("test@gmail.com"); // enter email adress
        driver.findElement(By.xpath("//*[@id='id_order']")).sendKeys("001/October/2018"); //enter order ID
        driver.findElement(By.xpath("//*[@name='fileUpload']")).sendKeys("C:\\Users\\Pres\\Desktop\\Example.txt"); // select file for upload
        driver.findElement(By.xpath("//*[@id='message']")).sendKeys("test"); // enter message
        driver.findElement(By.xpath("//*[@id='submitMessage']")).click(); // send message

        if(driver.findElement(By.xpath("//*[@id='center_column']")).isDisplayed()){ //check whether form has been sent or not
            System.out.println("Contact form has been sent");
        }












    }
}
