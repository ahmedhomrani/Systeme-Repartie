import java.io.*;
import java.net.*;
import java.util.Scanner;
public class Serveur {
 public static void main(String[] args) {
 final int port = 2020;
 try{
 ServerSocket serveur = new ServerSocket(port);//enregistrement de service 
 System.out.println("Started");
 while(true)
//boucle pour traiter plusieurs clients séquentiellement
 {
 Socket socket = serveur.accept();
/* accept: attente jusqu'à la réception d'une demande de connexion de 
client.
Si un client envoie une demande, la méthode accept renvoie un socket 
servant à l'échange de données entre le serveur et ce client.
*/
 System.out.println(socket.getPort()+"connecté");
//affichage du port du client connecté
 
//réception message
 InputStream in = socket.getInputStream();
// Récupération du flux de lecture (flux entrant) manipulant des octets
 InputStreamReader reader = new InputStreamReader(in);
// Conversion en flux manipulant des caractères
 BufferedReader istream = new BufferedReader(reader);
//conversion en flux manipulant des chaines de caractères
 while(true){
//boucle pour échanger plusieurs messages avec le même client
 String line = istream.readLine();
//Récupération de la chaine envoyée par le client
 System.out.println("S Client a dit :"+line);//affichage
if(line.equals ("fin")){
//condition d'arrêt si la chaine envoyée par le client est "fin"
	socket.close();//on ferme le socket coté Serveur
	System.out.println("Fin connexion!"); //affichage
	break;
	/*Exit de la deuxième boucle d'échange de messages pour passer au client 
	suivant*/
	}
	 //envoi message
	System.out.println("S Taper votre message : ");
	 Scanner sc = new Scanner(System.in);
	//Préparer l'outil de lecture au clavier
	 String str = sc.nextLine();
	//Récupération de la chaine lue au clavier
	 OutputStream out = socket.getOutputStream();
	//Récupération de flux d'écriture (flux sortant) manipulant des octets
	 PrintWriter ostream = new PrintWriter(out);
	//Conversion en flux manipulant des chaines de caractères
	 ostream.println(str);
	//écriture de la chaine saisie au clavier sur le flux sortant
	 ostream.flush();}
	//envoi effectif de données sur le flux sortant
	 }
	 }catch(IOException e){
	 
	 }
	 }
	}
