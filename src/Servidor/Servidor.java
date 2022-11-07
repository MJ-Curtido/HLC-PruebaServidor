package Servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws IOException {
		int puerto = 6007;
		
		ServerSocket servidor = new ServerSocket(puerto);
		
		System.out.println("Escuchando en " + servidor.getLocalPort());
		
		Socket cliente = servidor.accept();
		
		DataInputStream msgCliente = new DataInputStream(cliente.getInputStream());
		System.out.println(msgCliente.readUTF());
		
		DataOutputStream msgServidor = new DataOutputStream(cliente.getOutputStream());
		msgServidor.writeUTF("Saludos al cliente del servidor");
		
		servidor.close();
	}
}