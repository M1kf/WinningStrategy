package com.example.winningstrategy.Tasks.Task20.CountOfHeaps1.CountOfKoef3.NoSame;

import java.util.ArrayList;
import java.util.List;

public class OneHeapThreeNoSame2Player20 {
    private final int NumberOfAdded1;
    private final int NumberOfAdded2;
    private final int NumberOfMultiply;
    private final int Winning;
    private List<Integer> list = new ArrayList<>();

    public OneHeapThreeNoSame2Player20(int NumberOfAdded1, int NumberOfAdded2, int NumberOfMultiply, int Winning) {
        this.NumberOfAdded1 = NumberOfAdded1;
        this.NumberOfAdded2 = NumberOfAdded2;
        this.NumberOfMultiply = NumberOfMultiply;
        this.Winning = Winning;
    }

    private boolean Calculations(int x, int h, int m) {
        if (h == 4 && x >= Winning)
            return true;
        if (h != 4 && x >= Winning)
            return false;
        if ((h == 3 || h == 1) && x < Winning) {
            if (m == 1)
                return Calculations(x + NumberOfAdded2, h + 1, 2) || Calculations(x * NumberOfMultiply, h + 1, 3);
            if (m == 2)
                return Calculations(x + NumberOfAdded1, h + 1, 1) || Calculations(x * NumberOfMultiply, h + 1, 3);
            if (m == 3)
                return Calculations(x + NumberOfAdded1, h + 1, 1) || Calculations(x + NumberOfAdded2, h + 1, 2);
            return Calculations(x + NumberOfAdded1, h + 1, 1) || Calculations(x + NumberOfAdded2, h + 1, 2) || Calculations(x * NumberOfMultiply, h + 1, 3);
        }
        if (h == 2 && x < Winning) {
            if (m == 1)
                return Calculations(x + NumberOfAdded2, h + 1, 2) && Calculations(x * NumberOfMultiply, h + 1, 3);
            if (m == 2)
                return Calculations(x + NumberOfAdded1, h + 1, 1) && Calculations(x * NumberOfMultiply, h + 1, 3);
            if (m == 3)
                return Calculations(x + NumberOfAdded1, h + 1, 1) && Calculations(x + NumberOfAdded2, h + 1, 2);
            return Calculations(x + NumberOfAdded1, h + 1, 1) || Calculations(x + NumberOfAdded2, h + 1, 2) || Calculations(x * NumberOfMultiply, h + 1, 3);
        }
        return false;
    }

    public List<Integer> getResult() {
        for (int x = 1; x <= Winning; x++) {
            if (Calculations(x, 1, 0)) {
                list.add(x);
            }
        }
        return list;
    }
}
