package com.example.winningstrategy.Tasks.Task20.CountOfHeaps1.CountOfKoef2;

import java.util.ArrayList;
import java.util.List;

public class OneHeapTwo_PL_MU_MN_20 {
    private final int NumberOfAdded1;
    private final int NumberOfMultiply;
    private final int NumberOfSubtract;
    private final int Winning;
    private List<Integer> list = new ArrayList<>();

    public OneHeapTwo_PL_MU_MN_20(int NumberOfAdded1, int NumberOfMultiply, int NumberOfSubtract, int Winning) {
        this.NumberOfAdded1 = NumberOfAdded1;
        this.NumberOfMultiply = NumberOfMultiply;
        this.NumberOfSubtract = NumberOfSubtract;
        this.Winning = Winning;
    }

    private boolean Calculations(int x, int h) {
        if (h == 4 && x >= Winning)
            return true;
        if (h == 4 && x < Winning)
            return false;
        if (h < 4 && x >= Winning)
            return false;
        else {
            if (h % 2 != 0)
                return Calculations(x + NumberOfAdded1, h + 1) || Calculations(x * NumberOfMultiply - NumberOfSubtract, h + 1);
            else
                return Calculations(x + NumberOfAdded1, h + 1) && Calculations(x * NumberOfMultiply - NumberOfSubtract, h + 1);
        }
    }

    public List<Integer> getResult() {
        for (int x = 1; x < Winning; x++) {
            if (Calculations(x, 1))
                list.add(x);
        }
        return list;
    }
}
