package com.ge.predix.solsvc.service;

public class ReportGeneratorImpl implements ReportGenerator {

    public ReportGeneratorImpl(){
        System.out.println("ReportGeneratorImpl instance created");
    }
    @Override
    public String displayReportTemplate(String reportFormat,int reportEntries) {
    	return null;
    }
    @Override
    public String  generateComplexReport(String reportFormat, int reportEntries){
    	return "ReportGeneratorImpl: Generating complex report in "+reportFormat+" format with "+ reportEntries+" entries - NOT USING PROXY";

    }
    @Override
    public String  generateSensitiveReport(){
       return "ReportGeneratorImpl: Generating sensitive report - NOT USING PROXY";
    }

}
