//EchoThread.java
import java.io.*; 
import java.net.*; 
import java.util.*;
public class EchoThread extends Thread {
    private Socket connectionSocket;
    public EchoThread(Socket connectionSocket) {
        this.connectionSocket = connectionSocket;
    }
    public void run() {
         Scanner inFromClient = null;
         DataOutputStream outToClient = null;
         try {
            inFromClient = new Scanner(connectionSocket.getInputStream());
			   outToClient = 
             	new DataOutputStream(connectionSocket.getOutputStream());
            
			   String sentence1 = inFromClient.nextLine();
            int num1 = Integer.parseInt(sentence1);

            String sentence2 = inFromClient.nextLine();
            int num2 = Integer.parseInt(sentence2);

      	   String result = "The result is " + (num1 + num2); 
      	   outToClient.writeBytes(result);         
            
		   }
        catch (IOException e) {
            System.err.println("Closing Socket connection");
        }
        catch (NumberFormatException e) {
         // กรณีป้อนข้อมูลไม่ถูกต้อง
         System.out.println("Exception : Type error");
      }
        finally {
            try {
               if (inFromClient != null)
                  inFromClient.close();
               if (outToClient != null)
                  outToClient.close();
               if (connectionSocket != null)
                  connectionSocket.close();
                  System.out.println("Connection closed... ");
               }
              
            catch (IOException e) {
               e.printStackTrace();
            }
        }
    }
}
