package com.example.myapplication.ui.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;

import static com.example.myapplication.MyAdapter.mtts;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link tts#newInstance} factory method to
 * create an instance of this fragment.
 */
public class tts extends Fragment {
    // TODO: Rename and change types and number of parameters
    public static tts newInstance() {
        tts fragment = new tts();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_tts, container, false);
        EditText word= view.findViewById(R.id.word);
        Button speak = view.findViewById(R.id.speak);
        speak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String wordtospeak=word.getText().toString();
                if(!wordtospeak.equals(""))
                mtts.speak(wordtospeak,0,null,"word");
                else
                    Toast.makeText(getContext(),"enter text",Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}