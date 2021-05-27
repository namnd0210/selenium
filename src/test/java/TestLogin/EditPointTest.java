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
import org.openqa.selenium.interactions.Actions;

public class EditPointTest {
	WebDriver driver;

	// -------------------------------------- Điểm CC
	// ------------------------------------------------
	// nhập số âm
	@Test
	public void EditTest1() {
		WebElement txtDiemCC = this.driver.findElement(By.xpath("//*[@id=\"diem-cc\"]"));
		txtDiemCC.clear();
		txtDiemCC.sendKeys("-1");

		WebElement txtDiemTP = this.driver.findElement(By.xpath("//*[@id=\"diem-tp1\"]"));
		txtDiemTP.click();

		WebElement errorMess = this.driver.findElement(By.xpath("//*[@id=\"form-2\"]/div[1]/div/span"));
		Assertions.assertEquals("Giá trị điểm cho phép từ 0 - 10", errorMess.getText());
	}

	// nhập kỳ tự không phải số
	@Test
	public void EditTest2() {
		WebElement txtDiemCC = this.driver.findElement(By.xpath("//*[@id=\"diem-cc\"]"));
		txtDiemCC.clear();
		txtDiemCC.sendKeys("@@");

		WebElement txtDiemTP = this.driver.findElement(By.xpath("//*[@id=\"diem-tp1\"]"));
		txtDiemTP.click();

		WebElement errorMess = this.driver.findElement(By.xpath("//*[@id=\"form-2\"]/div[1]/div/span"));
		Assertions.assertEquals("Điểm không bao gồm chuỗi và các ký tự đặc biệt", errorMess.getText());
	}

	// ký tự chuôi
	@Test
	public void EditTest3() {
		WebElement txtDiemCC = this.driver.findElement(By.xpath("//*[@id=\"diem-cc\"]"));
		txtDiemCC.clear();
		txtDiemCC.sendKeys("ab");

		WebElement txtDiemTP = this.driver.findElement(By.xpath("//*[@id=\"diem-tp1\"]"));
		txtDiemTP.click();

		WebElement errorMess = this.driver.findElement(By.xpath("//*[@id=\"form-2\"]/div[1]/div/span"));
		Assertions.assertEquals("Điểm không bao gồm chuỗi và các ký tự đặc biệt", errorMess.getText());
	}

	// 2 chữ số sau dấu phẩy , nhiều hơn 2 ký tự sau dấu ,
	@Test
	public void EditTest4() {
		WebElement txtDiemCC = this.driver.findElement(By.xpath("//*[@id=\"diem-cc\"]"));
		txtDiemCC.clear();
		txtDiemCC.sendKeys("5.444");

		WebElement txtDiemTP = this.driver.findElement(By.xpath("//*[@id=\"diem-tp1\"]"));
		txtDiemTP.click();

		WebElement errorMess = this.driver.findElement(By.xpath("//*[@id=\"form-2\"]/div[1]/div/span"));
		Assertions.assertEquals("Chỉ phép nhập 2 chữ số sau dấu '.'", errorMess.getText());
	}

	// nhập số nhỏ hơn 10
	@Test
	public void EditTest5() {
		WebElement txtDiemCC = this.driver.findElement(By.xpath("//*[@id=\"diem-cc\"]"));
		txtDiemCC.clear();
		txtDiemCC.sendKeys("5");

		WebElement txtDiemTP = this.driver.findElement(By.xpath("//*[@id=\"diem-tp1\"]"));
		txtDiemTP.click();

		WebElement errorMess = this.driver.findElement(By.xpath("//*[@id=\"form-2\"]/div[1]/div/span"));
		Assertions.assertNotEquals("Điểm không bao gồm chuỗi và các ký tự đặc biệt", errorMess.getText());
		Assertions.assertNotEquals("Chỉ phép nhập 2 chữ số sau dấu '.'", errorMess.getText());
		Assertions.assertNotEquals("Giá trị điểm cho phép từ 0 - 10", errorMess.getText());
	}

