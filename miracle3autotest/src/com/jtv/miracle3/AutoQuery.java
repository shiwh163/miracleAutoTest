package com.jtv.miracle3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AutoQuery {
  @Test
  public void query() throws InterruptedException {
	  
System.out.println("************�˲��������������ԣ��Զ���ѯ");
	  
	  //��¼miracle
	  Login login = new Login();
	  login.loginmiracle("admin", "123");
	  
	  //��¼miracle �Ժ������
	  
	  WebDriver driver = login.Driver();
	  
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
          
	  try {
	      
	    //���ϵͳά��

	      login.xtwh();
	  
	      //�����Ա
	      driver.findElement(By.xpath(login.getRenyuan())).click();
	      
	           
	      Thread.sleep(3000);
	      
	      //��ת����Ա���ڵĿ��
	      String name;
	  	name=driver.findElement(By.tagName("iframe")).getAttribute("name"); 
	  	System.out.println(name);
	  	  
	  	driver.switchTo().frame(name);
	      
	      //�鿴��ǰ�ж��ٸ���ѡ�����жϵ�ǰ�ǲ����Զ���ѯ
	      
	      
	      //WebElement checkbox = driver.findElement(By.className("mini-grid-checkbox"));
	      java.util.List<WebElement> checkbox = driver.findElements(By.className("mini-grid-checkbox"));
	      int checkboxRealCount;
	      checkboxRealCount= checkbox.size()-1;
	      System.out.println(checkbox.size()-1);
	      
	      Actions action = new Actions(driver);
	      
	      //���嵥λ�����ݡ��Զ���ѯ�����Ԫ��
	      WebElement dep;
	      dep = driver.findElement(By.id(login.getDept()));
	      
	      
	      //
	      if (checkboxRealCount==0) {
	    	  System.out.println("��ǰ�Ĳ�ѯ��ʽ�����Զ���ѯģʽ�����潫�������ò�����");
	    	  
	    	  action.contextClick(dep).perform();
				
				//driver.switchTo().defaultContent();
				Thread.sleep(2000);
				WebElement date;
				date = driver.findElement(By.id(login.getData()));
			    action.moveToElement(date).perform();
				Thread.sleep(2000);
				WebElement query;
				query = driver.findElement(By.id(login.getAutoQuary()));
				action.moveToElement(query).perform();
				
				driver.findElement(By.id(login.getAutoQuary())).click();

				//���浽��������
				//driver.switchTo().frame(addframe);
				//�ڵ�λ���Ҽ�
				action.contextClick(dep).perform();
				
				action.moveToElement(date).perform();
				Thread.sleep(2000);
				//driver.switchTo().defaultContent();
				
				//��λ��������湫������
				driver.findElement(By.id("mini-138")).findElement(By.id("m-save-public")).click();
/*				WebElement save1;
				save1 = driver.findElement(By.xpath(".//*[@id='mini-305']/div/div/div[1]/div[1]/div"));
				save1.click();*/
				
				driver.navigate().refresh();
				
				Thread.sleep(2000);
				//���½�����Ա����鿴�Ƿ��Ѿ���ɲ��Զ���ѯ��
				//���ϵͳά��

			      login.xtwh();
			  
			      //�����Ա
			      driver.findElement(By.xpath(login.getRenyuan())).click();
			      
			      Thread.sleep(2000);
			      
			      //��ת����Ա���ڵĿ��
			      String name1;
			  	name1=driver.findElement(By.tagName("iframe")).getAttribute("name"); 
			  	System.out.println(name1);
			  	  
			  	driver.switchTo().frame(name1);
			      
			      //�鿴����ĸ�ѡ��
			      
			      Thread.sleep(2000);
			      java.util.List<WebElement> checkbox1 = driver.findElements(By.className("mini-grid-checkbox"));
			      int checkboxRealCount1;
			      checkboxRealCount1= checkbox1.size()-1;
			      System.out.println(checkbox1.size()-1);
			       
			      if(checkboxRealCount1==0){
			    	  System.out.println("���ö���ѯʧ��");
			    	  driver.quit();
			    	  
			      }else{
			    	  
			    	  System.out.println("�����Զ���ѯ�ɹ�");
			    	  driver.quit();
			      }
				
	    	  

	    	  
	    	  
		} else {
	    	  System.out.println("��ǰ�Ĳ�ѯ��ʽ���Զ���ѯģʽ�����潫�������ò�����");
			action.contextClick(dep).perform();
			
			//driver.switchTo().defaultContent();
			Thread.sleep(2000);
			WebElement date;
			date = driver.findElement(By.id(login.getData()));
		    action.moveToElement(date).perform();
			Thread.sleep(2000);
			WebElement query;
			query = driver.findElement(By.id(login.getAutoQuary()));
			action.moveToElement(query).perform();
			//����Զ���ѯ
			driver.findElement(By.id(login.getAutoQuary())).click();

			//���浽��������
						
			//driver.switchTo().frame(addframe);
			action.contextClick(dep).perform();
			Thread.sleep(5000);
			//driver.switchTo().defaultContent();
			
			//������浽��������
			
			driver.findElement(By.id("mini-137")).findElement(By.id("m-save-public")).click();
			/*		WebElement save1;
			save1 = driver.findElement(By.xpath(".//*[@id='mini-305']/div/div/div[1]/div[1]/div"));
			save1.click();*/
			
			driver.navigate().refresh();
			
			Thread.sleep(2000);
			//���½�����Ա����鿴�Ƿ��Ѿ���ɲ��Զ���ѯ��
			//���ϵͳά��

		      login.xtwh();;
		  
		      //�����Ա
		      driver.findElement(By.xpath(login.getRenyuan())).click();
		      
		      Thread.sleep(2000);
		      
		      //��ת����Ա���ڵĿ��
		      String name2;
		  	name2=driver.findElement(By.tagName("iframe")).getAttribute("name"); 
		  	//System.out.println(name2);
		  	  
		  	driver.switchTo().frame(name2);
		      
		      //�鿴����ĸ�ѡ��
		      
		      Thread.sleep(2000);
		      java.util.List<WebElement> checkbox1 = driver.findElements(By.className("mini-grid-checkbox"));
		      int checkboxRealCount1;
		      checkboxRealCount1= checkbox1.size()-1;
		      System.out.println("ȡ���Զ���ѯ�Ժ��ѯ����ǣ�");
		      System.out.println(checkbox1.size()-1);
		       
		      if(checkboxRealCount1==0){
		    	  System.out.println("ȡ���Զ���ѯ�ɹ�����֤ͨ��");
		    	  driver.quit();
		    	  
		      }else{
		    	  
		    	  System.out.println("ȡ���Զ���ѯʧ�ܡ�******************��֤��ͨ��");
		    	  driver.quit();
		      }
			
					}
	      
	     
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("����ʧ��#################"+e);
		}
	      }
}
