package ru.oti;

public class Box extends Letter {

    @Override
    public void setMyFormat() {

        System.out.println("\nДоступные форматы:");

        for (MyFormats f: MyFormats.values()) {
            if(f.ordinal() == 4 || f.ordinal() == 5){
                System.out.println((f.ordinal() - 3) + ". " + f.getName());
            }
        }

        boolean flag = false;
        do {
            System.out.print("Выберите формат: ");
            try {
                choice = Integer.parseInt(reader.readLine());
                switch (choice) {
                    case 1:
                        this.format = MyFormats.RECTANGULAR_PACKAGING;
                        flag = true;
                        break;
                    case 2:
                        this.format = MyFormats.ROLL;
                        flag = true;
                        break;
                    default:
                        if (flag == false) System.out.println("Введённого формата не существует.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Повторите ввод!\n");
            }
        } while (flag == false);
        System.out.println("Выбранный формат: " + getMyFormat());
    }

    @Override
    public void info(){
        System.out.println("Тип бандероли: простой BOX");
        System.out.println("Формат письма: " + getMyFormat());
        System.out.println("Страна получателя: " + getCountry());
        System.out.println("Способ доставки: " + getDeliveryMethod());
        System.out.println("Способ получения: " + getHandingOver());
    }

}
