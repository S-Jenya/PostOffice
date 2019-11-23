package ru.oti;

public class OrderedLetterFirstClass extends OrderedLetter {

    private MyFormat format;
    private Delivery delivery;
    private HandingOver handingOver;

    public OrderedLetterFirstClass(){
        this.format = MyFormat.NONE;
        this.delivery = Delivery.AIR;
        this.handingOver = HandingOver.COURIER;
    }

    @Override
    public void Title(){
        System.out.println("Тип письма: заказное письмо первого класса.");
    }

    @Override
    public void callDelivery() {
        System.out.println("Доступна услуга доставки по звонку. Сотрудник почтового отделения свяжется с адресатом и уточнит у него удобное время доставки!");
    }

    @Override
    public void setValuation(double valuation) {
        System.out.println("!!!");
    }

    @Override
    public void inventoryOfContents() {
        System.out.println("Опись вложения недоступна!");
    }

    @Override
    public void cashOnDelivery() {
        System.out.println("!!!");
    }

}
