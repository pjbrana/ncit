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
@Table(name = "property_category_tbl", catalog = "rentdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PropertyCategoryTbl.findAll", query = "SELECT p FROM PropertyCategoryTbl p"),
    @NamedQuery(name = "PropertyCategoryTbl.findById", query = "SELECT p FROM PropertyCategoryTbl p WHERE p.id = :id"),
    @NamedQuery(name = "PropertyCategoryTbl.findByName", query = "SELECT p FROM PropertyCategoryTbl p WHERE p.name = :name"),
    @NamedQuery(name = "PropertyCategoryTbl.findByDeleted", query = "SELECT p FROM PropertyCategoryTbl p WHERE p.deleted = :deleted"),
    @NamedQuery(name = "PropertyCategoryTbl.findByCreatedDate", query = "SELECT p FROM PropertyCategoryTbl p WHERE p.createdDate = :createdDate"),
    @NamedQuery(name = "PropertyCategoryTbl.findByModifiedDate", query = "SELECT p FROM PropertyCategoryTbl p WHERE p.modifiedDate = :modifiedDate")})
public class PropertyCategoryTbl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Column(name = "deleted")
    private Short deleted;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryId")
    private List<PropertyTbl> propertyTblList;

    public PropertyCategoryTbl() {
    }

    public PropertyCategoryTbl(Integer id) {
        this.id = id;
    }

    public PropertyCategoryTbl(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @XmlTransient
    public List<PropertyTbl> getPropertyTblList() {
        return propertyTblList;
    }

    public void setPropertyTblList(List<PropertyTbl> propertyTblList) {
        this.propertyTblList = propertyTblList;
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
        if (!(object instanceof PropertyCategoryTbl)) {
            return false;
        }
        PropertyCategoryTbl other = (PropertyCategoryTbl) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ncit.rentmgmt.entities.PropertyCategoryTbl[ id=" + id + " ]";
    }
    
}
