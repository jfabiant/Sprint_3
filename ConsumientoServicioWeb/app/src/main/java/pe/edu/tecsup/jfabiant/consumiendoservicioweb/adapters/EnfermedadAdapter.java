package pe.edu.tecsup.jfabiant.consumiendoservicioweb.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import pe.edu.tecsup.jfabiant.consumiendoservicioweb.R;
import pe.edu.tecsup.jfabiant.consumiendoservicioweb.models.Enfermedad;
import pe.edu.tecsup.jfabiant.consumiendoservicioweb.models.Hospital;

public class EnfermedadAdapter extends RecyclerView.Adapter<EnfermedadAdapter.ViewHolder> {

    private List<Enfermedad> enfermedades;

    public EnfermedadAdapter(){
        this.enfermedades = new ArrayList<>();
    }

    public void setEnfermedades (List<Enfermedad> enfermedades){
        this.enfermedades = enfermedades;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nombreText;
        public TextView descripcionText;
        public ImageView fotoImage;

        public ViewHolder(View itemView) {
            super(itemView);
            fotoImage = itemView.findViewById(R.id.foto_image);
            nombreText = itemView.findViewById(R.id.nombre_text);
            descripcionText = itemView.findViewById(R.id.descripcion_text);

        }
    }

    @Override
    public EnfermedadAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_enfermedad, parent, false);
        return new EnfermedadAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(EnfermedadAdapter.ViewHolder viewHolder, int position) {
        /*
        Hospital hospital = this.hospitales.get(position);
        viewHolder.nombreText.setText(hospital.getNombre());
        viewHolder.distritoText.setText(hospital.getC_distrito());

        String url = hospital.getHosp_img();
        Picasso.with(viewHolder.itemView.getContext()).load(url).into(viewHolder.fotoImage);
        */

        Enfermedad enfermedad = this.enfermedades.get(position);
        viewHolder.nombreText.setText(enfermedad.getNombre());
        viewHolder.descripcionText.setText(enfermedad.getDescripcion());

        String url = enfermedad.getEnf_img();
        Picasso.with(viewHolder.itemView.getContext()).load(url).into(viewHolder.fotoImage);

    }

    @Override
    public int getItemCount() {
        return this.enfermedades.size();
    }
}
