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

}
