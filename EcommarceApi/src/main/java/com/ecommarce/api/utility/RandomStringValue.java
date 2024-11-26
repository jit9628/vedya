package com.ecommarce.api.utility;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.validation.Payload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.TextAlignment;

//Java program generate a random AlphaNumeric String
//using Math.random() method
@Component
public class RandomStringValue {
	@Autowired
	private static Payload payload;

//function to generate a random string of length n
	public static String getAlphaNumericString() {

//choose a Character random from this String
		String AlphaNumericString = "VEDAKSHI01234";

//create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(6);

		for (int i = 0; i < 6; i++) {

//generate a random number between
//0 to AlphaNumericString variable length
			int index = (int) (AlphaNumericString.length() * Math.random());

//add Character one by one in end of sb
			sb.append(AlphaNumericString.charAt(index));
		}

		return sb.toString();
	}

	public static String getRandomNumber() {

//choose a Character random from this String
		String RendomNumbers = "0123456789";

//create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(6);

		for (int i = 0; i < 6; i++) {

//generate a random number between
//0 to AlphaNumericString variable length
			int index = (int) (RendomNumbers.length() * Math.random());

//add Character one by one in end of sb
			sb.append(RendomNumbers.charAt(index));
		}
		System.out.println("Random Number Is : " + sb);
		return sb.toString();
	}

	public String generateToken() {
		StringBuilder token = new StringBuilder();

		return token.append(UUID.randomUUID().toString()).append(UUID.randomUUID().toString()).toString();
	}

