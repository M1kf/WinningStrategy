package com.example.winningstrategy.Tasks.Task21.CountOfHeaps1.CountOfKoef3.NoSame;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OneHeapThreeNoSameMe21 {
    private final int NumberOfAdded1;
    private final int NumberOfAdded2;
    private final int NumberOfMultiply;
    private final int Winning;
    private List<Integer> list = new ArrayList<>();
    private List<Integer> delete1 = new ArrayList<>();
    private List<Integer> delete2 = new ArrayList<>();

    public OneHeapThreeNoSameMe21(int NumberOfAdded1, int NumberOfAdded2, int NumberOfMultiply, int Winning) {
        this.NumberOfAdded1 = NumberOfAdded1;
        this.NumberOfAdded2 = NumberOfAdded2;
        this.NumberOfMultiply = NumberOfMultiply;
        this.Winning = Winning;
    }

    private boolean Calculations(int x, int h, int p, int v) {
        if ((h == 2 || h == 4 || h == 6) && x >= Winning)
            return true;
        if (h == 6 && x < Winning)
            return false;
        if (h < 6 && x >= Winning)
            return false;
        else {
            if (h % 2 == 0) {
                if (h == 2)
                    return Calculations(x + NumberOfAdded1, h + 1, p, 1) && Calculations(x + NumberOfAdded2, h + 1, p, 2) && Calculations(x * NumberOfMultiply, h + 1, p, 3);
                if (h == 4) {
                    if (v == 1)
                        return Calculations(x + NumberOfAdded2, h + 1, p, v) && Calculations(x * NumberOfMultiply, h + 1, p, v);
                    if (v == 2)
                        return Calculations(x + NumberOfAdded1, h + 1, p, v) && Calculations(x * NumberOfMultiply, h + 1, p, v);
                    if (v == 3)
                        return Calculations(x + NumberOfAdded1, h + 1, p, v) && Calculations(x + NumberOfAdded2, h + 1, p, v);
                }
            } else {
                if (h == 1)
                    return Calculations(x + NumberOfAdded1, h + 1, 1, v) || Calculations(x + NumberOfAdded2, h + 1, 2, v) || Calculations(x * NumberOfMultiply, h + 1, 3, v);
                if (h == 3) {
                    if (p == 1)
                        return Calculations(x + NumberOfAdded2, h + 1, 2, v) || Calculations(x * NumberOfMultiply, h + 1, 3, v);
                    if (p == 2)
                        return Calculations(x + NumberOfAdded1, h + 1, 1, v) || Calculations(x * NumberOfMultiply, h + 1, 3, v);
                    if (p == 3)
                        return Calculations(x + NumberOfAdded1, h + 1, 1, v) || Calculations(x + NumberOfAdded2, h + 1, 2, v);
                }
                if (h == 5) {
                    if (p == 1)
                        return Calculations(x + NumberOfAdded2, h + 1, p, v) || Calculations(x * NumberOfMultiply, h + 1, p, v);
                    if (p == 2)
                        return Calculations(x + NumberOfAdded1, h + 1, p, v) || Calculations(x * NumberOfMultiply, h + 1, p, v);
                    if (p == 3)
                        return Calculations(x + NumberOfAdded1, h + 1, p, v) || Calculations(x + NumberOfAdded2, h + 1, p, v);
                }
            }
        }
        return false;
    }

    private boolean CalculationsDelete1(int x, int h) {
        if (h == 2 && x >= Winning)
            return true;
        if (h == 2 && x < Winning)
            return false;
        if (h < 2 && x >= Winning)
            return false;
        else {
            if (h % 2 != 0)
                return CalculationsDelete1(x + NumberOfAdded1, h + 1) || CalculationsDelete1(x + NumberOfAdded2, h + 1) || CalculationsDelete1(x * NumberOfMultiply, h + 1);
            else
                return CalculationsDelete1(x + NumberOfAdded1, h + 1) && CalculationsDelete1(x + NumberOfAdded2, h + 1) && CalculationsDelete1(x * NumberOfMultiply, h + 1);
        }
    }

    private boolean CalculationsDelete2(int x, int h, int m) {
        if (h == 4 && x >= Winning)
            return true;
        if (h == 4 && x < Winning)
            return false;
        if (h < 4 && x >= Winning)
            return false;
        else {
            if (h % 2 != 0) {
                if (h == 1)
                    return CalculationsDelete2(x + NumberOfAdded1, h + 1, 1) || CalculationsDelete2(x + NumberOfAdded2, h + 1, 2) || CalculationsDelete2(x * NumberOfMultiply, h + 1, 3);
                if (h == 3) {
                    if (m == 1)
                        return CalculationsDelete2(x + NumberOfAdded2, h + 1, m) || CalculationsDelete2(x * NumberOfMultiply, h + 1, m);
                    if (m == 2)
                        return CalculationsDelete2(x + NumberOfAdded1, h + 1, m) || CalculationsDelete2(x * NumberOfMultiply, h + 1, m);
                    if (m == 3)
                        return CalculationsDelete2(x + NumberOfAdded1, h + 1, m) || CalculationsDelete2(x + NumberOfAdded2, h + 1, m);
                }
            } else
                return CalculationsDelete2(x + NumberOfAdded1, h + 1, m) && CalculationsDelete2(x + NumberOfAdded2, h + 1, m) && CalculationsDelete2(x * NumberOfMultiply, h + 1, m);
        }
        return false;
    }

    public List<Integer> getResult() {
        for (int x = 1; x < Winning; x++) {
            if (Calculations(x, 1, 0, 0))
                list.add(x);
        }

        for (int j = 1; j < Winning; j++) {
            if (CalculationsDelete1(j, 1))
                delete1.add(j);
        }

        for (int j = 1; j < Winning; j++) {
            if (CalculationsDelete2(j, 1, 0))
                delete2.add(j);
        }

        for (int i = 0; i < list.size(); i++)
            for (int j = 0; j < delete1.size(); j++)
                if (Objects.equals(list.get(i), delete1.get(j)))
                    list.remove(i);

        for (int i = 0; i < list.size(); i++)
            for (int j = 0; j < delete2.size(); j++)
                if (Objects.equals(list.get(i), delete2.get(j)))
                    list.remove(i);

        return list;
    }
}
