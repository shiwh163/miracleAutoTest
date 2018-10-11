package com.jtv.miracle3;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.Test;

public class TableAdd {
	

  @Test
  public  void betchadd()  throws Exception{
	  System.out.println("************此测试用例用来测试：人员--单元格--批量增加");
	  
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
      
      //在单位上右键
      WebElement dep1;
      dep1 = driver.findElement(By.id(login.getDept()));

      Actions action = new Actions(driver);
              
             //在单位上边进行右键操作
             // action.moveToElement(dep1);
              action.contextClick(dep1).perform();
   
              Thread.sleep(1000);
              
              //driver.switchTo().defaultContent();
              
              WebElement dep2;
              
              //以下这个xpath需要注意，你的当前电脑只能让webdriver打开miracle,不能有其他浏览器正在访问，否则xpath 的值会自动变化；
              //将鼠标移动到【单元格】
              dep2 = driver.findElement(By.xpath(login.getTable()));              
              action.moveToElement(dep2).perform();
              //action.release();
              
              
              //点击批量添加
              driver.findElement(By.xpath(login.getPatchAdd())).click();
      
      
              
             // WebElement table1 = driver.findElement(By.xpath(".//*[@id='mini-235']/div/div[2]/div[2]/div[2]/div/div/div[2]/div[4]/div[2]/div/table"));
              
              driver.switchTo().defaultContent();
              
              java.util.List<WebElement> addCol = driver.findElements(By.className("mini-grid-cell "));
              System.out.println(addCol.size()/3);
              
              for (int i = 0; i < addCol.size(); i++) {
				//System.out.println(addCol.get(i).getText());
				
				if(addCol.get(i).getText().contains("职称")){
					addCol.get(i).click();
					break;
				}

			}
              
            /*  //勾选职称，电子邮件
              driver.findElement(By.id("mini-239$checkcolumn$69$6")).click();
              driver.findElement(By.id("mini-239$checkcolumn$70$6")).click();
            */
              
              //点击确定

				driver.findElement(By.xpath(login.getAlertSure())).click();
				//driver.findElement(By.className("mini-button green-button")).click();
            	  //driver.quit();
			
 
          	  login.xtwh();
              
          	//移动滑动框到最后一列，否则上一步添加的列的属性是不可见的。
				Thread.sleep(5000);
		    	WebElement gonghao = driver.findElement(By.id("1$cell$11"));
		        
		    	action.dragAndDropBy(gonghao, 1000, 0).perform();
		        action.release();
		        
                //判断人员查询界面的职称目前是否是可见状态
		        boolean zhicheng;
		        zhicheng = driver.findElement(By.id("mini-43$headerCell2$17")).isDisplayed();
		        System.out.println("当前职称是否可见："+zhicheng);
		        
		        if (zhicheng==true) {
					System.out.println("###############批量增加成功");
					driver.quit();
				} else {
                    System.out.println("#############批量增加失败");
                    driver.quit();
				}
              
              //保存到公用配置
             /* driver.switchTo().frame(addframe);
              Thread.sleep(1000);
              //右键单位,显示配置的下拉
              WebElement dep3;
              dep3=driver.findElement(By.xpath(".//*[@id='mini-41$headerCell2$9']"));
              action.contextClick(dep3).perform();
              
              Thread.sleep(1000);
              driver.switchTo().defaultContent();
              Thread.sleep(1000);
              //鼠标移动到保存配置
              WebElement save;
              save= driver.findElement(By.xpath(".//*[@id='mini-252']/div/div/div[1]/div[8]/div/div[2]"));
              action.moveToElement(save).perform();
              //点击保存到公用配置
              driver.findElement(By.xpath(".//*[@id='mini-322']/div/div/div[1]/div[1]/div")).click();
              
              */
              
              
               //driver.quit();   
      } catch (Exception e) {
			// TODO: handle exception
			System.out.println("批量添加点击确定失败###################"+e);
			driver.quit();
		}

  }
}
