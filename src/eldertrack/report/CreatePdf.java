package eldertrack.report;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import eldertrack.db.SQLObject;

public class CreatePdf{
	private String name;
	private String date;
	private String checktime;
	private double temp;
	private double blood;
	private double heart;
	private double sugar;
	private boolean eye;
	private boolean ear;
	private String eyeString;
	private String earString;
	private double tempM;
	private double bloodM;
	private double heartM;
	private double sugarM;
	private boolean eyeM;
	private boolean earM;
	private double tempA;
	private double bloodA;
	private double heartA;
	private double sugarA;
	private boolean eyeA;
	private boolean earA;
	private double tempN;
	private double bloodN;
	private double heartN;
	private double sugarN;
	private boolean eyeN;
	private boolean earN;
	
	Date dNow = new Date();
    SimpleDateFormat ft = new SimpleDateFormat ("MMMM yyyy");
    
	static SQLObject so = new SQLObject();
    ResultSet rsTmp = so.getResultSet("SELECT * FROM et_reportTemp ORDER BY name, date, checktime");
	
    {
		try{
			while (rsTmp.next()){
				name=rsTmp.getString("name");
				date=rsTmp.getString("date");
				checktime=rsTmp.getString("checktime");
				temp=rsTmp.getDouble("temp");
				blood=rsTmp.getDouble("blood");
				heart=rsTmp.getDouble("heart");
				sugar=rsTmp.getDouble("sugar");
				eye=rsTmp.getBoolean("eye");
				ear=rsTmp.getBoolean("ear");
				
				if (eye==true)
					eyeString = "Yes";
				else
					eyeString="No";
				
				if (ear==true)
					earString = "Yes";
				else
					earString="No";
				
				if (checktime=="Morning"){
					tempM=rsTmp.getDouble("temp");
					bloodM=rsTmp.getDouble("blood");
					heartM=rsTmp.getDouble("heart");
					sugarM=rsTmp.getDouble("sugar");
					eyeM=rsTmp.getBoolean("eye");
					earM=rsTmp.getBoolean("ear");
				}
				else if (checktime=="Afternoon"){
					tempA=rsTmp.getDouble("temp");
					bloodA=rsTmp.getDouble("blood");
					heartA=rsTmp.getDouble("heart");
					sugarA=rsTmp.getDouble("sugar");
					eyeA=rsTmp.getBoolean("eye");
					earA=rsTmp.getBoolean("ear");
				}
				else {
					tempN=rsTmp.getDouble("temp");
					bloodN=rsTmp.getDouble("blood");
					heartN=rsTmp.getDouble("heart");
					sugarN=rsTmp.getDouble("sugar");
					eyeN=rsTmp.getBoolean("eye");
					earN=rsTmp.getBoolean("ear");
				}
				
				
			Document document = new Document();
	
			PdfWriter.getInstance(document,
					new FileOutputStream(ft.format(dNow)+" Report.pdf"));

			document.open();
  
			Paragraph title1 = new Paragraph("Report for "+name +" for " +ft.format(dNow), 
					FontFactory.getFont(FontFactory.HELVETICA, 
							24, Font.BOLD, new CMYKColor(255, 230, 0,0)));
  		   
			Chapter chapter1 = new Chapter(title1, 1);
			chapter1.setNumberDepth(0);
  
			document.add(chapter1);

			Paragraph title11 = new Paragraph("Medical History", 
					FontFactory.getFont(FontFactory.HELVETICA, 20, Font.BOLD));
			Section section1 = chapter1.addSection(title11);
         
			Paragraph someSectionText = new Paragraph("Weekly Checkup: ", 
					FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD));
			section1.add(someSectionText);
			
			someSectionText = new Paragraph(date, 
					FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD));
			section1.add(someSectionText);
  
			PdfPTable t1 = new PdfPTable(5);
			t1.setWidthPercentage(100);
			t1.setSpacingBefore(25); //above table
			t1.setSpacingAfter(25); //below table

			PdfPCell c11 = new PdfPCell(new Phrase("Time of Day",
					FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD)));
			PdfPCell c12 = new PdfPCell(new Phrase("Temperature (deg Celcius)",
					FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD)));  
			PdfPCell c13 = new PdfPCell(new Phrase("Blood Pressure",
					FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD)));
			PdfPCell c14 = new PdfPCell(new Phrase("Heart Rate",
					FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD)));
			PdfPCell c15 = new PdfPCell(new Phrase("Sugar Level",
					FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD)));
			PdfPCell c16 = new PdfPCell(new Phrase("Eye Infection",
					FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD)));
			PdfPCell c17 = new PdfPCell(new Phrase("Ear Infection",
					FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD)));
			PdfPCell c18 = new PdfPCell(new Phrase("Comments",
					FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD)));
  			
			//Time of day
			t1.addCell(c11);
			t1.addCell("Morning");
			t1.addCell("Afternoon");
			t1.addCell("Night");	    
			t1.addCell("Average");
  	
			//Temp
			t1.addCell(c12);
			t1.addCell(""+tempM);
			t1.addCell(""+tempA);
			t1.addCell(""+tempN);
			t1.addCell(""+calAvr(tempM, tempA, tempN));
  	
			//BP
			t1.addCell(c13);
			t1.addCell(""+bloodM);
			t1.addCell(""+bloodA);
			t1.addCell(""+bloodN);
			t1.addCell(""+calAvr(bloodM, bloodA, bloodN));
  	
			//Heart rate
			t1.addCell(c14);
			t1.addCell(""+heartM);
			t1.addCell(""+heartA);
			t1.addCell(""+heartN);
			t1.addCell(""+calAvr(heartM, heartA, heartN));
			
			//Sugar level
			t1.addCell(c15);
			t1.addCell(""+sugarM);
			t1.addCell(""+sugarA);
			t1.addCell(""+sugarN);
			t1.addCell(""+calAvr(sugarM, sugarA, sugarN));
  	
			//Eye
			t1.addCell(c16);
			t1.addCell("");
			t1.addCell("");
			t1.addCell("");
			t1.addCell("-");
			
			//ear
			t1.addCell(c17);
			t1.addCell("");
			t1.addCell("");
			t1.addCell("");
			t1.addCell("-");
  	
			//comments
			t1.addCell(c18);
			t1.addCell("");
			t1.addCell("");
			t1.addCell("");
			t1.addCell("-");
  
			section1.add(t1);
	
//////////////////////
	
			someSectionText = new Paragraph("Average per Month: ", 
					FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD));
			section1.add(someSectionText);
	
			PdfPTable t2 = new PdfPTable(2);
			t2.setWidthPercentage(100);
			t2.setSpacingBefore(25); //above table
			t2.setSpacingAfter(25); //below table
	
			t2.addCell(c12);
			t2.addCell(" ");
			
			t2.addCell(c13);
			t2.addCell(" ");

			t2.addCell(c14);
			t2.addCell(" ");

			t2.addCell(c15);
			t2.addCell(" ");
	
			section1.add(t2);
	
////////////////////
  
			someSectionText = new Paragraph("Additional Comments: ", 
					FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD));

			section1.add(someSectionText);
			
			someSectionText = new Paragraph("" +addComment, 
					FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD));
	
			document.add(section1);
  
			document.close();
			}
			}catch (DocumentException e) {
				e.printStackTrace();
				} 
		catch (FileNotFoundException e2) {
			e2.printStackTrace();
			} catch (SQLException e) {
			e.printStackTrace();
		}
		
		}
	private double calAvr(double val1, double val2, double val3) {
		return (val1+val2+val3)/3;
	}
}