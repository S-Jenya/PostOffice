package ru.oti;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SimpleLetter implements Letter {
    public int choice;
    private MyFormat format;
    private Delivery delivery;
    private HandingOver handingOver;
    private int trackNumber = 0;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public SimpleLetter(){
        this.delivery = Delivery.TRAIN;
    }

    @Override
    public void setMyFormat(MyFormat myFormat) {

        for (MyFormat f: MyFormat.values()) {
            if(f.ordinal() != 0){
                System.out.println(f.ordinal() + ". " + f.getName());
            }
        }

        boolean flag = false;
        do {
            System.out.print("Выберите формат: ");
            try {
                choice = Integer.parseInt(reader.readLine());
                switch (choice) {
                    case 1:
                        this.format = MyFormat.C4;
                        flag = true;
                        break;
                    case 2:
                        this.format = MyFormat.C6;
                        flag = true;
                        break;
                    case 3:
                        this.format = MyFormat.B4;
                        flag = true;
                        break;
                    case 4:
                        this.format = MyFormat.EURO;
                        flag = true;
                        break;
                    default:
                        if (flag == false) System.out.println("Некорректные данные. Повторите ввод!\n");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Некорректные данные. Повторите ввод!\n");
            }
        } while (flag == false);
    }

    @Override
    public String getMyFormat() {
        return format.getName();
    }

    @Override
    public void setDeliveryMethod() {
        this.delivery = delivery;
    }

    @Override
    public String getDeliveryMethod() {
        return delivery.getName();
    }

    @Override
    public void setHandingOver() {

        for (HandingOver h: HandingOver.values()) {
             System.out.println((h.ordinal() + 1) + ". " + h.getName());
        }

        boolean flag = false;
        do {
            System.out.print("Выберите способ получения: ");
            try {
                choice = Integer.parseInt(reader.readLine());
                switch (choice) {
                    case 1:
                        this.handingOver = HandingOver.POSTMAN;
                        flag = true;
                        break;
                    case 2:
                        this.handingOver = HandingOver.COURIER;
                        flag = true;
                        break;
                    default:
                        if (flag == false) System.out.println("Некорректные данные. Повторите ввод!\n");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Exception!");
            }
        } while (flag == false);
    }

    @Override
    public String getHandingOver() {
        return handingOver.getName();
    }

    @Override
    public void info(){
        System.out.println("Тип письма: простое письмо");
        System.out.println("Формат письма: " + getMyFormat());
        System.out.println("Способ доставки: " + getDeliveryMethod());
        System.out.println("Способ получения: " + getHandingOver());
    }

    @Override
    public void setTrackNumber() {
        int numb = (int)(Math.random() * 1000000);
        this.trackNumber = numb;
    }

    @Override
    public void deliveryNotice() {
        System.out.println("Уведомление о вручении недоступно!");
    }

    @Override
    public void SMSNotification() {
        System.out.println("SMS уведомление недоступно!");
    }

    @Override
    public void callDelivery() {
        System.out.println("Услуга — «Доставка по звонку» недоступно!");
    }

    @Override
    public void setValuation() {
        System.out.println("Объявление ценности недоступно!");
    }

    @Override
    public void inventoryOfContents() {
        System.out.println("Опись вложения недоступна!");
    }

    @Override
    public void cashOnDelivery() {
        System.out.println("Наложенный платёж недоступен!");
    }

}
