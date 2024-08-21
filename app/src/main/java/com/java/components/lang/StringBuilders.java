package com.java.components.lang;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.java.components.lang.exception.IndexOutOfBoundsException;
import com.java.components.lang.exception.NullPointerException;

/**
 * <h1>Documentación</h1>
 * La clase {@code StringBuilder} mejora la clase {@link String} para proporcionar una mayor flexibilidad
 * en la manipulación de caracteres dentro de <strong>Java</strong>. A diferencia de {@link String},
 * {@code StringBuilder} es <strong>mutable</strong>, lo que permite modificar su contenido sin crear
 * nuevos objetos.
 *
 * <h2>¿Cómo usarlo?</h2>
 * Hay varias maneras de utilizar {@code StringBuilder}. Una opción es usar una instancia guardada en
 * una variable que soporte la clase {@code StringBuilder}. Otra opción es utilizarla directamente
 * con el operador <strong>new</strong>.
 *
 * <h3>Manera 1: Uso de la variable {@code StringBuilder}</h3>
 * En este enfoque, primero se crea una instancia de {@code StringBuilder} y se guarda en una variable
 * (por ejemplo, {@code sb}) que soporta la clase {@code StringBuilder}. Luego, se puede agregar el texto deseado.
 * <p>Ejemplo:</p>
 * <pre>{@code
 * StringBuilder sb = new StringBuilder("Here Text");
 * }</pre>
 *
 * <h3>Manera 2: Sin usar la variable</h3>
 * En este enfoque, se crea una instancia de {@code StringBuilder} directamente con el texto deseado,
 * sin necesidad de crear una variable para soportarla.
 * <p>Ejemplo:</p>
 * <pre>{@code
 * new StringBuilder("Here Text");
 * }</pre>
 *
 * @throws NullPointerException Si la inicializacion de la clase <strong>StringBuilder</strong> es <strong>null</strong>.
 * @throws IllegalArgumentException Si el argumento <strong>str</strong> es <strong>null</strong>.
 *
 * @author NH (NoobHack)
 *
 * @see java.lang.Object#toString()
 * @see java.lang.StringBuffer
 * @see java.lang.StringBuilder
 * @see java.lang.String
 * @see java.lang.CharSequence
 * @see java.nio.charset.Charset
 *
 * @version 1.0.0
 * @since JDK 21 (2024-07-15)
 */
@SuppressWarnings("redundant")
public class StringBuilders implements AbstractStringBuilder {
	private char[] character;
	private Integer count;
	private Integer offset;
	private Integer capacity = 16;

	public StringBuilders() {
		this.character = new char[this.capacity];
		this.count = 0;
		this.offset = 0;
	}

	public StringBuilders(Integer capacity) {
		this.capacity = capacity;
		this.character = new char[capacity];
		this.count = 0;
		this.offset = 0;
	}

	public StringBuilders(char ch) {
		this.character = new char[1];
		this.count = 1;
		this.offset = 0;
		character[0] = ch;
	}

	public StringBuilders(String str) {
		this(str, 0);
	}

	public StringBuilders(String str, int offset) {
		this(str, offset, str.length());
	}

	public StringBuilders(String str, int offset, int length) {
		this.character = new char[length];
		this.count = length;
		this.offset = offset;
		int position = offset;
		while(position < count) {
			this.character[position] = str.charAt(position);
			++position;
		}
	}

	public StringBuilders(StringBuilders str) {
		this(str, 0);
	}

	public StringBuilders(StringBuilders str, int offset) {
		this(str, offset, str.length());
	}

	public StringBuilders(StringBuilders str, int offset, int length) {
		this.character = new char[length];
		this.count = length;
		this.offset = offset;
		int position = offset;
		while((++position) < count) {
			this.character[position] = str.getCharAt(position);
		}
	}

	public StringBuilders(char values[]) {
		this(values, 0);
	}

	public StringBuilders(char values[], int offset) {
		this(values, offset, values.length);
	}

	public StringBuilders(char values[], int offset, int length) {
		if (values == null) throw new NullPointerException();
		if (offset < 0 || offset > values.length) throw new StringBuilderIndexOutOfBoundsException();
		if (length < 0) throw new IndexOutOfBoundsException();
		if (offset + length > values.length) throw new StringBuilderIndexOutOfBoundsException();
		this.character = new char[length];
		this.count = length;
		this.offset = offset;
		java.lang.System.arraycopy(values, offset, this.character, 0, length);
	}

	public StringBuilders(String[] strings) {
		this.character = System.toCharArray(strings);
		this.count = character.length;
	}

	public StringBuilders(String[] strings, int offset) {
		char[] newCharacter = System.toCharArray(strings);
		this.character = new char[newCharacter.length];
		for (int i = 0; i < newCharacter.length; i++) {
			this.character[i] = newCharacter[i + offset];
		}
		this.offset = offset;
		this.count = newCharacter.length;
	}

	public StringBuilders(String[] strings, int offset, int length) {
		char[] newCharacter = System.toCharArray(strings);
		this.character = new char[length];
		for (int i = 0; i < length; i++) {
			this.character[i] = newCharacter[i + offset];
		}
		this.offset = offset;
		this.count = length;
	}

	protected void ensureCapacity(int minimumCapacity) {
		int maxCapacity = character.length;
	
		if (minimumCapacity > maxCapacity) {
			int newCapacity = (maxCapacity + 1) * 2;
			if (minimumCapacity > newCapacity) {
				newCapacity = minimumCapacity;
			}
	
			char newValue[] = new char[newCapacity + capacity];
			java.lang.System.arraycopy(character, 0, newValue, 0, count);
			character = newValue;
		}
	}

