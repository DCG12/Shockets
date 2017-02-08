package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by 46406163y on 01/02/17.
 */
public class SocketServidor {

    public static void main(String[] args) {

        try{
            System.out.println("creando servidor");

            ServerSocket serverSocket = new ServerSocket();

            System.out.println("realizando el bind ( vinculo)");

            InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
            serverSocket.bind(addr);

            System.out.println("aceptando conexiones");

            while(true) {

                Socket newsocket = serverSocket.accept();

                HiloPeticion hp = new HiloPeticion(newsocket);
                hp.start();
                System.out.println("Conexion recibida");
            }
            //serverSocket.close();

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

}
