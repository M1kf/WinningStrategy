package com.example.winningstrategy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.winningstrategy.Tasks.Task21.CountOfHeaps1.CountOfKoef2.OneHeapTwo_PL_MU_21;
import com.example.winningstrategy.Tasks.Task21.CountOfHeaps1.CountOfKoef2.OneHeapTwo_PL_MU_MN_21;
import com.example.winningstrategy.Tasks.Task21.CountOfHeaps1.CountOfKoef2.OneHeapTwo_PL_MU_MU_21;
import com.example.winningstrategy.Tasks.Task21.CountOfHeaps1.CountOfKoef2.OneHeapTwo_PL_MU_PL_21;
import com.example.winningstrategy.Tasks.Task21.CountOfHeaps1.CountOfKoef2.OneHeapTwo_PL_PL_21;
import com.example.winningstrategy.Tasks.Task21.CountOfHeaps1.CountOfKoef3.NoSame.OneHeapThreeNoSame2Player21;
import com.example.winningstrategy.Tasks.Task21.CountOfHeaps1.CountOfKoef3.NoSame.OneHeapThreeNoSameMe21;
import com.example.winningstrategy.Tasks.Task21.CountOfHeaps1.CountOfKoef3.OneHeapThree21;

import java.util.List;

public class Task21Activity extends AppCompatActivity implements View.OnClickListener {
    Button Factor2Button, Factor3Button, YesButton, NoButton, MyLastOneButton, AnotherPlayerButton,
            ResultButton, BeginFromStartButton;
    TextView ChooseAction, Answer, CountOfHeaps1, PossibleValuesOfS;
    View Rectangle1, Rectangle2;
    ListView ListView;
    LinearLayout AnswerLayout, LayoutBranch3Factors, LayoutCountOfFactors, LayoutWhichMove;
    EditText StoneInputField1, StoneInputField2, FactorInputField, EnteredResult;

    int indexOfSelectedItem = -1;
    private int count2factors = 0;
    private int count3factors = 0;
    String saveStoneInputField1;
    String saveStoneInputField2;
    String saveFactorInputField;
    String saveEnteredResult;
    int saveIndexList;
    boolean flFactor2Button, flFactor3Button, flYesButton, flNoButton, flMyLastOne, flAnotherPlayer,
            somethingIsChecked, getAnswerIsSelected, saveLayout, ERROR;
    final String[] arrayChooseAction = new String[]{"Добавить или умножить", "Добавить или добавить",
            "Добавить или возвести", "Добавить или умножить и вычесть", "Добавить или умножить и добавить"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task21);

        Factor2Button = findViewById(R.id.koef2);
        Factor3Button = findViewById(R.id.koef3);
        YesButton = findViewById(R.id.yesButton);
        NoButton = findViewById(R.id.noButton);
        MyLastOneButton = findViewById(R.id.myMove);
        AnotherPlayerButton = findViewById(R.id.anotherPlayer);
        ResultButton = findViewById(R.id.resultButton);
        BeginFromStartButton = findViewById(R.id.beginFromStart);

        Factor2Button.setOnClickListener(this);
        Factor3Button.setOnClickListener(this);
        YesButton.setOnClickListener(this);
        NoButton.setOnClickListener(this);
        MyLastOneButton.setOnClickListener(this);
        AnotherPlayerButton.setOnClickListener(this);
        ResultButton.setOnClickListener(this);
        BeginFromStartButton.setOnClickListener(this);

        ChooseAction = findViewById(R.id.chooseAction);
        Answer = findViewById(R.id.answer);
        CountOfHeaps1 = findViewById(R.id.countOfHeaps1);
        PossibleValuesOfS = findViewById(R.id.possibleS);

        Rectangle1 = findViewById(R.id.view1);
        Rectangle2 = findViewById(R.id.view2);

        ListView = findViewById(R.id.listView);

        LayoutBranch3Factors = findViewById(R.id.layoutBranch3Koef);
        LayoutCountOfFactors = findViewById(R.id.layoutCountOfKoef);
        LayoutWhichMove = findViewById(R.id.whichMove);
        LayoutCountOfFactors = findViewById(R.id.layoutCountOfKoef);
        AnswerLayout = findViewById(R.id.answerLayout);

