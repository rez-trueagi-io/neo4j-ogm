package org.neo4j.ogm.persistence.model;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.context.EntityGraphMapper;
import org.neo4j.ogm.context.EntityMapper;
import org.neo4j.ogm.context.MappingContext;
import org.neo4j.ogm.domain.d.HasPOItemVendorPayee;
import org.neo4j.ogm.domain.d.POItem;
import org.neo4j.ogm.domain.d.VendorPayee;
import org.neo4j.ogm.metadata.MetaData;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.neo4j.ogm.session.event.Event;
import org.neo4j.ogm.session.event.EventListener;
import org.neo4j.ogm.testutil.TestContainersTestBase;

public class UnknownIssueTest extends TestContainersTestBase {

    private static SessionFactory sessionFactory;

    @BeforeClass
    public static void setUpTestDatabase() {

        sessionFactory = new SessionFactory(getDriver(), "org.neo4j.ogm.domain.d");
    }

    @Test
    public void dky() {

        sessionFactory.runAutoIndexManager(new Configuration.Builder().autoIndex("UPDATE").build());

        Session session = sessionFactory.openSession();
        session.purgeDatabase();

        VendorPayee vendorPayee = new VendorPayee();
        vendorPayee.setMgmtDiv("Aa");
        vendorPayee.setCcnDno("AaAa");
        vendorPayee.setCcnSuffix("BB");


        POItem poItem = new POItem();
        poItem.setHasPOItemVendorPayeeSet(new HashSet<>());

        POItem poItem2 = new POItem();
        poItem2.setHasPOItemVendorPayeeSet(new HashSet<>());

        session.save(Arrays.asList(poItem, poItem2, vendorPayee));
        ThreadLocalRandom random = ThreadLocalRandom.current();
        session.clear();
         VendorPayee copy = session.load(VendorPayee.class, vendorPayee.getId());
//VendorPayee copy = vendorPayee;
        System.out.println(vendorPayee.equals(copy));
session.register(new EventListener() {
    @Override public void onPreSave(Event event) {
        if(event.getObject() instanceof VendorPayee) {
            //System.out.println("changed");
           // ((VendorPayee)event.getObject()).setLastUpdatedBy(random.nextInt() +"");
        }
    }

    @Override public void onPostSave(Event event) {

    }

    @Override public void onPreDelete(Event event) {

    }

    @Override public void onPostDelete(Event event) {

    }
});
        System.out.println("-------------------------------------------------------------------------------------- now pain");
        ExecutorService executorService = Executors.newCachedThreadPool();
        int i=0;
//        while(i++<1000) {

            String someValue = "abc" + i;
  //          executorService.submit(() -> {
                //session.clear();
        vendorPayee.setCcnDno("AaBb");
             //   vendorPayee.setLastUpdatedBy(LocalDateTime.now().toString());
                poItem.getHasPOItemVendorPayeeSet().add(new HasPOItemVendorPayee(vendorPayee, poItem));
                poItem.setSomeAttribute(random.nextInt() +"");
     //   copy.setLastUpdatedBy(LocalDateTime.now().toString());
                poItem2.getHasPOItemVendorPayeeSet().add(new HasPOItemVendorPayee(copy, poItem2));
                poItem2.setSomeAttribute(random.nextInt() + "");
                POItem p3 = new POItem();
                p3.setHasPOItemVendorPayeeSet(Collections.singleton(new HasPOItemVendorPayee(vendorPayee, p3)));
                poItem2.setOther(poItem);
                poItem.setOther(poItem2);

                session.save(Arrays.asList(poItem, vendorPayee), 31);
                assertThat(poItem.getId()).isNotNull();
    //        });
        //}
    }
}
