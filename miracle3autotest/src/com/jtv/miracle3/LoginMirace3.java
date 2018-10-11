package com.jtv.miracle3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/*
 * 此测试用例是用来测试登陆mircle
 * 
 * user::shiwh
 */
public class LoginMirace3 {
@Test
	public void loginmiracle() throws Exception {
	
	try {
	
	  System.out.println("*****************此测试用例是用来测试登陆功能");

		Login login = new Login();
		
		login.loginmiracle("admin", "123");
		
		WebDriver driver = login.Driver();
		
		
        String mircaleTitle;
        
        mircaleTitle=driver.getTitle();

       //System.out.println(mircaleTitle);

       //mircaleTitle is "Miracle 3"
        
       if(mircaleTitle.contentEquals("Miracle 3")){
       	
       	System.out.println("###验证登录成，可以获取到title");
       }else{
       	System.out.println("###登录失败,获取的title与预期不符");
       }
		
		//安全退出
		String safeOut;
		safeOut=driver.findElement(By.id("btn-logout$text")).getText();
	    //System.out.println(safeOut);
		
		//判断系统登录后是否显示安全退出，来测试是否登录成功
		if(safeOut.contentEquals("安全退出")){
			System.out.println("登录验证通过");
			login.Driver().quit();
			
		}else{
			System.out.println("登录失败");
			login.Driver().quit();
		}
		
		
		//验证安全退出
		//抛异常机制
		

		
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("登录功能测试失败###################"+e);
		}
		
	}

	
	

}
