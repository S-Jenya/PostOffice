package ru.oti;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        System.out.println("-----Вас приветствует лучшая почта ОТИ МИФИ-----\n");

        // заказ
        Order order =  new Order();
        order.createOrder();

        System.out.println("\n-----Конец работы программы-----\n");
    }
}
