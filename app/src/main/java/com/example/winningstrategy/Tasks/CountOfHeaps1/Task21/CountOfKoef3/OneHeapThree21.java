package com.example.winningstrategy.Tasks.CountOfHeaps1.Task21.CountOfKoef3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OneHeapThree21 {
    private final int NumberOfAdded1;
    private final int NumberOfAdded2;
    private final int NumberOfMultiply;
    private final int Winning;
    private List<Integer> list = new ArrayList<>();
    private List<Integer> delete = new ArrayList<>();

    public OneHeapThree21(int NumberOfAdded1, int NumberOfAdded2, int NumberOfMultiply, int Winning) {
        this.NumberOfAdded1 = NumberOfAdded1;
        this.NumberOfAdded2 = NumberOfAdded2;
        this.NumberOfMultiply = NumberOfMultiply;
        this.Winning = Winning;
    }

    private boolean Calculations(int x, int h) {
        if ((h == 3 || h == 5) && x >= Winning)
            return true;
        if (h == 5 && x < Winning)
            return false;
        if (h < 5 && x >= Winning)
            return false;
        else {
            if (h % 2 == 0)
                return Calculations(x + NumberOfAdded1, h + 1) || Calculations(x + NumberOfAdded2, h + 1) || Calculations(x * NumberOfMultiply, h + 1);
            else
                return Calculations(x + NumberOfAdded1, h + 1) && Calculations(x + NumberOfAdded2, h + 1) && Calculations(x * NumberOfMultiply, h + 1);
        }
    }

    private boolean CalculationsDelete(int x, int h) {
        if (h == 3 && x >= Winning)
            return true;
        if (h == 3 && x < Winning)
            return false;
        if (h < 3 && x >= Winning)
            return false;
        else {
            if (h % 2 == 0)
                return CalculationsDelete(x + NumberOfAdded1, h + 1) || CalculationsDelete(x + NumberOfAdded2, h + 1) || CalculationsDelete(x * NumberOfMultiply, h + 1);
            else
                return CalculationsDelete(x + NumberOfAdded1, h + 1) && CalculationsDelete(x + NumberOfAdded2, h + 1) && CalculationsDelete(x * NumberOfMultiply, h + 1);
        }
    }

    public List<Integer> getResult() {
        for (int x = 1; x < Winning; x++) {
            if (Calculations(x, 1))
                list.add(x);
        }
        for (int j = 1; j < Winning; j++) {
            if (CalculationsDelete(j, 1))
                delete.add(j);
        }

        for (int i = 0; i < list.size(); i++)
            for (int j = 0; j < delete.size(); j++)
                if (Objects.equals(list.get(i), delete.get(j)))
                    list.remove(i);

        return list;
    }
}
