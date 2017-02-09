package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by 46406163y on 08/02/17.
 */
public class HiloPeticion extends Thread {

    private Socket newsocket;

    public HiloPeticion(Socket e){
        this.newsocket = e;
    }

    @Override
    public void run() {

        InputStream is = null;
        InputStream is2 = null;

        try {
            is = newsocket.getInputStream();
            is2 = newsocket.getInputStream();
            OutputStream os = newsocket.getOutputStream();


            byte[] n1 = new byte[10];
            is.read(n1);
            String mes = new String (n1);
            String otro = mes.trim();
            int n2 = Integer.valueOf(otro);

            int result = n2;


            System.out.println("El resultado es: " + result);
            System.out.println("cerrando el socket");
            newsocket.close();
            System.out.println("cerrando el socket servidor");
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

}
