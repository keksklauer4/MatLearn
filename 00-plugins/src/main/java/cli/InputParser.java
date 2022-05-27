package main.java.cli;

import java.util.Optional;
import java.util.Scanner;

public class InputParser {
    private final Scanner scanner;

    public InputParser() {
        this.scanner = new Scanner(System.in);
    }

    public Optional<Integer> parseInt(){
        resetScanner();
        try{
            return Optional.of(Integer.parseInt(scanner.nextLine().strip()));
        } catch (Exception e){
            return Optional.empty();
        }
    }

    public String parseText(){
        resetScanner();
        try{
            return scanner.nextLine().strip();
        } catch(Exception e){
            return "";
        }
    }

    private void resetScanner(){
        scanner.reset();
    }
}
