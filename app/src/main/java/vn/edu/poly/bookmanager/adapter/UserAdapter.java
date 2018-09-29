package vn.edu.poly.bookmanager.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import vn.edu.poly.bookmanager.R;
import vn.edu.poly.bookmanager.activity.ChangePasswordActivity;
import vn.edu.poly.bookmanager.activity.EditUserActivity;
import vn.edu.poly.bookmanager.activity.UserManagerActivity;
import vn.edu.poly.bookmanager.database.DatabaseHelper;
import vn.edu.poly.bookmanager.model.User;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder>{
    private Context context;
    DatabaseHelper databaseHelper;
    List<User> list;

    public UserAdapter(Context context, List<User> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.item_user,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        databaseHelper=new DatabaseHelper(context);
       final User user=list.get(position);
        holder.ten.setText(user.getUser_name());
        holder.phone.setText(user.getPhone_number());
        holder.line.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(holder.ten.getText().toString().matches("adimin")){
                    Toast.makeText(context, "Bạn không có quyền xóa tài khoản admin", Toast.LENGTH_SHORT).show();
                }else {
                databaseHelper.deleteUser(holder.ten.getText().toString());
                list.remove(user);}
                notifyDataSetChanged();
                return false;
            }
        });
        holder.iconSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,EditUserActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("username",holder.ten.getText().toString());
                intent.putExtra("key",bundle);
                context.startActivity(intent);
            }
        });
        holder.iconchangepassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,ChangePasswordActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("username",holder.ten.getText().toString());
                intent.putExtra("key",bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public  class ViewHolder extends RecyclerView.ViewHolder{
        private CardView line;
        private TextView ten,phone;
        private ImageView iconSua,iconchangepassword;
        public ViewHolder(View itemView) {
            super(itemView);
            ten=itemView.findViewById(R.id.UserNameManager);
            phone=itemView.findViewById(R.id.PhoneNumberManager);
            line=itemView.findViewById(R.id.cardUser);
            iconSua=itemView.findViewById(R.id.imgSua);
            iconchangepassword=itemView.findViewById(R.id.imgchangepass);
        }
    }
    public interface OnItemLongClickedListener {
        void onItemLongClick(String username);
    }

    private OnItemLongClickedListener onItemLongClickedListener;

    public void setOnItemLongClickedListener(OnItemLongClickedListener onItemLongClickedListener) {
        this.onItemLongClickedListener = onItemLongClickedListener;
    }
}
