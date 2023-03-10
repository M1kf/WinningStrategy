package com.example.winningstrategy.Tasks.CountOfHeaps2.Task19.CountOfKoef2;

public class TwoHeapsTwo_MN_DI_m_19 {
    private final int NumberOfDeducted;
    private final int NumberOfDivided;
    private final int NumberOfStonesInAHeap;
    private final int Winning;

    public TwoHeapsTwo_MN_DI_m_19(int numberOfDeducted, int numberOfDivided, int numberOfStonesInAHeap, int winning) {
        NumberOfDeducted = numberOfDeducted;
        NumberOfDivided = numberOfDivided;
        NumberOfStonesInAHeap = numberOfStonesInAHeap;
        Winning = winning;
    }

    private boolean Calculations(int x, int y, int h) {
        if (h == 3 && x + y <= Winning)
            return true;
        if (h == 3 && x + y > Winning)
            return false;
        if (h < 3 && x + y <= Winning)
            return false;
        else
            return Calculations(x - NumberOfDeducted, y, h + 1) || Calculations(x, y - NumberOfDeducted, h + 1) ||
                    Calculations(x / NumberOfDivided, y, h + 1) || Calculations(x, y / NumberOfDivided, h + 1);
    }

    public int getResult() {
        for (int x = 1000; x > 1; x--) {
            if (Calculations(x, NumberOfStonesInAHeap, 1))
                return x;
        }
        return 0;
    }
}
