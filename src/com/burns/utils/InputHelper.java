package com.burns.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.server.ExportException;

public class InputHelper {

    public static String getInput(String propmpt) {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

        System.out.print(propmpt);
        System.out.flush();

        try {
            return stdin.readLine();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public static double getDoubleInput(String prompt) throws NumberFormatException {
        String input = getInput(prompt);
        return Double.parseDouble(input);
    }
}
