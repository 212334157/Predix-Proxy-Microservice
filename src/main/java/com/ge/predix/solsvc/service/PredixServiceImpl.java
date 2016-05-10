package com.ge.predix.solsvc.service;

public class PredixServiceImpl implements PredixServiceGenerator {

    public PredixServiceImpl(){
        System.out.println("PredixServiceImpl instance created");
    }
    @Override
    public String displayServiceTemplate(String serviceFormat,int serviceData) {
    	return null;
    }
    @Override
    public String  generateUnrestrictedService(String serviceFormat, int serviceData){
    	return "PredixServiceImpl: Generating unrestricted service in "+serviceFormat+" format with "+ serviceData+" entries - NOT USING PROXY";

    }
    @Override
    public String  generateRestrictedService(){
       return "PredixServiceImpl: Generating restricted service - NOT USING PROXY";
    }

}
