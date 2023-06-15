import java.lang.reflect.InvocationTargetException;
import java.lang.reflect. *;
import java.util.Iterator;

public class ArrayStack<T extends Cloneable> implements Stack, Cloneable {
    protected int maxCapacity;
    protected T[] stackArray;
    protected int headIndex;
    public ArrayStack(int maxCapacity) throws NegativeCapacityException{
        if(maxCapacity < 0){
            throw new NegativeCapacityException();
        }
        this.maxCapacity = maxCapacity;
        this.headIndex = -1;
        this.stackArray =  (T[]) new Cloneable[maxCapacity];
    }

    @Override
    public ArrayStack<T> clone() {
        try{
            ArrayStack<T> temp = (ArrayStack<T>) super.clone();
            temp.headIndex = this.headIndex;
            temp.maxCapacity = this.maxCapacity;
//            Class c = ;
//            stackArray[0].
//            Method m = c.getMethods();
//            temp.stackArray = c[2].invoke(this.stackArray);
//            if(headIndex != -1)
//                temp.stackArray = (T[]) (stackArray[0].getClass().getMethod("clone").invoke(this.stackArray));
            temp.stackArray = this.stackArray.clone();
//            for(int i = 0 ; i < temp.headIndex; i++){
//                T t = (T) new Cloneable();
//                temp.stackArray[i] = this.stackArray[i];
//            }
            return temp;
        }
        catch (CloneNotSupportedException e) {
            return null;
//        } catch (InvocationTargetException e) {
//            throw new RuntimeException(e);
//        } catch (IllegalAccessException e) {
//            throw new RuntimeException(e);
//        } catch (NoSuchMethodException e){
//            throw new RuntimeException(e);
        }
    }



    @Override
    public void push(Cloneable element) throws StackOverflowException{
        if(this.headIndex +1 < this.maxCapacity){
            this.stackArray[this.headIndex+1] = (T) element;
            this.headIndex++;
        }
        else
            throw new StackOverflowException();
    }

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

    @Override
    public Cloneable peek() throws EmptyStackException{
        if(this.headIndex == -1)
            throw new EmptyStackException();
        return this.stackArray[this.headIndex];
    }

    @Override
    public int size() {
        return this.headIndex+1;
    }

    @Override
    public boolean isEmpty() {
        return this.headIndex == -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator(this);
    }

    public class StackIterator<T> implements Iterator<T>{
        ArrayStack arrayStack;

        public StackIterator(ArrayStack arrayStack){
            this.arrayStack = arrayStack.clone();
        }

        @Override
        public boolean hasNext() {
            return !arrayStack.isEmpty();
        }

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
