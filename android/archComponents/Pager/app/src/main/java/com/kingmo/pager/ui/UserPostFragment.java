package com.kingmo.pager.ui;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kingmo.pager.R;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UserPostFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserPostFragment extends Fragment {
    public static final String TAG = UserPostFragment.class.getSimpleName();
    private static final String ARG_USER_POST = TAG + ".USER_POST";

    private PostViewModel postViewModel;

    public UserPostFragment() {
    }

    public static UserPostFragment newInstance(PostViewModel postViewModel) {
        UserPostFragment fragment = new UserPostFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_USER_POST, postViewModel);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setPostViewModel();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragView = inflater.inflate(R.layout.fragment_post, container, false);

        TextView postId = fragView.findViewById(R.id.postId);
        TextView userId = fragView.findViewById(R.id.userId);
        TextView title = fragView.findViewById(R.id.title);
        TextView body = fragView.findViewById(R.id.body);

        postId.setText(postViewModel.getIdText());
        userId.setText(postViewModel.getUserIdText());
        title.setText(postViewModel.getTitle());
        body.setText(postViewModel.getBody());

        return fragView;
    }

    private void setPostViewModel() {
        if (getArguments() != null) {
            postViewModel = getArguments().getParcelable(ARG_USER_POST);
        } else {
            postViewModel = new PostViewModel(-1, -1,
                    getString(R.string.post_error_title),
                    getString(R.string.post_error_body));
        }
        postViewModel.setResources(getResources());
    }

}
