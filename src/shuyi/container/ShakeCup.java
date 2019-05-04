package shuyi.container;


import shuyi.container.shakecup.ShakeCupType;

public class ShakeCup extends Container{
    private final ShakeCupType SIZE;

    protected ShakeCup(ShakeCupType size) {
        this.SIZE = size;
    }

    @Override
    public String printCup() {
        return SIZE + ":\nOperations:" + this.getDescriptions();
    }

    @Override
    public String getName() {
        return SIZE.toString();
    }
}
