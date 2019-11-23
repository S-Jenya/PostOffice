package ru.oti;

public class OrderedLetter implements Letter {

    private MyFormat format;
    private Delivery delivery;
    private HandingOver handingOver;
    private int trackNumber;

    public OrderedLetter(){
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
        System.out.println("Тип письма: заказное");
    }

    @Override
    public int getTrackNumber() {
        int numb = (int)(Math.random() * 1000000);
        this.trackNumber = numb;
        return this.trackNumber;
    }

    @Override
    public void deliveryNotice() {
        System.out.println("Мы отправим документ, информирующий отправителя, что его почтовое отправление вручено адресату.!");
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
    public void setValuation(double valuation) {
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
