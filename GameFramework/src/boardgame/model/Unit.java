package boardgame.model;

import java.util.HashMap;

public abstract class Unit {
	public String type;
	public HashMap<String, Object> properties;
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}
	
	public void setProperty(String prop, Object value) {
		properties.put(prop, value);
	}
}
