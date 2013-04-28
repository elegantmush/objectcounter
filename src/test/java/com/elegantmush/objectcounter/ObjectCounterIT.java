package com.elegantmush.objectcounter;

import static org.junit.Assert.*;

import org.junit.Test;

import com.elegantmush.objectcounter.data.ObjectA;
import com.elegantmush.objectcounter.data.ObjectB;
import com.elegantmush.objectcounter.data.ObjectC;
import com.elegantmush.objectcounter.data.ObjectD;

public class ObjectCounterIT {

	@Test
	public void test() throws Exception {
		// create some objects
		ObjectA objA1 = new ObjectA();
		ObjectA objA2 = new ObjectA();
		ObjectB objB1 = new ObjectB();

		// see whether they've been recorded in the registry
		ObjectRegistry registry = ObjectRegistry.INSTANCE;
		assertEquals("count of ObjectA instances", Integer.valueOf(2),
				registry.get(ObjectA.class.getName()));
		assertEquals("count of ObjectB instances", Integer.valueOf(1),
				registry.get(ObjectB.class.getName()));

		Thread.sleep(3000);

		ObjectB objB2 = new ObjectB();
		// instantiate one object without assignment
		new ObjectB();
		// instantiate objects in an inheritance hierarchy
		ObjectC objC1 = new ObjectC();
		ObjectD objD1 = new ObjectD();
		Thread.sleep(3000);
		
		assertEquals("2nd count of ObjectA instances", Integer.valueOf(2),
				registry.get(ObjectA.class.getName()));
		assertEquals("2nd count of ObjectB instances", Integer.valueOf(3),
				registry.get(ObjectB.class.getName()));
		assertEquals("count of ObjectC instances", Integer.valueOf(1),
				registry.get(ObjectC.class.getName()));
		assertEquals("count of ObjectD instances", Integer.valueOf(1),
				registry.get(ObjectD.class.getName()));

		
	}

}
