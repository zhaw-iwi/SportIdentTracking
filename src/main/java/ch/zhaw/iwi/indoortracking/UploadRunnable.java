package ch.zhaw.iwi.indoortracking;

import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UploadRunnable implements Runnable {

	private final static Logger LOGGER = Logger.getLogger(UploadRunnable.class.getName());
	
	private String url;
	private String stationNo;
	private String cardNo;
	private String punchList;
	
	public UploadRunnable(String url, String stationNo, String cardNo, String punchList) {
		super();
		this.url = url;
		this.stationNo = stationNo;
		this.cardNo = cardNo;
		this.punchList = punchList;
	}

	@Override
	public void run() {
		try {
			String request = url + stationNo + "/" + cardNo + "/" + punchList.toString();
			System.out.println("Send request GET " + request);
			URL u = new URL(request);
			Scanner urlScanner = new Scanner(u.openStream());
			String response = urlScanner.useDelimiter("\\Z").next();
			urlScanner.close();
			System.out.println("http result: " + response);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Failed handling data", e);
		}
	}

}
