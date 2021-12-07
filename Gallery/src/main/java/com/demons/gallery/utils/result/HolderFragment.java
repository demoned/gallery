package com.demons.gallery.utils.result;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.demons.gallery.Gallery;
import com.demons.gallery.callback.PuzzleCallback;
import com.demons.gallery.callback.SelectCallback;
import com.demons.gallery.engine.ImageEngine;
import com.demons.gallery.models.album.entity.Photo;
import com.demons.gallery.ui.PhotosActivity;
import com.demons.gallery.ui.PuzzleActivity;

import java.util.ArrayList;

public class HolderFragment extends Fragment {

    private static final int HOLDER_SELECT_REQUEST_CODE = 0x44;
    private static final int HOLDER_PUZZLE_REQUEST_CODE = 0x55;
    private SelectCallback mSelectCallback;
    private PuzzleCallback mPuzzleCallback;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public void startEasyPhoto(SelectCallback callback) {
        mSelectCallback = callback;
        PhotosActivity.start(this, HOLDER_SELECT_REQUEST_CODE);
    }

    public void startPuzzleWithPhotos(ArrayList<Photo> photos, String puzzleSaveDirPath, String puzzleSaveNamePrefix, boolean replaceCustom, @NonNull ImageEngine imageEngine, PuzzleCallback callback) {
        mPuzzleCallback = callback;
        PuzzleActivity.startWithPhotos(this, photos, puzzleSaveDirPath, puzzleSaveNamePrefix, HOLDER_PUZZLE_REQUEST_CODE, replaceCustom, imageEngine);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (Activity.RESULT_OK == resultCode) {
            switch (requestCode) {
                case HOLDER_SELECT_REQUEST_CODE:
                    if (mSelectCallback != null) {
                        ArrayList<Photo> resultPhotos = data.getParcelableArrayListExtra(Gallery.RESULT_PHOTOS);
                        boolean selectedOriginal = data.getBooleanExtra(Gallery.RESULT_SELECTED_ORIGINAL, false);
                        mSelectCallback.onResult(resultPhotos,  selectedOriginal);
                    }
                    break;
                case HOLDER_PUZZLE_REQUEST_CODE:
                    if (mPuzzleCallback != null) {
                        Photo puzzlePhoto = data.getParcelableExtra(Gallery.RESULT_PHOTOS);
                        mPuzzleCallback.onResult(puzzlePhoto);
                    }
                    break;
            }
            return;
        }
        if (Activity.RESULT_CANCELED == resultCode) {
            switch (requestCode) {
                case HOLDER_SELECT_REQUEST_CODE:
                    if (mSelectCallback != null) {
                        mSelectCallback.onCancel();
                    }
                    break;
                case HOLDER_PUZZLE_REQUEST_CODE:
                    if (mPuzzleCallback != null) {
                        mPuzzleCallback.onCancel();
                    }
                    break;
            }
        }
    }
}
