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
import java.util.Locale;

public class ComplexTask extends AppCompatActivity implements View.OnClickListener {
    Button anyMoveButton, unluckyMoveButton, factor2Button, factor3Button, yesButton, noButton,
            myLastOneButton, anotherPlayerButton, resultButton, beginFromStartButton;
    TextView chooseAction, answerTask19, answerTask20, answerTask21, countOfHeaps1, possibleValuesOfS;
    View rectangle1, rectangle2;
    ListView listView;
    LinearLayout layoutCountOfFactors, layoutMove, answerLayout, layoutBranch3Factors, layoutWhichMove;
    EditText stoneInputField1, stoneInputField2, factorInputField, enteredResult;

    int indexOfSelectedItem = -1;
    int saveIndexOfButton = -1;
    private int count2factorsTapped = 0;
    private int count3factorsTapped = 0;
    String saveStoneInputField1;
    String saveStoneInputField2;
    String saveFactorInputField;
    String saveEnteredResult;
    int saveIndexList;
    boolean flAnyMoveButton, flUnluckyMoveButton, flFactor2Button, flFactor3Button, flYesButton,
            flNoButton, somethingIsChecked, getAnswerWasTapped, noWasPressed, flMyLastOne,
            flAnotherPlayer, ERROR;
    final String[] arrayChooseAction = new String[]{"Добавить или умножить", "Добавить или добавить",
            "Добавить или возвести", "Добавить или умножить и вычесть", "Добавить или умножить и добавить"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complex_task);

        anyMoveButton = findViewById(R.id.anyMove);
        unluckyMoveButton = findViewById(R.id.unluckyMove);
        factor2Button = findViewById(R.id.koef2);
        factor3Button = findViewById(R.id.koef3);
        yesButton = findViewById(R.id.yesButton);
        noButton = findViewById(R.id.noButton);
        myLastOneButton = findViewById(R.id.myMove);
        anotherPlayerButton = findViewById(R.id.anotherPlayer);
        resultButton = findViewById(R.id.resultButton);
        beginFromStartButton = findViewById(R.id.beginFromStart);

        anyMoveButton.setOnClickListener(this);
        unluckyMoveButton.setOnClickListener(this);
        factor2Button.setOnClickListener(this);
        factor3Button.setOnClickListener(this);
        yesButton.setOnClickListener(this);
        noButton.setOnClickListener(this);
        myLastOneButton.setOnClickListener(this);
        anotherPlayerButton.setOnClickListener(this);
        resultButton.setOnClickListener(this);
        beginFromStartButton.setOnClickListener(this);

        chooseAction = findViewById(R.id.chooseAction);
        answerTask19 = findViewById(R.id.answer19);
        answerTask20 = findViewById(R.id.answer20);
        answerTask21 = findViewById(R.id.answer21);
        countOfHeaps1 = findViewById(R.id.countOfHeaps1);
        possibleValuesOfS = findViewById(R.id.possibleS);

        rectangle1 = findViewById(R.id.view1);
        rectangle2 = findViewById(R.id.view2);

        listView = findViewById(R.id.listView);

        layoutMove = findViewById(R.id.layoutMove);
        layoutCountOfFactors = findViewById(R.id.layoutCountOfKoef);
        layoutBranch3Factors = findViewById(R.id.layoutBranch3Koef);
        layoutWhichMove = findViewById(R.id.whichMove);
        answerLayout = findViewById(R.id.answerLayout);

