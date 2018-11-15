package pe.edu.tecsup.jfabiant.medibotapp.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pe.edu.tecsup.jfabiant.medibotapp.R;
import pe.edu.tecsup.jfabiant.medibotapp.models.User;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder>{

    private List<User> users;

    public UserAdapter () {
        this.users = new ArrayList<>();
    }

    public void setUsers (List<User> users) {
        this.users = users;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView avatarImage;
        public TextView usernameText;
        public TextView emailText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            usernameText = itemView.findViewById(R.id.username_text);
            emailText = itemView.findViewById(R.id.email_text);

        }
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder viewHolder, int position) {
        User user = this.users.get(position);
        viewHolder.usernameText.setText(user.getUsername());
        viewHolder.emailText.setText(user.getEmail());
    }

    @Override
    public int getItemCount() {
        return this.users.size();
    }
}