	// nhập số lớn hơn 10
	@Test
	public void EditTest6() {
		WebElement txtDiemCC = this.driver.findElement(By.xpath("//*[@id=\"diem-cc\"]"));
		txtDiemCC.clear();
		txtDiemCC.sendKeys("10.5");

		WebElement txtDiemTP = this.driver.findElement(By.xpath("//*[@id=\"diem-tp1\"]"));
		txtDiemTP.click();

		WebElement errorMess = this.driver.findElement(By.xpath("//*[@id=\"form-2\"]/div[1]/div/span"));
		Assertions.assertEquals("Giá trị điểm cho phép từ 0 - 10", errorMess.getText());
	}

	// -------------------------------------- Điểm TP1
	// ------------------------------------------------
	// nhập số âm
	@Test
	public void EditTest7() {
		WebElement txtDiemTP1 = this.driver.findElement(By.xpath("//*[@id=\"diem-tp1\"]"));
		txtDiemTP1.clear();
		txtDiemTP1.sendKeys("-1");

		WebElement txtDiemTP = this.driver.findElement(By.xpath("//*[@id=\"diem-cc\"]"));
		txtDiemTP.click();

		WebElement errorMess = this.driver.findElement(By.xpath("//*[@id=\"form-2\"]/div[2]/div/span"));
		Assertions.assertEquals("Giá trị điểm cho phép từ 0 - 10", errorMess.getText());
	}

	// nhập kỳ tự không phải số
	@Test
	public void EditTest8() {
		WebElement txtDiemTP1 = this.driver.findElement(By.xpath("//*[@id=\"diem-tp1\"]"));
		txtDiemTP1.clear();
		txtDiemTP1.sendKeys("@@");

		WebElement txtDiemTP = this.driver.findElement(By.xpath("//*[@id=\"diem-cc\"]"));
		txtDiemTP.click();

		WebElement errorMess = this.driver.findElement(By.xpath("//*[@id=\"form-2\"]/div[2]/div/span"));
		Assertions.assertEquals("Điểm không bao gồm chuỗi và các ký tự đặc biệt", errorMess.getText());
	}

	// ký tự chuôi
	@Test
	public void EditTest9() {
		WebElement txtDiemTP1 = this.driver.findElement(By.xpath("//*[@id=\"diem-tp1\"]"));
		txtDiemTP1.clear();
		txtDiemTP1.sendKeys("ab");

		WebElement txtDiemTP = this.driver.findElement(By.xpath("//*[@id=\"diem-cc\"]"));
		txtDiemTP.click();

		WebElement errorMess = this.driver.findElement(By.xpath("//*[@id=\"form-2\"]/div[2]/div/span"));
		Assertions.assertEquals("Điểm không bao gồm chuỗi và các ký tự đặc biệt", errorMess.getText());
	}

	// 2 chữ số sau dấu phẩy , nhiều hơn 2 ký tự sau dấu ,
	@Test
	public void EditTest10() {
		WebElement txtDiemTP1 = this.driver.findElement(By.xpath("//*[@id=\"diem-tp1\"]"));
		txtDiemTP1.clear();
		txtDiemTP1.sendKeys("5.444");

		WebElement txtDiemTP = this.driver.findElement(By.xpath("//*[@id=\"diem-cc\"]"));
		txtDiemTP.click();

		WebElement errorMess = this.driver.findElement(By.xpath("//*[@id=\"form-2\"]/div[2]/div/span"));
		Assertions.assertEquals("Chỉ phép nhập 2 chữ số sau dấu '.'", errorMess.getText());
	}

	// nhập số nhỏ hơn 10
	@Test
	public void EditTest11() {
		WebElement txtDiemTP1 = this.driver.findElement(By.xpath("//*[@id=\"diem-tp1\"]"));
		txtDiemTP1.clear();
		txtDiemTP1.sendKeys("5");

		WebElement txtDiemTP = this.driver.findElement(By.xpath("//*[@id=\"diem-cc\"]"));
		txtDiemTP.click();

		WebElement errorMess = this.driver.findElement(By.xpath("//*[@id=\"form-2\"]/div[2]/div/span"));
		Assertions.assertNotEquals("Điểm không bao gồm chuỗi và các ký tự đặc biệt", errorMess.getText());
		Assertions.assertNotEquals("Chỉ phép nhập 2 chữ số sau dấu '.'", errorMess.getText());
		Assertions.assertNotEquals("Giá trị điểm cho phép từ 0 - 10", errorMess.getText());
	}

