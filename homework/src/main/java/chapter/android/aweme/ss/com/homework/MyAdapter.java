package chapter.android.aweme.ss.com.homework;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import chapter.android.aweme.ss.com.homework.model.Message;
import chapter.android.aweme.ss.com.homework.widget.CircleImageView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<Message> items;
    private final MyItemClickListener myItemClickListener;

    public MyAdapter(List<Message> messages,MyItemClickListener listener){
        items=messages;
        myItemClickListener=listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.im_list_item,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.bind(items.get(i));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final CircleImageView iv_avatar;
        private final ImageView robot_notice;
        private final TextView tv_title;
        private final TextView tv_description;
        private final TextView tv_time;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_avatar=itemView.findViewById(R.id.iv_avatar);
            robot_notice=itemView.findViewById(R.id.robot_notice);
            tv_title=itemView.findViewById(R.id.tv_title);
            tv_description=itemView.findViewById(R.id.tv_description);
            tv_time=itemView.findViewById(R.id.tv_time);
            itemView.setOnClickListener(this);
        }

        public void bind(Message item){
            String icon=item.getIcon();
            if(icon.equals("TYPE_ROBOT")){
                iv_avatar.setImageResource(R.drawable.session_robot);
            }else if(icon.equals("TYPE_GAME")){
                iv_avatar.setImageResource(R.drawable.icon_micro_game_comment);
            }else if(icon.equals("TYPE_SYSTEM")){
                iv_avatar.setImageResource(R.drawable.session_system_notice);
            }else if(icon.equals("TYPE_STRANGER")){
                iv_avatar.setImageResource(R.drawable.session_stranger);
            }else{
                iv_avatar.setImageResource(R.drawable.icon_girl);
            }

            if(item.isOfficial()){
                robot_notice.setVisibility(View.VISIBLE);
            }else{
                robot_notice.setVisibility(View.INVISIBLE);
            }
            tv_title.setText(item.getTitle());
            tv_description.setText(item.getDescription());
            tv_time.setText(item.getTime());
        }

        @Override
        public void onClick(View view) {
            if(myItemClickListener!=null){
                String clickedTitle=tv_title.getText().toString();
                myItemClickListener.onItemClick(clickedTitle);
            }
        }
    }

    public interface MyItemClickListener{
        void onItemClick(String title);
    }
}
