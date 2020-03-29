package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class Chatroom extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroom);
        Bundle extras=getIntent().getExtras();
        String title=extras.getString("clickedTitle");
        TextView tv_content_info=findViewById(R.id.tv_with_name);
        tv_content_info.setText("我和"+title+"的对话");
    }
}
