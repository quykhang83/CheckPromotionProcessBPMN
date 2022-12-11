package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class PrintPromotion implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        double discount = (double) delegateExecution.getVariable("promotion");
        double totalBill = (double) delegateExecution.getVariable("totalPrice") * (1 - discount);
        System.out.println("Total bill: " + totalBill);
        System.out.println("Promotion of " + delegateExecution.getVariable("quantity")
                + " " + delegateExecution.getVariable("productName")
                + " is: " + discount * 100 + "%");
    }
}