	@Override
	public StringBuilders setCharAt(int index, char character) {
		this.character[index + offset] = character;
		return this;
	}

	@Override
	public char getCharAt(int index) {
		return character[index >= character.length ? character.length - 1 : index];
	}

	@Override
	public StringBuilders setCharAtCodePoint(int index, int codePoint) {
		character[index + offset] = (char) codePoint;
		return this;
	}

	@Override
	public int getCharAtCodePoint(int index) {
		return (int) character[index + offset];
	}

	@Deprecated
	@Override
	public StringBuilders replace(char target, String replacement) {
		return replace(Character.toString(target), replacement);
	}

	@Deprecated
	@Override
	public StringBuilders replace(String target, char replacement) {
		return replace(target, Character.toString(replacement));
	}

	@Override
	public StringBuilders replace(int start, int end, char replacement) {
		return replace(start, end, String.valueOf(replacement));
	}

	@Override
	public StringBuilders replace(int start, int end, String replacement) {
		StringBuilders sb = new StringBuilders(character);
		character = sb.substring(0, start).append(replacement).append(sb.substring(end)).toString().toCharArray();
		return this;
	}

	@Override
	public StringBuilders replace(char target, char replacement) {
		return replace(target, 0, replacement);
	}

	@Override
	public StringBuilders replace(char target, int position, char replcement) {
		return replace(target, position, replcement, character.length);
	}

	@Override
	public StringBuilders replace(char target, char replcement, int countOfReplace) {
		return replace(target, 0, replcement, countOfReplace);
	}

	@Override
	public StringBuilders replace(char target, int position, char replcement, int countOfReplace) {
		return replace(target, position, replcement, countOfReplace, 0, count);
	}

	@Override
	public StringBuilders replace(char target, char replcement, int start, int end) {
		return replace(target, 0, replcement, start, end);
	}

	@Override
	public StringBuilders replace(char target, int position, char replcement, int start, int end) {
		return replace(target, position, replcement, character.length, start, end);
	}

	@Override
	public StringBuilders replace(char target, char replcement, int countOfReplace, int start, int end) {
		return replace(target, 0, replcement, countOfReplace, start, end);
	}

	@Override
	public StringBuilders replace(char target, int position, char replcement, int countOfReplace, int start, int end) {
		int index = start;
		while(index < end) {
			if(character[index + offset] == target && countOfReplace != 0 && position == 0) {
				character[index + offset] = replcement;
				countOfReplace--;
			} else if (character[index + offset] == target && position != 0) {
				position--;
			}
			++index;
		}
		return new StringBuilders(character);
	}

	@Override
	public StringBuilders replace(String target, String replacement) {
		return replaces(target, replacement, character.length);
 	}

	@Override
	public StringBuilders replace(String target, int position, String replacement) {
		int startIndex = indexOf(target);
		for (; startIndex != -1; startIndex = indexOf(target, startIndex + 1)) {
			if (position == 0) {
				replace(startIndex, startIndex + target.length(), replacement);
			} else {
				position--;
			}
		}
		if(startIndex == -1) return this;
		return this;
	}

	@Override
	public StringBuilders replace(String target, String replacement, int countOfReplace) {
		return replaces(target, replacement, countOfReplace);
	}

	@Override
	public StringBuilders replace(String target, int position, String replacement, int countOfReplace) {
		int startIndex = indexOf(target);
		for (; countOfReplace > -1; startIndex = indexOf(target, startIndex + 1), countOfReplace--) {
			if (position == 0) {
				replace(startIndex, startIndex + target.length(), replacement);
			} else {
				position--;
			}
		}
		if(startIndex == -1) return this;
		return this;
	}

	@Override
	public StringBuilders replace(String target, String replacement, int start, int end) {
		return replace(target, 0, replacement, start, end);
	}

	@Override
	public StringBuilders replace(String target, int position, String replacement, int start, int end) {
		return replace(target, position, replacement, character.length, start, end);
	}

	@Override
	public StringBuilders replace(String target, String replacement, int countOfReplace, int start, int end) {
		return replace(target, 0, replacement, countOfReplace, start, end);
	}

	@Override
	public StringBuilders replace(String target, int position, String replacement, int countOfReplace, int start,
			int end) {
		StringBuilders sb = substring(start, end);
		StringBuilders result = new StringBuilders();
		result.append(substring(0, start)).append(sb.replace(target, position, replacement, countOfReplace)).append(substring(end));
		character = result.toCharArray();
		return this;
	}
	
	@Override
	public StringBuilders replaceFirst(String target, String replacement) {
		return replaces(target, replacement, 1);
	}

	@Override
	public StringBuilders replaceFirst(char target, char replacement) {
		return replace(target, replacement, 1);
	}

	@Override
	public StringBuilders replaceLast(String target, String replacement) {
		return replace(target, concurrence(target) - 1, replacement);
	}

	@Override
	public StringBuilders replaceLast(char target, char replacement) {
		return replaceLast(Character.toString(target), Character.toString(replacement));
	}

	@Override
	public StringBuilders replaceAll(String target, String replacement) {
		Matcher m = Pattern.compile(target).matcher(new String(this.character));
		StringBuffer result = new StringBuffer();
		while (m.find()) {
			m.appendReplacement(result, replacement);
		}
		m.appendTail(result);
		character = result.toString().toCharArray();
		return this;
	}

