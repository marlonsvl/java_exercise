/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.script.java_exercise;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author marlonvinan
 */
public class ExtractData {

    public static void main(String[] args) {
        getElements();
    }

    public static void getElements() {
        List<Model> list = new ArrayList<>();

        try {
            String html = "http://www.port-monitor.com/plans-and-pricing";
            Document doc = Jsoup.connect(html).get();
            Elements products = doc.select("div.span2");
            
            for (int i = 0; i < products.size(); i++) {
                Model m = new Model();
                Element ele = products.get(i);
                Element p = ele.getAllElements().first();
                Element h2 = p.getElementsByTag("h2").first();
                m.setMonitors(Integer.parseInt(h2.text()));
                Element dl = p.getElementsByTag("dl").first();
                Elements dds = dl.getElementsByTag("dd");
                m.setCheckRate(getNumber(dds.get(0).text()));
                m.setHistory(getNumber(dds.get(1).text()));
                if(dds.get(2).text().equals("Yes") || dds.get(2).text().equals("yes"))
                    m.setMultipleNotifications(true);
                else
                    m.setMultipleNotifications(false);
                if(dds.get(3).text().equals("Yes") || dds.get(3).text().equals("yes"))
                    m.setPushNotifications(true);
                else
                    m.setPushNotifications(false);
                String sd = p.getElementsByTag("p").first().text();
                String numberOnly = sd.replaceAll("[^0-9\\.]+", "");
                double d = Double.parseDouble(numberOnly); 
                m.setPrice(d);
                list.add(m);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);
    }

    public static Integer getNumber(String s) {
        Pattern p = Pattern.compile("-?\\d+");
        Matcher m = p.matcher(s);
        String res = "";
        while (m.find()) {
            res = m.group();
        }
        return Integer.parseInt(res);
    }

}
