package ru.oti;

public class ValuableBanderoleFirstClass extends ValuableBanderole {

    public ValuableBanderoleFirstClass() {
        super();
        setDelivery(Delivery.AIR);
    }

    @Override
    public void info(){
        System.out.println("Тип заказа: Ценная бандероль первого класса");
        System.out.println("Формат заказа: " + getMyFormat());
        System.out.println("Страна получателя: " + getCountry());
        System.out.println("Способ доставки: " + getDeliveryMethod());
        System.out.println("Способ получения: " + getHandingOver());
        System.out.println("Трек номер: " + getTrackNumber());
        if(getSMSNotic()){
            System.out.println("Подключена услуга: \"SMS уведомление\"");
        }
        if(getDeliveryNotic()){
            System.out.println("Подключена услуга: \"Уведомление о вручении\"");
        }
        if(getValuation()){
            System.out.println("Подключена услуга: \"Объявленная ценность\"");
        }
        if(getCash()){
            System.out.println("Подключена услуга: \"Наложенный платеж\"");
        }
        if(getCallDelivery()){
            System.out.println("Подключена услуга: \"Доставка по звонку\"");
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
