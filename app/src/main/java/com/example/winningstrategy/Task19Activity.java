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

import java.util.List;
import java.util.Locale;

public class Task19Activity extends AppCompatActivity implements View.OnClickListener {
    Button AnyMoveButton, UnluckyMoveButton, Factor2Button, Factor3Button, YesButton, NoButton,
            MyLastOneButton, AnotherPlayerButton, ResultButton, BeginFromStartButton;
    TextView ChooseAction, Answer, CountOfHeaps1;
    View Rectangle1, Rectangle2;
    ListView ListView;
    LinearLayout LayoutCountOfFactors, LayoutMove, AnswerLayout, LayoutBranch3Factors, LayoutWhichMove;
    EditText StoneInputField1, StoneInputField2, FactorInputField, EnteredResult;

    int indexOfSelectedItem = -1;
    int saveIndexOfButton = -1;
    private int count2factors = 0;
    private int count3factors = 0;
    String saveStoneInputField1;
    String saveStoneInputField2;
    String saveFactorInputField;
    String saveEnteredResult;
    int saveIndexList;
    boolean flAnyMoveButton, flUnluckyMoveButton, flFactor2Button, flFactor3Button, flYesButton,
            flNoButton, somethingIsChecked, getAnswerIsSelected, noWasPressed, flMyLastOne,
            flAnotherPlayer, saveLayout, ERROR;
    final String[] arrayChooseAction = new String[]{"Добавить или умножить", "Добавить или добавить",
            "Добавить или возвести", "Добавить или умножить и вычесть", "Добавить или умножить и добавить"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task19);

        AnyMoveButton = findViewById(R.id.anyMove);
        UnluckyMoveButton = findViewById(R.id.unluckyMove);
        Factor2Button = findViewById(R.id.koef2);
        Factor3Button = findViewById(R.id.koef3);
        YesButton = findViewById(R.id.yesButton);
        NoButton = findViewById(R.id.noButton);
        MyLastOneButton = findViewById(R.id.myMove);
        AnotherPlayerButton = findViewById(R.id.anotherPlayer);
        ResultButton = findViewById(R.id.resultButton);
        BeginFromStartButton = findViewById(R.id.beginFromStart);

        AnyMoveButton.setOnClickListener(this);
        UnluckyMoveButton.setOnClickListener(this);
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

        Rectangle1 = findViewById(R.id.view1);
        Rectangle2 = findViewById(R.id.view2);

        ListView = findViewById(R.id.listView);

        LayoutMove = findViewById(R.id.layoutMove);
        LayoutCountOfFactors = findViewById(R.id.layoutCountOfKoef);
        LayoutBranch3Factors = findViewById(R.id.layoutBranch3Koef);
        LayoutWhichMove = findViewById(R.id.whichMove);
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

