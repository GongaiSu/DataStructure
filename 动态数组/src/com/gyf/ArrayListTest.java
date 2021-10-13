package com.gyf;

import java.util.Arrays;

/**
 * 自定义动态数组
 *
 * @author 龚燕飞
 * @date 2021/9/22
 */
public class ArrayListTest<E> {

    private int size;

    private E[] elements;

    private static final int DEFAULT_CAPACITY = 10;

    public ArrayListTest() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayListTest(int capacity) {
        capacity = capacity > DEFAULT_CAPACITY ? capacity : DEFAULT_CAPACITY;
        elements = (E[]) new Object[capacity];
    }

    public int size() // 元素的数量
    {
        return size;
    }

    public boolean isEmpty() // 是否为空
    {
        return size == 0;
    }

    public boolean contains(E element) // 是否包含某个元素
    {
        return indexOf(element) > 0;
    }

    public void add(E element) // 添加元素到最后面
    {
        add(size, element);
    }

    public E get(int index) // 返回index位置对应的元素
    {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("数组下标越界");
        }
        return elements[index];
    }

    public E set(int index, E element) // 设置index位置的元素
    {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("数组下标越界");
        }
        E oldElement = elements[index];
        elements[index] = element;
        return oldElement;
    }

    public void add(int index, E element) // 往index位置添加元素
    {
        ensureCapacity(size + 1);
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("数组下标越界");
        }
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    private void ensureCapacity(int capacity) {
        int oldCapacity=elements.length;
        if (oldCapacity>capacity) {
            return;
        }
        int newCapacity= oldCapacity +(oldCapacity>>1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i]=elements[i];
        }
        elements=newElements;
    }

    public E remove(int index) // 删除index位置对应的元素
    {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("数组下标越界");
        }
        E oldElement = elements[index];
        for (int i = index; i < size; i++) {
            elements[i - 1] = elements[i];
        }
        elements[--size] = null;
        return oldElement;
    }

    public int indexOf(E element) // 查看元素的位置
    {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public void clear() // 清除所有元素
    {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("size=").append(size).append(", [");
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                string.append(", ");
            }

            string.append(elements[i]);

//			if (i != size - 1) {
//				string.append(", ");
//			}
        }
        string.append("]");
        return string.toString();
    }
}
