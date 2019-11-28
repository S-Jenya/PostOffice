package ru.oti;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OrderedLetter implements Letter {

    protected MyFormat format;
    protected Delivery delivery;
    protected HandingOver handingOver;
    protected int trackNumber = 0;
    protected boolean deliveryNotic = false;
    protected boolean smsNotic = false;
    public int choice;
    boolean flag = false;

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public OrderedLetter(){
        this.format = MyFormat.NONE;
        this.delivery = Delivery.AIR;
        this.handingOver = HandingOver.COURIER;
        setTrackNumber();
    }

    @Override
    public void setMyFormat(MyFormat myFormat) {

        for (MyFormat f: MyFormat.values()) {
            if(f.ordinal() != 0){
                System.out.println(f.ordinal() + ". " + f.getName());
            }
        }

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

        do {
            try{
                System.out.println("\nДоступна услуга \"Авиапересылка\"\nЖелаете воспользоваться?");
                System.out.println("1. Да\n2. Нет\nОтвет: ");
                choice = Integer.parseInt(reader.readLine());
                if(choice == 1) {
                    this.delivery = Delivery.AIR;
                    flag = true;
                } else {
                    break;
                }
            }catch (Exception e){
                System.out.println("Некорректные данные.\nПовторите ввод!\n");
            }
        } while (flag == false);

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

    protected boolean getDeliveryNotic(){
        return this.deliveryNotic;
    }

    protected boolean getSMSNotic(){
        return this.smsNotic;
    }

    protected int getTrackNumber() {
        return this.trackNumber;
    }

    @Override
    public void setTrackNumber() {
        int numb = (int)(Math.random() * 1000000);
        this.trackNumber = numb;
    }

    @Override
    public void deliveryNotice() {
        do {
            try {
                System.out.println("\nДоступна услуга: \"Уведомление о вручении\". Желаете воспользоваться?");
                System.out.print("1. Да\n2. Нет\nОтвет: ");
                choice = Integer.parseInt(reader.readLine());
                if(choice == 1) {
                    System.out.println("Услуга: \"Уведомление о вручении\" подключена!");
                    System.out.println("\nМы отправим документ, информирующий отправителя, что его почтовое отправление вручено адресату.!");
                    this.deliveryNotic = true;
                }
            } catch (Exception e) {
                System.out.println("Некорректные данные. Повторите ввод!\n");
            }
        } while (flag == false);

    }

    @Override
    public void SMSNotification() {
        do {
            try {
                System.out.println("\nДоступна услуга: \"SMS уведомления\". Желаете воспользоваться?");
                System.out.print("1. Да\n2. Нет\nОтвет: ");
                choice = Integer.parseInt(reader.readLine());
                if(choice == 1) {
                    System.out.println("Услуга: \"SMS уведомления\" подключена!");
                    this.smsNotic = true;
                }
            } catch (Exception e) {
                System.out.println("Некорректные данные. Повторите ввод!\n");
            }
        } while (flag == false);
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

    @Override
    public void info(){
        System.out.println("Тип письма: заказное");
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
    }

}
