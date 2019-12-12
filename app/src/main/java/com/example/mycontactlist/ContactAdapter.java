package com.example.mycontactlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    private List<Contact> contacts;

    @NonNull
    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_contact_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ViewHolder holder, int position) {
        holder.bind(contacts.get(position));
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    protected void insertNewContact(List<Contact> insertContacts) {
        MyDiffUtilCallback myDiffutilCallback = new MyDiffUtilCallback(contacts, insertContacts);
        DiffUtil.DiffResult diffResult =  DiffUtil.calculateDiff(myDiffutilCallback);

        contacts.addAll(insertContacts);
        diffResult.dispatchUpdatesTo(this);
    }

    protected void deleteContact(List<Contact> deleteContacts) {
        MyDiffUtilCallback myDiffutilCallback = new MyDiffUtilCallback(contacts, deleteContacts);
        DiffUtil.DiffResult diffResult =  DiffUtil.calculateDiff(myDiffutilCallback);

        contacts.clear();
        contacts.addAll(deleteContacts);
        diffResult.dispatchUpdatesTo(this);
    }

    protected void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
        notifyDataSetChanged();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {

        private TextView contactName;
        private TextView contactPhoneNumber;

        private ViewHolder(@NonNull View itemView) {
            super(itemView);

            contactName = itemView.findViewById(R.id.contact_name);
            contactPhoneNumber = itemView.findViewById(R.id.contact_phone_number);

        }

        private void bind(Contact contact) {
            contactName.setText(contact.name);
            contactPhoneNumber.setText(contact.phoneNumber);
        }
    }
}
