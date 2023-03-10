package com.example.winningstrategy.Tasks.CountOfHeaps2.Task21.CountOfKoef2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TwoHeapsTwo_PL_MU_21 {
    private final int NumberOfAdded1;
    private final int NumberOfMultiply;
    private final int NumberOfStonesInAHeap;
    private final int Winning;
    private List<Integer> list = new ArrayList<>();
    private List<Integer> delete = new ArrayList<>();

    public TwoHeapsTwo_PL_MU_21(int numberOfAdded1, int numberOfMultiply, int numberOfStonesInAHeap, int winning) {
        NumberOfAdded1 = numberOfAdded1;
        NumberOfMultiply = numberOfMultiply;
        NumberOfStonesInAHeap = numberOfStonesInAHeap;
        Winning = winning;
    }

    private boolean Calculations(int x, int y, int h) {
        if ((h == 3 || h == 5) && x + y >= Winning)
            return true;
        if (h == 5 && x + y < Winning)
            return false;
        if (h < 5 && x + y >= Winning)
            return false;
        else {
            if (h % 2 == 0)
                return Calculations(x + NumberOfAdded1, y, h + 1) || Calculations(x, y + NumberOfAdded1, h + 1) ||
                        Calculations(x * NumberOfMultiply, y, h + 1) || Calculations(x, y * NumberOfMultiply, h + 1);
            else
                return Calculations(x + NumberOfAdded1, y, h + 1) && Calculations(x, y + NumberOfAdded1, h + 1) &&
                        Calculations(x * NumberOfMultiply, y, h + 1) && Calculations(x, y * NumberOfMultiply, h + 1);
        }
    }

    private boolean CalculationsDelete(int x, int y, int h) {
        if (h == 3 && x + y >= Winning)
            return true;
        if (h == 3 && x + y < Winning)
            return false;
        if (h < 3 && x + y >= Winning)
            return false;
        else {
            if (h % 2 == 0)
                return CalculationsDelete(x + NumberOfAdded1, y, h + 1) || CalculationsDelete(x, y + NumberOfAdded1, h + 1) ||
                        CalculationsDelete(x * NumberOfMultiply, y, h + 1) || CalculationsDelete(x, y * NumberOfMultiply, h + 1);
            else
                return CalculationsDelete(x + NumberOfAdded1, y, h + 1) && CalculationsDelete(x, y + NumberOfAdded1, h + 1) &&
                        CalculationsDelete(x * NumberOfMultiply, y, h + 1) && CalculationsDelete(x, y * NumberOfMultiply, h + 1);
        }
    }

    public List<Integer> getResult() {
        for (int x = 1; x < Winning; x++) {
            if (Calculations(x, NumberOfStonesInAHeap, 1))
                list.add(x);
        }
        for (int j = 1; j < Winning; j++) {
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
