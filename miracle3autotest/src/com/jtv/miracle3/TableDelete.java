package com.jtv.miracle3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TableDelete {
  @Test
  public void betchDelete() throws Exception {
 System.out.println("************�˲��������������ԣ���Ա--��Ԫ��--����ɾ��");
	  
	  Login login = new Login();
	  login.loginmiracle("admin", "123");
	  
	  WebDriver driver = login.Driver();
	  
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      
      try {
      
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
      
      WebElement dep1;//��λ
      dep1 = driver.findElement(By.id(login.getDept()));

      Actions action = new Actions(driver);
              
             //�ڵ�λ�ϱ߽����Ҽ�����
             // action.moveToElement(dep1);
              action.contextClick(dep1).perform();
              
              
              Thread.sleep(1000);
              
              //driver.switchTo().defaultContent();
              
               WebElement danyuange;
              
              //�������xpath��Ҫע�⣬��ĵ�ǰ����ֻ����webdriver��miracle,������������������ڷ��ʣ�����xpath ��ֵ���Զ��仯��
              //������ƶ�������Ԫ��
               danyuange = driver.findElement(By.xpath(login.getTable()));              
               action.moveToElement(danyuange).perform();
              //action.release();
              
              //�������ɾ��
              driver.findElement(By.xpath(login.getPatchDelete())).click();
              
              //��ת��Ĭ��frame
              driver.switchTo().defaultContent();
              
              //�鿴��ǰ�ж��ٿ���ɾ������Ŀ
              java.util.List<WebElement> del = driver.findElements(By.className("mini-grid-row"));
             // System.out.println(del.size());
              
              //��ѡ���
              for (int i = 0; i < del.size(); i++) {
				if(del.get(i).getText().contains("���")){
					//driver.findElement(By.xpath(".//*[@id='mini-239$checkcolumn$68$6']")).click();
					del.get(i).click();
					break;
				}
			}
              //���ȷ��ɾ��
              driver.findElement(By.xpath(login.getAlertSure())).click();
              
              //��ת����Ա��ѯframe
              login.xtwh();
               
              
              //���ҵ�ǰ�����Ƿ��а������ֶΡ������˵��ô��ɾ���ɹ������û���˾���ɾ���ɹ���
              java.util.List<WebElement> td = driver.findElements(By.tagName("td"));  
              
              for (int i = 0; i < td.size(); i++) {
              	if (td.get(i).getAttribute("id").contains("mini-41$headerCell2$")){
              		System.out.println(i-22);
              		//System.out.println("******"+td.get(i).getAttribute("id"));
              		System.out.println("******"+td.get(i).getText());
                  	if(td.get(i).getText().contains("���")){
              			System.out.println("ɾ��ʧ��");
              			break;
                  	}

              		}

              		
              	}
              driver.quit();
              
             
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("��;����ʧ��"+e);
			}
          	}
        
}
              
             

