package ru.oti;

public class SimpleLetter implements Letter {

    private MyFormat format;
    private Delivery delivery;
    private HandingOver handingOver;

    public SimpleLetter(){
        this.format = MyFormat.NONE;
        this.delivery = Delivery.TRAIN;
        this.handingOver = HandingOver.POSTMAN;
    }

    @Override
    public void setMyFormat(MyFormat myFormat) {
        this.format = myFormat;
    }

    @Override
    public MyFormat getMyFormat() {
        return this.format;
    }

    @Override
    public void setDeliveryMethod(Delivery delivery) {
        this.delivery = delivery;
    }

    @Override
    public Delivery getDeliveryMethod() {
        return this.delivery;
    }

    @Override
    public void setHandingOver(HandingOver handingOver) {
        this.handingOver = handingOver;
    }

    @Override
    public HandingOver getHandingOver() {
        return this.handingOver;
    }

    @Override
    public void Title(){
        System.out.println("Тип письма: простое письмо");
    }

    @Override
    public void getTrackNumber() {
        System.out.println("Трек номер недоступен!");
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
    public void setValuation(int valuation) {
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
