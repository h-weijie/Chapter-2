package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 作业2：一个抖音笔试题：统计页面所有view的个数
 * Tips：ViewGroup有两个API
 * {@link android.view.ViewGroup #getChildAt(int) #getChildCount()}
 * 用一个TextView展示出来
 */
public class Exercises2 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise2);
        int num=getAllChildViewCount(((ViewGroup)findViewById(android.R.id.content)).getChildAt(0));
        TextView tv_center=findViewById(R.id.tv_center);
        tv_center.setText(""+num);
    }

    public int getAllChildViewCount(View view) {
        //todo 补全你的代码
        if(view instanceof ViewGroup){   //中间结点viewgroup
            ViewGroup vg=(ViewGroup) view;
            int childNum=vg.getChildCount();
            int sum=0;
            for(int i=0;i<childNum;i++){
                sum+=getAllChildViewCount(vg.getChildAt(i));
            }
            return sum;
        }else{
            return 1;
        }
    }

}
