package hyunwook.co.kr.multiviewclick;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;


public class MultiViewImageClick extends Activity {
    public FrameLayout board;

    int movingCoordinateLeft = 0, movingCoordinateTop = 0;

    int windowHeight, windowWidth, defaultMargin = 150;
    ImageView answerOption1, answerOption2, answerOption3, dropZone1,
            dropZone2, dropZone3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        board = new FrameLayout(this);
        setContentView(R.layout.activity_main);

        //view object 세팅
        setIds();

        //touch listener.
        setOnTouchListener();

        getWindowDimensions();

    }

    //각 이미지뷰 터치 리스너 설정
    private void setOnTouchListener() {
        answerOption1.setOnTouchListener(dragt);
        answerOption2.setOnTouchListener(dragt);
        answerOption3.setOnTouchListener(dragt);

    }

    //각 항목 findViewById
    private void setIds() {

        board = (FrameLayout) findViewById(R.id.Board);
        // ids for answer options
        answerOption1 = (ImageView) findViewById(R.id.answer_black);
        answerOption2 = (ImageView) findViewById(R.id.answer_blue);
        answerOption3 = (ImageView) findViewById(R.id.answer_red);

    }


    private void getWindowDimensions() {
        // TODO Auto-generated method stub
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        windowHeight = metrics.heightPixels;
        System.out.println("window height" + windowHeight);
        windowWidth = metrics.widthPixels;
        System.out.println("window width" + windowWidth);

    }

    // onCreate
    View.OnTouchListener dragt = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            FrameLayout.LayoutParams par = (FrameLayout.LayoutParams) v.getLayoutParams();
            switch (v.getId()) {// What is being touched
                /***
                 *
                 * Answer option 1
                 *
                 * ***/
                case R.id.answer_black: {
                    // Which action is being taken
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_MOVE: {
                            par.topMargin = (int) event.getRawY()
                                    - (v.getHeight() + 22);
                            par.leftMargin = (int) event.getRawX()
                                    - (v.getWidth() / 2 + 150);

                            movingCoordinateLeft = (int) event.getRawX()
                                    - (v.getWidth() / 2 + 0);
                            movingCoordinateTop = par.topMargin;

                            v.setLayoutParams(par);

                            break;
                        }
                        case MotionEvent.ACTION_UP: {
                            par.height = 40;
                            par.width = 40;


                            if (windowHeight < 460) {
                                par.topMargin = 109;
                                par.leftMargin = 0;
                                par.height = 22;
                                par.width = 105;

                            } else {
                                par.topMargin = defaultMargin;
                                par.leftMargin = 0;
                            }


                            if ((movingCoordinateLeft > 10 && movingCoordinateLeft < 80)
                                    && (movingCoordinateTop > 10 && movingCoordinateTop < 100)) {



                                dropZone1.setImageDrawable(getResources().getDrawable(
                                        R.drawable.black));
                                answerOption1.setVisibility(View.INVISIBLE);

                            }

                            v.setLayoutParams(par);
                            break;
                        }
                        case MotionEvent.ACTION_DOWN: {



                            if (windowHeight < 460) {

                                par.height = 40;
                                par.width = 40;

                            } else {
                                par.height = 40;
                                par.width = 40;
                            }

                            v.setLayoutParams(par);
                            break;
                        }// inner case UP
                    }// inner switch
                    break;
                }// case pawn

                /***
                 *
                 * Answer blue
                 *
                 * ***/

                case R.id.answer_blue: {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_MOVE: {

                            par.topMargin = (int) event.getRawY()
                                    - (v.getHeight() + 22);
                            par.leftMargin = (int) event.getRawX()
                                    - (v.getWidth() / 2 + 150);

                            movingCoordinateLeft = (int) event.getRawX()
                                    - (v.getWidth() / 2 + 0);
                            movingCoordinateTop = par.topMargin;

                            v.setLayoutParams(par);

                            break;
                        }// inner case MOVE
                        case MotionEvent.ACTION_UP: {
                            par.height = 40;
                            par.width = 40;

                            if (windowHeight < 460) {
                                par.topMargin = 150;
                                par.leftMargin = 0;
                                par.height = 40;
                                par.width = 40;

                            } else {
                                par.topMargin = 200;
                                par.leftMargin = 0;
                            }


                            if ((movingCoordinateLeft > 120 && movingCoordinateLeft < 200)
                                    && (movingCoordinateTop > 10 && movingCoordinateTop < 100)) {


                                dropZone2.setImageDrawable(getResources().getDrawable(
                                        R.drawable.blue));
                                answerOption2.setVisibility(View.INVISIBLE);
                            }

                            v.setLayoutParams(par);

                            break;
                        }// inner case UP
                        case MotionEvent.ACTION_DOWN: {

                            if (windowHeight < 460) {

                                par.height = 40;
                                par.width = 40;

                            } else {
                                par.height = 40;
                                par.width = 40;
                            }

                            v.setLayoutParams(par);
                            break;
                        }// inner case UP
                    }// inner switch
                    break;
                }

                /***
                 *
                 * Answer red
                 *
                 * ***/

                case R.id.answer_red: {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_MOVE: {

                            par.topMargin = (int) event.getRawY()
                                    - (v.getHeight() + 22);
                            par.leftMargin = (int) event.getRawX()
                                    - (v.getWidth() / 2 + 150);

                            movingCoordinateLeft = (int) event.getRawX()
                                    - (v.getWidth() / 2 + 0);
                            movingCoordinateTop = par.topMargin;

                            v.setLayoutParams(par);

                            break;
                        }


                        case MotionEvent.ACTION_UP: {
                            par.height = 40;
                            par.width = 40;


                            if (windowHeight < 460) {
                                par.topMargin = 191;
                                par.leftMargin = 0;
                                par.height = 40;
                                par.width = 40;

                            } else {
                                par.topMargin = 250;
                                par.leftMargin = 0;
                            }


                            if ((movingCoordinateLeft > 220 && movingCoordinateLeft < 310)
                                    && (movingCoordinateTop > 10 && movingCoordinateTop < 100)) {

                                dropZone3.setImageDrawable(getResources().getDrawable(
                                        R.drawable.red));
                                answerOption3.setVisibility(View.INVISIBLE);
                            }
                            v.setLayoutParams(par);

                            break;
                        }

                        //action down
                        case MotionEvent.ACTION_DOWN: {

                            if (windowHeight < 460) {

                                par.height = 40;
                                par.width = 40;

                            } else {
                                par.height = 40;
                                par.width = 40;
                            }
                            v.setLayoutParams(par);
                            break;
                        }
                    }
                    break;
                }

            }
            return true;
        }

    };
}