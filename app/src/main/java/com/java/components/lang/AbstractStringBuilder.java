package com.java.components.lang;

import java.util.List;
import java.util.Map;

public interface AbstractStringBuilder {

	/**
	 * <h1> Documentacion </h1>
	 * El metodo `setCharAt(int, char)` es el encargado de cambiar un carácter a otro caracter por el <strong>segundo parámetro</strong>,
	 * por medio de las posiciones dados, en el <storng>primer parámetro</storng>.
	 * Y...
	 * <h2> ¿Como usarlo? </h2>
	 * Para usar, es solo llamar la instancia de la clase, con un texto que se quieres ingresar, ejemplo:
	 * <pre>
	 * <code>
	 *  StringBuilder sb = new StringBuilder("Hella");
	 * </code>
	 * </pre>
	 * en estq ejemplo creamos las instancia de la clase <strong>StringBuilder</strong>, con un <strong>texto</strong>
	 * para la variable <strong>sb</strong>.
	 * y para llamar el metodo `setCharAt(int, char)`, y para reemplaza el caracter que quedemos
	 * por el cual ocupamos, tenemos que colocar el <strong>segundo parámetro</strong> el valor que queremos reemplazar, junto con el
	 * <strong>primer parámetro</strong> que es la posicion del caracter que queremos reemplazar.
	 * ejemplo:
	 * <pre>
	 * <code>
	 *  // anterioir codigo...
	 *  sb.sdtCharAt(4, 'o');
	 * </code>
	 * </pre>
	 * en este ejemplo cambiamos el <strong>a</strong> por el <strong>o</strong> del la palabra <strong>Hella</strong>,
	 * para que diga <strong>Hello</strong> vez de <strong>Hella</strong>.
	 * aqui un ejemplo de codigo completo
	 * <pre>
	 * <code>
	 *  StringBuilder sb = new StringBuilder("Hella");
	 *  sb.sdtCharAt(4, 'o');
	 * </code>
	 * </pre>
	 *
	 * @author NH (NoobHack)
	 *
	 * @see java.lang.StringBuilder#setCharAt(int, char)
	 * @see java.lang.StringBuffer#setCharAt(int, char)
	 * @see java.lang.AbstractStringBuilder#setCharAt(int, char)
	 * @see #setCharAtCodePoint(int, char)
	 *
	 * @param character Parametro para cambiar un caracter por otro caracter especifico.
	 * @param index parametro para cambiar un caracter por otro caracter especifico.
	 *
	 * @throws ArrayIndexOutOfBoundsException Este <strong>Exception</strong> se lanza cuando el indice excede el tamanio del arreglo interna.
	 *
	 * @return <strong>AbstractStirngBuilder</strong> Retorna la propia clase, pero el caracter cambiado.
	 */
	public AbstractStringBuilder setCharAt(int index, char character);
	public char getCharAt(int index);
	public AbstractStringBuilder setCharAtCodePoint(int index, int codePoint);
	public int getCharAtCodePoint(int index);

	public AbstractStringBuilder replace(char target, String replacement);
	public AbstractStringBuilder replace(String target, char replacement);
	public AbstractStringBuilder replace(int start, int end, String replacement);
	public AbstractStringBuilder replace(int start, int end, char replacement);
	public AbstractStringBuilder replace(char target, char replacement);
	public AbstractStringBuilder replace(char target, int position, char replcement);
	public AbstractStringBuilder replace(char target, char replcement, int countOfReplace);
	public AbstractStringBuilder replace(char target, int position, char replcement, int countOfReplace);
	public AbstractStringBuilder replace(char target, char replcement, int start, int end);
	public AbstractStringBuilder replace(char target, char replcement, int countOfReplace, int start, int end);
	public AbstractStringBuilder replace(char target, int position, char replcement, int start, int end);
	public AbstractStringBuilder replace(char target, int position, char replcement, int countOfReplace, int start, int end);
	public AbstractStringBuilder replace(String target, String replacement);
	public AbstractStringBuilder replace(String target, int position, String replacement);
	public AbstractStringBuilder replace(String target, String replacement, int countOfReplace);
	public AbstractStringBuilder replace(String target, int position, String replacement, int countOfReplace);
	public AbstractStringBuilder replace(String target, String replacement, int start, int end);
	public AbstractStringBuilder replace(String target, int position, String replacement, int start, int end);
	public AbstractStringBuilder replace(String target, String replacement, int countOfReplace, int start, int end);
	public AbstractStringBuilder replace(String target, int position, String replacement, int countOfReplace, int start, int end);
	public AbstractStringBuilder replaceFirst(String target, String replacement);
	public AbstractStringBuilder replaceFirst(char target, char replacement);
	public AbstractStringBuilder replaceLast(String target, String replacement);
	public AbstractStringBuilder replaceLast(char target, char replacement);
	public AbstractStringBuilder replaceAll(String targetRegex, String replacementRegex);
	public AbstractStringBuilder replaceAll(String targetRegex, StringBuilder.Replacement replacementRegex);

