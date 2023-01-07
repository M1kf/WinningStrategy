package com.example.winningstrategy;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Space;
import android.widget.TextView;

import com.example.winningstrategy.Tasks.Task19.CountOfHeaps1.AnyMove.CountOfKoef2.OneHeapTwoAnd_PL_MU_19;
import com.example.winningstrategy.Tasks.Task19.CountOfHeaps1.AnyMove.CountOfKoef2.OneHeapTwoAnd_PL_MU_MN_19;
import com.example.winningstrategy.Tasks.Task19.CountOfHeaps1.AnyMove.CountOfKoef2.OneHeapTwoAnd_PL_MU_MU_19;
import com.example.winningstrategy.Tasks.Task19.CountOfHeaps1.AnyMove.CountOfKoef2.OneHeapTwoAnd_PL_MU_PL_19;
import com.example.winningstrategy.Tasks.Task19.CountOfHeaps1.AnyMove.CountOfKoef2.OneHeapTwoAnd_PL_PL_19;
import com.example.winningstrategy.Tasks.Task19.CountOfHeaps1.AnyMove.CountOfKoef3.NoSame.OneHeapThreeNoSame2Player19;
import com.example.winningstrategy.Tasks.Task19.CountOfHeaps1.AnyMove.CountOfKoef3.NoSame.OneHeapThreeNoSameMe19;
import com.example.winningstrategy.Tasks.Task19.CountOfHeaps1.AnyMove.CountOfKoef3.OneHeapThreeAnd19;
import com.example.winningstrategy.Tasks.Task19.CountOfHeaps1.UnluckyMove.CountOfKoef2.OneHeapTwoOr_PL_MU_19;
import com.example.winningstrategy.Tasks.Task19.CountOfHeaps1.UnluckyMove.CountOfKoef2.OneHeapTwoOr_PL_MU_MN_19;
import com.example.winningstrategy.Tasks.Task19.CountOfHeaps1.UnluckyMove.CountOfKoef2.OneHeapTwoOr_PL_MU_MU_19;
import com.example.winningstrategy.Tasks.Task19.CountOfHeaps1.UnluckyMove.CountOfKoef2.OneHeapTwoOr_PL_MU_PL_19;
import com.example.winningstrategy.Tasks.Task19.CountOfHeaps1.UnluckyMove.CountOfKoef2.OneHeapTwoOr_PL_PL_19;
import com.example.winningstrategy.Tasks.Task19.CountOfHeaps1.UnluckyMove.CountOfKoef3.OneHeapThreeOr19;
import com.example.winningstrategy.Tasks.Task20.CountOfHeaps1.CountOfKoef2.OneHeapTwo_PL_MU_20;
import com.example.winningstrategy.Tasks.Task20.CountOfHeaps1.CountOfKoef2.OneHeapTwo_PL_MU_MN_20;
import com.example.winningstrategy.Tasks.Task20.CountOfHeaps1.CountOfKoef2.OneHeapTwo_PL_MU_MU_20;
import com.example.winningstrategy.Tasks.Task20.CountOfHeaps1.CountOfKoef2.OneHeapTwo_PL_MU_PL_20;
import com.example.winningstrategy.Tasks.Task20.CountOfHeaps1.CountOfKoef2.OneHeapTwo_PL_PL_20;
import com.example.winningstrategy.Tasks.Task20.CountOfHeaps1.CountOfKoef3.NoSame.OneHeapThreeNoSame2Player20;
import com.example.winningstrategy.Tasks.Task20.CountOfHeaps1.CountOfKoef3.NoSame.OneHeapThreeNoSameMe20;
import com.example.winningstrategy.Tasks.Task20.CountOfHeaps1.CountOfKoef3.OneHeapThree20;
import com.example.winningstrategy.Tasks.Task21.CountOfHeaps1.CountOfKoef2.OneHeapTwo_PL_MU_21;
import com.example.winningstrategy.Tasks.Task21.CountOfHeaps1.CountOfKoef2.OneHeapTwo_PL_MU_MN_21;
import com.example.winningstrategy.Tasks.Task21.CountOfHeaps1.CountOfKoef2.OneHeapTwo_PL_MU_MU_21;
import com.example.winningstrategy.Tasks.Task21.CountOfHeaps1.CountOfKoef2.OneHeapTwo_PL_MU_PL_21;
import com.example.winningstrategy.Tasks.Task21.CountOfHeaps1.CountOfKoef2.OneHeapTwo_PL_PL_21;
import com.example.winningstrategy.Tasks.Task21.CountOfHeaps1.CountOfKoef3.NoSame.OneHeapThreeNoSame2Player21;
import com.example.winningstrategy.Tasks.Task21.CountOfHeaps1.CountOfKoef3.NoSame.OneHeapThreeNoSameMe21;
import com.example.winningstrategy.Tasks.Task21.CountOfHeaps1.CountOfKoef3.OneHeapThree21;

import java.util.List;

public class ComplexActivity extends AppCompatActivity implements View.OnClickListener {
    Button AnyMoveButton, UnluckyMoveButton, Koef2Button, Koef3Button, YesButton, NoButton,
            MyLastOneButton, AnotherPlayerButton, ResultButton, BeginFromStartButton;
    TextView ChooseAction, Answer19, Answer20, Answer21, CountOfHeaps1, Pvos;
    View View1, View2;
    ListView ListView;
    Space Space1, Space2, Space3, Space4, Space5, Space6, Space7;
    LinearLayout LayoutListView, LayoutEdT1, LayoutEdT2, LayoutEdT3, LayoutEdT4,
            LayoutCountOfKoef, LayoutMove, AnswerLayout, LayoutBranch3Koef, LayoutWhichMove,
            LayoutErrorAnswer;
    EditText EditText1, EditText2, EditText3, EditText4;

