/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ncit.rentmgmt.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Prashanna
 */
@Entity
@Table(name = "property_tbl", catalog = "rentdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PropertyTbl.findAll", query = "SELECT p FROM PropertyTbl p"),
    @NamedQuery(name = "PropertyTbl.findById", query = "SELECT p FROM PropertyTbl p WHERE p.id = :id"),
    @NamedQuery(name = "PropertyTbl.findByPropertyAddres", query = "SELECT p FROM PropertyTbl p WHERE p.propertyAddres = :propertyAddres"),
    @NamedQuery(name = "PropertyTbl.findByPropertyDescription", query = "SELECT p FROM PropertyTbl p WHERE p.propertyDescription = :propertyDescription"),
    @NamedQuery(name = "PropertyTbl.findByPropertyLeaseType", query = "SELECT p FROM PropertyTbl p WHERE p.propertyLeaseType = :propertyLeaseType"),
    @NamedQuery(name = "PropertyTbl.findByPrice", query = "SELECT p FROM PropertyTbl p WHERE p.price = :price"),
    @NamedQuery(name = "PropertyTbl.findByDeleted", query = "SELECT p FROM PropertyTbl p WHERE p.deleted = :deleted"),
    @NamedQuery(name = "PropertyTbl.findByCreatedDate", query = "SELECT p FROM PropertyTbl p WHERE p.createdDate = :createdDate"),
    @NamedQuery(name = "PropertyTbl.findByModified", query = "SELECT p FROM PropertyTbl p WHERE p.modified = :modified"),
    @NamedQuery(name = "PropertyTbl.findByAvailable", query = "SELECT p FROM PropertyTbl p WHERE p.available = :available")})
public class PropertyTbl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "property_addres")
    private String propertyAddres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "property_description")
    private String propertyDescription;
    @Size(max = 45)
    @Column(name = "property_lease_type")
    private String propertyLeaseType;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private Float price;
    @Column(name = "deleted")
    private Short deleted;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified;
    @Column(name = "available")
    private Short available;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propertyId")
    private List<PropertyBooking> propertyBookingList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propertyId")
    private List<PropertyImages> propertyImagesList;
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PropertyCategoryTbl categoryId;
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UserTbl ownerId;

    public PropertyTbl() {
    }

    public PropertyTbl(Integer id) {
        this.id = id;
    }

    public PropertyTbl(Integer id, String propertyAddres, String propertyDescription) {
        this.id = id;
        this.propertyAddres = propertyAddres;
        this.propertyDescription = propertyDescription;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPropertyAddres() {
        return propertyAddres;
    }

    public void setPropertyAddres(String propertyAddres) {
        this.propertyAddres = propertyAddres;
    }

    public String getPropertyDescription() {
        return propertyDescription;
    }

    public void setPropertyDescription(String propertyDescription) {
        this.propertyDescription = propertyDescription;
    }

    public String getPropertyLeaseType() {
        return propertyLeaseType;
    }

    public void setPropertyLeaseType(String propertyLeaseType) {
        this.propertyLeaseType = propertyLeaseType;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Short getDeleted() {
        return deleted;
    }

    public void setDeleted(Short deleted) {
        this.deleted = deleted;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Short getAvailable() {
        return available;
    }

    public void setAvailable(Short available) {
        this.available = available;
    }

    @XmlTransient
    public List<PropertyBooking> getPropertyBookingList() {
        return propertyBookingList;
    }

    public void setPropertyBookingList(List<PropertyBooking> propertyBookingList) {
        this.propertyBookingList = propertyBookingList;
    }

    @XmlTransient
    public List<PropertyImages> getPropertyImagesList() {
        return propertyImagesList;
    }

    public void setPropertyImagesList(List<PropertyImages> propertyImagesList) {
        this.propertyImagesList = propertyImagesList;
    }

    public PropertyCategoryTbl getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(PropertyCategoryTbl categoryId) {
        this.categoryId = categoryId;
    }

    public UserTbl getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(UserTbl ownerId) {
        this.ownerId = ownerId;
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
        if (!(object instanceof PropertyTbl)) {
            return false;
        }
        PropertyTbl other = (PropertyTbl) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ncit.rentmgmt.entities.PropertyTbl[ id=" + id + " ]";
    }
    
}
