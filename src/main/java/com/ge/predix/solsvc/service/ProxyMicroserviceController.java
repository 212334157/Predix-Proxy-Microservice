package com.ge.predix.solsvc.service;





import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProxyMicroserviceController {
	private Role accessRole;
	private ReportGenerator proxy;

	@RequestMapping("/")
	String homePage(){
		StringBuilder contentBuilder = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(new FileReader("index.html"));
			String str;
			while((str = in.readLine()) != null){
				contentBuilder.append(str);
			}
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return "NOPE";
		}
		return contentBuilder.toString();
	}
	
	@RequestMapping("/role/{role}")
	String setRole(@PathVariable("role")String newRole){
		accessRole = new Role(newRole);
		proxy = new ReportGeneratorImplProxy(accessRole);
		return newRole;
	}
	
	@RequestMapping("/complex-report/{format}/{entries}")
	String generateCompReport(@PathVariable("format")String reportFormat,@PathVariable("entries")int reportEntries){
		return proxy.generateComplexReport(reportFormat, reportEntries) + "<br/><a href='/'>BACK</a> ";
	}

	@RequestMapping("/sensitive-report")
	String generateSensReport(){
		return proxy.generateSensitiveReport() + "<br/><a href='/'>BACK</a> ";
	}

	@RequestMapping("/template/{format}/{entries}")
	String getReportTemplate(@PathVariable("format")String reportFormat,@PathVariable("entries")int reportEntries){
		return proxy.displayReportTemplate(reportFormat, reportEntries) + "<br/><a href='/'>BACK</a> ";
	}
	
}