    int index = -1;
    int saveIndexOfButton = -1;
    boolean flAnyMoveButton, flUnluckyMoveButton, flKoef2Button, flKoef3Button, flYesButton,
            flNoButton, somethingIsChecked, getAnswerIsSelected, noIsPressed, flMyLastOne,
            flAnotherPlayer;
    final String[] arrayChooseAction = new String[]{"Добавить и умножить", "Добавить и добавить",
            "Добавить и возвести", "Добавить, умножить и вычесть", "Добавить, умножить и добавить"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complex);
        init();
    }

    @SuppressLint("CutPasteId")
    private void init(){
        AnyMoveButton = findViewById(R.id.anyMove);
        UnluckyMoveButton = findViewById(R.id.unluckyMove);
        Koef2Button = findViewById(R.id.koef2);
        Koef3Button = findViewById(R.id.koef3);
        YesButton = findViewById(R.id.yesButton);
        NoButton = findViewById(R.id.noButton);
        MyLastOneButton = findViewById(R.id.myMove);
        AnotherPlayerButton = findViewById(R.id.anotherPlayer);
        ResultButton = findViewById(R.id.resultButton);
        BeginFromStartButton = findViewById(R.id.beginFromStart);

        AnyMoveButton.setOnClickListener(this);
        UnluckyMoveButton.setOnClickListener(this);
        Koef2Button.setOnClickListener(this);
        Koef3Button.setOnClickListener(this);
        YesButton.setOnClickListener(this);
        NoButton.setOnClickListener(this);
        MyLastOneButton.setOnClickListener(this);
        AnotherPlayerButton.setOnClickListener(this);
        ResultButton.setOnClickListener(this);
        BeginFromStartButton.setOnClickListener(this);

        ChooseAction = findViewById(R.id.chooseAction);
        Answer19 = findViewById(R.id.answer19);
        Answer20 = findViewById(R.id.answer20);
        Answer21 = findViewById(R.id.answer21);
        CountOfHeaps1 = findViewById(R.id.countOfHeaps1);
        Pvos = findViewById(R.id.pvos);

        View1 = findViewById(R.id.view1);
        View2 = findViewById(R.id.view2);

        ListView = findViewById(R.id.listView);

        Space1 = findViewById(R.id.space1);
        Space2 = findViewById(R.id.space2);
        Space3 = findViewById(R.id.space3);
        Space4 = findViewById(R.id.space4);
        Space5 = findViewById(R.id.space5);
        Space6 = findViewById(R.id.space6);
        Space7 = findViewById(R.id.space7);

        LayoutListView = findViewById(R.id.layoutListView);
        LayoutEdT1 = findViewById(R.id.layoutEdT1);
        LayoutEdT2 = findViewById(R.id.layoutEdT2);
        LayoutEdT3 = findViewById(R.id.layoutEdT3);
        LayoutEdT4 = findViewById(R.id.layoutEdT4);
        LayoutMove = findViewById(R.id.layoutMove);
        LayoutCountOfKoef = findViewById(R.id.layoutCountOfKoef);
        LayoutBranch3Koef = findViewById(R.id.layoutBranch3Koef);
        LayoutWhichMove = findViewById(R.id.whichMove);
        LayoutErrorAnswer = findViewById(R.id.layoutErrorAnswer);
        AnswerLayout = findViewById(R.id.answerLayout);

        EditText1 = findViewById(R.id.editText1);
        EditText2 = findViewById(R.id.editText2);
        EditText3 = findViewById(R.id.editText3);
        EditText4 = findViewById(R.id.editText4);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_white_text,
                R.id.list_content, arrayChooseAction);
        ListView.setAdapter(adapter);

        flAnyMoveButton = flUnluckyMoveButton = flKoef2Button = flKoef3Button = flYesButton = flNoButton
                = somethingIsChecked = getAnswerIsSelected = flMyLastOne = flAnotherPlayer =
                noIsPressed =false;
    }

    @SuppressLint({"UseCompatLoadingForDrawables", "NonConstantResourceId", "SetTextI18n"})
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.anyMove:
                if (flUnluckyMoveButton) {
                    UnluckyMoveButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_task19));
                    flUnluckyMoveButton = false;
                }
                AnyMoveButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_pressed_19));
                flAnyMoveButton = true;
                break;

            case R.id.unluckyMove:
                if (flAnyMoveButton) {
                    AnyMoveButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_task19));
                    flAnyMoveButton = false;
                }
                UnluckyMoveButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_pressed_19));
                flUnluckyMoveButton = true;
                break;

            case R.id.koef2:
                if (flKoef3Button) {
                    Koef3Button.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_task19));
                    flKoef3Button = false;
                }
                Koef2Button.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_pressed_19));
                flKoef2Button = true;
                LayoutBranch3Koef.setVisibility(View.GONE);
                flYesButton = flNoButton = noIsPressed = false;
                NoButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_task19));
                YesButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_task19));
                AnyMoveButton.setEnabled(true);
                UnluckyMoveButton.setEnabled(true);
                saveIndexOfButton = -1;
                LayoutWhichMove.setVisibility(View.GONE);
                AnotherPlayerButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_task19));
                MyLastOneButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_task19));
                flMyLastOne = flAnotherPlayer = false;

                if (flAnyMoveButton){
                    AnyMoveButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_pressed_19));
                    flAnyMoveButton = true;
                    UnluckyMoveButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_task19));
                    flUnluckyMoveButton = false;
                }

                if (flUnluckyMoveButton){
                    UnluckyMoveButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_pressed_19));
                    flUnluckyMoveButton = true;
                    AnyMoveButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_task19));
                    flAnyMoveButton = false;
                }
                break;

            case R.id.koef3:
                if (flKoef2Button) {
                    Koef2Button.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_task19));
                    flKoef2Button = false;
                }
                Koef3Button.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_pressed_19));
                flKoef3Button = true;
                LayoutBranch3Koef.setVisibility(View.VISIBLE);

                break;

            case R.id.yesButton:
                if (flNoButton) {
                    NoButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_task19));
                    flNoButton = false;
                }
                YesButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_pressed_19));
                flYesButton = true;
                AnyMoveButton.setEnabled(true);
                UnluckyMoveButton.setEnabled(true);

                if (saveIndexOfButton == 1 && noIsPressed){
                    UnluckyMoveButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_task19));
                    AnyMoveButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_pressed_19));

                    flAnyMoveButton = true;
                }

                if (saveIndexOfButton == 2 && noIsPressed) {
                    AnyMoveButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_task19));
                    UnluckyMoveButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_pressed_19));
                    flAnyMoveButton = false;
                    flUnluckyMoveButton = true;
                }

                if (saveIndexOfButton == -1 && noIsPressed){
                    flAnyMoveButton = false;
                    AnyMoveButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_task19));
                    UnluckyMoveButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_task19));
                }

                LayoutWhichMove.setVisibility(View.GONE);
                AnotherPlayerButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_task19));
                MyLastOneButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_task19));
                flMyLastOne = flAnotherPlayer = false;
                break;

            case R.id.noButton:
                if (flYesButton) {
                    YesButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_task19));
                    flYesButton = false;
                }
                NoButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_pressed_19));
                flNoButton = true;

                noIsPressed = true;

                if (flUnluckyMoveButton) {
                    saveIndexOfButton = 2;
                    UnluckyMoveButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_task19));
                    AnyMoveButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_pressed_19));
                    AnyMoveButton.setEnabled(false);
                    UnluckyMoveButton.setEnabled(false);

                }

                if (flAnyMoveButton) {
                    saveIndexOfButton = 1;
                    AnyMoveButton.setEnabled(false);
                    UnluckyMoveButton.setEnabled(false);
                }

                if (!flAnyMoveButton && !flUnluckyMoveButton){
                    AnyMoveButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_pressed_19));
                    AnyMoveButton.setEnabled(false);
                    UnluckyMoveButton.setEnabled(false);
                }

                flAnyMoveButton = true;
                flUnluckyMoveButton = false;
                LayoutWhichMove.setVisibility(View.VISIBLE);
                break;

            case R.id.myMove:
                if (flAnotherPlayer) {
                    AnotherPlayerButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_task19));
                    flAnotherPlayer = false;
                }
                MyLastOneButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_pressed_19));
                flMyLastOne = true;
                break;

            case R.id.anotherPlayer:
                if (flMyLastOne) {
                    MyLastOneButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_task19));
                    flMyLastOne = false;
                }
                AnotherPlayerButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_pressed_19));
                flAnotherPlayer = true;
                break;

            case R.id.resultButton:

                if ((!flAnyMoveButton && !flUnluckyMoveButton) ||
                        (!flKoef2Button && !flKoef3Button) ||
                        (flKoef3Button && !flYesButton && !flNoButton) ||
                        (flNoButton && !flMyLastOne && !flAnotherPlayer) ||
                        (flKoef3Button && (EditText1.getText().toString().isEmpty() ||
                                EditText2.getText().toString().isEmpty() ||
                                EditText3.getText().toString().isEmpty() ||
                                EditText4.getText().toString().isEmpty())) ||
                        (flKoef2Button && (index != 3 && index != 4) && (EditText1.getText().toString().isEmpty() ||
                                EditText2.getText().toString().isEmpty() || EditText4.getText().toString().isEmpty())) ||
                        (flKoef2Button && (index == 3 || index == 4) && (EditText1.getText().toString().isEmpty() ||
                                EditText2.getText().toString().isEmpty() ||
                                EditText3.getText().toString().isEmpty() ||
                                EditText4.getText().toString().isEmpty())) ||
                        (EditText1.getText().toString().length() > 4 ||
                                EditText2.getText().toString().length() > 4 ||
                                EditText3.getText().toString().length() > 4 ||
                                EditText4.getText().toString().length() > 4)) {

                    getAnswerIsSelected = true;

                    ChooseAction.setVisibility(View.GONE);
                    Space1.setVisibility(View.GONE);
                    View1.setVisibility(View.GONE);
                    LayoutListView.setVisibility(View.GONE);
                    View2.setVisibility(View.GONE);
                    Space2.setVisibility(View.GONE);
                    EditText1.setVisibility(View.GONE);
                    EditText2.setVisibility(View.GONE);
                    EditText3.setVisibility(View.GONE);
                    EditText4.setVisibility(View.GONE);
                    Space3.setVisibility(View.GONE);
                    CountOfHeaps1.setVisibility(View.GONE);
                    LayoutCountOfKoef.setVisibility(View.GONE);
                    LayoutMove.setVisibility(View.GONE);
                    Pvos.setVisibility(View.GONE);
                    LayoutBranch3Koef.setVisibility(View.GONE);
                    LayoutWhichMove.setVisibility(View.GONE);
                    ResultButton.setVisibility(View.GONE);
                    AnswerLayout.setVisibility(View.GONE);
                    BeginFromStartButton.setVisibility(View.VISIBLE);

                    LayoutErrorAnswer.setVisibility(View.VISIBLE);
                }
                else {
                    if (flAnyMoveButton) {
                        if (flKoef2Button) {
                            getAnswerIsSelected = true;

                            ChooseAction.setVisibility(View.GONE);
                            Space1.setVisibility(View.GONE);
                            View1.setVisibility(View.GONE);
                            LayoutListView.setVisibility(View.GONE);
                            View2.setVisibility(View.GONE);
                            Space2.setVisibility(View.GONE);
                            EditText1.setVisibility(View.GONE);
                            EditText2.setVisibility(View.GONE);
                            EditText3.setVisibility(View.GONE);
                            EditText4.setVisibility(View.GONE);
                            Space3.setVisibility(View.GONE);
                            Space4.setVisibility(View.GONE);
                            Space5.setVisibility(View.GONE);
                            Space6.setVisibility(View.GONE);
                            Space7.setVisibility(View.VISIBLE);
                            CountOfHeaps1.setVisibility(View.GONE);
                            LayoutCountOfKoef.setVisibility(View.GONE);
                            LayoutBranch3Koef.setVisibility(View.GONE);
                            LayoutWhichMove.setVisibility(View.GONE);
                            LayoutMove.setVisibility(View.GONE);
                            ResultButton.setVisibility(View.GONE);
                            AnswerLayout.setVisibility(View.VISIBLE);
                            BeginFromStartButton.setVisibility(View.VISIBLE);

                            switch (index) {
                                case -1:
                                    LayoutErrorAnswer.setVisibility(View.VISIBLE);
                                    AnswerLayout.setVisibility(View.GONE);
                                    break;

                                case 0:
                                    OneHeapTwoAnd_PL_MU_19 obj_PL_MU_19 = new OneHeapTwoAnd_PL_MU_19(
                                            Integer.parseInt(EditText1.getText().toString()),
                                            Integer.parseInt(EditText2.getText().toString()),
                                            Integer.parseInt(EditText4.getText().toString()));

                                    OneHeapTwo_PL_MU_20 obj_PL_MU_20 = new OneHeapTwo_PL_MU_20(
                                            Integer.parseInt(EditText1.getText().toString()),
                                            Integer.parseInt(EditText2.getText().toString()),
                                            Integer.parseInt(EditText4.getText().toString()));

                                    OneHeapTwo_PL_MU_21 obj_PL_MU_21 = new OneHeapTwo_PL_MU_21(
                                            Integer.parseInt(EditText1.getText().toString()),
                                            Integer.parseInt(EditText2.getText().toString()),
                                            Integer.parseInt(EditText4.getText().toString()));

                                    StringBuilder answer_PL_MU_20 = new StringBuilder();
                                    List<Integer> list_PL_MU_20 = (List<Integer>) obj_PL_MU_20.getResult();

                                    StringBuilder answer_PL_MU_21 = new StringBuilder();
                                    List<Integer> list_PL_MU_21 = (List<Integer>) obj_PL_MU_21.getResult();

                                    if (obj_PL_MU_19.getResult() == 0 || list_PL_MU_20.isEmpty() || list_PL_MU_21.isEmpty()) {
                                        LayoutErrorAnswer.setVisibility(View.VISIBLE);
                                        AnswerLayout.setVisibility(View.GONE);
                                    }
                                    else {
                                        Answer19.setText(Integer.toString(obj_PL_MU_19.getResult()));

                                        for(int elem: list_PL_MU_20) answer_PL_MU_20.append(elem).append("  ");
                                        Answer20.setText(answer_PL_MU_20);

                                        for(int elem: list_PL_MU_21) answer_PL_MU_21.append(elem).append("  ");
                                        Answer21.setText(answer_PL_MU_21);
                                    }
                                    break;

                                case 1:
                                    OneHeapTwoAnd_PL_PL_19 obj_PL_PL_19 = new OneHeapTwoAnd_PL_PL_19(
                                            Integer.parseInt(EditText1.getText().toString()),
                                            Integer.parseInt(EditText2.getText().toString()),
                                            Integer.parseInt(EditText4.getText().toString()));

                                    OneHeapTwo_PL_PL_20 obj_PL_PL_20 = new OneHeapTwo_PL_PL_20(
                                            Integer.parseInt(EditText1.getText().toString()),
                                            Integer.parseInt(EditText2.getText().toString()),
                                            Integer.parseInt(EditText4.getText().toString()));

                                    OneHeapTwo_PL_PL_21 obj_PL_PL_21 = new OneHeapTwo_PL_PL_21(
                                            Integer.parseInt(EditText1.getText().toString()),
                                            Integer.parseInt(EditText2.getText().toString()),
                                            Integer.parseInt(EditText4.getText().toString()));

                                    StringBuilder answer_PL_PL_20 = new StringBuilder();
                                    List<Integer> list_PL_PL_20 = (List<Integer>) obj_PL_PL_20.getResult();

                                    StringBuilder answer_PL_PL_21 = new StringBuilder();
                                    List<Integer> list_PL_PL_21 = (List<Integer>) obj_PL_PL_21.getResult();

                                    if (obj_PL_PL_19.getResult() == 0 || list_PL_PL_20.isEmpty() || list_PL_PL_21.isEmpty()) {
                                        LayoutErrorAnswer.setVisibility(View.VISIBLE);
                                        AnswerLayout.setVisibility(View.GONE);
                                    }
                                    else {
                                        Answer19.setText(Integer.toString(obj_PL_PL_19.getResult()));

                                        for(int elem: list_PL_PL_20) answer_PL_PL_20.append(elem).append("  ");
                                        Answer20.setText(answer_PL_PL_20);

                                        for(int elem: list_PL_PL_21) answer_PL_PL_21.append(elem).append("  ");
                                        Answer21.setText(answer_PL_PL_21);
                                    }

                                    break;

                                case 2:
                                    OneHeapTwoAnd_PL_MU_MU_19 obj_PL_MU_MU_19 = new OneHeapTwoAnd_PL_MU_MU_19(
                                            Integer.parseInt(EditText1.getText().toString()),
                                            Integer.parseInt(EditText2.getText().toString()),
                                            Integer.parseInt(EditText4.getText().toString()));

                                    OneHeapTwo_PL_MU_MU_20 obj_PL_MU_MU_20 = new OneHeapTwo_PL_MU_MU_20(
                                            Integer.parseInt(EditText1.getText().toString()),
                                            Integer.parseInt(EditText2.getText().toString()),
                                            Integer.parseInt(EditText4.getText().toString()));

                                    OneHeapTwo_PL_MU_MU_21 obj_PL_MU_MU_21 = new OneHeapTwo_PL_MU_MU_21(
                                            Integer.parseInt(EditText1.getText().toString()),
                                            Integer.parseInt(EditText2.getText().toString()),
                                            Integer.parseInt(EditText4.getText().toString()));

                                    StringBuilder answer_PL_MU_MU_20 = new StringBuilder();
                                    List<Integer> list_PL_MU_MU_20 = (List<Integer>) obj_PL_MU_MU_20.getResult();

                                    StringBuilder answer_PL_MU_MU_21 = new StringBuilder();
                                    List<Integer> list_PL_MU_MU_21 = (List<Integer>) obj_PL_MU_MU_21.getResult();

                                    if (obj_PL_MU_MU_19.getResult() == 0 || list_PL_MU_MU_20.isEmpty() || list_PL_MU_MU_21.isEmpty()) {
                                        LayoutErrorAnswer.setVisibility(View.VISIBLE);
                                        AnswerLayout.setVisibility(View.GONE);
                                    }
                                    else {
                                        Answer19.setText(Integer.toString(obj_PL_MU_MU_19.getResult()));

                                        for(int elem: list_PL_MU_MU_20) answer_PL_MU_MU_20.append(elem).append("  ");
                                        Answer20.setText(answer_PL_MU_MU_20);

                                        for(int elem: list_PL_MU_MU_21) answer_PL_MU_MU_21.append(elem).append("  ");
                                        Answer21.setText(answer_PL_MU_MU_21);
                                    }

                                    break;

                                case 3:
                                    OneHeapTwoAnd_PL_MU_MN_19 obj_PL_MU_MN_19 = new OneHeapTwoAnd_PL_MU_MN_19(
                                            Integer.parseInt(EditText1.getText().toString()),
                                            Integer.parseInt(EditText2.getText().toString()),
                                            Integer.parseInt(EditText3.getText().toString()),
                                            Integer.parseInt(EditText4.getText().toString()));

                                    OneHeapTwo_PL_MU_MN_20 obj_PL_MU_MN_20 = new OneHeapTwo_PL_MU_MN_20(
                                            Integer.parseInt(EditText1.getText().toString()),
                                            Integer.parseInt(EditText2.getText().toString()),
                                            Integer.parseInt(EditText3.getText().toString()),
                                            Integer.parseInt(EditText4.getText().toString()));

                                    OneHeapTwo_PL_MU_MN_21 obj_PL_MU_MN_21 = new OneHeapTwo_PL_MU_MN_21(
                                            Integer.parseInt(EditText1.getText().toString()),
                                            Integer.parseInt(EditText2.getText().toString()),
                                            Integer.parseInt(EditText3.getText().toString()),
                                            Integer.parseInt(EditText4.getText().toString()));

                                    StringBuilder answer_PL_MU_MN_20 = new StringBuilder();
                                    List<Integer> list_PL_MU_MN_20 = (List<Integer>) obj_PL_MU_MN_20.getResult();

                                    StringBuilder answer_PL_MU_MN_21 = new StringBuilder();
                                    List<Integer> list_PL_MU_MN_21 = (List<Integer>) obj_PL_MU_MN_21.getResult();

                                    if (obj_PL_MU_MN_19.getResult() == 0 || list_PL_MU_MN_20.isEmpty() || list_PL_MU_MN_21.isEmpty()) {
                                        LayoutErrorAnswer.setVisibility(View.VISIBLE);
                                        AnswerLayout.setVisibility(View.GONE);
                                    }
                                    else {
                                        Answer19.setText(Integer.toString(obj_PL_MU_MN_19.getResult()));

                                        for(int elem: list_PL_MU_MN_20) answer_PL_MU_MN_20.append(elem).append("  ");
                                        Answer20.setText(answer_PL_MU_MN_20);

                                        for(int elem: list_PL_MU_MN_21) answer_PL_MU_MN_21.append(elem).append("  ");
                                        Answer21.setText(answer_PL_MU_MN_21);
                                    }

                                    break;

                                case 4:
                                    OneHeapTwoAnd_PL_MU_PL_19 obj_PL_MU_PL_19 = new OneHeapTwoAnd_PL_MU_PL_19(
                                            Integer.parseInt(EditText1.getText().toString()),
                                            Integer.parseInt(EditText2.getText().toString()),
                                            Integer.parseInt(EditText3.getText().toString()),
                                            Integer.parseInt(EditText4.getText().toString()));

                                    OneHeapTwo_PL_MU_PL_20 obj_PL_MU_PL_20 = new OneHeapTwo_PL_MU_PL_20(
                                            Integer.parseInt(EditText1.getText().toString()),
                                            Integer.parseInt(EditText2.getText().toString()),
                                            Integer.parseInt(EditText3.getText().toString()),
                                            Integer.parseInt(EditText4.getText().toString()));

                                    OneHeapTwo_PL_MU_PL_21 obj_PL_MU_PL_21 = new OneHeapTwo_PL_MU_PL_21(
                                            Integer.parseInt(EditText1.getText().toString()),
                                            Integer.parseInt(EditText2.getText().toString()),
                                            Integer.parseInt(EditText3.getText().toString()),
                                            Integer.parseInt(EditText4.getText().toString()));

                                    StringBuilder answer_PL_MU_PL_20 = new StringBuilder();
                                    List<Integer> list_PL_MU_PL_20 = (List<Integer>) obj_PL_MU_PL_20.getResult();

                                    StringBuilder answer_PL_MU_PL_21 = new StringBuilder();
                                    List<Integer> list_PL_MU_PL_21 = (List<Integer>) obj_PL_MU_PL_21.getResult();

                                    if (obj_PL_MU_PL_19.getResult() == 0 || list_PL_MU_PL_20.isEmpty() || list_PL_MU_PL_21.isEmpty()) {
                                        LayoutErrorAnswer.setVisibility(View.VISIBLE);
                                        AnswerLayout.setVisibility(View.GONE);
                                    }
                                    else {
                                        Answer19.setText(Integer.toString(obj_PL_MU_PL_19.getResult()));

                                        for(int elem: list_PL_MU_PL_20) answer_PL_MU_PL_20.append(elem).append("  ");
                                        Answer20.setText(answer_PL_MU_PL_20);

                                        for(int elem: list_PL_MU_PL_21) answer_PL_MU_PL_21.append(elem).append("  ");
                                        Answer21.setText(answer_PL_MU_PL_21);
                                    }

                                    break;
                            }
                        }

                        if (flKoef3Button) {
                            getAnswerIsSelected = true;

                            Space2.setVisibility(View.GONE);
                            Space3.setVisibility(View.GONE);
                            ResultButton.setVisibility(View.GONE);
                            EditText1.setVisibility(View.GONE);
                            EditText2.setVisibility(View.GONE);
                            EditText3.setVisibility(View.GONE);
                            EditText4.setVisibility(View.GONE);
                            CountOfHeaps1.setVisibility(View.GONE);
                            LayoutCountOfKoef.setVisibility(View.GONE);
                            LayoutMove.setVisibility(View.GONE);
                            Space4.setVisibility(View.GONE);
                            Space5.setVisibility(View.GONE);
                            Space6.setVisibility(View.GONE);
                            Space7.setVisibility(View.VISIBLE);
                            LayoutWhichMove.setVisibility(View.GONE);
                            LayoutBranch3Koef.setVisibility(View.GONE);
                            AnswerLayout.setVisibility(View.VISIBLE);
                            BeginFromStartButton.setVisibility(View.VISIBLE);

                            if (flYesButton){
                                OneHeapThreeAnd19 obj_19 = new OneHeapThreeAnd19(
                                        Integer.parseInt(EditText1.getText().toString()),
                                        Integer.parseInt(EditText2.getText().toString()),
                                        Integer.parseInt(EditText3.getText().toString()),
                                        Integer.parseInt(EditText4.getText().toString()));

                                OneHeapThree20 obj_20 = new OneHeapThree20(
                                        Integer.parseInt(EditText1.getText().toString()),
                                        Integer.parseInt(EditText2.getText().toString()),
                                        Integer.parseInt(EditText3.getText().toString()),
                                        Integer.parseInt(EditText4.getText().toString()));

                                OneHeapThree21 obj_21 = new OneHeapThree21(
                                        Integer.parseInt(EditText1.getText().toString()),
                                        Integer.parseInt(EditText2.getText().toString()),
                                        Integer.parseInt(EditText3.getText().toString()),
                                        Integer.parseInt(EditText4.getText().toString()));

                                StringBuilder answer_20 = new StringBuilder();
                                List<Integer> list_20 = (List<Integer>) obj_20.getResult();

                                StringBuilder answer_21 = new StringBuilder();
                                List<Integer> list_21 = (List<Integer>) obj_21.getResult();

                                if (obj_19.getResult() == 0 || list_20.isEmpty() || list_21.isEmpty()) {
                                    LayoutErrorAnswer.setVisibility(View.VISIBLE);
                                    AnswerLayout.setVisibility(View.GONE);
                                }
                                else {
                                    Answer19.setText(Integer.toString(obj_19.getResult()));

                                    for(int elem: list_20) answer_20.append(elem).append("  ");
                                    Answer20.setText(answer_20);

                                    for(int elem: list_21) answer_21.append(elem).append("  ");
                                    Answer21.setText(answer_21);
                                }
                            }

                            if (flNoButton && flMyLastOne){
                                OneHeapThreeNoSameMe19 objNoSameMy_19 = new OneHeapThreeNoSameMe19(
                                        Integer.parseInt(EditText1.getText().toString()),
                                        Integer.parseInt(EditText2.getText().toString()),
                                        Integer.parseInt(EditText3.getText().toString()),
                                        Integer.parseInt(EditText4.getText().toString()));

                                OneHeapThreeNoSameMe20 objNoSameMy_20 = new OneHeapThreeNoSameMe20(
                                        Integer.parseInt(EditText1.getText().toString()),
                                        Integer.parseInt(EditText2.getText().toString()),
                                        Integer.parseInt(EditText3.getText().toString()),
                                        Integer.parseInt(EditText4.getText().toString()));

                                OneHeapThreeNoSameMe21 objNoSameMy_21 = new OneHeapThreeNoSameMe21(
                                        Integer.parseInt(EditText1.getText().toString()),
                                        Integer.parseInt(EditText2.getText().toString()),
                                        Integer.parseInt(EditText3.getText().toString()),
                                        Integer.parseInt(EditText4.getText().toString()));

                                StringBuilder answer_19 = new StringBuilder();
                                List<Integer> list_19 = (List<Integer>) objNoSameMy_19.getResult();

                                StringBuilder answer_20 = new StringBuilder();
                                List<Integer> list_20 = (List<Integer>) objNoSameMy_20.getResult();

                                StringBuilder answer_21 = new StringBuilder();
                                List<Integer> list_21 = (List<Integer>) objNoSameMy_21.getResult();

                                if (list_19.isEmpty() || list_20.isEmpty() || list_21.isEmpty()) {
                                    LayoutErrorAnswer.setVisibility(View.VISIBLE);
                                    AnswerLayout.setVisibility(View.GONE);
                                }
                                else {
                                    for(int elem: list_19) answer_19.append(elem).append("  ");
                                    Answer19.setText(answer_19);

                                    answer_20.append(list_20.get(0)).append("  ").append(list_20.get(list_20.size() - 1));
                                    Answer20.setText(answer_20);

                                    Pvos.setText("Максимальное значение S:");
                                    answer_21.append(list_21.get(list_21.size() - 1));
                                    Answer21.setText(answer_21);
                                }
                            }

                            if (flNoButton && flAnotherPlayer){
                                OneHeapThreeNoSame2Player19 objNoSameSecond_19 = new OneHeapThreeNoSame2Player19(
                                        Integer.parseInt(EditText1.getText().toString()),
                                        Integer.parseInt(EditText2.getText().toString()),
                                        Integer.parseInt(EditText3.getText().toString()),
                                        Integer.parseInt(EditText4.getText().toString()));

                                OneHeapThreeNoSame2Player20 objNoSameSecond_20 = new OneHeapThreeNoSame2Player20(
                                        Integer.parseInt(EditText1.getText().toString()),
                                        Integer.parseInt(EditText2.getText().toString()),
                                        Integer.parseInt(EditText3.getText().toString()),
                                        Integer.parseInt(EditText4.getText().toString()));

                                OneHeapThreeNoSame2Player21 objNoSameSecond_21 = new OneHeapThreeNoSame2Player21(
                                        Integer.parseInt(EditText1.getText().toString()),
                                        Integer.parseInt(EditText2.getText().toString()),
                                        Integer.parseInt(EditText3.getText().toString()),
                                        Integer.parseInt(EditText4.getText().toString()));

                                StringBuilder answer_19 = new StringBuilder();
                                List<Integer> list_19 = (List<Integer>) objNoSameSecond_19.getResult();

                                StringBuilder answer_20 = new StringBuilder();
                                List<Integer> list_20 = (List<Integer>) objNoSameSecond_20.getResult();

                                StringBuilder answer_21 = new StringBuilder();
                                List<Integer> list_21 = (List<Integer>) objNoSameSecond_21.getResult();

                                if (list_19.isEmpty() || list_20.isEmpty() || list_21.isEmpty()) {
                                    LayoutErrorAnswer.setVisibility(View.VISIBLE);
                                    AnswerLayout.setVisibility(View.GONE);
                                }
                                else {
                                    for(int elem: list_19) answer_19.append(elem).append("  ");
                                    Answer19.setText(answer_19);

                                    answer_20.append(list_20.get(0)).append("  ").append(list_20.get(list_20.size() - 1));
                                    Answer20.setText(answer_20);

                                    Pvos.setText("Минимальное значение S:");
                                    answer_21.append(list_21.get(0));
                                    Answer21.setText(answer_21);
                                }
                            }

                        }
                    }
                    if (flUnluckyMoveButton) {
                        if (flKoef2Button) {
                            getAnswerIsSelected = true;

                            ChooseAction.setVisibility(View.GONE);
                            Space1.setVisibility(View.GONE);
                            View1.setVisibility(View.GONE);
                            LayoutListView.setVisibility(View.GONE);
                            View2.setVisibility(View.GONE);
                            Space2.setVisibility(View.GONE);
                            EditText1.setVisibility(View.GONE);
                            EditText2.setVisibility(View.GONE);
                            EditText3.setVisibility(View.GONE);
                            EditText4.setVisibility(View.GONE);
                            Space3.setVisibility(View.GONE);
                            Space4.setVisibility(View.GONE);
                            Space5.setVisibility(View.GONE);
                            Space6.setVisibility(View.GONE);
                            Space7.setVisibility(View.VISIBLE);
                            CountOfHeaps1.setVisibility(View.GONE);
                            LayoutCountOfKoef.setVisibility(View.GONE);
                            LayoutBranch3Koef.setVisibility(View.GONE);
                            LayoutWhichMove.setVisibility(View.GONE);
                            LayoutMove.setVisibility(View.GONE);
                            ResultButton.setVisibility(View.GONE);
                            AnswerLayout.setVisibility(View.VISIBLE);
                            BeginFromStartButton.setVisibility(View.VISIBLE);

                            switch (index) {
                                case -1:
                                    LayoutErrorAnswer.setVisibility(View.VISIBLE);
                                    AnswerLayout.setVisibility(View.GONE);
                                    break;

                                case 0:
                                    OneHeapTwoOr_PL_MU_19 obj_PL_MU_19 = new OneHeapTwoOr_PL_MU_19(
                                            Integer.parseInt(EditText1.getText().toString()),
                                            Integer.parseInt(EditText2.getText().toString()),
                                            Integer.parseInt(EditText4.getText().toString()));

                                    OneHeapTwo_PL_MU_20 obj_PL_MU_20 = new OneHeapTwo_PL_MU_20(
                                            Integer.parseInt(EditText1.getText().toString()),
                                            Integer.parseInt(EditText2.getText().toString()),
                                            Integer.parseInt(EditText4.getText().toString()));

                                    OneHeapTwo_PL_MU_21 obj_PL_MU_21 = new OneHeapTwo_PL_MU_21(
                                            Integer.parseInt(EditText1.getText().toString()),
                                            Integer.parseInt(EditText2.getText().toString()),
                                            Integer.parseInt(EditText4.getText().toString()));

                                    StringBuilder answer_PL_MU_20 = new StringBuilder();
                                    List<Integer> list_PL_MU_20 = (List<Integer>) obj_PL_MU_20.getResult();

                                    StringBuilder answer_PL_MU_21 = new StringBuilder();
                                    List<Integer> list_PL_MU_21 = (List<Integer>) obj_PL_MU_21.getResult();

                                    if (obj_PL_MU_19.getResult() == 0 || list_PL_MU_20.isEmpty() || list_PL_MU_21.isEmpty()) {
                                        LayoutErrorAnswer.setVisibility(View.VISIBLE);
                                        AnswerLayout.setVisibility(View.GONE);
                                    }
                                    else {
                                        Answer19.setText(Integer.toString(obj_PL_MU_19.getResult()));

                                        for(int elem: list_PL_MU_20) answer_PL_MU_20.append(elem).append("  ");
                                        Answer20.setText(answer_PL_MU_20);

                                        for(int elem: list_PL_MU_21) answer_PL_MU_21.append(elem).append("  ");
                                        Answer21.setText(answer_PL_MU_21);
                                    }
                                    break;

                                case 1:
                                    OneHeapTwoOr_PL_PL_19 obj_PL_PL_19 = new OneHeapTwoOr_PL_PL_19(
                                            Integer.parseInt(EditText1.getText().toString()),
                                            Integer.parseInt(EditText2.getText().toString()),
                                            Integer.parseInt(EditText4.getText().toString()));

                                    OneHeapTwo_PL_PL_20 obj_PL_PL_20 = new OneHeapTwo_PL_PL_20(
                                            Integer.parseInt(EditText1.getText().toString()),
                                            Integer.parseInt(EditText2.getText().toString()),
                                            Integer.parseInt(EditText4.getText().toString()));

                                    OneHeapTwo_PL_PL_21 obj_PL_PL_21 = new OneHeapTwo_PL_PL_21(
                                            Integer.parseInt(EditText1.getText().toString()),
                                            Integer.parseInt(EditText2.getText().toString()),
                                            Integer.parseInt(EditText4.getText().toString()));

                                    StringBuilder answer_PL_PL_20 = new StringBuilder();
                                    List<Integer> list_PL_PL_20 = (List<Integer>) obj_PL_PL_20.getResult();

                                    StringBuilder answer_PL_PL_21 = new StringBuilder();
                                    List<Integer> list_PL_PL_21 = (List<Integer>) obj_PL_PL_21.getResult();

                                    if (obj_PL_PL_19.getResult() == 0 || list_PL_PL_20.isEmpty() || list_PL_PL_21.isEmpty()) {
                                        LayoutErrorAnswer.setVisibility(View.VISIBLE);
                                        AnswerLayout.setVisibility(View.GONE);
                                    }
                                    else {
                                        Answer19.setText(Integer.toString(obj_PL_PL_19.getResult()));

                                        for(int elem: list_PL_PL_20) answer_PL_PL_20.append(elem).append("  ");
                                        Answer20.setText(answer_PL_PL_20);

                                        for(int elem: list_PL_PL_21) answer_PL_PL_21.append(elem).append("  ");
                                        Answer21.setText(answer_PL_PL_21);
                                    }

                                    break;

                                case 2:
                                    OneHeapTwoOr_PL_MU_MU_19 obj_PL_MU_MU_19 = new OneHeapTwoOr_PL_MU_MU_19(
                                            Integer.parseInt(EditText1.getText().toString()),
                                            Integer.parseInt(EditText2.getText().toString()),
                                            Integer.parseInt(EditText4.getText().toString()));

                                    OneHeapTwo_PL_MU_MU_20 obj_PL_MU_MU_20 = new OneHeapTwo_PL_MU_MU_20(
                                            Integer.parseInt(EditText1.getText().toString()),
                                            Integer.parseInt(EditText2.getText().toString()),
                                            Integer.parseInt(EditText4.getText().toString()));

                                    OneHeapTwo_PL_MU_MU_21 obj_PL_MU_MU_21 = new OneHeapTwo_PL_MU_MU_21(
                                            Integer.parseInt(EditText1.getText().toString()),
                                            Integer.parseInt(EditText2.getText().toString()),
                                            Integer.parseInt(EditText4.getText().toString()));

                                    StringBuilder answer_PL_MU_MU_20 = new StringBuilder();
                                    List<Integer> list_PL_MU_MU_20 = (List<Integer>) obj_PL_MU_MU_20.getResult();

                                    StringBuilder answer_PL_MU_MU_21 = new StringBuilder();
                                    List<Integer> list_PL_MU_MU_21 = (List<Integer>) obj_PL_MU_MU_21.getResult();

                                    if (obj_PL_MU_MU_19.getResult() == 0 || list_PL_MU_MU_20.isEmpty() || list_PL_MU_MU_21.isEmpty()) {
                                        LayoutErrorAnswer.setVisibility(View.VISIBLE);
                                        AnswerLayout.setVisibility(View.GONE);
                                    }
                                    else {
                                        Answer19.setText(Integer.toString(obj_PL_MU_MU_19.getResult()));

                                        for(int elem: list_PL_MU_MU_20) answer_PL_MU_MU_20.append(elem).append("  ");
                                        Answer20.setText(answer_PL_MU_MU_20);

                                        for(int elem: list_PL_MU_MU_21) answer_PL_MU_MU_21.append(elem).append("  ");
                                        Answer21.setText(answer_PL_MU_MU_21);
                                    }

                                    break;

                                case 3:
                                    OneHeapTwoOr_PL_MU_MN_19 obj_PL_MU_MN_19 = new OneHeapTwoOr_PL_MU_MN_19(
                                            Integer.parseInt(EditText1.getText().toString()),
                                            Integer.parseInt(EditText2.getText().toString()),
                                            Integer.parseInt(EditText3.getText().toString()),
                                            Integer.parseInt(EditText4.getText().toString()));

                                    OneHeapTwo_PL_MU_MN_20 obj_PL_MU_MN_20 = new OneHeapTwo_PL_MU_MN_20(
                                            Integer.parseInt(EditText1.getText().toString()),
                                            Integer.parseInt(EditText2.getText().toString()),
                                            Integer.parseInt(EditText3.getText().toString()),
                                            Integer.parseInt(EditText4.getText().toString()));

                                    OneHeapTwo_PL_MU_MN_21 obj_PL_MU_MN_21 = new OneHeapTwo_PL_MU_MN_21(
                                            Integer.parseInt(EditText1.getText().toString()),
                                            Integer.parseInt(EditText2.getText().toString()),
                                            Integer.parseInt(EditText3.getText().toString()),
                                            Integer.parseInt(EditText4.getText().toString()));

                                    StringBuilder answer_PL_MU_MN_20 = new StringBuilder();
                                    List<Integer> list_PL_MU_MN_20 = (List<Integer>) obj_PL_MU_MN_20.getResult();

                                    StringBuilder answer_PL_MU_MN_21 = new StringBuilder();
                                    List<Integer> list_PL_MU_MN_21 = (List<Integer>) obj_PL_MU_MN_21.getResult();

                                    if (obj_PL_MU_MN_19.getResult() == 0 || list_PL_MU_MN_20.isEmpty() || list_PL_MU_MN_21.isEmpty()) {
                                        LayoutErrorAnswer.setVisibility(View.VISIBLE);
                                        AnswerLayout.setVisibility(View.GONE);
                                    }
                                    else {
                                        Answer19.setText(Integer.toString(obj_PL_MU_MN_19.getResult()));

                                        for(int elem: list_PL_MU_MN_20) answer_PL_MU_MN_20.append(elem).append("  ");
                                        Answer20.setText(answer_PL_MU_MN_20);

                                        for(int elem: list_PL_MU_MN_21) answer_PL_MU_MN_21.append(elem).append("  ");
                                        Answer21.setText(answer_PL_MU_MN_21);
                                    }

                                    break;

                                case 4:
                                    OneHeapTwoOr_PL_MU_PL_19 obj_PL_MU_PL_19 = new OneHeapTwoOr_PL_MU_PL_19(
                                            Integer.parseInt(EditText1.getText().toString()),
                                            Integer.parseInt(EditText2.getText().toString()),
                                            Integer.parseInt(EditText3.getText().toString()),
                                            Integer.parseInt(EditText4.getText().toString()));

                                    OneHeapTwo_PL_MU_PL_20 obj_PL_MU_PL_20 = new OneHeapTwo_PL_MU_PL_20(
                                            Integer.parseInt(EditText1.getText().toString()),
                                            Integer.parseInt(EditText2.getText().toString()),
                                            Integer.parseInt(EditText3.getText().toString()),
                                            Integer.parseInt(EditText4.getText().toString()));

                                    OneHeapTwo_PL_MU_PL_21 obj_PL_MU_PL_21 = new OneHeapTwo_PL_MU_PL_21(
                                            Integer.parseInt(EditText1.getText().toString()),
                                            Integer.parseInt(EditText2.getText().toString()),
                                            Integer.parseInt(EditText3.getText().toString()),
                                            Integer.parseInt(EditText4.getText().toString()));

                                    StringBuilder answer_PL_MU_PL_20 = new StringBuilder();
                                    List<Integer> list_PL_MU_PL_20 = (List<Integer>) obj_PL_MU_PL_20.getResult();

                                    StringBuilder answer_PL_MU_PL_21 = new StringBuilder();
                                    List<Integer> list_PL_MU_PL_21 = (List<Integer>) obj_PL_MU_PL_21.getResult();

                                    if (obj_PL_MU_PL_19.getResult() == 0 || list_PL_MU_PL_20.isEmpty() || list_PL_MU_PL_21.isEmpty()) {
                                        LayoutErrorAnswer.setVisibility(View.VISIBLE);
                                        AnswerLayout.setVisibility(View.GONE);
                                    }
                                    else {
                                        Answer19.setText(Integer.toString(obj_PL_MU_PL_19.getResult()));

                                        for(int elem: list_PL_MU_PL_20) answer_PL_MU_PL_20.append(elem).append("  ");
                                        Answer20.setText(answer_PL_MU_PL_20);

                                        for(int elem: list_PL_MU_PL_21) answer_PL_MU_PL_21.append(elem).append("  ");
                                        Answer21.setText(answer_PL_MU_PL_21);
                                    }

                                    break;
                            }
                        }
                        if (flKoef3Button) {
                            getAnswerIsSelected = true;

                            Space2.setVisibility(View.GONE);
                            Space3.setVisibility(View.GONE);
                            ResultButton.setVisibility(View.GONE);
                            EditText1.setVisibility(View.GONE);
                            EditText2.setVisibility(View.GONE);
                            EditText3.setVisibility(View.GONE);
                            EditText4.setVisibility(View.GONE);
                            CountOfHeaps1.setVisibility(View.GONE);
                            LayoutCountOfKoef.setVisibility(View.GONE);
                            LayoutMove.setVisibility(View.GONE);
                            Space4.setVisibility(View.GONE);
                            Space5.setVisibility(View.GONE);
                            Space6.setVisibility(View.GONE);
                            Space7.setVisibility(View.VISIBLE);
                            LayoutWhichMove.setVisibility(View.GONE);
                            LayoutBranch3Koef.setVisibility(View.GONE);
                            AnswerLayout.setVisibility(View.VISIBLE);
                            BeginFromStartButton.setVisibility(View.VISIBLE);

                            OneHeapThreeOr19 obj_19 = new OneHeapThreeOr19(
                                    Integer.parseInt(EditText1.getText().toString()),
                                    Integer.parseInt(EditText2.getText().toString()),
                                    Integer.parseInt(EditText3.getText().toString()),
                                    Integer.parseInt(EditText4.getText().toString()));

                            OneHeapThree20 obj_20 = new OneHeapThree20(
                                    Integer.parseInt(EditText1.getText().toString()),
                                    Integer.parseInt(EditText2.getText().toString()),
                                    Integer.parseInt(EditText3.getText().toString()),
                                    Integer.parseInt(EditText4.getText().toString()));

                            OneHeapThree21 obj_21 = new OneHeapThree21(
                                    Integer.parseInt(EditText1.getText().toString()),
                                    Integer.parseInt(EditText2.getText().toString()),
                                    Integer.parseInt(EditText3.getText().toString()),
                                    Integer.parseInt(EditText4.getText().toString()));

                            StringBuilder answer_20 = new StringBuilder();
                            List<Integer> list_20 = (List<Integer>) obj_20.getResult();

                            StringBuilder answer_21 = new StringBuilder();
                            List<Integer> list_21 = (List<Integer>) obj_21.getResult();

                            if (obj_19.getResult() == 0 || list_20.isEmpty() || list_21.isEmpty()) {
                                LayoutErrorAnswer.setVisibility(View.VISIBLE);
                                AnswerLayout.setVisibility(View.GONE);
                            }
                            else {
                                Answer19.setText(Integer.toString(obj_19.getResult()));

                                for(int elem: list_20) answer_20.append(elem).append("  ");
                                Answer20.setText(answer_20);

                                for(int elem: list_21) answer_21.append(elem).append("  ");
                                Answer21.setText(answer_21);
                            }
                        }
                    }
                }
                break;

            case R.id.beginFromStart:
                finish();
                startActivity(getIntent());
                break;
        }

        if (flKoef2Button && !getAnswerIsSelected) {
            ChooseAction.setVisibility(View.VISIBLE);
            Space1.setVisibility(View.VISIBLE);
            View1.setVisibility(View.VISIBLE);
            LayoutListView.setVisibility(View.VISIBLE);
            View2.setVisibility(View.VISIBLE);
            Space2.setVisibility(View.VISIBLE);
            LayoutEdT1.setVisibility(View.VISIBLE);
            LayoutEdT2.setVisibility(View.VISIBLE);
            LayoutEdT3.setVisibility(View.GONE);
            LayoutEdT4.setVisibility(View.VISIBLE);
            Space3.setVisibility(View.VISIBLE);

            EditText1.getText().clear();
            EditText2.getText().clear();
            EditText3.getText().clear();
            EditText4.getText().clear();
        }

        if (flKoef3Button && !getAnswerIsSelected) {
            ChooseAction.setVisibility(View.GONE);
            Space1.setVisibility(View.GONE);
            View1.setVisibility(View.GONE);
            LayoutListView.setVisibility(View.GONE);
            View2.setVisibility(View.GONE);
            Space2.setVisibility(View.GONE);
            LayoutEdT1.setVisibility(View.VISIBLE);
            LayoutEdT2.setVisibility(View.VISIBLE);
            LayoutEdT3.setVisibility(View.VISIBLE);
            LayoutEdT4.setVisibility(View.VISIBLE);
            Space3.setVisibility(View.VISIBLE);

            EditText1.getText().clear();
            EditText2.getText().clear();
            EditText3.getText().clear();
            EditText4.getText().clear();

            if (index != -1) {
                ListView.getChildAt(index).setBackgroundColor(Color.parseColor("#2a2a2a"));
                index = -1;
                somethingIsChecked = false;
            }
        }

        ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (somethingIsChecked) {
                    if (i == 3 || i == 4)
                        LayoutEdT3.setVisibility(View.VISIBLE);
                    else
                        LayoutEdT3.setVisibility(View.GONE);
                    ListView.getChildAt(index).setBackgroundColor(Color.parseColor("#2a2a2a"));
                    index = i;
                    view.setBackgroundColor(Color.parseColor("#323232"));
                }
                else {
                    if (i == 3 || i == 4)
                        LayoutEdT3.setVisibility(View.VISIBLE);
                    else
                        LayoutEdT3.setVisibility(View.GONE);
                    index = i;
                    view.setBackgroundColor(Color.parseColor("#323232"));
                    somethingIsChecked = true;
                }
            }
        });

    }
}
