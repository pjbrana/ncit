/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ncit.rentmgmt.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Prashanna
 */
@Entity
@Table(name = "property_booking", catalog = "rentdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PropertyBooking.findAll", query = "SELECT p FROM PropertyBooking p"),
    @NamedQuery(name = "PropertyBooking.findById", query = "SELECT p FROM PropertyBooking p WHERE p.id = :id"),
    @NamedQuery(name = "PropertyBooking.findByCreatedDate", query = "SELECT p FROM PropertyBooking p WHERE p.createdDate = :createdDate"),
    @NamedQuery(name = "PropertyBooking.findByModifiedDate", query = "SELECT p FROM PropertyBooking p WHERE p.modifiedDate = :modifiedDate"),
    @NamedQuery(name = "PropertyBooking.findByDeleted", query = "SELECT p FROM PropertyBooking p WHERE p.deleted = :deleted"),
    @NamedQuery(name = "PropertyBooking.findByBookingDurationMonths", query = "SELECT p FROM PropertyBooking p WHERE p.bookingDurationMonths = :bookingDurationMonths")})
public class PropertyBooking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @Column(name = "deleted")
    private Short deleted;
    @Column(name = "booking_duration_months")
    private Integer bookingDurationMonths;
    @JoinColumn(name = "property_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PropertyTbl propertyId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UserTbl userId;

    public PropertyBooking() {
    }

    public PropertyBooking(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Short getDeleted() {
        return deleted;
    }

    public void setDeleted(Short deleted) {
        this.deleted = deleted;
    }

    public Integer getBookingDurationMonths() {
        return bookingDurationMonths;
    }

    public void setBookingDurationMonths(Integer bookingDurationMonths) {
        this.bookingDurationMonths = bookingDurationMonths;
    }

    public PropertyTbl getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(PropertyTbl propertyId) {
        this.propertyId = propertyId;
    }

    public UserTbl getUserId() {
        return userId;
    }

    public void setUserId(UserTbl userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PropertyBooking)) {
            return false;
        }
        PropertyBooking other = (PropertyBooking) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ncit.rentmgmt.entities.PropertyBooking[ id=" + id + " ]";
    }
    
}
