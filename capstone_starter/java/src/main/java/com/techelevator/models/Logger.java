package com.techelevator.models;
import java.io.*;

public class Logger implements Closeable{


    private File logFile;
    private PrintWriter writer;

    public  Logger(String pathName) {
        this.logFile = new File ("Log.txt");

    if(!logFile.exists()) {
        try {
            this.writer = new PrintWriter(this.logFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }else{
        try {
            this.writer = new PrintWriter(new FileWriter(this.logFile, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

public void write(String logMessage){
        this.writer.println(logMessage);
        this.writer.flush();
}
@Override
    public void close() {
        this.writer.close();
}
}
