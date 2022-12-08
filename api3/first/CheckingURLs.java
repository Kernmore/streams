package com.streams.api3.first;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CheckingURLs {

    public static List<String> readFromFile(File file) throws IOException {
        List<String> websites = new ArrayList<>();
        try(BufferedReader bf = new BufferedReader(new FileReader(file))){
            for(; ; ) {
                String temp = bf.readLine();
                if(temp == null){
                    break;
                }
                websites.add(temp);
            }
        }
        return websites;
    }

    public static void main(String[] args) {
        List<String> websites = new ArrayList<>();
        try {
            websites = readFromFile(new File("urls.txt"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        websites.stream()
//                .map(CheckingURLs::getResponse)
                .filter(CheckingURLs::getResponse)
                .forEach(System.out::println);


    }

    public static boolean getResponse(String string) {
        URL url;
        try {
            url = new URL(string);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            if( connection.getResponseCode() == 200){
                return true;
            }
        } catch (IOException e) {

        }
        return false;
    }
}
