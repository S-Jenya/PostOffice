package ru.oti;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.io.BufferedReader;
import java.io.IOException;
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

    public static String data(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        date = simpleDateFormat.format(new Date());
        return date;
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void createOrder() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        boolean flag = false;
        do {
            System.out.println("Выберите вид услуги");
            System.out.println("1. Простое письмо");
            System.out.println("2. Заказное письмо");
            System.out.println("3. Заказное письмо 1 класса");
            System.out.println("4. Ценное письмо");
            System.out.println("5. Ценное письмо 1 класса");
            System.out.println("6. Экспресс-письмо EMS");

            try {
                choice = Integer.parseInt(reader.readLine());

            } catch (Exception e) {
                System.out.println("Exception!");
            }
            switch (choice) {
                case 1:
                    System.out.println("1. Простое письмо");
                    flag = true;
                    break;
                case 2:
                    System.out.println("2. Заказное письмо");
                    flag = true;
                    break;
                case 3:
                    System.out.println("3. Заказное письмо 1 класса");
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
                    flag = true;
                    break;
                default:
                    if (flag == false) System.out.println("Некорректные данные.\nПовторите ввод!\n");
                    break;
            }

        } while (flag == false);

//        Runtime.getRuntime().exec("cls");
        Order.clearScreen();

        try {
            choice = Integer.parseInt(reader.readLine());
        } catch (Exception e){
            System.out.println("Exception!");
        }

        for(int i = 0; i < 2; i++){
            letter = new OrderedLetter();
            letter.setMyFormat(MyFormat.EURO);

            parcels.add(letter);
            parcels.get(i).Title();
            parcels.get(i).getTrackNumber();
            System.out.println("Номер заказа: " + i);
            System.out.println("Формат письма: " + parcels.get(i).getMyFormat());
            System.out.println("Способ доставки: " + parcels.get(i).getDeliveryMethod());
            System.out.println("Способ вручения: " + parcels.get(i).getHandingOver());
            System.out.println("Дата создания: " + Order.data() + "\n");
        }


    }

}
