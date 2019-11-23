package ru.oti;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ValuableLetterFirstClass extends ValuableLetter {

    private MyFormat format;
    private Delivery delivery;
    private HandingOver handingOver;
    private double valuation;
    private int trackNumber;
    private ArrayList<String> inventoryList = new ArrayList<String>();

    public ValuableLetterFirstClass(){
        this.format = MyFormat.NONE;
        this.delivery = Delivery.AIR;
        this.handingOver = HandingOver.COURIER;
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
    public void setDeliveryMethod(Delivery delivery) {
        this.delivery = delivery;
    }

    @Override
    public String getDeliveryMethod() {
        return delivery.getName();
    }

    @Override
    public void setHandingOver(HandingOver handingOver) {
        this.handingOver = handingOver;
    }

    @Override
    public String getHandingOver() {
        return handingOver.getName();
    }

    @Override
    public void Title(){
        System.out.println("Тип письма: ценное письмо.");
    }

    @Override
    public int getTrackNumber() {
        int numb = (int)(Math.random() * 1000000);
        this.trackNumber = numb;
        return this.trackNumber;
    }

    @Override
    public void deliveryNotice() {
        System.out.println("Мы отправим документ, информирующий отправителя, что его почтовое отправление вручено адресату!");
    }

    @Override
    public void SMSNotification() {
        System.out.println("Услуга — «Доставка по звонку» недоступно!");
    }

    @Override
    public void callDelivery() {
        System.out.println("Услуга — «Доставка по звонку» недоступно!");
    }

    @Override
    public void setValuation(double valuation) {
        this.valuation = valuation;
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
                System.out.print((i+1) + ". ");
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
    public void cashOnDelivery() {
        System.out.println("!!!");
    }
}
