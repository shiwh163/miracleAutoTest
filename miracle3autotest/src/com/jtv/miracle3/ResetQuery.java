package com.jtv.miracle3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/*
 * 此测试用例是测试人员查询界面【重置】功能
 * 2016-10-14
 * shiwh
 */
public class ResetQuery {
  @Test
  public void reset() throws Exception{
	  
	  System.out.println("*****************此测试用例是用来测试人员--重置查询");

	  String textvalue1,textvalue3;
	  Login login = new Login();
	  login.loginmiracle("admin", "123");  
	  
	  //定义浏览器。调用的login的浏览器。
	  
	  WebDriver driver = login.Driver();
	  
	  
	    try {
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
    
    //在查询条件处输入查询内容
    driver.findElement(By.id("userName$text")).sendKeys("test1");
    //driver.findElement(By.id("loginName$text")).sendKeys("test1");
    
    //获取查询框中输入的值
    
    textvalue1=driver.findElement(By.id("userName$text")).getAttribute("value");
    System.out.println("用户名查询栏输入的值是：：###:"+textvalue1);
    //登录名的查询框
    //textvalue2=driver.findElement(By.id("loginName$text")).getAttribute("value");
    //System.out.println("登陆名查询栏输入的值是：：###:"+textvalue2);
    
    //点击重置
    driver.findElement(By.id("custom-where")).click();//先点击更多
    Thread.sleep(2000);
    driver.findElement(By.xpath(".//*[@id='mm-custom-where']/div/div/div[1]/div[2]/div/div[2]")).click();
    
    //点击重置后再次查看用户名和登陆名的查询框
	  
    textvalue3=driver.findElement(By.id("userName$text")).getAttribute("value");
    //System.out.println("用户名查询栏输入的值是：：#######:"+textvalue3);
    
    //textvalue4=driver.findElement(By.id("loginName$text")).getAttribute("value");
   // System.out.println("用户名查询栏输入的值是：：#######:"+textvalue4);
    
    if (textvalue3.isEmpty()) {
    	System.out.println("#######重置后通过判断测试通过");
    	
    	driver.quit();
		
	} else {
		System.out.println("#######重置后通过判断测试#####不通过");
		
        driver.quit();
	}
    
    

		
	} catch (Exception e) {
		// TODO: handle exception
		
		System.out.println("重置查询条件测试失败请查找原因###############"+e);
	}
    
  }

}
