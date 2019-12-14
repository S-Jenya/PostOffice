package ru.oti;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static int choice;
    public static ArrayList<Order> parcels = new ArrayList<>();
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static void ShowInfo(){

        System.out.println("\n----- Ваши заказы -----\n");

        int count = parcels.size();
        if(count == 0) {
            System.out.println("Заказов не обнаружено!");
        } else {
            for(int i = 0; i < count; i ++) {
                System.out.println("Описание услуг заказа ID = " + (parcels.get(i).getID()));
                parcels.get(i).getInfo();
                System.out.println("Дата заказа: " +  parcels.get(i).getData());
                System.out.print("\n");
            }
        }

    }

    private static void delOrder(){
        boolean flag = false;
        boolean deleted = false;
        do {
            try{
                System.out.println("\n----- Удаление заказа -----\n");
                if(parcels.size() == 0) {
                    System.out.println("Заказов не обнаружено!");
                    break;
                }
                System.out.println("Для удаления заказа, введите ID заказа");
                System.out.println("Для отмены операции удаления заказа введите \"0\"");
                System.out.print("Ввод: ");
                choice = Integer.parseInt(reader.readLine());
                if (choice == 0) {
                    break;
                }
                if(!parcels.isEmpty()){

                    int count = parcels.size();
                    for(int i = 0; i < count; i ++) {
                        if(choice == parcels.get(i).getID()){
                            parcels.remove(i);
                            System.out.println("Удаление заказа ID = " + choice + " прошло успешно!");
                            deleted = true;
                            flag = true;
                            break;
                        }
                    }

                    if(!deleted){
                        System.out.println("Заказа с ID = " + choice + " не существует!");
                    }

                    /*if(choice == parcels.get(choice).getID()){
                        parcels.remove(choice);
                        System.out.println("Удаление заказа ID = " + choice + " прошло успешно!");
                        flag = true;
                        break;
                    }*/
                } else {
                    System.out.println("\nНет заказов!");
                }
            } catch (Exception e) {
                System.out.println("Некорректные данные!");
            }
        } while (flag == false);
    }

    public static void main(String[] args)  {

        System.out.println("\n----- Почтовое отделение -----");

        boolean flag = false;
        do {
            Order order =  new Order();
            try {
                System.out.println("\n----- Главное меню -----");
                System.out.println("1. Сделать заказ.");
                System.out.println("2. Информация о заказе.");
                System.out.println("3. Удалить заказ.");
                System.out.println("0. Выход.");
                System.out.print("Выберите вид услуги: ");
                choice = Integer.parseInt(reader.readLine());

                switch (choice) {
                    case 1:
                        order.makeAnOrder();
                        parcels.add(order);
                        if(parcels.lastIndexOf(order) == 0){
                            order.setID(1);
                        } else {
                            /* Запоминаем ID у предпоследнего элемента в списке заказов */
                            int i = parcels.get(parcels.lastIndexOf(order) - 1).getID();
                            /* Присваиваем ID последнему элементу списка заказов */
                            order.setID(i + 1);
                        }
                        order.setData();
                        break;
                    case 2:
                        ShowInfo();
                        break;
                    case 3:
                        delOrder();
                        break;
                    case 0:
                        flag = true;
                        break;
                    default:
                        if (flag == false) System.out.println("Некорректные данные. Повторите ввод!\n");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Некорректные данные!");
            }

        } while (flag == false);

        System.out.println("\n----- Конец работы программы -----\n");
    }
}
