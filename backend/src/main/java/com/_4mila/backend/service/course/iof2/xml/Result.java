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
    "startNumber",
    "bibNumber",
    "cCardIdOrCCard",
    "startTime",
    "finishTime",
    "time",
    "resultPosition",
    "competitorStatus",
    "teamSequence",
    "courseVariationIdOrCourseVariationOrCourseLength",
    "splitTime",
    "badgeValueIdOrBadgeValue",
    "point",
    "modifyDate"
})
@XmlRootElement(name = "Result")
public class Result {

    @XmlElement(name = "StartNumber")
    protected String startNumber;
    @XmlElement(name = "BibNumber")
    protected String bibNumber;
    @XmlElements({
        @XmlElement(name = "CCardId", type = CCardId.class),
        @XmlElement(name = "CCard", type = CCard.class)
    })
    protected List<Object> cCardIdOrCCard;
    @XmlElement(name = "StartTime")
    protected StartTime startTime;
    @XmlElement(name = "FinishTime")
    protected FinishTime finishTime;
    @XmlElement(name = "Time")
    protected Time time;
    @XmlElement(name = "ResultPosition")
    protected String resultPosition;
    @XmlElement(name = "CompetitorStatus", required = true)
    protected CompetitorStatus competitorStatus;
    @XmlElement(name = "TeamSequence")
    protected TeamSequence teamSequence;
    @XmlElements({
        @XmlElement(name = "CourseVariationId", type = CourseVariationId.class),
        @XmlElement(name = "CourseVariation", type = CourseVariation.class),
        @XmlElement(name = "CourseLength", type = CourseLength.class)
    })
    protected List<Object> courseVariationIdOrCourseVariationOrCourseLength;
    @XmlElement(name = "SplitTime")
    protected List<SplitTime> splitTime;
    @XmlElements({
        @XmlElement(name = "BadgeValueId", type = BadgeValueId.class),
        @XmlElement(name = "BadgeValue", type = BadgeValue.class)
    })
    protected List<Object> badgeValueIdOrBadgeValue;
    @XmlElement(name = "Point")
    protected List<Point> point;
    @XmlElement(name = "ModifyDate")
    protected ModifyDate modifyDate;

    /**
     * Gets the value of the startNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartNumber() {
        return startNumber;
    }

    /**
     * Sets the value of the startNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartNumber(String value) {
        this.startNumber = value;
    }

    /**
     * Gets the value of the bibNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBibNumber() {
        return bibNumber;
    }

    /**
     * Sets the value of the bibNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBibNumber(String value) {
        this.bibNumber = value;
    }

    /**
     * Gets the value of the cCardIdOrCCard property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cCardIdOrCCard property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCCardIdOrCCard().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CCardId }
     * {@link CCard }
     * 
     * 
     */
    public List<Object> getCCardIdOrCCard() {
        if (cCardIdOrCCard == null) {
            cCardIdOrCCard = new ArrayList<Object>();
        }
        return this.cCardIdOrCCard;
    }

    /**
     * Gets the value of the startTime property.
     * 
     * @return
     *     possible object is
     *     {@link StartTime }
     *     
     */
    public StartTime getStartTime() {
        return startTime;
    }

    /**
     * Sets the value of the startTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link StartTime }
     *     
     */
    public void setStartTime(StartTime value) {
        this.startTime = value;
    }

    /**
     * Gets the value of the finishTime property.
     * 
     * @return
     *     possible object is
     *     {@link FinishTime }
     *     
     */
    public FinishTime getFinishTime() {
        return finishTime;
    }

    /**
     * Sets the value of the finishTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link FinishTime }
     *     
     */
    public void setFinishTime(FinishTime value) {
        this.finishTime = value;
    }

    /**
     * Gets the value of the time property.
     * 
     * @return
     *     possible object is
     *     {@link Time }
     *     
     */
    public Time getTime() {
        return time;
    }

    /**
     * Sets the value of the time property.
     * 
     * @param value
     *     allowed object is
     *     {@link Time }
     *     
     */
    public void setTime(Time value) {
        this.time = value;
    }

    /**
     * Gets the value of the resultPosition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResultPosition() {
        return resultPosition;
    }

    /**
     * Sets the value of the resultPosition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResultPosition(String value) {
        this.resultPosition = value;
    }

    /**
     * Gets the value of the competitorStatus property.
     * 
     * @return
     *     possible object is
     *     {@link CompetitorStatus }
     *     
     */
    public CompetitorStatus getCompetitorStatus() {
        return competitorStatus;
    }

    /**
     * Sets the value of the competitorStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompetitorStatus }
     *     
     */
    public void setCompetitorStatus(CompetitorStatus value) {
        this.competitorStatus = value;
    }

    /**
     * Gets the value of the teamSequence property.
     * 
     * @return
     *     possible object is
     *     {@link TeamSequence }
     *     
     */
    public TeamSequence getTeamSequence() {
        return teamSequence;
    }

    /**
     * Sets the value of the teamSequence property.
     * 
     * @param value
     *     allowed object is
     *     {@link TeamSequence }
     *     
     */
    public void setTeamSequence(TeamSequence value) {
        this.teamSequence = value;
    }

    /**
     * Gets the value of the courseVariationIdOrCourseVariationOrCourseLength property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the courseVariationIdOrCourseVariationOrCourseLength property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCourseVariationIdOrCourseVariationOrCourseLength().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CourseVariationId }
     * {@link CourseVariation }
     * {@link CourseLength }
     * 
     * 
     */
    public List<Object> getCourseVariationIdOrCourseVariationOrCourseLength() {
        if (courseVariationIdOrCourseVariationOrCourseLength == null) {
            courseVariationIdOrCourseVariationOrCourseLength = new ArrayList<Object>();
        }
        return this.courseVariationIdOrCourseVariationOrCourseLength;
    }

    /**
     * Gets the value of the splitTime property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the splitTime property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSplitTime().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SplitTime }
     * 
     * 
     */
    public List<SplitTime> getSplitTime() {
        if (splitTime == null) {
            splitTime = new ArrayList<SplitTime>();
        }
        return this.splitTime;
    }

    /**
     * Gets the value of the badgeValueIdOrBadgeValue property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the badgeValueIdOrBadgeValue property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBadgeValueIdOrBadgeValue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BadgeValueId }
     * {@link BadgeValue }
     * 
     * 
     */
    public List<Object> getBadgeValueIdOrBadgeValue() {
        if (badgeValueIdOrBadgeValue == null) {
            badgeValueIdOrBadgeValue = new ArrayList<Object>();
        }
        return this.badgeValueIdOrBadgeValue;
    }

    /**
     * Gets the value of the point property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the point property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Point }
     * 
     * 
     */
    public List<Point> getPoint() {
        if (point == null) {
            point = new ArrayList<Point>();
        }
        return this.point;
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