        stoneInputField1 = findViewById(R.id.editText1);
        stoneInputField2 = findViewById(R.id.editText2);
        factorInputField = findViewById(R.id.editText3);
        enteredResult = findViewById(R.id.editText4);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, arrayChooseAction) {

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                TextView item = view.findViewById(android.R.id.text1);
                item.setGravity(Gravity.CENTER);
                item.setTextColor(Color.parseColor("#cdcdcd"));

                return view;
            }

        };

        listView.setAdapter(adapter);

        flAnyMoveButton = flUnluckyMoveButton = flFactor2Button = flFactor3Button = flYesButton = flNoButton
                = somethingIsChecked = getAnswerWasTapped = flMyLastOne = flAnotherPlayer =
                noWasPressed = ERROR = false;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.anyMove:
                if (flUnluckyMoveButton) {
                    unluckyMoveButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks, getBaseContext().getTheme()));
                    flUnluckyMoveButton = false;
                }
                anyMoveButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks_pressed, getBaseContext().getTheme()));
                flAnyMoveButton = true;
                layoutCountOfFactors.setVisibility(View.VISIBLE);
                break;

            case R.id.unluckyMove:
                if (flAnyMoveButton) {
                    anyMoveButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks, getBaseContext().getTheme()));
                    flAnyMoveButton = false;
                }
                unluckyMoveButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks_pressed, getBaseContext().getTheme()));
                flUnluckyMoveButton = true;
                layoutCountOfFactors.setVisibility(View.VISIBLE);
                break;

            case R.id.koef2:
                if (flFactor3Button) {
                    factor3Button.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks, getBaseContext().getTheme()));
                    flFactor3Button = false;
                }

                if (saveIndexOfButton == 2 && noWasPressed) {
                    anyMoveButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks, getBaseContext().getTheme()));
                    unluckyMoveButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks_pressed, getBaseContext().getTheme()));
                    flAnyMoveButton = false;
                    flUnluckyMoveButton = true;
                }

                count2factorsTapped++;
                factor2Button.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks_pressed, getBaseContext().getTheme()));
                flFactor2Button = true;

                resultButton.setVisibility(View.VISIBLE);
                layoutBranch3Factors.setVisibility(View.GONE);

                flYesButton = flNoButton = noWasPressed = false;
                noButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks, getBaseContext().getTheme()));
                yesButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks, getBaseContext().getTheme()));
                anyMoveButton.setEnabled(true);
                unluckyMoveButton.setEnabled(true);
                saveIndexOfButton = -1;
                layoutWhichMove.setVisibility(View.GONE);
                anotherPlayerButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks, getBaseContext().getTheme()));
                myLastOneButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks, getBaseContext().getTheme()));
                flMyLastOne = flAnotherPlayer = noWasPressed = false;

                if (flAnyMoveButton) {
                    anyMoveButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks_pressed, getBaseContext().getTheme()));
                    flAnyMoveButton = true;
                    unluckyMoveButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks, getBaseContext().getTheme()));
                    flUnluckyMoveButton = false;
                }

                if (flUnluckyMoveButton) {
                    unluckyMoveButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks_pressed, getBaseContext().getTheme()));
                    flUnluckyMoveButton = true;
                    anyMoveButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks, getBaseContext().getTheme()));
                    flAnyMoveButton = false;
                }
                break;

            case R.id.koef3:
                if (flFactor2Button) {
                    factor2Button.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks, getBaseContext().getTheme()));
                    flFactor2Button = false;
                }

                count3factorsTapped++;
                factor3Button.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks_pressed, getBaseContext().getTheme()));
                flFactor3Button = true;
                resultButton.setVisibility(View.VISIBLE);
                layoutBranch3Factors.setVisibility(View.VISIBLE);

                break;

            case R.id.yesButton:
                if (flNoButton) {
                    noButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks, getBaseContext().getTheme()));
                    flNoButton = false;
                }
                yesButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks_pressed, getBaseContext().getTheme()));
                flYesButton = true;
                anyMoveButton.setEnabled(true);
                unluckyMoveButton.setEnabled(true);

                if (saveIndexOfButton == 1 && noWasPressed) {
                    unluckyMoveButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks, getBaseContext().getTheme()));
                    anyMoveButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks_pressed, getBaseContext().getTheme()));

                    flAnyMoveButton = true;
                }

                if (saveIndexOfButton == 2 && noWasPressed) {
                    anyMoveButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks, getBaseContext().getTheme()));
                    unluckyMoveButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks_pressed, getBaseContext().getTheme()));
                    flAnyMoveButton = false;
                    flUnluckyMoveButton = true;
                }

                if (saveIndexOfButton == -1 && noWasPressed) {
                    flAnyMoveButton = false;
                    anyMoveButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks, getBaseContext().getTheme()));
                    unluckyMoveButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks_pressed, getBaseContext().getTheme()));
                }

                layoutWhichMove.setVisibility(View.GONE);
                anotherPlayerButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks, getBaseContext().getTheme()));
                myLastOneButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks, getBaseContext().getTheme()));
                flMyLastOne = flAnotherPlayer = noWasPressed = false;
                break;

            case R.id.noButton:
                if (flYesButton) {
                    yesButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks, getBaseContext().getTheme()));
                    flYesButton = false;
                }
                noButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks_pressed, getBaseContext().getTheme()));
                flNoButton = true;

                noWasPressed = true;

                if (flUnluckyMoveButton) {
                    saveIndexOfButton = 2;
                    unluckyMoveButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks, getBaseContext().getTheme()));
                    anyMoveButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks_pressed, getBaseContext().getTheme()));
                    anyMoveButton.setEnabled(false);
                    unluckyMoveButton.setEnabled(false);

                }

                if (flAnyMoveButton) {
                    saveIndexOfButton = 1;
                    anyMoveButton.setEnabled(false);
                    unluckyMoveButton.setEnabled(false);
                }

                if (!flAnyMoveButton && !flUnluckyMoveButton) {
                    anyMoveButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks_pressed, getBaseContext().getTheme()));
                    anyMoveButton.setEnabled(false);
                    unluckyMoveButton.setEnabled(false);
                }

                flAnyMoveButton = true;
                flUnluckyMoveButton = false;
                layoutWhichMove.setVisibility(View.VISIBLE);
                break;

            case R.id.myMove:
                if (flAnotherPlayer) {
                    anotherPlayerButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks, getBaseContext().getTheme()));
                    flAnotherPlayer = false;
                }
                myLastOneButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks_pressed, getBaseContext().getTheme()));
                flMyLastOne = true;
                break;

            case R.id.anotherPlayer:
                if (flMyLastOne) {
                    myLastOneButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks, getBaseContext().getTheme()));
                    flMyLastOne = false;
                }
                anotherPlayerButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks_pressed, getBaseContext().getTheme()));
                flAnotherPlayer = true;
                break;

            case R.id.resultButton:

                saveStoneInputField1 = stoneInputField1.getText().toString();
                saveStoneInputField2 = stoneInputField2.getText().toString();
                saveFactorInputField = factorInputField.getText().toString();
                saveEnteredResult = enteredResult.getText().toString();

                saveIndexList = indexOfSelectedItem;

                if ((flFactor2Button && indexOfSelectedItem == -1) || (flFactor3Button && !flYesButton && !flNoButton) ||
                        (flNoButton && !flMyLastOne && !flAnotherPlayer) ||
                        (flFactor3Button && (stoneInputField1.getText().toString().isEmpty() ||
                                stoneInputField2.getText().toString().isEmpty() ||
                                factorInputField.getText().toString().isEmpty() ||
                                enteredResult.getText().toString().isEmpty())) ||
                        (flFactor2Button && (indexOfSelectedItem != 3 && indexOfSelectedItem != 4) && (stoneInputField1.getText().toString().isEmpty() ||
                                stoneInputField2.getText().toString().isEmpty() || enteredResult.getText().toString().isEmpty())) ||
                        (flFactor2Button && (indexOfSelectedItem == 3 || indexOfSelectedItem == 4) && (stoneInputField1.getText().toString().isEmpty() ||
                                stoneInputField2.getText().toString().isEmpty() ||
                                factorInputField.getText().toString().isEmpty() ||
                                enteredResult.getText().toString().isEmpty())) ||
                        (stoneInputField1.getText().toString().length() > 4 ||
                                stoneInputField2.getText().toString().length() > 4 ||
                                factorInputField.getText().toString().length() > 4 ||
                                enteredResult.getText().toString().length() > 4)) {
                    saveLayout();
                    if (indexOfSelectedItem == -1)
                        Toast.makeText(this, "Не выбран вид операции", Toast.LENGTH_SHORT).show();

                    int countEmpty = 0;

                    if (stoneInputField1.getText().toString().isEmpty())
                        countEmpty++;

                    if (stoneInputField2.getText().toString().isEmpty())
                        countEmpty++;

                    if (factorInputField.getText().toString().isEmpty() && (flFactor3Button || indexOfSelectedItem == 3 || indexOfSelectedItem == 4))
                        countEmpty++;

                    if (enteredResult.getText().toString().isEmpty())
                        countEmpty++;

                    if (countEmpty > 1)
                        Toast.makeText(this, "Не введены коэффициенты", Toast.LENGTH_SHORT).show();
                    else {
                        if (flFactor3Button && (stoneInputField1.getText().toString().isEmpty() ||
                                stoneInputField2.getText().toString().isEmpty() ||
                                factorInputField.getText().toString().isEmpty() ||
                                enteredResult.getText().toString().isEmpty())) {

                            if (stoneInputField1.getText().toString().isEmpty())
                                Toast.makeText(this, "Не указано количество добавляемых камней", Toast.LENGTH_SHORT).show();

                            if (stoneInputField2.getText().toString().isEmpty())
                                Toast.makeText(this, "Не указано количество добавляемых камней", Toast.LENGTH_SHORT).show();

                            if (factorInputField.getText().toString().isEmpty())
                                Toast.makeText(this, "Не указан коэффициент умножения", Toast.LENGTH_SHORT).show();

                            if (enteredResult.getText().toString().isEmpty())
                                Toast.makeText(this, "Не указано число выигрыша", Toast.LENGTH_SHORT).show();
                        }

                        switch (indexOfSelectedItem) {
                            case 0:
                                if (stoneInputField1.getText().toString().isEmpty())
                                    Toast.makeText(this, "Не указано количество добавляемых камней", Toast.LENGTH_SHORT).show();

                                if (stoneInputField2.getText().toString().isEmpty())
                                    Toast.makeText(this, "Не указан коэффициент умножения", Toast.LENGTH_SHORT).show();

                                if (enteredResult.getText().toString().isEmpty())
                                    Toast.makeText(this, "Не указано число выигрыша", Toast.LENGTH_SHORT).show();

                                break;

                            case 1:
                                if (stoneInputField1.getText().toString().isEmpty())
                                    Toast.makeText(this, "Не указано количество добавляемых камней", Toast.LENGTH_SHORT).show();

                                if (stoneInputField2.getText().toString().isEmpty())
                                    Toast.makeText(this, "Не указано количество добавляемых камней", Toast.LENGTH_SHORT).show();

                                if (enteredResult.getText().toString().isEmpty())
                                    Toast.makeText(this, "Не указано число выигрыша", Toast.LENGTH_SHORT).show();
                                break;

                            case 2:
                                if (stoneInputField1.getText().toString().isEmpty())
                                    Toast.makeText(this, "Не указано количество добавляемых камней", Toast.LENGTH_SHORT).show();

                                if (stoneInputField2.getText().toString().isEmpty())
                                    Toast.makeText(this, "Не указан коэффициент возведения", Toast.LENGTH_SHORT).show();

                                if (enteredResult.getText().toString().isEmpty())
                                    Toast.makeText(this, "Не указано число выигрыша", Toast.LENGTH_SHORT).show();
                                break;

                            case 3:
                                if (stoneInputField1.getText().toString().isEmpty())
                                    Toast.makeText(this, "Не указано количество добавляемых камней", Toast.LENGTH_SHORT).show();

                                if (stoneInputField2.getText().toString().isEmpty())
                                    Toast.makeText(this, "Не указан коэффициент умножения", Toast.LENGTH_SHORT).show();

                                if (factorInputField.getText().toString().isEmpty())
                                    Toast.makeText(this, "Не указано количество вычитаемых камней", Toast.LENGTH_SHORT).show();

                                if (enteredResult.getText().toString().isEmpty())
                                    Toast.makeText(this, "Не указано число выигрыша", Toast.LENGTH_SHORT).show();

                                break;

                            case 4:
                                if (stoneInputField1.getText().toString().isEmpty())
                                    Toast.makeText(this, "Не указано количество добавляемых камней", Toast.LENGTH_SHORT).show();

                                if (stoneInputField2.getText().toString().isEmpty())
                                    Toast.makeText(this, "Не указан коэффициент умножения", Toast.LENGTH_SHORT).show();

                                if (factorInputField.getText().toString().isEmpty())
                                    Toast.makeText(this, "Не указано количество добавляемых камней", Toast.LENGTH_SHORT).show();

                                if (enteredResult.getText().toString().isEmpty())
                                    Toast.makeText(this, "Не указано число выигрыша", Toast.LENGTH_SHORT).show();

                                break;
                        }
                    }

                    if (flFactor3Button && !flYesButton && !flNoButton)
                        Toast.makeText(this, "Не выбрано условие повторения хода", Toast.LENGTH_SHORT).show();

                    if (flNoButton && !flMyLastOne && !flAnotherPlayer)
                        Toast.makeText(this, "Не выбрано чей ход нельзя повторять", Toast.LENGTH_SHORT).show();

                    int countLength = 0;

                    if (stoneInputField1.getText().toString().length() > 4)
                        countLength++;

                    if (stoneInputField2.getText().toString().length() > 4)
                        countLength++;

                    if (factorInputField.getText().toString().length() > 4)
                        countLength++;

                    if (enteredResult.getText().toString().length() > 4)
                        countLength++;

                    if (countLength > 1)
                        Toast.makeText(this, "Коэффициенты превышают допустимую длину", Toast.LENGTH_SHORT).show();
                    else {
                        if (stoneInputField1.getText().toString().length() > 4 ||
                                stoneInputField2.getText().toString().length() > 4 ||
                                factorInputField.getText().toString().length() > 4 ||
                                enteredResult.getText().toString().length() > 4) {

                            if (stoneInputField1.getText().toString().length() > 4)
                                Toast.makeText(this, "Количество добавляемых камней превышает допустимое", Toast.LENGTH_SHORT).show();

                            if (stoneInputField2.getText().toString().length() > 4)
                                Toast.makeText(this, "Количество добавляемых камней превышает допустимое", Toast.LENGTH_SHORT).show();

                            if (factorInputField.getText().toString().length() > 4)
                                Toast.makeText(this, "Коэффициент умножения превышает допустимое значение", Toast.LENGTH_SHORT).show();

                            if (enteredResult.getText().toString().length() > 4)
                                Toast.makeText(this, "Число выигрыша превышает допустимое", Toast.LENGTH_SHORT).show();
                        }

                        switch (indexOfSelectedItem) {
                            case 0:
                                if (stoneInputField1.getText().toString().length() > 4)
                                    Toast.makeText(this, "Количество добавляемых камней превышает допустимое", Toast.LENGTH_SHORT).show();

                                if (stoneInputField2.getText().toString().length() > 4)
                                    Toast.makeText(this, "Коэффициент умножения превышает допустимое значение", Toast.LENGTH_SHORT).show();

                                if (enteredResult.getText().toString().length() > 4)
                                    Toast.makeText(this, "Число выигрыша превышает допустимое", Toast.LENGTH_SHORT).show();

                                break;

                            case 1:
                                if (stoneInputField1.getText().toString().length() > 4)
                                    Toast.makeText(this, "Количество добавляемых камней превышает допустимое", Toast.LENGTH_SHORT).show();

                                if (stoneInputField2.getText().toString().length() > 4)
                                    Toast.makeText(this, "Количество добавляемых камней превышает допустимое", Toast.LENGTH_SHORT).show();

                                if (enteredResult.getText().toString().length() > 4)
                                    Toast.makeText(this, "Число выигрыша превышает допустимое", Toast.LENGTH_SHORT).show();
                                break;

                            case 2:
                                if (stoneInputField1.getText().toString().length() > 4)
                                    Toast.makeText(this, "Количество добавляемых камней превышает допустимое", Toast.LENGTH_SHORT).show();

                                if (stoneInputField2.getText().toString().length() > 1)
                                    Toast.makeText(this, "Коэффициент возведения превышает допустимое значение", Toast.LENGTH_SHORT).show();

                                if (enteredResult.getText().toString().length() > 4)
                                    Toast.makeText(this, "Число выигрыша превышает допустимое", Toast.LENGTH_SHORT).show();
                                break;

                            case 3:
                                if (stoneInputField1.getText().toString().length() > 4)
                                    Toast.makeText(this, "Количество добавляемых камней превышает допустимое", Toast.LENGTH_SHORT).show();

                                if (stoneInputField2.getText().toString().length() > 4)
                                    Toast.makeText(this, "Коэффициент умножения превышает допустимое значение", Toast.LENGTH_SHORT).show();

                                if (factorInputField.getText().toString().length() > 4)
                                    Toast.makeText(this, "Количество вычитаемых камней превышает допустимое", Toast.LENGTH_SHORT).show();

                                if (enteredResult.getText().toString().length() > 4)
                                    Toast.makeText(this, "Число выигрыша превышает допустимое", Toast.LENGTH_SHORT).show();

                                break;

                            case 4:
                                if (stoneInputField1.getText().toString().length() > 4)
                                    Toast.makeText(this, "Количество добавляемых камней превышает допустимое", Toast.LENGTH_SHORT).show();

                                if (stoneInputField2.getText().toString().length() > 4)
                                    Toast.makeText(this, "Коэффициент умножения превышает допустимое значение", Toast.LENGTH_SHORT).show();

                                if (factorInputField.getText().toString().length() > 4)
                                    Toast.makeText(this, "Количество добавляемых камней превышает допустимое", Toast.LENGTH_SHORT).show();

                                if (enteredResult.getText().toString().length() > 4)
                                    Toast.makeText(this, "Число выигрыша превышает допустимое", Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                } else {
                    final String errorText = "Ошибка: неверно введены данные";
                    if (flAnyMoveButton) {
                        if (flFactor2Button) {
                            switch (indexOfSelectedItem) {
                                case 0:
                                    OneHeapTwoAnd_PL_MU_19 obj_PL_MU_19 = new OneHeapTwoAnd_PL_MU_19(
                                            Integer.parseInt(stoneInputField1.getText().toString()),
                                            Integer.parseInt(stoneInputField2.getText().toString()),
                                            Integer.parseInt(enteredResult.getText().toString()));

                                    OneHeapTwo_PL_MU_20 obj_PL_MU_20 = new OneHeapTwo_PL_MU_20(
                                            Integer.parseInt(stoneInputField1.getText().toString()),
                                            Integer.parseInt(stoneInputField2.getText().toString()),
                                            Integer.parseInt(enteredResult.getText().toString()));

                                    OneHeapTwo_PL_MU_21 obj_PL_MU_21 = new OneHeapTwo_PL_MU_21(
                                            Integer.parseInt(stoneInputField1.getText().toString()),
                                            Integer.parseInt(stoneInputField2.getText().toString()),
                                            Integer.parseInt(enteredResult.getText().toString()));

                                    StringBuilder answer_PL_MU_20 = new StringBuilder();
                                    List<Integer> list_PL_MU_20 = obj_PL_MU_20.getResult();

                                    StringBuilder answer_PL_MU_21 = new StringBuilder();
                                    List<Integer> list_PL_MU_21 = obj_PL_MU_21.getResult();

                                    if (obj_PL_MU_19.getResult() == 0 || list_PL_MU_20.isEmpty() || list_PL_MU_21.isEmpty())
                                        ERROR = true;
                                    else {
                                        answerTask19.setText(String.format(new Locale("ru"), "%d", obj_PL_MU_19.getResult()));

                                        for (int elem : list_PL_MU_20)
                                            answer_PL_MU_20.append(elem).append("  ");
                                        answerTask20.setText(answer_PL_MU_20);

                                        for (int elem : list_PL_MU_21)
                                            answer_PL_MU_21.append(elem).append("  ");
                                        answerTask21.setText(answer_PL_MU_21);
                                    }
                                    break;

                                case 1:
                                    OneHeapTwoAnd_PL_PL_19 obj_PL_PL_19 = new OneHeapTwoAnd_PL_PL_19(
                                            Integer.parseInt(stoneInputField1.getText().toString()),
                                            Integer.parseInt(stoneInputField2.getText().toString()),
                                            Integer.parseInt(enteredResult.getText().toString()));

                                    OneHeapTwo_PL_PL_20 obj_PL_PL_20 = new OneHeapTwo_PL_PL_20(
                                            Integer.parseInt(stoneInputField1.getText().toString()),
                                            Integer.parseInt(stoneInputField2.getText().toString()),
                                            Integer.parseInt(enteredResult.getText().toString()));

                                    OneHeapTwo_PL_PL_21 obj_PL_PL_21 = new OneHeapTwo_PL_PL_21(
                                            Integer.parseInt(stoneInputField1.getText().toString()),
                                            Integer.parseInt(stoneInputField2.getText().toString()),
                                            Integer.parseInt(enteredResult.getText().toString()));

                                    StringBuilder answer_PL_PL_20 = new StringBuilder();
                                    List<Integer> list_PL_PL_20 = obj_PL_PL_20.getResult();

                                    StringBuilder answer_PL_PL_21 = new StringBuilder();
                                    List<Integer> list_PL_PL_21 = obj_PL_PL_21.getResult();

                                    if (obj_PL_PL_19.getResult() == 0 || list_PL_PL_20.isEmpty() || list_PL_PL_21.isEmpty())
                                        ERROR = true;
                                    else {
                                        answerTask19.setText(String.format(new Locale("ru"), "%d", obj_PL_PL_19.getResult()));

                                        for (int elem : list_PL_PL_20)
                                            answer_PL_PL_20.append(elem).append("  ");
                                        answerTask20.setText(answer_PL_PL_20);

                                        for (int elem : list_PL_PL_21)
                                            answer_PL_PL_21.append(elem).append("  ");
                                        answerTask21.setText(answer_PL_PL_21);
                                    }
                                    break;

                                case 2:
                                    OneHeapTwoAnd_PL_MU_MU_19 obj_PL_MU_MU_19 = new OneHeapTwoAnd_PL_MU_MU_19(
                                            Integer.parseInt(stoneInputField1.getText().toString()),
                                            Integer.parseInt(stoneInputField2.getText().toString()),
                                            Integer.parseInt(enteredResult.getText().toString()));

                                    OneHeapTwo_PL_MU_MU_20 obj_PL_MU_MU_20 = new OneHeapTwo_PL_MU_MU_20(
                                            Integer.parseInt(stoneInputField1.getText().toString()),
                                            Integer.parseInt(stoneInputField2.getText().toString()),
                                            Integer.parseInt(enteredResult.getText().toString()));

                                    OneHeapTwo_PL_MU_MU_21 obj_PL_MU_MU_21 = new OneHeapTwo_PL_MU_MU_21(
                                            Integer.parseInt(stoneInputField1.getText().toString()),
                                            Integer.parseInt(stoneInputField2.getText().toString()),
                                            Integer.parseInt(enteredResult.getText().toString()));

                                    StringBuilder answer_PL_MU_MU_20 = new StringBuilder();
                                    List<Integer> list_PL_MU_MU_20 = obj_PL_MU_MU_20.getResult();

                                    StringBuilder answer_PL_MU_MU_21 = new StringBuilder();
                                    List<Integer> list_PL_MU_MU_21 = obj_PL_MU_MU_21.getResult();

                                    if (obj_PL_MU_MU_19.getResult() == 0 || list_PL_MU_MU_20.isEmpty() || list_PL_MU_MU_21.isEmpty())
                                        ERROR = true;
                                    else {
                                        answerTask19.setText(String.format(new Locale("ru"), "%d", obj_PL_MU_MU_19.getResult()));

                                        for (int elem : list_PL_MU_MU_20)
                                            answer_PL_MU_MU_20.append(elem).append("  ");
                                        answerTask20.setText(answer_PL_MU_MU_20);

                                        for (int elem : list_PL_MU_MU_21)
                                            answer_PL_MU_MU_21.append(elem).append("  ");
                                        answerTask21.setText(answer_PL_MU_MU_21);
                                    }
                                    break;

                                case 3:
                                    OneHeapTwoAnd_PL_MU_MN_19 obj_PL_MU_MN_19 = new OneHeapTwoAnd_PL_MU_MN_19(
                                            Integer.parseInt(stoneInputField1.getText().toString()),
                                            Integer.parseInt(stoneInputField2.getText().toString()),
                                            Integer.parseInt(factorInputField.getText().toString()),
                                            Integer.parseInt(enteredResult.getText().toString()));

                                    OneHeapTwo_PL_MU_MN_20 obj_PL_MU_MN_20 = new OneHeapTwo_PL_MU_MN_20(
                                            Integer.parseInt(stoneInputField1.getText().toString()),
                                            Integer.parseInt(stoneInputField2.getText().toString()),
                                            Integer.parseInt(factorInputField.getText().toString()),
                                            Integer.parseInt(enteredResult.getText().toString()));

                                    OneHeapTwo_PL_MU_MN_21 obj_PL_MU_MN_21 = new OneHeapTwo_PL_MU_MN_21(
                                            Integer.parseInt(stoneInputField1.getText().toString()),
                                            Integer.parseInt(stoneInputField2.getText().toString()),
                                            Integer.parseInt(factorInputField.getText().toString()),
                                            Integer.parseInt(enteredResult.getText().toString()));

                                    StringBuilder answer_PL_MU_MN_20 = new StringBuilder();
                                    List<Integer> list_PL_MU_MN_20 = obj_PL_MU_MN_20.getResult();

                                    StringBuilder answer_PL_MU_MN_21 = new StringBuilder();
                                    List<Integer> list_PL_MU_MN_21 = obj_PL_MU_MN_21.getResult();

                                    if (obj_PL_MU_MN_19.getResult() == 0 || list_PL_MU_MN_20.isEmpty() || list_PL_MU_MN_21.isEmpty())
                                        ERROR = true;
                                    else {
                                        answerTask19.setText(String.format(new Locale("ru"), "%d", obj_PL_MU_MN_19.getResult()));

                                        for (int elem : list_PL_MU_MN_20)
                                            answer_PL_MU_MN_20.append(elem).append("  ");
                                        answerTask20.setText(answer_PL_MU_MN_20);

                                        for (int elem : list_PL_MU_MN_21)
                                            answer_PL_MU_MN_21.append(elem).append("  ");
                                        answerTask21.setText(answer_PL_MU_MN_21);
                                    }
                                    break;

                                case 4:
                                    OneHeapTwoAnd_PL_MU_PL_19 obj_PL_MU_PL_19 = new OneHeapTwoAnd_PL_MU_PL_19(
                                            Integer.parseInt(stoneInputField1.getText().toString()),
                                            Integer.parseInt(stoneInputField2.getText().toString()),
                                            Integer.parseInt(factorInputField.getText().toString()),
                                            Integer.parseInt(enteredResult.getText().toString()));

                                    OneHeapTwo_PL_MU_PL_20 obj_PL_MU_PL_20 = new OneHeapTwo_PL_MU_PL_20(
                                            Integer.parseInt(stoneInputField1.getText().toString()),
                                            Integer.parseInt(stoneInputField2.getText().toString()),
                                            Integer.parseInt(factorInputField.getText().toString()),
                                            Integer.parseInt(enteredResult.getText().toString()));

                                    OneHeapTwo_PL_MU_PL_21 obj_PL_MU_PL_21 = new OneHeapTwo_PL_MU_PL_21(
                                            Integer.parseInt(stoneInputField1.getText().toString()),
                                            Integer.parseInt(stoneInputField2.getText().toString()),
                                            Integer.parseInt(factorInputField.getText().toString()),
                                            Integer.parseInt(enteredResult.getText().toString()));

                                    StringBuilder answer_PL_MU_PL_20 = new StringBuilder();
                                    List<Integer> list_PL_MU_PL_20 = obj_PL_MU_PL_20.getResult();

                                    StringBuilder answer_PL_MU_PL_21 = new StringBuilder();
                                    List<Integer> list_PL_MU_PL_21 = obj_PL_MU_PL_21.getResult();

                                    if (obj_PL_MU_PL_19.getResult() == 0 || list_PL_MU_PL_20.isEmpty() || list_PL_MU_PL_21.isEmpty())
                                        ERROR = true;
                                    else {
                                        answerTask19.setText(String.format(new Locale("ru"), "%d", obj_PL_MU_PL_19.getResult()));

                                        for (int elem : list_PL_MU_PL_20)
                                            answer_PL_MU_PL_20.append(elem).append("  ");
                                        answerTask20.setText(answer_PL_MU_PL_20);

                                        for (int elem : list_PL_MU_PL_21)
                                            answer_PL_MU_PL_21.append(elem).append("  ");
                                        answerTask21.setText(answer_PL_MU_PL_21);
                                    }
                                    break;
                            }

                            if (ERROR) {
                                Toast.makeText(this, errorText, Toast.LENGTH_SHORT).show();
                                saveLayout();
                                ERROR = false;
                            } else {
                                getAnswerWasTapped = true;

                                chooseAction.setVisibility(View.GONE);
                                rectangle1.setVisibility(View.GONE);
                                listView.setVisibility(View.GONE);
                                rectangle2.setVisibility(View.GONE);
                                stoneInputField1.setVisibility(View.GONE);
                                stoneInputField2.setVisibility(View.GONE);
                                factorInputField.setVisibility(View.GONE);
                                enteredResult.setVisibility(View.GONE);
                                countOfHeaps1.setVisibility(View.GONE);
                                layoutCountOfFactors.setVisibility(View.GONE);
                                layoutBranch3Factors.setVisibility(View.GONE);
                                layoutWhichMove.setVisibility(View.GONE);
                                layoutMove.setVisibility(View.GONE);
                                resultButton.setVisibility(View.GONE);
                                answerLayout.setVisibility(View.VISIBLE);
                                beginFromStartButton.setVisibility(View.VISIBLE);
                            }
                        }

                        if (flFactor3Button) {
                            if (flYesButton) {
                                OneHeapThreeAnd19 obj_19 = new OneHeapThreeAnd19(
                                        Integer.parseInt(stoneInputField1.getText().toString()),
                                        Integer.parseInt(stoneInputField2.getText().toString()),
                                        Integer.parseInt(factorInputField.getText().toString()),
                                        Integer.parseInt(enteredResult.getText().toString()));

                                OneHeapThree20 obj_20 = new OneHeapThree20(
                                        Integer.parseInt(stoneInputField1.getText().toString()),
                                        Integer.parseInt(stoneInputField2.getText().toString()),
                                        Integer.parseInt(factorInputField.getText().toString()),
                                        Integer.parseInt(enteredResult.getText().toString()));

                                OneHeapThree21 obj_21 = new OneHeapThree21(
                                        Integer.parseInt(stoneInputField1.getText().toString()),
                                        Integer.parseInt(stoneInputField2.getText().toString()),
                                        Integer.parseInt(factorInputField.getText().toString()),
                                        Integer.parseInt(enteredResult.getText().toString()));

                                StringBuilder answer_20 = new StringBuilder();
                                List<Integer> list_20 = obj_20.getResult();

                                StringBuilder answer_21 = new StringBuilder();
                                List<Integer> list_21 = obj_21.getResult();

                                if (obj_19.getResult() == 0 || list_20.isEmpty() || list_21.isEmpty())
                                    ERROR = true;
                                else {
                                    answerTask19.setText(String.format(new Locale("ru"), "%d", obj_19.getResult()));

                                    for (int elem : list_20) answer_20.append(elem).append("  ");
                                    answerTask20.setText(answer_20);

                                    for (int elem : list_21) answer_21.append(elem).append("  ");
                                    answerTask21.setText(answer_21);
                                }
                            }

                            if (flNoButton && flMyLastOne) {
                                OneHeapThreeNoSameMe19 objNoSameMy_19 = new OneHeapThreeNoSameMe19(
                                        Integer.parseInt(stoneInputField1.getText().toString()),
                                        Integer.parseInt(stoneInputField2.getText().toString()),
                                        Integer.parseInt(factorInputField.getText().toString()),
                                        Integer.parseInt(enteredResult.getText().toString()));

                                OneHeapThreeNoSameMe20 objNoSameMy_20 = new OneHeapThreeNoSameMe20(
                                        Integer.parseInt(stoneInputField1.getText().toString()),
                                        Integer.parseInt(stoneInputField2.getText().toString()),
                                        Integer.parseInt(factorInputField.getText().toString()),
                                        Integer.parseInt(enteredResult.getText().toString()));

                                OneHeapThreeNoSameMe21 objNoSameMy_21 = new OneHeapThreeNoSameMe21(
                                        Integer.parseInt(stoneInputField1.getText().toString()),
                                        Integer.parseInt(stoneInputField2.getText().toString()),
                                        Integer.parseInt(factorInputField.getText().toString()),
                                        Integer.parseInt(enteredResult.getText().toString()));

                                StringBuilder answer_19 = new StringBuilder();
                                List<Integer> list_19 = objNoSameMy_19.getResult();

                                StringBuilder answer_20 = new StringBuilder();
                                List<Integer> list_20 = objNoSameMy_20.getResult();

                                StringBuilder answer_21 = new StringBuilder();
                                List<Integer> list_21 = objNoSameMy_21.getResult();

                                if (list_19.isEmpty() || list_20.isEmpty() || list_21.isEmpty())
                                    ERROR = true;
                                else {
                                    for (int elem : list_19) answer_19.append(elem).append("  ");
                                    answerTask19.setText(answer_19);

                                    answer_20.append(list_20.get(0)).append("  ").append(list_20.get(list_20.size() - 1));
                                    answerTask20.setText(answer_20);

                                    possibleValuesOfS.setText("Максимальное значение S:");
                                    answer_21.append(list_21.get(list_21.size() - 1));
                                    answerTask21.setText(answer_21);
                                }
                            }

                            if (flNoButton && flAnotherPlayer) {
                                OneHeapThreeNoSame2Player19 objNoSameSecond_19 = new OneHeapThreeNoSame2Player19(
                                        Integer.parseInt(stoneInputField1.getText().toString()),
                                        Integer.parseInt(stoneInputField2.getText().toString()),
                                        Integer.parseInt(factorInputField.getText().toString()),
                                        Integer.parseInt(enteredResult.getText().toString()));

                                OneHeapThreeNoSame2Player20 objNoSameSecond_20 = new OneHeapThreeNoSame2Player20(
                                        Integer.parseInt(stoneInputField1.getText().toString()),
                                        Integer.parseInt(stoneInputField2.getText().toString()),
                                        Integer.parseInt(factorInputField.getText().toString()),
                                        Integer.parseInt(enteredResult.getText().toString()));

                                OneHeapThreeNoSame2Player21 objNoSameSecond_21 = new OneHeapThreeNoSame2Player21(
                                        Integer.parseInt(stoneInputField1.getText().toString()),
                                        Integer.parseInt(stoneInputField2.getText().toString()),
                                        Integer.parseInt(factorInputField.getText().toString()),
                                        Integer.parseInt(enteredResult.getText().toString()));

                                StringBuilder answer_19 = new StringBuilder();
                                List<Integer> list_19 = objNoSameSecond_19.getResult();

                                StringBuilder answer_20 = new StringBuilder();
                                List<Integer> list_20 = objNoSameSecond_20.getResult();

                                StringBuilder answer_21 = new StringBuilder();
                                List<Integer> list_21 = objNoSameSecond_21.getResult();

                                if (list_19.isEmpty() || list_20.isEmpty() || list_21.isEmpty())
                                    ERROR = true;
                                else {
                                    for (int elem : list_19) answer_19.append(elem).append("  ");
                                    answerTask19.setText(answer_19);

                                    answer_20.append(list_20.get(0)).append("  ").append(list_20.get(list_20.size() - 1));
                                    answerTask20.setText(answer_20);

                                    possibleValuesOfS.setText("Минимальное значение S:");
                                    answer_21.append(list_21.get(0));
                                    answerTask21.setText(answer_21);
                                }
                            }

                            if (ERROR) {
                                Toast.makeText(this, errorText, Toast.LENGTH_SHORT).show();
                                saveLayout();
                                ERROR = false;
                            } else {
                                getAnswerWasTapped = true;

                                resultButton.setVisibility(View.GONE);
                                stoneInputField1.setVisibility(View.GONE);
                                stoneInputField2.setVisibility(View.GONE);
                                factorInputField.setVisibility(View.GONE);
                                enteredResult.setVisibility(View.GONE);
                                countOfHeaps1.setVisibility(View.GONE);
                                layoutCountOfFactors.setVisibility(View.GONE);
                                layoutMove.setVisibility(View.GONE);
                                layoutWhichMove.setVisibility(View.GONE);
                                layoutBranch3Factors.setVisibility(View.GONE);
                                answerLayout.setVisibility(View.VISIBLE);
                                beginFromStartButton.setVisibility(View.VISIBLE);
                            }
                        }
                    }
                    if (flUnluckyMoveButton) {
                        if (flFactor2Button) {
                            switch (indexOfSelectedItem) {
                                case 0:
                                    OneHeapTwoOr_PL_MU_19 obj_PL_MU_19 = new OneHeapTwoOr_PL_MU_19(
                                            Integer.parseInt(stoneInputField1.getText().toString()),
                                            Integer.parseInt(stoneInputField2.getText().toString()),
                                            Integer.parseInt(enteredResult.getText().toString()));

                                    OneHeapTwo_PL_MU_20 obj_PL_MU_20 = new OneHeapTwo_PL_MU_20(
                                            Integer.parseInt(stoneInputField1.getText().toString()),
                                            Integer.parseInt(stoneInputField2.getText().toString()),
                                            Integer.parseInt(enteredResult.getText().toString()));

                                    OneHeapTwo_PL_MU_21 obj_PL_MU_21 = new OneHeapTwo_PL_MU_21(
                                            Integer.parseInt(stoneInputField1.getText().toString()),
                                            Integer.parseInt(stoneInputField2.getText().toString()),
                                            Integer.parseInt(enteredResult.getText().toString()));

                                    StringBuilder answer_PL_MU_20 = new StringBuilder();
                                    List<Integer> list_PL_MU_20 = obj_PL_MU_20.getResult();

                                    StringBuilder answer_PL_MU_21 = new StringBuilder();
                                    List<Integer> list_PL_MU_21 = obj_PL_MU_21.getResult();

                                    if (obj_PL_MU_19.getResult() == 0 || list_PL_MU_20.isEmpty() || list_PL_MU_21.isEmpty())
                                        ERROR = true;
                                    else {
                                        answerTask19.setText(String.format(new Locale("ru"), "%d", obj_PL_MU_19.getResult()));

                                        for (int elem : list_PL_MU_20)
                                            answer_PL_MU_20.append(elem).append("  ");
                                        answerTask20.setText(answer_PL_MU_20);

                                        for (int elem : list_PL_MU_21)
                                            answer_PL_MU_21.append(elem).append("  ");
                                        answerTask21.setText(answer_PL_MU_21);
                                    }
                                    break;

                                case 1:
                                    OneHeapTwoOr_PL_PL_19 obj_PL_PL_19 = new OneHeapTwoOr_PL_PL_19(
                                            Integer.parseInt(stoneInputField1.getText().toString()),
                                            Integer.parseInt(stoneInputField2.getText().toString()),
                                            Integer.parseInt(enteredResult.getText().toString()));

                                    OneHeapTwo_PL_PL_20 obj_PL_PL_20 = new OneHeapTwo_PL_PL_20(
                                            Integer.parseInt(stoneInputField1.getText().toString()),
                                            Integer.parseInt(stoneInputField2.getText().toString()),
                                            Integer.parseInt(enteredResult.getText().toString()));

                                    OneHeapTwo_PL_PL_21 obj_PL_PL_21 = new OneHeapTwo_PL_PL_21(
                                            Integer.parseInt(stoneInputField1.getText().toString()),
                                            Integer.parseInt(stoneInputField2.getText().toString()),
                                            Integer.parseInt(enteredResult.getText().toString()));

                                    StringBuilder answer_PL_PL_20 = new StringBuilder();
                                    List<Integer> list_PL_PL_20 = obj_PL_PL_20.getResult();

                                    StringBuilder answer_PL_PL_21 = new StringBuilder();
                                    List<Integer> list_PL_PL_21 = obj_PL_PL_21.getResult();

                                    if (obj_PL_PL_19.getResult() == 0 || list_PL_PL_20.isEmpty() || list_PL_PL_21.isEmpty())
                                        ERROR = true;
                                    else {
                                        answerTask19.setText(String.format(new Locale("ru"), "%d", obj_PL_PL_19.getResult()));

                                        for (int elem : list_PL_PL_20)
                                            answer_PL_PL_20.append(elem).append("  ");
                                        answerTask20.setText(answer_PL_PL_20);

                                        for (int elem : list_PL_PL_21)
                                            answer_PL_PL_21.append(elem).append("  ");
                                        answerTask21.setText(answer_PL_PL_21);
                                    }
                                    break;

                                case 2:
                                    OneHeapTwoOr_PL_MU_MU_19 obj_PL_MU_MU_19 = new OneHeapTwoOr_PL_MU_MU_19(
                                            Integer.parseInt(stoneInputField1.getText().toString()),
                                            Integer.parseInt(stoneInputField2.getText().toString()),
                                            Integer.parseInt(enteredResult.getText().toString()));

                                    OneHeapTwo_PL_MU_MU_20 obj_PL_MU_MU_20 = new OneHeapTwo_PL_MU_MU_20(
                                            Integer.parseInt(stoneInputField1.getText().toString()),
                                            Integer.parseInt(stoneInputField2.getText().toString()),
                                            Integer.parseInt(enteredResult.getText().toString()));

                                    OneHeapTwo_PL_MU_MU_21 obj_PL_MU_MU_21 = new OneHeapTwo_PL_MU_MU_21(
                                            Integer.parseInt(stoneInputField1.getText().toString()),
                                            Integer.parseInt(stoneInputField2.getText().toString()),
                                            Integer.parseInt(enteredResult.getText().toString()));

                                    StringBuilder answer_PL_MU_MU_20 = new StringBuilder();
                                    List<Integer> list_PL_MU_MU_20 = obj_PL_MU_MU_20.getResult();

                                    StringBuilder answer_PL_MU_MU_21 = new StringBuilder();
                                    List<Integer> list_PL_MU_MU_21 = obj_PL_MU_MU_21.getResult();

                                    if (obj_PL_MU_MU_19.getResult() == 0 || list_PL_MU_MU_20.isEmpty() || list_PL_MU_MU_21.isEmpty())
                                        ERROR = true;
                                    else {
                                        answerTask19.setText(String.format(new Locale("ru"), "%d", obj_PL_MU_MU_19.getResult()));

                                        for (int elem : list_PL_MU_MU_20)
                                            answer_PL_MU_MU_20.append(elem).append("  ");
                                        answerTask20.setText(answer_PL_MU_MU_20);

                                        for (int elem : list_PL_MU_MU_21)
                                            answer_PL_MU_MU_21.append(elem).append("  ");
                                        answerTask21.setText(answer_PL_MU_MU_21);
                                    }
                                    break;

                                case 3:
                                    OneHeapTwoOr_PL_MU_MN_19 obj_PL_MU_MN_19 = new OneHeapTwoOr_PL_MU_MN_19(
                                            Integer.parseInt(stoneInputField1.getText().toString()),
                                            Integer.parseInt(stoneInputField2.getText().toString()),
                                            Integer.parseInt(factorInputField.getText().toString()),
                                            Integer.parseInt(enteredResult.getText().toString()));

                                    OneHeapTwo_PL_MU_MN_20 obj_PL_MU_MN_20 = new OneHeapTwo_PL_MU_MN_20(
                                            Integer.parseInt(stoneInputField1.getText().toString()),
                                            Integer.parseInt(stoneInputField2.getText().toString()),
                                            Integer.parseInt(factorInputField.getText().toString()),
                                            Integer.parseInt(enteredResult.getText().toString()));

                                    OneHeapTwo_PL_MU_MN_21 obj_PL_MU_MN_21 = new OneHeapTwo_PL_MU_MN_21(
                                            Integer.parseInt(stoneInputField1.getText().toString()),
                                            Integer.parseInt(stoneInputField2.getText().toString()),
                                            Integer.parseInt(factorInputField.getText().toString()),
                                            Integer.parseInt(enteredResult.getText().toString()));

                                    StringBuilder answer_PL_MU_MN_20 = new StringBuilder();
                                    List<Integer> list_PL_MU_MN_20 = obj_PL_MU_MN_20.getResult();

                                    StringBuilder answer_PL_MU_MN_21 = new StringBuilder();
                                    List<Integer> list_PL_MU_MN_21 = obj_PL_MU_MN_21.getResult();

                                    if (obj_PL_MU_MN_19.getResult() == 0 || list_PL_MU_MN_20.isEmpty() || list_PL_MU_MN_21.isEmpty())
                                        ERROR = true;
                                    else {
                                        answerTask19.setText(String.format(new Locale("ru"), "%d", obj_PL_MU_MN_19.getResult()));

                                        for (int elem : list_PL_MU_MN_20)
                                            answer_PL_MU_MN_20.append(elem).append("  ");
                                        answerTask20.setText(answer_PL_MU_MN_20);

                                        for (int elem : list_PL_MU_MN_21)
                                            answer_PL_MU_MN_21.append(elem).append("  ");
                                        answerTask21.setText(answer_PL_MU_MN_21);
                                    }
                                    break;

                                case 4:
                                    OneHeapTwoOr_PL_MU_PL_19 obj_PL_MU_PL_19 = new OneHeapTwoOr_PL_MU_PL_19(
                                            Integer.parseInt(stoneInputField1.getText().toString()),
                                            Integer.parseInt(stoneInputField2.getText().toString()),
                                            Integer.parseInt(factorInputField.getText().toString()),
                                            Integer.parseInt(enteredResult.getText().toString()));

                                    OneHeapTwo_PL_MU_PL_20 obj_PL_MU_PL_20 = new OneHeapTwo_PL_MU_PL_20(
                                            Integer.parseInt(stoneInputField1.getText().toString()),
                                            Integer.parseInt(stoneInputField2.getText().toString()),
                                            Integer.parseInt(factorInputField.getText().toString()),
                                            Integer.parseInt(enteredResult.getText().toString()));

                                    OneHeapTwo_PL_MU_PL_21 obj_PL_MU_PL_21 = new OneHeapTwo_PL_MU_PL_21(
                                            Integer.parseInt(stoneInputField1.getText().toString()),
                                            Integer.parseInt(stoneInputField2.getText().toString()),
                                            Integer.parseInt(factorInputField.getText().toString()),
                                            Integer.parseInt(enteredResult.getText().toString()));

                                    StringBuilder answer_PL_MU_PL_20 = new StringBuilder();
                                    List<Integer> list_PL_MU_PL_20 = obj_PL_MU_PL_20.getResult();

                                    StringBuilder answer_PL_MU_PL_21 = new StringBuilder();
                                    List<Integer> list_PL_MU_PL_21 = obj_PL_MU_PL_21.getResult();

                                    if (obj_PL_MU_PL_19.getResult() == 0 || list_PL_MU_PL_20.isEmpty() || list_PL_MU_PL_21.isEmpty())
                                        ERROR = true;
                                    else {
                                        answerTask19.setText(String.format(new Locale("ru"), "%d", obj_PL_MU_PL_19.getResult()));

                                        for (int elem : list_PL_MU_PL_20)
                                            answer_PL_MU_PL_20.append(elem).append("  ");
                                        answerTask20.setText(answer_PL_MU_PL_20);

                                        for (int elem : list_PL_MU_PL_21)
                                            answer_PL_MU_PL_21.append(elem).append("  ");
                                        answerTask21.setText(answer_PL_MU_PL_21);
                                    }
                                    break;
                            }

                            if (ERROR) {
                                Toast.makeText(this, errorText, Toast.LENGTH_SHORT).show();
                                saveLayout();
                                ERROR = false;
                            } else {
                                getAnswerWasTapped = true;

                                chooseAction.setVisibility(View.GONE);
                                rectangle1.setVisibility(View.GONE);
                                listView.setVisibility(View.GONE);
                                rectangle2.setVisibility(View.GONE);
                                stoneInputField1.setVisibility(View.GONE);
                                stoneInputField2.setVisibility(View.GONE);
                                factorInputField.setVisibility(View.GONE);
                                enteredResult.setVisibility(View.GONE);
                                countOfHeaps1.setVisibility(View.GONE);
                                layoutCountOfFactors.setVisibility(View.GONE);
                                layoutBranch3Factors.setVisibility(View.GONE);
                                layoutWhichMove.setVisibility(View.GONE);
                                layoutMove.setVisibility(View.GONE);
                                resultButton.setVisibility(View.GONE);
                                answerLayout.setVisibility(View.VISIBLE);
                                beginFromStartButton.setVisibility(View.VISIBLE);
                            }
                        }
                        if (flFactor3Button) {
                            OneHeapThreeOr19 obj_19 = new OneHeapThreeOr19(
                                    Integer.parseInt(stoneInputField1.getText().toString()),
                                    Integer.parseInt(stoneInputField2.getText().toString()),
                                    Integer.parseInt(factorInputField.getText().toString()),
                                    Integer.parseInt(enteredResult.getText().toString()));

                            OneHeapThree20 obj_20 = new OneHeapThree20(
                                    Integer.parseInt(stoneInputField1.getText().toString()),
                                    Integer.parseInt(stoneInputField2.getText().toString()),
                                    Integer.parseInt(factorInputField.getText().toString()),
                                    Integer.parseInt(enteredResult.getText().toString()));

                            OneHeapThree21 obj_21 = new OneHeapThree21(
                                    Integer.parseInt(stoneInputField1.getText().toString()),
                                    Integer.parseInt(stoneInputField2.getText().toString()),
                                    Integer.parseInt(factorInputField.getText().toString()),
                                    Integer.parseInt(enteredResult.getText().toString()));

                            StringBuilder answer_20 = new StringBuilder();
                            List<Integer> list_20 = obj_20.getResult();

                            StringBuilder answer_21 = new StringBuilder();
                            List<Integer> list_21 = obj_21.getResult();

                            if (obj_19.getResult() == 0 || list_20.isEmpty() || list_21.isEmpty())
                                ERROR = true;
                            else {
                                answerTask19.setText(String.format(new Locale("ru"), "%d", obj_19.getResult()));

                                for (int elem : list_20) answer_20.append(elem).append("  ");
                                answerTask20.setText(answer_20);

                                for (int elem : list_21) answer_21.append(elem).append("  ");
                                answerTask21.setText(answer_21);
                            }

                            if (ERROR) {
                                Toast.makeText(this, errorText, Toast.LENGTH_SHORT).show();
                                saveLayout();
                                ERROR = false;
                            } else {
                                getAnswerWasTapped = true;

                                resultButton.setVisibility(View.GONE);
                                stoneInputField1.setVisibility(View.GONE);
                                stoneInputField2.setVisibility(View.GONE);
                                factorInputField.setVisibility(View.GONE);
                                enteredResult.setVisibility(View.GONE);
                                countOfHeaps1.setVisibility(View.GONE);
                                layoutCountOfFactors.setVisibility(View.GONE);
                                layoutBranch3Factors.setVisibility(View.GONE);
                                layoutWhichMove.setVisibility(View.GONE);
                                layoutMove.setVisibility(View.GONE);
                                answerLayout.setVisibility(View.VISIBLE);
                                beginFromStartButton.setVisibility(View.VISIBLE);
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

        if (flFactor2Button && !getAnswerWasTapped) {
            chooseAction.setVisibility(View.VISIBLE);
            rectangle1.setVisibility(View.VISIBLE);
            listView.setVisibility(View.VISIBLE);
            rectangle2.setVisibility(View.VISIBLE);
            stoneInputField1.setVisibility(View.VISIBLE);
            stoneInputField2.setVisibility(View.VISIBLE);
            factorInputField.setVisibility(View.GONE);
            enteredResult.setVisibility(View.VISIBLE);

            if (count2factorsTapped == 1 && count3factorsTapped > 0) {
                stoneInputField1.getText().clear();
                stoneInputField2.getText().clear();
                factorInputField.getText().clear();
                enteredResult.getText().clear();

                count3factorsTapped = 0;
            }

            if (indexOfSelectedItem == 3 || indexOfSelectedItem == 4)
                factorInputField.setVisibility(View.VISIBLE);
        }

        if (flFactor3Button && !getAnswerWasTapped) {
            chooseAction.setVisibility(View.GONE);
            rectangle1.setVisibility(View.GONE);
            listView.setVisibility(View.GONE);
            rectangle2.setVisibility(View.GONE);
            stoneInputField1.setVisibility(View.VISIBLE);
            stoneInputField2.setVisibility(View.VISIBLE);
            factorInputField.setVisibility(View.VISIBLE);
            enteredResult.setVisibility(View.VISIBLE);

            if (count3factorsTapped == 1 && count2factorsTapped > 0) {
                stoneInputField1.setHint("Введите количество добавляемых камней");
                stoneInputField2.setHint("Введите количество добавляемых камней");
                factorInputField.setHint("Введите коэффициент умножения");


                stoneInputField1.getText().clear();
                stoneInputField2.getText().clear();
                factorInputField.getText().clear();
                enteredResult.getText().clear();

                count2factorsTapped = 0;
            }

            if (indexOfSelectedItem != -1) {
                listView.getChildAt(indexOfSelectedItem).setBackgroundColor(Color.TRANSPARENT);
                indexOfSelectedItem = -1;
                somethingIsChecked = false;
            }
        }

        listView.setOnItemClickListener((adapterView, view1, i, l) -> {
            if (somethingIsChecked) {
                if (i == 3 || i == 4)
                    factorInputField.setVisibility(View.VISIBLE);
                else
                    factorInputField.setVisibility(View.GONE);
                listView.getChildAt(indexOfSelectedItem).setBackgroundColor(Color.TRANSPARENT);
                indexOfSelectedItem = i;
                view1.setBackgroundColor(Color.parseColor("#B3323232"));
            } else {
                if (i == 3 || i == 4)
                    factorInputField.setVisibility(View.VISIBLE);
                else
                    factorInputField.setVisibility(View.GONE);
                indexOfSelectedItem = i;
                view1.setBackgroundColor(Color.parseColor("#B3323232"));
                somethingIsChecked = true;
            }

            switch (i) {
                case 0:
                    stoneInputField2.setHint("Введите коэффициент умножения");
                    break;

                case 1:
                    stoneInputField2.setHint("Введите количество добавляемых камней");
                    break;

                case 2:
                    stoneInputField2.setHint("Введите коэффициент возведения");
                    break;

                case 3:
                    stoneInputField2.setHint("Введите коэффициент умножения");
                    factorInputField.setHint("Введите количество вычитаемых камней");
                    break;

                case 4:
                    stoneInputField2.setHint("Введите коэффициент умножения");
                    factorInputField.setHint("Введите количество добавляемых камней");
                    break;
            }
        });
    }

    private void saveLayout() {
        stoneInputField1.setText(saveStoneInputField1);
        stoneInputField2.setText(saveStoneInputField2);
        factorInputField.setText(saveFactorInputField);
        enteredResult.setText(saveEnteredResult);

        stoneInputField1.setSelection(stoneInputField1.getText().toString().length());
        stoneInputField2.setSelection(stoneInputField2.getText().toString().length());
        factorInputField.setSelection(factorInputField.getText().toString().length());
        enteredResult.setSelection(enteredResult.getText().toString().length());

        listView.setSelection(saveIndexList);

        switch (saveIndexList) {
            case 0:
                stoneInputField2.setHint("Введите коэффициент умножения");
                factorInputField.setVisibility(View.GONE);
                break;

            case 1:
                stoneInputField2.setHint("Введите количество добавляемых камней");
                factorInputField.setVisibility(View.GONE);
                break;

            case 2:
                stoneInputField2.setHint("Введите коэффициент возведения");
                factorInputField.setVisibility(View.GONE);
                break;

            case 3:
                stoneInputField2.setHint("Введите коэффициент умножения");
                factorInputField.setHint("Введите количество вычитаемых камней");
                factorInputField.setVisibility(View.VISIBLE);
                break;

            case 4:
                stoneInputField2.setHint("Введите коэффициент умножения");
                factorInputField.setHint("Введите количество добавляемых камней");
                factorInputField.setVisibility(View.VISIBLE);
                break;
        }
    }
}
