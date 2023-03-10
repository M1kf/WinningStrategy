package com.example.winningstrategy.Tasks.CountOfHeaps2.Task20.CountOfKoef2;

import java.util.ArrayList;
import java.util.List;

public class TwoHeapsTwo_MN_DI_p_20 {
    private final int NumberOfDeducted;
    private final int NumberOfDivided;
    private final int NumberOfStonesInAHeap;
    private final int Winning;
    private List<Integer> list = new ArrayList<>();

    public TwoHeapsTwo_MN_DI_p_20(int numberOfDeducted, int numberOfDivided, int numberOfStonesInAHeap, int winning) {
        NumberOfDeducted = numberOfDeducted;
        NumberOfDivided = numberOfDivided;
        NumberOfStonesInAHeap = numberOfStonesInAHeap;
        Winning = winning;
    }

    private boolean Calculations(int x, int y, int h) {
        if (h == 4 && x + y <= Winning)
            return true;
        if (h == 4 && x + y > Winning)
            return false;
        if (h < 4 && x + y <= Winning)
            return false;
        else
            if (h % 2 != 0)
                return Calculations(x - NumberOfDeducted, y, h + 1) || Calculations(x, y - NumberOfDeducted, h + 1) ||
                    Calculations(x / NumberOfDivided + x % NumberOfDivided, y, h + 1) || Calculations(x, y / NumberOfDivided + y % NumberOfDivided, h + 1);
            else
                return Calculations(x - NumberOfDeducted, y, h + 1) && Calculations(x, y - NumberOfDeducted, h + 1) &&
                        Calculations(x / NumberOfDivided + x % NumberOfDivided, y, h + 1) && Calculations(x, y / NumberOfDivided + y % NumberOfDivided, h + 1);
    }

    public List<Integer> getResult() {
        for (int x = 1; x < 1000; x++) {
            if (Calculations(x, NumberOfStonesInAHeap, 1))
                list.add(x);
        }
        return list;
    }
}
