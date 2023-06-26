public interface Stack<E extends Cloneable> extends Iterable<E>, Cloneable {
    /**
     * pushes an element into the stack.
     * @param element the element to add to the stack.
     */
    void push(E element);

    /**
     * returns the top element of the stack, and removes the element.
     * @return the top element
     */
    E pop();

    /**
     * returns the top element without removing it.
     * @return the top element.
     */
    E peek();

    /**
     * returns the size of the stack.
     * @return the size of stack.
     */
    int size();

    /**
     * returns whether the stack is empty.
     * @return true if empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * clones the stack
     * @return a clone of the stack.
     */
    Stack<E> clone();
}