	public AbstractStringBuilder substring(int start, int end);
	public AbstractStringBuilder relativeSubstring(int start, int end);
	public AbstractStringBuilder substring(int start);
	public AbstractStringBuilder relativeSubstring(int end);
	public AbstractStringBuilder substring(String s);
	public AbstractStringBuilder relativeSubstring(String s);
	public AbstractStringBuilder substr(int start, int length);
	public AbstractStringBuilder relativeSubstr(int start, int length);
	public AbstractStringBuilder slide(int start, int end);
	public AbstractStringBuilder relativeSlide(int start, int end);
	
	public AbstractStringBuilder reverse();
	public AbstractStringBuilder reverse(int start, int end);
	public AbstractStringBuilder reverse(int startOrEnd, boolean isStart);
	public AbstractStringBuilder reverse(AbstractStringBuilder asb);
	public AbstractStringBuilder reverse(String s);
	public AbstractStringBuilder reverse(Number n);
	public AbstractStringBuilder reverse(Byte b);
	public AbstractStringBuilder reverse(byte b);
	public AbstractStringBuilder reverse(Short s);
	public AbstractStringBuilder reverse(short s);
	public AbstractStringBuilder reverse(Integer i);
	public AbstractStringBuilder reverse(int i);
	public AbstractStringBuilder reverse(Long l);
	public AbstractStringBuilder reverse(long l);
	public AbstractStringBuilder reverse(Float f);
	public AbstractStringBuilder reverse(float f);
	public AbstractStringBuilder reverse(Double d);
	public AbstractStringBuilder reverse(double d);
	public AbstractStringBuilder reverse(Character c);
	public AbstractStringBuilder reverse(char c);
	public AbstractStringBuilder reverse(Boolean b);
	public AbstractStringBuilder reverse(boolean b);

	public AbstractStringBuilder padStart(int length, char padChar);
	public AbstractStringBuilder padEnd(int length, char padChar);

	public AbstractStringBuilder append(Character c);
	// public AbstractStringBuilder append(char c);
	public AbstractStringBuilder append(CharSequence cs);
	public AbstractStringBuilder append(String s);
	public AbstractStringBuilder append(Object o);
	public AbstractStringBuilder append(Number n);
	// public AbstractStringBuilder append(Byte b);
	// public AbstractStringBuilder append(byte b);
	// public AbstractStringBuilder append(Short s);
	// public AbstractStringBuilder append(short s);
	// public AbstractStringBuilder append(Integer i);
	// public AbstractStringBuilder append(int i);
	// public AbstractStringBuilder append(Long l);
	// public AbstractStringBuilder append(long l);
	// public AbstractStringBuilder append(Float f);
	// public AbstractStringBuilder append(float f);
	// public AbstractStringBuilder append(Double d);
	// public AbstractStringBuilder append(double d);
	public AbstractStringBuilder append(Boolean b);
	// public AbstractStringBuilder append(boolean b);
	public AbstractStringBuilder append(AbstractStringBuilder asb);
	public AbstractStringBuilder appendCodePoint(int codePoint);
	public AbstractStringBuilder appendCodePoint(int... codePoints);

	public AbstractStringBuilder appendFirst(Character c);
	// public AbstractStringBuilder appendFirst(CharSequence cs);
	public AbstractStringBuilder appendFirst(String s);
	// public AbstractStringBuilder appendFirst(Object o);
	// public AbstractStringBuilder appendFirst(Number n);
	// public AbstractStringBuilder appendFirst(Byte b);
	// public AbstractStringBuilder appendFirst(byte b);
	// public AbstractStringBuilder appendFirst(Short s);
	// public AbstractStringBuilder appendFirst(short s);
	// public AbstractStringBuilder appendFirst(Integer i);
	// public AbstractStringBuilder appendFirst(int i);
	// public AbstractStringBuilder appendFirst(Long l);
	// public AbstractStringBuilder appendFirst(long l);
	// public AbstractStringBuilder appendFirst(Float f);
	// public AbstractStringBuilder appendFirst(float f);
	// public AbstractStringBuilder appendFirst(Double d);
	// public AbstractStringBuilder appendFirst(ouble d);
	// public AbstractStringBuilder appendFirst(Boolean b);
	// public AbstractStringBuilder appendFirst(boolean b);
	// public AbstractStringBuilder appendFirst(AbstractStringBuilder asb);
	// public AbstractStringBuilder appendFirstCodePoint(int codePoint);
	// public AbstractStringBuilder appendFirstCodePoint(int... codePoints);

