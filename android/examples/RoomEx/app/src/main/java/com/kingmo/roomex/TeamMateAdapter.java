package com.kingmo.roomex;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.kingmo.roomex.databinding.MateItemBinding;
import com.kingmo.roomex.viewmodel.TeamMateViewModel;

import java.util.List;

/**
 * Created by kingmo on 2/3/18.
 */

public class TeamMateAdapter extends RecyclerView.Adapter<TeamMateAdapter.MateViewHolder> {

    private List<TeamMateViewModel> mateViewModels;

    public TeamMateAdapter(@NonNull List<TeamMateViewModel> mateViewModels) {
        this.mateViewModels = mateViewModels;
    }

    @Override
    public MateViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        MateItemBinding binding = DataBindingUtil.inflate(layoutInflater,
                viewType, parent, false);

        return new MateViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(MateViewHolder holder, int position) {
        holder.bind(mateViewModels.get(position));
    }

    @Override
    public int getItemViewType(int position) {
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

    class MateViewHolder extends RecyclerView.ViewHolder {
        private final MateItemBinding binding;

        public MateViewHolder(MateItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(TeamMateViewModel mateItemViewModel) {
            binding.setVariable(BR.itemViewModel, mateItemViewModel);
            binding.executePendingBindings();
        }
    }
}
