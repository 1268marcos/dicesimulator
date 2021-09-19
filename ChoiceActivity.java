package com.example.dicesimulator2021;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.chip.ChipGroup;

import java.util.Random;

public class ChoiceActivity extends AppCompatActivity {

    private Random rnd = new Random();
    private String mMessageDisplay;

    private ChipGroup mChipGroupOption;
    private int mChipSelected = 0;

    private Button mButtonStart;

    private TextView mTextViewDice;

    private ImageView mImageViewDice;

    private void showResult(int value){
        mMessageDisplay = "Acertou com a sua escolha do " + value;
        if( value != mChipSelected ) {
            mMessageDisplay = "Ops! Não foi dessa vez";
        }
        Toast.makeText(this, mMessageDisplay, Toast.LENGTH_SHORT).show();
    }

    public class FilterChipSelectedInTheGroup implements ChipGroup.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged(ChipGroup group, int checkedId) {
           switch (group.getCheckedChipId()) {
               case R.id.chip1: mChipSelected=1; break;
               case R.id.chip2: mChipSelected=2; break;
               case R.id.chip3: mChipSelected=3; break;
               case R.id.chip4: mChipSelected=4; break;
               case R.id.chip5: mChipSelected=5; break;
               case R.id.chip6: mChipSelected=6; break;
           }
        }
    }

    private void showImage(int value){
        switch (value) {
            case 1: mImageViewDice.setImageResource(R.drawable.dice1); break;
            case 2: mImageViewDice.setImageResource(R.drawable.dice2); break;
            case 3: mImageViewDice.setImageResource(R.drawable.dice3); break;
            case 4: mImageViewDice.setImageResource(R.drawable.dice4); break;
            case 5: mImageViewDice.setImageResource(R.drawable.dice5); break;
            case 6: mImageViewDice.setImageResource(R.drawable.dice6); break;
        }
    }

    private void launchDice(){
        int number = rnd.nextInt(6) + 1;
        mTextViewDice.setText("" + number);
        showImage(number);
        showResult(number);
    }

    public class ClickStarPlay implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            launchDice();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        mChipGroupOption = findViewById(R.id.chipGroup_option);
        mChipGroupOption.setOnCheckedChangeListener(new FilterChipSelectedInTheGroup());

        mButtonStart = findViewById(R.id.button_start);
        mButtonStart.setOnClickListener(new ClickStarPlay());

        mImageViewDice = findViewById(R.id.imageView_dice);
        mImageViewDice.setOnClickListener(new ClickStarPlay());

        mTextViewDice = findViewById(R.id.textView_dice_value);

    }

}
