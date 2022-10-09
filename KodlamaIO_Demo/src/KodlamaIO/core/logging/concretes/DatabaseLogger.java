package KodlamaIO.core.logging.concretes;

import KodlamaIO.core.logging.abstracts.Logger;

public class DatabaseLogger implements Logger {

	@Override
	public void log(String data) {
		System.out.println("Veritabanina loglandi : " + data);

	}

}
