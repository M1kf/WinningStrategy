package com.example.winningstrategy.Tasks.CountOfHeaps2.Task20.CountOfKoef3;

import java.util.ArrayList;
import java.util.List;

public class TwoHeapsThree_PL_PL_MU_20 {
    private final int NumberOfAdded1;
    private final int NumberOfAdded2;
    private final int NumberOfMultiply;
    private final int NumberOfStonesInAHeap;
    private final int Winning;
    private List<Integer> list = new ArrayList<>();

    public TwoHeapsThree_PL_PL_MU_20(int numberOfAdded1, int numberOfAdded2, int numberOfMultiply, int numberOfStonesInAHeap, int winning) {
        NumberOfAdded1 = numberOfAdded1;
        NumberOfAdded2 = numberOfAdded2;
        NumberOfMultiply = numberOfMultiply;
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
                return Calculations(x + NumberOfAdded1, y + NumberOfAdded2, h + 1) || Calculations(x + NumberOfAdded2, y + NumberOfAdded1, h + 1) ||
                    Calculations(x * NumberOfMultiply, y, h + 1) || Calculations(x, y * NumberOfMultiply, h + 1);
            else
                return Calculations(x + NumberOfAdded1, y + NumberOfAdded2, h + 1) && Calculations(x + NumberOfAdded2, y + NumberOfAdded1, h + 1) &&
                        Calculations(x * NumberOfMultiply, y, h + 1) && Calculations(x, y * NumberOfMultiply, h + 1);
    }

    public List<Integer> getResult() {
        for (int x = 1; x < Winning; x++) {
            if (Calculations(x, NumberOfStonesInAHeap, 1))
                list.add(x);
        }
        return list;
    }
}
