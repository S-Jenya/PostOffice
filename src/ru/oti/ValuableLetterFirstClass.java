package ru.oti;

public class ValuableLetterFirstClass extends ValuableLetter {

    public ValuableLetterFirstClass(){
        super();
    }

    @Override
    public void info(){
        System.out.println("Тип письма: Ценное письмо 1 класса");
        System.out.println("Формат письма: " + getMyFormat());
        System.out.println("Способ доставки: " + getDeliveryMethod());
        System.out.println("Способ получения: " + getHandingOver());
        System.out.println("Трек номер: " + getTrackNumber());
        if(getValuation()){
            System.out.println("Объявленна ценность");
        }
        if(getDeliveryNotic()){
            System.out.println("Подключена услуга: \"Уведомление о вручении\"");
        }
        if(getCallDelivery()){
            System.out.println("Подключена услуга: \"Доставка по звонку\"");
        }
        if(getCash()){
            System.out.println("Подключена услуга: \"Наложенный платёж\"");
        }
        if(getSMSNotic()){
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
