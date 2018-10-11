package com.jtv.miracle3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/*
 * 此测试用例是测试个人信息用户名密码
 * 
 * user::shiwh
 */
public class ModifyUserPasswd {
  @Test
  public void modify() throws Exception {
	  System.out.println("*****************此测试用例是用来测试--修改口令");

	  Adduser user = new Adduser();
	  
	  Login login = new Login();
	  login.loginmiracle(user.username, user.passwd);
	  
	  WebDriver driver = login.Driver();
	  
	  try {
	  //点击用户名
	  driver.findElement(By.id("btn-user")).click();
	  //点击修改密码
	  driver.findElement(By.id("user-pwd$text")).click();
	  
	  //重新定位frame
	  
	   WebElement newframe;
	   newframe = driver.findElement(By.xpath(".//*[@id='win-upwd']/div/div[2]/div[2]/iframe"));
	   
	   driver.switchTo().frame(newframe);
	   
	   Thread.sleep(2000);
	   boolean       isedit1 = false;
	   boolean       isedit2 = false;
	   boolean       isedit3  =false;
	   isedit1 = driver.findElement(By.id("oldPwd$text")).isEnabled();
	   isedit2 = driver.findElement(By.id("newPwd$text")).isEnabled();
	   isedit3 = driver.findElement(By.id("newRePwd$text")).isEnabled();
	   
	   
	   System.out.println("旧密码是否可编辑"+isedit1);
	   System.out.println("新密码是否可编辑"+isedit2);
	   System.out.println("确认密码是否可编辑"+isedit3);
        
	   if(isedit1=isedit2=isedit3==true){
		   Thread.sleep(3000);
	       //原密码
		     driver.findElement(By.id("oldPwd$text")).sendKeys(user.passwd);
		     
		       //新密码
		     driver.findElement(By.id("newPwd$text")).sendKeys("123456");
		       // 确认新密码
		     driver.findElement(By.id("newRePwd$text")).sendKeys("123456");
		     
		     // 点击修改
		     driver.findElement(By.id("update-pwd")).click();
		     
		     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		     
		     driver.switchTo().defaultContent();
		     //点击关闭
		     driver.findElement(By.id("3")).click();
		     
		     System.out.println("##################修改口令成功");
		     driver.quit();
		   
	   }
	   else{
		   
		   System.out.println("有编辑框不能编辑，不能修改密码");
		   driver.quit();
	   }
	   
	  
		
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("修改用户名密码失败请查找原因"+e);
	}
     
     
     
  }
}
