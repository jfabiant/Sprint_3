package pe.edu.tecsup.jfabiant.consumiendoservicioweb.adapters;

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
import pe.edu.tecsup.jfabiant.consumiendoservicioweb.models.Hospital;

public class HospitalAdapter extends RecyclerView.Adapter<HospitalAdapter.ViewHolder> {

    private List<Hospital> hospitales;

    public HospitalAdapter() {
        this.hospitales = new ArrayList<>();
    }

    public void setHospitales (List<Hospital> hospitales) {
        this.hospitales = hospitales;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView fotoImage;
        public TextView nombreText;
        public TextView distritoText;

        public ViewHolder(View itemView) {
            super(itemView);
            fotoImage = itemView.findViewById(R.id.foto_image);
            nombreText = itemView.findViewById(R.id.nombre_text);
            distritoText = itemView.findViewById(R.id.distrito_text);

        }
    }

    @Override
    public HospitalAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hospital, parent, false);
        return new ViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(HospitalAdapter.ViewHolder viewHolder, int position) {

        Hospital hospital = this.hospitales.get(position);
        viewHolder.nombreText.setText(hospital.getNombre());
        viewHolder.distritoText.setText(hospital.getC_distrito());

        String url = hospital.getHosp_img();
        Picasso.with(viewHolder.itemView.getContext()).load(url).into(viewHolder.fotoImage);

    }

    @Override
    public int getItemCount() {
        return this.hospitales.size();
    }
}
