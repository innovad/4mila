//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.07.09 at 05:12:48 PM MESZ 
//


package com._4mila.backend.service.course.iof2.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "eventOfficialRole",
    "personIdOrPerson"
})
@XmlRootElement(name = "EventOfficial")
public class EventOfficial {

    @XmlElement(name = "EventOfficialRole", required = true)
    protected String eventOfficialRole;
    @XmlElements({
        @XmlElement(name = "PersonId", required = true, type = PersonId.class),
        @XmlElement(name = "Person", required = true, type = Person.class)
    })
    protected List<Object> personIdOrPerson;

    /**
     * Gets the value of the eventOfficialRole property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEventOfficialRole() {
        return eventOfficialRole;
    }

    /**
     * Sets the value of the eventOfficialRole property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventOfficialRole(String value) {
        this.eventOfficialRole = value;
    }

    /**
     * Gets the value of the personIdOrPerson property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the personIdOrPerson property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPersonIdOrPerson().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PersonId }
     * {@link Person }
     * 
     * 
     */
    public List<Object> getPersonIdOrPerson() {
        if (personIdOrPerson == null) {
            personIdOrPerson = new ArrayList<Object>();
        }
        return this.personIdOrPerson;
    }

}
