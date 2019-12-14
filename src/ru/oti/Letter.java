package ru.oti;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public abstract class Letter {

    protected MyFormats format;
    protected String country;
    protected Delivery delivery;
    protected HandingOver handingOver;
    protected boolean valuation;
    protected int trackNumber = 0;
    protected boolean deliveryNotic = false;
    protected boolean smsNotic = false;
    protected boolean cash = false;
    protected boolean call = false;
    protected boolean invList = false;
    protected ArrayList<String> inventoryList = new ArrayList<String>();
    protected int choice;
    protected boolean flag = false;

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    abstract void info();

    protected boolean getDeliveryNotic(){
        return this.deliveryNotic;
    }

    protected boolean getSMSNotic(){
        return this.smsNotic;
    }

    protected int getTrackNumber() {
        return this.trackNumber;
    }

    protected boolean getValuation() {
        return this.valuation;
    }

    protected String getMyFormat() {
        return format.getName();
    }

    protected String getDeliveryMethod() {
        return delivery.getName();
    }

    protected String getHandingOver() {
        return handingOver.getName();
    }

    protected boolean getCallDelivery(){
        return this.call;
    }

    protected boolean getInventoryList(){
        return this.invList;
    }

    protected boolean getCash(){
        return this.cash;
    }

    protected String getCountry() {
        return this.country;
    }

    public void setCountry(String country){
        this.country = country;
    }

    public void setDelivery(Delivery delivery){
        this.delivery = delivery;
    }

    public void setHandingOver(HandingOver handingOver){
        this.handingOver = handingOver;
    }

    public void setValuation(boolean value){
        this.valuation = value;
    }

    public void setCountry(){
        boolean flag = false;
        do {
            try {
                System.out.println("\nОтправление заказа по России?");
                System.out.print("1. Да\n2. Нет\nОтвет: ");
                choice = Integer.parseInt(reader.readLine());
                switch (choice) {
                    case 1:
                        this.country = "Россия";
                        flag = true;
                        break;
                    case 2:
                        String myCountry;
                        System.out.print("Введите страну получителя: ");
                        myCountry = reader.readLine();
                        setCountry(myCountry);
                        flag = true;
                        break;
                    default:
                        if (flag == false) System.out.println("Некорректные данные.\n");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Повторите ввод!\n");
            }
        } while (flag == false);
        System.out.println("Страна получателя: " + getCountry());
    }

    public void airShipment(){

        boolean flag = false;
        do {
            try {
                System.out.println("\nДоступна услуга: \"Авиапересылка\". Желаете воспользоваться?");
                System.out.print("1. Да\n2. Нет\nОтвет: ");
                choice = Integer.parseInt(reader.readLine());
                switch (choice) {
                    case 1:
                        this.delivery = Delivery.AIR;
                        System.out.println("Услуга: \"Авиапересылка\" подключена!");
                        System.out.println("Заказ будет доставлен значительно быстрее");
                        flag = true;
                        break;
                    case 2:
                        flag = true;
                        break;
                    default:
                        if (flag == false) System.out.println("Некорректные данные.\n");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Повторите ввод!\n");
            }
        } while (flag == false);

    }

    // установка формата письма
    public void setMyFormat() {

        System.out.println("\nДоступные форматы:");

        for (MyFormats f: MyFormats.values()) {
            if(f.ordinal() < 4){
                System.out.println((f.ordinal() + 1) + ". " + f.getName());
            }
        }

        boolean flag = false;
        do {
            System.out.print("Выберите формат: ");
            try {
                choice = Integer.parseInt(reader.readLine());
                switch (choice) {
                    case 1:
                        this.format = MyFormats.C4;
                        flag = true;
                        break;
                    case 2:
                        this.format = MyFormats.C6;
                        flag = true;
                        break;
                    case 3:
                        this.format = MyFormats.B4;
                        flag = true;
                        break;
                    case 4:
                        this.format = MyFormats.EURO;
                        flag = true;
                        break;
                    default:
                        if (flag == false) System.out.println("Введённого формата не существует.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Повторите ввод!\n");
            }
        } while (flag == false);
        System.out.println("Выбранный формат: " + getMyFormat());
    }

    // способы получения
    public void setHandingOver() {

        boolean flag = false;
        do {
            System.out.println("\nСпособы получения:");
            System.out.println("1. Получить лично в почтовом отделении\n2. Представителю по доверенности");
            System.out.print("Выберите способ получения: ");
            try {
                choice = Integer.parseInt(reader.readLine());
                switch (choice) {
                    case 1:
                        this.handingOver = HandingOver.PERSONALLY;
                        flag = true;
                        break;
                    case 2:
                        this.handingOver = HandingOver.ATTORNEY_IN_FACT;
                        flag = true;
                        break;
                    default:
                        if (flag == false) System.out.println("Введённого способа получения не существует.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Повторите ввод!\n");
            }
        } while (flag == false);
        System.out.println("Выбранный способ получения: " + getHandingOver());
    }

    // трек номер
    public void setTrackNumber() {
        int numb = (int)(Math.random() * 1000000);
        this.trackNumber = numb;
    }

    // уведомление о вручении
    public void deliveryNotice() {
        flag = false;
        do {
            try {
                System.out.println("\nДоступна услуга: \"Уведомление о вручении\". Желаете воспользоваться?");
                System.out.print("1. Да\n2. Нет\nОтвет: ");
                choice = Integer.parseInt(reader.readLine());
                switch (choice) {
                    case 1:
                        System.out.println("Услуга: \"Уведомление о вручении\" подключена!");
                        System.out.println("Вы получите подписанное адресатом уведомление о вручении.");
                        this.deliveryNotic = true;
                        flag = true;
                    case 2:
                        flag = true;
                        break;
                    default:
                        System.out.println("Некорректные данные. Повторите ввод!\n");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Некорректные данные. Повторите ввод!\n");
            }
        } while (flag == false);
    }

    // СМС-уведомление содержит трек-номер отправления и статус доставки.
    public void SMSNotification() {
        flag = false;
        do {
            try {
                System.out.println("\nДоступна услуга: \"SMS уведомления\". Желаете воспользоваться?");
                System.out.print("1. Да\n2. Нет\nОтвет: ");
                choice = Integer.parseInt(reader.readLine());
                switch (choice) {
                    case 1:
                        System.out.println("Услуга: \"SMS уведомления\" подключена!");
                        System.out.println("СМС-уведомление содержит трек-номер отправления и статус доставки.");
                        this.smsNotic = true;
                        flag = true;
                    case 2:
                        flag = true;
                        break;
                    default:
                        System.out.println("Некорректные данные. Повторите ввод!\n");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Некорректные данные. Повторите ввод!\n");
            }
        } while (flag == false);
    }

    // услуга — «Доставка по звонку»
    public void callDelivery() {

        flag = false;
        do {
            try {
                System.out.println("\nДоступна услуга: \"Доставка по звонку\". Желаете воспользоваться?");
                System.out.print("1. Да\n2. Нет\nОтвет: ");
                choice = Integer.parseInt(reader.readLine());
                switch (choice) {
                    case 1:
                        System.out.println("Услуга: \"Доставка по звонку\" подключена!");
                        System.out.println(" Сотрудник почтового отделения свяжется с адресатом и уточнит у него удобное время доставки.");
                        this.call = true;
                        flag = true;
                    case 2:
                        flag = true;
                        break;
                    default:
                        System.out.println("Некорректные данные. Повторите ввод!\n");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Некорректные данные. Повторите ввод!\n");
            }
        } while (flag == false);
    }

    // объявленная ценность
    public void setValuation() {

        flag = false;
        do {
            try{
                System.out.println("\nДоступна услуга \"Объявленная ценность\". Желаете воспользоваться?");
                System.out.print("1. Да\n2. Нет\nОтвет: ");
                choice = Integer.parseInt(reader.readLine());
                switch (choice) {
                    case 1:
                    this.valuation = true;
                    System.out.println("Услуга: \"Объявленная ценность\" подключена!");
                    System.out.println("Ваше письмо застраховано.");
                    flag = true;
                    case 2:
                        flag = true;
                        break;
                    default:
                        System.out.println("Некорректные данные. Повторите ввод!\n");
                        break;
                }
            }catch (Exception e){
                System.out.println("Некорректные данные.\nПовторите ввод!\n");
            }
        } while (flag == false);
    }

    // Опись вложения
    public void inventoryOfContents() {

        int count;
        int i = 1;
        flag = false;
        do {
            try {
                System.out.println("\nДоступна услуга \"Опись вложения\". Желаете воспользоваться?");
                System.out.print("1. Да\n2. Нет\nОтвет: ");
                choice = Integer.parseInt(reader.readLine());

                switch (choice) {
                    case 1:
                        System.out.print("Укажите необходимое число предметов:");
                        count = Integer.parseInt(reader.readLine());
                        System.out.println("Введите название элементов посылки:");
                        do {
                            System.out.print(i + ". ");
                            inventoryList.add(reader.readLine());
                            i++;
                        } while (i <= count);
                        invList = true;
                        flag = true;
                    case 2:
                        flag = true;
                        break;
                    default:
                        System.out.println("Некорректные данные. Повторите ввод!\n");
                        break;
                }
            } catch (Exception e){
                System.out.println("Некорректные данные.\nПовторите ввод!\n");
            }
        } while (flag == false);

    }

    // наложенный платёж
    public void cashOnDelivery() {
        flag = false;
        do {
            try{
                System.out.println("\nДоступна услуга \"Наложенный платёж\". Желаете воспользоваться?");
                System.out.print("1. Да\n2. Нет\nОтвет: ");
                choice = Integer.parseInt(reader.readLine());
                switch (choice) {
                    case 1:
                        this.cash = true;
                        System.out.println("Услуга: \"Наложенный платёж\" подключена!");
                        System.out.println("Вы получите заверенное почтовым работником подтверждение содержимого письма и даты его отправки.");
                        flag = true;
                    case 2:
                        flag = true;
                        break;
                    default:
                        System.out.println("Некорректные данные. Повторите ввод!\n");
                        break;
                }
            }catch (Exception e){
                System.out.println("Некорректные данные.\nПовторите ввод!\n");
            }
        } while (flag == false);
    }

}
