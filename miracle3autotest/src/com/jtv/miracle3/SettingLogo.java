package com.jtv.miracle3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SettingLogo {
  @Test
  public void logo()  throws Exception{
	  System.out.println("************�˲��������������ԣ�����--������--�Ƿ���ʾlogo");
	  Login login = new Login();
	  login.loginmiracle("admin", "123");
	  
	  WebDriver driver = login.Driver();
	  try {
		  //�鿴��ǰϵͳ�Ƿ���logo
		  boolean logo;
		  logo = driver.findElement(By.id("logo-pic")).isDisplayed();
		  //System.out.println("��ǰlogo״̬�ǣ�false���ɼ���true�ǿɼ���"+logo );
		  
		  if (logo==true) {
			System.out.println("��ǰlogo״̬�ǿɼ�״̬");
			 //�������
			  driver.findElement(By.id(login.getConfig())).click();

				  //���������
			  driver.findElement(By.id(login.getTool())).click();
				  

			
			  
			  //���ȡ����ʾlogo
			  driver.findElement(By.xpath(".//*[@id='mini-33']/div/div/div[1]/div[1]/div/div[2]")).click();
			  Thread.sleep(2000);
			  boolean logo1;
			  logo1 = driver.findElement(By.id("logo-pic")).isDisplayed();
			  System.out.println(logo1);
			  
			  if (logo1==false) {
				System.out.println("ȡ����ʾlogo���Գɹ�");
				
				driver.quit();
			} else {
				System.out.println("#####ȡ����ʾlogo���Բ�ͨ��");
				driver.quit();
			}
			  
			  
			  
		} else {
	        System.out.println("��ǰlogo״̬�ǲ��ɼ�״̬");
	        
	        //�������
	  	  driver.findElement(By.id(login.getConfig())).click();
	  	  
	  	  //���������
	  	  driver.findElement(By.id(login.getTool())).click();
	  	  
	  	  //�����ʾlogo
	  	  driver.findElement(By.xpath(".//*[@id='mini-33']/div/div/div[1]/div[1]/div/div[2]")).click();
	  	 Thread.sleep(2000);
		  boolean logo2;
		  logo2 = driver.findElement(By.id("logo-pic")).isDisplayed();
		  //System.out.println(logo1);
		  
		  if (logo2==true) {
			System.out.println("������ʾlogo���Գɹ�");
			driver.quit();
		} else {
			System.out.println("#####��ʾlogo���Բ�ͨ��");
			driver.quit();

		}
		
		
		}
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("ִ�й����з�������"+e);
		driver.quit();
		
	}
	  
	 
  
  }
}
