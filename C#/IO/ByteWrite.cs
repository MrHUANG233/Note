using System.IO;
using System;
using System.Text;

public class ByteWrite{
    public static void Main(string[] args){
        // string str=File.ReadAllText("input.txt");
        // File.WriteAllText("output.txt",str);
        byte b = 65;
        byte[] bytes=new byte[100];
        for(int i=0;i<50;i++){
            bytes[i] = b;
        }
        bytes[50] = 13;
        for(int i = 51;i<100;i++){
            bytes[i] = 66;
        }
        File.WriteAllBytes("output.txt",bytes);
        File.AppendAllText("output.txt","appendtext");
        string str = "appendtext\nappendtext2line";
    }
}