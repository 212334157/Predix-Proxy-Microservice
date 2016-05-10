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
	private PredixServiceGenerator proxy;

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
		proxy = new PredixServiceImplProxy(accessRole);
		return newRole;
	}

	@RequestMapping("/unrestricted-service/{service}/{data}")
	String generateCompReport(@PathVariable("service")String serviceReport,@PathVariable("data")int dataEntries){
		return proxy.generateUnrestrictedService(serviceReport, dataEntries) + "<br/><a href='/'>BACK</a> ";
	}

	@RequestMapping("/restricted-service")
	String generateSensReport(){
		return proxy.generateRestrictedService() + "<br/><a href='/'>BACK</a> ";
	}

	@RequestMapping("/template/{service}/{data}")
	String getReportTemplate(@PathVariable("service")String serviceReport,@PathVariable("data")int dataEntries){
		return proxy.displayServiceTemplate(serviceReport, dataEntries) + "<br/><a href='/'>BACK</a> ";
	}

}
