package com.jtv.miracle3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AssignRight {
  @Test
  public void right() throws Exception {
	  
	  System.out.println("*****************�˲�����������--��Ա--��ѯ�����--������Ȩ");
	  Login login = new Login();
	  login.loginmiracle("admin", "123");
	  WebDriver driver = login.Driver();
	  
	  
	  try{
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
     
     //���������Ȩ
     
     driver.findElement(By.id(login.getLcsq())).click();
     
 
     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
     
     Thread.sleep(2000);
     
     driver.switchTo().defaultContent();
    //��ת��������Ȩ��frame--.//*[@id='assign-dept']/div/div[2]/div[2]/iframe
     WebElement rightframe;
     rightframe=driver.findElement(By.xpath(login.getLcframe()));
     driver.switchTo().frame(rightframe);
       
     boolean depat;  
     depat=driver.findElement(By.id("mini-13$checkbox$2")).isDisplayed();
     System.out.println("�����Ƿ���֣���##"+depat);
     
     
     
     
     if (depat==true) {
		System.out.println("����Ĳ��ų���");
		
		 //��ȡ��ǰ�ж��ٸ�����Ȩ��
	     java.util.List<WebElement>  checkbox = driver.findElements(By.className("mini-tree-nodetext"));
	     
	     //�������
	     int  checkboxcount;
	     checkboxcount = checkbox.size();
	     System.out.println("��ǰϵͳ�п��������ż�ְλ�У���"+checkboxcount+"  ��");
	     
	    for(int i=0; i<checkboxcount;i++){
	    	System.out.println(checkbox.get(i).getText());	    	
	    }
	    System.out.println("######################������Ȩ���Գɹ�");
	    driver.quit();
	    
	} else {
        System.out.println("��λ����û�г��֣����Բ�ͨ��");
        driver.quit();
	}
     
    
		
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("���Բ�ͨ��*************"+e);
	}
     
     
 
     
     
  }
}
