import java.io.*; 
import java.net.*;
import java.util.*; 

class UDPClient { 
   public static void main(String args[]) throws Exception { 
      DatagramSocket clientSocket = new DatagramSocket(); 
      InetAddress IPAddress = InetAddress.getByName("localhost"); 
      byte[] sendData = new byte[1024]; 
      byte[] receiveData = new byte[1024];
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876); 
      clientSocket.send(sendPacket);
      DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length); 
      clientSocket.receive(receivePacket); 
      String date = new String(receivePacket.getData()); 
      System.out.println("FROM SERVER:" + date.trim()); 
	   clientSocket.close(); 
   } 
} 
