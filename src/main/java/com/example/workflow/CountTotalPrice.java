package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class CountTotalPrice implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        double totalPrice =
                (double) delegateExecution.getVariable("productPrice") * (long) delegateExecution.getVariable("quantity");
        delegateExecution.setVariable("totalPrice", totalPrice);
        System.out.println("Total price: " + delegateExecution.getVariable("totalPrice"));
    }
}