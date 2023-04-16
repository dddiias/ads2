package lists;

public class MyArrayList<T> implements MyList<T>{
    private Object[] elements;
    private int size;

    public MyArrayList() {
        elements = new Object[10];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(elements[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(T element) {
        if (size == elements.length) {
            Object[] newArray = new Object[elements.length * 2];
            System.arraycopy(elements, 0, newArray, 0, elements.length);
            elements = newArray;
        }
        elements[size] = element;
        size++;
    }

    @Override
    public void add(Object item, int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        if (size == elements.length) {
            Object[] newArray = new Object[elements.length * 2];
            System.arraycopy(elements, 0, newArray, 0, index);
            newArray[index] = item;
            System.arraycopy(elements, index, newArray, index + 1, size - index);
            elements = newArray;
        } else {
            System.arraycopy(elements, index, elements, index + 1, size - index);
            elements[index] = item;
        }
        size++;
    }

    @Override
    public boolean remove(Object item) {
        int index = indexOf(item);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    @Override
    public T remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        T removed = (T) elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[size - 1] = null;
        size--;
        return removed;
    }


    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        return (T) elements[index];
    }

    @Override
    public int indexOf(Object element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object element) {
        for (int i = size - 1; i >= 0; i--) {
            if (element.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void sort() {
        int n = size;
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (((Comparable) elements[i]).compareTo(elements[i-1]) < 0) {
                    Object temp = elements[i];
                    elements[i] = elements[i-1];
                    elements[i-1] = temp;
                    swapped = true;
                }
            }
            n--;
        }
    }
}
