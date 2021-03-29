package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Locale;

import static android.speech.tts.TextToSpeech.ERROR;
import static android.speech.tts.TextToSpeech.QUEUE_FLUSH;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.viewholder> {
    public static TextToSpeech mtts;
    private  ArrayList<Text> list;
    private Context context;
    //constructor
    public MyAdapter(ArrayList<Text> list, FragmentActivity context) {
        this.list = list;
        this.context = context;
        if(mtts==null)
        init(context);
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_number, parent, false);
        return new viewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        holder.getNumspell().setText(list.get(position).getSpell());
        holder.getNumimage().setImageResource(list.get(position).getId());
        holder.getPlayButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mtts.speak(list.get(position).getSpell(),QUEUE_FLUSH,null,"word");
            }
        });

    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    static public class viewholder extends RecyclerView.ViewHolder {
        private final TextView numSpell;
        private final ImageView numImage;
        private final ImageButton playButton;
        //getters
        public TextView getNumspell() { return numSpell; }
        public ImageView getNumimage() {
            return numImage;
        }
        public ImageButton getPlayButton() {
            return playButton;
        }

        public viewholder(@NonNull View itemView) {
            super(itemView);
            numSpell= itemView.findViewById(R.id.spelling);
            numImage= itemView.findViewById(R.id.image);
            playButton= itemView.findViewById(R.id.playbutton);
        }

    }
    //initializing tts
    public static void init(Context context){
        mtts=new TextToSpeech(context, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status!=ERROR)
                {


                    int res=mtts.setLanguage(new Locale("en","IN"));
                    Toast.makeText(context,"Resources ready",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(context,status+":status",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
