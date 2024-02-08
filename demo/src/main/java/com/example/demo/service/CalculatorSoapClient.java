package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

@Service
public class CalculatorSoapClient {

    @Autowired
    private WebServiceTemplate webServiceTemplate;

    public int add(int intA, int intB) {
        Add request = new Add();
        request.setIntA(intA);
        request.setIntB(intB);

        AddResponse response = (AddResponse) webServiceTemplate.marshalSendAndReceive(request);
        return response.getAddResult();
    }

    public int subtract(int a, int b) {
        Subtract subtractRequest = new Subtract();
        subtractRequest.setIntA(a);
        subtractRequest.setIntB(b);

        SubtractResponse response = (SubtractResponse) webServiceTemplate.marshalSendAndReceive(subtractRequest);
        return response.getSubtractResult();
    }

    public int multiply(int a, int b) {
        Multiply multiplyRequest = new Multiply();
        multiplyRequest.setIntA(a);
        multiplyRequest.setIntB(b);

        MultiplyResponse response = (MultiplyResponse) webServiceTemplate.marshalSendAndReceive(multiplyRequest);
        return response.getMultiplyResult();
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        Divide divideRequest = new Divide();
        divideRequest.setIntA(a);
        divideRequest.setIntB(b);

        DivideResponse response = (DivideResponse) webServiceTemplate.marshalSendAndReceive(divideRequest);
        return response.getDivideResult();
    }
}
