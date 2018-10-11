package com.jtv.miracle3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CommonLable {
  @Test
  public void lable() throws Exception{
	  
	  System.out.println("************此测试用例用来测试：人员--常用标签");
	  
	  //登录miracle
	  Login login = new Login();
	  login.loginmiracle("admin", "123");
	  
	  //登录miracle 以后继续用
	  
	  WebDriver driver = login.Driver();
	  
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
          
	  try {
	      
	    //点击系统维护

	      login.xtwh();
	  
	      //点击人员
	      driver.findElement(By.xpath(login.getRenyuan())).click();
	      
	           
	      Thread.sleep(3000);
	      
/*	      boolean RYisDisplay;
	      RYisDisplay = driver.findElement(By.id("mini-81$2")).isDisplayed();
	     // System.out.println(RYisDisplay);
*/	      
	      
	      //在查询界面--人员--的标题上边右键
          //定义人员元素
	      WebElement renyuan;
	      renyuan = driver.findElement(By.id("mini-80$2"));
	      
	      Actions action = new Actions(driver);
	      action.contextClick(renyuan).perform();
	      
	      
	      //点击设为常用标签
	      driver.findElement(By.id("mi-add-favorite")).click();
	      
           //取消常用标签
		  //driver.findElement(By.id("mi-remove-favorite$text")).click();
	      
	      
		      //退出浏览器，
		      driver.findElement(By.id("btn-logout")).click();
		      //重新登录
		      driver.findElement(By.id("j_username$text")).clear();
		         driver.findElement(By.id("j_username$text")).sendKeys("admin");
		         driver.findElement(By.id("j_password$text")).clear();
		         driver.findElement(By.id("j_password$text")).sendKeys("123");

		         driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

		         driver.findElement(By.id("btnLogin")).click();
		         
		         Thread.sleep(3000);

		         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		      
		      
		      
		      //查看【人员】是否可见，是否是常用标签
		      boolean RYisDisplay;
		      RYisDisplay = driver.findElement(By.id("mini-80$2")).isDisplayed();
		     // System.out.println(RYisDisplay);
		      
		      if(RYisDisplay==true){
		    	  System.out.println("*********设为常用标签成功");
		    	  
		    	  
		    	  driver.navigate().refresh();
		    	  
		    	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    	  
		    	  
		    	  driver.findElement(By.id("mini-80$2")).click();
		    	  
		    	  Thread.sleep(6000);
		    	  
		    	  WebElement renyuan2 = driver.findElement(By.id("mini-80$2"));
		    	  action.contextClick(renyuan2).perform();
		    	  
		    	  
		    	  
		           //取消常用标签
		    	  
				  driver.findElement(By.id("mi-remove-favorite")).click();
				  action.release();
		    	  
		    	  driver.quit();
		    	  
		      }else{
		    	
		    	  System.out.println("*********设为常用标签**不成功");
		    	  action.release();
		    	  driver.quit();

		      }
		     
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("退出浏览器发生异常"+e);
			driver.quit();
		}

	      

	      
	      
	      
	      

	      
	      
  }
}
