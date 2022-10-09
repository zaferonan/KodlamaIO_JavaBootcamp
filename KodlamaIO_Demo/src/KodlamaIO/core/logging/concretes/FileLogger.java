package KodlamaIO.core.logging.concretes;

import KodlamaIO.core.logging.abstracts.Logger;

public class FileLogger implements Logger {

	@Override
	public void log(String data) {
		System.out.println("Dosyaya loglandi : " + data);

	}

}
