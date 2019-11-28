package ru.oti;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class EMSLetter implements Letter {

    private MyFormat format;
    private Delivery delivery;
    private HandingOver handingOver;
    private int trackNumber;
    private ArrayList<String> inventoryList = new ArrayList<String>();

    public EMSLetter(){
        this.format = MyFormat.NONE;
        this.delivery = Delivery.TRAIN;
        this.handingOver = HandingOver.POSTMAN;
    }

    @Override
    public void setMyFormat(MyFormat myFormat) {
        this.format = myFormat;
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
        this.handingOver = handingOver;
    }

    @Override
    public String getHandingOver() {
        return handingOver.getName();
    }

    @Override
    public void info(){
        System.out.println("Тип письма: простое письмо");
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
        System.out.println("Доступна услуга SMS уведомление!");
    }

    @Override
    public void callDelivery() {
        System.out.println("Услуга — «Доставка по звонку» недоступно!");
    }

    @Override
    public void setValuation(boolean valuation) {
        System.out.println("Объявление ценности недоступно!");
    }

    @Override
    public void inventoryOfContents() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count;
        int i = 1;
        System.out.print("Укажите необходимое число предметов:");
        try {
            count = Integer.parseInt(reader.readLine());
            System.out.println("Введите название элементов посылки:");
            do{
                System.out.print(i + ". ");
                inventoryList.add(reader.readLine());
                i++;
            } while (i <= count);
        } catch (Exception e){
            System.out.println("Exception!");
        }

        System.out.print("Конец заполнения! \n\nСодержимое:\n");
        for (String s : inventoryList)
        {
            System.out.println(s);
        }
    }

    @Override
    public void cashOnDelivery(boolean cash) {
        System.out.println("Наложенный платёж недоступен!");
    }
}
