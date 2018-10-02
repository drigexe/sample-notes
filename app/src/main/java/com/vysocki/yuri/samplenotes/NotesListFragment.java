package com.vysocki.yuri.samplenotes;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class NotesListFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notes_list, container, false);
        Log.d("fragment", "NoteListCreateView");
        Button button = view.findViewById(R.id.buttonTest);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment noteDetailFragment = new NoteDetailFragment();
                ((MainActivity)getActivity()).setFragment(noteDetailFragment, MainActivity.FRAGMENT_CONTAINER_ID, true);
            }
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("fragment", "NoteListOnStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("fragment", "NoteListOnResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("fragment", "NoteListOnPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("fragment", "NoteListOnStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("fragment", "NoteListOnDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("fragment", "NoteListOnDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("fragment", "NoteListOnDetach");
    }

}
