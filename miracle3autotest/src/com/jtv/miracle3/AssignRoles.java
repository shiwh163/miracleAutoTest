package com.jtv.miracle3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


/*
 * 此测试用例是测试【人员】--【分配角色】
 * 
 * user::shiwh
 */


public class AssignRoles {
  @Test
  public void assign() throws Exception {
	  System.out.println("****************此测试用例用来测试人员--分配角色");
	  //登录miracle
	  Login login = new  Login();
	  login.loginmiracle("admin", "123");
	  
	  //继续使用登录的driver,不用重新打开浏览器
	  WebDriver driver = login.Driver();
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      
      try {
      
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
     

     
     //先查找新增的用户
     
    // Adduser  userinfo = new Adduser();
     
   //  System.out.println("adduser类中添加的用户名是###"+ userinfo.loginname);
     
     
     //在查询条件中输入要查找的用户名：
     //driver.findElement(By.id("userName$text")).sendKeys(userinfo.username);
     
     //点击查询
     
     //driver.findElement(By.id("btn-query")).click();
     
     //勾选查询结果
     
     //driver.findElement(By.id("mini-41$checkcolumn$31$2")).click();
     
     //点击分配角色
     
     driver.findElement(By.id("btn-grant")).click();
     
     //分配角色的frame 是默认的窗口，现在跳出人员查询界面的frame，到分配角色的frame
     
     Thread.sleep(1000);
     
     driver.switchTo().defaultContent();
     //人员-查询界面-分配角色
     WebElement roleframe;
     roleframe = driver.findElement(By.xpath(".//*[@id='assign-role']/div/div[2]/div[2]/iframe"));
     driver.switchTo().frame(roleframe);

     //查看系统中目前有多少角色可以授权
     
     java.util.List<WebElement> checkbox = driver.findElements(By.className("mini-tree-nodetext"));
      
     System.out.println("当前系统共有角色"+checkbox.size()+"个："); 
     
     
     if(checkbox.size()<2){
    	 System.out.println("当前角色授权界面没有角色显示，请确认！");
    	 driver.quit();
     }else{
    	 for(int i=0; i<checkbox.size();i++){
        	 System.out.println(checkbox.get(i).getText());
         }
         
        
         //勾选部门经理
         
         driver.findElement(By.id("mini-15$checkbox$8")).click();
         
         String select ;
         
         select = driver.findElement(By.id("mini-15$checkbox$8")).getAttribute("class");
         
         System.out.println(select);
        
        
        	 Assert.assertEquals(select, "mini-tree-checkbox mini-tree-checkbox-checked");
        	 System.out.println("#############分配角色成功");
        	 
        	 driver.findElement(By.className("mini-button")).click();
        	 
        	 driver.quit();   	 
     }
     
     } catch (Exception e) {
			// TODO: handle exception
			System.out.println("############分配角色失败"+e);
			driver.quit();
		}
      
     
      
  }
}
