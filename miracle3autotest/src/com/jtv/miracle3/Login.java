package com.jtv.miracle3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

//先把登录进行封装，登录的时候调用.把浏览器也进行封装。随时调用，就不用再new了
//把所有的界面对象进行封装，方便后期修改
public class Login {
	
    private  WebDriver driver;
	
	public  WebDriver Driver(){
		return driver;
	}
	
	//登录界面--用户名
	String loginname = "j_username$text";
	public String getLoginname(){
		return loginname;
	}
	
	//登录界面--密码；
	String loginpasswd = "j_password$text";
	public String getPasswd(){
		return loginpasswd;
	}
	
	//设置
	String  config = "btn-config";
	public String getConfig(){
		return config;
		}
	
	//设置--工具栏
	String tool = "mini-32";
	public String getTool(){
		return tool;
	}

	//系统维护
	String xitongweihu = ".//*[@id='mini-98$2']/div[1]";
	
	public String getXtwh(){
		return xitongweihu;
	}
	
	 public void xtwh(){
		  java.util.List<WebElement> module = driver.findElement(By.id("outlook-tree")).findElements(By.className("mini-outlookbar-groupHeader"));
		  for(WebElement a:module){
			//System.out.println(a.getText());
			if(a.getText().contains("系统维护")){
				a.click();
			}
		  }
	  }
	  
	
	//系统维护--通用表单
	String CommonTable = "10$cell$2";
	public String getCommonTable(){
	    return CommonTable;
	}
	
	//系统维护--通用表单--查询界面所在的框架
	String CommonTableFrame="mini-iframe-157";
	public String getCommonFrame(){
		return CommonTableFrame;
	}
	
	//系统维护--【角色】
	String role = ".//*[@id='7$cell$2']/div/div/span[2]/span[2]";
	public String getRole(){
		return role;
	}
	
	//系统维护--角色--角色所在框架
	String roleFrame = ".//*[@id='mini-80$body$2']/iframe";
	public String getRoleFrame(){
		return roleFrame;
	}
	
	//系统维护--【人员】
	
	String renyuan = ".//*[@id='6$cell$2']/div/div/span[2]/span[2]";
	
	public String getRenyuan(){
		return renyuan;
	}
	
	//人员--查询界面所在的框架
	
	String frame = "mini-iframe-151";
	
	public String getFrame(){
		return frame;
	}
	
	//人员--【单位】
	String dept = "mini-42$headerCell2$8";
	public String getDept(){
		return dept;
	}
	
	//单位--右键--单元格
	String table = ".//*[@id='m-cell$text']";
	public String getTable(){
		return table;
	}
	
	//单位--右键--单元格--批量增加
	String patchAdd = ".//*[@id='m-cell-batch-add$text']";
	public String getPatchAdd(){
		return patchAdd;
	}
	
	//单位--右键--单元格--批量增加--确定
	String AlertSure = ".//*[@id='mini-158']/div/div[2]/div[3]/div/a[1]";
	public String getAlertSure(){
		return AlertSure;
	}
	
	//单位--右键--单元格--批量删除
	String patchDelete = ".//*[@id='m-cell-batch-delete$text']";
	public String getPatchDelete(){
		return patchDelete;
	}
	
	//单位--右键--【组件】
	String zujian = ".//*[@id='m-comp$text']";
	public String getZujiain(){
		return zujian;
	}
	
	//单位--右键--选择组件--【选择列】
	String xzl = ".//*[@id='m-select$text']";
	public String getXzl(){
		return xzl;
	}
    
	//单位--右键--选择组件--选择列--【单选框】
	 String radiobox = ".//*[@id='m-select-radio$text']";
	
	 public String getRadiobox(){
		 return radiobox;
	 }
	//单位--右键--选择组件--选择列--【多选框】
	 
	 String checkbox = ".//*[@id='m-select-checkbox$text']";
	 
	 public String getCheckbox(){
		 return checkbox;
	 }
	 
	 //单位--右键--【数据】
	 String data = "m-data$text";
	 public String getData(){
		 return data;
	 }
	 
	 //单位--右键--数据--【自动查询】
	 
	 String autoQuary = "m-data-autoquery$text";
	 public String getAutoQuary(){
		 return autoQuary;
	 }
	 
	 //单位--右键--【保存公用配置】
	 String publicSave = ".//*[@id='m-save-public$text']";
	 public String getPublicSave(){
		 return publicSave;
	 }
	 
	 
	 //人员-新增--编辑界面所在框架
	 String editframe = ".//*[@id='edit-dialog-db52a5d0-0c76-4ab4-ad5b-38074b9bb2af']/div/div[2]/div[2]/iframe";
	 public String getEditFrame(){
		 return editframe;
	 }
	 
	 
	 
	 
	 //系统维护--人员--【流程授权】
	 
	 String lcsq = "btn-wfRoleGrant";
	 public String getLcsq(){
		 return lcsq;
	 }
	
	 //系统维护--人员--流程授权--所在的框架
	 
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
         // the title is "请登录"

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
