package com.elegantmush.objectcounter.aspect;

import com.elegantmush.objectcounter.*;

public aspect CounterAspect {

	private ObjectRegistry objectRegistry = ObjectRegistry.INSTANCE;

	after(final Object obj) returning: initialization (*.new(..)) 
										&& !within(CounterAspect) 
										&& !within(*IT)
										&& !within(ObjectRegistry)
										&& this(obj){
		String objType = obj.getClass().getName();
		Integer count = objectRegistry.putIfAbsent(objType, Integer.valueOf(1));
		if (count != null)
			objectRegistry.put(objType, ++count);
	}

}
