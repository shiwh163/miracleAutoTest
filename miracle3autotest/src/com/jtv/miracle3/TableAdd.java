package com.jtv.miracle3;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.Test;

public class TableAdd {
	

  @Test
  public  void betchadd()  throws Exception{
	  System.out.println("************�˲��������������ԣ���Ա--��Ԫ��--��������");
	  
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
      
      //�ڵ�λ���Ҽ�
      WebElement dep1;
      dep1 = driver.findElement(By.id(login.getDept()));

      Actions action = new Actions(driver);
              
             //�ڵ�λ�ϱ߽����Ҽ�����
             // action.moveToElement(dep1);
              action.contextClick(dep1).perform();
   
              Thread.sleep(1000);
              
              //driver.switchTo().defaultContent();
              
              WebElement dep2;
              
              //�������xpath��Ҫע�⣬��ĵ�ǰ����ֻ����webdriver��miracle,������������������ڷ��ʣ�����xpath ��ֵ���Զ��仯��
              //������ƶ�������Ԫ��
              dep2 = driver.findElement(By.xpath(login.getTable()));              
              action.moveToElement(dep2).perform();
              //action.release();
              
              
              //����������
              driver.findElement(By.xpath(login.getPatchAdd())).click();
      
      
              
             // WebElement table1 = driver.findElement(By.xpath(".//*[@id='mini-235']/div/div[2]/div[2]/div[2]/div/div/div[2]/div[4]/div[2]/div/table"));
              
              driver.switchTo().defaultContent();
              
              java.util.List<WebElement> addCol = driver.findElements(By.className("mini-grid-cell "));
              System.out.println(addCol.size()/3);
              
              for (int i = 0; i < addCol.size(); i++) {
				//System.out.println(addCol.get(i).getText());
				
				if(addCol.get(i).getText().contains("ְ��")){
					addCol.get(i).click();
					break;
				}

			}
              
            /*  //��ѡְ�ƣ������ʼ�
              driver.findElement(By.id("mini-239$checkcolumn$69$6")).click();
              driver.findElement(By.id("mini-239$checkcolumn$70$6")).click();
            */
              
              //���ȷ��

				driver.findElement(By.xpath(login.getAlertSure())).click();
				//driver.findElement(By.className("mini-button green-button")).click();
            	  //driver.quit();
			
 
          	  login.xtwh();
              
          	//�ƶ����������һ�У�������һ����ӵ��е������ǲ��ɼ��ġ�
				Thread.sleep(5000);
		    	WebElement gonghao = driver.findElement(By.id("1$cell$11"));
		        
		    	action.dragAndDropBy(gonghao, 1000, 0).perform();
		        action.release();
		        
                //�ж���Ա��ѯ�����ְ��Ŀǰ�Ƿ��ǿɼ�״̬
		        boolean zhicheng;
		        zhicheng = driver.findElement(By.id("mini-43$headerCell2$17")).isDisplayed();
		        System.out.println("��ǰְ���Ƿ�ɼ���"+zhicheng);
		        
		        if (zhicheng==true) {
					System.out.println("###############�������ӳɹ�");
					driver.quit();
				} else {
                    System.out.println("#############��������ʧ��");
                    driver.quit();
				}
              
              //���浽��������
             /* driver.switchTo().frame(addframe);
              Thread.sleep(1000);
              //�Ҽ���λ,��ʾ���õ�����
              WebElement dep3;
              dep3=driver.findElement(By.xpath(".//*[@id='mini-41$headerCell2$9']"));
              action.contextClick(dep3).perform();
              
              Thread.sleep(1000);
              driver.switchTo().defaultContent();
              Thread.sleep(1000);
              //����ƶ�����������
              WebElement save;
              save= driver.findElement(By.xpath(".//*[@id='mini-252']/div/div/div[1]/div[8]/div/div[2]"));
              action.moveToElement(save).perform();
              //������浽��������
              driver.findElement(By.xpath(".//*[@id='mini-322']/div/div/div[1]/div[1]/div")).click();
              
              */
              
              
               //driver.quit();   
      } catch (Exception e) {
			// TODO: handle exception
			System.out.println("������ӵ��ȷ��ʧ��###################"+e);
			driver.quit();
		}

  }
}