	// nhập số lớn hơn 10
	@Test
	public void EditTest12() {
		WebElement txtDiemTP1 = this.driver.findElement(By.xpath("//*[@id=\"diem-tp1\"]"));
		txtDiemTP1.clear();
		txtDiemTP1.sendKeys("10.5");

		WebElement txtDiemTP = this.driver.findElement(By.xpath("//*[@id=\"diem-cc\"]"));
		txtDiemTP.click();

		WebElement errorMess = this.driver.findElement(By.xpath("//*[@id=\"form-2\"]/div[2]/div/span"));
		Assertions.assertEquals("Giá trị điểm cho phép từ 0 - 10", errorMess.getText());
	}

	// -------------------------------------- Điểm TP2
	// ------------------------------------------------
	// nhập số âm
	@Test
	public void EditTest13() {
		WebElement txtDiemTP2 = this.driver.findElement(By.xpath("//*[@id=\"diem-tp2\"]"));
		txtDiemTP2.clear();
		txtDiemTP2.sendKeys("-1");

		WebElement txtDiemTP = this.driver.findElement(By.xpath("//*[@id=\"diem-cc\"]"));
		txtDiemTP.click();

		WebElement errorMess = this.driver.findElement(By.xpath("//*[@id=\"form-2\"]/div[3]/div[1]/div/span"));
		Assertions.assertEquals("Giá trị điểm cho phép từ 0 - 10", errorMess.getText());
	}

	// nhập kỳ tự không phải số
	@Test
	public void EditTest14() {
		WebElement txtDiemTP2 = this.driver.findElement(By.xpath("//*[@id=\"diem-tp2\"]"));
		txtDiemTP2.clear();
		txtDiemTP2.sendKeys("@@");

		WebElement txtDiemTP = this.driver.findElement(By.xpath("//*[@id=\"diem-cc\"]"));
		txtDiemTP.click();

		WebElement errorMess = this.driver.findElement(By.xpath("//*[@id=\"form-2\"]/div[3]/div[1]/div/span"));
		Assertions.assertEquals("Điểm không bao gồm chuỗi và các ký tự đặc biệt", errorMess.getText());
	}

	// ký tự chuôi
	@Test
	public void EditTest15() {
		WebElement txtDiemTP2 = this.driver.findElement(By.xpath("//*[@id=\"diem-tp2\"]"));
		txtDiemTP2.clear();
		txtDiemTP2.sendKeys("ab");

		WebElement txtDiemTP = this.driver.findElement(By.xpath("//*[@id=\"diem-cc\"]"));
		txtDiemTP.click();

		WebElement errorMess = this.driver.findElement(By.xpath("//*[@id=\"form-2\"]/div[2]/div/span"));
		Assertions.assertEquals("Điểm không bao gồm chuỗi và các ký tự đặc biệt", errorMess.getText());
	}

	// 2 chữ số sau dấu phẩy , nhiều hơn 2 ký tự sau dấu ,
	@Test
	public void EditTest16() {
		WebElement txtDiemTP2 = this.driver.findElement(By.xpath("//*[@id=\"diem-tp2\"]"));
		txtDiemTP2.clear();
		txtDiemTP2.sendKeys("5.444");

		WebElement txtDiemTP = this.driver.findElement(By.xpath("//*[@id=\"diem-cc\"]"));
		txtDiemTP.click();

		WebElement errorMess = this.driver.findElement(By.xpath("//*[@id=\"form-2\"]/div[3]/div[1]/div/span"));
		Assertions.assertEquals("Chỉ phép nhập 2 chữ số sau dấu '.'", errorMess.getText());
	}

