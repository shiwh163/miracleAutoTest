package com.jtv.miracle3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
/*
 * �˲����������������԰�ȫ�˳�
 * 
 * user::shiwh
 */
public class SafeOut {
  @Test
  public void safeOut() throws InterruptedException {
	  System.out.println("*****************�˲����������������԰�ȫ�˳�");
	  Login login = new Login();
	  login.loginmiracle("admin", "123");
	  Thread.sleep(3000);
	  WebDriver driver = login.Driver();
	  //�жϵ�ǰҳ���еġ���ȫ�˳����Ƿ���Ե��
/*		String safeOut;
		safeOut=driver.findElement(By.id("btn-logout")).getText();
	    //System.out.println(safeOut);
		
		//�ж�ϵͳ��¼���Ƿ���ʾ��ȫ�˳����������Ƿ��¼�ɹ�
		if(safeOut.contentEquals("��ȫ�˳�")){
			System.out.println("��¼�ɹ�");
           //�����ȫ�˳�
			driver.findElement(By.id("btn-logout")).click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			try {
				driver.findElement(By.id(login.getLoginname()));
				System.out.println("��ȫ�˳����Գɹ���");
				driver.quit();
				
			} catch (Exception e) {
				System.out.println(e);
				driver.quit();
			}
			
		}else{
			System.out.println("��¼ʧ��");
			login.Driver().quit();
		}*/
	  
	    try {
	    	Thread.sleep(2000);
			driver.findElement(By.id("btn-logout")).click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElement(By.id(login.getLoginname()));
			System.out.println("��ȫ�˳����Գɹ���");
			driver.quit();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("����ʧ�������ԭ��############"+e);
		}
		
  }
}
