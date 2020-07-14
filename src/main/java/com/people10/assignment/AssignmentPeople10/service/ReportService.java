package com.people10.assignment.AssignmentPeople10.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.people10.assignment.AssignmentPeople10.DAO.CustomerRepo;
import com.people10.assignment.AssignmentPeople10.model.Customer;

import antlr.collections.List;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ReportService {

	@Autowired
	CustomerRepo cusrepo;

	public String getAllData() throws FileNotFoundException, JRException {

		java.util.List<Customer> custlist = cusrepo.findAll();

		File file = ResourceUtils.getFile("classpath:CustomerReport.jrxml");

		// String path="src//main//resources//jasper//CustomerReport.jasper";
		// InputStream
		// cusstream=JasperUtility.class.getClassLoader().getResourceAsStream(file.getAbsolutePath());

		JasperReport jasperreport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource datasourc = new JRBeanCollectionDataSource(custlist);
		Map<String, Object> parameter = new HashedMap();
		parameter.put("createdBy", "Mutturaj");

		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperreport, parameter, datasourc);
		JasperExportManager.exportReportToPdfFile(jasperPrint,
				"H:\\Mutturaj_stuff\\AssignmentPeople10\\" + "\\customer.pdf");

		return "generated";
	}

}
