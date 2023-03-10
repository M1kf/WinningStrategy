package com.example.winningstrategy.Tasks.CountOfHeaps2.Task19.CountOfKoef3;

public class TwoHeapsThree_PL_PL_MU_19 {
    private final int NumberOfAdded1;
    private final int NumberOfAdded2;
    private final int NumberOfMultiply;
    private final int NumberOfStonesInAHeap;
    private final int Winning;

    public TwoHeapsThree_PL_PL_MU_19(int numberOfAdded1, int numberOfAdded2, int numberOfMultiply, int numberOfStonesInAHeap, int winning) {
        NumberOfAdded1 = numberOfAdded1;
        NumberOfAdded2 = numberOfAdded2;
        NumberOfMultiply = numberOfMultiply;
        NumberOfStonesInAHeap = numberOfStonesInAHeap;
        Winning = winning;
    }

    private boolean Calculations(int x, int y, int h) {
        if (h == 3 && x + y >= Winning)
            return true;
        if (h == 3 && x + y < Winning)
            return false;
        if (h < 3 && x + y >= Winning)
            return false;
        else
            return Calculations(x + NumberOfAdded1, y + NumberOfAdded2, h + 1) || Calculations(x + NumberOfAdded2, y + NumberOfAdded1, h + 1) ||
                    Calculations(x * NumberOfMultiply, y, h + 1) || Calculations(x, y * NumberOfMultiply, h + 1);
    }

    public int getResult() {
        for (int x = 1; x < Winning; x++) {
            if (Calculations(x, NumberOfStonesInAHeap, 1))
                return x;
        }
        return 0;
    }
}
