package com.jtv.miracle3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/*
 * �˲��������ǲ�����Ա��ѯ���桾���á�����
 * 2016-10-14
 * shiwh
 */
public class ResetQuery {
  @Test
  public void reset() throws Exception{
	  
	  System.out.println("*****************�˲�������������������Ա--���ò�ѯ");

	  String textvalue1,textvalue3;
	  Login login = new Login();
	  login.loginmiracle("admin", "123");  
	  
	  //��������������õ�login���������
	  
	  WebDriver driver = login.Driver();
	  
	  
	    try {
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
    
    //�ڲ�ѯ�����������ѯ����
    driver.findElement(By.id("userName$text")).sendKeys("test1");
    //driver.findElement(By.id("loginName$text")).sendKeys("test1");
    
    //��ȡ��ѯ���������ֵ
    
    textvalue1=driver.findElement(By.id("userName$text")).getAttribute("value");
    System.out.println("�û�����ѯ�������ֵ�ǣ���###:"+textvalue1);
    //��¼���Ĳ�ѯ��
    //textvalue2=driver.findElement(By.id("loginName$text")).getAttribute("value");
    //System.out.println("��½����ѯ�������ֵ�ǣ���###:"+textvalue2);
    
    //�������
    driver.findElement(By.id("custom-where")).click();//�ȵ������
    Thread.sleep(2000);
    driver.findElement(By.xpath(".//*[@id='mm-custom-where']/div/div/div[1]/div[2]/div/div[2]")).click();
    
    //������ú��ٴβ鿴�û����͵�½���Ĳ�ѯ��
	  
    textvalue3=driver.findElement(By.id("userName$text")).getAttribute("value");
    //System.out.println("�û�����ѯ�������ֵ�ǣ���#######:"+textvalue3);
    
    //textvalue4=driver.findElement(By.id("loginName$text")).getAttribute("value");
   // System.out.println("�û�����ѯ�������ֵ�ǣ���#######:"+textvalue4);
    
    if (textvalue3.isEmpty()) {
    	System.out.println("#######���ú�ͨ���жϲ���ͨ��");
    	
    	driver.quit();
		
	} else {
		System.out.println("#######���ú�ͨ���жϲ���#####��ͨ��");
		
        driver.quit();
	}
    
    

		
	} catch (Exception e) {
		// TODO: handle exception
		
		System.out.println("���ò�ѯ��������ʧ�������ԭ��###############"+e);
	}
    
  }

}
