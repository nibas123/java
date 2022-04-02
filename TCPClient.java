import java.io.*;
import java.net.*;
public class TCPClient
{
public static void main(String argv[])throws Exception
{
String fact;
Socket clientEnd=new Socket("localhost",6789);

System.out.println("Connected to localhost at port 6789");
PrintWriter toServer=new PrintWriter(clientEnd.getOutputStream(),true);

BufferedReader fromServer=new BufferedReader (new InputStreamReader(clientEnd.getInputStream()));

BufferedReader fromUser=new BufferedReader (new InputStreamReader(System.in));

System.out.println("Enter an integer");
String n=fromUser.readLine();
toServer.println(n);
System.out.println("Sent to Server: "+n);

System.out.println("Enter an integer");
String n2=fromUser.readLine();
toServer.println(n);
System.out.println("Sent to Server: "+n2);

fact=fromServer.readLine();
System.out.println("Received from  Server: "+fact);

clientEnd.close();
}
}
