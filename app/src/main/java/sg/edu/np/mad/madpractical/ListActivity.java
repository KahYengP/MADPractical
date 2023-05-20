package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.Random;

public class ListActivity extends AppCompatActivity {


    private ImageView imageButton;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ArrayList<String> userNameList = new ArrayList<>();
        ArrayList<String> descriptionList = new ArrayList<>();

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        for (int i = 0; i < 21; i++) {
            Random r = new Random();
            int randomNumber = r.nextInt(1000000000);
            userNameList.add(String.valueOf(randomNumber));
            userNameList.add(String.valueOf(randomNumber));

        }
        for (int i = 0; i < 21; i++) {
            Random r = new Random();
            int randomNumber = r.nextInt(1000000000);
            userNameList.add(String.valueOf(randomNumber));
            descriptionList.add(String.valueOf(randomNumber));

        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new UserAdapter(getApplicationContext(), userNameList));
        recyclerView.setAdapter(new UserAdapter(getApplicationContext(), descriptionList));



    }

    public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {
        private ArrayList<String> data;
        public class MyViewHolder extends RecyclerView.ViewHolder {
            private TextView nameTxt;
            private TextView descTxt;

            public MyViewHolder(View view) {
                super(view);
                nameTxt = view.findViewById(R.id.name);
                descTxt = view.findViewById(R.id.description);
            }

            public TextView getNameTxt(){
                return nameTxt;
            }

            public TextView getDescTxt(){
                return descTxt;
            }

        }
        public UserAdapter(Context applicationContext, ArrayList<String> input) {
            data = input;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_list, viewGroup, false);
            return new MyViewHolder(view);

        }

        @Override
        public void onBindViewHolder(MyViewHolder myViewHolder, final int position) {
            myViewHolder.getNameTxt().setText(data.get(position));
            myViewHolder.getDescTxt().setText(data.get(position));

        }

        

        @Override
        public int getItemCount() {
            return data.size();
        }


    }
}







