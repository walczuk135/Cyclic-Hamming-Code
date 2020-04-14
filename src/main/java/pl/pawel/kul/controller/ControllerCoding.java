package pl.pawel.kul.controller;

import pl.pawel.kul.model.FunctionOne;
import pl.pawel.kul.model.GeneratingFunction;
import pl.pawel.kul.service.CodingMessage;

public class ControllerCoding {

    private GeneratingFunction generatingFunction;

    private CodingMessage codingMessage;
    private final String data;

    public ControllerCoding(String data) {
        this.generatingFunction=new FunctionOne();
        this.codingMessage = new CodingMessage(generatingFunction, data);
        this.data = data;
    }

    public String coding() {
        String coding = codingMessage.coding();
        return  codingMessage.getData() + " * " + codingMessage.getMultiplyMessage() + "\n"
                + "xr=" + codingMessage.getData() + " * " + codingMessage.getMultiplyMessage() + " / " + generatingFunction.getGeneratingFunction() + "\n"
                + "Message xn = message || xr = " + codingMessage.getData() + " || " + codingMessage.getRemainder() + "\n"
                + "Coding message = " + coding;
    }

    public void setGeneratingFunction(GeneratingFunction generatingFunction,String message) {
        this.generatingFunction=generatingFunction;
        this.codingMessage = new CodingMessage(generatingFunction,message);
    }

}
