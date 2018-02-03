package com.kingmo.roomex.view;

import android.support.annotation.NonNull;
import com.kingmo.roomex.R;
import com.kingmo.roomex.viewmodel.TeamMateViewModel;

import java.util.List;

/**
 * Created by kingmo on 2/3/18.
 */

public class TeamMateAdapter extends BaseRecyclerAdapter {

    private List<TeamMateViewModel> mateViewModels;

    public TeamMateAdapter(@NonNull List<TeamMateViewModel> mateViewModels) {
        this.mateViewModels = mateViewModels;
    }

    @Override
    protected Object getViewModel(int position) {
        return mateViewModels.get(position);
    }

    @Override
    protected int getLayoutIdForPosition(int position) {
        return R.layout.mate_item;
    }

    @Override
    public int getItemCount() {
        return mateViewModels.size();
    }

    public void updateData(List<TeamMateViewModel> viewModels) {
        this.mateViewModels = viewModels;
        notifyDataSetChanged();
    }
}