	@Override
	public StringBuilders replaceAll(String target, Replacement repleces) {
		Matcher m = Pattern.compile(target).matcher(new String(this.character));
		StringBuffer result = new StringBuffer();
		while (m.find()) {
			String replacement = repleces.replacement(m.group());
			m.appendReplacement(result, new Strings().escapeToNormal(replacement));
		}
		m.appendTail(result);
		character = result.toString().toCharArray();
		return this;
	}

	public int concurrence(String target) {
		int count = 0;
		int startIndex = indexOf(target);
		while (startIndex != -1) {
			count++;
			startIndex = indexOf(target, startIndex + 1);
		}
		return count;
	}

	private StringBuilders replaces(String target, String replacement, int countOfReplace) {
		if (target.isEmpty()) {
			return this;
		}

		char[] originalChars = character;
		char[] targetChars = target.toCharArray();
		char[] replacementChars = replacement.toCharArray();

		StringBuilders result = new StringBuilders();

		int count = 0;
		int i = 0;
		while (i < originalChars.length) {
			boolean foundMatch = true;

			for (int j = 0; j < targetChars.length; j++) {
				if (originalChars[i + j] != targetChars[j]) {
					foundMatch = false;
					break;
				}
			}

			if (count == countOfReplace && foundMatch) {
				foundMatch = false;
			}
			if (foundMatch) {
				result.append(replacementChars);
				i += targetChars.length;
				count++;
			} else {
				result.append(originalChars[i]);
				i++;
			}
		}

		while (i < originalChars.length) {
			result.append(originalChars[i]);
			i++;
		}

		return result;
 	}

	private StringBuilders append(char[] chs) {
		int newCount = count + chs.length;
		ensureCapacity(newCount);
		java.lang.System.arraycopy(chs, 0, character, count, chs.length);
		count = newCount;
		return this;
	}

	@Override
	public StringBuilders substring(int start, int end) {
		if (start < 0) {
			throw new StringBuilderIndexOutOfBoundsException(start);
		}
		if (end < 0) {
			throw new StringBuilderIndexOutOfBoundsException(end);
		}
		if (start > end) {
			throw new StringBuilderIndexOutOfBoundsException(end - start);
		}
		return new StringBuilders(character, start, end - start);
	}

	@Override
	public StringBuilders relativeSubstring(int start, int end) {
		if (start < 0) {
			throw new StringBuilderIndexOutOfBoundsException(start);
		}
		if (end < 0) {
			throw new StringBuilderIndexOutOfBoundsException(end);
		}
		if (start > end) {
			throw new StringBuilderIndexOutOfBoundsException(end - start);
		}
		return substring(0, start).append(substring(end));
	}
	
	@Override
	public StringBuilders substring(int start) {
		return substring(start, count);
	}

	@Override
	public StringBuilders relativeSubstring(int end) {
		return substring(0, end);
	}

	@Override
	public StringBuilders substring(String s) {
		if(contains(s)) {
			return substring(indexOf(s), indexOf(s) + s.length());
		}
		return this;
	}

	@Override
	public StringBuilders relativeSubstring(String s) {
		if (contains(s)) {
			return substring(0, indexOf(s)).append(substring(indexOf(s) + s.length()));
		}
		return this;
	}

	@Override
	public StringBuilders substr(int start, int length) {
		if (start < 0) {
			throw new StringBuilderIndexOutOfBoundsException(start);
		}
		if (length < 0) {
			throw new StringBuilderIndexOutOfBoundsException(length);
		}
		if (start + length > count) {
			throw new StringBuilderIndexOutOfBoundsException(length);
		}
		return substring(start, start + length);
	}

	@Override
	public StringBuilders relativeSubstr(int start, int length) {
		return substring(0, start).append(substring(start + length));
	}

	@Override
	public StringBuilders slide(int start, int end) {
		if (start < 0 && end < 0) {
			return substring(length() + start, length() + end);
		}
		if (end < 0) {
			return substring(start, length() + end);
		}
		if (start < 0) {
			return substring(length() + start, end);
		}
		if (start == end) {
			return new StringBuilders();
		}
		return substring(start, end);
	}

	@Override
	public StringBuilders relativeSlide(int start, int end) {
		return slide(0, start).append(slide(end, count));
	}

	@Override
	public StringBuilders reverse() {
		return reverse(0, length());
	}

	@Override
	public StringBuilders reverse(int start, int end) {
		if (start < 0) {
			throw new StringBuilderIndexOutOfBoundsException(start);
		}
		if (end < 0) {
			throw new StringBuilderIndexOutOfBoundsException(end);
		}

		int size = end - start;

		if (size == 1) {
			return new StringBuilders(character[offset + start]);
		}
		if (size == 0) {
			return new StringBuilders();
		}

		char[] retcarahc = new char[size];
		for (int i = start; i < end; i++) {
			retcarahc[size - i - 1] = character[offset + i];
		}
		return new StringBuilders(retcarahc, 0, size);
	}

	@Override
	public StringBuilders reverse(int startOrEnd, boolean isStart) {
		throw new UnsupportedOperationException("Unimplemented method 'reverse'");
	}

	@Override
	public StringBuilders reverse(AbstractStringBuilder asb) {
		StringBuilders sb = (StringBuilders) asb;
		return reverse(0, sb.length());
	}

