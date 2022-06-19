package L01.Stack;

import java.util.Arrays;

public class Stack<T> {

    private T[] stack;
    private int position;

    private final static int GROWTH = 10;

    public Stack() {
        stack = (T[]) new Object[GROWTH];
        position = 0;
    }

    public T push(T value) {
        growAsNeeded();
        stack[position] = value;
        position++;
        return value;
    }

    public T pop() {
        if (position == 0) {
            throw new IndexOutOfBoundsException();
        }
        position--;
        T value = stack[position];
        stack[position] = null;
        reduceAsNeeded();
        return value;
    }

    private void growAsNeeded() {
        if (position == stack.length) {
            stack = Arrays.copyOf(stack,  stack.length + GROWTH);
        }
    }

    private void reduceAsNeeded() {
        if ((stack.length - position) >= GROWTH) {
            stack = Arrays.copyOf(stack, stack.length - GROWTH);
        }
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("Stack[");
        Arrays.stream(stack)
                .limit(position)
                .forEach(val -> sb.append(val.toString()).append(", "));
        if (position > 0) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append("]");

        return sb.toString();

    }
}
