package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by 46406163y on 01/02/17.
 */
public class SocketClient {

    public static void main(String[] args) {
        try{

            Scanner sc = new Scanner (System.in);

            String n1;
            String n3;
            System.out.println("Inserte el primer numero de la operación");
            n1 = sc.nextLine();
            System.out.println("Inserte el segundo numero de la operación");
            n3 = sc.nextLine();
            System.out.println("Creamos un cliente (creando socket)");

            //Socket de TCP
            Socket cliente = new Socket();

            System.out.println("Estableciendo conexion");

            InetSocketAddress addr = new InetSocketAddress("localhost", 5555);

            cliente.connect(addr);

            InputStream is = cliente.getInputStream();
            OutputStream os = cliente.getOutputStream();
            OutputStream os1 = cliente.getOutputStream();


            System.out.println("enviando mensaje");

            os.write(n1.getBytes());
            os1.write(n3.getBytes());
            System.out.println("Mensaje enviado");



            System.out.println("Cerrando el socket del cliente");

            cliente.close();

            System.out.println("Terminado");



        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