	@Override
	public StringBuilders reverse(String s) {
		StringBuilders sb = new StringBuilders(s);
		return sb.reverse();
	}

	@Override
	public StringBuilders reverse(Number n) {
		StringBuilders sb = new StringBuilders(n.toString());
		return sb.reverse();
	}

	@Override
	public StringBuilders reverse(Byte b) {
		StringBuilders sb = new StringBuilders(b.toString());
		return sb.reverse();
	}

	@Override
	public StringBuilders reverse(byte b) {
		StringBuilders sb = new StringBuilders(Byte.toString(b));
		return sb.reverse();
	}

	@Override
	public StringBuilders reverse(Short s) {
		StringBuilders sb = new StringBuilders(s.toString());
		return sb.reverse();
	}

	@Override
	public StringBuilders reverse(short s) {
		StringBuilders sb = new StringBuilders(Short.toString(s));
		return sb.reverse();
	}

	@Override
    public StringBuilders reverse(Integer i) {
       StringBuilders sb = new StringBuilders(i.toString());
	   return sb.reverse();
    }

	@Override
    public StringBuilders reverse(int i) {
	   StringBuilders sb = new StringBuilders(Integer.toString(i));
	   return sb.reverse();
    }

	@Override
	public StringBuilders reverse(Long l) {
		StringBuilders sb = new StringBuilders(l.toString());
		return sb.reverse();
	}

	@Override
	public StringBuilders reverse(long l) {
		StringBuilders sb = new StringBuilders(Long.toString(l));
		return sb.reverse();
	}

	@Override
	public StringBuilders reverse(Float f) {
		StringBuilders sb = new StringBuilders(f.toString());
		return sb.reverse();
	}

	@Override
	public StringBuilders reverse(float f) {
		StringBuilders sb = new StringBuilders(Float.toString(f));
		return sb.reverse();
	}

	@Override
	public StringBuilders reverse(Double d) {
		StringBuilders sb = new StringBuilders(d.toString());
		return sb.reverse();
	}

	@Override
	public StringBuilders reverse(double d) {
		StringBuilders sb = new StringBuilders(Double.toString(d));
		return sb.reverse();
	}

	@Override
	public StringBuilders reverse(Character c) {
		StringBuilders sb = new StringBuilders(c.toString());
		return sb.reverse();
	}

	@Override
	public StringBuilders reverse(char c) {
		StringBuilders sb = new StringBuilders(Character.toString(c));
		return sb.reverse();
	}

	@Override
	public StringBuilders reverse(Boolean b) {
		StringBuilders sb = new StringBuilders(b.toString());
		return sb.reverse();
	}

	@Override
	public StringBuilders reverse(boolean b) {
		StringBuilders sb = new StringBuilders(Boolean.toString(b));
		return sb.reverse();
	}

	@Override
	public StringBuilders padStart(int length, char padChar) {
		if (length < 0) {
			throw new StringBuilderIndexOutOfBoundsException(length);
		}
		if (length == 0) {
			return this;
		}
		char[] newCharacter = new char[count + length];
		for (int i = 0; i < length; i++) {
			newCharacter[i] = padChar;
		}
		for (int i = length, j = 0; i < count; i++, j++) {
			newCharacter[i] = character[offset + j];
		}
		return new StringBuilders(newCharacter, offset, count + length);
	}

	@Override
	public StringBuilders padEnd(int length, char padChar) {
		if (length < 0) {
			throw new StringIndexOutOfBoundsException(length);
		}
		if (length == 0) {
			return this;
		}
		char[] newCharacter = new char[count + length];
		for (int i = 0; i < count; i++) {
			newCharacter[i] = character[offset + i];
		}
		for (int i = count; i < count + length; i++) {
			newCharacter[i] = padChar;
		}
		return new StringBuilders(newCharacter, offset, count + length);
	}

	@Override
	public StringBuilders append(Character c) {
		return append(c.toString());
	}

	@Override
	public StringBuilders append(CharSequence cs) {
		return append(cs.toString());
	}

	@Override
	public StringBuilders append(String s) {
		if (s == null) {
			s = "null";
		}
		ensureCapacity(count + s.length());
		for (int i = 0; i < s.length(); i++) {
			character[offset + count + i] = s.charAt(i);
		}
		count += s.length();
		return this;
	}

	@Override
	public StringBuilders append(Object o) {
		return append(o.toString());
	}

	@Override
	public StringBuilders append(Number n) {
		return append(n.toString());
	}

	@Override
	public StringBuilders append(Boolean b) {
		return append(b.toString());
	}

	@Override
	public StringBuilders append(AbstractStringBuilder asb) {
		return append(asb.toString());
	}

	@Override
	public StringBuilders appendCodePoint(int codePoint) {
		ensureCapacity(count + 1);
		character[count + 1] = (char) codePoint;
		count += 1;
		return this;
	}

	@Override
	public StringBuilders appendCodePoint(int... codePoints) {
		for (int codePoint : codePoints) {
			appendCodePoint(codePoint);
		}
		return this;
	}

	@Override
	public StringBuilders appendFirst(Character c) {
		StringBuilders sb = new StringBuilders(c.toString());
		sb.append(this.character);
		this.character = sb.toCharArray();
		return this;
	}

	@Override
	public StringBuilders appendFirst(String s) {
		StringBuilders sb = new StringBuilders(s);
		sb.append(this.character);
		this.character = sb.toCharArray();
		return this;
	}

