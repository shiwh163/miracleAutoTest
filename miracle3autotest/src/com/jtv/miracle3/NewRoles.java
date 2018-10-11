package com.jtv.miracle3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;



/*
 * 此用例是角色的新增和删除操作
 * 
 * user::shiwh
 */

public class NewRoles {
  @Test
  public void newrole() throws Exception {
	  System.out.println("*****************此测试用例是用来测试角色--新增，删除角色");

	  
	  Login login = new Login();
	  login.loginmiracle("admin", "123");
	  
	  WebDriver driver = login.Driver();
	  
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  	  
	  try {
	  //点击系统维护
	  
      login.xtwh();
      
      Thread.sleep(1000);
	  
	  //点击角色
      
      driver.findElement(By.xpath(login.getRole())).click();
      
     
	  
	  //跳转frame
	  WebElement  roleframe;
	  roleframe = driver.findElement(By.xpath(login.getRoleFrame()));
	  driver.switchTo().frame(roleframe);
	  
	  
      Thread.sleep(3000);
	  //点击新增
      
	  driver.findElement(By.id("btn-add")).click();
	  
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  
	  //跳转frame
	  
	  driver.switchTo().defaultContent();
	  
	  WebElement editroleframe;
	  
	  editroleframe = 	  driver.findElement(By.xpath(".//*[@id='edit-dialog-04165b7c-949c-415b-a505-156a918f1e21']/div/div[2]/div[2]/iframe"));

	  driver.switchTo().frame(editroleframe);
	  
	  
	  
	  //录入角色信息
	  
	  driver.findElement(By.id("roleName$text")).sendKeys("质量部");
  
	  //点击保存
  
		  driver.findElement(By.id("btn-submit")).click();

	
	  //点击关闭
	  
	  driver.findElement(By.id("btn-close")).click();
	  
	  System.out.println("##############新增角色成功");
	  //删除角色
	  
	  driver.switchTo().defaultContent();
	  
	  driver.switchTo().frame(roleframe);
	  
	  //保存成功后把新增的质量部删掉
	  
	  driver.findElement(By.id("btn-delete")).click();
	  
	  
	  driver.switchTo().defaultContent();
	  
	  driver.findElement(By.id("mini-161")).click();
	  
	  
	  driver.quit();
	  
		
		} catch (Exception e) {
			// TODO: handle exception
			//System.out.println(e);
			System.out.println("###############新增或删除角色失败"+e);
			driver.quit();
		}
  }
}
