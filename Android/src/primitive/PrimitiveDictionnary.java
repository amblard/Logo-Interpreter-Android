package primitive;

import java.util.HashMap;
import java.util.Map;


public class PrimitiveDictionnary {

	private Map<String, Primitive> map;
	private Map<String, CustomPrimitive> customs;

	public PrimitiveDictionnary() {
		map = new HashMap<String, Primitive>();
		customs = new HashMap<String, CustomPrimitive>();
	}

	public Primitive get(String name) {
		name = name.toLowerCase();
		if (!map.containsKey(name)) {
			System.out.println("Primitive [" + name + "] not found!");
			return null;
		}
		return map.get(name);
	}

	public CustomPrimitive getCustomPrimitive(String name) {
		name = name.toLowerCase();
		if (!customs.containsKey(name)) {
			return null;
		}
		return customs.get(name);
	}

	public void put(String name, Primitive primitive) {
		name = name.toLowerCase();
		if (!map.containsKey(name)) {
			map.put(name, primitive);
		}
	}

	public void put(String name, CustomPrimitive primitive) {
		name = name.toLowerCase();
		if (!customs.containsKey(name)) {
			customs.put(name, primitive);
		}
	}

}
