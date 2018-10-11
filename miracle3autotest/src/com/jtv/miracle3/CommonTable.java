package com.jtv.miracle3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/*
 * author :shiwh
 * 
 * date:2017-1-3
 */
public class CommonTable {
  @Test
  public void CommonTable1() throws Exception {
	  
	  System.out.println("****************此测试用例是用来测试通用表单的增加和删除");
	  Login login = new Login();
	  login.loginmiracle("admin","123");
	  
	  WebDriver driver = login.Driver();
	  
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  
	  //点击系统维护
	  login.xtwh();
	  
	  //点击通用表单
	  driver.findElement(By.id(login.getCommonTable())).click();
	  
	  
	  Thread.sleep(3000);
	  //跳转到通用表单查询界面的表单框架
	  
	  WebElement CommonFrame;
	  
	  CommonFrame = driver.findElement(By.name(login.getCommonFrame()));
	  driver.switchTo().frame(CommonFrame);
	  
	  try {
		//点击创建表单
		  
		  driver.findElement(By.id("EL0BBH2HXbBeRmFy")).click();
		  
		  //点击主表单
		  
		  driver.findElement(By.xpath(".//*[@id='mm-EL0BBH2HXbBeRmFy']/div/div/div[1]/div[1]/div")).click();
		  
		  
		  driver.switchTo().defaultContent();
		  
		  //输入表单的标识
		  Thread.sleep(3000);
		  
		  
		  driver.findElement(By.id("mini-158")).findElement(By.xpath(".//*[@id='themeId']")).sendKeys("test1,test1");	  
		  driver.findElement(By.id("mini-158")).findElement(By.xpath(".//*[@id='themeName']")).sendKeys("test3");
		  //点击确定
		  driver.findElement(By.id("mini-159")).click();
		  
		  driver.switchTo().frame(CommonFrame);
		  
		  Thread.sleep(3000);
		  
		  //点击查询
		  driver.findElement(By.id("btn-query")).click();
		  
		  //勾选全选的复选框
		  driver.findElement(By.id("mini-29checkall")).click();
		  
		  
   /*       java.util.List<WebElement> checkbox = driver.findElements(By.className("mini-grid-checkbox"));
          
          for(int i=0;i<=checkbox.size();i++){
        	  checkbox.get(i).click();
        	  
          }*/
		  
		  //点击删除
		  driver.findElement(By.id("btn-delete")).click();
		  
		  driver.switchTo().defaultContent();
		  Thread.sleep(3000);
		  
		  //点击弹出框中的确定
		  driver.findElement(By.id("mini-162")).click();
		  System.out.println("##################通用表单测试成功");
		  
		  driver.quit();
		  
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("通用表单测试失败"+e);
		driver.quit();
	}
  
	  
	  
  }
}
