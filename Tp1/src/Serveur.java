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
//boucle pour traiter plusieurs clients s�quentiellement
 {
 Socket socket = serveur.accept();
/* accept: attente jusqu'� la r�ception d'une demande de connexion de 
client.
Si un client envoie une demande, la m�thode accept renvoie un socket 
servant � l'�change de donn�es entre le serveur et ce client.
*/
 System.out.println(socket.getPort()+"connect�");
//affichage du port du client connect�
 
//r�ception message
 InputStream in = socket.getInputStream();
// R�cup�ration du flux de lecture (flux entrant) manipulant des octets
 InputStreamReader reader = new InputStreamReader(in);
// Conversion en flux manipulant des caract�res
 BufferedReader istream = new BufferedReader(reader);
//conversion en flux manipulant des chaines de caract�res
 while(true){
//boucle pour �changer plusieurs messages avec le m�me client
 String line = istream.readLine();
//R�cup�ration de la chaine envoy�e par le client
 System.out.println("S Client a dit :"+line);//affichage
if(line.equals ("fin")){
//condition d'arr�t si la chaine envoy�e par le client est "fin"
	socket.close();//on ferme le socket cot� Serveur
	System.out.println("Fin connexion!"); //affichage
	break;
	/*Exit de la deuxi�me boucle d'�change de messages pour passer au client 
	suivant*/
	}
	 //envoi message
	System.out.println("S Taper votre message : ");
	 Scanner sc = new Scanner(System.in);
	//Pr�parer l'outil de lecture au clavier
	 String str = sc.nextLine();
	//R�cup�ration de la chaine lue au clavier
	 OutputStream out = socket.getOutputStream();
	//R�cup�ration de flux d'�criture (flux sortant) manipulant des octets
	 PrintWriter ostream = new PrintWriter(out);
	//Conversion en flux manipulant des chaines de caract�res
	 ostream.println(str);
	//�criture de la chaine saisie au clavier sur le flux sortant
	 ostream.flush();}
	//envoi effectif de donn�es sur le flux sortant
	 }
	 }catch(IOException e){
	 
	 }
	 }
	}
