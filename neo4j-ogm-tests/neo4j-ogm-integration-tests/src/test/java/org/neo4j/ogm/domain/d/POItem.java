package org.neo4j.ogm.domain.d;

import java.util.Set;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class POItem {

    @Id @GeneratedValue
    private Long id;

    @Relationship(type = "HAS_PO_ITEM", direction = Relationship.INCOMING)
    private Set<HasPOItemVendorPayee> hasPOItemVendorPayeeSet;

    private String someAttribute;

    @Relationship(type = "WHATVER")
    private POItem other;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<HasPOItemVendorPayee> getHasPOItemVendorPayeeSet() {
        return hasPOItemVendorPayeeSet;
    }

    public void setHasPOItemVendorPayeeSet(Set<HasPOItemVendorPayee> hasPOItemVendorPayeeSet) {
        this.hasPOItemVendorPayeeSet = hasPOItemVendorPayeeSet;
    }

    public String getSomeAttribute() {
        return someAttribute;
    }

    public void setSomeAttribute(String someAttribute) {
        this.someAttribute = someAttribute;
    }

    public POItem getOther() {
        return other;
    }

    public void setOther(POItem other) {
        this.other = other;
    }
}
