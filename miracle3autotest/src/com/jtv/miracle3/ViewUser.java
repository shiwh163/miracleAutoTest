package com.jtv.miracle3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
 * 此测试用例测试【人员】---【查看】功能
 * 
 * user::shiwh
 */


public class ViewUser {
  @Test
  public void view() throws Exception {
		 //logIn  miracle
	  System.out.println("*****************此测试用例是用来测试人员--查看功能");
	  Login login = new Login();
	  login.loginmiracle("admin", "123");
	  
	  WebDriver driver=login.Driver();

       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 
       try {
       //
       //driver.switchTo().frame(arg0)
       
       //点击系统维护
       
      login.xtwh();
   
       //点击人员
       driver.findElement(By.xpath(login.getRenyuan())).click();
       
            
       Thread.sleep(4000);
       
   
       //先定位到按钮所在的frame,然后点击新赠。否则无法定位
       
       String name;
   	name=driver.findElement(By.tagName("iframe")).getAttribute("name"); 
   	System.out.println(name);
   	  
   	driver.switchTo().frame(name);
     

     
     //先查找新增的用户
     
     //Adduser  userinfo = new Adduser();
     
     //System.out.println("adduser类中添加的用户名是###"+ userinfo.loginname);
     
     Thread.sleep(2000);
     //在系统查询条件中输入要查找的用户名：
     //driver.findElement(By.id("userName$text")).sendKeys(userinfo.username);
     driver.findElement(By.id("userName$text")).sendKeys("史伟华");
     //点击查询
     
     driver.findElement(By.id("btn-query")).click();
     
     String qurey;
     qurey = driver.findElement(By.id("31$cell$5")).getText();
     
     System.out.println("查找到的用户名：  ###"+qurey);
  
     Thread.sleep(2000);
     
     Assert.assertEquals(qurey, "史伟华");
     
     //勾选查询结果
     
     driver.findElement(By.id("mini-43$checkcolumn$31$2")).click();
     
     //点击查看
     
    	 driver.findElement(By.id("btn-view")).click();
    	 System.out.println("##################查看功能测试成功");
    	 driver.quit();
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println(e);
		System.out.println("###############查看功能测试失败");
		driver.quit();
	}     
  }
}