	public AbstractStringBuilder insert(int index, Character c);
	public AbstractStringBuilder insert(int index, CharSequence cs);
	public AbstractStringBuilder insert(int index, String s);
	public AbstractStringBuilder insert(int index, Object o);
	public AbstractStringBuilder insert(int index, Number n);
	// public AbstractStringBuilder insert(int index, Byte b);
	// public AbstractStringBuilder insert(int index, byte b);
	// public AbstractStringBuilder insert(int index, Short s);
	// public AbstractStringBuilder insert(int index, short s);
	// public AbstractStringBuilder insert(int index, Integer i);
	// public AbstractStringBuilder insert(int index, int i);
	// public AbstractStringBuilder insert(int index, Long l);
	// public AbstractStringBuilder insert(int index, long l);
	// public AbstractStringBuilder insert(int index, Float f);
	// public AbstractStringBuilder insert(int index, float f);
	// public AbstractStringBuilder insert(int index, Double d);
	// public AbstractStringBuilder insert(int index, double d);
	public AbstractStringBuilder insert(int index, Boolean b);
	// public AbstractStringBuilder insert(int index, boolean b);
	// public AbstractStringBuilder insert(int index, AbstractStringBuilder asb);
	// public AbstractStringBuilder insertCodePoint(int index, int codePoint);
	// public AbstractStringBuilder insertCodePoint(int index, int... codePoints);

	public AbstractStringBuilder delete(int start, int end);
	public AbstractStringBuilder delete(int character);
	public AbstractStringBuilder deletes(int... characters);
	public AbstractStringBuilder deletesAll(char characters);
	public AbstractStringBuilder deleteFirst();
	public AbstractStringBuilder deleteFirst(char characters);
	public AbstractStringBuilder deleteLast();
	public AbstractStringBuilder deleteLast(char characters);


	public AbstractStringBuilder toUpperCase();
	public AbstractStringBuilder toLowerCase();
	public AbstractStringBuilder toUpperCase(int start, int end);
	public AbstractStringBuilder toLowerCase(int start, int end);

	public AbstractStringBuilder trimStart();
	public AbstractStringBuilder trimEnd();
	public AbstractStringBuilder trim();

	public AbstractStringBuilder join(int length, String begin, String prefix, String delimiter, String suffix, String end, Object... objects);
	// public AbstractStringBuilder join(String begin, String prefix, String delimiter, String suffix, String end, Object... objects);
	// public AbstractStringBuilder join(int length, String prefix, String delimiter, String suffix, Object... objects);
	// public AbstractStringBuilder join(String prefix, String delimiter, String suffix, Object... objects);
	// public AbstractStringBuilder join(int length, String delimiter, Object... objects);
	// public AbstractStringBuilder join(String delimiter, Object... objects);

	// public AbstractStringBuilder[] split(String delimiter, boolean returnDelimiters, int limit);
	// public AbstractStringBuilder[] split(char delimiter, boolean returnDelimiters, int limit);
	// public AbstractStringBuilder[] split(String delimiter, boolean returnDelimiters);
	// public AbstractStringBuilder[] split(char delimiter, boolean returnDelimiters);
	// public AbstractStringBuilder[] split(String delimiter, int limit);
	//public AbstractStringBuilder[] split(char delimiter, int limit);
	//public AbstractStringBuilder[] split(String delimiter);
	// public AbstractStringBuilder[] split(char delimiter);
	public AbstractStringBuilder[] split(int index, int limit);
	public AbstractStringBuilder[] split(int index);

	public AbstractStringBuilder swap(int index, int toIndex);
	public AbstractStringBuilder swaps(int[] index, int[] toIndex);
	public AbstractStringBuilder swaps(int... indexToIndex);

	public boolean startsWith(char c, int toffset);
	public boolean startsWithIgnoreCase(char c, int toffset);
	public boolean startsWith(char c);
	public boolean startsWithIgnoreCase(char c);
	public boolean startsWith(String prefix, int toffset);
	public boolean startsWithIgnoreCase(String prefix, int toffset);
	public boolean startsWith(String prefix);
	public boolean startsWithIgnoreCase(String prefix);
	public boolean endsWith(char c, int toffset);
	public boolean endsWithIgnoreCase(char c, int toffset);
	public boolean endsWith(char c);
	public boolean endsWithIgnoreCase(char c);
	public boolean endsWith(String s, int toffset);
	public boolean endsWithIgnoreCase(String s, int toffset);
	public boolean endsWith(String s);
	public boolean endsWithIgnoreCase(String s);

	public boolean equals(Object obj);
	public boolean equalsIgnoreCase(Object obj);
	public boolean contains(String s);
	public boolean containsIgnoreCase(String s);
	public boolean contains(char c);
	public boolean containsIgnoreCase(char c);

