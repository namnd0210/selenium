/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestLogin;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

/**
 *
 * @author NguyenTheNghi
 */
public class LoginTest {
	WebDriver driver;

	public void LoginTest() {
	}

	// Đăng nhập đúng chuyển qua trang tiếp theo
	@Test
	public void testLogin() {
		WebElement txtlogin = this.driver.findElement(By.xpath("//*[@id=\"mgv\"]"));
		txtlogin.sendKeys("demo");
		WebElement txtpassword = this.driver.findElement(By.xpath("//*[@id=\"password\"]"));
		txtpassword.sendKeys("1234567" + Keys.ENTER);

		String expectURL = driver.getCurrentUrl();
		String actuaURL = "http://localhost:8080/SQA_QLDT/CheckLoginUser";
		Assertions.assertEquals(expectURL, actuaURL);
	}

	// Không nhập mật khẩu
	@Test
	public void testLoginEmpty8() {
		WebElement txtusername = this.driver.findElement(By.xpath("//*[@id=\"mgv\"]"));
		txtusername.sendKeys("demo");
		WebElement btnDangnhap = this.driver.findElement(By.xpath("//*[@id=\"form-1\"]/button"));
		btnDangnhap.click();
		WebElement txtThongbao = this.driver.findElement(By.xpath("//*[@id=\"form-1\"]/div[3]/span"));
		Assertions.assertEquals("Vui lòng nhập mật khẩu", txtThongbao.getText());
	}

	// Không nhập 
	@Test
	public void testLoginEmpty9() {

		WebElement txtpassword = this.driver.findElement(By.xpath("//*[@id=\"password\"]"));
		txtpassword.sendKeys("123456");
		WebElement btnDangnhap = this.driver.findElement(By.xpath("//*[@id=\"form-1\"]/button"));
		btnDangnhap.click();
		WebElement txtThongbao = this.driver.findElement(By.xpath("//*[@id=\"form-1\"]/div[2]/span"));
		Assertions.assertEquals("Vui lòng nhập MGV", txtThongbao.getText());

	}

	// Đăng nhập với tài khoản mật khẩu , đều rỗng
	@Test
	public void testLoginEmpty() throws InterruptedException {
		WebElement btnDangnhap = this.driver.findElement(By.xpath("//*[@id=\"form-1\"]/button"));
		btnDangnhap.click();

		Thread.sleep(1000);

		WebElement txtThongbao = this.driver.findElement(By.xpath("//*[@id=\"form-1\"]/div[2]/span"));
		WebElement txtThongbao2 = this.driver.findElement(By.xpath("//*[@id=\"form-1\"]/div[3]/span"));
		Assertions.assertEquals("Vui lòng nhập mật khẩu", txtThongbao2.getText());
		Assertions.assertEquals("Vui lòng nhập MGV", txtThongbao.getText());

	}

	// Đăng nhập với tài khoản đúng mật khẩu sai
	@Test
	public void testLoginEmpty2() {
		WebElement txtusername = this.driver.findElement(By.xpath("//*[@id=\"mgv\"]"));
		txtusername.sendKeys("demo");
		WebElement txtpassword = this.driver.findElement(By.xpath("//*[@id=\"password\"]"));
		txtpassword.sendKeys("123456");
		WebElement btnDangnhap = this.driver.findElement(By.xpath("//*[@id=\"form-1\"]/button"));
		btnDangnhap.click();
		WebElement txtThongbao = this.driver.findElement(By.xpath("//*[@id=\"form-1\"]/div[1]/span"));
		Assertions.assertEquals("Sai Thông tin đăng nhập, vui lòng nhập lại!!!", txtThongbao.getText());

	}

	// Đăng nhập với tài khoản sai mật khẩu đúng
	@Test
	public void testLoginEmpty3() {
		WebElement txtusername = this.driver.findElement(By.xpath("//*[@id=\"mgv\"]"));
		txtusername.sendKeys("demo1000");
		WebElement txtpassword = this.driver.findElement(By.xpath("//*[@id=\"password\"]"));
		txtpassword.sendKeys("1234567");
		WebElement btnDangnhap = this.driver.findElement(By.xpath("//*[@id=\"form-1\"]/button"));
		btnDangnhap.click();
		WebElement txtThongbao = this.driver.findElement(By.xpath("//*[@id=\"form-1\"]/div[1]/span"));
		Assertions.assertEquals("Sai Thông tin đăng nhập, vui lòng nhập lại!!!", txtThongbao.getText());

	}

