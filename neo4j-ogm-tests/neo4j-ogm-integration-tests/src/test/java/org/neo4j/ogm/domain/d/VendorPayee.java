package org.neo4j.ogm.domain.d;

import java.util.Objects;

import org.neo4j.ogm.annotation.CompositeIndex;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
@CompositeIndex(properties = { "ccnDno", "mgmtDiv", "ccnSuffix" }, unique = true)
public class VendorPayee {

    @Id @GeneratedValue
    private Long id;
    private String ccnDno;
    private String ccnSuffix;
    private String mgmtDiv;
    private String lastUpdatedTs;
    private String lastUpdatedBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCcnDno() {
        return ccnDno;
    }

    public void setCcnDno(String ccnDno) {
        this.ccnDno = ccnDno;
    }

    public String getCcnSuffix() {
        return ccnSuffix;
    }

    public void setCcnSuffix(String ccnSuffix) {
        this.ccnSuffix = ccnSuffix;
    }

    public String getMgmtDiv() {
        return mgmtDiv;
    }

    public void setMgmtDiv(String mgmtDiv) {
        this.mgmtDiv = mgmtDiv;
    }

    public String getLastUpdatedTs() {
        return lastUpdatedTs;
    }

    public void setLastUpdatedTs(String lastUpdatedTs) {
        this.lastUpdatedTs = lastUpdatedTs;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }



    @Override public String toString() {
        return "VendorPayee{" +
            "id=" + id +
            "} " + super.toString();
    }
}