	@Override
	public StringBuilders insert(int index, Character character) {
		StringBuilders sb = new StringBuilders(this.character);
		sb = sb.substring(0, index).append(character).append(sb.substring(index));
		this.character = sb.toString().toCharArray();
		return this;
	}

	@Override
	public StringBuilders insert(int index, CharSequence cs) {
		StringBuilders sb = new StringBuilders(this.character);
		sb = sb.substring(0, index).append(cs).append(sb.substring(index));
		this.character = sb.toString().toCharArray();
		return this;
	}

	@Override
	public StringBuilders insert(int index, String s) {
		StringBuilders sb = new StringBuilders(this.character);
		sb = sb.substring(0, index).append(s).append(sb.substring(index));
		this.character = sb.toString().toCharArray();
		return this;
	}

	@Override
	public StringBuilders insert(int index, Object o) {
		StringBuilders sb = new StringBuilders(this.character);
		sb = sb.substring(0, index).append(o).append(sb.substring(index));
		this.character = sb.toString().toCharArray();
		return this;
	}

	@Override
	public StringBuilders insert(int index, Number n) {
		StringBuilders sb = new StringBuilders(this.character);
		sb = sb.substring(0, index).append(n).append(sb.substring(index));
		this.character = sb.toString().toCharArray();
		return this;
	}

	@Override
	public StringBuilders insert(int index, Boolean b) {
		StringBuilders sb = new StringBuilders(this.character);
		sb = sb.substring(0, index).append(b).append(sb.substring(index));
		this.character = sb.toString().toCharArray();
		return this;
	}

	@Override
	public StringBuilders delete(int start, int end) {
		StringBuilders sb = new StringBuilders(this.character);
		sb = sb.substring(0, start).append(sb.substring(end));
		this.character = sb.toCharArray();
		return this;
	}

	@Override
	public StringBuilders delete(int index) {
		if ((index < 0) || (index >= count)) {
			throw new StringBuilderIndexOutOfBoundsException(index);
		}
		char[] newCharacter = new char[count - 1];
		for (int i = 0, j = 0; i < newCharacter.length; i++, j++) {
			if (i == index) {
				j++;
			}
			newCharacter[offset + i] = character[offset + j];
		}
		character = newCharacter;
		count = character.length;
		return this;
	}

	@Override
	public StringBuilders deletes(int... characters) {
		int fix = 0;
		for (int character : characters) {
			if (fix == 1) { delete(character - 2); }
			else delete(character);
			fix++;
		}
		return this;
	}

	@Override
	public StringBuilders deletesAll(char characters) {
		return replace(String.valueOf(characters), "");
	}

	@Override
	public StringBuilders deleteFirst() {
		return delete(0, 1);
	}

	@Override
	public StringBuilders deleteFirst(char characters) {
		return replaceFirst(String.valueOf(characters), "");
	}

	@Override
	public StringBuilders deleteLast() {
		return delete(length() - 1, length());
	}

	@Override
	public StringBuilders deleteLast(char characters) {
		return replaceLast(String.valueOf(characters), "");
	}

	@Override
	public StringBuilders toUpperCase() {
		return toUpperCase(0, length());
	}

	@Override
	public StringBuilders toUpperCase(int start, int end) {
		int position = start;
		while (position < end) {
			if (getCharAt(offset + position) >= 'a' && getCharAt(offset + position) <= 'z') {
				character[offset + position] = (char) (character[offset + position] - 32);
			}
			position++;
		}
		return new StringBuilders(character);
	}

	@Override
	public StringBuilders toLowerCase() {
		return toLowerCase(0, length());
	}

	@Override
	public StringBuilders toLowerCase(int start, int end) {
		int position = start;
		while ((position) < end) {
			if (getCharAt(offset + position) >= 'A' && getCharAt(offset + position) <= 'Z') {
				character[offset + position] = (char) (character[offset + position] + 32);
			}
			position++;
		}
		return new StringBuilders(character);
	}

	@Override
	public StringBuilders trimStart() {
		int position = 0;
		while (getCharAt(++position) == ' ') {}
		return substring(position, length());
	}

	@Override
	public StringBuilders trimEnd() {
		int position = size();
		while (getCharAt(--position) == ' ') {}
		return substring(0, position + 1);
	}

	@Override
	public StringBuilders trim() {
		int start = 0;
		int end = size();
		while (getCharAt(++start) == ' ') {}
		while (getCharAt(--end) == ' ') {}
		return substring(start, end + 1);
	}

	@Override
	public StringBuilders join(String begin, String prefix, String delimiter, String suffix,
			String end, int length, Object[] objects) {
		StringBuilders sb = new StringBuilders(begin);
		for (int i = 0; i < length; i++) {
			sb = sb.append(prefix).append(objects[i]).append(suffix).append(delimiter);
		}
		if (sb.length() > 1) {
			sb = sb.substring(0, sb.length() - delimiter.length()).append(end);
		}
		return sb;
	}

	@Override
	public StringBuilders join(String begin, String prefix, String delimiter, String suffix,
			String end, Object[] objects) {
		return join(begin, prefix, delimiter, suffix, end, objects.length, objects);
	}

	@Override
	public StringBuilders join(String prefix, String delimiter, String suffix, int length, Object[] objects) {
		return join("", prefix, delimiter, suffix, "", length, objects);
	}

	@Override
	public StringBuilders join(String prefix, String delimiter, String suffix, Object[] objects) {
		return join("", prefix, delimiter, suffix, "", objects.length, objects);
	}

