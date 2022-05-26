package main.java.cli;

import java.util.Scanner;

public class InputParser {
    private final Scanner scanner;

    public InputParser() {
        this.scanner = new Scanner(System.in);
    }

    public Integer parseInt(){
        try{
            return scanner.nextInt();
        } catch (Exception e){
            return null;
        }
    }

    public String parseText(){
        try{
            return scanner.nextLine().strip();
        } catch(Exception e){
            return "";
        }
    }
}
