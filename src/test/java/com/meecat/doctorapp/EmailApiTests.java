package com.meecat.doctorapp;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import com.sendgrid.*;

import java.io.IOException;

@RunWith(SpringRunner.class)
public class EmailApiTests {

	@Test
	public void sendEmailTest() throws IOException {
		String apikey = "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";
		Email from = new Email("bruce.meerkat@gmail.com");
		String subject = "Hello World - Send From Doctor Online";
		Email to = new Email("coolcode@live.com");
		Content content = new Content("text/html", "<h1>Hello World!</h1>");
		Mail mail = new Mail(from, subject, to, content);

		SendGrid sg = new SendGrid(apikey);
		Request request = new Request();
		
		try {
			request.setMethod(Method.POST);
			request.setEndpoint("mail/send");
			request.setBody(mail.build());
			Response response = sg.api(request);
			// System.out.println(response.getStatusCode());
			// System.out.println(response.getBody());
			// System.out.println(response.getHeaders());

			assertEquals(202, response.getStatusCode());

		} catch (IOException ex) {
			throw ex;
		}
	}
}
