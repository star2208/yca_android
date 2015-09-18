package com.yca.adapter;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.nhaarman.listviewanimations.swinginadapters.AnimationAdapter;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ObjectAnimator;

public class CardsAnimationAdapter extends AnimationAdapter {
    private float mTranslationY = 400;
    private float mRotationX = 15;
    private long mDuration = 400;
    private long Delay = 30;

	public CardsAnimationAdapter(BaseAdapter baseAdapter) {
		super(baseAdapter);
		// TODO Auto-generated constructor stub
	}
    @Override
    protected long getAnimationDelayMillis() {
        return Delay;
    }

    @Override
    protected long getAnimationDurationMillis() {
        return mDuration;
    }
	@Override
	@NonNull
	public Animator[] getAnimators(@NonNull ViewGroup viewGroup, @NonNull View view) {
		// TODO Auto-generated method stub
		Animator[] animators = new Animator[]{
                ObjectAnimator.ofFloat(view, "translationY", mTranslationY, 0),
                ObjectAnimator.ofFloat(view, "rotationX", mRotationX, 0)
        };
        return animators;
	}

}
