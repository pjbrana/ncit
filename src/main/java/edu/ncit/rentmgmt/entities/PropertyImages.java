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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Prashanna
 */
@Entity
@Table(name = "property_images", catalog = "rentdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PropertyImages.findAll", query = "SELECT p FROM PropertyImages p"),
    @NamedQuery(name = "PropertyImages.findById", query = "SELECT p FROM PropertyImages p WHERE p.id = :id"),
    @NamedQuery(name = "PropertyImages.findByPropertyImages", query = "SELECT p FROM PropertyImages p WHERE p.propertyImages = :propertyImages"),
    @NamedQuery(name = "PropertyImages.findByCreatedDate", query = "SELECT p FROM PropertyImages p WHERE p.createdDate = :createdDate"),
    @NamedQuery(name = "PropertyImages.findByModifiedDate", query = "SELECT p FROM PropertyImages p WHERE p.modifiedDate = :modifiedDate")})
public class PropertyImages implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "property_images")
    private String propertyImages;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "property_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PropertyTbl propertyId;

    public PropertyImages() {
    }

    public PropertyImages(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPropertyImages() {
        return propertyImages;
    }

    public void setPropertyImages(String propertyImages) {
        this.propertyImages = propertyImages;
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

    public PropertyTbl getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(PropertyTbl propertyId) {
        this.propertyId = propertyId;
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
        if (!(object instanceof PropertyImages)) {
            return false;
        }
        PropertyImages other = (PropertyImages) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ncit.rentmgmt.entities.PropertyImages[ id=" + id + " ]";
    }
    
}
