package org.neo4j.ogm.domain.d;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity(type = "HAS_PO_ITEM")
public class HasPOItemVendorPayee {

    @Id @GeneratedValue
    private Long id;

    @StartNode
    private VendorPayee vendorPayee;

    @EndNode
    private POItem poItem;

    public HasPOItemVendorPayee() {
    }

    public HasPOItemVendorPayee(VendorPayee vendorPayee, POItem poItem) {
        this.vendorPayee = vendorPayee;
        this.poItem = poItem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public VendorPayee getVendorPayee() {
        return vendorPayee;
    }

    public void setVendorPayee(VendorPayee vendorPayee) {
        this.vendorPayee = vendorPayee;
    }

    public POItem getPoItem() {
        return poItem;
    }

    public void setPoItem(POItem poItem) {
        this.poItem = poItem;
    }
}
