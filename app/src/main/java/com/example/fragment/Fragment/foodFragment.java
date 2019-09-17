package com.example.fragment.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragment.Helper;
import com.example.fragment.Model.UserModel;
import com.example.fragment.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class foodFragment extends Fragment
{
    View view;
    TextView text_id,text_author,text_category;
    ImageView image_thumbnail;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    DividerItemDecoration dividerItemDecoration;
    Retrofit retrofit;
    Helper helper;
    getAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.food,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        text_id = view.findViewById(R.id.ID);
        text_author = view.findViewById(R.id.author);
        text_category = view.findViewById(R.id.category);
        image_thumbnail = view.findViewById(R.id.smallThumbnail);
        recyclerView = view.findViewById(R.id.recycler_view_car);
        linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        dividerItemDecoration = new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(dividerItemDecoration);
        retrofit = new Retrofit
                .Builder()
                .baseUrl("https://www.googleapis.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        helper = retrofit.create(Helper.class);

        getfood();
    }

    private void getfood()
    {
        Call<ArrayList<UserModel>> call = helper.foodHelper();
        call.enqueue(new Callback<ArrayList<UserModel>>()
        {
            @Override
            public void onResponse(Call<ArrayList<UserModel>> call, Response<ArrayList<UserModel>> response)
            {
                if (response.isSuccessful())
                {
                    ArrayList<UserModel> models = response.body();
                    adapter = new getAdapter(models);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<UserModel>> call, Throwable t)
            {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public class getAdapter extends RecyclerView.Adapter<getAdapter.getVH>
    {
        ArrayList<UserModel> userModels ;

        public getAdapter(ArrayList<UserModel> userModels)
        {
            this.userModels = userModels;
        }

        @NonNull
        @Override
        public getVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
        {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.item,parent,false);
            return new getVH(view);
        }

        @Override
        public void onBindViewHolder(@NonNull getVH holder, int position)
        {
            UserModel model = userModels.get(position);
            holder.id.setText(model.getItems().getId());
            holder.author.setText(model.getItems().getVolumeInfo().getAuthors());
            holder.categ.setText(model.getItems().getVolumeInfo().getCategories());
            holder.image.setImageResource(model.getItems().getVolumeInfo().getImageLinks().getSmallThumbnail());
        }

        @Override
        public int getItemCount()
        {
            return userModels.size();
        }

        public class getVH extends RecyclerView.ViewHolder
        {
            TextView id,author,categ;
            ImageView image;
            public getVH(@NonNull View itemView)
            {
                super(itemView);
                id = itemView.findViewById(R.id.ID);
                author = itemView.findViewById(R.id.author);
                categ = itemView.findViewById(R.id.category);
                image = itemView.findViewById(R.id.smallThumbnail);
            }
        }
    }
}
