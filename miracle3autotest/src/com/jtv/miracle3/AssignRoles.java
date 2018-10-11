package com.jtv.miracle3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


/*
 * �˲��������ǲ��ԡ���Ա��--�������ɫ��
 * 
 * user::shiwh
 */


public class AssignRoles {
  @Test
  public void assign() throws Exception {
	  System.out.println("****************�˲�����������������Ա--�����ɫ");
	  //��¼miracle
	  Login login = new  Login();
	  login.loginmiracle("admin", "123");
	  
	  //����ʹ�õ�¼��driver,�������´������
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
     

     
     //�Ȳ����������û�
     
    // Adduser  userinfo = new Adduser();
     
   //  System.out.println("adduser������ӵ��û�����###"+ userinfo.loginname);
     
     
     //�ڲ�ѯ����������Ҫ���ҵ��û�����
     //driver.findElement(By.id("userName$text")).sendKeys(userinfo.username);
     
     //�����ѯ
     
     //driver.findElement(By.id("btn-query")).click();
     
     //��ѡ��ѯ���
     
     //driver.findElement(By.id("mini-41$checkcolumn$31$2")).click();
     
     //��������ɫ
     
     driver.findElement(By.id("btn-grant")).click();
     
     //�����ɫ��frame ��Ĭ�ϵĴ��ڣ�����������Ա��ѯ�����frame���������ɫ��frame
     
     Thread.sleep(1000);
     
     driver.switchTo().defaultContent();
     //��Ա-��ѯ����-�����ɫ
     WebElement roleframe;
     roleframe = driver.findElement(By.xpath(".//*[@id='assign-role']/div/div[2]/div[2]/iframe"));
     driver.switchTo().frame(roleframe);

     //�鿴ϵͳ��Ŀǰ�ж��ٽ�ɫ������Ȩ
     
     java.util.List<WebElement> checkbox = driver.findElements(By.className("mini-tree-nodetext"));
      
     System.out.println("��ǰϵͳ���н�ɫ"+checkbox.size()+"����"); 
     
     
     if(checkbox.size()<2){
    	 System.out.println("��ǰ��ɫ��Ȩ����û�н�ɫ��ʾ����ȷ�ϣ�");
    	 driver.quit();
     }else{
    	 for(int i=0; i<checkbox.size();i++){
        	 System.out.println(checkbox.get(i).getText());
         }
         
        
         //��ѡ���ž���
         
         driver.findElement(By.id("mini-15$checkbox$8")).click();
         
         String select ;
         
         select = driver.findElement(By.id("mini-15$checkbox$8")).getAttribute("class");
         
         System.out.println(select);
        
        
        	 Assert.assertEquals(select, "mini-tree-checkbox mini-tree-checkbox-checked");
        	 System.out.println("#############�����ɫ�ɹ�");
        	 
        	 driver.findElement(By.className("mini-button")).click();
        	 
        	 driver.quit();   	 
     }
     
     } catch (Exception e) {
			// TODO: handle exception
			System.out.println("############�����ɫʧ��"+e);
			driver.quit();
		}
      
     
      
  }
}
