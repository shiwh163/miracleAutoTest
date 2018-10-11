package com.jtv.miracle3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
/*
 * 此测试用例是用来测试安全退出
 * 
 * user::shiwh
 */
public class SafeOut {
  @Test
  public void safeOut() throws InterruptedException {
	  System.out.println("*****************此测试用例是用来测试安全退出");
	  Login login = new Login();
	  login.loginmiracle("admin", "123");
	  Thread.sleep(3000);
	  WebDriver driver = login.Driver();
	  //判断当前页面中的【安全退出】是否可以点击
/*		String safeOut;
		safeOut=driver.findElement(By.id("btn-logout")).getText();
	    //System.out.println(safeOut);
		
		//判断系统登录后是否显示安全退出，来测试是否登录成功
		if(safeOut.contentEquals("安全退出")){
			System.out.println("登录成功");
           //点击安全退出
			driver.findElement(By.id("btn-logout")).click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			try {
				driver.findElement(By.id(login.getLoginname()));
				System.out.println("安全退出测试成功。");
				driver.quit();
				
			} catch (Exception e) {
				System.out.println(e);
				driver.quit();
			}
			
		}else{
			System.out.println("登录失败");
			login.Driver().quit();
		}*/
	  
	    try {
	    	Thread.sleep(2000);
			driver.findElement(By.id("btn-logout")).click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElement(By.id(login.getLoginname()));
			System.out.println("安全退出测试成功。");
			driver.quit();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("测试失败请查找原因############"+e);
		}
		
  }
}