        StoneInputField1 = findViewById(R.id.editText1);
        StoneInputField2 = findViewById(R.id.editText2);
        FactorInputField = findViewById(R.id.editText3);
        EnteredResult = findViewById(R.id.editText4);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, arrayChooseAction) {

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view =super.getView(position, convertView, parent);

                TextView item = view.findViewById(android.R.id.text1);
                item.setGravity(Gravity.CENTER);
                item.setTextColor(Color.parseColor("#cdcdcd"));

                return view;
            }

        };

        ListView.setAdapter(adapter);

        flFactor2Button = flFactor3Button = somethingIsChecked = flYesButton = flNoButton =
                getAnswerIsSelected = saveLayout = flMyLastOne = flAnotherPlayer = ERROR = false;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.koef2:
                if (flFactor3Button) {
                    Factor3Button.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks, getBaseContext().getTheme()));
                    flFactor3Button = false;
                }

                if (flNoButton || flYesButton) {
                    flNoButton = flYesButton = false;
                    NoButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks, getBaseContext().getTheme()));
                    YesButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks, getBaseContext().getTheme()));
                }
                Factor2Button.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks_pressed, getBaseContext().getTheme()));
                flFactor2Button = true;

                count2factors++;
                ResultButton.setVisibility(View.VISIBLE);
                LayoutBranch3Factors.setVisibility(View.GONE);
                LayoutWhichMove.setVisibility(View.GONE);
                AnotherPlayerButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks, getBaseContext().getTheme()));
                MyLastOneButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks, getBaseContext().getTheme()));
                flMyLastOne = flAnotherPlayer = false;
                break;

            case R.id.koef3:
                if (flFactor2Button) {
                    Factor2Button.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks, getBaseContext().getTheme()));
                    flFactor2Button = false;
                }

                count3factors++;
                Factor3Button.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks_pressed, getBaseContext().getTheme()));
                flFactor3Button = true;
                ResultButton.setVisibility(View.VISIBLE);
                LayoutBranch3Factors.setVisibility(View.VISIBLE);
                break;

            case R.id.yesButton:
                if (flNoButton) {
                    NoButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks, getBaseContext().getTheme()));
                    flNoButton = false;
                }
                YesButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks_pressed, getBaseContext().getTheme()));
                flYesButton = true;

                LayoutWhichMove.setVisibility(View.GONE);
                AnotherPlayerButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks, getBaseContext().getTheme()));
                MyLastOneButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks, getBaseContext().getTheme()));
                flMyLastOne = flAnotherPlayer = false;
                break;

            case R.id.noButton:
                if (flYesButton) {
                    YesButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks, getBaseContext().getTheme()));
                    flYesButton = false;
                }
                NoButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks_pressed, getBaseContext().getTheme()));
                flNoButton = true;
                LayoutWhichMove.setVisibility(View.VISIBLE);
                break;

            case R.id.myMove:
                if (flAnotherPlayer) {
                    AnotherPlayerButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks, getBaseContext().getTheme()));
                    flAnotherPlayer = false;
                }
                MyLastOneButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks_pressed, getBaseContext().getTheme()));
                flMyLastOne = true;
                break;

            case R.id.anotherPlayer:
                if (flMyLastOne) {
                    MyLastOneButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks, getBaseContext().getTheme()));
                    flMyLastOne = false;
                }
                AnotherPlayerButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks_pressed, getBaseContext().getTheme()));
                flAnotherPlayer = true;
                break;

            case R.id.resultButton:

                saveStoneInputField1 = StoneInputField1.getText().toString();
                saveStoneInputField2 = StoneInputField2.getText().toString();
                saveFactorInputField = FactorInputField.getText().toString();
                saveEnteredResult = EnteredResult.getText().toString();

                saveIndexList = indexOfSelectedItem;

                if ((flFactor2Button && indexOfSelectedItem == -1) || (flNoButton && !flMyLastOne && !flAnotherPlayer) ||
                        (!flNoButton && !flYesButton && flFactor3Button) ||
                        (flFactor3Button && (StoneInputField1.getText().toString().isEmpty() ||
                                StoneInputField2.getText().toString().isEmpty() ||
                                FactorInputField.getText().toString().isEmpty() ||
                                EnteredResult.getText().toString().isEmpty())) ||
                        (flFactor2Button && (indexOfSelectedItem != 3 && indexOfSelectedItem != 4) && (StoneInputField1.getText().toString().isEmpty() ||
                                StoneInputField2.getText().toString().isEmpty() || EnteredResult.getText().toString().isEmpty())) ||
                        (flFactor2Button && (indexOfSelectedItem == 3 || indexOfSelectedItem == 4) && (StoneInputField1.getText().toString().isEmpty() ||
                                StoneInputField2.getText().toString().isEmpty() ||
                                FactorInputField.getText().toString().isEmpty() ||
                                EnteredResult.getText().toString().isEmpty())) ||
                        (StoneInputField1.getText().toString().length() > 4 ||
                                StoneInputField2.getText().toString().length() > 4 ||
                                FactorInputField.getText().toString().length() > 4 ||
                                EnteredResult.getText().toString().length() > 4)) {
                    if (indexOfSelectedItem == -1) {
                        Toast.makeText(this, "Не выбран вид операции", Toast.LENGTH_SHORT).show();
                        saveLayout = true;
                    }

                    int countEmpty = 0;

                    if (StoneInputField1.getText().toString().isEmpty())
                        countEmpty++;

                    if (StoneInputField2.getText().toString().isEmpty())
                        countEmpty++;

                    if (FactorInputField.getText().toString().isEmpty() && (flFactor3Button || indexOfSelectedItem == 3 || indexOfSelectedItem == 4))
                        countEmpty++;

                    if (EnteredResult.getText().toString().isEmpty())
                        countEmpty++;

                    if (countEmpty > 1) {
                        Toast.makeText(this, "Не введены коэффициенты", Toast.LENGTH_SHORT).show();
                        saveLayout = true;
                    }
                    else {
                        if (flFactor3Button && (StoneInputField1.getText().toString().isEmpty() ||
                                StoneInputField2.getText().toString().isEmpty() ||
                                FactorInputField.getText().toString().isEmpty() ||
                                EnteredResult.getText().toString().isEmpty())) {

                            if (StoneInputField1.getText().toString().isEmpty()) {
                                Toast.makeText(this, "Не указано количество добавляемых камней", Toast.LENGTH_SHORT).show();
                                saveLayout = true;
                            }

                            if (StoneInputField2.getText().toString().isEmpty()) {
                                Toast.makeText(this, "Не указано количество добавляемых камней", Toast.LENGTH_SHORT).show();
                                saveLayout = true;
                            }

                            if (FactorInputField.getText().toString().isEmpty()) {
                                Toast.makeText(this, "Не указан коэффициент умножения", Toast.LENGTH_SHORT).show();
                                saveLayout = true;
                            }

                            if (EnteredResult.getText().toString().isEmpty()) {
                                Toast.makeText(this, "Не указано число выигрыша", Toast.LENGTH_SHORT).show();
                                saveLayout = true;
                            }
                        }

                        switch (indexOfSelectedItem) {
                            case 0:
                                if (StoneInputField1.getText().toString().isEmpty()) {
                                    Toast.makeText(this, "Не указано количество добавляемых камней", Toast.LENGTH_SHORT).show();
                                    saveLayout = true;
                                }

                                if (StoneInputField2.getText().toString().isEmpty()) {
                                    Toast.makeText(this, "Не указан коэффициент умножения", Toast.LENGTH_SHORT).show();
                                    saveLayout = true;
                                }

                                if  (EnteredResult.getText().toString().isEmpty()) {
                                    Toast.makeText(this, "Не указано число выигрыша", Toast.LENGTH_SHORT).show();
                                    saveLayout = true;
                                }

                                break;

                            case 1:
                                if (StoneInputField1.getText().toString().isEmpty()) {
                                    Toast.makeText(this, "Не указано количество добавляемых камней", Toast.LENGTH_SHORT).show();
                                    saveLayout = true;
                                }

                                if (StoneInputField2.getText().toString().isEmpty()) {
                                    Toast.makeText(this, "Не указано количество добавляемых камней", Toast.LENGTH_SHORT).show();
                                    saveLayout = true;
                                }

                                if  (EnteredResult.getText().toString().isEmpty()) {

                                    Toast.makeText(this, "Не указано число выигрыша", Toast.LENGTH_SHORT).show();
                                    saveLayout = true;
                                }
                                break;

                            case 2:
                                if (StoneInputField1.getText().toString().isEmpty()) {
                                    Toast.makeText(this, "Не указано количество добавляемых камней", Toast.LENGTH_SHORT).show();
                                    saveLayout = true;
                                }

                                if (StoneInputField2.getText().toString().isEmpty()) {
                                    Toast.makeText(this, "Не указан коэффициент возведения", Toast.LENGTH_SHORT).show();
                                    saveLayout = true;
                                }

                                if  (EnteredResult.getText().toString().isEmpty()) {
                                    Toast.makeText(this, "Не указано число выигрыша", Toast.LENGTH_SHORT).show();
                                    saveLayout = true;
                                }
                                break;

                            case 3:
                                if (StoneInputField1.getText().toString().isEmpty()) {
                                    Toast.makeText(this, "Не указано количество добавляемых камней", Toast.LENGTH_SHORT).show();
                                    saveLayout = true;
                                }

                                if (StoneInputField2.getText().toString().isEmpty()) {
                                    Toast.makeText(this, "Не указан коэффициент умножения", Toast.LENGTH_SHORT).show();
                                    saveLayout = true;
                                }

                                if (FactorInputField.getText().toString().isEmpty()) {
                                    Toast.makeText(this, "Не указано количество вычитаемых камней", Toast.LENGTH_SHORT).show();
                                    saveLayout = true;
                                }

                                if  (EnteredResult.getText().toString().isEmpty()) {
                                    Toast.makeText(this, "Не указано число выигрыша", Toast.LENGTH_SHORT).show();
                                    saveLayout = true;
                                }

                                break;

                            case 4:
                                if (StoneInputField1.getText().toString().isEmpty()) {
                                    Toast.makeText(this, "Не указано количество добавляемых камней", Toast.LENGTH_SHORT).show();
                                    saveLayout = true;
                                }

                                if (StoneInputField2.getText().toString().isEmpty()) {
                                    Toast.makeText(this, "Не указан коэффициент умножения", Toast.LENGTH_SHORT).show();
                                    saveLayout = true;
                                }

                                if (FactorInputField.getText().toString().isEmpty()) {
                                    Toast.makeText(this, "Не указано количество добавляемых камней", Toast.LENGTH_SHORT).show();
                                    saveLayout = true;
                                }

                                if  (EnteredResult.getText().toString().isEmpty()) {
                                    Toast.makeText(this, "Не указано число выигрыша", Toast.LENGTH_SHORT).show();
                                    saveLayout = true;
                                }

                                break;
                        }
                    }

                    if (flFactor3Button && !flYesButton && !flNoButton) {
                        Toast.makeText(this, "Не выбрано условие повторения хода", Toast.LENGTH_SHORT).show();
                        saveLayout = true;
                    }

                    if (flNoButton && !flMyLastOne && !flAnotherPlayer) {
                        Toast.makeText(this, "Не выбрано чей ход нельзя повторять", Toast.LENGTH_SHORT).show();
                        saveLayout = true;
                    }

                    int countLength = 0;

                    if (StoneInputField1.getText().toString().length() > 4)
                        countLength++;

                    if (StoneInputField2.getText().toString().length() > 4)
                        countLength++;

                    if (FactorInputField.getText().toString().length() > 4)
                        countLength++;

                    if (EnteredResult.getText().toString().length() > 4)
                        countLength++;

                    if (countLength > 1) {
                        Toast.makeText(this, "Коэффициенты превышают допустимую длину", Toast.LENGTH_SHORT).show();
                        saveLayout = true;
                    }
                    else {
                        if (StoneInputField1.getText().toString().length() > 4 ||
                                StoneInputField2.getText().toString().length() > 4 ||
                                FactorInputField.getText().toString().length() > 4 ||
                                EnteredResult.getText().toString().length() > 4) {

                            if (StoneInputField1.getText().toString().length() > 4) {
                                Toast.makeText(this, "Количество добавляемых камней превышает допустимое", Toast.LENGTH_SHORT).show();
                                saveLayout = true;
                            }

                            if (StoneInputField2.getText().toString().length() > 4) {
                                Toast.makeText(this, "Количество добавляемых камней превышает допустимое", Toast.LENGTH_SHORT).show();
                                saveLayout = true;
                            }

                            if (FactorInputField.getText().toString().length() > 4) {
                                Toast.makeText(this, "Коэффициент умножения превышает допустимое значение", Toast.LENGTH_SHORT).show();
                                saveLayout = true;
                            }

                            if (EnteredResult.getText().toString().length() > 4) {
                                Toast.makeText(this, "Число выигрыша превышает допустимое", Toast.LENGTH_SHORT).show();
                                saveLayout = true;
                            }
                        }

                        switch (indexOfSelectedItem) {
                            case 0:
                                if (StoneInputField1.getText().toString().length() > 4) {
                                    Toast.makeText(this, "Количество добавляемых камней превышает допустимое", Toast.LENGTH_SHORT).show();
                                    saveLayout = true;
                                }

                                if (StoneInputField2.getText().toString().length() > 4) {
                                    Toast.makeText(this, "Коэффициент умножения превышает допустимое значение", Toast.LENGTH_SHORT).show();
                                    saveLayout = true;
                                }

                                if  (EnteredResult.getText().toString().length() > 4) {
                                    Toast.makeText(this, "Число выигрыша превышает допустимое", Toast.LENGTH_SHORT).show();
                                    saveLayout = true;
                                }

                                break;

                            case 1:
                                if (StoneInputField1.getText().toString().length() > 4) {
                                    Toast.makeText(this, "Количество добавляемых камней превышает допустимое", Toast.LENGTH_SHORT).show();
                                    saveLayout = true;
                                }

                                if (StoneInputField2.getText().toString().length() > 4) {
                                    Toast.makeText(this, "Количество добавляемых камней превышает допустимое", Toast.LENGTH_SHORT).show();
                                    saveLayout = true;
                                }

                                if  (EnteredResult.getText().toString().length() > 4) {
                                    Toast.makeText(this, "Число выигрыша превышает допустимое", Toast.LENGTH_SHORT).show();
                                    saveLayout = true;
                                }
                                break;

                            case 2:
                                if (StoneInputField1.getText().toString().length() > 4) {
                                    Toast.makeText(this, "Количество добавляемых камней превышает допустимое", Toast.LENGTH_SHORT).show();
                                    saveLayout = true;
                                }

                                if (StoneInputField2.getText().toString().length() > 1) {
                                    Toast.makeText(this, "Коэффициент возведения превышает допустимое значение", Toast.LENGTH_SHORT).show();
                                    saveLayout = true;
                                }

                                if  (EnteredResult.getText().toString().length() > 4) {
                                    Toast.makeText(this, "Число выигрыша превышает допустимое", Toast.LENGTH_SHORT).show();
                                    saveLayout = true;
                                }
                                break;

                            case 3:
                                if (StoneInputField1.getText().toString().length() > 4) {
                                    Toast.makeText(this, "Количество добавляемых камней превышает допустимое", Toast.LENGTH_SHORT).show();
                                    saveLayout = true;
                                }

                                if (StoneInputField2.getText().toString().length() > 4) {
                                    Toast.makeText(this, "Коэффициент умножения превышает допустимое значение", Toast.LENGTH_SHORT).show();
                                    saveLayout = true;
                                }

                                if (FactorInputField.getText().toString().length() > 4) {
                                    Toast.makeText(this, "Количество вычитаемых камней превышает допустимое", Toast.LENGTH_SHORT).show();
                                    saveLayout = true;
                                }

                                if  (EnteredResult.getText().toString().length() > 4) {
                                    Toast.makeText(this, "Число выигрыша превышает допустимое", Toast.LENGTH_SHORT).show();
                                    saveLayout = true;
                                }

                                break;

                            case 4:
                                if (StoneInputField1.getText().toString().length() > 4) {
                                    Toast.makeText(this, "Количество добавляемых камней превышает допустимое", Toast.LENGTH_SHORT).show();
                                    saveLayout = true;
                                }

                                if (StoneInputField2.getText().toString().length() > 4) {
                                    Toast.makeText(this, "Коэффициент умножения превышает допустимое значение", Toast.LENGTH_SHORT).show();
                                    saveLayout = true;
                                }

                                if (FactorInputField.getText().toString().length() > 4) {
                                    Toast.makeText(this, "Количество добавляемых камней превышает допустимое", Toast.LENGTH_SHORT).show();
                                    saveLayout = true;
                                }

                                if  (EnteredResult.getText().toString().length() > 4) {
                                    Toast.makeText(this, "Число выигрыша превышает допустимое", Toast.LENGTH_SHORT).show();
                                    saveLayout = true;
                                }

                                break;
                        }
                    }
                }
                else {
                    final String errorText = "Ошибка: неверно введены данные";
                    if (flFactor2Button) {
                        switch (indexOfSelectedItem) {
                            case 0:
                                OneHeapTwo_PL_MU_21 obj_PL_MU = new OneHeapTwo_PL_MU_21(
                                        Integer.parseInt(StoneInputField1.getText().toString()),
                                        Integer.parseInt(StoneInputField2.getText().toString()),
                                        Integer.parseInt(EnteredResult.getText().toString()));

                                StringBuilder answer_PL_MU = new StringBuilder();
                                List<Integer> list_PL_MU = obj_PL_MU.getResult();

                                if (list_PL_MU.isEmpty())
                                    ERROR = true;
                                else {
                                    for(int elem: list_PL_MU) answer_PL_MU.append(elem).append("\n\n");
                                    Answer.setText(answer_PL_MU);
                                }
                                break;

                            case 1:
                                OneHeapTwo_PL_PL_21 obj_PL_PL = new OneHeapTwo_PL_PL_21(
                                        Integer.parseInt(StoneInputField1.getText().toString()),
                                        Integer.parseInt(StoneInputField2.getText().toString()),
                                        Integer.parseInt(EnteredResult.getText().toString()));

                                StringBuilder answer_PL_PL = new StringBuilder();
                                List<Integer> list_PL_PL = obj_PL_PL.getResult();

                                if (list_PL_PL.isEmpty())
                                    ERROR = true;
                                else {
                                    for(int elem: list_PL_PL) answer_PL_PL.append(elem).append("\n\n");
                                    Answer.setText(answer_PL_PL);
                                }
                                break;

                            case 2:
                                OneHeapTwo_PL_MU_MU_21 obj_PL_MU_MU = new OneHeapTwo_PL_MU_MU_21(
                                        Integer.parseInt(StoneInputField1.getText().toString()),
                                        Integer.parseInt(StoneInputField2.getText().toString()),
                                        Integer.parseInt(EnteredResult.getText().toString()));

                                StringBuilder answer_PL_MU_MU = new StringBuilder();
                                List<Integer> list_PL_MU_MU = obj_PL_MU_MU.getResult();

                                if (list_PL_MU_MU.isEmpty())
                                    ERROR = true;
                                else {
                                    for(int elem: list_PL_MU_MU) answer_PL_MU_MU.append(elem).append("\n\n");
                                    Answer.setText(answer_PL_MU_MU);
                                }
                                break;

                            case 3:
                                OneHeapTwo_PL_MU_MN_21 obj_PL_MU_MN = new OneHeapTwo_PL_MU_MN_21(
                                        Integer.parseInt(StoneInputField1.getText().toString()),
                                        Integer.parseInt(StoneInputField2.getText().toString()),
                                        Integer.parseInt(FactorInputField.getText().toString()),
                                        Integer.parseInt(EnteredResult.getText().toString()));

                                StringBuilder answer_PL_MU_MN = new StringBuilder();
                                List<Integer> list_PL_MU_MN = obj_PL_MU_MN.getResult();

                                if (list_PL_MU_MN.isEmpty())
                                    ERROR = true;
                                else {
                                    for(int elem: list_PL_MU_MN) answer_PL_MU_MN.append(elem).append("\n\n");
                                    Answer.setText(answer_PL_MU_MN);
                                }
                                break;

                            case 4:
                                OneHeapTwo_PL_MU_PL_21 obj_PL_MU_PL = new OneHeapTwo_PL_MU_PL_21(
                                        Integer.parseInt(StoneInputField1.getText().toString()),
                                        Integer.parseInt(StoneInputField2.getText().toString()),
                                        Integer.parseInt(FactorInputField.getText().toString()),
                                        Integer.parseInt(EnteredResult.getText().toString()));

                                StringBuilder answer_PL_MU_PL = new StringBuilder();
                                List<Integer> list_PL_MU_PL = obj_PL_MU_PL.getResult();

                                if (list_PL_MU_PL.isEmpty())
                                    ERROR = true;
                                else {
                                    for(int elem: list_PL_MU_PL) answer_PL_MU_PL.append(elem).append("\n\n");
                                    Answer.setText(answer_PL_MU_PL);
                                }
                                break;
                        }

                        if (ERROR) {
                            Toast.makeText(this, errorText, Toast.LENGTH_SHORT).show();
                            saveLayout = true;
                            ERROR = false;
                        }
                        else {
                            getAnswerIsSelected = true;

                            ChooseAction.setVisibility(View.GONE);
                            Rectangle1.setVisibility(View.GONE);
                            ListView.setVisibility(View.GONE);
                            Rectangle2.setVisibility(View.GONE);
                            StoneInputField1.setVisibility(View.GONE);
                            StoneInputField2.setVisibility(View.GONE);
                            FactorInputField.setVisibility(View.GONE);
                            EnteredResult.setVisibility(View.GONE);
                            CountOfHeaps1.setVisibility(View.GONE);
                            LayoutCountOfFactors.setVisibility(View.GONE);
                            LayoutBranch3Factors.setVisibility(View.GONE);
                            LayoutWhichMove.setVisibility(View.GONE);
                            ResultButton.setVisibility(View.GONE);
                            AnswerLayout.setVisibility(View.VISIBLE);
                            BeginFromStartButton.setVisibility(View.VISIBLE);
                        }
                    }

                    if (flFactor3Button) {
                        if (flYesButton) {
                            OneHeapThree21 obj = new OneHeapThree21(
                                    Integer.parseInt(StoneInputField1.getText().toString()),
                                    Integer.parseInt(StoneInputField2.getText().toString()),
                                    Integer.parseInt(FactorInputField.getText().toString()),
                                    Integer.parseInt(EnteredResult.getText().toString()));

                            StringBuilder answer = new StringBuilder();
                            List<Integer> list = obj.getResult();

                            if (list.isEmpty())
                                ERROR = true;
                            else {
                                for(int elem: list) answer.append(elem).append("\n\n");
                                Answer.setText(answer);
                            }
                        }

                        if (flNoButton) {
                            if (flMyLastOne){
                                OneHeapThreeNoSameMe21 objNoSameMy = new OneHeapThreeNoSameMe21(
                                        Integer.parseInt(StoneInputField1.getText().toString()),
                                        Integer.parseInt(StoneInputField2.getText().toString()),
                                        Integer.parseInt(FactorInputField.getText().toString()),
                                        Integer.parseInt(EnteredResult.getText().toString()));

                                StringBuilder answer = new StringBuilder();
                                List<Integer> list = objNoSameMy.getResult();

                                if (list.isEmpty())
                                    ERROR = true;
                                else {
                                    PossibleValuesOfS.setText("Максимальное значение S:");
                                    answer.append(list.get(list.size() - 1));
                                    Answer.setText(answer);
                                }
                            }

                            if (flAnotherPlayer){
                                OneHeapThreeNoSame2Player21 objNoSameSecond = new OneHeapThreeNoSame2Player21(
                                        Integer.parseInt(StoneInputField1.getText().toString()),
                                        Integer.parseInt(StoneInputField2.getText().toString()),
                                        Integer.parseInt(FactorInputField.getText().toString()),
                                        Integer.parseInt(EnteredResult.getText().toString()));

                                StringBuilder answer = new StringBuilder();
                                List<Integer> list = objNoSameSecond.getResult();

                                if (list.isEmpty())
                                    ERROR = true;
                                else {
                                    PossibleValuesOfS.setText("Минимальное значение S:");
                                    answer.append(list.get(0));
                                    Answer.setText(answer);
                                }
                            }
                        }

                        if (ERROR) {
                            Toast.makeText(this, errorText, Toast.LENGTH_SHORT).show();
                            saveLayout = true;
                            ERROR = false;
                        }
                        else {
                            getAnswerIsSelected = true;

                            ResultButton.setVisibility(View.GONE);
                            StoneInputField1.setVisibility(View.GONE);
                            StoneInputField2.setVisibility(View.GONE);
                            FactorInputField.setVisibility(View.GONE);
                            EnteredResult.setVisibility(View.GONE);
                            CountOfHeaps1.setVisibility(View.GONE);
                            LayoutCountOfFactors.setVisibility(View.GONE);
                            LayoutBranch3Factors.setVisibility(View.GONE);
                            LayoutWhichMove.setVisibility(View.GONE);
                            AnswerLayout.setVisibility(View.VISIBLE);
                            BeginFromStartButton.setVisibility(View.VISIBLE);
                        }
                    }
                }
                break;

            case R.id.beginFromStart:
                finish();
                startActivity(getIntent());
                break;
        }

        if (flFactor2Button && !getAnswerIsSelected) {
            ChooseAction.setVisibility(View.VISIBLE);
            Rectangle1.setVisibility(View.VISIBLE);
            ListView.setVisibility(View.VISIBLE);
            Rectangle2.setVisibility(View.VISIBLE);
            StoneInputField1.setVisibility(View.VISIBLE);
            StoneInputField2.setVisibility(View.VISIBLE);
            FactorInputField.setVisibility(View.GONE);
            EnteredResult.setVisibility(View.VISIBLE);

            if (count2factors == 1 && count3factors > 0) {
                StoneInputField1.getText().clear();
                StoneInputField2.getText().clear();
                FactorInputField.getText().clear();
                EnteredResult.getText().clear();

                count3factors = 0;
            }
        }

        if (flFactor3Button && !getAnswerIsSelected) {
            ChooseAction.setVisibility(View.GONE);
            Rectangle1.setVisibility(View.GONE);
            ListView.setVisibility(View.GONE);
            Rectangle2.setVisibility(View.GONE);
            StoneInputField1.setVisibility(View.VISIBLE);
            StoneInputField2.setVisibility(View.VISIBLE);
            FactorInputField.setVisibility(View.VISIBLE);
            EnteredResult.setVisibility(View.VISIBLE);

            if (count3factors == 1 && count2factors > 0) {
                StoneInputField1.setHint("Введите количество добавляемых камней");
                StoneInputField2.setHint("Введите количество добавляемых камней");
                FactorInputField.setHint("Введите коэффициент умножения");


                StoneInputField1.getText().clear();
                StoneInputField2.getText().clear();
                FactorInputField.getText().clear();
                EnteredResult.getText().clear();

                count2factors = 0;
            }

            if (indexOfSelectedItem != -1) {
                ListView.getChildAt(indexOfSelectedItem).setBackgroundColor(Color.parseColor("#2a2a2a"));
                indexOfSelectedItem = -1;
                somethingIsChecked = false;
            }
        }

        if (saveLayout) {
            StoneInputField1.setText(saveStoneInputField1);
            StoneInputField2.setText(saveStoneInputField2);
            FactorInputField.setText(saveFactorInputField);
            EnteredResult.setText(saveEnteredResult);

            StoneInputField1.setSelection(StoneInputField1.getText().toString().length());
            StoneInputField2.setSelection(StoneInputField2.getText().toString().length());
            FactorInputField.setSelection(FactorInputField.getText().toString().length());
            EnteredResult.setSelection(EnteredResult.getText().toString().length());

            ListView.setSelection(saveIndexList);

            switch (saveIndexList) {
                case 0:
                    StoneInputField2.setHint("Введите коэффициент умножения");
                    FactorInputField.setVisibility(View.GONE);
                    break;

                case 1:
                    StoneInputField2.setHint("Введите количество добавляемых камней");
                    FactorInputField.setVisibility(View.GONE);
                    break;

                case 2:
                    StoneInputField2.setHint("Введите коэффициент возведения");
                    FactorInputField.setVisibility(View.GONE);
                    break;

                case 3:
                    StoneInputField2.setHint("Введите коэффициент умножения");
                    FactorInputField.setHint("Введите количество вычитаемых камней");
                    FactorInputField.setVisibility(View.VISIBLE);
                    break;

                case 4:
                    StoneInputField2.setHint("Введите коэффициент умножения");
                    FactorInputField.setHint("Введите количество добавляемых камней");
                    FactorInputField.setVisibility(View.VISIBLE);
                    break;
            }

            saveLayout = false;
        }

        ListView.setOnItemClickListener((adapterView, view1, i, l) -> {
            if (somethingIsChecked) {
                if (i == 3 || i == 4)
                    FactorInputField.setVisibility(View.VISIBLE);
                else
                    FactorInputField.setVisibility(View.GONE);
                ListView.getChildAt(indexOfSelectedItem).setBackgroundColor(Color.parseColor("#2a2a2a"));
                indexOfSelectedItem = i;
                view1.setBackgroundColor(Color.parseColor("#323232"));
            }
            else {
                if (i == 3 || i == 4)
                    FactorInputField.setVisibility(View.VISIBLE);
                else
                    FactorInputField.setVisibility(View.GONE);
                indexOfSelectedItem = i;
                view1.setBackgroundColor(Color.parseColor("#323232"));
                somethingIsChecked = true;
            }

            switch (i) {
                case 0:
                    StoneInputField2.setHint("Введите коэффициент умножения");
                    break;

                case 1:
                    StoneInputField2.setHint("Введите количество добавляемых камней");
                    break;

                case 2:
                    StoneInputField2.setHint("Введите коэффициент возведения");
                    break;

                case 3:
                    StoneInputField2.setHint("Введите коэффициент умножения");
                    FactorInputField.setHint("Введите количество вычитаемых камней");
                    break;

                case 4:
                    StoneInputField2.setHint("Введите коэффициент умножения");
                    FactorInputField.setHint("Введите количество добавляемых камней");
                    break;
            }
        });
    }
}