package com.jtv.miracle3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/*
 * �˲����������������Ե�½mircle
 * 
 * user::shiwh
 */
public class LoginMirace3 {
@Test
	public void loginmiracle() throws Exception {
	
	try {
	
	  System.out.println("*****************�˲����������������Ե�½����");

		Login login = new Login();
		
		login.loginmiracle("admin", "123");
		
		WebDriver driver = login.Driver();
		
		
        String mircaleTitle;
        
        mircaleTitle=driver.getTitle();

       //System.out.println(mircaleTitle);

       //mircaleTitle is "Miracle 3"
        
       if(mircaleTitle.contentEquals("Miracle 3")){
       	
       	System.out.println("###��֤��¼�ɣ����Ի�ȡ��title");
       }else{
       	System.out.println("###��¼ʧ��,��ȡ��title��Ԥ�ڲ���");
       }
		
		//��ȫ�˳�
		String safeOut;
		safeOut=driver.findElement(By.id("btn-logout$text")).getText();
	    //System.out.println(safeOut);
		
		//�ж�ϵͳ��¼���Ƿ���ʾ��ȫ�˳����������Ƿ��¼�ɹ�
		if(safeOut.contentEquals("��ȫ�˳�")){
			System.out.println("��¼��֤ͨ��");
			login.Driver().quit();
			
		}else{
			System.out.println("��¼ʧ��");
			login.Driver().quit();
		}
		
		
		//��֤��ȫ�˳�
		//���쳣����
		

		
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("��¼���ܲ���ʧ��###################"+e);
		}
		
	}

	
	

}
