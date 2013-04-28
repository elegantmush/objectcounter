package com.elegantmush.objectcounter.aspect;

import com.elegantmush.objectcounter.*;

public aspect CounterAspect {

	private ObjectRegistry objectRegistry = ObjectRegistry.INSTANCE;

	// capture all calls to object instantiation, excluding this aspect and the enum where
	// we're storing the object counts.
	after() returning: call(*.new(..)) && !within(CounterAspect) && !within(ObjectRegistry) {

		String objType = thisJoinPointStaticPart.getSignature().toString().replaceAll("\\(\\)", "");
		Integer count = objectRegistry.putIfAbsent(objType, Integer.valueOf(1));
		if (count != null) {
			objectRegistry.put(objType, ++count);
		}
	}

}
