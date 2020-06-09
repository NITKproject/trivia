package com.example.trivia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class y extends AppCompatActivity {
    Button exity;


    ImageButton next;
    ImageButton previous;
    TextView questions;
    TextView atext,btext,ctext,dtext;
    ImageButton abutton,bbutton,cbutton,dbutton;
    TextView scorex;

    int count=-1;
    int QuestionNnumber;
    int p=0;
    Integer score=0;
    Random random=new Random();
    Handler handler=new Handler();

    yquestions[] questionBanky=new yquestions[]{
            new yquestions(R.string.y1,"a"),
            new yquestions(R.string.y2,"c"),
            new yquestions(R.string.y3,"b"),
            new yquestions(R.string.y4,"c"),
            new yquestions(R.string.y5,"d"),
            new yquestions(R.string.y6,"a"),
            new yquestions(R.string.y7,"c"),
            new yquestions(R.string.y8,"b"),
            new yquestions(R.string.y9,"c"),
            new yquestions(R.string.y10,"d"),

    };

    String[] a=new String[]{
            "Kamaljit Sandhu","2 minutes","1932","1975","Subash Agarwal","1951","West Bengal","Nepal","Delhi","Wrestling"
    };
    String[] b=new String[]{
            "P.T.Usha","1 minute","1928","1955","Ashol Shandiliya","1963","Rajasthan","Yorkshire","Mumbai","Archery"
    };
    String[] c=new String[]{
            "M.L.Valsamma","45 seconds","1948","1957","Manoj Kolhari","1982","Manipur","Sri Lanka","Ahemdabad","Swimming"
    };
    String[] d=new String[]{
            "K.Malleshwari","25 seconds","1936","1950","Mihir Sen","1971","Kerala","West Indies","Kolkata","Tennis"
    };

    int[] numbers=new int[]{0,1,2,3,4,5,6,7,8,9};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_y);

        exity=findViewById(R.id.exity);
        next=findViewById(R.id.nexty);
        previous=findViewById(R.id.previousy);
        questions=findViewById(R.id.textViewy);
        atext=findViewById(R.id.atexty);
        btext=findViewById(R.id.btexty);
        ctext=findViewById(R.id.ctexty);
        dtext=findViewById(R.id.dtexty);
        abutton=findViewById(R.id.abuttony);
        bbutton=findViewById(R.id.bbuttony);
        cbutton=findViewById(R.id.cbuttony);
        dbutton=findViewById(R.id.dbuttony);
        scorex=findViewById(R.id.scorey);

        shuffle(numbers);





        exity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(y.this ,MainActivity.class);
                startActivity(intent);
            }
        });

        abutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count!=-1) {


                    checkanswer("a");
                }
                else
                    questions.setText("Press next or exit to continue");




            }
        });
        bbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count!=-1) {

                    checkanswer("b");

                }
                else
                    questions.setText("Press next or exit to continue");

            }
        });
        cbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count!=-1) {
                    checkanswer("c");
                }
                else
                    questions.setText("Press next or exit to continue");

            }
        });
        dbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count!=-1) {
                    checkanswer("d");

                }
                else
                    questions.setText("Press Next or Exit to continue");
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateQuestion();
            }
        });
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count=count-1;
                QuestionNnumber=p;
                if(count==-2)

                {
                    questions.setText("Press next or exit to continue");
                    atext.setText(" ");
                    btext.setText("");
                    ctext.setText(" ");
                    dtext.setText("");
                }
                else
                {
                    questions.setText(questionBanky[QuestionNnumber].getQuestionId());
                    atext.setText(a[QuestionNnumber]);
                    btext.setText(b[QuestionNnumber]);
                    ctext.setText(c[QuestionNnumber]);
                    dtext.setText(d[QuestionNnumber]);
                }
            }
        });

    }

    public void checkanswer(String Answer){
        String actualAnswer=questionBanky[QuestionNnumber].getAnswer();
        int toast=0;
        if(Answer==actualAnswer){
            toast=R.string.correct;
            score=score+1;
            scorex.setText(score.toString());
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    updateQuestion();
                }
            },1200);


        }
        else{
            // shake_animation();
            toast=R.string.wrong;
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    updateQuestion();
                }
            },1200);
        }
        Toast.makeText(y.this, toast, Toast.LENGTH_SHORT).show();


    }
    public int[] shuffle(int[] num){
        int temp;
        int a1;
        //int a2=random.nextInt(10);

        for (int i=0;i<3;i++)
        {
            a1=random.nextInt(10);

            temp=num[a1];
            num[a1]=num[9-a1];
            num[9-a1]=temp;}

        // if(a1!=a2) {
        //  temp = num[a2];
        // num[a2] = num[9 - a2];
        // num[9 - a2] = temp;


        return num;

    }
    public void updateQuestion(){
        count = count + 1;
        p=QuestionNnumber;

        if (count == 10) {
            questions.setText("Game over...\n Your score is " + score.toString());
            atext.setText(" ");
            btext.setText("");
            ctext.setText(" ");
            dtext.setText("");
        } else {
            QuestionNnumber=numbers[count];

            questions.setText(questionBanky[QuestionNnumber].getQuestionId());
            atext.setText(a[QuestionNnumber]);
            btext.setText(b[QuestionNnumber]);
            ctext.setText(c[QuestionNnumber]);
            dtext.setText(d[QuestionNnumber]);

        }
    }

}

