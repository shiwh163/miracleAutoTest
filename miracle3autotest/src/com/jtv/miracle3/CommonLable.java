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
	  
	  System.out.println("************�˲��������������ԣ���Ա--���ñ�ǩ");
	  
	  //��¼miracle
	  Login login = new Login();
	  login.loginmiracle("admin", "123");
	  
	  //��¼miracle �Ժ������
	  
	  WebDriver driver = login.Driver();
	  
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
          
	  try {
	      
	    //���ϵͳά��

	      login.xtwh();
	  
	      //�����Ա
	      driver.findElement(By.xpath(login.getRenyuan())).click();
	      
	           
	      Thread.sleep(3000);
	      
/*	      boolean RYisDisplay;
	      RYisDisplay = driver.findElement(By.id("mini-81$2")).isDisplayed();
	     // System.out.println(RYisDisplay);
*/	      
	      
	      //�ڲ�ѯ����--��Ա--�ı����ϱ��Ҽ�
          //������ԱԪ��
	      WebElement renyuan;
	      renyuan = driver.findElement(By.id("mini-80$2"));
	      
	      Actions action = new Actions(driver);
	      action.contextClick(renyuan).perform();
	      
	      
	      //�����Ϊ���ñ�ǩ
	      driver.findElement(By.id("mi-add-favorite")).click();
	      
           //ȡ�����ñ�ǩ
		  //driver.findElement(By.id("mi-remove-favorite$text")).click();
	      
	      
		      //�˳��������
		      driver.findElement(By.id("btn-logout")).click();
		      //���µ�¼
		      driver.findElement(By.id("j_username$text")).clear();
		         driver.findElement(By.id("j_username$text")).sendKeys("admin");
		         driver.findElement(By.id("j_password$text")).clear();
		         driver.findElement(By.id("j_password$text")).sendKeys("123");

		         driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

		         driver.findElement(By.id("btnLogin")).click();
		         
		         Thread.sleep(3000);

		         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		      
		      
		      
		      //�鿴����Ա���Ƿ�ɼ����Ƿ��ǳ��ñ�ǩ
		      boolean RYisDisplay;
		      RYisDisplay = driver.findElement(By.id("mini-80$2")).isDisplayed();
		     // System.out.println(RYisDisplay);
		      
		      if(RYisDisplay==true){
		    	  System.out.println("*********��Ϊ���ñ�ǩ�ɹ�");
		    	  
		    	  
		    	  driver.navigate().refresh();
		    	  
		    	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    	  
		    	  
		    	  driver.findElement(By.id("mini-80$2")).click();
		    	  
		    	  Thread.sleep(6000);
		    	  
		    	  WebElement renyuan2 = driver.findElement(By.id("mini-80$2"));
		    	  action.contextClick(renyuan2).perform();
		    	  
		    	  
		    	  
		           //ȡ�����ñ�ǩ
		    	  
				  driver.findElement(By.id("mi-remove-favorite")).click();
				  action.release();
		    	  
		    	  driver.quit();
		    	  
		      }else{
		    	
		    	  System.out.println("*********��Ϊ���ñ�ǩ**���ɹ�");
		    	  action.release();
		    	  driver.quit();

		      }
		     
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�˳�����������쳣"+e);
			driver.quit();
		}

	      

	      
	      
	      
	      

	      
	      
  }
}
