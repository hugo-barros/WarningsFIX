//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.03.30 at 08:49:48 AM BRT 
//
package br.ufg.inf.findbugsparser;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained
 * within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}Message" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="classname" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="start" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="end" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="startBytecode" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="endBytecode" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="opcodes" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="sourcefile" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="sourcepath" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="synthetic" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="role" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="primary" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "message"
})
@XmlRootElement(name = "SourceLine")
public class SourceLine {

    @XmlElement(name = "Message")
    protected String message;
    @XmlAttribute(required = true)
    protected String classname;
    @XmlAttribute
    protected Integer start;
    @XmlAttribute
    protected Integer end;
    @XmlAttribute
    protected Integer startBytecode;
    @XmlAttribute
    protected Integer endBytecode;
    @XmlAttribute
    protected String opcodes;
    @XmlAttribute
    protected String sourcefile;
    @XmlAttribute
    protected String sourcepath;
    @XmlAttribute
    protected Boolean synthetic;
    @XmlAttribute
    protected String role;
    @XmlAttribute
    protected Boolean primary;

    /**
     * Gets the value of the message property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * Gets the value of the classname property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getClassname() {
        return classname;
    }

    /**
     * Sets the value of the classname property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setClassname(String value) {
        this.classname = value;
    }

    /**
     * Gets the value of the start property.
     *
     * @return possible object is {@link Integer }
     *
     */
    public Integer getStart() {
        return start;
    }

    /**
     * Sets the value of the start property.
     *
     * @param value allowed object is {@link Integer }
     *
     */
    public void setStart(Integer value) {
        this.start = value;
    }

    /**
     * Gets the value of the end property.
     *
     * @return possible object is {@link Integer }
     *
     */
    public Integer getEnd() {
        return end;
    }

    /**
     * Sets the value of the end property.
     *
     * @param value allowed object is {@link Integer }
     *
     */
    public void setEnd(Integer value) {
        this.end = value;
    }

    /**
     * Gets the value of the startBytecode property.
     *
     * @return possible object is {@link Integer }
     *
     */
    public Integer getStartBytecode() {
        return startBytecode;
    }

    /**
     * Sets the value of the startBytecode property.
     *
     * @param value allowed object is {@link Integer }
     *
     */
    public void setStartBytecode(Integer value) {
        this.startBytecode = value;
    }

    /**
     * Gets the value of the endBytecode property.
     *
     * @return possible object is {@link Integer }
     *
     */
    public Integer getEndBytecode() {
        return endBytecode;
    }

    /**
     * Sets the value of the endBytecode property.
     *
     * @param value allowed object is {@link Integer }
     *
     */
    public void setEndBytecode(Integer value) {
        this.endBytecode = value;
    }

    /**
     * Gets the value of the opcodes property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getOpcodes() {
        return opcodes;
    }

    /**
     * Sets the value of the opcodes property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setOpcodes(String value) {
        this.opcodes = value;
    }

    /**
     * Gets the value of the sourcefile property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getSourcefile() {
        return sourcefile;
    }

    /**
     * Sets the value of the sourcefile property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setSourcefile(String value) {
        this.sourcefile = value;
    }

    /**
     * Gets the value of the sourcepath property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getSourcepath() {
        return sourcepath;
    }

    /**
     * Sets the value of the sourcepath property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setSourcepath(String value) {
        this.sourcepath = value;
    }

    /**
     * Gets the value of the synthetic property.
     *
     * @return possible object is {@link Boolean }
     *
     */
    public Boolean isSynthetic() {
        return synthetic;
    }

    /**
     * Sets the value of the synthetic property.
     *
     * @param value allowed object is {@link Boolean }
     *
     */
    public void setSynthetic(Boolean value) {
        this.synthetic = value;
    }

    /**
     * Gets the value of the role property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the value of the role property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setRole(String value) {
        this.role = value;
    }

    /**
     * Gets the value of the primary property.
     *
     * @return possible object is {@link Boolean }
     *
     */
    public Boolean isPrimary() {
        return primary;
    }

    /**
     * Sets the value of the primary property.
     *
     * @param value allowed object is {@link Boolean }
     *
     */
    public void setPrimary(Boolean value) {
        this.primary = value;
    }
}
