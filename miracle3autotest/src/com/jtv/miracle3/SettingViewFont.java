package com.jtv.miracle3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SettingViewFont {
  @Test
  public void font() throws Exception {
	  System.out.println("************此测试用例用来测试：设置--工具栏--是否显示文字");
	  Login login = new Login();
	  login.loginmiracle("admin", "123");
	  
	  WebDriver driver = login.Driver();
	  
	  try {
		//查看当前系统是否有logo
		  String fontview;
		  fontview = driver.findElement(By.id("btn-config$text")).getText();
		  //System.out.println("当前logo状态是（false不可见，true是可见）"+logo );
		  
		  System.out.println(fontview);
		  
		  
		  
		  if (fontview.equals("设置")) {
			System.out.println("当前设置的文字是可见状态");
			 //点击设置
			  driver.findElement(By.id(login.getConfig())).click();
			  
			  //点击工具栏
			  driver.findElement(By.id(login.getTool())).click();
			  
			  //点击是否显示文字
			  driver.findElement(By.xpath(".//*[@id='mini-33']/div/div/div[1]/div[2]/div/div[2]")).click();
			  
			  String fontview1;
			  fontview1 = driver.findElement(By.id("btn-config$text")).getText();
			  System.out.println(fontview1);
			  
			  if (fontview1.isEmpty()) {
				System.out.println("取消显示文字测试成功");
				
				driver.quit();
			} else {
				System.out.println("#############取消显示文字测试不通过");
				driver.quit();
			}
			  
			  
			  
		} else {
	        System.out.println("设置的文字是不可见状态");
	        
	        //点击设置
	  	  driver.findElement(By.id(login.getConfig())).click();
	  	  
	  	  //点击工具栏
	  	  driver.findElement(By.id(login.getTool())).click();
	  	  
	  	  //点击显示文字
	  	  driver.findElement(By.xpath(".//*[@id='mini-33']/div/div/div[1]/div[2]/div/div[2]")).click();
		
		  String fontview2;
		  fontview2 = driver.findElement(By.id("btn-config$text")).getText();
		  System.out.println(fontview2);
		  //System.out.println(logo1);
		  
		  if (fontview2.contentEquals("设置")) {
			System.out.println("设置显示文字测试成功");
			driver.quit();
		} else {
			System.out.println("#############显示文字测试不通过");
			driver.quit();

		}
		
		
		}
	  
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("执行过程中发生错误"+e);
		driver.quit();
	}
	  
 
  }
}
