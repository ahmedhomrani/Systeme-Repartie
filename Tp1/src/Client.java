import java.io.*;
import java.net.*;
import java.util.Scanner;
public class Client {
 public static void main(String[] args) {
 final int port = 2020;
//le port doit être le même que celui proposé par le serveur
 try{
 Socket socket = new Socket(InetAddress.getLocalHost(),port);
 /*demande de connexion au serveur qui se trouve dans ce cas 
sur la même machine (LocalHost)*/
 
//envoi message
 OutputStream out = socket.getOutputStream();
 PrintWriter ostream = new PrintWriter(out);
 while(true)
 {
 
System.out.println("C Taper votre message : ");
 Scanner sc = new Scanner(System.in);
 String str = sc.nextLine();
 System.out.println("C vous avez ecrit : "+str);
 ostream.println(str);
 ostream.flush();
if(str.equals ("fin"))
{socket.close(); 
System.out.println("Fin connexion!");
break;}

//reception message
BufferedReader in = new BufferedReader(new
InputStreamReader(socket.getInputStream()));
System.out.println("C Le serveur a dit : " +in.readLine());
}
}catch(IOException e){

}
}

}