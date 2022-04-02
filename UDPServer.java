import java.net.*;
import java.io.*;
public class UDPServer
{
public static void main(String args[])throws Exception
{
byte[] rbuf=new byte[10],sbuf=new byte[10];

DatagramSocket socket=new DatagramSocket(5000);
System.out.println("Server ready");

DatagramPacket rpkt=new DatagramPacket(rbuf,rbuf.length);
socket.receive(rpkt);

DatagramPacket rpkt2=new DatagramPacket(rbuf,rbuf.length);
socket.receive(rpkt);

String data=new String(rpkt.getData(),0,rpkt.getLength());
InetAddress addr=rpkt.getAddress();
int port=rpkt.getPort();
int a=Integer.parseInt(data);
System.out.println("Received: " +a+"from"+addr+":"+port);

String data2=new String(rpkt.getData(),0,rpkt.getLength());
InetAddress addr2=rpkt.getAddress();
int port2=rpkt.getPort();
int b=Integer.parseInt(data2);
System.out.println("Received: " +b+"from"+addr2+":"+port2);

int sum=a+b;

sbuf=String.valueOf(sum).getBytes();

DatagramPacket spkt=new DatagramPacket(sbuf,sbuf.length,addr,port);
socket.send(spkt);

System.out.println("Sent:"+sum);
}
}