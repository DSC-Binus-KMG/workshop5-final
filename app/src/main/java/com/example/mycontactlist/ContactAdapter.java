package com.example.mycontactlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    private List<Contact> contacts;
    private static final int VIEWHOLDER_NOT_FAVORITE = 0;
    private static final int VIEWHOLDER_FAVORITE = 1;

    public ContactAdapter() {
        contacts = new ArrayList<>();
    }

    @NonNull
    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ViewHolder viewHolder = null;
        View view;

        switch (viewType)
        {
            case VIEWHOLDER_NOT_FAVORITE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_contact_not_favorite, parent,false);;
                viewHolder = new NotFavoriteViewHolder(view);
                break;
            case VIEWHOLDER_FAVORITE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_contact_favorite, parent,false);;
                viewHolder = new FavoriteViewHolder(view);
                break;
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ViewHolder holder, int position) {
        holder.bind(contacts.get(position));
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    @Override
    public int getItemViewType(int position) {
        return contacts.get(position).isFavorite() ? VIEWHOLDER_FAVORITE : VIEWHOLDER_NOT_FAVORITE;
    }

    protected void insertNewContact(List<Contact> insertContacts) {
        MyDiffUtilCallback myDiffutilCallback = new MyDiffUtilCallback(contacts, insertContacts);
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(myDiffutilCallback);

        contacts.addAll(insertContacts);
        diffResult.dispatchUpdatesTo(this);
    }

    protected void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
        notifyDataSetChanged();
    }

    protected abstract class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {super(itemView); }

        protected abstract void bind(Contact contact);
    }

    public class FavoriteViewHolder extends ViewHolder {

        private TextView contactName;
        private TextView contactPhoneNumber;

        public FavoriteViewHolder(@NonNull View itemView) {
            super(itemView);
            contactName = itemView.findViewById(R.id.contact_name);
            contactPhoneNumber = itemView.findViewById(R.id.contact_phone_number);
        }

        @Override
        protected void bind(Contact contact) {
            contactName.setText(contact.name);
            contactPhoneNumber.setText(contact.phoneNumber);
        }

    }

    public class NotFavoriteViewHolder extends ViewHolder {

        private TextView contactName;
        private TextView contactPhoneNumber;

        public NotFavoriteViewHolder(@NonNull View itemView) {
            super(itemView);
            contactName = itemView.findViewById(R.id.contact_name);
            contactPhoneNumber = itemView.findViewById(R.id.contact_phone_number);
        }

        @Override
        protected void bind(Contact contact) {
            contactName.setText(contact.name);
            contactPhoneNumber.setText(contact.phoneNumber);
        }

    }
}
