package com.foreverrafs.starfm;

import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsDetailActivity extends AppCompatActivity {
    //TODO: use ButterKnife throughout the project
    @BindView(R.id.content)
    private TextView textContent;

    @BindView(R.id.headline)
    private TextView textTitle;

    @BindView(R.id.date)
    private TextView textDate;


    @BindView(R.id.image)
    private ImageView imageView;

    @BindView(R.id.toolbar)
    private Toolbar toolbar;

    private String content, image, title, date;

//    private String content = "", image = "", title = "", date = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        ButterKnife.bind(this);

//        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        textContent = findViewById(R.id.content);
//        textTitle = findViewById(R.id.headline);
//        textDate = findViewById(R.id.date);
//        imageView = findViewById(R.id.image);

        String[] transitions;

        if (getIntent() != null) {
            content = getIntent().getExtras().getString("content", "");
            title = getIntent().getExtras().getString("title", "");
            date = getIntent().getExtras().getString("date", "");
            image = getIntent().getExtras().getString("image", "");
            transitions = getIntent().getExtras().getStringArray("transitions");

            ViewCompat.setTransitionName(imageView, transitions[0]);
            ViewCompat.setTransitionName(textTitle, transitions[1]);
        }

        textContent.setText(Html.fromHtml(content));
        textTitle.setText(Html.fromHtml(title));
        textDate.setText("Published on " + date);

        Picasso.get().load(image).into(imageView);
    }
}