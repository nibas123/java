import java.io.*;
import java.net.*;
public class TCPServer
{
public static void main(String argv[])throws Exception
{
ServerSocket serversocket=new ServerSocket(6789);
System.out.println("Server is listening on port 6789");
Socket serverEnd=serversocket.accept();
System.out.println("Request accepted");
BufferedReader fromclient=new BufferedReader (new InputStreamReader(serverEnd.getInputStream()));
PrintWriter toClient=new PrintWriter(serverEnd.getOutputStream(),true);
int n=Integer.parseInt(fromclient.readLine());
System.out.println("First Number: "+n);

BufferedReader fromclient2=new BufferedReader (new InputStreamReader(serverEnd.getInputStream()));
int n2=Integer.parseInt(fromclient2.readLine());
System.out.println("Second Number: "+n2);
int sum=n+n2;
toClient.println(sum);
System.out.println("Sent to client: "+sum);
}
}
