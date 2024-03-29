package ru.oti;

public class SimpleLetter extends Letter {

    public SimpleLetter(){
        setCountry();
        setMyFormat();
    }

    @Override
    public void info(){
        System.out.println("Тип заказа: Простое письмо");
        System.out.println("Формат заказа: " + getMyFormat());
        System.out.println("Страна получателя: " + getCountry());
        System.out.println("Способ доставки: " + getDeliveryMethod());
        if(getCountry() == "Россия") {
            System.out.println("Способ получения: " + getHandingOver());
        }
    }

}