	// nhập số nhỏ hơn 10
	@Test
	public void EditTest17() {
		WebElement txtDiemTP2 = this.driver.findElement(By.xpath("//*[@id=\"diem-tp2\"]"));
		txtDiemTP2.clear();
		txtDiemTP2.sendKeys("5");

		WebElement txtDiemTP = this.driver.findElement(By.xpath("//*[@id=\"diem-cc\"]"));
		txtDiemTP.click();

		WebElement errorMess = this.driver.findElement(By.xpath("//*[@id=\"form-2\"]/div[3]/div[1]/div/span"));
		Assertions.assertNotEquals("Điểm không bao gồm chuỗi và các ký tự đặc biệt", errorMess.getText());
		Assertions.assertNotEquals("Chỉ phép nhập 2 chữ số sau dấu '.'", errorMess.getText());
		Assertions.assertNotEquals("Giá trị điểm cho phép từ 0 - 10", errorMess.getText());
	}

	// nhập số lớn hơn 10
	@Test
	public void EditTest18() {
		WebElement txtDiemTP2 = this.driver.findElement(By.xpath("//*[@id=\"diem-tp2\"]"));
		txtDiemTP2.clear();
		txtDiemTP2.sendKeys("10.5");

		WebElement txtDiemTP = this.driver.findElement(By.xpath("//*[@id=\"diem-cc\"]"));
		txtDiemTP.click();

		WebElement errorMess = this.driver.findElement(By.xpath("//*[@id=\"form-2\"]/div[3]/div[1]/div/span"));
		Assertions.assertEquals("Giá trị điểm cho phép từ 0 - 10", errorMess.getText());
	}

	// -------------------------------------- Điểm Thi
	// ------------------------------------------------
	// nhập số âm
	@Test
	public void EditTest19() {
		WebElement txtDiemThi = this.driver.findElement(By.xpath("//*[@id=\"diem-thi\"]"));
		txtDiemThi.clear();
		txtDiemThi.sendKeys("-1");

		WebElement txtDiemTP = this.driver.findElement(By.xpath("//*[@id=\"diem-cc\"]"));
		txtDiemTP.click();

		WebElement errorMess = this.driver.findElement(By.xpath("//*[@id=\"form-2\"]/div[3]/div[2]/div/div/span"));
		Assertions.assertEquals("Giá trị điểm cho phép từ 0 - 10", errorMess.getText());
	}

	// nhập kỳ tự không phải số
	@Test
	public void EditTest20() {
		WebElement txtDiemThi = this.driver.findElement(By.xpath("//*[@id=\"diem-thi\"]"));
		txtDiemThi.clear();
		txtDiemThi.sendKeys("@@");

		WebElement txtDiemTP = this.driver.findElement(By.xpath("//*[@id=\"diem-cc\"]"));
		txtDiemTP.click();

		WebElement errorMess = this.driver.findElement(By.xpath("//*[@id=\"form-2\"]/div[3]/div[2]/div/div/span"));
		Assertions.assertEquals("Điểm không bao gồm chuỗi và các ký tự đặc biệt", errorMess.getText());
	}

	// ký tự chuôi
	@Test
	public void EditTest21() {
		WebElement txtDiemThi = this.driver.findElement(By.xpath("//*[@id=\"diem-thi\"]"));
		txtDiemThi.clear();
		txtDiemThi.sendKeys("ab");

		WebElement txtDiemTP = this.driver.findElement(By.xpath("//*[@id=\"diem-cc\"]"));
		txtDiemTP.click();

		WebElement errorMess = this.driver.findElement(By.xpath("//*[@id=\"form-2\"]/div[3]/div[2]/div/div/span"));
		Assertions.assertEquals("Điểm không bao gồm chuỗi và các ký tự đặc biệt", errorMess.getText());
	}

	// 2 chữ số sau dấu phẩy , nhiều hơn 2 ký tự sau dấu ,
	@Test
	public void EditTest22() {
		WebElement txtDiemThi = this.driver.findElement(By.xpath("//*[@id=\"diem-thi\"]"));
		txtDiemThi.clear();
		txtDiemThi.sendKeys("5.444");

		WebElement txtDiemTP = this.driver.findElement(By.xpath("//*[@id=\"diem-cc\"]"));
		txtDiemTP.click();

		WebElement errorMess = this.driver.findElement(By.xpath("//*[@id=\"form-2\"]/div[3]/div[2]/div/div/span"));
		Assertions.assertEquals("Chỉ phép nhập 2 chữ số sau dấu '.'", errorMess.getText());
	}

