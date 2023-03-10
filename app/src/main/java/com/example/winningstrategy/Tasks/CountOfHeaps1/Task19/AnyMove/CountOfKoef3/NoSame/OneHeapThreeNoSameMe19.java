package com.example.winningstrategy.Tasks.CountOfHeaps1.Task19.AnyMove.CountOfKoef3.NoSame;

import java.util.ArrayList;
import java.util.List;

public class OneHeapThreeNoSameMe19 {
    private final int NumberOfAdded1;
    private final int NumberOfAdded2;
    private final int NumberOfMultiply;
    private final int Winning;
    private List<Integer> list = new ArrayList<>();

    public OneHeapThreeNoSameMe19(int NumberOfAdded1, int NumberOfAdded2, int NumberOfMultiply, int Winning) {
        this.NumberOfAdded1 = NumberOfAdded1;
        this.NumberOfAdded2 = NumberOfAdded2;
        this.NumberOfMultiply = NumberOfMultiply;
        this.Winning = Winning;
    }

    private boolean Calculations(int x, int h, int m) {
        if (h == 4 && x >= Winning)
            return true;
        if (h == 4 && x < Winning)
            return false;
        if (h < 4 && x >= Winning)
            return false;
        else {
            if (h % 2 != 0) {
                if (h == 1)
                    return Calculations(x + NumberOfAdded1, h + 1, 1) || Calculations(x + NumberOfAdded2, h + 1, 2) || Calculations(x * NumberOfMultiply, h + 1, 3);
                if (h == 3) {
                    if (m == 1)
                        return Calculations(x + NumberOfAdded2, h + 1, m) || Calculations(x * NumberOfMultiply, h + 1, m);
                    if (m == 2)
                        return Calculations(x + NumberOfAdded1, h + 1, m) || Calculations(x * NumberOfMultiply, h + 1, m);
                    if (m == 3)
                        return Calculations(x + NumberOfAdded1, h + 1, m) || Calculations(x + NumberOfAdded2, h + 1, m);
                }
            } else
                return Calculations(x + NumberOfAdded1, h + 1, m) && Calculations(x + NumberOfAdded2, h + 1, m) && Calculations(x * NumberOfMultiply, h + 1, m);
        }
        return false;
    }

    public List<Integer> getResult() {
        for (int x = 1; x < Winning; x++) {
            if (Calculations(x, 1, 0)) {
                list.add(x);
            }
        }
        return list;
    }
}
