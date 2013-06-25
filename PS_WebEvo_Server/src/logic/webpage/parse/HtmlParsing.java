/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.webpage.parse;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import org.jsoup.select.NodeVisitor;
import org.xml.sax.SAXException;

/**
 *
 * @author Djordje Gligorijevic
 */
public class HtmlParsing {

    public static org.w3c.dom.Document DOMDocument(String file) throws ParserConfigurationException, SAXException, IOException {
        org.w3c.dom.Document document;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder = factory.newDocumentBuilder();
        document = builder.parse(file);

        return document;

    }

    public static String parse(String stringUrl) throws IOException {
//        Document doc = Jsoup.connect(urlToSearch).get();
//        doc.body().text();

        URL url = new URL(stringUrl);
        URLConnection con = url.openConnection();
        Pattern p = Pattern.compile("text/html;\\s+charset=([^\\s]+)\\s*");
        Matcher m = p.matcher(con.getContentType());
        /* If Content-Type doesn't match this pre-conception, choose default and 
         * hope for the best. */
        String charset = m.matches() ? m.group(1) : "ISO-8859-1";
        Reader r = new InputStreamReader(con.getInputStream(), charset);
        StringBuilder buf = new StringBuilder();
        while (true) {
            int ch = r.read();
            if (ch < 0) {
                break;
            }
            buf.append((char) ch);
        }
        String str = buf.toString();

        return str;
    }

    public static String parseUrlJsoup(String stringUrl) throws IOException {
        Document doc = null;
        if (stringUrl.startsWith("http")) {
            doc = Jsoup.connect(stringUrl).get();
        } else {
            File in = new File(stringUrl);

            doc = Jsoup.parse(in, null);
        }
//        Document doc = Jsoup.parse(stringUrl);
        return doc.html();
    }

    public static String parseFileJsoup(String stringUrl) throws IOException {
        Document doc = null;
        File in = new File(stringUrl);
        doc = Jsoup.parse(in, null);
        return doc.html();
    }

    public static void parseUrlJsoupIterate(String stringUrl) throws IOException {
        Document doc = Jsoup.connect(stringUrl).get();
//        Document doc = Jsoup.parse(stringUrl);

        doc.traverse(new NodeVisitor() {
            @Override
            public void head(Node node, int depth) {
                System.out.println("Entering tag: " + node.nodeName());
            }

            @Override
            public void tail(Node node, int depth) {
                System.out.println("Exiting tag: " + node.nodeName());
            }
        });

//        Elements e = doc.getAllElements();
//
//        for (Iterator<Element> it = e.iterator(); it.hasNext();) {
//
//
//            Element element = it.next();
//            System.out.println(element.tagName());
//        }
    }

    public static Document getHTMLDocument(String stringUrl) throws IOException {
        Document doc = null;
        if (stringUrl.startsWith("http") || stringUrl.startsWith("www")) {
            doc = Jsoup.connect(stringUrl).get();
        } else {
            File in = new File(stringUrl);

            doc = Jsoup.parse(in, null);
        }
//        Document doc = Jsoup.parse(stringUrl);
        return doc;

//        Document doc = Jsoup.connect(stringUrl).get();
//        File in = new File(stringUrl);
//        Document doc = Jsoup.parse(in, null);
//        Document doc = Jsoup.parse(stringUrl);
//        Element link = doc.select("a").first();
//        String relHref = link.attr("href"); // == "/"
//        String absHref = link.attr("abs:href"); // "http://jsoup.org/"

    }
}
