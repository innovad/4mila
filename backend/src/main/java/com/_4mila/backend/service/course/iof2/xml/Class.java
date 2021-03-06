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
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "classId",
    "name",
    "classShortName",
    "classTypeIdOrClassType",
    "substituteClass",
    "notQualifiedSubstituteClass",
    "entryFeeIdOrEntryFee",
    "modifyDate"
})
@XmlRootElement(name = "Class")
public class Class {

    @XmlAttribute
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String lowAge;
    @XmlAttribute
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String highAge;
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String sex;
    @XmlAttribute
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String numberInTeam;
    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String teamEntry;
    @XmlAttribute
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String maxNumberInClass;
    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String actualForRanking;
    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String timePresentation;
    @XmlAttribute
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String allowedMinAge;
    @XmlAttribute
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String allowedMaxAge;
    @XmlElement(name = "ClassId", required = true)
    protected ClassId classId;
    @XmlElement(name = "Name")
    protected Name name;
    @XmlElement(name = "ClassShortName", required = true)
    protected ClassShortName classShortName;
    @XmlElements({
        @XmlElement(name = "ClassTypeId", type = ClassTypeId.class),
        @XmlElement(name = "ClassType", type = ClassType.class)
    })
    protected List<Object> classTypeIdOrClassType;
    @XmlElement(name = "SubstituteClass")
    protected SubstituteClass substituteClass;
    @XmlElement(name = "NotQualifiedSubstituteClass")
    protected NotQualifiedSubstituteClass notQualifiedSubstituteClass;
    @XmlElements({
        @XmlElement(name = "EntryFeeId", type = EntryFeeId.class),
        @XmlElement(name = "EntryFee", type = EntryFee.class)
    })
    protected List<Object> entryFeeIdOrEntryFee;
    @XmlElement(name = "ModifyDate")
    protected ModifyDate modifyDate;

    /**
     * Gets the value of the lowAge property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLowAge() {
        return lowAge;
    }

    /**
     * Sets the value of the lowAge property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLowAge(String value) {
        this.lowAge = value;
    }

    /**
     * Gets the value of the highAge property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHighAge() {
        return highAge;
    }

    /**
     * Sets the value of the highAge property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHighAge(String value) {
        this.highAge = value;
    }

    /**
     * Gets the value of the sex property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSex() {
        return sex;
    }

    /**
     * Sets the value of the sex property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSex(String value) {
        this.sex = value;
    }

    /**
     * Gets the value of the numberInTeam property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumberInTeam() {
        if (numberInTeam == null) {
            return "1";
        } else {
            return numberInTeam;
        }
    }

    /**
     * Sets the value of the numberInTeam property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberInTeam(String value) {
        this.numberInTeam = value;
    }

    /**
     * Gets the value of the teamEntry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTeamEntry() {
        if (teamEntry == null) {
            return "N";
        } else {
            return teamEntry;
        }
    }

    /**
     * Sets the value of the teamEntry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTeamEntry(String value) {
        this.teamEntry = value;
    }

    /**
     * Gets the value of the maxNumberInClass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaxNumberInClass() {
        return maxNumberInClass;
    }

    /**
     * Sets the value of the maxNumberInClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaxNumberInClass(String value) {
        this.maxNumberInClass = value;
    }

    /**
     * Gets the value of the actualForRanking property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActualForRanking() {
        if (actualForRanking == null) {
            return "N";
        } else {
            return actualForRanking;
        }
    }

    /**
     * Sets the value of the actualForRanking property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActualForRanking(String value) {
        this.actualForRanking = value;
    }

    /**
     * Gets the value of the timePresentation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimePresentation() {
        if (timePresentation == null) {
            return "Y";
        } else {
            return timePresentation;
        }
    }

    /**
     * Sets the value of the timePresentation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimePresentation(String value) {
        this.timePresentation = value;
    }

    /**
     * Gets the value of the allowedMinAge property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAllowedMinAge() {
        return allowedMinAge;
    }

    /**
     * Sets the value of the allowedMinAge property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAllowedMinAge(String value) {
        this.allowedMinAge = value;
    }

    /**
     * Gets the value of the allowedMaxAge property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAllowedMaxAge() {
        return allowedMaxAge;
    }

    /**
     * Sets the value of the allowedMaxAge property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAllowedMaxAge(String value) {
        this.allowedMaxAge = value;
    }

    /**
     * Gets the value of the classId property.
     * 
     * @return
     *     possible object is
     *     {@link ClassId }
     *     
     */
    public ClassId getClassId() {
        return classId;
    }

    /**
     * Sets the value of the classId property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClassId }
     *     
     */
    public void setClassId(ClassId value) {
        this.classId = value;
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
     * Gets the value of the classShortName property.
     * 
     * @return
     *     possible object is
     *     {@link ClassShortName }
     *     
     */
    public ClassShortName getClassShortName() {
        return classShortName;
    }

    /**
     * Sets the value of the classShortName property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClassShortName }
     *     
     */
    public void setClassShortName(ClassShortName value) {
        this.classShortName = value;
    }

    /**
     * Gets the value of the classTypeIdOrClassType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the classTypeIdOrClassType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClassTypeIdOrClassType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClassTypeId }
     * {@link ClassType }
     * 
     * 
     */
    public List<Object> getClassTypeIdOrClassType() {
        if (classTypeIdOrClassType == null) {
            classTypeIdOrClassType = new ArrayList<Object>();
        }
        return this.classTypeIdOrClassType;
    }

    /**
     * Gets the value of the substituteClass property.
     * 
     * @return
     *     possible object is
     *     {@link SubstituteClass }
     *     
     */
    public SubstituteClass getSubstituteClass() {
        return substituteClass;
    }

    /**
     * Sets the value of the substituteClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubstituteClass }
     *     
     */
    public void setSubstituteClass(SubstituteClass value) {
        this.substituteClass = value;
    }

    /**
     * Gets the value of the notQualifiedSubstituteClass property.
     * 
     * @return
     *     possible object is
     *     {@link NotQualifiedSubstituteClass }
     *     
     */
    public NotQualifiedSubstituteClass getNotQualifiedSubstituteClass() {
        return notQualifiedSubstituteClass;
    }

    /**
     * Sets the value of the notQualifiedSubstituteClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link NotQualifiedSubstituteClass }
     *     
     */
    public void setNotQualifiedSubstituteClass(NotQualifiedSubstituteClass value) {
        this.notQualifiedSubstituteClass = value;
    }

    /**
     * Gets the value of the entryFeeIdOrEntryFee property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the entryFeeIdOrEntryFee property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEntryFeeIdOrEntryFee().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntryFeeId }
     * {@link EntryFee }
     * 
     * 
     */
    public List<Object> getEntryFeeIdOrEntryFee() {
        if (entryFeeIdOrEntryFee == null) {
            entryFeeIdOrEntryFee = new ArrayList<Object>();
        }
        return this.entryFeeIdOrEntryFee;
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
