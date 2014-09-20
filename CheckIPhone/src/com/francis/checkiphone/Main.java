package com.francis.checkiphone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		URL url;
		BufferedReader reader = null;
		String text;
		try {
			while (true) {
				url = new URL(
						"https://reserve.cdn-apple.com/HK/en_HK/reserve/iPhone/availability.json");

				reader = new BufferedReader(new InputStreamReader(
						url.openStream(), "UTF-8"));

				text = "";
				for (String line; (line = reader.readLine()) != null;) {
					text += line;
				}

				// JSONObject obj = new JSONObject(text);
				if (text.contains("true")) {
					JOptionPane.showMessageDialog(null, "Has iphone ar");
					//System.out.println("true");
				} else {
					//System.out.println("false");
				}

				Thread.sleep(1000);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (reader != null)
				try {
					reader.close();
				} catch (IOException ignore) {
				}
		}
	}
}