	// nhập số nhỏ hơn 10
	@Test
	public void EditTest23() {
		WebElement txtDiemThi = this.driver.findElement(By.xpath("//*[@id=\"diem-thi\"]"));
		txtDiemThi.clear();
		txtDiemThi.sendKeys("5");

		WebElement txtDiemTP = this.driver.findElement(By.xpath("//*[@id=\"diem-cc\"]"));
		txtDiemTP.click();

		WebElement errorMess = this.driver.findElement(By.xpath("//*[@id=\"form-2\"]/div[3]/div[2]/div/div/span"));
		Assertions.assertNotEquals("Điểm không bao gồm chuỗi và các ký tự đặc biệt", errorMess.getText());
		Assertions.assertNotEquals("Chỉ phép nhập 2 chữ số sau dấu '.'", errorMess.getText());
		Assertions.assertNotEquals("Giá trị điểm cho phép từ 0 - 10", errorMess.getText());
	}

	// nhập số lớn hơn 10
	@Test
	public void EditTest24() {
		WebElement txtDiemTP2 = this.driver.findElement(By.xpath("//*[@id=\"diem-tp2\"]"));
		txtDiemTP2.clear();
		txtDiemTP2.sendKeys("10.5");

		WebElement txtDiemTP = this.driver.findElement(By.xpath("//*[@id=\"diem-cc\"]"));
		txtDiemTP.click();

		WebElement errorMess = this.driver.findElement(By.xpath("//*[@id=\"form-2\"]/div[3]/div[1]/div/span"));
		Assertions.assertEquals("Giá trị điểm cho phép từ 0 - 10", errorMess.getText());
	}

	@BeforeEach
	public void setUP() throws InterruptedException {
		// 1.Khai báo đường dẫn cho Webdriver -> để spript có thể tương tác
		// 2.Khời tạo driver tương ứng với trình duyệt muôn test
		// 3.Sử dụng các phương thức của Webdriver để làm gì

		EdgeOptions option = new EdgeOptions();
		System.setProperty("webdriver.edge.driver", "C:\\Users\\ducnam\\Desktop\\WIP\\SQA\\msedgedriver.exe");
		this.driver = new EdgeDriver(option);
		this.driver.get("http://localhost:8080/SQA_QLDT/");

		// Đăng nhập sẵn tài khoản demo , 1234567
		WebElement txtlogin = this.driver.findElement(By.xpath("//*[@id=\"mgv\"]"));
		txtlogin.sendKeys("demo");
		WebElement txtpassword = this.driver.findElement(By.xpath("//*[@id=\"password\"]"));
		txtpassword.sendKeys("1234567" + Keys.ENTER);
		Thread.sleep(1000);
		// chọn môn học
		Actions action = new Actions(this.driver);
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"subject-selected\"]"))).perform();
		WebElement MhEnglish = this.driver.findElement(By.xpath("//*[@id=\"subject-selected\"]/option[3]"));
		MhEnglish.click();
		Thread.sleep(1000);
		WebElement btnchonmh = this.driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/form[1]/button"));
		btnchonmh.click();
		Thread.sleep(1000);

		// chọn nhóm môn học
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"shift-selected\"]"))).perform();
		WebElement D18_English01 = this.driver.findElement(By.xpath("//*[@id=\"shift-selected\"]/option[2]"));
		D18_English01.click();
		WebElement btnchonLHP = this.driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/form[2]/button"));
		btnchonLHP.click();
		Thread.sleep(1000);

		// kiem tra lớp học
		WebElement viewtenmh = this.driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/span[2]"));
		WebElement viewtenLHP = this.driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/span[2]"));
		Assertions.assertEquals("English", viewtenmh.getText());
		Assertions.assertEquals("D18_ENGLISH01", viewtenLHP.getText());
		// chọn nút sửa điểm của học sinh đầu tiên
		WebElement Edit1 = this.driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/table/tbody/tr[1]/td[11]/a"));
		Edit1.click();
		Thread.sleep(1000);

	}

	@AfterEach
	public void tearDowd() {
		 this.driver.quit();
	}
}
