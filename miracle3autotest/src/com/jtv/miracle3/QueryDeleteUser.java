package com.jtv.miracle3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
 * �˲��������ǲ��ԡ���Ա����----����ѯ����ɾ����
 * 
 * user����shiwh
 */


public class QueryDeleteUser {
  @Test
  public void delete() throws Exception{
	  
	  System.out.println("******************�˲�����������������Ա--��ѯ��ɾ��");
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
       
            
       Thread.sleep(4000);
       
   
       //�ȶ�λ����ť���ڵ�frame,Ȼ���������������޷���λ
       
       String name;
   	name=driver.findElement(By.tagName("iframe")).getAttribute("name"); 
   	System.out.println(name);
   	  
   	driver.switchTo().frame(name);
     

     
     //�Ȳ����������û�
     
     Adduser  userinfo = new Adduser();
     
     System.out.println("adduser������ӵ��û�����###"+ userinfo.loginname);
     
     
     //��ϵͳ��ѯ����������Ҫ���ҵ��û�����
     driver.findElement(By.id("userName$text")).sendKeys(userinfo.username);
     
     //�����ѯ
     
     driver.findElement(By.id("btn-query")).click();
     
     String qurey;
     qurey = driver.findElement(By.id("31$cell$5")).getText();
     
     System.out.println("���ҵ����û�����  ###"+qurey);
  
     Thread.sleep(2000);
     
     Assert.assertEquals(qurey, userinfo.username);
     
     //��ѡ��ѯ���
     
     driver.findElement(By.id("31$cell$2")).click();
     
     //���ɾ��
     
     driver.findElement(By.id("btn-delete")).click();
     
     //��λ�����Ƿ�ɾ���ģ�������
     
    
      driver.switchTo().defaultContent();
      
     //���ȷ��
     driver.findElement(By.xpath(".//*[@id='mini-160']")).click();
     
     
    //���ص����������frame

 	  
 	driver.switchTo().frame(name);
     
     //�鿴�ǲ��ǻ��ǵ���Ҫ��ѯ�Ľ��
     String tip;
     
     tip = driver.findElement(By.id("mini-41$emptytext2")).getText();
     
    // System.out.println(tip);
     
     if (tip.equals("û�з��ص�����")){
    	 System.out.println("##########"+userinfo.username+"ɾ���ɹ�");
    	 
    	 driver.quit();
     }
     else{
    	  System.out.println("##########ɾ��ʧ��");
    	  driver.quit();
     }
     

		
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("ɾ���û�ʧ�ܣ������ԭ��"+e);
	}
     
  }
  
  
}
