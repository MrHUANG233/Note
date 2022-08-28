using System;
using System.IO;
using System.Text;

public class TextWrite{
    public static void Main(string[] args){
        byte[] bytes=File.ReadAllBytes("input2.txt");
        int count1=0;
        int count2=0;
        for(int i=0;i<bytes.Length;i++){
            if(bytes[i]==13){
                count1+=1;
            }
        }
        File.WriteAllBytes("output2.txt",bytes);
        string str=File.ReadAllText("input2.txt");
        char[] str2char=str.ToCharArray();
        for(int i=0;i<str2char.Length;i++){
            if(str2char[i]=='\r'){
                count2+=1;
            }
        }
        string str3 ="AAAAA\nBBBBB\nCCCCC";
        Console.WriteLine(str3.Length);
        File.WriteAllText("output3.txt",str3);
        string str4 =File.ReadAllText("output3.txt");
        Console.WriteLine(str4.Length);
        Console.WriteLine(bytes.Length);
        Console.WriteLine(str2char.Length);
        Console.WriteLine(count1);
        Console.WriteLine(count2);
    }
    
}