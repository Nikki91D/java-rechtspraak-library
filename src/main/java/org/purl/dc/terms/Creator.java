//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.09.27 at 07:46:05 PM BST 
//


package org.purl.dc.terms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for anonymous complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType>
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *       &lt;attribute ref="{http://www.w3.org/2000/01/rdf-schema#}label use="required""/>
 *       &lt;attribute name="resourceIdentifier" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="scheme" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute ref="{http://psi.rechtspraak.nl/}resourceIdentifier"/>
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "value"
})
@XmlRootElement(name = "creator")
public class Creator {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "label", namespace = "http://www.w3.org/2000/01/rdf-schema#", required = true)
    protected String label;
    @XmlAttribute(name = "resourceIdentifier")
    @XmlSchemaType(name = "anyURI")
    protected String resourceIdentifier;
    @XmlAttribute(name = "scheme", required = true)
    protected String scheme;
    @XmlAttribute(name = "resourceIdentifier", namespace = "http://psi.rechtspraak.nl/")
    @XmlSchemaType(name = "anyURI")
    protected String psiResourceIdentifier;

    /**
     * Gets the value of the value property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the label property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets the value of the label property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLabel(String value) {
        this.label = value;
    }

    /**
     * Gets the value of the resourceIdentifier property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getResourceIdentifier() {
//        if (resourceIdentifier == null || resourceIdentifier.trim().length() <= 0) {
//            return psiResourceIdentifier;
//        } else if (psiResourceIdentifier != null && psiResourceIdentifier.length() > 0) {
//            System.err.println("WARNING: Also found psiResourceIdentifier");
//        }
        return resourceIdentifier;
    }

    /**
     * Sets the value of the resourceIdentifier property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setResourceIdentifier(String value) {
        this.resourceIdentifier = value;
    }

    /**
     * Gets the value of the scheme property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getScheme() {
        return scheme;
    }

    /**
     * Sets the value of the scheme property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setScheme(String value) {
        this.scheme = value;
    }

    /**
     * Gets the value of the psiResourceIdentifier property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPsiResourceIdentifier() {
        return psiResourceIdentifier;
    }

    /**
     * Sets the value of the psiResourceIdentifier property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPsiResourceIdentifier(String value) {
        this.psiResourceIdentifier = value;
    }

}
