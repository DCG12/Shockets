package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by 46406163y on 01/02/17.
 */
public class SocketClient {

    public static void main(String[] args) {
        try{

            System.out.println("Creamos un cliente (creando socket)");

            //Socket de TCP
            Socket cliente = new Socket();

            System.out.println("Estableciendo conexion");

            InetSocketAddress addr = new InetSocketAddress("localhost", 5555);

            cliente.connect(addr);

            InputStream is = cliente.getInputStream();
            OutputStream os = cliente.getOutputStream();

            System.out.println("enviando mensaje");


            String  mensaje = "mi primer mensaje que navega";

            os.write(mensaje.getBytes());

            System.out.println("Mensaje enviado");



            System.out.println("Cerrando el socket del cliente");

            cliente.close();

            System.out.println("Terminado");



        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
