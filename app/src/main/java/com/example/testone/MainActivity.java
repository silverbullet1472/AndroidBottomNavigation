package com.example.testone;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.testone.fragments.ArFragment;
import com.example.testone.fragments.MapFragment;
import com.example.testone.fragments.MeFragment;
import com.example.testone.fragments.MessageFragment;
import com.example.testone.fragments.TaskFragment;
import com.next.easynavigition.view.EasyNavigitionBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private EasyNavigitionBar mNavigationBar;
    private String[] tabText = {"地图", "任务", "AR", "消息", "我的"};
    //未选中icon
    private int[] normalIcon = {R.mipmap.map0, R.mipmap.task0, R.mipmap.ar, R.mipmap.message0,
            R.mipmap.me0};
    //选中时icon
    private int[] selectIcon = {R.mipmap.map1, R.mipmap.task1, R.mipmap.ar, R.mipmap.message1,
            R.mipmap.me1};
    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initNavigationBar();//初始化fragments和navigationBar
    }

    public void initNavigationBar(){
        mNavigationBar = findViewById(R.id.navigitionBar);
        fragments.add(new MapFragment());
        fragments.add(new TaskFragment());
        fragments.add(new ArFragment());
        fragments.add(new MessageFragment());
        fragments.add(new MeFragment());
        mNavigationBar.titleItems(tabText)
                .normalIconItems(normalIcon)
                .selectIconItems(selectIcon)
                .fragmentList(fragments)
                .mode(EasyNavigitionBar.MODE_ADD)
                .addAsFragment(true)
                .fragmentManager(getSupportFragmentManager())
                .build();
        mNavigationBar.getmViewPager().setOffscreenPageLimit(5);//设置缓存页面数
    }
    public EasyNavigitionBar getNavigationBar(){
        return mNavigationBar;
    }
}
