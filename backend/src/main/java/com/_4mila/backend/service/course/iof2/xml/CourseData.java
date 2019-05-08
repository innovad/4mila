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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "iofVersion",
    "map",
    "startPoint",
    "control",
    "finishPoint",
    "course"
})
@XmlRootElement(name = "CourseData")
public class CourseData {

    @XmlElement(name = "IOFVersion")
    protected IOFVersion iofVersion;
    @XmlElement(name = "Map")
    protected Map map;
    @XmlElement(name = "StartPoint")
    protected List<StartPoint> startPoint;
    @XmlElement(name = "Control")
    protected List<XmlControl> control;
    @XmlElement(name = "FinishPoint")
    protected List<FinishPoint> finishPoint;
    @XmlElement(name = "Course")
    protected List<XmlCourse> course;

    /**
     * Gets the value of the iofVersion property.
     * 
     * @return
     *     possible object is
     *     {@link IOFVersion }
     *     
     */
    public IOFVersion getIOFVersion() {
        return iofVersion;
    }

    /**
     * Sets the value of the iofVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link IOFVersion }
     *     
     */
    public void setIOFVersion(IOFVersion value) {
        this.iofVersion = value;
    }

    /**
     * Gets the value of the map property.
     * 
     * @return
     *     possible object is
     *     {@link Map }
     *     
     */
    public Map getMap() {
        return map;
    }

    /**
     * Sets the value of the map property.
     * 
     * @param value
     *     allowed object is
     *     {@link Map }
     *     
     */
    public void setMap(Map value) {
        this.map = value;
    }

    /**
     * Gets the value of the startPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the startPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStartPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StartPoint }
     * 
     * 
     */
    public List<StartPoint> getStartPoint() {
        if (startPoint == null) {
            startPoint = new ArrayList<StartPoint>();
        }
        return this.startPoint;
    }

    /**
     * Gets the value of the control property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the control property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getControl().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link XmlControl }
     * 
     * 
     */
    public List<XmlControl> getControl() {
        if (control == null) {
            control = new ArrayList<XmlControl>();
        }
        return this.control;
    }

    /**
     * Gets the value of the finishPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the finishPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFinishPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FinishPoint }
     * 
     * 
     */
    public List<FinishPoint> getFinishPoint() {
        if (finishPoint == null) {
            finishPoint = new ArrayList<FinishPoint>();
        }
        return this.finishPoint;
    }

    /**
     * Gets the value of the course property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the course property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCourse().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link XmlCourse }
     * 
     * 
     */
    public List<XmlCourse> getCourse() {
        if (course == null) {
            course = new ArrayList<XmlCourse>();
        }
        return this.course;
    }

}
