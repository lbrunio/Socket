package ut3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	final static int PORT = 7707;

	public static void main(String[] args) {
		ServerSocket server = null;

		Socket socket = null;

		DataInputStream in;
		DataOutputStream out;

		try {
			server = new ServerSocket(PORT);
			System.out.println("Server waiting...");

			while (true) {
				socket = server.accept();
				System.out.println("Host connected from: " + socket.getInetAddress());

				in = new DataInputStream(socket.getInputStream());
				out = new DataOutputStream(socket.getOutputStream());

				// Leer la cantidad de lineas
				int numLines = in.readInt();

				// Procesar cada linea
				for (int i = 0; i < numLines; i++) {
					String line = in.readUTF();
					int sum = sumCharacters(line);
					out.writeInt(sum);
				}

				System.out.println("Host disconnected");

				socket.close();

				in.close();
				out.close();

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static int sumCharacters(String line) {
		int sum = 0;
		for (char c : line.toCharArray()) {
			sum += (int) c;
		}
		return sum;
	}
}
