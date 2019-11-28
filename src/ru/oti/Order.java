package ru.oti;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Order {

    private int ID = 0;
    private static String date;
    private ArrayList<Letter> parcels = new ArrayList<Letter>();
    static int choice = 0;
    Letter letter;

    public static String setData(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        date = simpleDateFormat.format(new Date());
        return date;
    }

    private int getID(){
        return ID;
    }

    public void ShowInfo(){
        int count = getID();

        if(count == 0) {
            System.out.println("Корзина пуста. Заказов не обнаружено!");
        } else {
            for(int i = 0; i < count; i ++) {
                System.out.println("Описание услуг заказа № " + (i + 1));
                parcels.get(i).info();
                System.out.println("\n");
            }
        }
    }

    public void createOrder() {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        boolean flag = false;
        do {
            try {
                System.out.println("\nТипы письма: ");
                System.out.println("1. Простое письмо");
                System.out.println("2. Заказное письмо");
                System.out.println("3. Заказное письмо 1 класса");
                System.out.println("4. Ценное письмо");
                System.out.println("5. Ценное письмо 1 класса");
                System.out.println("6. Экспресс-письмо EMS");
                System.out.print("Выберите вид услуги: ");
                choice = Integer.parseInt(reader.readLine());

                switch (choice) {
                    case 1:
                        letter = new SimpleLetter();

                        parcels.add(letter);
                        System.out.println("\nДоступные форматы:");
                        letter.setMyFormat(MyFormat.NONE);
                        System.out.println("\nСпособы получения:");
                        letter.setHandingOver();

                        flag = true;
                        break;
                    case 2:
                        letter = new OrderedLetter();

                        parcels.add(letter);
                        System.out.println("\nДоступные форматы:");
                        letter.setMyFormat(MyFormat.NONE);
                        System.out.println("\nСпособы получения:");
                        letter.setHandingOver();
                        letter.SMSNotification();
                        letter.deliveryNotice();

                        flag = true;
                        break;
                    case 3:
                        letter = new OrderedLetterFirstClass();

                        parcels.add(letter);
                        System.out.println("\nДоступные форматы:");
                        letter.setMyFormat(MyFormat.NONE);
                        System.out.println("\nСпособы получения:");
                        letter.setHandingOver();
                        letter.SMSNotification();
                        letter.deliveryNotice();
                        letter.callDelivery();;

                        flag = true;
                        break;
                    case 4:
                        System.out.println("4. Ценное письмо");
                        flag = true;
                        break;
                    case 5:
                        System.out.println("5. Ценное письмо 1 класса");
                        flag = true;
                        break;
                    case 6:
                        System.out.println("6. Экспресс-письмо EMS");
                        letter = new EMSLetter();
                        letter.inventoryOfContents();
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

        ID++;

    }

}
