package com.proj.htmltopdf;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

public class PDFConverter 
{
    public static void main( String[] args ) throws DocumentException, IOException
    {
    	
    	String workDir = System.getProperty("user.dir").toString();
      // step 1
        Document document = new Document();
        // step 2
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(workDir+"/SaveAsPage.pdf"));
        // step 3
        document.open();
        // step 4
        XMLWorkerHelper.getInstance().parseXHtml(writer, document,new FileInputStream(workDir+"/LinkedInLogin.html")); 
        //step 5
         document.close();
 
        System.out.println( "PDF Created!" );
    }
}