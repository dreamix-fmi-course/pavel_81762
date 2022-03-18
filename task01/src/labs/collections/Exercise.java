package labs.collections;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class Exercise {

    public static void main(String[] args) {
        Dog kiro = new Dog("retriver", 25);
        Dog kiro2 = new Dog("pitbull", 35);
        Dog malkiq = new Dog("ovcharka", 10);
        ArrayList<Dog> dogs = new ArrayList<>();
        dogs.add(kiro);
        dogs.add(kiro2);
        dogs.add(malkiq);
        sort(dogs);
    }
    // T0) Write a method to insert an element into the array list at the first position
    public static void insertFirstPosition(ArrayList<Integer> l, int element){
        l.add(0, element);
    }
    // T1) Write a method to retrieve an element (at a specified index) from a given list.
    public static int getIndex(int index, ArrayList<Integer> l){
        return l.get(index);
    }
    // T2) Write a method to remove the third element from an array list.
    public static void removeThird(ArrayList<Integer> l){
        l.remove(2);
    }
    // T3) Write a method to search an element in a list.
    public static boolean search( ArrayList<Integer> l,int element){
        for (Integer el: l){
            if(el == element){
                return true;
            }
        }
        return false;
    }
    // T4) Write a method to sort a given array list. (list of String/Integer/Dog).
    // Implement Dog class with attribute breed and weight, sort the array by weight property.
    // Tip: implement the task with Comparator and Comparable
    public static void sort(ArrayList<Dog> dogs){
        Collections.sort(dogs);
        for (Dog dog: dogs){
            System.out.print(dog.getBreed() + " ");
        }
    }
    // T5) Write a method to replace the second element of a ArrayList with the specified element.
    public static void replaceSecond(ArrayList<Integer> l, int element){
        if(l.size() > 2)
        l.set(1, element);
        else System.out.println("List is too short");
    }
    // T6)?? Write a Java program to count the number of key-value (size) mappings in a map.
    public static int countMappings(String key, int value, HashMap<String, Integer> m){
        int counter = 0;
        for (Map.Entry<String, Integer> e: m.entrySet()){
            if(e.getKey() == key && e.getValue() == value){
                counter++;
            }
        }
        return counter;
    }

    // T7) Write the following structure against aircraft tail number associate
    // list of leg information (fromAirport, toAirport, date).
    // Fill test information
    // Extract legs inside list/set that have from/to airport for a specific airport
    // (Example: All legs for airport LBSF)
}
