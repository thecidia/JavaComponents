package com.java.components.util;

@SuppressWarnings("unchecked")
public class Tuple {
	private Object[] values;

	public <T> Tuple(T T1) {
		System.out.println("Please use 'Set<?>' or 'List<?>', and not 'Tuple<?>'.");
		this.values = new Object[] { T1 };
	}

	public <T, T2> Tuple(T T1, T2 t2) { this.values = new Object[] { T1, t2 }; }

	public <T, T2, T3> Tuple(T T1, T2 t2, T3 t3) { this.values = new Object[] { T1, t2, t3 }; }

	public <T, T2, T3, T4> Tuple(T T1, T2 t2, T3 t3, T4 t4) { this.values = new Object[] { T1, t2, t3, t4 }; }

	public <T, T2, T3, T4, T5> Tuple(T T1, T2 t2, T3 t3, T4 t4, T5 t5) { this.values = new Object[] { T1, t2, t3, t4, t5 }; }

	public <T, T2, T3, T4, T5, T6> Tuple(T T1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6) { this.values = new Object[] { T1, t2, t3, t4, t5, t6 }; }

	public <T, T2, T3, T4, T5, T6, T7> Tuple(T T1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7) { this.values = new Object[] { T1, t2, t3, t4, t5, t6, t7 }; }

	public <T, T2, T3, T4, T5, T6, T7, T8> Tuple(T T1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8) { this.values = new Object[] { T1, t2, t3, t4, t5, t6, t7, t8 }; }

	public <T> void setItem1(T T1) { values[0] = T1; }

	public <T> T getItem1() { return (T) values[0]; }

	public <T> void setItem2(T T2) { values[1] = T2; }

	public <T> T getItem2() { return (T) values[1]; }

	public <T> void setItem3(T T3) { values[2] = T3; }

	public <T> T getItem3() { return (T) values[2]; }

	public <T> void setItem4(T T4) { values[3] = T4; }

	public <T> T getItem4() { return (T) values[3]; }

	public <T> void setItem5(T T5) { values[4] = T5; }

	public <T> T getItem5() { return (T) values[4]; }

	public <T> void setItem6(T T6) { values[5] = T6; }

	public <T> T getItem6() { return (T) values[5]; }

	public <T> void setItem7(T T7) { values[6] = T7; }

	public <T> T getItem7() { return (T) values[6]; }

	public <T> void setItem8(T T8) { values[7] = T8; }

	public <T> T getItem8() { return (T) values[7]; }
}
