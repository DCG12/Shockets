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
        try {
            is = newsocket.getInputStream();
            OutputStream os = newsocket.getOutputStream();
            byte[] mensaje = new byte[35];
            is.read(mensaje);
            System.out.println("Mensaje recibido " +new String(mensaje));
            System.out.println("cerrando el socket");
            newsocket.close();
            System.out.println("cerrando el socket servidor");
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

}
