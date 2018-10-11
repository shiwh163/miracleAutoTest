package com.jtv.miracle3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AssignRight {
  @Test
  public void right() throws Exception {
	  
	  System.out.println("*****************此测试用例测试--人员--查询界面的--流程授权");
	  Login login = new Login();
	  login.loginmiracle("admin", "123");
	  WebDriver driver = login.Driver();
	  
	  
	  try{
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
     
     //点击流程授权
     
     driver.findElement(By.id(login.getLcsq())).click();
     
 
     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
     
     Thread.sleep(2000);
     
     driver.switchTo().defaultContent();
    //跳转到流程授权的frame--.//*[@id='assign-dept']/div/div[2]/div[2]/iframe
     WebElement rightframe;
     rightframe=driver.findElement(By.xpath(login.getLcframe()));
     driver.switchTo().frame(rightframe);
       
     boolean depat;  
     depat=driver.findElement(By.id("mini-13$checkbox$2")).isDisplayed();
     System.out.println("部门是否出现：：##"+depat);
     
     
     
     
     if (depat==true) {
		System.out.println("可审的部门出现");
		
		 //获取当前有多少个部门权限
	     java.util.List<WebElement>  checkbox = driver.findElements(By.className("mini-tree-nodetext"));
	     
	     //输出数字
	     int  checkboxcount;
	     checkboxcount = checkbox.size();
	     System.out.println("当前系统中可审批部门及职位有：："+checkboxcount+"  个");
	     
	    for(int i=0; i<checkboxcount;i++){
	    	System.out.println(checkbox.get(i).getText());	    	
	    }
	    System.out.println("######################流程授权测试成功");
	    driver.quit();
	    
	} else {
        System.out.println("单位部门没有出现，测试不通过");
        driver.quit();
	}
     
    
		
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("测试不通过*************"+e);
	}
     
     
 
     
     
  }
}
