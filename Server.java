import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private final ServerSocket serverSocket;

    private final ExecutorService pool = Executors.newFixedThreadPool(10);

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public  void startServer() {
        try {

            while (!serverSocket.isClosed()) {

                Socket socket = serverSocket.accept();
                System.out.println("A new client has connected successfully!");
                ClientHandler clientHandler = new ClientHandler(socket);
                pool.execute(clientHandler);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void closeServerSocket(){
            try{
                if(serverSocket != null){
                    serverSocket.close();
                }
                if(pool != null){
                    pool.shutdown();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }



    public static void main(String[] args) throws IOException {

            ServerSocket serverSocket = new ServerSocket(1234);
            Server server = new Server(serverSocket);
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                System.out.println("Shutting down server...");
                server.closeServerSocket();
            }));
            server.startServer();
        }


}
