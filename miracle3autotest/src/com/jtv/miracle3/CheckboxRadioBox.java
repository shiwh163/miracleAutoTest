package com.jtv.miracle3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


/*
 * �˲��������ǲ�����Ա--���--ѡ����--��ѡ��͸�ѡ���ת������
 * 
 * shiwh
 */

public class CheckboxRadioBox {
  @Test
  public void changebox() throws Exception {
	  System.out.println("*****************�˲��������ǲ�����Ա--���--ѡ����--��ѡ��͸�ѡ���ת������");

		 
		 //logIn  miracle

		  Login login = new Login();
		  login.loginmiracle("admin", "123");
		  
		  WebDriver driver=login.Driver();
	 
       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       try {
       
       //
       //driver.switchTo().frame(arg0)
       
       //���ϵͳά��   
       //driver.findElement(By.xpath(login.getXtwh())).click();
       login.xtwh();
       
   
       //�����Ա
       driver.findElement(By.xpath(login.getRenyuan())).click();
             
       Thread.sleep(3000);
       
   
       //�ȶ�λ����ť���ڵ�frame,Ȼ���������������޷���λ
       
       String name;
   	name=driver.findElement(By.tagName("iframe")).getAttribute("name"); 
   	System.out.println(name);
   	  
   	driver.switchTo().frame(name);
     
     //�жϵ�ǰϵͳ�ǵ�ѡ���Ǹ�ѡ��
     //��ѡ��mini-grid-checkbox

     //��ѡ��mini-grid-radio
     
     Thread.sleep(3000);
     String a;
     a = driver.findElement(By.id("mini-42$headerCell2$2")).getAttribute("class");
     System.out.println(a);
     
     if(a.contains("mini-checkcolumn")){
    	 System.out.println("��ǰ�Ǹ�ѡ��");
     }else{
    	 System.out.println("��ǰ�ǵ�ѡѡ��");
     }
    	 //
     
     //�Ҽ���ʹ�÷�����action
     
     Actions action = new Actions(driver);
     
     //��λ
     WebElement dept;
     dept=driver.findElement(By.id(login.getDept()));
     
     //�Ҽ���λ
     action.contextClick(dept).perform();
     
     Thread.sleep(1000);
     
     //��ת��Ĭ�ϵĿ����
     
     //driver.switchTo().defaultContent();
     
     //����ƶ������     
     WebElement zujian;
     zujian = driver.findElement(By.xpath(login.getZujiain()));
     
     action.moveToElement(zujian).perform();
     
     //����ƶ���ѡ����
     WebElement select_lie;
     select_lie = driver.findElement(By.xpath(login.getXzl()));
     action.moveToElement(select_lie).perform();
     
     //�������ѡ����ѡ��ѡ����ѡ��ѡ��
     WebElement radiobox,checkbox;
   
     radiobox = driver.findElement(By.xpath(login.getRadiobox()));
     checkbox = driver.findElement(By.xpath(login.getCheckbox()));
     
     if(a.equals("mini-grid-radio")){
    	// System.out.println("��ǰ�Ǹ�ѡ��");
    	 action.moveToElement(checkbox).click().perform();
    	 
    	 System.out.println("��ѡ��ѡ��ת�����Գɹ�");
    	//ת���Ժ��жϵ�ǰϵͳ���������Ƿ�Ϊ��ѡ��
    	   //�˳���ǰ�����
         driver.quit();
    	 
    	 
     }else{
    	//System.out.println("��ǰ�Ǹ�ѡ��");
    	 action.moveToElement(radiobox).click().perform();
    	 System.out.println("��ѡ��ѡ��ת�����Գɹ�");
    	   //�˳���ǰ�����
    	 
         driver.quit();
     }
     
     
		
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("��ѡ��ѡ��ת������ʧ��"+e);
	}
  
  }
}
