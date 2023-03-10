package com.example.winningstrategy.Tasks.CountOfHeaps2.Task20.CountOfKoef3;

import java.util.ArrayList;
import java.util.List;

public class TwoHeapsThree_PL_MU_MU_20 {
    private final int NumberOfAdded;
    private final int NumberOfMultiply1;
    private final int NumberOfMultiply2;
    private final int NumberOfStonesInAHeap;
    private final int Winning;
    private List<Integer> list = new ArrayList<>();

    public TwoHeapsThree_PL_MU_MU_20(int numberOfAdded, int numberOfMultiply1, int numberOfMultiply2, int numberOfStonesInAHeap, int winning) {
        NumberOfAdded = numberOfAdded;
        NumberOfMultiply1 = numberOfMultiply1;
        NumberOfMultiply2 = numberOfMultiply2;
        NumberOfStonesInAHeap = numberOfStonesInAHeap;
        Winning = winning;
    }

    private boolean Calculations(int x, int y, int h) {
        if (h == 4 && x + y >= Winning)
            return true;
        if (h == 4 && x + y < Winning)
            return false;
        if (h < 4 && x + y >= Winning)
            return false;
        else
            if (h % 2 != 0)
                return Calculations(x + NumberOfAdded, y, h + 1) || Calculations(x, y + NumberOfAdded, h + 1) ||
                    Calculations(x, y  * NumberOfMultiply1, h + 1) || Calculations(x  * NumberOfMultiply2, y, h + 1);
            else
                return Calculations(x + NumberOfAdded, y, h + 1) && Calculations(x, y + NumberOfAdded, h + 1) &&
                        Calculations(x, y  * NumberOfMultiply1, h + 1) && Calculations(x  * NumberOfMultiply2, y, h + 1);
    }

    public List<Integer> getResult() {
        for (int x = 1; x < Winning; x++) {
            if (Calculations(x, NumberOfStonesInAHeap, 1))
                list.add(x);
        }
        return list;
    }
}
