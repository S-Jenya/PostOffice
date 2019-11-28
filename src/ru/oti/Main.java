package ru.oti;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int choice;

    public static void main(String[] args)  {

        System.out.println("\n-----Вас приветствует лучшая почта ОТИ МИФИ-----");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Order order =  new Order();

        boolean flag = false;
        do {
            try {
                System.out.println("\nГлавное меню");
                System.out.println("1. Сделать заказ.");
                System.out.println("2. Информация о заказе.");
                System.out.println("3. Выйти из программы.");
                System.out.print("Выберите вид услуги: ");
                choice = Integer.parseInt(reader.readLine());

                switch (choice) {
                    case 1:
                        order.createOrder();
                        break;
                    case 2:
                        System.out.println("\nВаша корзина: ");
                        order.ShowInfo();
                        break;
                    case 3:
                        flag = true;
                        break;
                    default:
                        if (flag == false) System.out.println("Некорректные данные.\nПовторите ввод!\n");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Некорректные данные!");
            }

        } while (flag == false);


        System.out.println("\n-----Конец работы программы-----\n");
    }
}
