package hp.com.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.orhanobut.logger.Logger;

import java.util.List;

import hp.com.retrofitdemo.R;
import hp.com.retrofitdemo.bean.JokeBean;


/**
 * Created by tangdekun on 2017/3/15.
 */

public class JokesJokeBeanApapter extends RecyclerView.Adapter<JokesJokeBeanApapter.JokesViewHolder> {

    private static final String TAG = JokesJokeBeanApapter.class.getSimpleName();
    List<JokeBean> mdata;
    Context mContext;
    LayoutInflater inflater;




    public JokesJokeBeanApapter(List<JokeBean> mdata, Context context) {
        this.mContext = context;
        if (this.mdata != null && this.mdata.size() > 0) {
            this.mdata.clear();
        }
        this.mdata = mdata;
        inflater = LayoutInflater.from(mContext);
//        Logger.t(TAG).d(mdata.get(0).getContent());
    }


    @Override
    public JokesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item_jokes_adapter, parent, false);
        JokesViewHolder ViewHolder = new JokesViewHolder(view);
        return ViewHolder;
    }

    @Override
    public void onBindViewHolder(JokesViewHolder holder, int position) {
        Logger.t(TAG).d(mdata.get(position).getContent());
        holder.itemJokesContent.setText(mdata.get(position).getContent());
        holder.itemJokesTime.setText(mdata.get(position).getUpdatetime());

    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public class JokesViewHolder extends RecyclerView.ViewHolder {
        TextView itemJokesContent;
        TextView itemJokesTime;

        public JokesViewHolder(View itemView) {
            super(itemView);
            itemJokesContent= (TextView) itemView.findViewById(R.id.item_jokes_content);
            itemJokesTime = (TextView) itemView.findViewById(R.id.item_jokes_time);
        }
    }


}