	// Đăng nhập với tài khoản sai mật khẩu sai
	@Test
	public void testLoginEmpty4() throws InterruptedException {
		WebElement txtusername = this.driver.findElement(By.xpath("//*[@id=\"mgv\"]"));
		txtusername.sendKeys("demo1000");
		Thread.sleep(3000);
		WebElement txtpassword = this.driver.findElement(By.xpath("//*[@id=\"password\"]"));
		txtpassword.sendKeys("1234567");
		Thread.sleep(3000);
		WebElement btnDangnhap = this.driver.findElement(By.xpath("//*[@id=\"form-1\"]/button"));
		btnDangnhap.click();
		Thread.sleep(3000);
		WebElement txtThongbao = this.driver.findElement(By.xpath("//*[@id=\"form-1\"]/div[1]/span"));
		Assertions.assertEquals("Sai Thông tin đăng nhập, vui lòng nhập lại!!!", txtThongbao.getText());
	}

	// Đăng nhập với tài khoản mật khẩu ký tự đặc biết
	@Test
	public void testLoginEmpty5() {
		WebElement txtusername = this.driver.findElement(By.xpath("//*[@id=\"mgv\"]"));
		txtusername.sendKeys("@:))");
		WebElement txtpassword = this.driver.findElement(By.xpath("//*[@id=\"password\"]"));
		txtpassword.sendKeys("muonlaco@@@");
		WebElement btnDangnhap = this.driver.findElement(By.xpath("//*[@id=\"form-1\"]/button"));
		btnDangnhap.click();
		WebElement txtThongbao = this.driver.findElement(By.xpath("//*[@id=\"form-1\"]/div[2]/span"));
		Assertions.assertEquals("MGV không bao gồm các ký tự đặc biệt!", txtThongbao.getText());
	}

	// Đăng nhập với tài khoản gồm ký tựu đặc biệt mật khẩu bình thường
	@Test
	public void testLoginEmpty6() {
		WebElement txtusername = this.driver.findElement(By.xpath("//*[@id=\"mgv\"]"));
		txtusername.sendKeys("@:))"); 
		WebElement txtpassword = this.driver.findElement(By.xpath("//*[@id=\"password\"]"));
		txtpassword.sendKeys("muonlaco1999");
		WebElement btnDangnhap = this.driver.findElement(By.xpath("//*[@id=\"form-1\"]/button"));
		btnDangnhap.click();
		WebElement txtThongbao = this.driver.findElement(By.xpath("//*[@id=\"form-1\"]/div[2]/span"));
		Assertions.assertEquals("MGV không bao gồm các ký tự đặc biệt!", txtThongbao.getText());
	}

	// Đăng nhập với tài khoản bình thường mật khẩu ký tự đặc biết
	@Test
	public void testLoginEmpty7() {
		WebElement txtusername = this.driver.findElement(By.xpath("//*[@id=\"mgv\"]"));
		txtusername.sendKeys("demo");
		WebElement txtpassword = this.driver.findElement(By.xpath("//*[@id=\"password\"]"));
		txtpassword.sendKeys("@chaobanhuhu");
		WebElement btnDangnhap = this.driver.findElement(By.xpath("//*[@id=\"form-1\"]/button"));
		btnDangnhap.click();
		WebElement txtThongbao = this.driver.findElement(By.xpath("//*[@id=\"form-1\"]/div[2]/span"));
//        Assertions.assertEquals("MGV không bao gồm các ký tự đặc biệt!",txtThongbao.getText());
	}

	// hàm chạy trước mỗi hàm test
	@BeforeEach
	public void setUP() throws InterruptedException {
		EdgeOptions option = new EdgeOptions();
		System.setProperty("webdriver.edge.driver", "C:\\Users\\ducnam\\Desktop\\WIP\\SQA\\msedgedriver.exe");
		this.driver = new EdgeDriver(option);
		this.driver.get("http://localhost:8080/SQA_QLDT/");

	}

	@AfterEach
	public void tearDowd() {
		this.driver.quit();
	}
}
