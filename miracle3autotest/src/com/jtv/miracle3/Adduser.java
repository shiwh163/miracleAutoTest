package com.jtv.miracle3;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


/*
 * �˲��������ǲ��ԡ���Ա����������
 * user::shiwh
 * 
 */

public class Adduser {
	
    String username = "test1" ;
     String loginname = "test1";
     String passwd = "123" ;  
     
     
   	
     @Test
	 public void adduser () throws Exception{
   	  System.out.println("*****************�˲�������������������Ա--��������");

		 
		 //logIn  miracle

		  Login login = new Login();
		  login.loginmiracle("admin", "123");
		  
		  WebDriver driver=login.Driver();
  	 
          driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 
          try {
          //
          //driver.switchTo().frame(arg0)
          
          //���ϵͳά��
          
          login.xtwh();
      
          //�����Ա
          driver.findElement(By.xpath(login.getRenyuan())).click();
          
               
          Thread.sleep(3000);
          
      
          //�ȶ�λ����ť���ڵ�frame,Ȼ���������������޷���λ
          
          String name;
      	name=driver.findElement(By.tagName("iframe")).getAttribute("name"); 
      	System.out.println(name);
      	  
      	driver.switchTo().frame(name);

          
         //�������
         driver.findElement(By.id("btn-add")).click();
         
         Thread.sleep(3000);
         
        
         driver.switchTo().defaultContent();
         
         //������༭�������ڵĿ��
         String editframe;
         editframe = driver.findElement(By.id("edit-dialog-db52a5d0-0c76-4ab4-ad5b-38074b9bb2af")).findElement(By.tagName("iframe")).getAttribute("name");
         System.out.println(editframe);
         
         driver.switchTo().frame(editframe);
          

          
          //�жϵ�ǰ�Ƿ�Ĭ��ѡ�����Ա�
          
          boolean sex;
          
          sex = driver.findElement(By.id("mini-20$0")).isSelected();
          
         if(sex==true){
        	 System.out.println("��ǰĬ��ѡ�����Ů");
         }else{
        	 System.out.println("��ǰĬ��ѡ�������");
         }
          
          
          //�жϵ�ǰ�Ƿ�Ĭ��ѡ���ˡ������¼��
          boolean isenable;
          isenable=driver.findElement(By.id("isEnable")).isSelected();
          
          if (isenable==true) {
        	  
        	  System.out.println("��ǰ�û�Ĭ�ϲ������¼");
        	  
        	  driver.findElement(By.id("isEnable")).click();
			
		} else {
			 System.out.println("��ǰ�û�Ĭ���������¼��");
      	
		}
          
/*          username="test1";
          loginname="test1";
          passwd = "123";*/
          
          //¼��Ҫ���������ݣ��û��������롢��¼������λ����Ϣ��
          driver.findElement(By.id("userName$text")).sendKeys(username);
          Thread.sleep(1000);
          driver.findElement(By.id("loginName$text")).sendKeys(loginname);
          Thread.sleep(3000);
          driver.findElement(By.id("loginPassword$text")).sendKeys(passwd);
          Thread.sleep(2000);
          
          
          
         java.util.List<WebElement> xiala = driver.findElements(By.name("trigger"));
        	  xiala.get(1).click();

          //driver.findElement(By.name("trigger")).click();
          //driver.findElement(By.id("stationId$text")).sendKeys("������");
        	  Thread.sleep(2000);
        	  driver.findElement(By.xpath(".//*[@id='1$cell$1']/div/div/span/span")).click();
          //driver.findElement(By.id("1$cell$1")).click();
         
    
  	        
        //�������
         
			
        	  driver.findElement(By.id("btn-submit")).click();
        	  
        	  System.out.println("###############������Ա�ɹ�");

		
          
        Thread.sleep(2000);
       //click close
        driver.findElement(By.id("btn-close")).click();
          
    
		 
         driver.quit();
         
          } catch (Exception e) {
  			// TODO: handle exception
  			//System.out.println(e);
  			System.out.println("������Աʧ��,����ִ��ʧ�ܣ��ر������"+e);
  			driver.quit();
  		}
	 }
     

}
