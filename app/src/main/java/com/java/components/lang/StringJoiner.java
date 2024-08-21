package com.java.components.lang;

import java.util.ArrayList;

public class StringJoiner {
	private ArrayList<String> elt;
    private final String prefix;
    private final String delimiter;
    private final String suffix;

	public StringJoiner(String delimiter) {
		this("", delimiter, "");
	}

	public StringJoiner(String prefix, String delimiter, String suffix) {
		this.elt = new ArrayList<>();
		this.prefix = prefix;
		this.delimiter = delimiter;
		this.suffix = suffix;
	}

	public StringJoiner add(String text) {
		elt.add(text);
		return this;
	}

	public StringJoiner remove(int position) {
		elt.remove(position);
		return this;
	}

	public int size() {
		String tmp = toString();
		return tmp.length();
	}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
		sb.append(this.prefix);
		for (int i = 0; i < elt.size(); i++) {
			sb.append(elt.get(i));
			sb.append(delimiter);
		}
		if (sb.toString().endsWith(delimiter)) {
			sb.delete(sb.length() - delimiter.length(), sb.length());
		}
		sb.append(this.suffix);
		return sb.toString();
    }

    public String getDelimiter() {
        return delimiter;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getSuffix() {
        return suffix;
    }
}
