package ma.library_apps.tic_tac_toc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button[] btn = new Button[9];
    Button btn1 ,btn2 ;
    String[][] Tab = new String[3][3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn[0] = (Button) findViewById(R.id.b1);
        btn[1] = (Button) findViewById(R.id.b2);
        btn[2] = (Button) findViewById(R.id.b3);
        btn[3] = (Button) findViewById(R.id.b4);
        btn[4] = (Button) findViewById(R.id.b5);
        btn[5] = (Button) findViewById(R.id.b6);
        btn[6] = (Button) findViewById(R.id.b7);
        btn[7] = (Button) findViewById(R.id.b8);
        btn[8] = (Button) findViewById(R.id.b9);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        Intialise();

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intialise();
            }
        });

        btn[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Jouer(btn[0],0,0);
            }
        });

        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Jouer(btn[1],0,1);
            }
        });


        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Jouer(btn[2],0,2);
            }
        });


        btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Jouer(btn[3],1,0);
            }
        });

        btn[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Jouer(btn[4],1,1);
            }
        });

        btn[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Jouer(btn[5],1,2);
            }
        });

        btn[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Jouer(btn[6],2,0);
            }
        });

        btn[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Jouer(btn[7],2,1);
            }
        });

        btn[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Jouer(btn[8],2,2);
            }
        });
    }

    void Intialise(){
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) Tab[i][j]="";
        }
        for(int i=0 ; i<9;i++) btn[i].setText("");
    }

    int Gagne(){
        int Rst=-1;
        String lig="" , col="" , diag1=""  , diag2="" ;
        for(int i=0;i<3;i++) {
            lig="" ;
            col="";
            for(int j=0;j<3;j++)
            {
                lig+= Tab[i][j];
                col+= Tab[j][i];
            }
            diag1+= Tab[i][i];
            diag2+= Tab[i][2-i];
            if( lig.equals("XXX") || col.equals("XXX")) Rst=1;
            if( lig.equals("OOO") || col.equals("OOO")) Rst=2;
        }
        if( diag1.equals("XXX") || diag2.equals("XXX")) Rst=1;
        if( diag1.equals("OOO") || diag2.equals("OOO")) Rst=2;
        return Rst;
    }
    boolean terminer(){
        boolean b =true;
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++){
                if(Tab[i][j].equals("")) b=false;
            }
        }
        return b;
    }
    int MAC(){
        int x=-1;
        do{
            x=(int)Math.floor(Math.random()*9);
        }while(!btn[x].getText().equals(""));
        return x;
    }
    void Jouer(Button b , int x , int y) {
        b.setText("X");
        Tab[x][y] = "X";
        if (Gagne() == 1)
            Toast.makeText(MainActivity.this, "Joueur gagne", Toast.LENGTH_LONG).show();
        if (terminer() && Gagne() == -1)
            Toast.makeText(MainActivity.this, "Partie nulle", Toast.LENGTH_LONG).show();
        if (terminer() == false && Gagne() == -1) {
            btn[MAC()].setText("O");
            Tab[MAC() % 3][MAC() / 3] = "O";
            if (Gagne() == 2)
                Toast.makeText(MainActivity.this, "Machine gagne", Toast.LENGTH_LONG).show();
            if (terminer() && Gagne() == -1)
                Toast.makeText(MainActivity.this, "Partie nulle", Toast.LENGTH_LONG).show();
        }
    }
}