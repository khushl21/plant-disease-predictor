package com.example.sih_project;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Crop_list extends AppCompatActivity {

    private ListView listView;
    private CropAdapter cropAdapter;
    private ArrayList<CropItem> cropItemArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_crop_list);
        listView = findViewById(R.id.listview);
        initArrayList();
        cropAdapter = new CropAdapter(this, cropItemArrayList);
        listView.setAdapter(cropAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                CropItem cropItem = cropAdapter.getItem(i);
                Toast.makeText(Crop_list.this, cropItem.getNames(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private void initArrayList(){
        cropItemArrayList.clear();
        cropItemArrayList.add(new CropItem("Onion", "https://imgs.search.brave.com/PYGTlzKLVeZQc01r_rehNGxk_BYrb3nVIZ_0OgKQBlY/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9tZWRp/YS5pc3RvY2twaG90/by5jb20vaWQvNTEz/OTIwMzc5L3Bob3Rv/L29uaW9uLWJ1bGJz/LmpwZz9zPTYxMng2/MTImdz0wJms9MjAm/Yz1FcUw4dmVsTktZ/T0labVdod1p0dF9X/ZFd5a0ljYUdCYlBQ/SjRLQV9QR09nPQ"));
        cropItemArrayList.add(new CropItem("Lettuce", "https://imgs.search.brave.com/FTBFb_aTppUerDQ-o4TEG56tef2iOcFMli3vMT4vmwA/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9tZWRp/YS5pc3RvY2twaG90/by5jb20vaWQvMTYz/NzM5ODIxL3Bob3Rv/L2xldHR1Y2UuanBn/P3M9NjEyeDYxMiZ3/PTAmaz0yMCZjPUcw/NEV4aTJSeG1STGYz/ZkxYdVpkdnp0aFV1/WHZMT2d1WWlqTEI3/WFNWcms9"));
        cropItemArrayList.add(new CropItem("Apple", "https://imgs.search.brave.com/ylbIMylRbGHPyPXYnZERMTM6w7OJQMqI9kexJAn_Q_Y/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9tZWRp/YS5nZXR0eWltYWdl/cy5jb20vaWQvMTg0/Mjc2ODE4L3Bob3Rv/L3JlZC1hcHBsZS5q/cGc_cz02MTJ4NjEy/Jnc9MCZrPTIwJmM9/TnZPLWJMc0cwREpf/N0lpOFNTVm9LTHVy/emptVjBRaTRlR2Zu/Nm5XM2w1dz0"));
        cropItemArrayList.add(new CropItem("Garlic", "https://imgs.search.brave.com/mB3of8BZNAlnvHFSOj7mSnNaV4qDi75JO-uaM6CXz6k/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9tZWRp/YS5pc3RvY2twaG90/by5jb20vaWQvNDk5/MTQ3ODY0L3Bob3Rv/L2dhcmxpYy5qcGc_/cz02MTJ4NjEyJnc9/MCZrPTIwJmM9LTli/NDgzVjZVUDJVcmxq/RVlaRGNFQkV3emtQ/cWIzdTVNSUozLU1h/b2Z1Yz0"));
        cropItemArrayList.add(new CropItem("Carrot", "https://imgs.search.brave.com/4w7aHsGeJ42IH1J8Vl67O3dEZADxma4CZQIwuGgWqHc/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9tZWRp/YS5nZXR0eWltYWdl/cy5jb20vaWQvOTIw/MjY1MjAvcGhvdG8v/Y2Fycm90cy5qcGc_/cz02MTJ4NjEyJnc9/MCZrPTIwJmM9N1F6/VzRERW9IZFNKUU5p/aXRyM1c0UnZLOUxO/REMwVjR4aFVxNm9Z/THJPRT0"));
        cropItemArrayList.add(new CropItem("Spinach", "https://imgs.search.brave.com/uncd-PTXGQ3CbBSQI2xobk2w4NgcS7MP8g4ViNOAj6A/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9tZWRp/YS5pc3RvY2twaG90/by5jb20vaWQvMTc3/NDIzMDc4L3Bob3Rv/L3NwaW5hY2gtb24t/d2hpdGUuanBnP3M9/NjEyeDYxMiZ3PTAm/az0yMCZjPTEtWWtQ/OElZNWF3cmU1aVZF/YUM4Q0tTdHMyMWZN/Mjd4Y0ZWMmZreC1t/eXc9"));
        cropItemArrayList.add(new CropItem("Potato", "https://upload.wikimedia.org/wikipedia/commons/4/43/Potato-800x800.jpg"));
        cropItemArrayList.add(new CropItem("Tomato", "https://imgs.search.brave.com/2EP4IMjfgamEAW645aKxLyLhS5fP6eSPZHCyKmLNhfc/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9tZWRp/YS5pc3RvY2twaG90/by5jb20vaWQvOTMw/NDE5OTUvcGhvdG8v/dG9tYXRvLXctY2xp/cHBpbmctcGF0aC5q/cGc_cz02MTJ4NjEy/Jnc9MCZrPTIwJmM9/WXhTNjFjRUNsclFI/XzZ6MDFqdFlXWjU0/RU5hcndwVE5TdWZH/YW9fV2wxST0"));
        cropItemArrayList.add(new CropItem("Mango", "https://imgs.search.brave.com/kDdXbbKVXdrosA77WPcshDpM8fEEsXA14Wa3aGkxT_I/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9tZWRp/YS5pc3RvY2twaG90/by5jb20vaWQvMTY4/MzcwMTM4L3Bob3Rv/L21hbmdvLmpwZz9z/PTYxMng2MTImdz0w/Jms9MjAmYz1FTnEy/QnJVVjhkTkgycnRo/X1pZQkJ0UzlSV0R3/Q2JJMjVTZnVseGly/bW5RPQ"));
        cropItemArrayList.add(new CropItem("Strawberry", "https://imgs.search.brave.com/AtqunEfFC8k6P4N1PldMDU6wTQanepqfuXeSoDKysp0/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9tZWRp/YS5pc3RvY2twaG90/by5jb20vaWQvNjky/NTQyMzk0L3Bob3Rv/L3N0cmF3YmVycnku/anBnP3M9NjEyeDYx/MiZ3PTAmaz0yMCZj/PVlMUUgyb2hjdkVJ/M0hCWDNlenJ6Vkoy/RFlSMndla2RKNnNz/YjZ5RjZiOTA9"));
        cropItemArrayList.add(new CropItem("Peach", "https://imgs.search.brave.com/q1fSroAJti03tilPMfa2ZzGSevITI9uqlTCsVurlFy8/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly90NC5m/dGNkbi5uZXQvanBn/LzAwLzk5LzA2LzYz/LzM2MF9GXzk5MDY2/MzY5X3VTOThTWlY0/SlQ1cGJNUmRhb1Bq/ZkpsNGRMTDZtaFRY/LmpwZw"));
    }
}