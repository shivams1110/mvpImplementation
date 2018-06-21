package com.ssalphax.mvpimplementation.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ssalphax.mvpimplementation.R;
import com.ssalphax.mvpimplementation.data.model.Contact;
import com.ssalphax.mvpimplementation.ui.contacts.ContactActivity;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    private Context context;
    private List<Contact> contactList;

    public ContactAdapter(Context context, List<Contact> contactList) {
        this.contactList = contactList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_contact_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Contact c = contactList.get(position);

        holder.txtName.setText(c.getName());
        holder.txtEmail.setText(c.getEmail());
        holder.txtAddress.setText(c.getAddress());
        holder.txtGender.setText(c.getGender());

    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtName;
        public TextView txtEmail;
        public TextView txtAddress;
        public TextView txtGender;

        public ViewHolder(View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txtContactName);
            txtEmail = itemView.findViewById(R.id.txtContactEmail);
            txtAddress = itemView.findViewById(R.id.txtContactAddress);
            txtGender = itemView.findViewById(R.id.txtContactGender);

        }
    }
}
