package com.ge.predix.solsvc.service;

public class PredixServiceImplProxy implements PredixServiceGenerator{
    PredixServiceGenerator predixService;
    private Role accessRole;
    public PredixServiceImplProxy(Role accessRole){
            this.accessRole=accessRole;
    }

    @Override
    public String displayServiceTemplate(String serviceFormat, int serviceData) {
        return "PredixServiceImplProxy: Displaying blank service template style of " + serviceFormat + " with " + serviceData + " data entries - USING PROXY";
    }

    @Override
    public String generateUnrestrictedService(String serviceFormat,int serviceData){
        if(predixService==null)
            predixService = new PredixServiceImpl();
            return predixService.generateUnrestrictedService(serviceFormat,serviceData);
    }
    @Override
    public String generateRestrictedService(){
        if(accessRole.getRole().equals("Manager")){
            if(predixService==null)
                predixService = new PredixServiceImpl();
                return predixService.generateRestrictedService();
        }
        else{
        	return "You are not authorized to access restricted service. - USING PROXY";
        }

    }

}
