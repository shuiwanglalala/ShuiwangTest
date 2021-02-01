package com.example.shuiwangtest;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import com.github.nisrulz.sensey.FlipDetector;
import com.github.nisrulz.sensey.MovementDetector;
import com.github.nisrulz.sensey.PickupDeviceDetector;
import com.github.nisrulz.sensey.PinchScaleDetector;
import com.github.nisrulz.sensey.Sensey;
import com.github.nisrulz.sensey.ShakeDetector;
import com.github.nisrulz.sensey.TouchTypeDetector;

public class GestureActivity extends AppCompatActivity implements
        GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {

    private static final String DEBUG_TAG = "Gestures";
    private static final String TAG = "GestureActivity";
    private GestureDetectorCompat mDetector;
    private ShakeDetector.ShakeListener shakeListener=new ShakeDetector.ShakeListener() {
        @Override public void onShakeDetected() {
            Log.d(TAG, "onShakeDetected: ");
        }

        @Override public void onShakeStopped() {
            Log.d(TAG, "onShakeStopped: ");
        }
    };

    MovementDetector.MovementListener movementListener=new MovementDetector.MovementListener() {
        @Override public void onMovement() {
            Log.d(TAG, "onMovement: ");
        }

        @Override public void onStationary() {
            Log.d(TAG, "onStationary: ");
        }

    };

    PickupDeviceDetector.PickupDeviceListener pickupDeviceListener = new PickupDeviceDetector.PickupDeviceListener() {
        @Override
        public void onDevicePickedUp() {
            Log.d(TAG, "onDevicePickedUp: ");
        }

        @Override
        public void onDevicePutDown() {
            Log.d(TAG, "onDevicePutDown: ");
        }
    };

    FlipDetector.FlipListener flipListener=new FlipDetector.FlipListener() {
        @Override public void onFaceUp() {
            Log.d(TAG, "onFaceUp: ");
        }

        @Override public void onFaceDown() {
            Log.d(TAG, "onFaceDown: ");
        }
    };

    PinchScaleDetector.PinchScaleListener pinchScaleListener=new PinchScaleDetector.PinchScaleListener() {
        @Override public void onScale(ScaleGestureDetector scaleGestureDetector, boolean isScalingOut) {
            if (isScalingOut) {
                Log.d(TAG, "onScale: 1");
            } else {
                Log.d(TAG, "onScale: 2");
            }
        }

        @Override public void onScaleStart(ScaleGestureDetector scaleGestureDetector) {
            Log.d(TAG, "onScaleStart: ");
        }

        @Override public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            Log.d(TAG, "onScaleEnd: ");
        }
    };

    TouchTypeDetector.TouchTypListener touchTypListener=new TouchTypeDetector.TouchTypListener() {
        @Override public void onTwoFingerSingleTap() {
            Log.d(TAG, "onTwoFingerSingleTap: ");
        }

        @Override public void onThreeFingerSingleTap() {
            Log.d(TAG, "onThreeFingerSingleTap: ");
        }

        @Override public void onDoubleTap() {
            Log.d(TAG, "onDoubleTap: ");
        }

        @Override public void onScroll(int scrollDirection) {
            switch (scrollDirection) {
                case TouchTypeDetector.SCROLL_DIR_UP:
                    // Scrolling Up
                    Log.d(TAG, "onScroll: SCROLL_DIR_UP");
                    break;
                case TouchTypeDetector.SCROLL_DIR_DOWN:
                    // Scrolling Down
                    Log.d(TAG, "onScroll: SCROLL_DIR_DOWN");
                    break;
                case TouchTypeDetector.SCROLL_DIR_LEFT:
                    // Scrolling Left
                    Log.d(TAG, "onScroll: SCROLL_DIR_LEFT");
                    break;
                case TouchTypeDetector.SCROLL_DIR_RIGHT:
                    // Scrolling Right
                    Log.d(TAG, "onScroll: SCROLL_DIR_RIGHT");
                    break;
                default:
                    // Do nothing
                    Log.d(TAG, "onScroll: ");
                    break;
            }
        }

        @Override public void onSingleTap() {
            Log.d(TAG, "onSingleTap: ");
        }

        @Override public void onSwipe(int swipeDirection) {
            switch (swipeDirection) {
                case TouchTypeDetector.SWIPE_DIR_UP:
                    // Swipe Up
                    Log.d(TAG, "onSwipe: SWIPE_DIR_UP");
                    break;
                case TouchTypeDetector.SWIPE_DIR_DOWN:
                    // Swipe Down
                    Log.d(TAG, "onSwipe: SWIPE_DIR_DOWN");
                    break;
                case TouchTypeDetector.SWIPE_DIR_LEFT:
                    // Swipe Left
                    Log.d(TAG, "onSwipe: SWIPE_DIR_LEFT");
                    break;
                case TouchTypeDetector.SWIPE_DIR_RIGHT:
                    // Swipe Right
                    Log.d(TAG, "onSwipe: SWIPE_DIR_RIGHT");
                    break;
                default:
                    //do nothing
                    Log.d(TAG, "onSwipe: ");
                    break;
            }
        }

        @Override public void onLongPress() {
            Log.d(TAG, "onLongPress: ");
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);
        mDetector = new GestureDetectorCompat(this,this);
        // Set the gesture detector as the double tap
        // listener.
        mDetector.setOnDoubleTapListener(this);
        Sensey.getInstance().init(this);
        Sensey.getInstance().startTouchTypeDetection(this, touchTypListener);
//        Sensey.getInstance().startPinchScaleDetection(this, pinchScaleListener);
//        Sensey.getInstance().startShakeDetection(shakeListener);
//        Sensey.getInstance().startMovementDetection(movementListener);
//        Sensey.getInstance().startPickupDeviceDetection(pickupDeviceListener);
//        Sensey.getInstance().startFlipDetection(flipListener);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Sensey.getInstance().stop();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
//        if (this.mDetector.onTouchEvent(event)) {
//            return true;
//        }

        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Sensey.getInstance().setupDispatchTouchEvent(ev);
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onDown(MotionEvent event) {
        Log.d(DEBUG_TAG,"onDown: " + event.toString());
        return true;
    }

    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2,
                           float velocityX, float velocityY) {
        Log.d(DEBUG_TAG, "onFling: " + event1.toString() + event2.toString());
        return true;
    }

    @Override
    public void onLongPress(MotionEvent event) {
        Log.d(DEBUG_TAG, "onLongPress: " + event.toString());
    }

    @Override
    public boolean onScroll(MotionEvent event1, MotionEvent event2, float distanceX,
                            float distanceY) {
        Log.d(DEBUG_TAG, "onScroll: " + event1.toString() + event2.toString());
        return true;
    }

    @Override
    public void onShowPress(MotionEvent event) {
        Log.d(DEBUG_TAG, "onShowPress: " + event.toString());
    }

    @Override
    public boolean onSingleTapUp(MotionEvent event) {
        Log.d(DEBUG_TAG, "onSingleTapUp: " + event.toString());
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent event) {
        Log.d(TAG, "onDoubleTap: " + event.toString());
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent event) {
        Log.d(TAG, "onDoubleTapEvent: " + event.toString());
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent event) {
        Log.d(TAG, "onSingleTapConfirmed: " + event.toString());
        return true;
    }

}
