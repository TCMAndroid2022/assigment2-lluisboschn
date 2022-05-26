//package cat.tecnocampus.mobileapps.practica2.LluisBoschNadal.IvanCarolNavas.MaricelNavarroSagarra;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.ArrayList;
//
//public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.ViewHolder> {
//    ArrayList<Player> data;
//
//    public PlayerAdapter(ArrayList<Player> data) {
//        this.data = data;
//    }
//
//    @NonNull
//    @Override
//    public PlayerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
//        ViewHolder vh = new ViewHolder(v);
//        return vh;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull PlayerAdapter.ViewHolder holder, int position) {
//        Player currentPlayer = data.get(position);
//        holder.tv_llistat_nickname.setText(String.valueOf(currentPlayer.getNickname()));
//        holder.tv_llistat_puntuacio.setText(currentPlayer.getPuntuacio());
//    }
//
//    @Override
//    public int getItemCount() {
//        return data.size();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder{
//        public TextView tv_llistat_nickname;
//        public TextView tv_llistat_puntuacio;
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            this.tv_llistat_nickname = itemView.findViewById(R.id.tv_llista_nickname);
//            this.tv_llistat_puntuacio = itemView.findViewById(R.id.tv_llista_puntuacio);
//        }
//    }
//}
