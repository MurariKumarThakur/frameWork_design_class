package demo;

import java.io.IOException;
import java.util.Map;

import com.file.utility.propertyReusable;

public class class1 {

	public static void main(String[] args) throws IOException {

		propertyReusable config = new propertyReusable("./config.property");
		String url1 = config.getPropertyFileValue("url");
		propertyReusable object = new propertyReusable("./src/test/java/com/app/objectRepository/OR.gamil.properties");
		System.out.println(url1);
		String gmail_login_id = object.getPropertyFileValue("gmail_userField_By_Id");

		System.out.println(gmail_login_id);
		
		
		object.SetProperty("gamil_navigation_button_By_name", "navi");
		
		Map alldata =  config.getAllPropertyData();
		
		  System.out.println(alldata);
	}

}
