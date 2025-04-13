package com.bia.dio.conversor;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import io.github.cdimascio.dotenv.Dotenv;

public class  Conversor  {
    Dotenv dotenv = Dotenv.load();
    String yourKey = dotenv.get("KEY");
    static Scanner sc = new Scanner(System.in);
    private  String nameOfCoin;
    static private double value;
    double ars;
    double brl;
    double cop;



    public Conversor() throws IOException, MalformedURLException{
        String url_str = "https://v6.exchangerate-api.com/v6/"+yourKey+"/latest/USD";
        URL url = new URL(url_str);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        // Convert to JSON
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();

         this.ars = jsonobj.getAsJsonObject("conversion_rates").get("ARS").getAsDouble();
         this.cop = jsonobj.getAsJsonObject("conversion_rates").get("COP").getAsDouble();
         this.brl = jsonobj.getAsJsonObject("conversion_rates").get("BRL").getAsDouble();
    }
    public  void usdToArs(double value) { System.out.printf("o valor [USD]  %.2f equivale %.3f [ARS] ",value,value*ars);}
    public  void arsToUsd(double value) { System.out.printf("o valor [ARS]  %.2f equivale %.3f [USD] ",value,(1/ars)*value);}
    public  void usdToBrl(double value) { System.out.printf("o valor [USD]  %.2f equivale %.2f [BRL] ",value,value*brl);}
    public  void brlToUsd(double value) { System.out.printf("o valor [BRL]  %.2f equivale %.2f [USD] ",value,(1/brl)*value);}
    public  void usdToCop(double value) { System.out.printf("o valor [USD]  %.2f equivale %.3f [COP] ",value,value*cop);}
    public  void copToUsd(double value) { System.out.printf("o valor [COP]  %.2f equivale %.3f [USD] ",value,(1/cop)*value);}


}
//double arsToUsd = (1/ars)*value;
//double usdToBrl = value*brl;
//double brlToUsd = (1/brl)*value;
//double usdToCop = value*cop;
//double copToUsd = (1/cop)*value;