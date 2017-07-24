package ua.nure.bushuy;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by sbushui on 7/6/2017.
 */
public class MyListImpl implements MyList, ListIterable{
    MyListImpl() {
        array = new Object[5];
        countOfElements = 0;
    }
    Object[] array;
    int countOfElements;

    @Override
    public void add(Object e) {
        if (checkCapacity()) {
            array[countOfElements] = e;
            countOfElements++;
        }
        else {
            Object[] newArray = new Object[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
            array[countOfElements + 1] = e;
            countOfElements++;
        }
    }

    @Override
    public void clear() {
        array = new Object[5];
        countOfElements = 0;
    }

    @Override
    public boolean remove(Object o) {
        int elementIndex = getElementIndex(o);
        if(elementIndex > 0) {
            removeByIndex(elementIndex);
            return true;
        }
        return false;

    }
    public boolean removeByIndex(int index) {
        if (index >= 0) {
            Object[] newArray = new Object[array.length - 1];
            System.arraycopy(array, 0, newArray, 0, index);
            System.arraycopy(array, index + 1, newArray, index, array.length - index - 1);
            array = newArray;
            countOfElements--;
            return true;
        }
        return false;
    }
    @Override
    public Object[] toArray() {
        Object[] newArray = new Object[countOfElements];
        System.arraycopy(array, 0, newArray, 0, countOfElements);
        return newArray;
    }

    @Override
    public int size() {
        return countOfElements;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            for (Object obj : array) {
                if (o == obj) {
                    return true;
                }
                return false;
            }
        }
            for (Object obj : array) {
                if (o.equals(obj)) {
                    return true;
                }
            }
        return false;
    }

    @Override
    public boolean containsAll(MyList c) {
        int countOfEquals = 0;
        for(Object obj : c.toArray()) {
            if(contains(obj)) {
                countOfEquals++;
            }
        }
        return countOfEquals == c.size();
    }
    @Override
    public String toString() {
        if(countOfElements > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < countOfElements; i++) {
                if (array[i] == null) {
                    sb.append("null, ");
                    continue;
                }
                sb.append(array[i].toString() + ", ");
            }
            return sb.toString().substring(0, sb.length() - 2);
        }
        return "";
    }
    private boolean checkCapacity() {
        return array.length - countOfElements > 0;
    }
    private int getElementIndex(Object o) {
        if(o == null) {
            for (int i = 0; i < array.length; i++) {

                if (array[i] == null) {
                    return i;
                }
            }
            return -1;
        }

        for (int i = 0; i < array.length; i++) {

            if (o.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    @Override
    public ListIterator listIterator() {
        return new ListIteratorImpl() {
        };
    }

    private class IteratorImpl implements Iterator<Object> {

        int cursor = 0;       // index of next element to return
        int lastRet = -1; // index of last element returned; -1 if no such
        @Override
        public boolean hasNext() {
            return cursor != countOfElements;
        }

        @Override
        public Object next() {
            int i = cursor;
            if (i >= countOfElements)
                throw new NoSuchElementException();
            cursor = i + 1;
            return array[lastRet = i];
        }


        @Override
        public void remove() {
            if (lastRet < 0) {
                throw new IllegalStateException();
            }

            removeByIndex(lastRet);
            cursor = lastRet;
            lastRet = -1;
        }
    }
    private class ListIteratorImpl extends IteratorImpl implements ListIterator{

        @Override
        public boolean hasPrevious() {
            return cursor >=0;
        }

        @Override
        public Object previous() {
            int i = cursor;
            if (i < 0)
                throw new NoSuchElementException();
            cursor = i - 1;
            return array[lastRet = i];
        }

        @Override
        public void set(Object e) {
            array[lastRet] = e;
        }

    }
}
