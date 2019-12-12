package com.example.mycontactlist;

import androidx.recyclerview.widget.DiffUtil;
import java.util.List;

public class MyDiffUtilCallback extends DiffUtil.Callback {

    private List<Contact> oldList;
    private List<Contact> newList;

    protected MyDiffUtilCallback(List<Contact> oldList, List<Contact> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }


    @Override
    public int getOldListSize() {
        return oldList != null ? oldList.size() : 0;
    }

    @Override
    public int getNewListSize() {
        return newList != null ? newList.size() : 0;
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return newList.get(newItemPosition) == oldList.get(oldItemPosition);
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return newList.get(newItemPosition).name.equals(oldList.get(oldItemPosition).name);
    }
}
