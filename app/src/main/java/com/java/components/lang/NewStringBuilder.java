package com.java.components.lang;

public class NewStringBuilder {
    public static Clazz<?> clazz = new Clazz<>(NewStringBuilder.class);

    protected char[] characters;
    protected int count;
    protected int capacity;
    protected int offset;

    public NewStringBuilder() {
        this.characters = new char[capacity];
        this.count = 0;
        this.offset = 0;
        this.capacity = 0;
    }

    public NewStringBuilder(Capacity capacity) {
        this.capacity = capacity.getCapacity();
        this.characters = new char[this.capacity];
        this.count = 0;
        this.offset = 0;
    }

    public NewStringBuilder(String text) {
        this.characters = text.toCharArray();
        this.capacity = 0;
        this.count = this.characters.length;
        this.offset = 0;
    }

    public NewStringBuilder setCharAt(int position, char character) {
        if (position > count || position < 0) {
            throw new CompilerTaskException(count);
        }
        this.characters[position] = character;
        return this;
    }

    public char getChatAt(int position) {
        if (position > count || position < 0) {
            throw new CompilerTaskException(count);
        }
        return this.characters[position];
    }

    public boolean endsWith(char character, int position) {
        return startsWith(character, this.characters.length - position);
    }

    public boolean endsWith(char character) {
        return endsWith(character, 0);
    }

    public boolean startsWith(char character, int position) {
        return this.characters[position] == character;
    }

    public boolean startsWith(char character) {
        return startsWith(character, 0);
    }

    public int indexOf(int position, char character, int fromIndex, int startRange, int endRange) {
        if (fromIndex > count) {
            throw new CompilerTaskException(fromIndex);
        }
        if (startRange > count) {
            throw new CompilerTaskException(fromIndex);
        }
        if (endRange < 0) {
            throw new CompilerTaskException(fromIndex);
        }
        if (endRange < startRange) {
            throw new CompilerTaskException(endRange - startRange);
        }
        int index = -1;
        for (
            int tmp = startRange + (fromIndex < 0 ? 0 : fromIndex);
            tmp < endRange;
            tmp++
        ) {
            if (character == this.characters[tmp]) {
                if (position == 0) {
                    return tmp;
                } else {
                    position--;
                }
            }
        }
        return index;
    }

    public int indexOf(int position, char character, int startRange, int endRange) {
        return indexOf(position, character, 0, startRange, endRange);
    }

    public int indexOf(int position, char character, int fromIndex) {
        return indexOf(position, character, fromIndex, 0, count);
    }

    public int indexOf(int position, char character) {
        return indexOf(position, character, -1);
    }

    public int indexOf(char character, int fromIndex, int startRange, int endRange) {
        return indexOf(0, character, fromIndex, startRange, endRange);
    }

    public int indexOf(char character, int startRange, int endRange) {
        return indexOf(0, character, 0, startRange, endRange);
    }

    public int indexOf(char character, int fromIndex) {
        return indexOf(character, -1, 0, count);
    }

    public int indexOf(char character) {
        return indexOf(character, -1);
    }

    public int getCapacity() {
        return capacity;
    }

    public int lenght() {
        return count;
    }

    public int size() {
        return count;
    }

    public int getOffset() {
        return offset;
    }

    public int getId() {
        return 18;
    }

    public boolean contains(char character) {
        return indexOf(character) >= 0;
    }

    public Clazz<?> getClazz() {
        return new Clazz<>(NewStringBuilder.class);
    }
}
