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
    "nameOrOrganisationIdOrOrganisation",
    "rankPosition",
    "rankValue",
    "validFromDate",
    "validToDate",
    "modifyDate"
})
@XmlRootElement(name = "Rank")
public class Rank {

    @XmlElements({
        @XmlElement(name = "Name", required = true, type = Name.class),
        @XmlElement(name = "OrganisationId", required = true, type = OrganisationId.class),
        @XmlElement(name = "Organisation", required = true, type = Organisation.class)
    })
    protected List<Object> nameOrOrganisationIdOrOrganisation;
    @XmlElement(name = "RankPosition", required = true)
    protected String rankPosition;
    @XmlElement(name = "RankValue", required = true)
    protected String rankValue;
    @XmlElement(name = "ValidFromDate")
    protected ValidFromDate validFromDate;
    @XmlElement(name = "ValidToDate")
    protected ValidToDate validToDate;
    @XmlElement(name = "ModifyDate")
    protected ModifyDate modifyDate;

    /**
     * Gets the value of the nameOrOrganisationIdOrOrganisation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nameOrOrganisationIdOrOrganisation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNameOrOrganisationIdOrOrganisation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Name }
     * {@link OrganisationId }
     * {@link Organisation }
     * 
     * 
     */
    public List<Object> getNameOrOrganisationIdOrOrganisation() {
        if (nameOrOrganisationIdOrOrganisation == null) {
            nameOrOrganisationIdOrOrganisation = new ArrayList<Object>();
        }
        return this.nameOrOrganisationIdOrOrganisation;
    }

    /**
     * Gets the value of the rankPosition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRankPosition() {
        return rankPosition;
    }

    /**
     * Sets the value of the rankPosition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRankPosition(String value) {
        this.rankPosition = value;
    }

    /**
     * Gets the value of the rankValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRankValue() {
        return rankValue;
    }

    /**
     * Sets the value of the rankValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRankValue(String value) {
        this.rankValue = value;
    }

    /**
     * Gets the value of the validFromDate property.
     * 
     * @return
     *     possible object is
     *     {@link ValidFromDate }
     *     
     */
    public ValidFromDate getValidFromDate() {
        return validFromDate;
    }

    /**
     * Sets the value of the validFromDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link ValidFromDate }
     *     
     */
    public void setValidFromDate(ValidFromDate value) {
        this.validFromDate = value;
    }

    /**
     * Gets the value of the validToDate property.
     * 
     * @return
     *     possible object is
     *     {@link ValidToDate }
     *     
     */
    public ValidToDate getValidToDate() {
        return validToDate;
    }

    /**
     * Sets the value of the validToDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link ValidToDate }
     *     
     */
    public void setValidToDate(ValidToDate value) {
        this.validToDate = value;
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
