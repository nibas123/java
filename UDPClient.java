import java.net.*;
import java.io.*;
public class UDPClient
{
public static void main(String args[])throws Exception
{
byte[] rbuf=new byte[1024],sbuf=new byte[1024];
byte[] rbuf2=new byte[1024],sbuf2=new byte[1024];

BufferedReader fromUser=new BufferedReader(new InputStreamReader(System.in));

DatagramSocket socket=new DatagramSocket();
InetAddress addr=InetAddress.getByName(args[0]);

System.out.println("Enter an integer: ");
String data=fromUser.readLine();
System.out.println("Enter an Second integer: ");
String data2=fromUser.readLine();
sbuf=data.getBytes();
sbuf2=data2.getBytes();

DatagramPacket spkt=new DatagramPacket(sbuf,sbuf.length,addr,5050);
socket.send(spkt);

DatagramPacket spkt2=new DatagramPacket(sbuf,sbuf.length,addr,5050);
socket.send(spkt2);

System.out.println("Numbers Sent to Server are" +data);


DatagramPacket rpkt=new DatagramPacket(rbuf,rbuf.length);
socket.receive(rpkt);

data=new String(rpkt.getData(),0,rpkt.getLength());


System.out.println("Received from Server: "+data);
socket.close();

}
}