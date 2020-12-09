package com.company;

public interface IMoney {
    int getMainPart();
    int getHundredthPart();
    IMoney plus(IMoney money);
    IMoney minus(IMoney money);
    IMoney multiply(double num);
    boolean more(IMoney anotherMoney);
    boolean less(IMoney anotherMoney);
}
