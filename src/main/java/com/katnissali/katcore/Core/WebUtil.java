package com.katnissali.katcore.Core;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class WebUtil {

    public static File downloadFile(String fileName, String urlPath, String parentPath) {
        Util.debug("all useragents: " + getPossibleUserAgents());
        for(String userAgent : getPossibleUserAgents()) {
            try {
                return downloadFileWithUserAgent(fileName, urlPath, parentPath, getPossibleUserAgents().get(0));
            } catch (IOException e) {
                Util.printError("File fetch with user agent " + userAgent + " failed!");
                Util.printError("Error: ");
                e.printStackTrace();
            }
        }
        Util.printError("All user agents have failed!");
        return null;
    }
    public static File downloadJar(String jarName, String urlPath, String parentPath) {
        return downloadFile(jarName + ".jar", urlPath, parentPath);
    }
    public static File downloadFileWithUserAgent(String fileName, String urlPath, String parentPath, String userAgent) throws IOException{
        Util.log("Downloading " + fileName + ".");
        URL url = new URL(urlPath);

        Util.log("Opening HttpURLConnection.");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("User-Agent", userAgent);
        connection.setRequestMethod("GET");
        connection.setReadTimeout(5000);
        connection.setRequestProperty("set-cookie", "cf_clearance");
        Util.log("Connection opened.");

        Util.log("Opening input output streams.");
        BufferedInputStream in = new BufferedInputStream(connection.getInputStream());
        FileOutputStream stream = new FileOutputStream(parentPath + "/" + fileName);
        Util.log("Streams opened.");

        Util.log("Downloading data.");
        byte[] data = new byte[1024];
        int count;
        while ((count = in.read(data, 0, 1024)) != -1) {
            stream.write(data, 0, count);
        }
        Util.log("Data downloaded.");

        Util.log("Finishing.");
        in.close();
        stream.close();
        connection.disconnect();
        Util.log("Finished.");

        return new File(parentPath, fileName);
    }
    private static ArrayList<String> getPossibleUserAgents(){
        ArrayList<String> userAgents = new ArrayList<>();
        userAgents.add("JustixDevelopment/APIClient");
        userAgents.add("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.97 Safari/537.36");
        userAgents.add("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36");
        return userAgents;
    }

}
