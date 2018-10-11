package com.jtv.miracle3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/*
 * �˲��������ǲ��Ը�����Ϣ�û�������
 * 
 * user::shiwh
 */
public class ModifyUserPasswd {
  @Test
  public void modify() throws Exception {
	  System.out.println("*****************�˲�����������������--�޸Ŀ���");

	  Adduser user = new Adduser();
	  
	  Login login = new Login();
	  login.loginmiracle(user.username, user.passwd);
	  
	  WebDriver driver = login.Driver();
	  
	  try {
	  //����û���
	  driver.findElement(By.id("btn-user")).click();
	  //����޸�����
	  driver.findElement(By.id("user-pwd$text")).click();
	  
	  //���¶�λframe
	  
	   WebElement newframe;
	   newframe = driver.findElement(By.xpath(".//*[@id='win-upwd']/div/div[2]/div[2]/iframe"));
	   
	   driver.switchTo().frame(newframe);
	   
	   Thread.sleep(2000);
	   boolean       isedit1 = false;
	   boolean       isedit2 = false;
	   boolean       isedit3  =false;
	   isedit1 = driver.findElement(By.id("oldPwd$text")).isEnabled();
	   isedit2 = driver.findElement(By.id("newPwd$text")).isEnabled();
	   isedit3 = driver.findElement(By.id("newRePwd$text")).isEnabled();
	   
	   
	   System.out.println("�������Ƿ�ɱ༭"+isedit1);
	   System.out.println("�������Ƿ�ɱ༭"+isedit2);
	   System.out.println("ȷ�������Ƿ�ɱ༭"+isedit3);
        
	   if(isedit1=isedit2=isedit3==true){
		   Thread.sleep(3000);
	       //ԭ����
		     driver.findElement(By.id("oldPwd$text")).sendKeys(user.passwd);
		     
		       //������
		     driver.findElement(By.id("newPwd$text")).sendKeys("123456");
		       // ȷ��������
		     driver.findElement(By.id("newRePwd$text")).sendKeys("123456");
		     
		     // ����޸�
		     driver.findElement(By.id("update-pwd")).click();
		     
		     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		     
		     driver.switchTo().defaultContent();
		     //����ر�
		     driver.findElement(By.id("3")).click();
		     
		     System.out.println("##################�޸Ŀ���ɹ�");
		     driver.quit();
		   
	   }
	   else{
		   
		   System.out.println("�б༭���ܱ༭�������޸�����");
		   driver.quit();
	   }
	   
	  
		
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("�޸��û�������ʧ�������ԭ��"+e);
	}
     
     
     
  }
}
