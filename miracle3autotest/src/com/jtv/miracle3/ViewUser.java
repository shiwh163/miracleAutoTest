package com.jtv.miracle3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
 * �˲����������ԡ���Ա��---���鿴������
 * 
 * user::shiwh
 */


public class ViewUser {
  @Test
  public void view() throws Exception {
		 //logIn  miracle
	  System.out.println("*****************�˲�������������������Ա--�鿴����");
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
       
            
       Thread.sleep(4000);
       
   
       //�ȶ�λ����ť���ڵ�frame,Ȼ���������������޷���λ
       
       String name;
   	name=driver.findElement(By.tagName("iframe")).getAttribute("name"); 
   	System.out.println(name);
   	  
   	driver.switchTo().frame(name);
     

     
     //�Ȳ����������û�
     
     //Adduser  userinfo = new Adduser();
     
     //System.out.println("adduser������ӵ��û�����###"+ userinfo.loginname);
     
     Thread.sleep(2000);
     //��ϵͳ��ѯ����������Ҫ���ҵ��û�����
     //driver.findElement(By.id("userName$text")).sendKeys(userinfo.username);
     driver.findElement(By.id("userName$text")).sendKeys("ʷΰ��");
     //�����ѯ
     
     driver.findElement(By.id("btn-query")).click();
     
     String qurey;
     qurey = driver.findElement(By.id("31$cell$5")).getText();
     
     System.out.println("���ҵ����û�����  ###"+qurey);
  
     Thread.sleep(2000);
     
     Assert.assertEquals(qurey, "ʷΰ��");
     
     //��ѡ��ѯ���
     
     driver.findElement(By.id("mini-43$checkcolumn$31$2")).click();
     
     //����鿴
     
    	 driver.findElement(By.id("btn-view")).click();
    	 System.out.println("##################�鿴���ܲ��Գɹ�");
    	 driver.quit();
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println(e);
		System.out.println("###############�鿴���ܲ���ʧ��");
		driver.quit();
	}     
  }
}
