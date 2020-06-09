package com.example.trivia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class x extends AppCompatActivity {
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

    xquestions[] questionBankx=new xquestions[]{
            new xquestions(R.string.x1,"a"),
            new xquestions(R.string.x2,"c"),
            new xquestions(R.string.x3,"b"),
            new xquestions(R.string.x4,"c"),
            new xquestions(R.string.x5,"d"),
            new xquestions(R.string.x6,"a"),
            new xquestions(R.string.x7,"c"),
            new xquestions(R.string.x8,"b"),
            new xquestions(R.string.x9,"c"),
            new xquestions(R.string.x10,"d"),

    };

    String[] a=new String[]{
            "Jean","O Henry","Gore Vidal","Robert Geller","Tulips","Robert Frost","Roald Dahl","Tapesh Babu","Music","Antonio"
    };
    String[] b=new String[]{
            "Bilius","F.Scott Fitzgerald","Rabindranath Tagore","Robert Baldacci","A Tear and A Smile","Oscar Wilde","Rabindranath Tagore","Pradosh C Mittar","Alcohol","Bassanio"
    };
    String[] c=new String[]{
            "Mildred","Oscar Wilde","Voltaire","Robert Galbraith","Whisper","Sylvia Plath","Ruskin Bond","Laxman G Bhatt","Books","Gratiano"
    };
    String[] d=new String[]{
            "Leanne","Mary Shelly","Mahatma Gandhi","Robert Baratheon","Annabelle Lee","Edgar Allen Poe","Arundhati Roy","Aniruddh Ghosh","Dance","Portia"
    };

    int[] numbers=new int[]{0,1,2,3,4,5,6,7,8,9};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_x);

        exit=findViewById(R.id.exitx);
        next=findViewById(R.id.next);
        previous=findViewById(R.id.previous);
        questions=findViewById(R.id.textViewx);
        atext=findViewById(R.id.atext);
        btext=findViewById(R.id.btext);
        ctext=findViewById(R.id.ctext);
        dtext=findViewById(R.id.dtext);
        abutton=findViewById(R.id.abutton);
        bbutton=findViewById(R.id.bbutton);
        cbutton=findViewById(R.id.cbutton);
        dbutton=findViewById(R.id.dbutton);
        scorex=findViewById(R.id.score);

        shuffle(numbers);





        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(x.this ,MainActivity.class);
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
                    questions.setText(questionBankx[QuestionNnumber].getQuestionId());
                    atext.setText(a[QuestionNnumber]);
                    btext.setText(b[QuestionNnumber]);
                    ctext.setText(c[QuestionNnumber]);
                    dtext.setText(d[QuestionNnumber]);
                }
            }
        });

    }

    public void checkanswer(String Answer){
        String actualAnswer=questionBankx[QuestionNnumber].getAnswer();
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
        Toast.makeText(x.this, toast, Toast.LENGTH_SHORT).show();


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

             questions.setText(questionBankx[QuestionNnumber].getQuestionId());
             atext.setText(a[QuestionNnumber]);
             btext.setText(b[QuestionNnumber]);
             ctext.setText(c[QuestionNnumber]);
             dtext.setText(d[QuestionNnumber]);

         }
     }



    //private void shake_animation(){
        //Animation shake= AnimationUtils.loadAnimation(x.this,R.anim.anim_shake);
       // questions.setAnimation(shake);
    //}




    }

