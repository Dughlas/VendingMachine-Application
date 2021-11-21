package com.techelevator.models;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SalesReport implements Closeable{


    private File logFile;
    private PrintWriter writer2;

    public  SalesReport(String pathName) {
        this.logFile = new File ("Sales.txt");

        if(!logFile.exists()) {
            try {
                this.writer2 = new PrintWriter(this.logFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }else{
            try {
                this.writer2 = new PrintWriter(new FileWriter(this.logFile, true));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void write2(String logMessage){
        this.writer2.println(logMessage);
        this.writer2.flush();
    }
    @Override
    public void close() {
        this.writer2.close();
    }
}
