package com.ge.predix.solsvc.service;

public interface PredixServiceGenerator {
	String displayServiceTemplate(String reportFormat,int reportEntries);
    String generateUnrestrictedService(String reportFormat,int reportEntries);
    String generateRestrictedService();
}
