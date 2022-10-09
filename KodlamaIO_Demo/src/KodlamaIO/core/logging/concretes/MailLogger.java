package KodlamaIO.core.logging.concretes;

import KodlamaIO.core.logging.abstracts.Logger;

public class MailLogger implements Logger {

	@Override
	public void log(String data) {
		System.out.println("Maile loglandi : " + data);
		
	}

}
