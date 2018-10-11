package com.jtv.miracle3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TableDelete {
  @Test
  public void betchDelete() throws Exception {
 System.out.println("************此测试用例用来测试：人员--单元格--批量删除");
	  
	  Login login = new Login();
	  login.loginmiracle("admin", "123");
	  
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
      
      WebElement dep1;//单位
      dep1 = driver.findElement(By.id(login.getDept()));

      Actions action = new Actions(driver);
              
             //在单位上边进行右键操作
             // action.moveToElement(dep1);
              action.contextClick(dep1).perform();
              
              
              Thread.sleep(1000);
              
              //driver.switchTo().defaultContent();
              
               WebElement danyuange;
              
              //以下这个xpath需要注意，你的当前电脑只能让webdriver打开miracle,不能有其他浏览器正在访问，否则xpath 的值会自动变化；
              //将鼠标移动到【单元格】
               danyuange = driver.findElement(By.xpath(login.getTable()));              
               action.moveToElement(danyuange).perform();
              //action.release();
              
              //点击批量删除
              driver.findElement(By.xpath(login.getPatchDelete())).click();
              
              //跳转到默认frame
              driver.switchTo().defaultContent();
              
              //查看当前有多少可以删除的项目
              java.util.List<WebElement> del = driver.findElements(By.className("mini-grid-row"));
             // System.out.println(del.size());
              
              //勾选班次
              for (int i = 0; i < del.size(); i++) {
				if(del.get(i).getText().contains("班次")){
					//driver.findElement(By.xpath(".//*[@id='mini-239$checkcolumn$68$6']")).click();
					del.get(i).click();
					break;
				}
			}
              //点击确定删除
              driver.findElement(By.xpath(login.getAlertSure())).click();
              
              //跳转到人员查询frame
              login.xtwh();
               
              
              //查找当前界面是否有班次这个字段。如果有说明么有删除成功。如果没有了就是删除成功了
              java.util.List<WebElement> td = driver.findElements(By.tagName("td"));  
              
              for (int i = 0; i < td.size(); i++) {
              	if (td.get(i).getAttribute("id").contains("mini-41$headerCell2$")){
              		System.out.println(i-22);
              		//System.out.println("******"+td.get(i).getAttribute("id"));
              		System.out.println("******"+td.get(i).getText());
                  	if(td.get(i).getText().contains("班次")){
              			System.out.println("删除失败");
              			break;
                  	}

              		}

              		
              	}
              driver.quit();
              
             
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("中途测试失败"+e);
			}
          	}
        
}
              
             

