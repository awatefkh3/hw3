import java.lang.reflect.InvocationTargetException;
import java.lang.reflect. *;
import java.util.Iterator;

public class ArrayStack<T extends Cloneable> implements Stack, Cloneable {
    protected int maxCapacity;
    protected T[] stackArray;/** stack of elements from type T */
    protected int headIndex;/** the index of the first */

    /**
     * Constructor that recieves the max capacity and creates an ArrayStack.
     * @param maxCapacity - the max capacity of the stack.
     * @throws NegativeCapacityException - throws an exception if the capacity given is negative.
     */
    public ArrayStack(int maxCapacity) throws NegativeCapacityException{
        if(maxCapacity < 0){
            throw new NegativeCapacityException();
        }
        this.maxCapacity = maxCapacity;
        this.headIndex = -1;
        this.stackArray =  (T[]) new Cloneable[maxCapacity];
    }

    /**
     * creates a deep clone of the arrayStack.
     * @return deep copy of this ArrayStack
     */
    @Override
    public ArrayStack<T> clone() {
        try{
            ArrayStack<T> temp = (ArrayStack<T>) super.clone();
            temp.headIndex = this.headIndex;
            temp.maxCapacity = this.maxCapacity;
            temp.stackArray = this.stackArray.clone();
            for(int i = 0; i < temp.stackArray.length; i++){
                if(temp.stackArray[i] != null){
                    temp.stackArray[i] = (T) temp.stackArray[i].getClass().getMethod("clone")
                            .invoke(temp.stackArray[i]);
                }
            }

            return temp;
        }
        catch (CloneNotSupportedException e) {
            return null;
        }
        catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * receives an element and pushes the element into the top of the stack.
     * @param element the element to be added to the stack.
     * @throws StackOverflowException - trows an exception if there is an attempt to add an element to a full stack.
     */
    @Override
    public void push(Cloneable element) throws StackOverflowException{
        if(this.headIndex +1 < this.maxCapacity){
            this.stackArray[this.headIndex+1] = (T) element;
            this.headIndex++;
        }
        else
            throw new StackOverflowException();
    }

    /**
     * returns the top element and removes it from the stack.
     * @return the top element from the ArrayStack.
     * @throws EmptyStackException - throws an exception if the ArrayStack is empty.
     */
    @Override
    public Cloneable pop() throws EmptyStackException{
        if(this.headIndex != -1)
        {
            this.headIndex--;
            T temp = this.stackArray[this.headIndex+1];
            this.stackArray[this.headIndex+1] = null;
            return temp;
        }
        else{
            throw new EmptyStackException();
        }
    }

    /**
     * returns the top element of the ArrayStack without removing it.
     * @return the top element.
     * @throws EmptyStackException - throws an exception if the ArrayStack is empty.
     */
    @Override
    public Cloneable peek() throws EmptyStackException{
        if(this.headIndex == -1)
            throw new EmptyStackException();
        return this.stackArray[this.headIndex];
    }

    /**
     * calculates the size of the current ArrayStack.
     * @return the size of the ArrayStack.
     */
    @Override
    public int size() {
        return this.headIndex+1;
    }

    /**
     * returns whether the stack is empty.
     * @return true if the stack is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return this.headIndex == -1;
    }

    /**
     * creates an iterator over the stack.
     * @return new iterator of this stack.
     */
    @Override
    public Iterator<T> iterator() {
        return new StackIterator(this);
    }

    public class StackIterator<T> implements Iterator<T>{
        ArrayStack arrayStack;/** the arrayStack over which it iterates.*/

        /**
         * constructor for the stackIterator
         * @param arrayStack - the arrayStack to iterate over.
         */
        public StackIterator(ArrayStack arrayStack){
            this.arrayStack = arrayStack.clone();
        }

        /**
         * checks if the iterator has next element to iterate over.
         * @return true if there is a next element, false otherwise.
         */
        @Override
        public boolean hasNext() {
            return !arrayStack.isEmpty();
        }

        /**
         * returns the next element of the iterator.
         * @return the next element of the iterator.
         */
        @Override
        public T next() {
            if(hasNext()){
                return (T) arrayStack.pop();
            }
            else{
                return null;
            }
        }
    }
}
