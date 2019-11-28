package ru.oti;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class EMSLetter implements Letter {

    protected MyFormat format;
    protected Delivery delivery;
    protected HandingOver handingOver;
    protected int trackNumber = 0;

    protected ArrayList<String> inventoryList = new ArrayList<String>();
    protected boolean smsNotic = false;
    protected boolean cash = false;
    protected boolean valuation;

    protected int choice;
    protected boolean flag = false;

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public EMSLetter(){
        this.format = MyFormat.NONE;
        this.delivery = Delivery.PERSONALLY_COURIER;
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
        flag = false;
        do {
            try {
                System.out.println("\nДоступна услуга: \"SMS уведомления\". Желаете воспользоваться?");
                System.out.print("1. Да\n2. Нет\nОтвет: ");
                choice = Integer.parseInt(reader.readLine());
                if(choice == 1) {
                    System.out.println("Услуга: \"SMS уведомления\" подключена!");
                    this.smsNotic = true;
                    flag = true;
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

        flag = false;
        do {
            try{
                System.out.println("\nДоступна услуга \"Объявленная ценность\"\nЖелаете воспользоваться?");
                System.out.println("1. Да\n2. Нет\nОтвет: ");
                choice = Integer.parseInt(reader.readLine());
                if(choice == 1) {
                    this.valuation = true;
                    System.out.println("Услуга: \"Объявленная ценность\" подключена!");
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
    public void inventoryOfContents() {

        int count;
        int i = 1;
        flag = false;
        do {
            try {
                System.out.println("\nДоступна услуга \"Опись вложения\"\nЖелаете воспользоваться?");
                System.out.println("1. Да\n2. Нет\nОтвет: ");
                choice = Integer.parseInt(reader.readLine());

                if(choice == 1) {
                    System.out.print("Укажите необходимое число предметов:");
                    count = Integer.parseInt(reader.readLine());
                    System.out.println("Введите название элементов посылки:");
                    do {
                        System.out.print(i + ". ");
                        inventoryList.add(reader.readLine());
                        i++;
                    } while (i <= count);
                }
                flag = true;
            } catch (Exception e){
                System.out.println("Некорректные данные.\nПовторите ввод!\n");
            }
        } while (flag == false);

        System.out.print("Конец заполнения!\n");

    }

    @Override
    public void cashOnDelivery() {
        flag = false;
        do {
            try{
                System.out.println("\nДоступна услуга \"Наложенный платёж\"\nЖелаете воспользоваться?");
                System.out.println("1. Да\n2. Нет\nОтвет: ");
                choice = Integer.parseInt(reader.readLine());
                if(choice == 1) {
                    this.cash = true;
                    System.out.println("\nУслуга \"Наложенный платёж\" подключена\n");
                    flag = true;
                } else {
                    break;
                }
            }catch (Exception e){
                System.out.println("Некорректные данные.\nПовторите ввод!\n");
            }
        } while (flag == false);
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

    @Override
    public void info(){
        System.out.println("Тип письма: ценное письмо");
        System.out.println("Формат письма: " + getMyFormat());
        System.out.println("Способ доставки: " + getDeliveryMethod());
        System.out.println("Способ получения: " + getHandingOver());
        System.out.println("Трек номер: " + getTrackNumber());
        if(getSMSNotic()){
            System.out.println("Подключена услуга: \"SMS уведомление\"");
        }
        if(getValuation()){
            System.out.println("Подключена услуга: \"Объявленная ценность\"");
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
