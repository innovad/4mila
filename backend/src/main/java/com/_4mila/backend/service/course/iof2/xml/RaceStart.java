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
    "eventRaceIdOrEventRace",
    "start"
})
@XmlRootElement(name = "RaceStart")
public class RaceStart {

    @XmlElements({
        @XmlElement(name = "EventRaceId", required = true, type = EventRaceId.class),
        @XmlElement(name = "EventRace", required = true, type = EventRace.class)
    })
    protected List<Object> eventRaceIdOrEventRace;
    @XmlElement(name = "Start", required = true)
    protected Start start;

    /**
     * Gets the value of the eventRaceIdOrEventRace property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the eventRaceIdOrEventRace property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEventRaceIdOrEventRace().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EventRaceId }
     * {@link EventRace }
     * 
     * 
     */
    public List<Object> getEventRaceIdOrEventRace() {
        if (eventRaceIdOrEventRace == null) {
            eventRaceIdOrEventRace = new ArrayList<Object>();
        }
        return this.eventRaceIdOrEventRace;
    }

    /**
     * Gets the value of the start property.
     * 
     * @return
     *     possible object is
     *     {@link Start }
     *     
     */
    public Start getStart() {
        return start;
    }

    /**
     * Sets the value of the start property.
     * 
     * @param value
     *     allowed object is
     *     {@link Start }
     *     
     */
    public void setStart(Start value) {
        this.start = value;
    }

}