//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.09.27 at 07:46:05 PM BST 
//


package org.purl.dc.terms;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.purl.dc.terms package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Coverage_QNAME = new QName("http://purl.org/dc/terms/", "coverage");
    private final static QName _Identifier_QNAME = new QName("http://purl.org/dc/terms/", "identifier");
    private final static QName _Format_QNAME = new QName("http://purl.org/dc/terms/", "format");
    private final static QName _Modified_QNAME = new QName("http://purl.org/dc/terms/", "modified");
    private final static QName _Language_QNAME = new QName("http://purl.org/dc/terms/", "language");
    private final static QName _AccessRights_QNAME = new QName("http://purl.org/dc/terms/", "accessRights");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.purl.dc.terms
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Abstract }
     * 
     */
    public Abstract createAbstract() {
        return new Abstract();
    }

    /**
     * Create an instance of {@link Creator }
     * 
     */
    public Creator createCreator() {
        return new Creator();
    }

    /**
     * Create an instance of {@link Date }
     * 
     */
    public Date createDate() {
        return new Date();
    }

    /**
     * Create an instance of {@link HasVersion }
     * 
     */
    public HasVersion createHasVersion() {
        return new HasVersion();
    }

    /**
     * Create an instance of {@link Issued }
     * 
     */
    public Issued createIssued() {
        return new Issued();
    }

    /**
     * Create an instance of {@link Publisher }
     * 
     */
    public Publisher createPublisher() {
        return new Publisher();
    }

    /**
     * Create an instance of {@link References }
     * 
     */
    public References createReferences() {
        return new References();
    }

    /**
     * Create an instance of {@link Replaces }
     * 
     */
    public Replaces createReplaces() {
        return new Replaces();
    }

    /**
     * Create an instance of {@link Relation }
     * 
     */
    public Relation createRelation() {
        return new Relation();
    }

    /**
     * Create an instance of {@link Spatial }
     * 
     */
    public Spatial createSpatial() {
        return new Spatial();
    }

    /**
     * Create an instance of {@link Subject }
     * 
     */
    public Subject createSubject() {
        return new Subject();
    }

    /**
     * Create an instance of {@link Temporal }
     * 
     */
    public Temporal createTemporal() {
        return new Temporal();
    }

    /**
     * Create an instance of {@link Title }
     * 
     */
    public Title createTitle() {
        return new Title();
    }

    /**
     * Create an instance of {@link Type }
     * 
     */
    public Type createType() {
        return new Type();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://purl.org/dc/terms/", name = "coverage")
    public JAXBElement<String> createCoverage(String value) {
        return new JAXBElement<>(_Coverage_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://purl.org/dc/terms/", name = "identifier")
    public JAXBElement<String> createIdentifier(String value) {
        return new JAXBElement<>(_Identifier_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://purl.org/dc/terms/", name = "format")
    public JAXBElement<String> createFormat(String value) {
        return new JAXBElement<>(_Format_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://purl.org/dc/terms/", name = "modified")
    public JAXBElement<XMLGregorianCalendar> createModified(XMLGregorianCalendar value) {
        return new JAXBElement<>(_Modified_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://purl.org/dc/terms/", name = "language")
    public JAXBElement<String> createLanguage(String value) {
        return new JAXBElement<>(_Language_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://purl.org/dc/terms/", name = "accessRights")
    public JAXBElement<String> createAccessRights(String value) {
        return new JAXBElement<>(_AccessRights_QNAME, String.class, null, value);
    }

}