	@Override
	public StringBuilders join(String delimiter, int length, Object[] objects) {
		return join("", "", delimiter, "", "", length, objects);
	}

	@Override
	public StringBuilders join(String delimiter, Object[] objects) {
		return join("", "", delimiter, "", "", objects.length, objects);
	}

	@Override
	public StringBuilders[] split(String delimiter, int limit) {
        if (character == null || delimiter == null || limit < 1) {
            throw new IllegalArgumentException("Invalid input");
        }
		StringBuilders sb = new StringBuilders(character);

		StringBuilders[] result = new StringBuilders[limit];
        int count = 0;
        int start = 0;
        int end;

        while ((end = sb.indexOf(delimiter, start)) != -1) {
            if (count == limit - 1) {
                break;
            }
            result[count++] = sb.substring(start, end);
            start = end + delimiter.length();
        }

        result[count] = sb.substring(start);

        if (count < limit - 1) {
            StringBuilders[] trimmedResult = new StringBuilders[count + 1];
            java.lang.System.arraycopy(result, 0, trimmedResult, 0, count + 1);
            return trimmedResult;
        }
		return result;
	}

	// @Override
	public StringBuilders[] split(char delimiter) {
		return split(Character.toString(delimiter), 0);
	}

	@Override
	public StringBuilders[] split(int index) {
		return split(index, 0);
	}

	@Override
	public StringBuilders[] split(int index, int limit) {
		int missing = length() % index;
		StringBuilders[] result = new StringBuilders[limit == 0 ? (missing != 0 ? (length() / index) + 1 : length() / index) : limit];
		for (int i = 0; i < result.length; i++) {
			int j = (i + 1) * index;
			result[i] = substring(i * index, j < length() ? j : length());
		}
		return result;
	}

	@Override
	public StringBuilders swap(int index, int toIndex) {
		if ((index < 0) || (index >= count)) {
			throw new StringBuilderIndexOutOfBoundsException(index);
		}
		if ((toIndex < 0) || (toIndex >= count)) {
			throw new StringBuilderIndexOutOfBoundsException(toIndex);
		}
		char temp = character[offset + index];
		character[offset + index] = character[offset + toIndex];
		character[offset + toIndex] = temp;
		return this;
	}

