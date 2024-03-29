package ru.oti;

public class EMSLetter extends Letter {

    public EMSLetter(){
        setCountry();
        setMyFormat();
        setTrackNumber();
    }

    @Override
    public void info(){
        System.out.println("Тип заказа: Экспресс-отправление EMS");
        System.out.println("Формат заказа: " + getMyFormat());
        System.out.println("Страна получателя: " + getCountry());
        System.out.println("Способ доставки: " + getDeliveryMethod());
        if(getCountry() == "Россия") {
            System.out.println("Способ получения: " + getHandingOver());
        }
        System.out.println("Трек номер: " + getTrackNumber());
        if(getValuation()){
            System.out.println("Подключена услуга: \"Объявленная ценность\"");
        }
        if(getCash()){
            System.out.println("Подключена услуга: \"Наложенный платеж\"");
        }
        if((getSMSNotic()) && (getCountry() == "Россия")){
            System.out.println("Подключена услуга: \"SMS уведомление\"");
        }
        if(getInventoryList()){
            System.out.println("Ваша опись вложения:");
            for (String s : inventoryList)
            {
                System.out.println("\t" + s);
            }
        }
    }
}
