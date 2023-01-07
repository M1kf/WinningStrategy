package com.example.winningstrategy.Tasks.Task19.CountOfHeaps1.UnluckyMove.CountOfKoef2;

public class OneHeapTwoOr_PL_MU_MN_19 {
    private final int NumberOfAdded1;
    private final int NumberOfMultiplied;
    private final int NumberOfSubtracted;
    private final int Winning;

    public OneHeapTwoOr_PL_MU_MN_19(int NumberOfAdded1, int NumberOfMultiplied, int NumberOfSubtracted, int Winning){
        this.NumberOfAdded1 = NumberOfAdded1;
        this.NumberOfMultiplied = NumberOfMultiplied;
        this.NumberOfSubtracted = NumberOfSubtracted;
        this.Winning = Winning;
    }

    private boolean Calculations(int x, int h){
        if(h == 3 && x >= Winning)
            return true;
        if(h == 3 && x < Winning)
            return false;
        if(h < 3 && x >= Winning)
            return false;
        else {
            if(h % 2 == 0)
                return Calculations(x + NumberOfAdded1, h + 1) || Calculations(x * NumberOfMultiplied - NumberOfSubtracted, h + 1);
            else
                return Calculations(x + NumberOfAdded1, h + 1) || Calculations(x * NumberOfMultiplied - NumberOfSubtracted, h + 1);
        }
    }

    public int getResult(){
        for(int x = 1; x < Winning; x++){
            if(Calculations(x, 1))
                return x;
        }
        return 0;
    }
}
