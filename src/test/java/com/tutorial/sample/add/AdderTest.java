package com.tutorial.sample.add;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class AdderTest {

	Adder adder;
	ArrayList<Adder> st = new ArrayList<Adder>() ;
	
	
	@Before
	public void init() {
	    adder = new Adder();
	    st.add(adder);
	    

	}
	
	@Test
	public void addTest(){
		int r = adder.add(13, 17);
		assertEquals(30, r);
	}
	@After
	public void After(){
		adder=null;
	}

	
	
	
}
