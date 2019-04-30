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
    "account",
    "foreignAccount",
    "date",
    "amount",
    "clubIdOrClubOrOrganisationIdOrOrganisation",
    "personIdOrPerson",
    "entryId",
    "serviceOrderNumberOrServiceIdOrService",
    "modifyDate"
})
@XmlRootElement(name = "Transaction")
public class Transaction {

    @XmlElement(name = "Account", required = true)
    protected Account account;
    @XmlElement(name = "ForeignAccount")
    protected ForeignAccount foreignAccount;
    @XmlElement(name = "Date", required = true)
    protected Date date;
    @XmlElement(name = "Amount", required = true)
    protected Amount amount;
    @XmlElements({
        @XmlElement(name = "ClubId", required = true, type = ClubId.class),
        @XmlElement(name = "Club", required = true, type = Club.class),
        @XmlElement(name = "OrganisationId", required = true, type = OrganisationId.class),
        @XmlElement(name = "Organisation", required = true, type = Organisation.class)
    })
    protected List<Object> clubIdOrClubOrOrganisationIdOrOrganisation;
    @XmlElements({
        @XmlElement(name = "PersonId", type = PersonId.class),
        @XmlElement(name = "Person", type = Person.class)
    })
    protected List<Object> personIdOrPerson;
    @XmlElement(name = "EntryId")
    protected List<EntryId> entryId;
    @XmlElements({
        @XmlElement(name = "ServiceOrderNumber", type = ServiceOrderNumber.class),
        @XmlElement(name = "ServiceId", type = ServiceId.class),
        @XmlElement(name = "Service", type = Service.class)
    })
    protected List<Object> serviceOrderNumberOrServiceIdOrService;
    @XmlElement(name = "ModifyDate")
    protected ModifyDate modifyDate;

    /**
     * Gets the value of the account property.
     * 
     * @return
     *     possible object is
     *     {@link Account }
     *     
     */
    public Account getAccount() {
        return account;
    }

    /**
     * Sets the value of the account property.
     * 
     * @param value
     *     allowed object is
     *     {@link Account }
     *     
     */
    public void setAccount(Account value) {
        this.account = value;
    }

    /**
     * Gets the value of the foreignAccount property.
     * 
     * @return
     *     possible object is
     *     {@link ForeignAccount }
     *     
     */
    public ForeignAccount getForeignAccount() {
        return foreignAccount;
    }

    /**
     * Sets the value of the foreignAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link ForeignAccount }
     *     
     */
    public void setForeignAccount(ForeignAccount value) {
        this.foreignAccount = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setDate(Date value) {
        this.date = value;
    }

    /**
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link Amount }
     *     
     */
    public Amount getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Amount }
     *     
     */
    public void setAmount(Amount value) {
        this.amount = value;
    }

    /**
     * Gets the value of the clubIdOrClubOrOrganisationIdOrOrganisation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the clubIdOrClubOrOrganisationIdOrOrganisation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClubIdOrClubOrOrganisationIdOrOrganisation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClubId }
     * {@link Club }
     * {@link OrganisationId }
     * {@link Organisation }
     * 
     * 
     */
    public List<Object> getClubIdOrClubOrOrganisationIdOrOrganisation() {
        if (clubIdOrClubOrOrganisationIdOrOrganisation == null) {
            clubIdOrClubOrOrganisationIdOrOrganisation = new ArrayList<Object>();
        }
        return this.clubIdOrClubOrOrganisationIdOrOrganisation;
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

    /**
     * Gets the value of the entryId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the entryId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEntryId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntryId }
     * 
     * 
     */
    public List<EntryId> getEntryId() {
        if (entryId == null) {
            entryId = new ArrayList<EntryId>();
        }
        return this.entryId;
    }

    /**
     * Gets the value of the serviceOrderNumberOrServiceIdOrService property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the serviceOrderNumberOrServiceIdOrService property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServiceOrderNumberOrServiceIdOrService().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceOrderNumber }
     * {@link ServiceId }
     * {@link Service }
     * 
     * 
     */
    public List<Object> getServiceOrderNumberOrServiceIdOrService() {
        if (serviceOrderNumberOrServiceIdOrService == null) {
            serviceOrderNumberOrServiceIdOrService = new ArrayList<Object>();
        }
        return this.serviceOrderNumberOrServiceIdOrService;
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
