package ru.oti;

public class OrderedLetterFirstClass extends OrderedLetter {

    private boolean callDelivery;

    public OrderedLetterFirstClass(){
        super();
    }

    @Override
    public void callDelivery() {

        do {
            try{
                System.out.println("\nДоступна услуга \"Доставка по звонку\"\nЖелаете воспользоваться?");
                System.out.println("1. Да\n2. Нет\nОтвет: ");
                choice = Integer.parseInt(reader.readLine());
                if(choice == 1) {
                    this.callDelivery = true;
                    flag = true;
                    System.out.println("Подключена услуга \"Доставка по звонку\". \nСотрудник почтового отделения свяжется с адресатом и уточнит у него удобное время доставки!");
                } else {
                    break;
                }
            }catch (Exception e){
                System.out.println("Некорректные данные.\nПовторите ввод!\n");
            }
        } while (flag == false);

    }

    @Override
    public void setValuation() {
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

    private boolean getCallDelivery(){
        return this.callDelivery;
    }

    @Override
    public void info(){
        System.out.println("Тип письма: заказное");
        System.out.println("Формат письма: " + getMyFormat());
        System.out.println("Способ доставки: " + getDeliveryMethod());
        System.out.println("Способ получения: " + getHandingOver());
        System.out.println("Трек номер: " + getTrackNumber());
        if(getSMSNotic()){
            System.out.println("Подключена услуга: \"SMS уведомление\"");
        }
        if(getDeliveryNotic()){
            System.out.println("Подключена услуга: \"Уведомление о вручении\"");
        }
        if(getCallDelivery()){
            System.out.println("Подключена услуга: \"Доставка по звонку\"");
        }
    }

}
