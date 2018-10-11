package com.jtv.miracle3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/*
 * author :shiwh
 * 
 * date:2017-1-3
 */
public class CommonTable {
  @Test
  public void CommonTable1() throws Exception {
	  
	  System.out.println("****************�˲�����������������ͨ�ñ������Ӻ�ɾ��");
	  Login login = new Login();
	  login.loginmiracle("admin","123");
	  
	  WebDriver driver = login.Driver();
	  
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  
	  //���ϵͳά��
	  login.xtwh();
	  
	  //���ͨ�ñ�
	  driver.findElement(By.id(login.getCommonTable())).click();
	  
	  
	  Thread.sleep(3000);
	  //��ת��ͨ�ñ���ѯ����ı����
	  
	  WebElement CommonFrame;
	  
	  CommonFrame = driver.findElement(By.name(login.getCommonFrame()));
	  driver.switchTo().frame(CommonFrame);
	  
	  try {
		//���������
		  
		  driver.findElement(By.id("EL0BBH2HXbBeRmFy")).click();
		  
		  //�������
		  
		  driver.findElement(By.xpath(".//*[@id='mm-EL0BBH2HXbBeRmFy']/div/div/div[1]/div[1]/div")).click();
		  
		  
		  driver.switchTo().defaultContent();
		  
		  //������ı�ʶ
		  Thread.sleep(3000);
		  
		  
		  driver.findElement(By.id("mini-158")).findElement(By.xpath(".//*[@id='themeId']")).sendKeys("test1,test1");	  
		  driver.findElement(By.id("mini-158")).findElement(By.xpath(".//*[@id='themeName']")).sendKeys("test3");
		  //���ȷ��
		  driver.findElement(By.id("mini-159")).click();
		  
		  driver.switchTo().frame(CommonFrame);
		  
		  Thread.sleep(3000);
		  
		  //�����ѯ
		  driver.findElement(By.id("btn-query")).click();
		  
		  //��ѡȫѡ�ĸ�ѡ��
		  driver.findElement(By.id("mini-29checkall")).click();
		  
		  
   /*       java.util.List<WebElement> checkbox = driver.findElements(By.className("mini-grid-checkbox"));
          
          for(int i=0;i<=checkbox.size();i++){
        	  checkbox.get(i).click();
        	  
          }*/
		  
		  //���ɾ��
		  driver.findElement(By.id("btn-delete")).click();
		  
		  driver.switchTo().defaultContent();
		  Thread.sleep(3000);
		  
		  //����������е�ȷ��
		  driver.findElement(By.id("mini-162")).click();
		  System.out.println("##################ͨ�ñ����Գɹ�");
		  
		  driver.quit();
		  
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("ͨ�ñ�����ʧ��"+e);
		driver.quit();
	}
  
	  
	  
  }
}
