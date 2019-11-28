package com.example.customsnackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    public Button grootButton;
    public Button spidermanButton;
    public Button deadpoolButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grootButton = findViewById(R.id.groot_button);
        spidermanButton = findViewById(R.id.spiderman_button);
        deadpoolButton = findViewById(R.id.deadpool_button);

        grootButton.setOnClickListener(new GrootButtonHandler());
        spidermanButton.setOnClickListener(new SpidermanButtonHandler());
        deadpoolButton.setOnClickListener(new DeadpoolButtonHandler());


    }

    private Snackbar createCustomSnackbar(View view, CharSequence message, Drawable drawable){
        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT);
        Snackbar.SnackbarLayout layout = (Snackbar.SnackbarLayout) snackbar.getView();

        TextView textView = layout.findViewById(R.id.snackbar_text);
        textView.setVisibility(View.INVISIBLE);
        layout.setBackgroundColor(Color.WHITE);

        View snackView = getLayoutInflater().inflate(R.layout.snack_view, null);

        ImageView avatarImage = snackView.findViewById(R.id.avatar_image);
        avatarImage.setImageDrawable(drawable);

        TextView messageView = snackView.findViewById(R.id.message_view);
        messageView.setText(message);
        messageView.setTextColor(Color.WHITE);

        layout.addView(snackView, 0);
        return snackbar;
    }

    private class GrootButtonHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            createCustomSnackbar(v,
                    "I AM GROOT!",
                    getResources().getDrawable(R.drawable.groot)).show();
        }
    }

    private class SpidermanButtonHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            createCustomSnackbar(v,
                    "With great power comes great responsibility",
                    getResources().getDrawable(R.drawable.spiderman)).show();
        }
    }

    private class DeadpoolButtonHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            createCustomSnackbar(v,
                    "Sorry, I use humor to deflect my insecurities. Plus, I’m hilarious, so don’t hate.",
                    getResources().getDrawable(R.drawable.deadpool)).show();
        }
    }



}
