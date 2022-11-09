package Servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;

public class Servidor {

	public static void main(String[] args) throws IOException {
		int puerto = 6070;
		
		ServerSocket servidor = new ServerSocket(puerto);
		
		for (int i = 1; ; i++) {
			System.out.println("Escuchando en " + servidor.getLocalPort());
			
			Socket cliente = servidor.accept();
			
			DataInputStream msgCliente = new DataInputStream(cliente.getInputStream());
			System.out.println("Cliente " + i + ": " + msgCliente.readUTF());
			
			DataOutputStream msgServidor = new DataOutputStream(cliente.getOutputStream());
			msgServidor.writeUTF("Saludos al cliente del servidor");
			
			msgCliente.close();
			msgServidor.close();
		}
	}
}