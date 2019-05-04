package shuyi.product.toppings;

public enum Toppings {
    Grass_Jelly, Pearl, Coconut_Jelly, Fig_Jelly, Black_Brick_Jelly, Red_Bean, Oats, Pineapple_Jelly, Caramel_Pudding, Salty_Cream;

    @Override
    public String toString() {
        switch (this) {
            case Oats:
                return "燕麦";
            case Pearl:
                return "珍珠";
            case Red_Bean:
                return "红豆";
            case Fig_Jelly:
                return "爱玉";
            case Grass_Jelly:
                return "仙草";
            case Salty_Cream:
                return "奶盖";
            case Coconut_Jelly:
                return "椰果";
            case Caramel_Pudding:
                return "焦糖布丁";
            case Pineapple_Jelly:
                return "凤梨水晶";
            case Black_Brick_Jelly:
            default:
                return "黑砖";
        }
    }
}
