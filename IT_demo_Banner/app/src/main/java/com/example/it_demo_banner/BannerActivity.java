package com.example.it_demo_banner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.snackbar.Snackbar;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.transformer.AlphaPageTransformer;
import com.youth.banner.transformer.DepthPageTransformer;
import com.youth.banner.transformer.RotateDownPageTransformer;
import com.youth.banner.transformer.RotateUpPageTransformer;
import com.youth.banner.transformer.RotateYTransformer;
import com.youth.banner.transformer.ScaleInTransformer;
import com.youth.banner.transformer.ZoomOutPageTransformer;

public class BannerActivity extends AppCompatActivity {
    private Banner banner,banner2;
    private static final String TAG = "BannerActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);
        banner = findViewById(R.id.banner);
        banner2 = findViewById(R.id.banner2);

        banner.setLoopTime(1000);
        banner.setPageTransformer(new RotateYTransformer());

        banner2.setLoopTime(1000);
        banner2.setPageTransformer(new RotateYTransformer());
//        ImageAdapter imageAdapter = new ImageAdapter(DataBean.getTestData2());
//        //加载本地图片
//        banner.setAdapter(imageAdapter)
//                .addBannerLifecycleObserver(this)
//                .setIndicator(new CircleIndicator(this))
//                .setOnBannerListener(new OnBannerListener() {
//                    @Override
//                    public void OnBannerClick(Object data, int position) {
//                        Snackbar.make(banner, ((DataBean) data).title, Snackbar.LENGTH_SHORT).show();
//                        Log.i(TAG, "position: " + position);
//                    }
//                });

        //加载网络图片
        banner.setAdapter(new BannerImageAdapter<DataBean>(DataBean.getTestData3()) {
            @Override
            public void onBindView(BannerImageHolder holder, DataBean data, int position, int size) {
                Glide.with(holder.imageView)
                        .load(data.imageUrl)
                        .thumbnail(Glide.with(holder.itemView).load(R.drawable.loading)) //加载缩略图
                        .apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
                        .into(holder.imageView);
            }
        });
        banner.setIndicator(new CircleIndicator(this));

        banner2.setAdapter(new BannerImageAdapter<DataBean>(DataBean.getTestData3()) {
            @Override
            public void onBindView(BannerImageHolder holder, DataBean data, int position, int size) {
                Glide.with(holder.imageView)
                        .load(data.imageUrl)
                        .thumbnail(Glide.with(holder.itemView).load(R.drawable.loading)) //加载缩略图
                        .apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
                        .into(holder.imageView);
            }
        });
        banner2.setIndicator(new CircleIndicator(this));
    }
}