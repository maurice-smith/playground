package com.kingmo.roomex.view;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.android.databinding.library.baseAdapters.BR;

/**
 * Created by kingmo on 2/3/18.
 */
public abstract class BaseRecyclerAdapter
        extends RecyclerView.Adapter<BaseRecyclerAdapter.BaseViewHolder> {

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(
                layoutInflater, viewType, parent, false);

        return new BaseViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.bind(getViewModel(position));
    }

    @Override
    public int getItemViewType(int position) {
        return getLayoutIdForPosition(position);
    }

    protected abstract Object getViewModel(int position);

    protected abstract @LayoutRes int getLayoutIdForPosition(int position);

    public class BaseViewHolder extends RecyclerView.ViewHolder {
        private final ViewDataBinding binding;

        public BaseViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Object viewModel) {
            binding.setVariable(BR.itemViewModel, viewModel);
            binding.executePendingBindings();
        }
    }
}
