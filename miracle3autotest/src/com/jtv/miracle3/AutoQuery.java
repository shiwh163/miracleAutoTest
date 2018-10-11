package com.jtv.miracle3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AutoQuery {
  @Test
  public void query() throws InterruptedException {
	  
System.out.println("************此测试用例用来测试：自动查询");
	  
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
	      
	      //跳转到人员所在的框架
	      String name;
	  	name=driver.findElement(By.tagName("iframe")).getAttribute("name"); 
	  	System.out.println(name);
	  	  
	  	driver.switchTo().frame(name);
	      
	      //查看当前有多少个复选框，来判断当前是不是自动查询
	      
	      
	      //WebElement checkbox = driver.findElement(By.className("mini-grid-checkbox"));
	      java.util.List<WebElement> checkbox = driver.findElements(By.className("mini-grid-checkbox"));
	      int checkboxRealCount;
	      checkboxRealCount= checkbox.size()-1;
	      System.out.println(checkbox.size()-1);
	      
	      Actions action = new Actions(driver);
	      
	      //定义单位、数据、自动查询、这个元素
	      WebElement dep;
	      dep = driver.findElement(By.id(login.getDept()));
	      
	      
	      //
	      if (checkboxRealCount==0) {
	    	  System.out.println("当前的查询方式不是自动查询模式，下面将进行设置并测试");
	    	  
	    	  action.contextClick(dep).perform();
				
				//driver.switchTo().defaultContent();
				Thread.sleep(2000);
				WebElement date;
				date = driver.findElement(By.id(login.getData()));
			    action.moveToElement(date).perform();
				Thread.sleep(2000);
				WebElement query;
				query = driver.findElement(By.id(login.getAutoQuary()));
				action.moveToElement(query).perform();
				
				driver.findElement(By.id(login.getAutoQuary())).click();

				//保存到公用配置
				//driver.switchTo().frame(addframe);
				//在单位上右键
				action.contextClick(dep).perform();
				
				action.moveToElement(date).perform();
				Thread.sleep(2000);
				//driver.switchTo().defaultContent();
				
				//定位并点击保存公用配置
				driver.findElement(By.id("mini-138")).findElement(By.id("m-save-public")).click();
/*				WebElement save1;
				save1 = driver.findElement(By.xpath(".//*[@id='mini-305']/div/div/div[1]/div[1]/div"));
				save1.click();*/
				
				driver.navigate().refresh();
				
				Thread.sleep(2000);
				//重新进入人员界面查看是否已经变成不自动查询了
				//点击系统维护

			      login.xtwh();
			  
			      //点击人员
			      driver.findElement(By.xpath(login.getRenyuan())).click();
			      
			      Thread.sleep(2000);
			      
			      //跳转到人员所在的框架
			      String name1;
			  	name1=driver.findElement(By.tagName("iframe")).getAttribute("name"); 
			  	System.out.println(name1);
			  	  
			  	driver.switchTo().frame(name1);
			      
			      //查看界面的复选框
			      
			      Thread.sleep(2000);
			      java.util.List<WebElement> checkbox1 = driver.findElements(By.className("mini-grid-checkbox"));
			      int checkboxRealCount1;
			      checkboxRealCount1= checkbox1.size()-1;
			      System.out.println(checkbox1.size()-1);
			       
			      if(checkboxRealCount1==0){
			    	  System.out.println("设置动查询失败");
			    	  driver.quit();
			    	  
			      }else{
			    	  
			    	  System.out.println("设置自动查询成功");
			    	  driver.quit();
			      }
				
	    	  

	    	  
	    	  
		} else {
	    	  System.out.println("当前的查询方式是自动查询模式，下面将进行设置并测试");
			action.contextClick(dep).perform();
			
			//driver.switchTo().defaultContent();
			Thread.sleep(2000);
			WebElement date;
			date = driver.findElement(By.id(login.getData()));
		    action.moveToElement(date).perform();
			Thread.sleep(2000);
			WebElement query;
			query = driver.findElement(By.id(login.getAutoQuary()));
			action.moveToElement(query).perform();
			//点击自动查询
			driver.findElement(By.id(login.getAutoQuary())).click();

			//保存到公用配置
						
			//driver.switchTo().frame(addframe);
			action.contextClick(dep).perform();
			Thread.sleep(5000);
			//driver.switchTo().defaultContent();
			
			//点击保存到公用配置
			
			driver.findElement(By.id("mini-137")).findElement(By.id("m-save-public")).click();
			/*		WebElement save1;
			save1 = driver.findElement(By.xpath(".//*[@id='mini-305']/div/div/div[1]/div[1]/div"));
			save1.click();*/
			
			driver.navigate().refresh();
			
			Thread.sleep(2000);
			//重新进入人员界面查看是否已经变成不自动查询了
			//点击系统维护

		      login.xtwh();;
		  
		      //点击人员
		      driver.findElement(By.xpath(login.getRenyuan())).click();
		      
		      Thread.sleep(2000);
		      
		      //跳转到人员所在的框架
		      String name2;
		  	name2=driver.findElement(By.tagName("iframe")).getAttribute("name"); 
		  	//System.out.println(name2);
		  	  
		  	driver.switchTo().frame(name2);
		      
		      //查看界面的复选框
		      
		      Thread.sleep(2000);
		      java.util.List<WebElement> checkbox1 = driver.findElements(By.className("mini-grid-checkbox"));
		      int checkboxRealCount1;
		      checkboxRealCount1= checkbox1.size()-1;
		      System.out.println("取消自动查询以后查询结果是：");
		      System.out.println(checkbox1.size()-1);
		       
		      if(checkboxRealCount1==0){
		    	  System.out.println("取消自动查询成功。验证通过");
		    	  driver.quit();
		    	  
		      }else{
		    	  
		    	  System.out.println("取消自动查询失败。******************验证不通过");
		    	  driver.quit();
		      }
			
					}
	      
	     
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("测试失败#################"+e);
		}
	      }
}
