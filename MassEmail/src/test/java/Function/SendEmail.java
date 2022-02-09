package Function;

import javax.activation.DataSource;
import javax.activation.FileDataSource;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.testng.annotations.Test;

import Common.BaseClass;

public class SendEmail extends BaseClass {
	
	@Test(dataProvider = "ObjectRepository")
	public void SendMultipleEmails(String Email_Id, String username, String Password, String website, String Signature)
			throws Exception {
		// Navigate to new inventory page


		Email email = new SimpleEmail();
		email.setHostName("us2.smtp.mailhostbox.com");
		email.setSmtpPort(25);
		email.setAuthenticator(new DefaultAuthenticator("vishnu.vs@xilligence.com", "654321Aa@"));
		//email.setSSLOnConnect(true);
		email.setFrom("vishnu.vs@xilligence.com");
		email.addTo(Email_Id);

		email.setSubject("Introducing Kurien Varghese");
		email.setMsg("Dear Doctor,\r\n"
				+ "\r\n"
				+ "Wallace Pharmaceuticals welcomes you for your New Digital journey..!!\r\n"
				+ "We are happy to be your partners in enhancing connect with your patients on the World Wide Web As you have already received your personalized website next step is to activate your Practice Management Software Please download the PH Practitioner app using the below link:\r\n"
				+ "\r\n"
				+ "http://onelink.to/hx9sgm\r\n"
				+ "\r\n"
				+ "Please find below process to logging in the App and website to activate your account You can login to the app and website using the below details/or you can use the mobile number provided at the time of registration(OTP will be sent to that number)\r\n"
				+ "\r\n"
				+ "Username : "+username 
				+ "\r\n"
				+ "Password : "+Password
				+ "\r\n"
				+ "Your website is : "+website
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ Signature);
 

		
		
		email.send();
		System.out.println("Email send succcessfully");

}
}