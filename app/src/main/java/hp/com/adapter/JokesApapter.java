package hp.com.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import hp.com.retrofitdemo.R;
import hp.com.retrofitdemo.bean.SimpleBean;


/**
 * Created by tangdekun on 2017/3/15.
 */

public class JokesApapter extends RecyclerView.Adapter<JokesApapter.JokesViewHolder> {

    List<SimpleBean.ResultSimple.DataSimple> mdata;
    Context mContext;
    LayoutInflater inflater;



    public JokesApapter(List<SimpleBean.ResultSimple.DataSimple> mdata, Context context) {
        this.mContext = context;
        if (mdata != null && mdata.size() > 0) {
            mdata.clear();
        }
        this.mdata = mdata;
        inflater = LayoutInflater.from(mContext);
    }



    @Override
    public JokesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item_jokes_adapter, parent, false);
        JokesViewHolder ViewHolder = new JokesViewHolder(view);
        return ViewHolder;
    }

    @Override
    public void onBindViewHolder(JokesViewHolder holder, int position) {
        holder.itemJokesContent.setText(mdata.get(position).getContent());
        holder.itemJokesTime.setText(mdata.get(position).getUpdatetime());

    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public class JokesViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_jokes_content)
        TextView itemJokesContent;
        @BindView(R.id.item_jokes_time)
        TextView itemJokesTime;

        public JokesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(itemView);
        }
    }


}
