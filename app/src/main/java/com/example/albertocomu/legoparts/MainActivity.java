package com.example.albertocomu.legoparts;
// c7f6089a753a4a02f32023104f44e794
// stucom.flx.cat/lego/get_set_parts.php?key=c7f6089a753a4a02f32023104f44e794&set=60128-1
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    protected EditText code;
    protected Button boton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        code = (EditText) findViewById(R.id.editText);
        boton1 = (Button) findViewById(R.id.button);
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                String codigo = code.getText().toString();
                intent.putExtra("codigo", codigo);
                startActivity(intent);
            }
        });

    }
}
