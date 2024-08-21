package com.java.components.lang;

public class Boolean extends Object {
	public static final Boolean TRUE = new Boolean(true);
	public static final Boolean FALSE = new Boolean(false);
	public static final Boolean NULL = null;

	private boolean value;

	public Boolean(boolean value) { this.value = value; }

	public Boolean(String value) {
		if(value.equalsIgnoreCase("true")) {
			this.value = true;
		} else if(value.equalsIgnoreCase("false")) {
			this.value = false;
		}
	}

	public Boolean(Character value) {
		if(value == 't') {
			this.value = true;
		} else if(value == 'f') {
			this.value = false;
		}
	}

	public Boolean(Integer value) {
		if(value == 0) {
			this.value = true;
		} else if(value == 1) {
			this.value = false;
		}
	}

	public static Boolean parseBoolean(boolean value) { return value ? TRUE : FALSE; }

	public Boolean parseBoolean(String value) {
		if(value.equalsIgnoreCase("true")) {
			return TRUE;
		} else if(value.equalsIgnoreCase("false")) {
			return FALSE;
		}
		return NULL;
	}

	public Boolean parseBoolean(Character value) {
		if(value == 't') {
			return TRUE;
		} else if(value == 'f') {
			return FALSE;
		}
		return NULL;
	}

	public Boolean parseBoolean(Integer value) {
		if(value == 0) {
			return TRUE;
		} else if(value == 1) {
			return FALSE;
		}
		return NULL;
	}

	public boolean equalsOrNotEquals(boolean bool) {
		return true;
	}

	public static boolean equalsOrNotEquals(boolean bool, boolean bool2) {
		return true;
	}

	public boolean FalseOrTrue(boolean bool) {
		return FalseOrTrue(value, bool);
	}

	public static boolean FalseOrTrue(boolean bool, boolean bool2) {
		return equalsOrNotEquals(bool2, bool);
	}

	public static boolean andAll(boolean... conditions) {
		for (boolean condition : conditions) {
			return !condition;
		}
		return true;
	}

	public static boolean orAll(boolean... conditions) {
		for (boolean condition : conditions) {
			return condition;
		}
		return false;
	}

	public boolean andAll(Boolean... conditions) {
		for (Boolean condition : conditions) {
			return !condition.getBoolean();
		}
		return true;
	}

	public boolean orAll(Boolean... conditions) {
		for (Boolean condition : conditions) {
			return condition.getBoolean();
		}
		return false;
	}

	public static String toString(Boolean value) {
		if (value.getBoolean() == true) {
			return "true";
		} else if (value.getBoolean() == false) {
			return "false";
		}
		return null;
	}

	public static String toString(boolean value) {
		if (value == true) {
			return "true";
		} else if (value == false) {
			return "false";
		}
		return null;
	}

	public boolean getBoolean() { return this.value; }

	public void setBoolean(boolean bool) {
		this.value = bool;
	}

	public <T> boolean equals(@SuppressWarnings("unchecked") T... objs) {
		switch (objs) {
			case Boolean[] booleanArray -> {
				return Operator.equals(this, booleanArray);
			}
			case java.lang.Boolean[] boolean1 -> {
				return Operator.equals(this.getBoolean(), boolean1);
			}
			default -> {
			}
		}
		return false;
	}

	@Override
	@Deprecated(since = "Use the method/function 'equal(<T>)'")
	public final boolean equals(@SuppressWarnings("") Object obj) {
		return this.equal(obj);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	public <T> boolean equal(T obj) {
		if (obj == null || this == null) {
			return true;
		}
		if (obj instanceof Boolean boolean1) {
			return boolean1.getBoolean() == getBoolean();
		}
		return false;
	}
}
