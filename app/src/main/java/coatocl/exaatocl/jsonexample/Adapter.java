package coatocl.exaatocl.jsonexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>
{
    private ArrayList<String>employeeName;
    private ArrayList<String>employeeEmail;
    private ArrayList<String>employeeNumber;
    private Context context;

    Adapter(ArrayList<String> employeeName, ArrayList<String> employeeEmail, ArrayList<String> employeeNumber, Context context)
    {
        this.employeeName = employeeName;
        this.employeeEmail = employeeEmail;
        this.employeeNumber = employeeNumber;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.show,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        holder.t1.setText(employeeName.get(position));
        holder.t2.setText(employeeEmail.get(position));
        holder.t3.setText(employeeNumber.get(position));

        holder.itemView.setOnClickListener(v ->
                Toast.makeText(context,"Name :-"+employeeName.get(position),Toast.LENGTH_SHORT).show());
    }

    @Override
    public int getItemCount() {
        return employeeName.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView t1,t2,t3;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            t1 =itemView.findViewById(R.id.name);
            t2 =itemView.findViewById(R.id.email);
            t3 =itemView.findViewById(R.id.number);

        }
    }
}
