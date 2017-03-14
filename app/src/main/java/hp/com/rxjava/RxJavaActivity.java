package hp.com.rxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import hp.com.retrofitdemo.R;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;

public class RxJavaActivity extends AppCompatActivity {
    Subscriber<String> subscribe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java);
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onCompleted() {
                Toast.makeText(RxJavaActivity.this, "onCompleted", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(RxJavaActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNext(String s) {
                Toast.makeText(RxJavaActivity.this, s, Toast.LENGTH_SHORT).show();


            }
        };

            subscribe = new Subscriber<String>() {

            @Override
            public void onStart() {
                super.onStart();

            }

            @Override
            public void onCompleted() {
                Toast.makeText(RxJavaActivity.this, "Subscriber onCompleted", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Toast.makeText(RxJavaActivity.this, "Subscriber onNext"+s, Toast.LENGTH_SHORT).show();
            }
        };

        Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("One");
                subscriber.onNext("Two");
                subscriber.onNext("Three");
                subscriber.onCompleted();

            }


        });

        Observable observable1 = Observable.just("Four","Five","Six");
        String[] datas = new  String[]{"Seven","Eight","Nine"};

        Observable observable2 = Observable.from(datas);
        observable.subscribe(observer);
        observable1.subscribe(observer);
//        if (subscribe.isUnsubscribed()){
//            subscribe.unsubscribe();
//        }
        observable2.subscribe(subscribe);


        Action1<String> onNext = new Action1<String>() {
            @Override
            public void call(String s) {
                Toast.makeText(RxJavaActivity.this, "Action  onNext "+s , Toast.LENGTH_SHORT).show();
            }
        };

        Action1<Throwable> onError = new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Toast.makeText(RxJavaActivity.this, "Action  onError"+throwable.toString(), Toast.LENGTH_SHORT).show();
            }
        };

        Action0 onCompleted = new Action0() {
            @Override
            public void call()
            {
                Toast.makeText(RxJavaActivity.this, "Action  onCompleted", Toast.LENGTH_SHORT).show();
            }
        };

        observable.subscribe(onNext);
//        observable.subscribe(onNext,onError);
//        observable.subscribe(onNext,onError,onCompleted);



        String[] names  =  new String[]{"Dog","Cat","Pig"};
        Observable.from(datas).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Toast.makeText(RxJavaActivity.this, "Observable 不完整定义"+s, Toast.LENGTH_SHORT).show();
            }
        });

//        observable.subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                Toast.makeText(RxJavaActivity.this, "Observable 不完整定义"+s, Toast.LENGTH_SHORT).show();
//            }
//        });
        observable1.lift(new Observable.Operator<String,Integer>() {
            @Override
            public Subscriber<? super Integer> call(final Subscriber<? super String> subscriber) {
                return new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {
                           subscriber.onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        subscriber.onError(e);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        subscriber.onNext("test"+integer);
                    }
                };
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (subscribe.isUnsubscribed()){
            subscribe.unsubscribe();
        }
    }
}
