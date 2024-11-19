import java.io.*;
import java.net.*;

public class TCPClient {

    public static void main(String[] args) {
        String host = "localhost";
        int port = 7002;

        try {
            // Establecer conexión TCP
            Socket socket = new Socket(host, port);

            // Crear streams de entrada y salida para enviar y recibir datos
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter out = new PrintWriter(outputStream, true);
            InputStream inputStream = socket.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));

            // Construir el mensaje XML
            String xmlMessage = "0032 1100 7000000000000000 4000001234567890";

            // Enviar el mensaje XML
            out.println(xmlMessage);

            // Esperar y leer la respuesta del servidor
            StringBuilder response = new StringBuilder();
            while (inputStream.available() == 0) {
                // Esperar hasta que haya datos disponibles para leer
            }
            while (inputStream.available() > 0) {
                response.append((char) inputStream.read());
            }
            System.out.println("Respuesta del servidor:\n" + response);

            // Cerrar streams y socket
            out.close();
            in.close();
            socket.close();

        } catch (UnknownHostException e) {
            System.err.println("Error: Host desconocido " + host);
        } catch (IOException e) {
            System.err.println("Error de E/S al conectar con el servidor " + host);
        }
    }
}