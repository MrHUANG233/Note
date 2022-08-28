using System.Xml;
using System.Xml.Linq;
using System.Xml.XPath;
public class Xml1{
    public static void Main(string[] args){
        XmlDocument xmlDoc = new XmlDocument();
        XDocument xDoc = new XDocument();
        string xmlContent =@"<? version='1.0' encoding = 'utf-8' ?> 
        <IndexItem xmlns:i='https'>
        <Item>
        <Information>'hello'</Information>
        </Item>
        </IndexItem>";
        XPathDocument xPathDoc=new XPathDooument(new StringReader(xmlContent));
    }
}