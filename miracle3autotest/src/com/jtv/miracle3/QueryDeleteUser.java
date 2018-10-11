package com.jtv.miracle3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
 * 此测试用例是测试【人员】的----【查询】【删除】
 * 
 * user：：shiwh
 */


public class QueryDeleteUser {
  @Test
  public void delete() throws Exception{
	  
	  System.out.println("******************此测试用例用来测试人员--查询和删除");
		 //logIn  miracle
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
     
     Adduser  userinfo = new Adduser();
     
     System.out.println("adduser类中添加的用户名是###"+ userinfo.loginname);
     
     
     //在系统查询条件中输入要查找的用户名：
     driver.findElement(By.id("userName$text")).sendKeys(userinfo.username);
     
     //点击查询
     
     driver.findElement(By.id("btn-query")).click();
     
     String qurey;
     qurey = driver.findElement(By.id("31$cell$5")).getText();
     
     System.out.println("查找到的用户名：  ###"+qurey);
  
     Thread.sleep(2000);
     
     Assert.assertEquals(qurey, userinfo.username);
     
     //勾选查询结果
     
     driver.findElement(By.id("31$cell$2")).click();
     
     //点击删除
     
     driver.findElement(By.id("btn-delete")).click();
     
     //定位到（是否删除的）弹出框
     
    
      driver.switchTo().defaultContent();
      
     //点击确定
     driver.findElement(By.xpath(".//*[@id='mini-160']")).click();
     
     
    //返回到新增界面的frame

 	  
 	driver.switchTo().frame(name);
     
     //查看是不是还是等于要查询的结果
     String tip;
     
     tip = driver.findElement(By.id("mini-41$emptytext2")).getText();
     
    // System.out.println(tip);
     
     if (tip.equals("没有返回的数据")){
    	 System.out.println("##########"+userinfo.username+"删除成功");
    	 
    	 driver.quit();
     }
     else{
    	  System.out.println("##########删除失败");
    	  driver.quit();
     }
     

		
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("删除用户失败，请查找原因"+e);
	}
     
  }
  
  
}
