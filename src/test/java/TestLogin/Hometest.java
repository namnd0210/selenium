package TestLogin;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import  org.openqa.selenium.support.ui.Select;

import javax.swing.*;

public class Hometest {
    WebDriver driver;

    // Kiểm tra danh sách sinh viên được chia hợp lý
    // chọn môn học English chọn lớp D18English01
    @Test
    public void testHomeSelenium1() throws InterruptedException {
//        WebElement combobox = this.driver.findElement(By.xpath("//*[@id=\"subject-selected\"]"));
//        Select combo = new Select(this.driver.findElement(By.xpath("//*[@id=\"subject-selected\"]")));
//        combo.selectByValue("English");
        //chọn môn học
        Actions action = new Actions(this.driver);
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"subject-selected\"]"))).perform();
        WebElement MhEnglish = this.driver.findElement(By.xpath("//*[@id=\"subject-selected\"]/option[3]"));
        MhEnglish.click();
         
        WebElement btnchonmh = this.driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/form[1]/button"));
        btnchonmh.click();
         

        //chọn nhóm môn học
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"shift-selected\"]"))).perform();
        WebElement D18_English01 = this.driver.findElement(By.xpath("//*[@id=\"shift-selected\"]/option[2]"));
        D18_English01.click();
        WebElement btnchonLHP=this.driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/form[2]/button"));
        btnchonLHP.click();
         
        // kiem tra
        WebElement viewtenmh = this.driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/span[2]"));
        WebElement viewtenLHP = this.driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/span[2]"));




        Assertions.assertEquals("English",viewtenmh.getText());
        Assertions.assertEquals("D18_ENGLISH01",viewtenLHP.getText());
    }
    //chọn môn học English lớp học D18English2
    
    @Test
    public void tesHomeSelenium2() throws InterruptedException {
        //chọn môn học
        Actions action = new Actions(this.driver);
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"subject-selected\"]"))).perform();
        WebElement MhEnglish = this.driver.findElement(By.xpath("//*[@id=\"subject-selected\"]/option[3]"));
        MhEnglish.click();
         
        WebElement btnchonmh = this.driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/form[1]/button"));
        btnchonmh.click();
         

        //chọn nhóm môn học
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"shift-selected\"]"))).perform();
        WebElement D18_English01 = this.driver.findElement(By.xpath("//*[@id=\"shift-selected\"]/option[2]"));
        D18_English01.click();
        WebElement btnchonLHP=this.driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/form[2]/button"));
        btnchonLHP.click();
         
        // kiem tra
        WebElement viewtenmh = this.driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/span[2]"));
        WebElement viewtenLHP = this.driver.findElement(By.xpath("//*[@id=\"shift-selected\"]/option[3]"));

        Assertions.assertEquals("English",viewtenmh.getText());
        Assertions.assertEquals("D18_ENGLISH02",viewtenLHP.getText());
    }
    
    //Chọn Môn học SQA ,Lớp học D17_SQA01
    @Test
    public void tesHomeSelenium3 ()throws InterruptedException {
        //chọn môn học
        Actions action = new Actions(this.driver);
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"subject-selected\"]"))).perform();
        WebElement Mh = this.driver.findElement(By.xpath("//*[@id=\"subject-selected\"]/option[2]"));
        Mh.click();
         
        WebElement btnchonmh = this.driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/form[1]/button"));
        btnchonmh.click();
         

        //chọn nhóm môn học
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"shift-selected\"]   "))).perform();
        WebElement LHP = this.driver.findElement(By.xpath("//*[@id=\"shift-selected\"]/option[2]"));
        LHP.click();
        WebElement btnchonLHP=this.driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/form[2]/button"));
        btnchonLHP.click();
         
        // kiem tra
        WebElement viewtenmh = this.driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/span[2]"));
        WebElement viewtenLHP = this.driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/span[2]"));
         

        Assertions.assertEquals("SQA",viewtenmh.getText());
        Assertions.assertEquals("D17_SQA01",viewtenLHP.getText());

    }
    
    //CHọn Môn học SQA, LỚp học D17_SQA02
    @Test
    public void tesHomeSelenium4 ()throws InterruptedException {
        //chọn môn học
        Actions action = new Actions(this.driver);
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"subject-selected\"]"))).perform();
        WebElement Mh = this.driver.findElement(By.xpath("//*[@id=\"subject-selected\"]/option[2]"));
        Mh.click();
         
        WebElement btnchonmh = this.driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/form[1]/button"));
        btnchonmh.click();
         

        //chọn nhóm môn học
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"shift-selected\"]"))).perform();
        WebElement LHP = this.driver.findElement(By.xpath("//*[@id=\"shift-selected\"]/option[3]"));
        LHP.click();
        WebElement btnchonLHP=this.driver.findElement(By.xpath("//*[@id=\"shift-selected\"]/option[2]"));
        btnchonLHP.click();
         
        // kiem tra
        WebElement viewtenmh = this.driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/span[2]"));
        WebElement viewtenLHP = this.driver.findElement(By.xpath("//*[@id=\"shift-selected\"]/option[3]"));

        Assertions.assertEquals("SQA",viewtenmh.getText());
        Assertions.assertEquals("D17_SQA02",viewtenLHP.getText());
    }
    //Chọn môn học để trống ấn luôn nút chọn
    
    @Test
    public  void HomeTestSelenium6 () throws InterruptedException
    {
        //chọn nút chọn môn học
        WebElement btnchonmh = this.driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/form[1]/button"));
        btnchonmh.click();
         
        WebElement Thongbao= this.driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/span"));
        Assertions.assertEquals("*Vui lòng chọn môn học học trước!",Thongbao.getText());

    }
    //Test chọn môn học lớp học để trống
    
    @Test
    public void tesHomeSelenium6 ()throws InterruptedException {
        //chọn môn học
        Actions action = new Actions(this.driver);
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"subject-selected\"]"))).perform();
        WebElement Mh = this.driver.findElement(By.xpath("//*[@id=\"subject-selected\"]/option[2]"));
        Mh.click();
         
        WebElement btnchonmh = this.driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/form[1]/button"));
        btnchonmh.click();
         

        //chọn nhóm môn học chọn lục chọn luôn
        WebElement btnchonLHP=this.driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/form[2]/button"));
        btnchonLHP.click();
         
        // kiem tra
        WebElement Thongbao= this.driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/span"));
        Assertions.assertEquals("*Vui lòng chọn nhóm môn học học trước!",Thongbao.getText());


    }
    // Test nút thông tin tài khoản
    
    @Test
    public void tesHomeSelenium7 ()throws InterruptedException {

        //chọn môn học
        WebElement Mh = this.driver.findElement(By.xpath("//*[@id=\"dropdownMenuButton\"]"));
        Mh.click();
         
        WebElement thongtintaikhoan = this.driver.findElement(By.xpath("/html/body/div[1]/div[2]/span/div/div/a[1]"));
        thongtintaikhoan.click();
        // kiểm tra
        String expectURL= driver.getCurrentUrl();
        String actuaURL="http://localhost:8080/SQA_QLDT-master/User";
        Assertions.assertEquals(expectURL,actuaURL);

    }
    // Test sinh viên đủ dk  dự thi
   
    @Test
    public void testHomeSelenium8() throws InterruptedException {
        //chọn môn học
        Actions action = new Actions(this.driver);
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"subject-selected\"]"))).perform();
        WebElement MhEnglish = this.driver.findElement(By.xpath("//*[@id=\"subject-selected\"]/option[3]"));
        MhEnglish.click();
         
        WebElement btnchonmh = this.driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/form[1]/button"));
        btnchonmh.click();
         

        //chọn nhóm môn học
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"shift-selected\"]"))).perform();
        WebElement D18_English01 = this.driver.findElement(By.xpath("//*[@id=\"shift-selected\"]/option[2]"));
        D18_English01.click();
        WebElement btnchonLHP = this.driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/form[2]/button"));
        btnchonLHP.click();
         
        // chọn sinh viên đủ dk dự thi
        WebElement btSVduDKDT = this.driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/form[1]/button"));
        btSVduDKDT.click();
        // kiem tra
            //kiểm tra đúng lớp học chưa
        WebElement viewtenmh = this.driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/span[2]"));
        WebElement viewtenLHP = this.driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/span[2]"));
            // kiểm tra sinh viên có đủ dk dự thi không
        WebElement dkdths1 = this.driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/table/tbody/tr/td[10]"));


        Assertions.assertEquals("English", viewtenmh.getText());
        Assertions.assertEquals("D18_ENGLISH01", viewtenLHP.getText());
        Assertions.assertEquals("1",dkdths1.getText());
    }
    // Sinh viên không đủ dkdt

    @Test
    public void testHomeSelenium9() throws InterruptedException {
        //chọn môn học
        Actions action = new Actions(this.driver);
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"subject-selected\"]"))).perform();
        WebElement MhEnglish = this.driver.findElement(By.xpath("//*[@id=\"subject-selected\"]/option[3]"));
        MhEnglish.click();
         
        WebElement btnchonmh = this.driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/form[1]/button"));
        btnchonmh.click();
         

        //chọn nhóm môn học
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"shift-selected\"]"))).perform();
        WebElement D18_English01 = this.driver.findElement(By.xpath("//*[@id=\"shift-selected\"]/option[2]"));
        D18_English01.click();
        WebElement btnchonLHP = this.driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/form[2]/button"));
        btnchonLHP.click();
         
        // chọn sinh viên đủ chưa đủ
        WebElement btSVduDKDT = this.driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/form[2]/button"));
        btSVduDKDT.click();
        // kiem tra
        //kiểm tra đúng lớp học chưa
        WebElement viewtenmh = this.driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/span[2]"));
        WebElement viewtenLHP = this.driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/span[2]"));
        // kiểm tra sinh viên có đủ dk dự thi không
        WebElement dkdths1 = this.driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/table/tbody/tr/td[10]"));


        Assertions.assertEquals("English", viewtenmh.getText());
        Assertions.assertEquals("D18_ENGLISH01", viewtenLHP.getText());
        Assertions.assertEquals("0",dkdths1.getText());
    }
    
    // Tất cả sinh viên
    @Test
    public void testHomeSelenium10() throws InterruptedException {
        //chọn môn học
        Actions action = new Actions(this.driver);
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"subject-selected\"]"))).perform();
        WebElement MhEnglish = this.driver.findElement(By.xpath("//*[@id=\"subject-selected\"]/option[3]"));
        MhEnglish.click();
         
        WebElement btnchonmh = this.driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/form[1]/button"));
        btnchonmh.click();
         

        //chọn nhóm môn học
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"shift-selected\"]"))).perform();
        WebElement D18_English01 = this.driver.findElement(By.xpath("//*[@id=\"shift-selected\"]/option[2]"));
        D18_English01.click();
        WebElement btnchonLHP = this.driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/form[2]/button"));
        btnchonLHP.click();
         
        // chọn sinh viên đủ chưa đủ dk
        WebElement btSVduDKDT = this.driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/form[2]/button"));
        btSVduDKDT.click();
        // chọn tất cả sinh viên
        WebElement btAllSV = this.driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/form[3]/button"));
        btAllSV.click();
         
        // kiem tra
        //kiểm tra đúng lớp học chưa
        WebElement viewtenmh = this.driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/span[2]"));
        WebElement viewtenLHP = this.driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/span[2]"));
        // kiểm tra sinh viên có đủ dk dự thi không
        WebElement dkdths1 = this.driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/table/tbody/tr/td[10]"));
        WebElement TenSV1 = this.driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/table/tbody/tr[1]/td[3]"));
        Assertions.assertEquals("English", viewtenmh.getText());
        Assertions.assertEquals("D18_ENGLISH01", viewtenLHP.getText());
        Assertions.assertEquals("0",dkdths1.getText());
        Assertions.assertEquals("Chat",TenSV1.getText());
    }
    
    //chọn sửa điểm
    // chọn môn học English chọn lớp D18English01
    @Test
    public void testHomeSelenium11() throws InterruptedException {
        //chọn môn học
        Actions action = new Actions(this.driver);
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"subject-selected\"]"))).perform();
        WebElement MhEnglish = this.driver.findElement(By.xpath("//*[@id=\"subject-selected\"]/option[3]"));
        MhEnglish.click();
         
        WebElement btnchonmh = this.driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/form[1]/button"));
        btnchonmh.click();
         

        //chọn nhóm môn học
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"shift-selected\"]"))).perform();
        WebElement D18_English01 = this.driver.findElement(By.xpath("//*[@id=\"shift-selected\"]/option[2]"));
        D18_English01.click();
        WebElement btnchonLHP=this.driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/form[2]/button"));
        btnchonLHP.click();
         

        // kiem tra lớp học
        WebElement viewtenmh = this.driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/span[2]"));
        WebElement viewtenLHP = this.driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/span[2]"));
        Assertions.assertEquals("English",viewtenmh.getText());
        Assertions.assertEquals("D18_ENGLISH01",viewtenLHP.getText());
        // chọn nút sửa điểm  của học sinh đầu tiên
        WebElement Edit1 = this.driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/table/tbody/tr[1]/td[11]/a"));
        Edit1.click();
         
        String expectURL= driver.getCurrentUrl();
        String actuaURL="http://localhost:8080/SQA_QLDT-master/EditPoint?studentId=7";
        Assertions.assertEquals(expectURL,actuaURL);
    }
    // Đăng xuất

    @BeforeEach
    public void setUP() throws InterruptedException {
        //1.Khai báo  đường dẫn  cho Webdriver -> để spript có thể tương tác
        //2.Khời tạo driver tương ứng với  trình duyệt muôn test
        //3.Sử dụng các phương thức của Webdriver để làm gì

		EdgeOptions option = new EdgeOptions();

        System.setProperty("webdriver.edge.driver","C:\\Users\\ducnam\\Desktop\\WIP\\SQA\\msedgedriver.exe");
        this.driver = new EdgeDriver(option);
        this.driver.get("http://localhost:8080/SQA_QLDT/");

        //Đăng nhập sẵn tài khoản demo , 1234567
        WebElement txtlogin = this.driver.findElement(By.xpath("//*[@id=\"mgv\"]"));
        txtlogin.sendKeys("demo");
        WebElement txtpassword = this.driver.findElement(By.xpath("//*[@id=\"password\"]"));
        txtpassword.sendKeys("1234567" + Keys.ENTER);
         

    }
    @AfterEach
    public  void tearDowd()
    {
        this.driver.quit();
    }
}
