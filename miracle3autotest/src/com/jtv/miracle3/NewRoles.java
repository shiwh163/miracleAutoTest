package com.jtv.miracle3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;



/*
 * �������ǽ�ɫ��������ɾ������
 * 
 * user::shiwh
 */

public class NewRoles {
  @Test
  public void newrole() throws Exception {
	  System.out.println("*****************�˲����������������Խ�ɫ--������ɾ����ɫ");

	  
	  Login login = new Login();
	  login.loginmiracle("admin", "123");
	  
	  WebDriver driver = login.Driver();
	  
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  	  
	  try {
	  //���ϵͳά��
	  
      login.xtwh();
      
      Thread.sleep(1000);
	  
	  //�����ɫ
      
      driver.findElement(By.xpath(login.getRole())).click();
      
     
	  
	  //��תframe
	  WebElement  roleframe;
	  roleframe = driver.findElement(By.xpath(login.getRoleFrame()));
	  driver.switchTo().frame(roleframe);
	  
	  
      Thread.sleep(3000);
	  //�������
      
	  driver.findElement(By.id("btn-add")).click();
	  
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  
	  //��תframe
	  
	  driver.switchTo().defaultContent();
	  
	  WebElement editroleframe;
	  
	  editroleframe = 	  driver.findElement(By.xpath(".//*[@id='edit-dialog-04165b7c-949c-415b-a505-156a918f1e21']/div/div[2]/div[2]/iframe"));

	  driver.switchTo().frame(editroleframe);
	  
	  
	  
	  //¼���ɫ��Ϣ
	  
	  driver.findElement(By.id("roleName$text")).sendKeys("������");
  
	  //�������
  
		  driver.findElement(By.id("btn-submit")).click();

	
	  //����ر�
	  
	  driver.findElement(By.id("btn-close")).click();
	  
	  System.out.println("##############������ɫ�ɹ�");
	  //ɾ����ɫ
	  
	  driver.switchTo().defaultContent();
	  
	  driver.switchTo().frame(roleframe);
	  
	  //����ɹ����������������ɾ��
	  
	  driver.findElement(By.id("btn-delete")).click();
	  
	  
	  driver.switchTo().defaultContent();
	  
	  driver.findElement(By.id("mini-161")).click();
	  
	  
	  driver.quit();
	  
		
		} catch (Exception e) {
			// TODO: handle exception
			//System.out.println(e);
			System.out.println("###############������ɾ����ɫʧ��"+e);
			driver.quit();
		}
  }
}
