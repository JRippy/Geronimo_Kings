package fr.geronimo.listsimple;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Julien on 04/05/2017.
 */

public class KingAdapter extends ArrayAdapter<King> {

    private Button buttonDetail;
    private Button buttonShare;
    private Context context;

    public KingAdapter(Context context, List<King> kingsl) {
        super(context, 0, kingsl);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_items_king,parent, false);
        }

        KingViewHolder viewHolder = (KingViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new KingViewHolder();
            viewHolder.name = (TextView) convertView.findViewById(R.id.king_name);
            viewHolder.details = (TextView) convertView.findViewById(R.id.king_detail);
            viewHolder.picture = (ImageView) convertView.findViewById(R.id.king_picture);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Tweet> tweets
        final King kingk = getItem(position);

        viewHolder.picture.setImageBitmap(kingk.getPicture());
        viewHolder.details.setText(kingk.getDetail());
        viewHolder.name.setText(kingk.getName());
        //viewHolder.picture.setImageDrawable(new ColorDrawable(tweet.getColor()));

        buttonDetail = (Button) convertView.findViewById(R.id.Button_king_detail);
        buttonShare = (Button) convertView.findViewById(R.id.Button_king_share);

        final View finalConvertView = convertView;
        final String strDetail = "Detail : " + kingk.getName();
        buttonDetail.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Toast.makeText(getContext().getApplicationContext(),
                        strDetail, Toast.LENGTH_LONG).show();

            }
        });

        final String strShare = "Hello : " + kingk.getName();
        buttonShare.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, strShare);
                sendIntent.setType("text/plain");
                context.startActivity(sendIntent);
            }
        });

        return convertView;
    }
}
