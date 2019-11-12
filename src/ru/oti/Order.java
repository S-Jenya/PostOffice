package ru.oti;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Order {

    private int ID = 0;
    private static String date;
    private ArrayList<Letter> parcels = new ArrayList<>(5);
    Letter letter;

    public static String data(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        date = simpleDateFormat.format(new Date());
        return date;
    }

    public void createOrder() {

        for(int i = 0; i < 2; i++){
            letter = new SimpleLetter();
            letter.setMyFormat(MyFormat.EURO);
            parcels.add(letter);
            System.out.println("Номер заказа: " + i);
            parcels.get(i).Title();
            System.out.println("Формат письма: " + parcels.get(i).getMyFormat());
            System.out.println("Способ доставки: " + parcels.get(i).getDeliveryMethod());
            System.out.println("Способ вручения: " + parcels.get(i).getHandingOver());
            System.out.println("Дата создания: " + Order.data() + "\n");
        }
    }

}
