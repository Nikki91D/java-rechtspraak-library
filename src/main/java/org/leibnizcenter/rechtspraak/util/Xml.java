package org.leibnizcenter.rechtspraak.util;

import com.google.common.collect.Lists;
import com.sun.org.apache.xerces.internal.dom.DOMOutputImpl;
import org.w3c.dom.*;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;

import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.StringWriter;
import java.io.Writer;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;

/**
 * Created by maarten on 22-12-15.
 */
public class Xml {
    public static Element wrapSubstringInElement(
            Text node,
            int startIndex,
            int length,
            String tagName) {
        return wrapSubstringInElement(node, startIndex, length, null, tagName, null)[1];
    }

    public static Element wrapSubstringInElement(
            Text node,
            int length,
            String tagName) {
        node.splitText(length);

        Node parent = node.getParentNode();

        Element newElement = node.getOwnerDocument().createElement(tagName);
        parent.replaceChild(newElement, node);
        newElement.appendChild(node);

        return newElement;
    }

    public static Element[] wrapSubstringInElement(
            Text startNode,
            int startIndex,
            int length,
            String tagNameStart, String tagNameMiddle, String tagNameLast) {
        Element[] wrappedesies = new Element[3];

        Text middle = startNode.splitText(startIndex);
        Text last = middle.splitText(length);

        Node parent = startNode.getParentNode();
        if (tagNameStart != null) {
            Element firstTextWrapped = startNode.getOwnerDocument().createElement(tagNameStart);
            parent.replaceChild(firstTextWrapped, startNode);
            firstTextWrapped.appendChild(startNode);
            wrappedesies[0] = firstTextWrapped;
        }

        Element newElement = startNode.getOwnerDocument().createElement(tagNameMiddle);
        parent.replaceChild(newElement, middle);
        newElement.appendChild(middle);
        wrappedesies[1] = newElement;

        if (tagNameLast != null) {
            Element lastTextWrapped = startNode.getOwnerDocument().createElement(tagNameLast);
            parent.replaceChild(lastTextWrapped, last);
            lastTextWrapped.appendChild(last);
            wrappedesies[2] = lastTextWrapped;
        }

        return wrappedesies;
    }


    public static String toString(Document document) throws TransformerException,
            InstantiationException, IllegalAccessException, ClassNotFoundException {
//        DOMImplementationLS domImplLS = (DOMImplementationLS) document
//                .getImplementation();
        DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
        DOMImplementationLS impl = (DOMImplementationLS) registry.getDOMImplementation("XML 3.0 LS 3.0");
        LSSerializer serializer = impl.createLSSerializer();
        LSOutput out = new DOMOutputImpl();
        out.setEncoding("UTF-8");
        Writer sw = new StringWriter();
        out.setCharacterStream(sw);
        serializer.write(document, out);

        return sw.toString();
    }

    public static void writeToStream(Document document, Writer w) throws TransformerException,
            InstantiationException, IllegalAccessException, ClassNotFoundException {
//        DOMImplementationLS domImplLS = (DOMImplementationLS) document
//                .getImplementation();
        DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
        DOMImplementationLS impl = (DOMImplementationLS) registry.getDOMImplementation("XML 3.0 LS 3.0");
        LSSerializer serializer = impl.createLSSerializer();
        LSOutput out = new DOMOutputImpl();
        out.setEncoding("UTF-8");
        out.setCharacterStream(w);
        serializer.write(document, out);
    }

    public static Element getContentRoot(Document doc) {
        NodeList uitspraken = doc.getElementsByTagName("uitspraak");
        NodeList conclusies = doc.getElementsByTagName("conclusie");

        assert uitspraken.getLength() + conclusies.getLength() == 1;

        Element e = null;
        if (uitspraken.getLength() == 1) {
            e = (Element) uitspraken.item(0);
        } else if (conclusies.getLength() == 1) {
            e = (Element) conclusies.item(0);
        }
        if (e == null) {
            throw new NullPointerException("Content node could not be found");
        }
        return e;
    }

    public static List<Text> textInPreorder(Node root) {
        if (root.getNodeType() == Node.TEXT_NODE) {
            return Lists.newArrayList((Text) root);
        } else {
            NodeList children = root.getChildNodes();
            List<Text> texts = new ArrayList<>(children.getLength());
            for (int i = 0; i < children.getLength(); i++) {
                texts.addAll(textInPreorder(children.item(i)));
            }
            return texts;
        }
    }


