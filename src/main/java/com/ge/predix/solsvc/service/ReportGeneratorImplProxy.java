package com.ge.predix.solsvc.service;

public class ReportGeneratorImplProxy implements ReportGenerator{
    ReportGenerator reportGeneratorImpl;
    private Role accessRole;
    public ReportGeneratorImplProxy(Role accessRole){
            this.accessRole=accessRole;
    }
 
    @Override
    public String displayReportTemplate(String reportFormat, int reportEntries) {
        return "ReportGeneratorImplProxy: Displaying blank report template in " + reportFormat + " format with " + reportEntries + " entries - USING PROXY";
    }
 
    @Override
    public String generateComplexReport(String reportFormat,int reportEntries){
        if(reportGeneratorImpl==null)
            reportGeneratorImpl = new ReportGeneratorImpl();
            return reportGeneratorImpl.generateComplexReport(reportFormat,reportEntries);
    }
    @Override
    public String generateSensitiveReport(){
        if(accessRole.getRole().equals("Manager")){
            if(reportGeneratorImpl==null)
                reportGeneratorImpl = new ReportGeneratorImpl();
                return reportGeneratorImpl.generateSensitiveReport();
        }
        else{
        	return "You are not authorized to access sensitive reports. - USING PROXY";
        }
 
    }
 
}
