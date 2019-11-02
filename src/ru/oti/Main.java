package ru.oti;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Letter letter = new SimpleLetter();
        letter.setMyFormat(MyFormat.C4);
        System.out.println("My format is " + letter.getMyFormat());
        System.out.println("Delivery is " + letter.getDeliveryMethod());
        System.out.println("HandingOver is " + letter.getHandingOver());
    }
}
