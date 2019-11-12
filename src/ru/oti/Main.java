package ru.oti;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("-----Вас приветствует лучшая почта ОТИ МИФИ-----\n");

        // заказ
        Order order =  new Order();
        order.createOrder();

        System.out.println("\n-----Конец работы программы-----\n");
    }
}
