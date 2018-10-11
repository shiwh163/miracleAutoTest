package com.jtv.miracle3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

//�Ȱѵ�¼���з�װ����¼��ʱ�����.�������Ҳ���з�װ����ʱ���ã��Ͳ�����new��
//�����еĽ��������з�װ����������޸�
public class Login {
	
    private  WebDriver driver;
	
	public  WebDriver Driver(){
		return driver;
	}
	
	//��¼����--�û���
	String loginname = "j_username$text";
	public String getLoginname(){
		return loginname;
	}
	
	//��¼����--���룻
	String loginpasswd = "j_password$text";
	public String getPasswd(){
		return loginpasswd;
	}
	
	//����
	String  config = "btn-config";
	public String getConfig(){
		return config;
		}
	
	//����--������
	String tool = "mini-32";
	public String getTool(){
		return tool;
	}

	//ϵͳά��
	String xitongweihu = ".//*[@id='mini-98$2']/div[1]";
	
	public String getXtwh(){
		return xitongweihu;
	}
	
	 public void xtwh(){
		  java.util.List<WebElement> module = driver.findElement(By.id("outlook-tree")).findElements(By.className("mini-outlookbar-groupHeader"));
		  for(WebElement a:module){
			//System.out.println(a.getText());
			if(a.getText().contains("ϵͳά��")){
				a.click();
			}
		  }
	  }
	  
	
	//ϵͳά��--ͨ�ñ�
	String CommonTable = "10$cell$2";
	public String getCommonTable(){
	    return CommonTable;
	}
	
	//ϵͳά��--ͨ�ñ�--��ѯ�������ڵĿ��
	String CommonTableFrame="mini-iframe-157";
	public String getCommonFrame(){
		return CommonTableFrame;
	}
	
	//ϵͳά��--����ɫ��
	String role = ".//*[@id='7$cell$2']/div/div/span[2]/span[2]";
	public String getRole(){
		return role;
	}
	
	//ϵͳά��--��ɫ--��ɫ���ڿ��
	String roleFrame = ".//*[@id='mini-80$body$2']/iframe";
	public String getRoleFrame(){
		return roleFrame;
	}
	
	//ϵͳά��--����Ա��
	
	String renyuan = ".//*[@id='6$cell$2']/div/div/span[2]/span[2]";
	
	public String getRenyuan(){
		return renyuan;
	}
	
	//��Ա--��ѯ�������ڵĿ��
	
	String frame = "mini-iframe-151";
	
	public String getFrame(){
		return frame;
	}
	
	//��Ա--����λ��
	String dept = "mini-42$headerCell2$8";
	public String getDept(){
		return dept;
	}
	
	//��λ--�Ҽ�--��Ԫ��
	String table = ".//*[@id='m-cell$text']";
	public String getTable(){
		return table;
	}
	
	//��λ--�Ҽ�--��Ԫ��--��������
	String patchAdd = ".//*[@id='m-cell-batch-add$text']";
	public String getPatchAdd(){
		return patchAdd;
	}
	
	//��λ--�Ҽ�--��Ԫ��--��������--ȷ��
	String AlertSure = ".//*[@id='mini-158']/div/div[2]/div[3]/div/a[1]";
	public String getAlertSure(){
		return AlertSure;
	}
	
	//��λ--�Ҽ�--��Ԫ��--����ɾ��
	String patchDelete = ".//*[@id='m-cell-batch-delete$text']";
	public String getPatchDelete(){
		return patchDelete;
	}
	
	//��λ--�Ҽ�--�������
	String zujian = ".//*[@id='m-comp$text']";
	public String getZujiain(){
		return zujian;
	}
	
	//��λ--�Ҽ�--ѡ�����--��ѡ���С�
	String xzl = ".//*[@id='m-select$text']";
	public String getXzl(){
		return xzl;
	}
    
	//��λ--�Ҽ�--ѡ�����--ѡ����--����ѡ��
	 String radiobox = ".//*[@id='m-select-radio$text']";
	
	 public String getRadiobox(){
		 return radiobox;
	 }
	//��λ--�Ҽ�--ѡ�����--ѡ����--����ѡ��
	 
	 String checkbox = ".//*[@id='m-select-checkbox$text']";
	 
	 public String getCheckbox(){
		 return checkbox;
	 }
	 
	 //��λ--�Ҽ�--�����ݡ�
	 String data = "m-data$text";
	 public String getData(){
		 return data;
	 }
	 
	 //��λ--�Ҽ�--����--���Զ���ѯ��
	 
	 String autoQuary = "m-data-autoquery$text";
	 public String getAutoQuary(){
		 return autoQuary;
	 }
	 
	 //��λ--�Ҽ�--�����湫�����á�
	 String publicSave = ".//*[@id='m-save-public$text']";
	 public String getPublicSave(){
		 return publicSave;
	 }
	 
	 
	 //��Ա-����--�༭�������ڿ��
	 String editframe = ".//*[@id='edit-dialog-db52a5d0-0c76-4ab4-ad5b-38074b9bb2af']/div/div[2]/div[2]/iframe";
	 public String getEditFrame(){
		 return editframe;
	 }
	 
	 
	 
	 
	 //ϵͳά��--��Ա--��������Ȩ��
	 
	 String lcsq = "btn-wfRoleGrant";
	 public String getLcsq(){
		 return lcsq;
	 }
	
	 //ϵͳά��--��Ա--������Ȩ--���ڵĿ��
	 
	 String lcframe = ".//*[@id='assign-dept']/div/div[2]/div[2]/iframe";
	 public String getLcframe(){
		 return lcframe;
	 }
	 
	public void loginmiracle(String loginname, String loginpasswd) throws InterruptedException{

		  driver = new FirefoxDriver();
		  driver.manage().window().maximize();
		 
         driver.get("http://172.16.80.38:9999/miracle3");


	      
         driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

         //System.out.println(driver.getTitle());
         // the title is "���¼"

         driver.findElement(By.id("j_username$text")).clear();
         driver.findElement(By.id("j_username$text")).sendKeys(loginname);
     
         driver.findElement(By.id("j_password$text")).clear();
         driver.findElement(By.id("j_password$text")).sendKeys(loginpasswd);

         driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

         driver.findElement(By.id("btnLogin")).click();
         
         Thread.sleep(3000);

         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         


}
}
