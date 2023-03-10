package com.example.winningstrategy.Tasks.CountOfHeaps2.Task19.CountOfKoef2;

public class TwoHeapsTwo_PL_PL_19 {
    private final int NumberOfAdded;
    private final int NumberOfStonesInAHeap;
    private final int Winning;

    public TwoHeapsTwo_PL_PL_19(int numberOfAdded, int numberOfStonesInAHeap, int winning) {
        NumberOfAdded = numberOfAdded;
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
            return Calculations(x + NumberOfAdded, y, h + 1) || Calculations(x, y + NumberOfAdded, h + 1) ||
                    Calculations(x + y, y, h + 1) || Calculations(x, y + x, h + 1);
    }

    public int getResult() {
        for (int x = 1; x < Winning; x++) {
            if (Calculations(x, NumberOfStonesInAHeap, 1))
                return x;
        }
        return 0;
    }
}
