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

public class z extends AppCompatActivity {
    Button exit;
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

    zquestions[] questionBankz=new zquestions[]{
            new zquestions(R.string.z1,"a"),
            new zquestions(R.string.z2,"c"),
            new zquestions(R.string.z3,"b"),
            new zquestions(R.string.z4,"c"),
            new zquestions(R.string.z5,"d"),
            new zquestions(R.string.z6,"a"),
            new zquestions(R.string.z7,"c"),
            new zquestions(R.string.z8,"b"),
            new zquestions(R.string.z9,"c"),
            new zquestions(R.string.z10,"d"),

    };

    String[] a=new String[]{
            "Active transport","II and III are correct","Urea","Protection of organs","Zone of elongation","Mitosis","Whales","Nucleolus","Yellow light","Mendeleev"
    };
    String[] b=new String[]{
            "Osmosis","II and IV are correct","Free nitrgen","Producing blood corpuscles","Growing point","Heterosis","Kangaroes","All of these","Red light","Rudolf Virchow"
    };
    String[] c=new String[]{
            "Diffusion","I and II are correct","Ammonia","Secretion of hormones","Embryonic zone","Fusion","Dolphins","Nucleur Membrane","White light","Robert Hooke"
    };
    String[] d=new String[]{
            "Passive transport","IV and I are correct","Proteins","Place for muscle attachment","Root hairs","None of these","Elephants","Organelle membrane","Darkness","Robert Brown"
    };

    int[] numbers=new int[]{0,1,2,3,4,5,6,7,8,9};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_z);

        exit=findViewById(R.id.exitz);
        next=findViewById(R.id.nextz);
        previous=findViewById(R.id.previousz);
        questions=findViewById(R.id.textViewz);
        atext=findViewById(R.id.atextz);
        btext=findViewById(R.id.btextz);
        ctext=findViewById(R.id.ctextz);
        dtext=findViewById(R.id.dtextz);
        abutton=findViewById(R.id.abuttonz);
        bbutton=findViewById(R.id.bbuttonz);
        cbutton=findViewById(R.id.cbuttonz);
        dbutton=findViewById(R.id.dbuttonz);
        scorex=findViewById(R.id.scorez);

        shuffle(numbers);





        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(z.this ,MainActivity.class);
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
                    questions.setText(questionBankz[QuestionNnumber].getQuestionId());
                    atext.setText(a[QuestionNnumber]);
                    btext.setText(b[QuestionNnumber]);
                    ctext.setText(c[QuestionNnumber]);
                    dtext.setText(d[QuestionNnumber]);
                }
            }
        });

    }

    public void checkanswer(String Answer){
        String actualAnswer=questionBankz[QuestionNnumber].getAnswer();
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
        Toast.makeText(z.this, toast, Toast.LENGTH_SHORT).show();


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

            questions.setText(questionBankz[QuestionNnumber].getQuestionId());
            atext.setText(a[QuestionNnumber]);
            btext.setText(b[QuestionNnumber]);
            ctext.setText(c[QuestionNnumber]);
            dtext.setText(d[QuestionNnumber]);

        }
    }

}

