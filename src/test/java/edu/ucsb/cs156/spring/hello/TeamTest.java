package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string(){
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_returns_correct_boolean_if_same_object() {
        Team t1 = new Team("test-team");
        assert(t1.equals(t1));
    }

    @Test
    public void equals_returns_correct_boolean_if_not_correct_instance(){
        Object testObject = new Object();
        Team t1 = new Team("test-team");
        assert(!t1.equals(testObject));
    }

    @Test
    public void equals_returns_correct_boolean_if_different_objects() {
        //T && T
        Team t1 = new Team("test-team");
        Team t2 = new Team("test-team");
        assert(t1.equals(t2));

        //T && F
        Team t3 = new Team("test-team");
        Team t4 = new Team("test-team");
        t3.addMember("member1");
        t4.addMember("member2");
        assert(!t3.equals(t4));

        //F && T
        Team t5 = new Team("test1");
        Team t6 = new Team("test2");
        assert(!t5.equals(t6));

        //F && F
        Team t7 = new Team("test-team");
        Team t8 = new Team("test-team1");
        t7.addMember("member1");
        t8.addMember("member2");
        assert(!t7.equals(t8));

    }

    @Test
    public void hashCode_test(){
        Team t = new Team();
        int result = t.hashCode();
        int expectedResult = 1;
        assertEquals(expectedResult, result);
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
