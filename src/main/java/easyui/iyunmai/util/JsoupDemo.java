package easyui.iyunmai.util;

import java.io.IOException;
import java.text.AttributedCharacterIterator.Attribute;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class JsoupDemo {

	@SuppressWarnings("null")
	public static void main(String[] args)  {
		
		Document doc;
		try {
			doc = Jsoup.connect("http://www.baidu.com").timeout(5000).get();
			Elements mnavs = doc.select(".mnav");//通过css获取一系列对象
			Element mnav = mnavs.first();
			String mnavFt= mnav.text();//获取第一个对象的text
			String mnavFh = mnav.html();
			//System.out.println(mnavFh);
			Attributes mnavsFatts = mnavs.first().attributes();//获取第一个对象的所有属性
			/*System.out.println(mnavsFatts.get("href"));//输出所有属性中的href属性
			System.out.println(mnavsFatts.get("name"));
			System.out.println(mnavsFatts.get("class"));*/
			String title = doc.title();
			String text = doc.text();
			//System.out.println(title+")|("+text);	
			Element content = doc.getElementById("u1");
			//System.out.println(content.html());
			Elements links = content.getElementsByTag("a");
			for(Element link : links) {
			String linkHref = link.attr("href");
			String linkText = link.text();
			//System.out.println(linkHref+"*****"+linkText);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