    //    private final static Pattern relevantParents = Pattern.compile("(^title$)|(^\\p{L}*\\.info$)");


    public static boolean isElement(Node e) {
        return e != null && e.getNodeType() == Node.ELEMENT_NODE;
    }

    public static boolean whitespaceText(Node node) {
        switch (node.getNodeType()) {
            case Element.TEXT_NODE:
                return node.getTextContent().trim().length() == 0;
            case Element.ELEMENT_NODE:
            case Element.PROCESSING_INSTRUCTION_NODE:
                return false;
            default:
                throw new InvalidParameterException();
        }
    }

    public static boolean hasParentWithTagSuffix(Node node, String suffix) {
        Node parentNode = node.getParentNode();
        return parentNode != null
                && (parentNode.getNodeType() == Node.ELEMENT_NODE
                && ((Element) parentNode).getTagName().endsWith(suffix)
                || hasParentWithTagSuffix(parentNode, suffix));

    }

    public static Element getParentWithTagName(Node el, String tag) {
        Node parentNode = el.getParentNode();
        if (parentNode != null && parentNode.getNodeType() == Node.ELEMENT_NODE) {
            if (((Element) parentNode).getTagName().equals(tag)) {
                return (Element) parentNode;
            } else {
                return getParentWithTagName(parentNode, tag);
            }
        } else {
            return null;
        }
    }

    public static Element wrapNodeInElement(Node node, String tagText) {
        Node parent = node.getParentNode();
        Element newElement = node.getOwnerDocument().createElement(tagText);
        parent.replaceChild(newElement, node);
        newElement.appendChild(node);
        return newElement;
    }

    /**
     * Has more than one non-whitespace char
     *
     * @param text
     * @return
     */
    public static boolean hasSubstantialText(Text text) {
        String textContent = text.getTextContent();
        if (textContent.length() > 0) {
            Matcher matcher = Regex.NON_WHITESPACE.matcher(textContent);
            if (matcher.find() &&
                    matcher.find()) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNonEmptyText(Node sibling) {
        return sibling != null
                && (sibling.getNodeType() == Element.TEXT_NODE
                || "text".equals(sibling.getNodeName())
                || "textgroup".equals(sibling.getNodeName())
                || "nr".equals(sibling.getNodeName())
                || "emphasis".equals(sibling.getNodeName())
        )
                && sibling.getTextContent().trim().length() > 0;
    }

    public static Node getPreviousNonWhitespaceNode(Element e) {
        Node prev = e;
        do {
            prev = prev.getPreviousSibling();
        } while (prev != null && whitespaceText(prev));
        return prev;
    }

    public static List<File> listXmlFiles(File folder) {
        return listXmlFiles(folder, -1);
    }

    public static List<File> listXmlFiles(File folder, int max) {
        return listXmlFiles(folder, max, true);
    }

    public static List<File> listXmlFiles(File folder, int max, boolean shuffle) {
        File[] files = folder.listFiles();
        if (files == null) throw new NullPointerException();

        List<File> xmls = new ArrayList<>(files.length);
        if (shuffle) {
            for (File file : files) {
                addToListIfXmlFile(xmls, file);
            }
            Collections.shuffle(xmls);
        } else {
            for (File file : files) {
                addToListIfXmlFile(xmls, file);
                if (max > 0 && xmls.size() >= max) break;
            }
        }
        if (max > 0 && max < xmls.size()) {
            return xmls.subList(0, max);
        }
        for (File f : xmls) if (f == null || f.getName() == null) throw new Error();
        return xmls;
    }

    private static void addToListIfXmlFile(List<File> xmls, File file) {
        if (file.getAbsolutePath().endsWith(".xml")) {
            xmls.add(file);
        }
    }

    public static List<File> listXmlFiles() {
        return listXmlFiles(new File(Const.PATH_TRAIN_TEST_XML_FILES_LINUX), -1, false);
    }

    public static File getFile(File folder, String ecli) {
        return new File(folder, ecli.replaceAll(":", ".") + ".xml");
    }
}
