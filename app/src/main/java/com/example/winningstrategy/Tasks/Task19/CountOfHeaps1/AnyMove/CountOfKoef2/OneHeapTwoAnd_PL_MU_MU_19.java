package com.example.winningstrategy.Tasks.Task19.CountOfHeaps1.AnyMove.CountOfKoef2;

public class OneHeapTwoAnd_PL_MU_MU_19 {

    private final int NumberOfAdded1;
    private final int NumberOfSquared;
    private final int Winning;

    public OneHeapTwoAnd_PL_MU_MU_19(int NumberOfAdded1, int NumberOfSquared, int Winning){
        this.NumberOfAdded1 = NumberOfAdded1;
        this.NumberOfSquared = NumberOfSquared;
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
                return Calculations(x + NumberOfAdded1, h + 1) || Calculations((int) Math.pow(x, NumberOfSquared), h + 1);
            else
                return Calculations(x + NumberOfAdded1, h + 1) && Calculations((int) Math.pow(x, NumberOfSquared), h + 1);
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