	@Override
	public StringBuilders swaps(int[] index, int[] toIndex) {
		if ((index == null) || (toIndex == null)) {
			throw new NullPointerException();
		}
		if ((index.length != toIndex.length) || (index.length <= 0)) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < index.length; i++) {
			swap(index[i], toIndex[i]);
		}
		return this;
	}

	@Override
	public StringBuilders swaps(int... indexToIndex) {
		if ((indexToIndex == null) || (indexToIndex.length <= 0)) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < indexToIndex.length; i += 2) {
			swap(indexToIndex[i], indexToIndex[i + 1]);
		}
		return this;
	}

	@Override
	public boolean startsWith(char c, int toffset) {
		return getCharAt(offset + toffset) == c;
	}

	@Override
	public boolean startsWithIgnoreCase(char c, int toffset) {
		return toLowerCase().startsWith(Character.toLowerCase(c), toffset);
	}

	@Override
	public boolean startsWith(char c) {
		return getCharAt(offset) == c;
	}

	@Override
	public boolean startsWithIgnoreCase(char c) {
		return startsWithIgnoreCase(c, 0);
	}

	@Override
	public boolean startsWith(String s, int toffset) {
		char[] sc = s.toCharArray();
		for (int i = 0; i < sc.length; i++) {
			if (getCharAt(offset + i + toffset) != sc[i]) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean startsWithIgnoreCase(String prefix, int toffset) {
		return toLowerCase().startsWith(prefix.toLowerCase(), toffset);
	}

	@Override
	public boolean startsWith(String s) {
		return startsWith(s, 0);
	}

	@Override
	public boolean startsWithIgnoreCase(String prefix) {
		return startsWithIgnoreCase(prefix, 0);
	}

	@Override
	public boolean endsWith(char c, int toffset) {
		return getCharAt(offset + length() - 1 - toffset) == c;
	}

	@Override
	public boolean endsWithIgnoreCase(char c, int toffset) {
		return toLowerCase().endsWith(Character.toLowerCase(c), toffset);
	}

	@Override
	public boolean endsWith(char c) {
		return endsWith(c, 0);
	}

	@Override
	public boolean endsWithIgnoreCase(char c) {
		return endsWithIgnoreCase(c, 0);
	}

	@Override
	public boolean endsWith(String s, int toffset) {
		return startsWith(s, length() - s.length() - toffset);
	}

	@Override
	public boolean endsWithIgnoreCase(String s, int toffset) {
		return toLowerCase().endsWith(s.toLowerCase(), toffset);
	}

	@Override
	public boolean endsWith(String s) {
		return endsWith(s, 0);
	}

	@Override
	public boolean endsWithIgnoreCase(String s) {
		return endsWithIgnoreCase(s, 0);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof StringBuilders)) {
			return false;
		}
		String s = (String) obj;
		if (s.length() != length()) {
			return false;
		}
		StringBuilders otherStringBuilder = (StringBuilders) obj;
		if (size() != otherStringBuilder.length()) { return false; }
		for (int i = 0; i < otherStringBuilder.length(); i++) {
			if (getCharAt(i) != otherStringBuilder.getCharAt(i)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean equalsIgnoreCase(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof StringBuilders)) {
			return false;
		}
		StringBuilders otherStringBuilder = (StringBuilders) obj;
	
		if (size() != otherStringBuilder.length()) { return false; }
		for (int i = 0; i < otherStringBuilder.length(); i++) {
			if (toLowerCase().getCharAt(i) != otherStringBuilder.toLowerCase().getCharAt(i)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean contains(String s) {
		return indexOf(s) >= 0;
	}

	@Override
	public boolean containsIgnoreCase(String s) {
		return toLowerCase().contains(s.toLowerCase());
	}

	@Override
	public boolean contains(char c) {
		return indexOf(c) >= 0;
	}

	@Override
	public boolean containsIgnoreCase(char c) {
		return toLowerCase().contains(Character.toLowerCase(c));
	}

	@Override
	public boolean isUpperCase() {
		return isUpperCase(0, length());
	}

	@Override
	public boolean isLowerCase() {
		return isLowerCase(0, length());
	}

	@Override
	public boolean isUpperCase(int start, int end) {
		if (start > end) {
			return false;
		}
		if (start == end) {
			return false;
		}
		for (int i = start; i < end; i++) {
			if (getCharAt(i) >= 'a' && getCharAt(i) <= 'z') {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean isLowerCase(int start, int end) {
		if (start > end) {
			return false;
		}
		if (start == end) {
			return false;
		}
		for (int i = start; i < end; i++) {
			if (getCharAt(i) >= 'A' && getCharAt(i) <= 'Z') {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean isEmpty() {
		if (isNull()) {
			return false;
		}
		return length() == 0 && size() == 0;
	}

	@Override
	public boolean isEmptyOrNull() {
		return isEmpty() || isNull();
	}

	@Override
	public boolean isBlank() {
		boolean b = false;
		if (isEmpty()) {
			return b;
		}
		for (int i = 0; i < length(); i++) {
			if (getCharAt(i) == ' ' || getCharAt(i) == '\t' || getCharAt(i) == '\r' || getCharAt(i) == '\n') {
				b = true;
			} else if (getCharAt(i) != ' ') {
				b = false;
				break;
			}
		}
		return b;
	}

	@Override
	public boolean isBlankOrEmpty() {
		return isBlank() || isEmpty();
	}

	@Override
	public boolean isBlankOrNull() {
		return isBlank() || isNull();
	}

	@Override
	public boolean isNull() {
		return this == null;
	}

	@Override
	public boolean isNullOrEmptyOrBlank() {
		return isNull() || isEmpty() || isBlank();
	}
	
	@Override
	public int length() {
		return count;
	}
	@Override
	public int size() {
		return count;
	}

	@Override
	public int shortSize(int subtractSize) {
		return count - subtractSize;
	}

	@Override
	public int shortLength(int subtractLength) {
		return count - subtractLength;
	}

	@Override
	public int indexOf(char c) {
		return indexOf(c, 0);
	}

	@Override
	public int indexOf(char c, int fromIndex) {
		return indexOf(c, fromIndex, length());
	}

	@Override
	public int indexOf(char cs, int start, int end) {
		return indexOf(cs, 0, start, end);
	}

	@Override
	public int indexOf(char cs, int fromIndex, int start, int end) {
		return indexOf(0, cs, fromIndex, start, end);
	}

	@Override
	public int indexOf(int position, char cs) {
		return indexOf(position, cs, 0, length());
	}

	@Override
	public int indexOf(int position, char cs, int fromIndex) {
		return indexOf(position, cs, fromIndex, 0, length());
	}

	@Override
	public int indexOf(int position, char cs, int start, int end) {
		return indexOf(position, cs, 0, start, end);
	}

	@Override
	public int indexOf(int position, char cs, int fromIndex, int start, int end) {
		int index = start + fromIndex;
		while (index < end) {
			if (getCharAt(index) == cs && position == 0) {
				return index;
			} else if (getCharAt(index) == cs && position != 0) {
				position--;
			}
			index++;
		}
		return -1;
	}

	@Override
	public int indexOf(String s) {
		return indexOf(s, 0);
	}

	@Override
	public int indexOf(String s, int fromIndex) {
		return indexOf(s, fromIndex, length());
	}

	@Override
	public int indexOf(String s, int start, int end) {
		return indexOf(s, 0, start, end);
	}

	@Override
	public int indexOf(String s, int fromIndex, int start, int end) {
		return indexOf(0, s, fromIndex, start, end);
	}

	@Override
	public int indexOf(int position, String s, int fromIndex) {
		return indexOf(position, s, fromIndex, 0, length());
	}

	@Override
	public int indexOf(int position, String s, int start, int end) {
		return indexOf(position, s, 0, start, end);
	}

	@Override
	public int indexOf(int position, String s) {
		return indexOf(position, s, 0, 0, length());
	}

	@Override
	public int indexOf(int position, String s, int fromIndex, int start, int end) {
		int index = start + fromIndex;
		while (index < length()) {
			int subIndex = 0;
			while ((++subIndex) < s.length()) {
				if (getCharAt(index + subIndex - 1) != s.charAt(subIndex - 1)) {
					break;
				}
			}
			if (subIndex == s.length() && position == 0) {
				return index;
			} else if (subIndex == s.length() && position != 0) {
				position--;
			}
			index++;
		}
		return -1;
	}

	@Override
	public int relativeIndexOf(char c) {
		return relativeIndexOf(c, 0);
	}

	@Override
	public int relativeIndexOf(char c, int fromIndex) {
		return relativeIndexOf(c, fromIndex, length());
	}

	@Override
	public int relativeIndexOf(char cs, int start, int end) {
		return relativeIndexOf(cs, 0, start, end);
	}

	@Override
	public int relativeIndexOf(char cs, int fromIndex, int start, int end) {
		return relativeIndexOf(0, cs, fromIndex, start, end);
	}

	@Override
	public int relativeIndexOf(int position, char cs) {
		return relativeIndexOf(position, cs, 0, length());
	}

	@Override
	public int relativeIndexOf(int position, char cs, int fromIndex) {
		return relativeIndexOf(position, cs, fromIndex, 0, length());
	}

	@Override
	public int relativeIndexOf(int position, char cs, int start, int end) {
		return relativeIndexOf(position, cs, 0, start, end);
	}

	@Override
	public int relativeIndexOf(int position, char cs, int fromIndex, int start, int end) {
		return indexOf(position, cs, fromIndex, start, end) + 1;
	}

	@Override
	public int lastIndexOf(char ch) {
		int min = offset;
	
		int position = offset + count - 1;
		while ((--position) >= min) {
			if (getCharAt(position) == ch) {
				return position - offset;
			}
		}
		return -1;
	}

	@Override
	public int[] indexOfAll(String target) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i != -1; i = indexOf(target, i + target.length())) {
			list.add(i);
		}
		list.remove(0);
		int[] array = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			array[i] = list.get(i);
		}
		return array;
	}
	
	@Override
	public int[] indexOfAll(char target) {
		String text = new String(character);
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < text.length(); i++) {
			if ((text.charAt(i) == target)) {
				list.add(i);
			}
		}
		int[] array = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			array[i] = list.get(i);
		}
		return array;
	}

	@Override
	public int[] relativeIndeOfAll(String target) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i != -1; i = indexOf(target, i + target.length())) {
			list.add(i + target.length());
		}
		list.remove(0);
		int[] array = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			array[i] = list.get(i);
		}
		return array;
	}

	@Override
	public int[] relativeIndeOfAll(char target) {
		String text = new String(character);
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < text.length(); i++) {
			if ((text.charAt(i) == target)) {
				list.add(i + 1);
			}
		}
		int[] array = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			array[i] = list.get(i);
		}
		return array;
	}

	@Override
	public int reverseIndexOf(char c) {
		return lastIndexOf(c);
	}

	@Override
	public char getFirstChar() {
		return getCharAt(0);
	}

	@Override
	public char getLastChar() {
		return getCharAt(count - 1);
	}
	
	@Override
	public String toString() {
		return new String(character);
	}

	@Override
	public String toString(int min, int max) {
		return new String(character, offset + min, max - min);
	}

	@Override
	public String toString(AbstractStringBuilder asb) {
		return new String(asb.toString());
	}

	@Override
	public Map<Integer, Character> toCharMap() {
		Map<Integer, Character> map = new HashMap<>();
		for (int i = 0; i < count; i++) {
			map.put(i, getCharAt(i));
		}
		return map;
	}

	@Override
	public List<Character> toCharList() {
		List<Character> list = new ArrayList<Character>();
		for (char chars : character) {
			list.add(chars);
		}
		return list;
	}

	@Override
	public char[] toCharArray() {
		return character;
	}

	public interface Replacement {
		String replacement(String target);
	}
	
	public class StringBuilderIndexOutOfBoundsException extends IndexOutOfBoundsException {
		public StringBuilderIndexOutOfBoundsException() { super(); }
		public StringBuilderIndexOutOfBoundsException(Throwable cause) { super(cause); }
		public StringBuilderIndexOutOfBoundsException(String msg) { super(msg); }
		public StringBuilderIndexOutOfBoundsException(String msg, Throwable cause) { super(msg, cause); }
		public StringBuilderIndexOutOfBoundsException(int msg) {super(msg);}
		public StringBuilderIndexOutOfBoundsException(int msg, Throwable cause) {super(msg, cause);}
		public StringBuilderIndexOutOfBoundsException(byte msg) {super(msg);}
		public StringBuilderIndexOutOfBoundsException(byte msg, Throwable cause) {super(msg, cause);}
		public StringBuilderIndexOutOfBoundsException(short msg) {super(msg);}
		public StringBuilderIndexOutOfBoundsException(short msg, Throwable cause) {super(msg, cause);}
		public StringBuilderIndexOutOfBoundsException(long msg) {super(msg);}
		public StringBuilderIndexOutOfBoundsException(long msg, Throwable cause) { super(msg, cause); }
		public StringBuilderIndexOutOfBoundsException(float msg) { super(msg); }
		public StringBuilderIndexOutOfBoundsException(float msg, Throwable cause) { super(msg, cause); }
		public StringBuilderIndexOutOfBoundsException(double msg) { super(msg); }
		public StringBuilderIndexOutOfBoundsException(double msg, Throwable cause) { super(msg, cause); }
		public StringBuilderIndexOutOfBoundsException(char msg) { super(msg); }
		public StringBuilderIndexOutOfBoundsException(char msg, Throwable cause) { super(msg, cause); }
		public StringBuilderIndexOutOfBoundsException(boolean msg) { super(msg); }
		public StringBuilderIndexOutOfBoundsException(boolean msg, Throwable cause) { super(msg, cause); }
		public StringBuilderIndexOutOfBoundsException(CharSequence msg) { super(msg); }
		public StringBuilderIndexOutOfBoundsException(CharSequence msg, Throwable cause) { super(msg, cause); }
	}
}
