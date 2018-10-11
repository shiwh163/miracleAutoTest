package com.jtv.miracle3;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


/*
 * 此测试用例是测试【人员】新增功能
 * user::shiwh
 * 
 */

public class Adduser {
	
    String username = "test1" ;
     String loginname = "test1";
     String passwd = "123" ;  
     
     
   	
     @Test
	 public void adduser () throws Exception{
   	  System.out.println("*****************此测试用例是用来测试人员--新增功能");

		 
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
          
               
          Thread.sleep(3000);
          
      
          //先定位到按钮所在的frame,然后点击新赠。否则无法定位
          
          String name;
      	name=driver.findElement(By.tagName("iframe")).getAttribute("name"); 
      	System.out.println(name);
      	  
      	driver.switchTo().frame(name);

          
         //点击新增
         driver.findElement(By.id("btn-add")).click();
         
         Thread.sleep(3000);
         
        
         driver.switchTo().defaultContent();
         
         //新增后编辑界面所在的框架
         String editframe;
         editframe = driver.findElement(By.id("edit-dialog-db52a5d0-0c76-4ab4-ad5b-38074b9bb2af")).findElement(By.tagName("iframe")).getAttribute("name");
         System.out.println(editframe);
         
         driver.switchTo().frame(editframe);
          

          
          //判断当前是否默认选择了性别
          
          boolean sex;
          
          sex = driver.findElement(By.id("mini-20$0")).isSelected();
          
         if(sex==true){
        	 System.out.println("当前默认选择的是女");
         }else{
        	 System.out.println("当前默认选择的是男");
         }
          
          
          //判断当前是否默认选择了“允许登录”
          boolean isenable;
          isenable=driver.findElement(By.id("isEnable")).isSelected();
          
          if (isenable==true) {
        	  
        	  System.out.println("当前用户默认不允许登录");
        	  
        	  driver.findElement(By.id("isEnable")).click();
			
		} else {
			 System.out.println("当前用户默认是允许登录的");
      	
		}
          
/*          username="test1";
          loginname="test1";
          passwd = "123";*/
          
          //录入要新增的数据（用户名、密码、登录名、单位等信息）
          driver.findElement(By.id("userName$text")).sendKeys(username);
          Thread.sleep(1000);
          driver.findElement(By.id("loginName$text")).sendKeys(loginname);
          Thread.sleep(3000);
          driver.findElement(By.id("loginPassword$text")).sendKeys(passwd);
          Thread.sleep(2000);
          
          
          
         java.util.List<WebElement> xiala = driver.findElements(By.name("trigger"));
        	  xiala.get(1).click();

          //driver.findElement(By.name("trigger")).click();
          //driver.findElement(By.id("stationId$text")).sendKeys("铁道部");
        	  Thread.sleep(2000);
        	  driver.findElement(By.xpath(".//*[@id='1$cell$1']/div/div/span/span")).click();
          //driver.findElement(By.id("1$cell$1")).click();
         
    
  	        
        //点击保存
         
			
        	  driver.findElement(By.id("btn-submit")).click();
        	  
        	  System.out.println("###############新增人员成功");

		
          
        Thread.sleep(2000);
       //click close
        driver.findElement(By.id("btn-close")).click();
          
    
		 
         driver.quit();
         
          } catch (Exception e) {
  			// TODO: handle exception
  			//System.out.println(e);
  			System.out.println("新增人员失败,用例执行失败，关闭浏览器"+e);
  			driver.quit();
  		}
	 }
     

}
