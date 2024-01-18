package ut3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


import io.IO;

public class Cliente {
	final static String HOST = "192.168.1.192";

	final static int PORT = 7707;

	public static void main(String[] args) {
		DataInputStream in;
		DataOutputStream out;


		try {
			
			Socket socket = new Socket(HOST, PORT);
			
			in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

			// Preguntar cuantas lineas
			System.out.print("Enter line amount: ");
			int numLines = IO.readInt();
			out.writeInt(numLines);

			// Enviamos
			for (int i = 0; i < numLines; i++) {
				System.out.print("Enter the word for the line: " + (i + 1) + ": ");
				String line = IO.readString();
				out.writeUTF(line);
			}

			// Recibir y mostrar los resultados
			for (int i = 0; i < numLines; i++) {
				int result = in.readInt();
				System.out.println("Sum of characters for the line: " + (i + 1) + ": " + result);
			}
			
			socket.close();
			in.close();
			out.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}