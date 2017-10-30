package javaee.example;

import javaee.example.domain.Telefon;

import java.util.*;

public class Cart implements List<Telefon> {
    List<Telefon> items;

    public Cart(){
        items = new ArrayList<>();
    }

    @Override
    public int size() {
        return items.size();
    }

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return items.contains(o);
    }

    @Override
    public Iterator<Telefon> iterator() {
        return items.iterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return items.toArray(a);
    }

    @Override
    public boolean add(Telefon telefon) {
        return items.add(telefon);
    }

    @Override
    public boolean remove(Object o) {
        return items.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return items.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends Telefon> c) {
        return items.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends Telefon> c) {
        return items.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return items.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return items.retainAll(c);
    }

    @Override
    public void clear() {

    }

    @Override
    public Telefon get(int index) {
        return items.get(index);
    }

    @Override
    public Telefon set(int index, Telefon element) {
        return items.set(index, element);
    }

    @Override
    public void add(int index, Telefon element) {

    }

    @Override
    public Telefon remove(int index) {
        return items.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return items.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return items.lastIndexOf(o);
    }

    @Override
    public ListIterator<Telefon> listIterator() {
        return items.listIterator();
    }

    @Override
    public ListIterator<Telefon> listIterator(int index) {
        return items.listIterator();
    }

    @Override
    public List<Telefon> subList(int fromIndex, int toIndex) {
        return items.subList(fromIndex, toIndex);
    }


}
