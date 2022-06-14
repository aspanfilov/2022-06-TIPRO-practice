package L01.Stack;

import java.util.Arrays;

public class Stack<T> {

    private T[] stack;
    private int position;

    public Stack() {
        stack = (T[]) new Object[3];
        position = 0;
    }

    public T push(T value) {
        if (position == stack.length) {
            stack = Arrays.copyOf(stack, (int) (stack.length * 1.5));
        }
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
        return value;
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
