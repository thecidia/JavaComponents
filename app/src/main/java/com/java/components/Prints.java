package com.java.components;

@SuppressWarnings("static-access")
public class Prints {
	public static Prints print(String string) {
		System.out.print(string);
		return new Prints();
	}
	public static String printr(String string) {
		print(string);
		return string;
	}
	public static Prints print(Object obj) { return print(obj.toString()); }
	public static Prints print(Boolean bool) { return print(bool.toString()); }
	public static Prints print(boolean b) { return print(((Object) b).toString()); }
	public static Prints print(Character character) { return print(character.toString()); }
	public static Prints print(char c) { return print(((Object) c).toString()); }
	public static Prints print(Short short1) { return print(short1.toString()); }
	public static Prints print(short srt) { return print(((Object) srt).toString()); }
	public static Prints print(Byte byte1) { return print(byte1.toString()); }
	public static Prints print(byte bte) { return print(((Object) bte).toString()); }
	public static Prints print(Integer integer) { return print(integer.toString()); }
	public static Prints print(int i) { return print(((Object) i).toString()); }
	public static Prints print(Long long1) { return print(long1.toString()); }
	public static Prints print(long l) { return print(((Object) l).toString()); }
	public static Prints print(Float float1) { return print(float1.toString()); }
	public static Prints print(float f) { return print(((Object) f).toString()); }
	public static Prints print(Double double1) { return print(double1.toString()); }
	public static Prints print(double d) { return print(((Object) d).toString()); }

	public static Prints prints(String... strs) {
		for (String str : strs) {
			print(str);
		}
		return new Prints();
	}
	public static Prints prints(Object... objs) {
		return prints(objs.toString());
	}

	public static Prints println() {
		return print("\n");
	}

	public static Prints println(String str) {
		print(str).print("\n");
		return new Prints();
	}

	public static Prints printsln(String... strs) {
		for (String str : strs) {
			print(str);
		}
		println();
		return new Prints();
	}

	public static Prints printlns(String... strs) {
		for (String str : strs) {
			print(str).println();
		}
		return new Prints();
	}
}