package com.jtv.miracle3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SettingLogo {
  @Test
  public void logo()  throws Exception{
	  System.out.println("************此测试用例用来测试：设置--工具栏--是否显示logo");
	  Login login = new Login();
	  login.loginmiracle("admin", "123");
	  
	  WebDriver driver = login.Driver();
	  try {
		  //查看当前系统是否有logo
		  boolean logo;
		  logo = driver.findElement(By.id("logo-pic")).isDisplayed();
		  //System.out.println("当前logo状态是（false不可见，true是可见）"+logo );
		  
		  if (logo==true) {
			System.out.println("当前logo状态是可见状态");
			 //点击设置
			  driver.findElement(By.id(login.getConfig())).click();

				  //点击工具栏
			  driver.findElement(By.id(login.getTool())).click();
				  

			
			  
			  //点击取消显示logo
			  driver.findElement(By.xpath(".//*[@id='mini-33']/div/div/div[1]/div[1]/div/div[2]")).click();
			  Thread.sleep(2000);
			  boolean logo1;
			  logo1 = driver.findElement(By.id("logo-pic")).isDisplayed();
			  System.out.println(logo1);
			  
			  if (logo1==false) {
				System.out.println("取消显示logo测试成功");
				
				driver.quit();
			} else {
				System.out.println("#####取消显示logo测试不通过");
				driver.quit();
			}
			  
			  
			  
		} else {
	        System.out.println("当前logo状态是不可见状态");
	        
	        //点击设置
	  	  driver.findElement(By.id(login.getConfig())).click();
	  	  
	  	  //点击工具栏
	  	  driver.findElement(By.id(login.getTool())).click();
	  	  
	  	  //点击显示logo
	  	  driver.findElement(By.xpath(".//*[@id='mini-33']/div/div/div[1]/div[1]/div/div[2]")).click();
	  	 Thread.sleep(2000);
		  boolean logo2;
		  logo2 = driver.findElement(By.id("logo-pic")).isDisplayed();
		  //System.out.println(logo1);
		  
		  if (logo2==true) {
			System.out.println("设置显示logo测试成功");
			driver.quit();
		} else {
			System.out.println("#####显示logo测试不通过");
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
