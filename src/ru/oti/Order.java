package ru.oti;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {

    private int ID = 0;
    private Letter letter;
    private String date;
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int choice = 0;

    public int getID(){
        return ID;
    }

    public void setID(int value){
        this.ID = value;
    }

    public void setData(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        date = simpleDateFormat.format(new Date());
    }

    public String getData(){
        return date;
    }

    public void getInfo(){
        letter.info();
    }

    private void createLetter(){

        boolean flag = false;
        do {
            try {
                System.out.println("\nТипы письма: ");
                System.out.println("1. Простое письмо");
                System.out.println("2. Заказное письмо");
                System.out.println("3. Заказное письмо 1 класса");
                System.out.println("4. Ценное письмо");
                System.out.println("5. Ценное письмо 1 класса");
                System.out.println("6. Экспресс-письмо EMS");
                System.out.print("Выберите вид услуги: ");
                choice = Integer.parseInt(reader.readLine());

                switch (choice) {
                    case 1:
                        letter = new SimpleLetter();
                        letter.setDelivery(Delivery.ORDINARY_DELIVERY);
                        if(letter.getCountry() == "Россия") {
                            letter.setHandingOver(HandingOver.POSTMAN);
                        }
                        /* Дополнительные услуги */
                        if(letter.getCountry() != "Россия"){
                            letter.airShipment();
                        }
                        flag = true;
                        break;
                    case 2:
                        letter = new OrderedLetter();
                        letter.setCountry();
                        if(letter.getCountry() == "Россия") {
                            letter.setHandingOver();
                        }
                        letter.setDelivery(Delivery.ORDINARY_DELIVERY);
                        /* Дополнительные услуги */
                        letter.airShipment();
                        letter.deliveryNotice();
                        letter.SMSNotification();
                        flag = true;
                        break;
                    case 3:
                        letter = new OrderedLetterFirstClass();
                        letter.setCountry("Россия");
                        letter.setDelivery(Delivery.AIR);
                        /* Дополнительные услуги */
                        letter.deliveryNotice();
                        letter.callDelivery();
                        letter.SMSNotification();
                        flag = true;
                        break;
                    case 4:
                        letter = new ValuableLetter();
                        letter.setDelivery(Delivery.ORDINARY_DELIVERY);
                        letter.setValuation(true);
                        letter.setCountry();
                        if(letter.getCountry() == "Россия") {
                            letter.setHandingOver();
                        }
                        /* Дополнительные услуги */
                        letter.airShipment();
                        if(letter.getCountry() == "Россия") {
                            letter.SMSNotification();
                        }
                        letter.deliveryNotice();
                        letter.cashOnDelivery();
                        letter.inventoryOfContents();

                        flag = true;
                        break;
                    case 5:
                        letter = new ValuableLetterFirstClass();
                        letter.setCountry("Россия");
                        letter.setDelivery(Delivery.AIR);
                        letter.setValuation(true);
                        /* Дополнительные услуги */
                        letter.deliveryNotice();
                        letter.callDelivery();
                        letter.inventoryOfContents();
                        letter.cashOnDelivery();
                        letter.SMSNotification();

                        flag = true;
                        break;
                    case 6:
                        letter = new EMSLetter();
                        letter.setDelivery(Delivery.PERSONALLY_COURIER);
                        letter.setHandingOver(HandingOver.COURIER);
                        /* Дополнительные услуги */
                        letter.cashOnDelivery();
                        letter.setValuation();
                        if(letter.getCountry() == "Россия") {
                            letter.SMSNotification();
                        }
                        letter.inventoryOfContents();

                        flag = true;
                        break;
                    default:
                        if (flag == false) System.out.println("Некорректные данные. Повторите ввод!\n");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Некорректные данные!");
            }

        } while (flag == false);

    }

    private void createBanderole(){

        boolean flag = false;
        do {
            try {
                System.out.println("\nТипы заказа: ");
                System.out.println("1. Простая бандероль");
                System.out.println("2. Заказная бандероль");
                System.out.println("3. Заказная бандероль 1 класса");
                System.out.println("4. Ценная бандероль");
                System.out.println("5. Ценная бандероль 1 класса");
                System.out.print("Выберите вид услуги: ");
                choice = Integer.parseInt(reader.readLine());

                switch (choice) {
                    case 1:
                        letter = new SimpleBanderole();
                        letter.setDelivery(Delivery.ORDINARY_DELIVERY);
                        if(letter.getCountry() == "Россия") {
                            letter.setHandingOver(HandingOver.POSTMAN);
                        }
                        /* Дополнительные услуги */
                        if(letter.getCountry() != "Россия" || letter.getValuation()){
                            letter.airShipment();
                        }

                        flag = true;
                        break;

                    case 2:
                        letter = new OrderedBanderole();
                        letter.setCountry();
                        if(letter.getCountry() == "Россия") {
                            letter.setHandingOver();
                        }
                        letter.setDelivery(Delivery.ORDINARY_DELIVERY);
                        /* Дополнительные услуги */
                        letter.deliveryNotice();
                        letter.SMSNotification();

                        flag = true;
                        break;

                    case 3:
                        letter = new OrderBanderoleFirstClass();
                        letter.setCountry("Россия");
                        letter.setDelivery(Delivery.AIR);
                        /* Дополнительные услуги */
                        letter.deliveryNotice();
                        letter.callDelivery();
                        letter.SMSNotification();

                        flag = true;
                        break;

                    case 4:
                        letter = new ValuableBanderole();
                        letter.setDelivery(Delivery.ORDINARY_DELIVERY);
                        /* Дополнительные услуги */
                        letter.airShipment();
                        letter.deliveryNotice();
                        letter.cashOnDelivery();
                        letter.SMSNotification();
                        letter.inventoryOfContents();

                        flag = true;
                        break;

                    case 5:
                        letter = new ValuableBanderoleFirstClass();
                        /* Дополнительные услуги */
                        letter.deliveryNotice();
                        letter.callDelivery();
                        letter.cashOnDelivery();
                        letter.SMSNotification();
                        letter.inventoryOfContents();

                        flag = true;
                        break;


                    default:
                        if (flag == false) System.out.println("Некорректные данные. Повторите ввод!\n");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Некорректные данные!");
            }

        } while (flag == false);

    }

    private void createParse(){

        boolean flag = false;
        do {
            try {
                System.out.println("\nТипы посылки: ");
                System.out.println("1. Мелкий пакет");
                System.out.println("2. Заказной мелкий пакет");
                System.out.println("3. Посылка");
                System.out.println("4. Ценная посылка");
                System.out.println("5. Экспресс-посылка EMS");
                System.out.print("Выберите вид услуги: ");
                choice = Integer.parseInt(reader.readLine());

                switch (choice) {
                    case 1:
                        letter = new SmallPackage();
                        /* Дополнительная услуга*/
                        letter.airShipment();

                        flag = true;
                        break;

                    case 2:
                        letter = new OrderedSmallPackage();
                        /* Дополнительная услуга*/
                        letter.airShipment();
                        letter.deliveryNotice();

                        flag = true;
                        break;

                    case 3:
                        letter = new SimpleParcel();
                        if(letter.getCountry() == "Россия") {
                            letter.setHandingOver();
                        }
                        /* Дополнительные услуги */
                        letter.deliveryNotice();
                        letter.setValuation();
                        letter.cashOnDelivery();
                        letter.SMSNotification();
                        letter.inventoryOfContents();

                        flag = true;
                        break;

                    case 4:
                        letter = new ValuableParce();
                        if(letter.getCountry() == "Россия") {
                            letter.setHandingOver();
                        }
                        /* Дополнительные услуги */
                        letter.airShipment();
                        letter.deliveryNotice();
                        letter.cashOnDelivery();
                        letter.SMSNotification();
                        letter.inventoryOfContents();

                        flag = true;
                        break;

                    case 5:
                        letter = new EMSParse();
                        letter.setDelivery(Delivery.PERSONALLY_COURIER);
                        letter.setHandingOver(HandingOver.COURIER);
                        /* Дополнительные услуги */
                        letter.cashOnDelivery();
                        letter.setValuation();
                        if(letter.getCountry() == "Россия") {
                            letter.SMSNotification();
                        }
                        letter.inventoryOfContents();

                        flag = true;
                        break;
                    default:
                        if (flag == false) System.out.println("Некорректные данные. Повторите ввод!\n");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Некорректные данные!");
            }

        } while (flag == false);

    }

    public void makeAnOrder() {

        boolean flag = false;
        do {
            try {
                System.out.println("\nТипы услуг: ");
                System.out.println("1. Отправить письмо");
                System.out.println("2. Отправить бандероль");
                System.out.println("3. Отправить посылку");
                System.out.println("0. Главное меню");
                System.out.print("Выберите вид услуги: ");
                choice = Integer.parseInt(reader.readLine());

                switch (choice) {
                    case 1:
                        createLetter();
                        flag = true;
                        break;
                    case 2:
                        createBanderole();
                        flag = true;
                        break;
                    case 3:
                        createParse();
                        flag = true;
                        break;
                    case 0:
                        flag = true;
                        break;
                    default:
                        if (flag == false) System.out.println("Некорректные данные. Повторите ввод!\n");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Некорректные данные!");
            }

        } while (flag == false);

        System.out.print("\n----- Конец формирования заказа -----\n");

    }

}