	public static int serialWiseRandomNumber() {

		int serialNo = 000;

		Calendar cal = Calendar.getInstance();

		int date = cal.get(Calendar.DATE);
		int month = cal.get(Calendar.MONTH) + 1;
		int year = cal.get(Calendar.YEAR);

		for (int i = 0; i < 10; i++) {

			serialNo++;
			System.out.println("Testing =====> " + year + month + date + serialNo);

		}
		return serialNo;
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

//Get the size n
		int n = 20;

//Get and display the alphanumeric string
		System.out.println(RandomStringValue.getRandomNumber());
		try {
			LocalDateTime now = LocalDateTime.now();
			System.out.println("Before Formatting: " + now);
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			String formatDateTime = now.format(format);
			System.out.println("After Formatting: " + formatDateTime);
			String splitdate = formatDateTime.split(" ")[0];
			System.out.println("Split string" + splitdate);
			Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(splitdate);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date1);
			cal.add(Calendar.DATE, 5);
			Date dateWith5Days = cal.getTime();
			Calendar instance = Calendar.getInstance();
			int date = dateWith5Days.getDate();

			System.out.println(" Interval Date " + dateWith5Days + "  :: " + date);
//		        DateTimeFormatter f  = DateTimeFormatter.ofPattern( "dd/MM/uuuu" ) ;
//		        LocalDate ld = LocalDate.parse( (CharSequence) dateWith5Days , f ) ;
//		        LocalDate fiveDaysLater = ld.plusDays( 5 ) ;
//		        System.out.println("fiveDaysLater"+fiveDaysLater);
//		        String output = fiveDaysLater.format( f ) ;
//			System.out.println("output"+output);

			// Creating a PdfWriter
			// List<OrderDetailsPojo> bookingDetail =
			// payload.getSpecificUserBookingDetail(623205);

//			for(int i=0;i<=4;i++) {
			String dest = "invoice.pdf";
			PdfWriter writer = new PdfWriter(dest);
			// Creating a PdfDocument
			PdfDocument pdfDoc = new PdfDocument(writer);

			// Adding a new page
			pdfDoc.addNewPage();
			// Creating a Document
			Document document = new Document(pdfDoc);

			// Closing the document

			System.out.println("PDF Created");

			String content = "INVOICE";
			Paragraph paragraph = new Paragraph(content);
			paragraph.setFontSize(14);
			paragraph.setTextAlignment(TextAlignment.CENTER);
			paragraph.setBorder(Border.NO_BORDER); // set border
			paragraph.setFirstLineIndent(20);
			paragraph.setItalic();
			paragraph.setBold();
			// paragraph.setBackgroundColor(new DeviceRgb(155, 185, 245));
			paragraph.setMargin(10);
			paragraph.setPaddingLeft(10);
			paragraph.setPaddingRight(10);
			paragraph.setWidth(1000);
			paragraph.setHeight(30);
			document.add(paragraph);
			float[] pointColumnWidths = { 150F, 150F, 150F, 150F };
			float[] dealertablecolumnwidth = { 500, 100F };
			float[] fromdetail = { 500F };
			com.itextpdf.layout.element.Table dealertable = new com.itextpdf.layout.element.Table(dealertablecolumnwidth);
			com.itextpdf.layout.element.Table table = new com.itextpdf.layout.element.Table(pointColumnWidths);
			com.itextpdf.layout.element.Table fromdetails = new com.itextpdf.layout.element.Table(fromdetail);
			fromdetails.addCell(new Cell().add("Sold By : Vedakshi Shops").setBorder(Border.NO_BORDER).setBold());
			fromdetails.addCell(new Cell().add("Ship-from Address :").setBorder(Border.NO_BORDER).setBold());
			fromdetails.addCell(new Cell().add(" hdjf djhfggggdgd bdhgdg djdgs bvhjdvdvd vdjhvgddsdjhvdgvssgvs ")
					.setBorder(Border.NO_BORDER));
			fromdetails.addCell(
					new Cell().add("ggsegsseg e  dfge fk kdj g rr r , dkjg yg k g , b ").setBorder(Border.NO_BORDER));
			fromdetails.addCell(
					new Cell().add("eru gjk k  mdvbdmjs djgd v bgbd, bs  gdj sgs ").setBorder(Border.NO_BORDER));
			// new Table(pointColumnWidths);
			// Table table = new Table(4); init by number of columns
			// dealertable.addCell(new Cell().add(new Paragraph("Sold By: Vedakshi Shops
			// ")).setBorder(Border.NO_BORDER).setBold());
			// dealertable.addCell(new Cell().add(new Paragraph("Ship-from Address
			// ")).setBorder(Border.NO_BORDER));
			dealertable.addCell(new Cell().add(fromdetails).setBorder(Border.NO_BORDER));
			dealertable.addCell(new Cell().add(new Paragraph("Name")).setBorder(Border.NO_BORDER));
			dealertable.setMarginBottom(12F);
			table.addCell(new Cell().add(new Paragraph("Id")));
			table.addCell(new Cell().add(new Paragraph("Name")));
			table.addCell(new Cell().add(new Paragraph("Location")));
			table.addCell(new Cell().add(new Paragraph("Date")));
			table.addCell(new Cell().add(new Paragraph("1000")).setBorder(Border.NO_BORDER));
			table.addCell(new Cell().add(new Paragraph("T-Shirt")).setBorder(Border.NO_BORDER));
			table.addCell(new Cell().add(new Paragraph("Jaipur")).setBorder(Border.NO_BORDER));
			table.addCell(new Cell().add(new Paragraph("01/12/2020")).setBorder(Border.NO_BORDER));
			table.addCell(new Cell().add(new Paragraph("1005")).setBorder(Border.NO_BORDER));
			table.addCell(new Cell().add(new Paragraph("Item-2")).setBorder(Border.NO_BORDER));
			table.addCell(new Cell().add(new Paragraph("uuuuyyuyu")).setBorder(Border.NO_BORDER));
			table.addCell(new Cell().add(new Paragraph("05/12/2020")).setBorder(Border.NO_BORDER));
			document.add(new Cell().add(dealertable).setBorder(Border.NO_BORDER));
			document.add(new Cell().add(table.setBorder(Border.NO_BORDER)));
			document.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(" " + RandomStringValue.serialWiseRandomNumber());
	}

}
