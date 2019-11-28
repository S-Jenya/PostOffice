package ru.oti;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ValuableLetterFirstClass extends ValuableLetter {

    protected boolean call = false;

    public ValuableLetterFirstClass(){
        super();
    }

    @Override
    public void callDelivery() {

        flag = false;
        do {
            try {
                System.out.println("\nДоступна услуга: \"Доставка по звонку\". Желаете воспользоваться?");
                System.out.print("1. Да\n2. Нет\nОтвет: ");
                choice = Integer.parseInt(reader.readLine());
                if(choice == 1) {
                    System.out.println("Услуга: \"Доставка по звонку\" подключена!");
                    this.call = true;
                    flag = true;
                }
            } catch (Exception e) {
                System.out.println("Некорректные данные. Повторите ввод!\n");
            }
        } while (flag == false);
    }

    private boolean getCallDelivery(){
        return this.call;
    }

    @Override
    public void info(){
        System.out.println("Тип письма: Ценное письмо 1 класса");
        System.out.println("Формат письма: " + getMyFormat());
        System.out.println("Способ доставки: " + getDeliveryMethod());
        System.out.println("Способ получения: " + getHandingOver());
        System.out.println("Трек номер: " + getTrackNumber());
        if(getSMSNotic()){
            System.out.println("Подключена услуга: \"SMS уведомление\"");
        }
        if(getDeliveryNotic()){
            System.out.println("Подключена услуга: \"Уведомление о вручении\"");
        }
        if(getValuation()){
            System.out.println("Подключена услуга: \"Объявленная ценность\"");
        }
        if(getCallDelivery()){
            System.out.println("Подключена услуга: \"Доставка по звонку\"");
        }
        if(inventoryList != null){
            System.out.println("Ваша опись вложения:");
            for (String s : inventoryList)
            {
                System.out.println("\t" + s);
            }
        }
    }
}
