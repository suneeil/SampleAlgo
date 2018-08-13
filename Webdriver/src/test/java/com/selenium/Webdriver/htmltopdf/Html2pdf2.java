/*package com.selenium.Webdriver.htmltopdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.IOException;
import java.io.FileReader;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.StringReader;

import org.jsoup.Jsoup;

public class Html2pdf2 {
	private Html2pdf2() {}

	public static String extractText(Reader reader) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(reader);
		String line;
		while ( (line=br.readLine()) != null) {
			sb.append(line);
		}
		String textOnly = Jsoup.parse(sb.toString()).text();
		return textOnly;
	}

	public final static void main(String[] args) throws Exception{
		FileReader reader = new FileReader
				("example.html");

		try {

			OutputStream file = new FileOutputStream(new File("D:\\Test.pdf"));
			Document document = new Document();
			PdfWriter.getInstance(document, file);
			document.open();
			
			HTMLWorker htmlWorker = new HTMLWorker(document);
			
			htmlWorker.parse(new StringReader(ht));
			document.close();
			file.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("finished converting");
	}
}
*/