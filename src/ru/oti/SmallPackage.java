package ru.oti;

import java.util.Random;
import java.lang.Object;

public class SmallPackage extends Box {

    public SmallPackage(){
        setMyFormat();
        setCountry();
        setDelivery(Delivery.ORDINARY_DELIVERY);
    }

    @Override
    public void setCountry(){

        boolean flag = false;
        do {
            try {
                String myCountry;
                System.out.print("\nУстановка страны получателя");
                System.out.print("\nВвод: ");
                myCountry = reader.readLine();
                /* Удаление пробелов до и после */
                myCountry = myCountry.trim();
                /* Сравнение введённой страны с "Россия" */
                if (!"россия".equals(myCountry.toLowerCase())){
                    setCountry(myCountry);
                    flag = true;
                    break;
                } else {
                    System.out.println("Доставка \"Маленького пакета\" осуществляется только за пределы Российской Федерации");
                    System.out.println("Повторите ввод!");
                }

            } catch (Exception e) {
                System.out.println("Повторите ввод!\n");
            }
        } while (flag == false);

        System.out.println("Страна получателя: " + getCountry());
    }

    @Override
    public void info(){
        System.out.println("Тип заказа: Простая пакет");
        System.out.println("Формат заказа: " + getMyFormat());
        System.out.println("Страна получателя: " + getCountry());
        System.out.println("Способ доставки: " + getDeliveryMethod());
    }

}