	public boolean isUpperCase();
	public boolean isLowerCase();
	public boolean isUpperCase(int start, int end);
	public boolean isLowerCase(int start, int end);

	public boolean isEmpty();
	public boolean isEmptyOrNull();
	public boolean isBlank();
	public boolean isBlankOrEmpty();
	public boolean isBlankOrNull();
	public boolean isNullOrEmptyOrBlank();
	public boolean isNull();

	public int length();
	public int size();
	public int shortSize(int subtractSize);
	public int shortLength(int subtractLength);

	public int indexOf(char c);
	public int indexOf(char c, int fromIndex);
	public int indexOf(char c, int start, int end);
	public int indexOf(char c, int fromIndex, int start, int end);
	public int indexOf(int position, char c);
	public int indexOf(int position, char c, int fromIndex);
	public int indexOf(int position, char c, int start, int end);
	public int indexOf(int position, char c, int fromIndex, int start, int end);
	public int indexOf(String s);
	public int indexOf(String s, int fromIndex);
	public int indexOf(String s, int start, int end);
	public int indexOf(String s, int fromIndex, int start, int end);
	public int indexOf(int position, String s);
	public int indexOf(int position, String s, int fromIndex);
	public int indexOf(int position, String s, int start, int end);
	public int indexOf(int position, String s, int fromIndex, int start, int end);
	public int relativeIndexOf(char c);
	public int relativeIndexOf(char c, int fromIndex);
	public int relativeIndexOf(char c, int start, int end);
	public int relativeIndexOf(char c, int fromIndex, int start, int end);
	public int relativeIndexOf(int position, char c);
	public int relativeIndexOf(int position, char c, int fromIndex);
	public int relativeIndexOf(int position, char c, int start, int end);
	public int relativeIndexOf(int position, char c, int fromIndex, int start, int end);
	// public int relativeIndexOf(String s);
	// public int relativeIndexOf(String s, int fromIndex);
	// public int relativeIndexOf(String s, int start, int end);
	// public int relativeIndexOf(String s, int fromIndex, int start, int end);
	// public int relativeIndexOf(int position, String s);
	// public int relativeIndexOf(int position, String s, int fromIndex);
	// public int relativeIndexOf(int position, String s, int start, int end);
	// public int relativeIndexOf(int position, String s, int fromIndex, int start, int end);
	public int lastIndexOf(char c);
	//// public int lastIndexOf(char c, int fromIndex);
	// public int lastIndexOf(char c, int start, int end);
	//// public int lastIndexOf(char c, int fromIndex, int start, int end);
	//// public int lastIndexOf(int position, char c);
	//// public int lastIndexOf(int position, char c, int fromIndex);
	//// public int lastIndexOf(int position, char c, int start, int end);
	//// public int lastIndexOf(int position, char c, int fromIndex, int start, int end);
	// public int lastIndexOf(String s);
	//// public int lastIndexOf(String s, int fromIndex);
	// public int lastIndexOf(String s, int start, int end);
	//// public int lastIndexOf(String s, int fromIndex, int start, int end);
	//// public int lastIndexOf(int position, String s);
	//// public int lastIndexOf(int position, String s, int fromIndex);
	//// public int lastIndexOf(int position, String s, int start, int end);
	//// public int lastIndexOf(int position, String s, int fromIndex, int start, int end);
	public int reverseIndexOf(char c);
	// public int reverseIndexOf(char c, int fromIndex);
	// public int reverseIndexOf(char c, int start, int end);
	// public int reverseIndexOf(char c, int fromIndex, int start, int end);
	// public int reverseIndexOf(int position, char c);
	// public int reverseIndexOf(int position, char c, int fromIndex);
	// public int reverseIndexOf(int position, char c, int start, int end);
	// public int reverseIndexOf(int position, char c, int fromIndex, int start, int end);
	// public int reverseIndexOf(String s);
	// public int reverseIndexOf(String s, int fromIndex);
	// public int reverseIndexOf(String s, int start, int end);
	// public int reverseIndexOf(String s, int fromIndex, int start, int end);
	// public int reverseIndexOf(int position, String s);
	// public int reverseIndexOf(int position, String s, int fromIndex);
	// public int reverseIndexOf(int position, String s, int start, int end);
	// public int reverseIndexOf(int position, String s, int fromIndex, int start, int end);
	public int[] indexOfAll(String target);
	public int[] indexOfAll(char target);
	public int[] relativeIndeOfAll(String target);
	public int[] relativeIndeOfAll(char target);

	public char getFirstChar();
	public char getLastChar();

	public String toString();
	public String toString(int min, int max);
	public String toString(AbstractStringBuilder asb);

	public Map<Integer, Character> toCharMap();
	public List<Character> toCharList();
	public char[] toCharArray();
}
