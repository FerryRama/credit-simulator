package com.simulator;

import com.simulator.controller.Controller;
import com.simulator.view.LoanView;

public class Main {
    public static void main(String[] args) {
        LoanView view = new LoanView();
        Controller controller = new Controller(view);
        if (args.length > 0) {
            // If a filename is provided
            String filename = args[0];
            controller.processFileInput(filename);
        } else {
            controller.processLoan();
        }
    }
}