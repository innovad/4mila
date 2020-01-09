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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "courseVariationId",
    "name",
    "courseLength",
    "courseClimb",
    "startPointCodeOrStartPoint",
    "finishChute",
    "courseControl",
    "finishPointCodeOrFinishPoint",
    "distanceToFinish",
    "modifyDate"
})
@XmlRootElement(name = "CourseVariation")
public class CourseVariation {

    @XmlAttribute
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String numberOfRunners;
    @XmlElement(name = "CourseVariationId", required = true)
    protected CourseVariationId courseVariationId;
    @XmlElement(name = "Name")
    protected Name name;
    @XmlElement(name = "CourseLength", required = true)
    protected CourseLength courseLength;
    @XmlElement(name = "CourseClimb")
    protected CourseClimb courseClimb;
    @XmlElements({
        @XmlElement(name = "StartPointCode", type = StartPointCode.class),
        @XmlElement(name = "StartPoint", type = StartPoint.class)
    })
    protected List<Object> startPointCodeOrStartPoint;
    @XmlElement(name = "FinishChute")
    protected String finishChute;
    @XmlElement(name = "CourseControl", required = true)
    protected List<CourseControl> courseControl;
    @XmlElements({
        @XmlElement(name = "FinishPointCode", type = FinishPointCode.class),
        @XmlElement(name = "FinishPoint", type = FinishPoint.class)
    })
    protected List<Object> finishPointCodeOrFinishPoint;
    @XmlElement(name = "DistanceToFinish")
    protected DistanceToFinish distanceToFinish;
    @XmlElement(name = "ModifyDate")
    protected ModifyDate modifyDate;

    /**
     * Gets the value of the numberOfRunners property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumberOfRunners() {
        return numberOfRunners;
    }

    /**
     * Sets the value of the numberOfRunners property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberOfRunners(String value) {
        this.numberOfRunners = value;
    }

    /**
     * Gets the value of the courseVariationId property.
     * 
     * @return
     *     possible object is
     *     {@link CourseVariationId }
     *     
     */
    public CourseVariationId getCourseVariationId() {
        return courseVariationId;
    }

    /**
     * Sets the value of the courseVariationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link CourseVariationId }
     *     
     */
    public void setCourseVariationId(CourseVariationId value) {
        this.courseVariationId = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link Name }
     *     
     */
    public Name getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link Name }
     *     
     */
    public void setName(Name value) {
        this.name = value;
    }

    /**
     * Gets the value of the courseLength property.
     * 
     * @return
     *     possible object is
     *     {@link CourseLength }
     *     
     */
    public CourseLength getCourseLength() {
        return courseLength;
    }

    /**
     * Sets the value of the courseLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link CourseLength }
     *     
     */
    public void setCourseLength(CourseLength value) {
        this.courseLength = value;
    }

    /**
     * Gets the value of the courseClimb property.
     * 
     * @return
     *     possible object is
     *     {@link CourseClimb }
     *     
     */
    public CourseClimb getCourseClimb() {
        return courseClimb;
    }

    /**
     * Sets the value of the courseClimb property.
     * 
     * @param value
     *     allowed object is
     *     {@link CourseClimb }
     *     
     */
    public void setCourseClimb(CourseClimb value) {
        this.courseClimb = value;
    }

    /**
     * Gets the value of the startPointCodeOrStartPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the startPointCodeOrStartPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStartPointCodeOrStartPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StartPointCode }
     * {@link StartPoint }
     * 
     * 
     */
    public List<Object> getStartPointCodeOrStartPoint() {
        if (startPointCodeOrStartPoint == null) {
            startPointCodeOrStartPoint = new ArrayList<Object>();
        }
        return this.startPointCodeOrStartPoint;
    }

    /**
     * Gets the value of the finishChute property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFinishChute() {
        return finishChute;
    }

    /**
     * Sets the value of the finishChute property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFinishChute(String value) {
        this.finishChute = value;
    }

    /**
     * Gets the value of the courseControl property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the courseControl property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCourseControl().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CourseControl }
     * 
     * 
     */
    public List<CourseControl> getCourseControl() {
        if (courseControl == null) {
            courseControl = new ArrayList<CourseControl>();
        }
        return this.courseControl;
    }

    /**
     * Gets the value of the finishPointCodeOrFinishPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the finishPointCodeOrFinishPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFinishPointCodeOrFinishPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FinishPointCode }
     * {@link FinishPoint }
     * 
     * 
     */
    public List<Object> getFinishPointCodeOrFinishPoint() {
        if (finishPointCodeOrFinishPoint == null) {
            finishPointCodeOrFinishPoint = new ArrayList<Object>();
        }
        return this.finishPointCodeOrFinishPoint;
    }

    /**
     * Gets the value of the distanceToFinish property.
     * 
     * @return
     *     possible object is
     *     {@link DistanceToFinish }
     *     
     */
    public DistanceToFinish getDistanceToFinish() {
        return distanceToFinish;
    }

    /**
     * Sets the value of the distanceToFinish property.
     * 
     * @param value
     *     allowed object is
     *     {@link DistanceToFinish }
     *     
     */
    public void setDistanceToFinish(DistanceToFinish value) {
        this.distanceToFinish = value;
    }

    /**
     * Gets the value of the modifyDate property.
     * 
     * @return
     *     possible object is
     *     {@link ModifyDate }
     *     
     */
    public ModifyDate getModifyDate() {
        return modifyDate;
    }

    /**
     * Sets the value of the modifyDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link ModifyDate }
     *     
     */
    public void setModifyDate(ModifyDate value) {
        this.modifyDate = value;
    }

}