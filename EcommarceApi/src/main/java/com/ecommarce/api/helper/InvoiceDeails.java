package com.ecommarce.api.helper;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.ecommarce.api.payload.OrderDetailsPojo;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;

@Component
public class InvoiceDeails {
/*
	public void getInvoiceData(List<OrderDetailsPojo> bookingDetail)
			throws FileNotFoundException, MalformedURLException {
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
		paragraph.setMargin(10);
		paragraph.setPaddingLeft(10);
		paragraph.setPaddingRight(10);
		paragraph.setWidth(1000);
		paragraph.setHeight(30);
		document.add(paragraph);
		float[] pointColumnWidths = { 150F, 150F, 150F, 150F };
		float[] dealertablecolumnwidth = { 300, 300F };
		float[] fromdetail = { 300F };
		float[] customerdetail = { 300F };
		float[] fullwidth = { 150F * 4 };
		com.itextpdf.layout.element.Table dealertable = new com.itextpdf.layout.element.Table(dealertablecolumnwidth);
		com.itextpdf.layout.element.Table table = new com.itextpdf.layout.element.Table(pointColumnWidths);
		com.itextpdf.layout.element.Table fromdetails = new com.itextpdf.layout.element.Table(fromdetail);
		com.itextpdf.layout.element.Table fullwidths = new com.itextpdf.layout.element.Table(fullwidth);
		com.itextpdf.layout.element.Table customerdetails = new com.itextpdf.layout.element.Table(customerdetail);

		fromdetails.addCell(new Cell().add("Sold By : Vedakshi Shops").setBorder(Border.NO_BORDER).setBold());
		fromdetails.addCell(new Cell().add("Ship-from Address :").setBorder(Border.NO_BORDER).setBold());
		fromdetails.addCell(new Cell().add(" hdjf djhfggggdgd bdhgdg djdgs bvhjdvdvd vdjhvgddsdjhvdgvssgvs ")
				.setBorder(Border.NO_BORDER));
		fromdetails.addCell(
				new Cell().add("ggsegsseg e  dfge fk kdj g rr r , dkjg yg k g , b ").setBorder(Border.NO_BORDER));
		fromdetails
				.addCell(new Cell().add("eru gjk k  mdvbdmjs djgd v bgbd, bs  gdj sgs ").setBorder(Border.NO_BORDER));

		// customer detild
		customerdetails.addCell(new Cell().add("Customer Name :" + bookingDetail.get(0).getCustomername())
				.setBorder(Border.NO_BORDER).setBold());
		customerdetails.addCell(new Cell().add("Billing Address :").setBorder(Border.NO_BORDER).setBold());
		customerdetails.addCell(new Cell().add("LalKothi C Scheme Jaipur ").setBorder(Border.NO_BORDER));
		customerdetails.addCell(new Cell().add("pincode :203015").setBorder(Border.NO_BORDER));

		dealertable.addCell(new Cell().add(fromdetails).setBorder(Border.NO_BORDER));
		dealertable.addCell(new Cell().add(customerdetails).setBorder(Border.NO_BORDER));
		dealertable.setMarginBottom(12F);

		// add devidder
		Border db = new SolidBorder(Color.GRAY, 2F / 2F);
		fullwidths.setBorder(db);
		document.add(fullwidths);

		table.addCell(new Cell().add(new Paragraph("product name")).setBorder(Border.NO_BORDER));
		table.addCell(new Cell().add(new Paragraph("quantity")).setBorder(Border.NO_BORDER));
		table.addCell(new Cell().add(new Paragraph("price")).setBorder(Border.NO_BORDER));
		table.addCell(new Cell().add(new Paragraph("subtotal")).setBorder(Border.NO_BORDER));

		for (int i = 0; i < bookingDetail.size(); i++) {
			table.addCell(new Cell().add(new Paragraph(bookingDetail.get(i).getOpname())).setBorder(Border.NO_BORDER));
			table.addCell(new Cell().add(new Paragraph(String.valueOf(bookingDetail.get(i).getOrderquantity())))
					.setBorder(Border.NO_BORDER));
			table.addCell(new Cell().add(new Paragraph(String.valueOf(bookingDetail.get(i).getPrice())))
					.setBorder(Border.NO_BORDER));
			table.addCell(new Cell().add(new Paragraph(String.valueOf(bookingDetail.get(i).getSubtotal())))
					.setBorder(Border.NO_BORDER));
		}

		document.add(new Cell().add(dealertable).setBorder(Border.NO_BORDER));
		document.add(fullwidths);
		dealertable.setMarginBottom(12F);
		document.add(new Cell().add(table.setBorder(Border.NO_BORDER)));
		document.close();
		
		amazoneInvoiceTemplate(bookingDetail);
	}
*/
	public void amazoneInvoiceTemplate(List<OrderDetailsPojo> bookingDetail, HttpServletResponse httpServletResponse) throws MalformedURLException {
		String dest = "AmazoneInvoice.pdf";
		PdfWriter writer;
		try {
			writer = new PdfWriter(dest);
			// Creating a PdfDocument
			PdfDocument pdfDoc = new PdfDocument(writer);
			// Adding a new page
			pdfDoc.addNewPage();
			// Creating a Document
			Document document = new Document(pdfDoc);
//		create top leveltable
			float[] specificdetai = { 150F, 450F };
			float[] nestedspecificdetails = { 300F };
			float[] pointColumnWidths = { 150F, 20F, 150F, 150F };
			float[] dealertablecolumnwidth = { 300, 300F };
			float[] fromdetail = { 300F };
			float[] customerdetail = { 300F };
			float[] nestedcustomerdetails = { 300F };
			float[] fullwidth = { 150F * 4 };
			com.itextpdf.layout.element.Table dealertable = new com.itextpdf.layout.element.Table(
					dealertablecolumnwidth);
			com.itextpdf.layout.element.Table nestedspecificdetail = new com.itextpdf.layout.element.Table(
					nestedspecificdetails);
			com.itextpdf.layout.element.Table nestedcustomerdetail = new com.itextpdf.layout.element.Table(
					nestedcustomerdetails);

			com.itextpdf.layout.element.Table table = new com.itextpdf.layout.element.Table(pointColumnWidths);
			com.itextpdf.layout.element.Table fromdetails = new com.itextpdf.layout.element.Table(fromdetail);
			com.itextpdf.layout.element.Table fullwidths = new com.itextpdf.layout.element.Table(fullwidth);
			com.itextpdf.layout.element.Table customerdetails = new com.itextpdf.layout.element.Table(customerdetail);

			nestedspecificdetail
					.addCell(new Cell().add(new Paragraph("Sold By :")).setBorder(Border.NO_BORDER).setBold());

			nestedspecificdetail.addCell(new Cell().add(new Paragraph("Vedya")).setBorder(Border.NO_BORDER));
			nestedspecificdetail.addCell(new Cell().add(new Paragraph(
					"It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout"))
					.setBorder(Border.NO_BORDER));
			fromdetails.addCell(new Cell().add(nestedspecificdetail).setBorder(Border.NO_BORDER));

//			fromdetails.addCell(new Cell().add("Sold By : Vedakshi Shops").setBorder(Border.NO_BORDER).setBold());
//			fromdetails.addCell(new Cell().add("Ship-from Address :").setBorder(Border.NO_BORDER).setBold());
//			fromdetails.addCell(new Cell().add(" hdjf djhfggggdgd bdhgdg djdgs bvhjdvdvd vdjhvgddsdjhvdgvssgvs ")
//					.setBorder(Border.NO_BORDER));
//			fromdetails.addCell(
//					new Cell().add("ggsegsseg e  dfge fk kdj g rr r , dkjg yg k g , b ").setBorder(Border.NO_BORDER));
//			fromdetails
//					.addCell(new Cell().add("eru gjk k  mdvbdmjs djgd v bgbd, bs  gdjsgsjksgffgfhhgffghhgfgffggfgfgfgfgf").setBorder(Border.NO_BORDER));
//			

			nestedcustomerdetail.addCell(new Cell().add("Billing Adderess :").setBorder(Border.NO_BORDER).setBold());
			nestedcustomerdetail.addCell(new Cell().add("Jitendra SHukla").setBorder(Border.NO_BORDER));
			nestedcustomerdetail.addCell(new Cell().add(
					"It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout")
					.setBorder(Border.NO_BORDER));
			nestedcustomerdetail.addCell(new Cell().add("Uttar Pradesh").setBorder(Border.NO_BORDER));
			nestedcustomerdetail.addCell(new Cell().add("pincode :231001").setBorder(Border.NO_BORDER));

			customerdetails.addCell(new Cell().add(nestedcustomerdetail).setBorder(Border.NO_BORDER));

			// customerdetails.addCell(new Cell().add(" hdjf djhfggggdgd bdhgdg djdgs
			// bvhjdvdvd vdjhvgddsdjhvdgvssgvs ");

			dealertable.addCell(new Cell().add(fromdetails).setBorder(Border.NO_BORDER));
			dealertable.addCell(new Cell().add(customerdetails).setBorder(Border.NO_BORDER));
			dealertable.setMarginBottom(35F);
			dealertable.setMarginTop(35F);

			// add devidder
			Border db = new SolidBorder(Color.GRAY, 2F / 2F);
			fullwidths.setBorder(db);
			// document.add(fullwidths);

			table.addCell(new Cell().add(new Paragraph("product name")).setBackgroundColor(Color.GRAY));
			table.addCell(new Cell().add(new Paragraph("Qty")).setBackgroundColor(Color.GRAY));
			table.addCell(new Cell().add(new Paragraph("Unit price")).setBackgroundColor(Color.GRAY));
			table.addCell(new Cell().add(new Paragraph("subtotal")).setBackgroundColor(Color.GRAY));
			Table specifics = new Table(specificdetai);

			// product booking detail
			for (int i = 0; i < bookingDetail.size(); i++) {
				table.addCell(new Cell().add(new Paragraph(bookingDetail.get(i).getOpname())));
				table.addCell(new Cell()
						.add(new Paragraph(String.valueOf(bookingDetail.get(i).getOrderquantity())).setPadding(10F)));
				table.addCell(new Cell().add(new Paragraph(String.valueOf(bookingDetail.get(i).getPrice()))));
				table.addCell(new Cell().add(new Paragraph(String.valueOf(bookingDetail.get(i).getSubtotal()))));
			}

			// add image into pdf cell
			// Creating an ImageData object
			String imageFile = "C:\\Users\\Precise\\Documents\\vedya\\EcommarceApi\\src\\main\\webapp\\resources\\images\\logo.png";
			ImageData data = ImageDataFactory.create(imageFile);
			// Creating an Image object
			Image img = new Image(data);
			// img.setFixedPosition(10, 10);
			img.setWidth(180F);
			// img.setHeight(150F);
			specifics.addCell(new Cell().add(img).setBorder(Border.NO_BORDER).setMargin(10));
			specifics.addCell(new Cell().add(new Paragraph("Tax Invoice/Bill of Supply/Cash Memo").setMarginLeft(60F))
					.setBold().setItalic().setBorder(Border.NO_BORDER));
			document.add(specifics);
			document.add(fullwidths);
			document.add(dealertable);
			document.add(table); // add product details

			// document.add(fromdetails.setBorder(Border.NO_BORDER).setMarginTop(20F));
			// document.add(customerdetails.setBorder(Border.NO_BORDER));
			// billing details

			document.close();
			// download pdf content 

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
