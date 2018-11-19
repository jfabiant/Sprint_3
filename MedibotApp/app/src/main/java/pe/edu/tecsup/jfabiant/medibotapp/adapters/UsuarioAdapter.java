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
import pe.edu.tecsup.jfabiant.medibotapp.models.Usuario;

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioAdapter.ViewHolder>{

    private List<Usuario> usuarios;

    public UsuarioAdapter() {
        this.usuarios = new ArrayList<>();
    }

    public void setUsers (List<Usuario> usuarios) {
        this.usuarios = usuarios;
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
    public UsuarioAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioAdapter.ViewHolder viewHolder, int position) {
        Usuario usuario = this.usuarios.get(position);
        viewHolder.usernameText.setText(usuario.getNombre());
        viewHolder.emailText.setText(usuario.getEmail());
    }

    @Override
    public int getItemCount() {
        return this.usuarios.size();
    }
}
