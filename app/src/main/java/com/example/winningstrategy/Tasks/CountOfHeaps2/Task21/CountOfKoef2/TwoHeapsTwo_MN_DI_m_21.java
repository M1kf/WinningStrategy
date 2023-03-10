package com.example.winningstrategy.Tasks.CountOfHeaps2.Task21.CountOfKoef2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TwoHeapsTwo_MN_DI_m_21 {
    private final int NumberOfDeducted;
    private final int NumberOfDivided;
    private final int NumberOfStonesInAHeap;
    private final int Winning;
    private List<Integer> list = new ArrayList<>();
    private List<Integer> delete = new ArrayList<>();

    public TwoHeapsTwo_MN_DI_m_21(int numberOfDeducted, int numberOfDivided, int numberOfStonesInAHeap, int winning) {
        NumberOfDeducted = numberOfDeducted;
        NumberOfDivided = numberOfDivided;
        NumberOfStonesInAHeap = numberOfStonesInAHeap;
        Winning = winning;
    }

    private boolean Calculations(int x, int y, int h) {
        if ((h == 3 || h == 5) && x + y <= Winning)
            return true;
        if (h == 5 && x + y > Winning)
            return false;
        if (h < 5 && x + y <= Winning)
            return false;
        else {
            if (h % 2 == 0)
                return Calculations(x - NumberOfDeducted, y, h + 1) || Calculations(x, y - NumberOfDeducted, h + 1) ||
                        Calculations(x / NumberOfDivided, y, h + 1) || Calculations(x, y / NumberOfDivided, h + 1);
            else
                return Calculations(x - NumberOfDeducted, y, h + 1) && Calculations(x, y - NumberOfDeducted, h + 1) &&
                        Calculations(x / NumberOfDivided, y, h + 1) && Calculations(x, y / NumberOfDivided, h + 1);
        }
    }

    private boolean CalculationsDelete(int x, int y, int h) {
        if (h == 3 && x + y <= Winning)
            return true;
        if (h == 3 && x + y > Winning)
            return false;
        if (h < 3 && x + y <= Winning)
            return false;
        else {
            if (h % 2 == 0)
                return CalculationsDelete(x - NumberOfDeducted, y, h + 1) || CalculationsDelete(x, y - NumberOfDeducted, h + 1) ||
                        CalculationsDelete(x / NumberOfDivided, y, h + 1) || CalculationsDelete(x, y / NumberOfDivided, h + 1);
            else
                return CalculationsDelete(x - NumberOfDeducted, y, h + 1) && CalculationsDelete(x, y - NumberOfDeducted, h + 1) &&
                        CalculationsDelete(x / NumberOfDivided, y, h + 1) && CalculationsDelete(x, y / NumberOfDivided, h + 1);
        }
    }

    public List<Integer> getResult() {
        for (int x = 1; x < 1000; x++) {
            if (Calculations(x, NumberOfStonesInAHeap, 1))
                list.add(x);
        }
        for (int j = 1; j < 1000; j++) {
            if (CalculationsDelete(j, NumberOfStonesInAHeap, 1))
                delete.add(j);
        }

        for (int i = 0; i < list.size(); i++)
            for (int j = 0; j < delete.size(); j++)
                if (Objects.equals(list.get(i), delete.get(j)))
                    list.remove(i);

        return list;
    }
}
