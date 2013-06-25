/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.webpage.parse;

import java.util.Iterator;
import javax.swing.tree.DefaultMutableTreeNode;
import model.website.HtmlPage;
import model.website.HtmlTag;
import model.website.HtmlTagAttribute;
import model.website.HtmlTagText;
import model.website.PairedHtmlTag;
import model.website.UnpairedHtmlTag;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *
 * @author Djordje Gligorijevic
 */
public class TreeModelFromHtmlPage {

    /*
     * Unosimo prvi 
     */
    public static DefaultMutableTreeNode getTreeNodes(Document html) {
        DefaultMutableTreeNode root = null;
//        root = new DefaultMutableTreeNode(html.getAllElements().first().nodeName());
        root = new DefaultMutableTreeNode(html.getElementsByTag("html").first().nodeName());
        htmlstablorekurzivno(html.getElementsByTag("html").first(), root);
        return root;
    }
    
    public static void copyHtmlStructure(Document htmlPageDocument, HtmlPage htmlpage){
        Element rootElement = htmlPageDocument.getElementsByTag("html").first();
        htmlpage.setHtmlPageText(htmlPageDocument.html());
        htmlpage.setHtmlPageName(htmlPageDocument.title());
        htmlpage.setHtmlPageDescription(htmlPageDocument.title());
        HtmlTag startTag = new HtmlTag();
        copyStructure(rootElement, startTag);
        htmlpage.getHtmlTagList().add(startTag);
        System.out.println("finished copying html structure");
    }

    public static void htmlstablorekurzivno(Element element, DefaultMutableTreeNode node) {
        if (element.childNodeSize() == 0) {
            DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(element.nodeName());
            node.add(newNode);
        } else {
            if (!element.nodeName().equals("html")) {
                DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(element.nodeName());
                node.add(newNode);
                Iterator<Element> iterator = element.children().iterator();  //getAllElements().iterator();

                while (iterator.hasNext()) {
                    Element el = (Element) iterator.next();
                    if (!element.equals(el)) {
//                        System.out.println("Dete od: " + element.nodeName() + " je: " + el.nodeName());
                        htmlstablorekurzivno(el, newNode);
                    }
                }

            } else {
                Iterator<Element> iterator = element.children().iterator();  //getAllElements().iterator();

                while (iterator.hasNext()) {
                    Element el = (Element) iterator.next();
                    if (!element.equals(el)) {
                        System.out.println("Dete od: " + element.nodeName() + " je: " + el.nodeName());
                        htmlstablorekurzivno(el, node);
                    }
                }
            }
        }
    }

    public static void copyStructure(Element element, HtmlTag startTag) {
        if (element.childNodeSize() == 0) {
            if (!element.isBlock()) {
                HtmlTag htmlTag = new HtmlTag();
                UnpairedHtmlTag unpairedHtmlTag = new UnpairedHtmlTag();
                htmlTag.setUnpairedHtmlTag(unpairedHtmlTag);
                htmlTag.setHtmlTagName(element.tagName());
                HtmlTagText htmlTagText = new HtmlTagText();
                htmlTagText.setHtmlTagTextValue(element.text());
                Attributes attributes = element.attributes();
                for (Attribute a : attributes.asList()) {
                    HtmlTagAttribute htmlTagAttribute = new HtmlTagAttribute();
                    htmlTagAttribute.setHtmlTagAttributeName(a.getKey());
                    htmlTagAttribute.setHtmlTagAttributeValue(a.getValue());
                    htmlTag.getHtmlTagAttributeList().add(htmlTagAttribute);
                }
            }
        } else {
            if (!element.nodeName().equals("html")) {
                startTag.setHtmlTagName(element.tagName());
                PairedHtmlTag pairedHtmlTag = new PairedHtmlTag();
                startTag.setPairedHtmlTag(pairedHtmlTag);

                for (Attribute a : element.attributes().asList()) {
                    HtmlTagAttribute htmlTagAttribute = new HtmlTagAttribute();
                    htmlTagAttribute.setHtmlTagAttributeName(a.getKey());
                    htmlTagAttribute.setHtmlTagAttributeValue(a.getValue());
                    startTag.getHtmlTagAttributeList().add(htmlTagAttribute);
                }

                Iterator<Element> iterator = element.children().iterator();
                while (iterator.hasNext()) {
                    Element el = (Element) iterator.next();
                    if (!element.equals(el)) {
                        copyStructure(el, startTag);
                    }
                }
            } else {
                //TODO HARD!
                if (element.isBlock()) {
                    //TODO here
                    
                    Iterator<Element> iterator = element.children().iterator();

                    while (iterator.hasNext()) {
                        Element el = (Element) iterator.next();
                        if (!element.equals(el)) {
                            System.out.println("Dete od: " + element.nodeName() + " je: " + el.nodeName());
                            copyStructure(el, startTag);
                        }
                    }
                } else {
                    //and TODO here



                    Iterator<Element> iterator = element.children().iterator();

                    while (iterator.hasNext()) {
                        Element el = (Element) iterator.next();
                        if (!element.equals(el)) {
                            System.out.println("Dete od: " + element.nodeName() + " je: " + el.nodeName());
                            copyStructure(el, startTag);
                        }
                    }
                }
            }
        }
    }
}
