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

import com.example.winningstrategy.Tasks.Task20.CountOfHeaps1.CountOfKoef2.OneHeapTwo_PL_MU_20;
import com.example.winningstrategy.Tasks.Task20.CountOfHeaps1.CountOfKoef2.OneHeapTwo_PL_MU_MN_20;
import com.example.winningstrategy.Tasks.Task20.CountOfHeaps1.CountOfKoef2.OneHeapTwo_PL_MU_MU_20;
import com.example.winningstrategy.Tasks.Task20.CountOfHeaps1.CountOfKoef2.OneHeapTwo_PL_MU_PL_20;
import com.example.winningstrategy.Tasks.Task20.CountOfHeaps1.CountOfKoef2.OneHeapTwo_PL_PL_20;
import com.example.winningstrategy.Tasks.Task20.CountOfHeaps1.CountOfKoef3.NoSame.OneHeapThreeNoSame2Player20;
import com.example.winningstrategy.Tasks.Task20.CountOfHeaps1.CountOfKoef3.NoSame.OneHeapThreeNoSameMe20;
import com.example.winningstrategy.Tasks.Task20.CountOfHeaps1.CountOfKoef3.OneHeapThree20;

import java.util.List;

public class Task20Activity extends AppCompatActivity implements View.OnClickListener {
    Button Koef2Button, Koef3Button, YesButton, NoButton, MyLastOneButton, AnotherPlayerButton,
            ResultButton, BeginFromStartButton;
    TextView ChooseAction, Answer, CountOfHeaps1, Pvos;
    View View1, View2;
    ListView ListView;
    Space Space1, Space2, Space3;
    LinearLayout LayoutListView, LayoutEdT1, LayoutEdT2, LayoutEdT3, LayoutEdT4, AnswerLayout,
            LayoutBranch3Koef, LayoutCountOfKoef, LayoutWhichMove;
    EditText EditText1, EditText2, EditText3, EditText4;

