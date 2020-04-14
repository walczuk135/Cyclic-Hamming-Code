package pl.pawel.kul.controller;

import pl.pawel.kul.model.FunctionOne;
import pl.pawel.kul.model.GeneratingFunction;
import pl.pawel.kul.service.CodingService;

public class ControllerCoding {

    private GeneratingFunction generatingFunction;

    private CodingService codingService;
    private final String data;

    public ControllerCoding(String data) {
        this.generatingFunction=new FunctionOne();
        this.codingService = new CodingService(generatingFunction, data);
        this.data = data;
    }

    public String coding() {
        String coding = codingService.coding();
        return  codingService.getData() + " * " + codingService.getMultiplyMessage() + "\n"
                + "xr=" + codingService.getData() + " * " + codingService.getMultiplyMessage() + " / " + generatingFunction.getGeneratingFunction() + "\n"
                + "Message xn = message || xr = " + codingService.getData() + " || " + codingService.getRemainder() + "\n"
                + "Coding message = " + coding;
    }

    public void setGeneratingFunction(GeneratingFunction generatingFunction,String message) {
        this.generatingFunction=generatingFunction;
        this.codingService = new CodingService(generatingFunction,message);
    }

}
