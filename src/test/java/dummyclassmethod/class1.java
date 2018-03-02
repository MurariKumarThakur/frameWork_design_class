package dummyclassmethod;

import java.io.IOException;
import java.util.Map;

import com.file.utility.propertyFileReusable;

public class class1 {

	public static void main(String[] args) throws IOException {

		propertyFileReusable config = new propertyFileReusable("./config.property");
		String url1 = config.getPropertyFileValue("url");
		propertyFileReusable object = new propertyFileReusable("./src/test/java/com/app/objectRepository/OR.gamil.properties");
		System.out.println(url1);
		String gmail_login_id = object.getPropertyFileValue("gmail_userField_By_Id");

		System.out.println(gmail_login_id);

		object.SetProperty("gamil_navigation_button_By_name", "navi");

		Map alldata = config.getAllPropertyData();

		System.out.println(alldata);
	}

}
