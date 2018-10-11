package com.jtv.miracle3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


/*
 * 此测试用例是测试人员--组件--选择列--单选框和复选框的转换测试
 * 
 * shiwh
 */

public class CheckboxRadioBox {
  @Test
  public void changebox() throws Exception {
	  System.out.println("*****************此测试用例是测试人员--组件--选择列--单选框和复选框的转换测试");

		 
		 //logIn  miracle

		  Login login = new Login();
		  login.loginmiracle("admin", "123");
		  
		  WebDriver driver=login.Driver();
	 
       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       try {
       
       //
       //driver.switchTo().frame(arg0)
       
       //点击系统维护   
       //driver.findElement(By.xpath(login.getXtwh())).click();
       login.xtwh();
       
   
       //点击人员
       driver.findElement(By.xpath(login.getRenyuan())).click();
             
       Thread.sleep(3000);
       
   
       //先定位到按钮所在的frame,然后点击新赠。否则无法定位
       
       String name;
   	name=driver.findElement(By.tagName("iframe")).getAttribute("name"); 
   	System.out.println(name);
   	  
   	driver.switchTo().frame(name);
     
     //判断当前系统是单选框还是复选框
     //复选框mini-grid-checkbox

     //单选框mini-grid-radio
     
     Thread.sleep(3000);
     String a;
     a = driver.findElement(By.id("mini-42$headerCell2$2")).getAttribute("class");
     System.out.println(a);
     
     if(a.contains("mini-checkcolumn")){
    	 System.out.println("当前是复选框");
     }else{
    	 System.out.println("当前是单选选框");
     }
    	 //
     
     //右键的使用方法是action
     
     Actions action = new Actions(driver);
     
     //单位
     WebElement dept;
     dept=driver.findElement(By.id(login.getDept()));
     
     //右键单位
     action.contextClick(dept).perform();
     
     Thread.sleep(1000);
     
     //跳转到默认的框架中
     
     //driver.switchTo().defaultContent();
     
     //鼠标移动到组件     
     WebElement zujian;
     zujian = driver.findElement(By.xpath(login.getZujiain()));
     
     action.moveToElement(zujian).perform();
     
     //鼠标移动到选择列
     WebElement select_lie;
     select_lie = driver.findElement(By.xpath(login.getXzl()));
     action.moveToElement(select_lie).perform();
     
     //根据情况选择是选复选框还是选择单选框；
     WebElement radiobox,checkbox;
   
     radiobox = driver.findElement(By.xpath(login.getRadiobox()));
     checkbox = driver.findElement(By.xpath(login.getCheckbox()));
     
     if(a.equals("mini-grid-radio")){
    	// System.out.println("当前是复选框");
    	 action.moveToElement(checkbox).click().perform();
    	 
    	 System.out.println("单选框复选框转换测试成功");
    	//转换以后判断当前系统的条件行是否为复选框
    	   //退出当前浏览器
         driver.quit();
    	 
    	 
     }else{
    	//System.out.println("当前是复选框");
    	 action.moveToElement(radiobox).click().perform();
    	 System.out.println("单选框复选框转换测试成功");
    	   //退出当前浏览器
    	 
         driver.quit();
     }
     
     
		
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("单选框复选框转换测试失败"+e);
	}
  
  }
}
