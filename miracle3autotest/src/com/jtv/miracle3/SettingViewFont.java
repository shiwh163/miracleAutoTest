package com.jtv.miracle3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SettingViewFont {
  @Test
  public void font() throws Exception {
	  System.out.println("************�˲��������������ԣ�����--������--�Ƿ���ʾ����");
	  Login login = new Login();
	  login.loginmiracle("admin", "123");
	  
	  WebDriver driver = login.Driver();
	  
	  try {
		//�鿴��ǰϵͳ�Ƿ���logo
		  String fontview;
		  fontview = driver.findElement(By.id("btn-config$text")).getText();
		  //System.out.println("��ǰlogo״̬�ǣ�false���ɼ���true�ǿɼ���"+logo );
		  
		  System.out.println(fontview);
		  
		  
		  
		  if (fontview.equals("����")) {
			System.out.println("��ǰ���õ������ǿɼ�״̬");
			 //�������
			  driver.findElement(By.id(login.getConfig())).click();
			  
			  //���������
			  driver.findElement(By.id(login.getTool())).click();
			  
			  //����Ƿ���ʾ����
			  driver.findElement(By.xpath(".//*[@id='mini-33']/div/div/div[1]/div[2]/div/div[2]")).click();
			  
			  String fontview1;
			  fontview1 = driver.findElement(By.id("btn-config$text")).getText();
			  System.out.println(fontview1);
			  
			  if (fontview1.isEmpty()) {
				System.out.println("ȡ����ʾ���ֲ��Գɹ�");
				
				driver.quit();
			} else {
				System.out.println("#############ȡ����ʾ���ֲ��Բ�ͨ��");
				driver.quit();
			}
			  
			  
			  
		} else {
	        System.out.println("���õ������ǲ��ɼ�״̬");
	        
	        //�������
	  	  driver.findElement(By.id(login.getConfig())).click();
	  	  
	  	  //���������
	  	  driver.findElement(By.id(login.getTool())).click();
	  	  
	  	  //�����ʾ����
	  	  driver.findElement(By.xpath(".//*[@id='mini-33']/div/div/div[1]/div[2]/div/div[2]")).click();
		
		  String fontview2;
		  fontview2 = driver.findElement(By.id("btn-config$text")).getText();
		  System.out.println(fontview2);
		  //System.out.println(logo1);
		  
		  if (fontview2.contentEquals("����")) {
			System.out.println("������ʾ���ֲ��Գɹ�");
			driver.quit();
		} else {
			System.out.println("#############��ʾ���ֲ��Բ�ͨ��");
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
