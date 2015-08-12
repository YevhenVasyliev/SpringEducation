//package com.epam.repository.event;
//
//import com.epam.entity.Event;
//import com.epam.repository.event.api.EventDAO;
//import org.junit.Before;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import static junit.framework.Assert.assertEquals;
//
///**
// * Created by Yevhen_Vasyliev on 12.08.2015.
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:/appConfig.xml", "classpath:/appConfigTest.xml"})
//public class EventDAOImplTest {
//
//    @Autowired
//    private EventDAO eventDAO;
//
//    @Autowired
//    @Qualifier("event_1")
//    private Event event;
//
//    private Event resultEvent;
//
//    @Before
//    public void setUp() {
//    }
//}