    int index = -1;
    boolean flKoef2Button, flKoef3Button, flYesButton, flNoButton, somethingIsChecked,
            getAnswerIsSelected, flMyLastOne,
            flAnotherPlayer, ERROR;
    final String[] arrayChooseAction = new String[]{"Добавить и умножить", "Добавить и добавить",
            "Добавить и возвести", "Добавить, умножить и вычесть", "Добавить, умножить и добавить"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task20);
        init();
    }

    @SuppressLint("CutPasteId")
    private void init(){
        Koef2Button = findViewById(R.id.koef2);
        Koef3Button = findViewById(R.id.koef3);
        YesButton = findViewById(R.id.yesButton);
        NoButton = findViewById(R.id.noButton);
        MyLastOneButton = findViewById(R.id.myMove);
        AnotherPlayerButton = findViewById(R.id.anotherPlayer);
        ResultButton = findViewById(R.id.resultButton);
        BeginFromStartButton = findViewById(R.id.beginFromStart);

        Koef2Button.setOnClickListener(this);
        Koef3Button.setOnClickListener(this);
        YesButton.setOnClickListener(this);
        NoButton.setOnClickListener(this);
        MyLastOneButton.setOnClickListener(this);
        AnotherPlayerButton.setOnClickListener(this);
        ResultButton.setOnClickListener(this);
        BeginFromStartButton.setOnClickListener(this);

        ChooseAction = findViewById(R.id.chooseAction);
        Answer = findViewById(R.id.answer);
        CountOfHeaps1 = findViewById(R.id.countOfHeaps1);
        Pvos = findViewById(R.id.pvos);

        View1 = findViewById(R.id.view1);
        View2 = findViewById(R.id.view2);

        ListView = findViewById(R.id.listView);

        Space1 = findViewById(R.id.space1);
        Space2 = findViewById(R.id.space2);
        Space3 = findViewById(R.id.space3);

        LayoutListView = findViewById(R.id.layoutListView);
        LayoutEdT1 = findViewById(R.id.layoutEdT1);
        LayoutEdT2 = findViewById(R.id.layoutEdT2);
        LayoutEdT3 = findViewById(R.id.layoutEdT3);
        LayoutEdT4 = findViewById(R.id.layoutEdT4);
        LayoutBranch3Koef = findViewById(R.id.layoutBranch3Koef);
        LayoutCountOfKoef = findViewById(R.id.layoutCountOfKoef);
        LayoutWhichMove = findViewById(R.id.whichMove);
        AnswerLayout = findViewById(R.id.answerLayout);

        EditText1 = findViewById(R.id.editText1);
        EditText2 = findViewById(R.id.editText2);
        EditText3 = findViewById(R.id.editText3);
        EditText4 = findViewById(R.id.editText4);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_white_text,
                R.id.list_content, arrayChooseAction);
        ListView.setAdapter(adapter);

        flKoef2Button = flKoef3Button = somethingIsChecked = flYesButton = flNoButton =
                getAnswerIsSelected = flMyLastOne = flAnotherPlayer = ERROR = false;
    }

    @SuppressLint({"UseCompatLoadingForDrawables", "NonConstantResourceId", "SetTextI18n"})
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.koef2:
                if (flKoef3Button) {
                    Koef3Button.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_task19));
                    flKoef3Button = false;
                }

                if (flNoButton || flYesButton) {
                    flNoButton = flYesButton = false;
                    NoButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_task19));
                    YesButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_task19));
                }

                Koef2Button.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_pressed_19));
                flKoef2Button = true;

                LayoutBranch3Koef.setVisibility(View.GONE);
                LayoutWhichMove.setVisibility(View.GONE);
                AnotherPlayerButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_task19));
                MyLastOneButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_task19));
                flMyLastOne = flAnotherPlayer = false;
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
                if ((!flKoef2Button && !flKoef3Button) ||
                        (flNoButton && !flMyLastOne && !flAnotherPlayer) ||
                        (!flNoButton && !flYesButton && flKoef3Button) ||
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
                    ResultButton.setVisibility(View.GONE);
                    Pvos.setVisibility(View.GONE);
                    LayoutCountOfKoef.setVisibility(View.GONE);
                    LayoutBranch3Koef.setVisibility(View.GONE);
                    LayoutWhichMove.setVisibility(View.GONE);
                    AnswerLayout.setVisibility(View.VISIBLE);
                    BeginFromStartButton.setVisibility(View.VISIBLE);

                    Answer.setText("Ошибка: неверный ввод данных");
                }
                else {
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
                        CountOfHeaps1.setVisibility(View.GONE);
                        LayoutCountOfKoef.setVisibility(View.GONE);
                        LayoutBranch3Koef.setVisibility(View.GONE);
                        LayoutWhichMove.setVisibility(View.GONE);
                        ResultButton.setVisibility(View.GONE);
                        AnswerLayout.setVisibility(View.VISIBLE);
                        BeginFromStartButton.setVisibility(View.VISIBLE);

                        switch (index) {
                            case -1:
                                Answer.setText("Ошибка: неверный ввод данных");
                                ERROR = true;
                                break;

                            case 0:
                                OneHeapTwo_PL_MU_20 obj_PL_MU = new OneHeapTwo_PL_MU_20(
                                        Integer.parseInt(EditText1.getText().toString()),
                                        Integer.parseInt(EditText2.getText().toString()),
                                        Integer.parseInt(EditText4.getText().toString()));

                                StringBuilder answer_PL_MU = new StringBuilder();
                                List<Integer> list_PL_MU = (List<Integer>) obj_PL_MU.getResult();

                                if (list_PL_MU.isEmpty()) {
                                    Answer.setText("Ошибка: неверный ввод данных");
                                    ERROR = true;
                                }
                                else {
                                    for(int elem: list_PL_MU) answer_PL_MU.append(elem).append("\n\n");
                                    Answer.setText(answer_PL_MU);
                                }
                                break;

                            case 1:
                                OneHeapTwo_PL_PL_20 obj_PL_PL = new OneHeapTwo_PL_PL_20(
                                        Integer.parseInt(EditText1.getText().toString()),
                                        Integer.parseInt(EditText2.getText().toString()),
                                        Integer.parseInt(EditText4.getText().toString()));

                                StringBuilder answer_PL_PL = new StringBuilder();
                                List<Integer> list_PL_PL = (List<Integer>) obj_PL_PL.getResult();

                                if (list_PL_PL.isEmpty()) {
                                    Answer.setText("Ошибка: неверный ввод данных");
                                    ERROR = true;
                                }
                                else {
                                    for(int elem: list_PL_PL) answer_PL_PL.append(elem).append("\n\n");
                                    Answer.setText(answer_PL_PL);
                                }
                                break;

                            case 2:
                                OneHeapTwo_PL_MU_MU_20 obj_PL_MU_MU = new OneHeapTwo_PL_MU_MU_20(
                                        Integer.parseInt(EditText1.getText().toString()),
                                        Integer.parseInt(EditText2.getText().toString()),
                                        Integer.parseInt(EditText4.getText().toString()));

                                StringBuilder answer_PL_MU_MU = new StringBuilder();
                                List<Integer> list_PL_MU_MU = (List<Integer>) obj_PL_MU_MU.getResult();

                                if (list_PL_MU_MU.isEmpty()) {
                                    Answer.setText("Ошибка: неверный ввод данных");
                                    ERROR = true;
                                }
                                else {
                                    for(int elem: list_PL_MU_MU) answer_PL_MU_MU.append(elem).append("\n\n");
                                    Answer.setText(answer_PL_MU_MU);
                                }
                                break;

                            case 3:
                                OneHeapTwo_PL_MU_MN_20 obj_PL_MU_MN = new OneHeapTwo_PL_MU_MN_20(
                                        Integer.parseInt(EditText1.getText().toString()),
                                        Integer.parseInt(EditText2.getText().toString()),
                                        Integer.parseInt(EditText3.getText().toString()),
                                        Integer.parseInt(EditText4.getText().toString()));

                                StringBuilder answer_PL_MU_MN = new StringBuilder();
                                List<Integer> list_PL_MU_MN = (List<Integer>) obj_PL_MU_MN.getResult();

                                if (list_PL_MU_MN.isEmpty()) {
                                    Answer.setText("Ошибка: неверный ввод данных");
                                    ERROR = true;
                                }
                                else {
                                    for(int elem: list_PL_MU_MN) answer_PL_MU_MN.append(elem).append("\n\n");
                                    Answer.setText(answer_PL_MU_MN);
                                }
                                break;

                            case 4:
                                OneHeapTwo_PL_MU_PL_20 obj_PL_MU_PL = new OneHeapTwo_PL_MU_PL_20(
                                        Integer.parseInt(EditText1.getText().toString()),
                                        Integer.parseInt(EditText2.getText().toString()),
                                        Integer.parseInt(EditText3.getText().toString()),
                                        Integer.parseInt(EditText4.getText().toString()));

                                StringBuilder answer_PL_MU_PL = new StringBuilder();
                                List<Integer> list_PL_MU_PL = (List<Integer>) obj_PL_MU_PL.getResult();

                                if (list_PL_MU_PL.isEmpty()) {
                                    Answer.setText("Ошибка: неверный ввод данных");
                                    ERROR = true;
                                }
                                else {
                                    for(int elem: list_PL_MU_PL) answer_PL_MU_PL.append(elem).append("\n\n");
                                    Answer.setText(answer_PL_MU_PL);
                                }
                                break;
                        }

                        if (ERROR)
                            Pvos.setVisibility(View.GONE);

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
                        LayoutBranch3Koef.setVisibility(View.GONE);
                        LayoutWhichMove.setVisibility(View.GONE);
                        AnswerLayout.setVisibility(View.VISIBLE);
                        BeginFromStartButton.setVisibility(View.VISIBLE);

                        if (flYesButton) {
                            OneHeapThree20 obj = new OneHeapThree20(
                                    Integer.parseInt(EditText1.getText().toString()),
                                    Integer.parseInt(EditText2.getText().toString()),
                                    Integer.parseInt(EditText3.getText().toString()),
                                    Integer.parseInt(EditText4.getText().toString()));

                            StringBuilder answer = new StringBuilder();
                            List<Integer> list = (List<Integer>) obj.getResult();

                            if (list.isEmpty()) {
                                Answer.setText("Ошибка: неверный ввод данных");
                                ERROR = true;
                            }
                            else {
                                for(int elem: list) answer.append(elem).append("\n\n");
                                Answer.setText(answer);
                            }

                            if (ERROR)
                                Pvos.setVisibility(View.GONE);
                        }
                        if (flNoButton) {
                            if (flMyLastOne){
                                OneHeapThreeNoSameMe20 objNoSameMy = new OneHeapThreeNoSameMe20(
                                        Integer.parseInt(EditText1.getText().toString()),
                                        Integer.parseInt(EditText2.getText().toString()),
                                        Integer.parseInt(EditText3.getText().toString()),
                                        Integer.parseInt(EditText4.getText().toString()));

                                StringBuilder answer = new StringBuilder();
                                List<Integer> list = (List<Integer>) objNoSameMy.getResult();

                                if (list.isEmpty()) {
                                    Answer.setText("Ошибка: неверный ввод данных");
                                    ERROR = true;
                                }
                                else {
                                    answer.append(list.get(0)).append("\n\n").append(list.get(list.size() - 1));
                                    Answer.setText(answer);
                                }
                            }

                            if (flAnotherPlayer){
                                OneHeapThreeNoSame2Player20 objNoSameSecond = new OneHeapThreeNoSame2Player20(
                                        Integer.parseInt(EditText1.getText().toString()),
                                        Integer.parseInt(EditText2.getText().toString()),
                                        Integer.parseInt(EditText3.getText().toString()),
                                        Integer.parseInt(EditText4.getText().toString()));

                                StringBuilder answer = new StringBuilder();
                                List<Integer> list = (List<Integer>) objNoSameSecond.getResult();

                                if (list.isEmpty()) {
                                    Answer.setText("Ошибка: неверный ввод данных");
                                    ERROR = true;
                                }
                                else {
                                    answer.append(list.get(0)).append("\n\n").append(list.get(list.size() - 1));
                                    Answer.setText(answer);
                                }
                            }

                            if (ERROR)
                                Pvos.setVisibility(View.GONE);
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