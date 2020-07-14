package com.people10.assignment.AssignmentPeople10.service;

import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.stereotype.Component;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.OutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;

@Component
public class JasperUtility {
	
	public void generateReport() throws JRException {
		String path="src//main//resources//jasper//CustomerReport.jasper";
		InputStream cusstream=JasperUtility.class.getClassLoader().getResourceAsStream(path);
	JasperReport jasperreport=	JasperCompileManager.compileReport(cusstream);
	  JasperPrint jasperprint=  JasperFillManager.fillReport(jasperreport, null);
	
	JRPdfExporter pdf=new JRPdfExporter();
	pdf.setExporterInput(new SimpleExporterInput(jasperprint));
	
	pdf.setExporterOutput(new SimpleOutputStreamExporterOutput("Employee.pdf")) ;
	
	SimplePdfReportConfiguration reportConfig
	  = new SimplePdfReportConfiguration();
	reportConfig.setSizePageToContent(true);
	reportConfig.setForceLineBreakPolicy(false);
	 
	SimplePdfExporterConfiguration exportConfig
	  = new SimplePdfExporterConfiguration();
	exportConfig.setMetadataAuthor("muttu");
	exportConfig.setEncrypted(true);
	exportConfig.setAllowedPermissionsHint("PRINTING");
	pdf.setConfiguration(reportConfig);
	pdf.setConfiguration(exportConfig);
	
	pdf.exportReport();
		
		
	
	
	
	
		
	}
	

}