        flAnyMoveButton = flUnluckyMoveButton = flFactor2Button = flFactor3Button = flYesButton = flNoButton
                = somethingIsChecked = getAnswerIsSelected = saveLayout = flMyLastOne = flAnotherPlayer =
                noWasPressed = ERROR = false;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.anyMove:
                if (flUnluckyMoveButton) {
                    UnluckyMoveButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks, getBaseContext().getTheme()));
                    flUnluckyMoveButton = false;
                }
                AnyMoveButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks_pressed, getBaseContext().getTheme()));
                flAnyMoveButton = true;
                LayoutCountOfFactors.setVisibility(View.VISIBLE);
                break;

            case R.id.unluckyMove:
                if (flAnyMoveButton) {
                    AnyMoveButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks, getBaseContext().getTheme()));
                    flAnyMoveButton = false;
                }
                UnluckyMoveButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks_pressed, getBaseContext().getTheme()));
                flUnluckyMoveButton = true;
                LayoutCountOfFactors.setVisibility(View.VISIBLE);
                break;

            case R.id.koef2:
                if (flFactor3Button) {
                    Factor3Button.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks, getBaseContext().getTheme()));
                    flFactor3Button = false;
                }

                if (saveIndexOfButton == 2 && noWasPressed) {
                    AnyMoveButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks, getBaseContext().getTheme()));
                    UnluckyMoveButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks_pressed, getBaseContext().getTheme()));
                    flAnyMoveButton = false;
                    flUnluckyMoveButton = true;
                }

                count2factors++;
                Factor2Button.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks_pressed, getBaseContext().getTheme()));
                flFactor2Button = true;
                ResultButton.setVisibility(View.VISIBLE);
                LayoutBranch3Factors.setVisibility(View.GONE);
                flYesButton = flNoButton = noWasPressed = false;
                NoButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks, getBaseContext().getTheme()));
                YesButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks, getBaseContext().getTheme()));
                AnyMoveButton.setEnabled(true);
                UnluckyMoveButton.setEnabled(true);
                saveIndexOfButton = -1;
                LayoutWhichMove.setVisibility(View.GONE);
                AnotherPlayerButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks, getBaseContext().getTheme()));
                MyLastOneButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks, getBaseContext().getTheme()));
                flMyLastOne = flAnotherPlayer = noWasPressed = false;

                if (flAnyMoveButton) {
                    AnyMoveButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks_pressed, getBaseContext().getTheme()));
                    flAnyMoveButton = true;
                    UnluckyMoveButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks, getBaseContext().getTheme()));
                    flUnluckyMoveButton = false;
                }

                if (flUnluckyMoveButton) {
                    UnluckyMoveButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks_pressed, getBaseContext().getTheme()));
                    flUnluckyMoveButton = true;
                    AnyMoveButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks, getBaseContext().getTheme()));
                    flAnyMoveButton = false;
                }
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
                AnyMoveButton.setEnabled(true);
                UnluckyMoveButton.setEnabled(true);

                if (saveIndexOfButton == 1 && noWasPressed) {
                    UnluckyMoveButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks, getBaseContext().getTheme()));
                    AnyMoveButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks_pressed, getBaseContext().getTheme()));

                    flAnyMoveButton = true;
                }

                if (saveIndexOfButton == 2 && noWasPressed) {
                    AnyMoveButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks, getBaseContext().getTheme()));
                    UnluckyMoveButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks_pressed, getBaseContext().getTheme()));
                    flAnyMoveButton = false;
                    flUnluckyMoveButton = true;
                }

                LayoutWhichMove.setVisibility(View.GONE);
                AnotherPlayerButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks, getBaseContext().getTheme()));
                MyLastOneButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks, getBaseContext().getTheme()));
                flMyLastOne = flAnotherPlayer = noWasPressed = false;
                break;

            case R.id.noButton:
                if (flYesButton) {
                    YesButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks, getBaseContext().getTheme()));
                    flYesButton = false;
                }
                NoButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks_pressed, getBaseContext().getTheme()));
                flNoButton = true;

                noWasPressed = true;

                if (flUnluckyMoveButton) {
                    saveIndexOfButton = 2;
                    UnluckyMoveButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks, getBaseContext().getTheme()));
                    AnyMoveButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_tasks_pressed, getBaseContext().getTheme()));
                    AnyMoveButton.setEnabled(false);
                    UnluckyMoveButton.setEnabled(false);

                }

                if (flAnyMoveButton) {
                    saveIndexOfButton = 1;
                    AnyMoveButton.setEnabled(false);
                    UnluckyMoveButton.setEnabled(false);
                }

                flAnyMoveButton = true;
                flUnluckyMoveButton = false;
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

                if ((flFactor2Button && indexOfSelectedItem == -1) || (flFactor3Button && !flYesButton && !flNoButton) ||
                        (flNoButton && !flMyLastOne && !flAnotherPlayer) ||
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
                    } else {
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

                                if (EnteredResult.getText().toString().isEmpty()) {
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

                                if (EnteredResult.getText().toString().isEmpty()) {

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

                                if (EnteredResult.getText().toString().isEmpty()) {
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

                                if (EnteredResult.getText().toString().isEmpty()) {
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

                                if (EnteredResult.getText().toString().isEmpty()) {
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
                    } else {
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

                                if (EnteredResult.getText().toString().length() > 4) {
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

                                if (EnteredResult.getText().toString().length() > 4) {
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

                                if (EnteredResult.getText().toString().length() > 4) {
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

                                if (EnteredResult.getText().toString().length() > 4) {
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

                                if (EnteredResult.getText().toString().length() > 4) {
                                    Toast.makeText(this, "Число выигрыша превышает допустимое", Toast.LENGTH_SHORT).show();
                                    saveLayout = true;
                                }

                                break;
                        }
                    }
                } else {
                    final String errorText = "Ошибка: неверно введены данные";
                    if (flAnyMoveButton) {
                        if (flFactor2Button) {
                            switch (indexOfSelectedItem) {
                                case 0:
                                    OneHeapTwoAnd_PL_MU_19 obj_PL_MU = new OneHeapTwoAnd_PL_MU_19(
                                            Integer.parseInt(StoneInputField1.getText().toString()),
                                            Integer.parseInt(StoneInputField2.getText().toString()),
                                            Integer.parseInt(EnteredResult.getText().toString()));

                                    if (obj_PL_MU.getResult() == 0)
                                        ERROR = true;
                                    else
                                        Answer.setText(String.format(new Locale("ru"), "%d", obj_PL_MU.getResult()));
                                    break;

                                case 1:
                                    OneHeapTwoAnd_PL_PL_19 obj_PL_PL = new OneHeapTwoAnd_PL_PL_19(
                                            Integer.parseInt(StoneInputField1.getText().toString()),
                                            Integer.parseInt(StoneInputField2.getText().toString()),
                                            Integer.parseInt(EnteredResult.getText().toString()));

                                    if (obj_PL_PL.getResult() == 0)
                                        ERROR = true;
                                    else
                                        Answer.setText(String.format(new Locale("ru"), "%d", obj_PL_PL.getResult()));
                                    break;

                                case 2:
                                    OneHeapTwoAnd_PL_MU_MU_19 obj_PL_MU_MU = new OneHeapTwoAnd_PL_MU_MU_19(
                                            Integer.parseInt(StoneInputField1.getText().toString()),
                                            Integer.parseInt(StoneInputField2.getText().toString()),
                                            Integer.parseInt(EnteredResult.getText().toString()));

                                    if (obj_PL_MU_MU.getResult() == 0)
                                        ERROR = true;
                                    else
                                        Answer.setText(String.format(new Locale("ru"), "%d", obj_PL_MU_MU.getResult()));
                                    break;

                                case 3:
                                    OneHeapTwoAnd_PL_MU_MN_19 obj_PL_MU_MN = new OneHeapTwoAnd_PL_MU_MN_19(
                                            Integer.parseInt(StoneInputField1.getText().toString()),
                                            Integer.parseInt(StoneInputField2.getText().toString()),
                                            Integer.parseInt(FactorInputField.getText().toString()),
                                            Integer.parseInt(EnteredResult.getText().toString()));

                                    if (obj_PL_MU_MN.getResult() == 0)
                                        ERROR = true;
                                    else
                                        Answer.setText(String.format(new Locale("ru"), "%d", obj_PL_MU_MN.getResult()));
                                    break;

                                case 4:
                                    OneHeapTwoAnd_PL_MU_PL_19 obj_PL_MU_PL = new OneHeapTwoAnd_PL_MU_PL_19(
                                            Integer.parseInt(StoneInputField1.getText().toString()),
                                            Integer.parseInt(StoneInputField2.getText().toString()),
                                            Integer.parseInt(FactorInputField.getText().toString()),
                                            Integer.parseInt(EnteredResult.getText().toString()));

                                    if (obj_PL_MU_PL.getResult() == 0)
                                        ERROR = true;
                                    else
                                        Answer.setText(String.format(new Locale("ru"), "%d", obj_PL_MU_PL.getResult()));
                                    break;
                            }

                            if (ERROR) {
                                Toast.makeText(this, errorText, Toast.LENGTH_SHORT).show();
                                saveLayout = true;
                                ERROR = false;
                            } else {
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
                                LayoutMove.setVisibility(View.GONE);
                                ResultButton.setVisibility(View.GONE);
                                AnswerLayout.setVisibility(View.VISIBLE);
                                BeginFromStartButton.setVisibility(View.VISIBLE);
                            }
                        }
                        if (flFactor3Button) {
                            if (flYesButton) {
                                OneHeapThreeAnd19 obj = new OneHeapThreeAnd19(
                                        Integer.parseInt(StoneInputField1.getText().toString()),
                                        Integer.parseInt(StoneInputField2.getText().toString()),
                                        Integer.parseInt(FactorInputField.getText().toString()),
                                        Integer.parseInt(EnteredResult.getText().toString()));

                                if (obj.getResult() == 0)
                                    ERROR = true;
                                else
                                    Answer.setText(String.format(new Locale("ru"), "%d", obj.getResult()));
                            }

                            if (flNoButton && flMyLastOne) {
                                OneHeapThreeNoSameMe19 objNoSameMy = new OneHeapThreeNoSameMe19(
                                        Integer.parseInt(StoneInputField1.getText().toString()),
                                        Integer.parseInt(StoneInputField2.getText().toString()),
                                        Integer.parseInt(FactorInputField.getText().toString()),
                                        Integer.parseInt(EnteredResult.getText().toString()));

                                StringBuilder answer = new StringBuilder();
                                List<Integer> list = objNoSameMy.getResult();

                                if (list.isEmpty())
                                    ERROR = true;
                                else {
                                    for (int elem : list) answer.append(elem).append("\n\n");
                                    Answer.setText(answer);
                                }
                            }

                            if (flNoButton && flAnotherPlayer) {
                                OneHeapThreeNoSame2Player19 objNoSameSecond = new OneHeapThreeNoSame2Player19(
                                        Integer.parseInt(StoneInputField1.getText().toString()),
                                        Integer.parseInt(StoneInputField2.getText().toString()),
                                        Integer.parseInt(FactorInputField.getText().toString()),
                                        Integer.parseInt(EnteredResult.getText().toString()));

                                StringBuilder answer = new StringBuilder();
                                List<Integer> list = objNoSameSecond.getResult();

                                if (list.isEmpty())
                                    ERROR = true;
                                else {
                                    for (int elem : list) answer.append(elem).append("\n\n");
                                    Answer.setText(answer);
                                }
                            }

                            if (ERROR) {
                                Toast.makeText(this, errorText, Toast.LENGTH_SHORT).show();
                                saveLayout = true;
                                ERROR = false;
                            } else {
                                getAnswerIsSelected = true;

                                ResultButton.setVisibility(View.GONE);
                                StoneInputField1.setVisibility(View.GONE);
                                StoneInputField2.setVisibility(View.GONE);
                                FactorInputField.setVisibility(View.GONE);
                                EnteredResult.setVisibility(View.GONE);
                                CountOfHeaps1.setVisibility(View.GONE);
                                LayoutCountOfFactors.setVisibility(View.GONE);
                                LayoutMove.setVisibility(View.GONE);
                                LayoutWhichMove.setVisibility(View.GONE);
                                LayoutBranch3Factors.setVisibility(View.GONE);
                                AnswerLayout.setVisibility(View.VISIBLE);
                                BeginFromStartButton.setVisibility(View.VISIBLE);
                            }
                        }
                    }
                    if (flUnluckyMoveButton) {
                        if (flFactor2Button) {
                            switch (indexOfSelectedItem) {
                                case 0:
                                    OneHeapTwoOr_PL_MU_19 obj_PL_MU = new OneHeapTwoOr_PL_MU_19(
                                            Integer.parseInt(StoneInputField1.getText().toString()),
                                            Integer.parseInt(StoneInputField2.getText().toString()),
                                            Integer.parseInt(EnteredResult.getText().toString()));

                                    if (obj_PL_MU.getResult() == 0)
                                        ERROR = true;
                                    else
                                        Answer.setText(String.format(new Locale("ru"), "%d", obj_PL_MU.getResult()));

                                    break;

                                case 1:
                                    OneHeapTwoOr_PL_PL_19 obj_PL_PL = new OneHeapTwoOr_PL_PL_19(
                                            Integer.parseInt(StoneInputField1.getText().toString()),
                                            Integer.parseInt(StoneInputField2.getText().toString()),
                                            Integer.parseInt(EnteredResult.getText().toString()));

                                    if (obj_PL_PL.getResult() == 0)
                                        ERROR = true;
                                    else
                                        Answer.setText(String.format(new Locale("ru"), "%d", obj_PL_PL.getResult()));

                                    break;

                                case 2:
                                    OneHeapTwoOr_PL_MU_MU_19 obj_PL_MU_MU = new OneHeapTwoOr_PL_MU_MU_19(
                                            Integer.parseInt(StoneInputField1.getText().toString()),
                                            Integer.parseInt(StoneInputField2.getText().toString()),
                                            Integer.parseInt(EnteredResult.getText().toString()));

                                    if (obj_PL_MU_MU.getResult() == 0)
                                        ERROR = true;
                                    else
                                        Answer.setText(String.format(new Locale("ru"), "%d", obj_PL_MU_MU.getResult()));

                                    break;

                                case 3:
                                    OneHeapTwoOr_PL_MU_MN_19 obj_PL_MU_MN = new OneHeapTwoOr_PL_MU_MN_19(
                                            Integer.parseInt(StoneInputField1.getText().toString()),
                                            Integer.parseInt(StoneInputField2.getText().toString()),
                                            Integer.parseInt(FactorInputField.getText().toString()),
                                            Integer.parseInt(EnteredResult.getText().toString()));

                                    if (obj_PL_MU_MN.getResult() == 0)
                                        ERROR = true;
                                    else
                                        Answer.setText(String.format(new Locale("ru"), "%d", obj_PL_MU_MN.getResult()));

                                    break;

                                case 4:
                                    OneHeapTwoOr_PL_MU_PL_19 obj_PL_MU_PL = new OneHeapTwoOr_PL_MU_PL_19(
                                            Integer.parseInt(StoneInputField1.getText().toString()),
                                            Integer.parseInt(StoneInputField2.getText().toString()),
                                            Integer.parseInt(FactorInputField.getText().toString()),
                                            Integer.parseInt(EnteredResult.getText().toString()));

                                    if (obj_PL_MU_PL.getResult() == 0)
                                        ERROR = true;
                                    else
                                        Answer.setText(String.format(new Locale("ru"), "%d", obj_PL_MU_PL.getResult()));

                                    break;
                            }

                            if (ERROR) {
                                Toast.makeText(this, errorText, Toast.LENGTH_SHORT).show();
                                saveLayout = true;
                                ERROR = false;
                            } else {
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
                                LayoutMove.setVisibility(View.GONE);
                                ResultButton.setVisibility(View.GONE);
                                AnswerLayout.setVisibility(View.VISIBLE);
                                BeginFromStartButton.setVisibility(View.VISIBLE);
                            }
                        }
                        if (flFactor3Button) {
                            OneHeapThreeOr19 obj = new OneHeapThreeOr19(
                                    Integer.parseInt(StoneInputField1.getText().toString()),
                                    Integer.parseInt(StoneInputField2.getText().toString()),
                                    Integer.parseInt(FactorInputField.getText().toString()),
                                    Integer.parseInt(EnteredResult.getText().toString()));

                            if (obj.getResult() == 0)
                                ERROR = true;
                            else
                                Answer.setText(String.format(new Locale("ru"), "%d", obj.getResult()));

                            if (ERROR) {
                                Toast.makeText(this, errorText, Toast.LENGTH_SHORT).show();
                                saveLayout = true;
                                ERROR = false;
                            } else {
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
                                LayoutMove.setVisibility(View.GONE);
                                AnswerLayout.setVisibility(View.VISIBLE);
                                BeginFromStartButton.setVisibility(View.VISIBLE);
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
            } else {
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
