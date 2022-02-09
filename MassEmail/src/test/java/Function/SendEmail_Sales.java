package Function;



import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.testng.annotations.Test;

import Common.BaseClass;

public class SendEmail_Sales extends BaseClass {
	
	@Test(dataProvider = "ObjectRepository")
	public void SendMultipleEmails(String EmployeeFirstName, String EmployeeTitle, String CompanyName, String EmployeeWorkEmail, String CompanyHQPhone, String SignatureUpdated)
			throws Exception {
		// Navigate to new inventory page


		Email email = new SimpleEmail();
		email.setHostName("us2.smtp.mailhostbox.com");
		email.setSmtpPort(25);
		email.setAuthenticator(new DefaultAuthenticator("rashif@xilligence.com", "September2021firstday"));
		//email.setSSLOnConnect(true);
		email.setFrom("rashif@xilligence.com");
		email.addTo(EmployeeWorkEmail);

		email.setSubject("Request for Meeting - Xilligence - Kurien Varghese - Software Testing & QA");
		email.setMsg("Dear " +EmployeeFirstName+", \r\n"
				+ "\r\n"
				+ "Greetings!! Hope you are doing well & staying safe! \r\n"
				+ "\r\n"
				+ "I am delighted to write this note to you. Let me quickly take the liberty of introducing myself, I’m Abdul Rashif, I head the business for Xilligence, we are a CMMi Level 3 certified product engineering company specialising in Software Testing & QA services for the banking and financial sector. We are headquartered in Toronto, Canada with offshore hub in India and with offices in Singapore & Dubai.\r\n"
				+ "\r\n"
				+ "I am reaching out to you with an intention of partnering with "+CompanyName+" as its trusted Software Testing & QA partner. It is our success and focus on QA and Testing as a practice, which makes us one of the leading QA/Testing specialists globally. In addition to being inexpensive, which is the obvious benefit; Xilligence QA can complement and augment your present capabilities and resources as well as accelerate your development cycles when you are growing fast. \r\n"
				+ "\r\n"
				+ "Our portfolio of services for the banking business such as yours include “Functional Testing -Manual Testing (UAT /SIT) & Automation Testing, Performance/ Load Testing, Security assessment including penetration testing & Security code review” etc.\r\n"
				+ "\r\n"
				+ "I am keen in fixing up a telecon with you according to your convenience along with our Advisory board member (Mr. Kurien Varghese) and our banking service head (Mr. Sandeep Mathias) to explain and exhibit our offering around Software Testing & QA \r\n" 
				+ "\r\n"
				+ "A brief on Mr. Kurien Varghese: Mr. Varghese has over 40 years of high-level leadership in the IT & Banking sector in the Kuwait market. He has occupied various high-profile positions, such as Head of IT, Consultant - IT & Banking, Head of Project Management Office, Project Manager, etc. \r\n"
				+ "\r\n"
				+ "Mr. Varghese has worked with Burgan Bank, Boubyan Bank, Hasibat Information Technology (ex-Kuwait Computer Company), NCR Corporation, Commercial Bank of Kuwait, etc. He has managed the IT divisions of two banks and oversaw establishing an Islamic Bank from systems selection to go live.\r\n"
				+ "\r\n"
				+ "As Head of IT and PMO, he has managed the implementation of various banking projects such as Core Banking Systems, Internet and Mobile Banking, Omni Channel Solution, Corporate Cash Management, Card Management, ATM & POS Switch, RTGS, AML, SWIFT, Payment Gateway, MasterSend, Ripple, Loyalty system, Contact Center, Test Management, Trade Finance, etc \r\n"
				+ "\r\n"
				+ "Looking forward to hearing from you. Wishing you a great day!"
				+ "\r\n"
				+ "\r\n"
				+ "Regards, \r\n"
				+ "Rashif Abdul \r\n"
				+ "Manager, Sales & Strategy – UAE, Qatar & Bahrain    \r\n"
				+ "Xilligence Ltd. \r\n"
				+ "+971-54-597-3371 | +91-991-611-1567 | \r\n"
				+ SignatureUpdated);
 

		
		
		email.send();
		System.out.println("Email send succcessfully to"+EmployeeFirstName);

}
}