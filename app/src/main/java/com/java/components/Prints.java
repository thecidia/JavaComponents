package com.java.components;

@SuppressWarnings("static-access")
public class Prints {
	public static Prints print(String string) {
		System.out.print(string);
		return new Prints();
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
	public static Prints prints(Object... objs) { return prints((String[]) objs); }
	public static Prints prints(Boolean... bool) { return print((Object[]) bool); }
	public static Prints prints(boolean... b) { return print(objectArray(b)); }
	public static Prints prints(Character... character) { return print((Object[]) character); }
	public static Prints prints(char... c) { return print(objectArray(c)); }
	public static Prints prints(Short... short1) { return print((Object[]) short1); }
	public static Prints prints(short... srt) { return print(objectArray(srt)); }
	public static Prints prints(Byte... byte1) { return print((Object[]) byte1); }
	public static Prints prints(byte... bte) { return print(objectArray(bte)); }
	public static Prints prints(Integer... integer) { return print((Object[]) integer); }
	public static Prints prints(int... i) { return print(objectArray(i)); }
	public static Prints prints(Long... long1) { return print((Object[]) long1); }
	public static Prints prints(long... l) { return print(objectArray(l)); }
	public static Prints prints(Float... float1) { return print((Object[]) float1); }
	public static Prints prints(float... f) { return print(objectArray(f)); }
	public static Prints prints(Double... double1) { return print((Object[])  double1); }
	public static Prints prints(double... d) { return print(objectArray(d)); }
	private static Object[] objectArray(Object... objs) { return objs; }

	public static Prints println() { return print("\n"); }

	public static Prints println(String str) {
		print(str).print("\n");
		return new Prints();
	}
	public static Prints println(Object obj) { return println(obj.toString()); }
	public static Prints println(Boolean bool) { return println(bool.toString()); }
	public static Prints println(boolean b) { return println(((Object) b).toString()); }
	public static Prints println(Character character) { return println(character.toString()); }
	public static Prints println(char c) { return println(((Object) c).toString()); }
	public static Prints println(Short short1) { return println(short1.toString()); }
	public static Prints println(short srt) { return println(((Object) srt).toString()); }
	public static Prints println(Byte byte1) { return println(byte1.toString()); }
	public static Prints println(byte bte) { return println(((Object) bte).toString()); }
	public static Prints println(Integer integer) { return println(integer.toString()); }
	public static Prints println(int i) { return println(((Object) i).toString()); }
	public static Prints println(Long long1) { return println(long1.toString()); }
	public static Prints println(long l) { return println(((Object) l).toString()); }
	public static Prints println(Float float1) { return println(float1.toString()); }
	public static Prints println(float f) { return println(((Object) f).toString()); }
	public static Prints println(Double double1) { return println(double1.toString()); }
	public static Prints println(double d) { return println(((Object) d).toString()); }

	public static Prints printsln(String... strs) {
		for (String str : strs) {
			print(str);
		}
		println();
		return new Prints();
	}
	public static Prints printsln(Object obj) { return printsln(obj.toString()); }
	public static Prints printsln(Boolean bool) { return printsln(bool.toString()); }
	public static Prints printsln(boolean b) { return printsln(((Object) b).toString()); }
	public static Prints printsln(Character character) { return printsln(character.toString()); }
	public static Prints printsln(char c) { return printsln(((Object) c).toString()); }
	public static Prints printsln(Short short1) { return printsln(short1.toString()); }
	public static Prints printsln(short srt) { return printsln(((Object) srt).toString()); }
	public static Prints printsln(Byte byte1) { return printsln(byte1.toString()); }
	public static Prints printsln(byte bte) { return printsln(((Object) bte).toString()); }
	public static Prints printsln(Integer integer) { return printsln(integer.toString()); }
	public static Prints printsln(int i) { return printsln(((Object) i).toString()); }
	public static Prints printsln(Long long1) { return printsln(long1.toString()); }
	public static Prints printsln(long l) { return printsln(((Object) l).toString()); }
	public static Prints printsln(Float float1) { return printsln(float1.toString()); }
	public static Prints printsln(float f) { return printsln(((Object) f).toString()); }
	public static Prints printsln(Double double1) { return printsln(double1.toString()); }
	public static Prints printsln(double d) { return printsln(((Object) d).toString()); }

	public static Prints printlns(String... strs) {
		for (String str : strs) {
			print(str).println();
		}
		return new Prints();
	}
	public static Prints printlns(Object obj) { return printlns(obj.toString()); }
	public static Prints printlns(Boolean bool) { return printlns(bool.toString()); }
	public static Prints printlns(boolean b) { return printlns(((Object) b).toString()); }
	public static Prints printlns(Character character) { return printlns(character.toString()); }
	public static Prints printlns(char c) { return printlns(((Object) c).toString()); }
	public static Prints printlns(Short short1) { return printlns(short1.toString()); }
	public static Prints printlns(short srt) { return printlns(((Object) srt).toString()); }
	public static Prints printlns(Byte byte1) { return printlns(byte1.toString()); }
	public static Prints printlns(byte bte) { return printlns(((Object) bte).toString()); }
	public static Prints printlns(Integer integer) { return printlns(integer.toString()); }
	public static Prints printlns(int i) { return printlns(((Object) i).toString()); }
	public static Prints printlns(Long long1) { return printlns(long1.toString()); }
	public static Prints printlns(long l) { return printlns(((Object) l).toString()); }
	public static Prints printlns(Float float1) { return printlns(float1.toString()); }
	public static Prints printlns(float f) { return printlns(((Object) f).toString()); }
	public static Prints printlns(Double double1) { return printlns(double1.toString()); }
	public static Prints printlns(double d) { return printlns(((Object) d).toString()); }

	public static String printr(String string) {
		print(string);
		return string;
	}
	public static Object printr(Object obj) {
		print(obj);
		return obj;
	}
	public static Boolean printr(Boolean bool) {
		print(bool);
		return bool;
	}
	public static boolean  printr(boolean b) {
		print(b);
		return b;
	}
	public static Character printr(Character character) {print(character);
		return character;
	}
	public static char printr(char c) {
		print(c);
		return c;
	}
	public static Short printr(Short short1) {
		print(short1);
		return short1;
	}
	public static short printr(short srt) {
		print(srt);
		return srt;
	}
	public static Byte printr(Byte byte1) {
		print(byte1);
		return byte1;
	}
	public static byte printr(byte bte) {
		print(bte);
		return bte;
	}
	public static Integer printr(Integer integer) {
		print(integer);
		return integer;
	}
	public static int printr(int i) {
		print(i);
		return i;
	}
	public static Long printr(Long long1) {
		print(long1);
		return long1;
	}
	public static long printr(long l) {
		print(l);
		return l;
	}
	public static Float printr(Float float1) {
		print(float1);
		return float1;
	}
	public static float printr(float f) {
		print(f);
		return f;
	}
	public static Double printr(Double double1) {
		print(double1);
		return double1;
	}
	public static double  printr(double d) {
		print(d);
		return d;
	}
}