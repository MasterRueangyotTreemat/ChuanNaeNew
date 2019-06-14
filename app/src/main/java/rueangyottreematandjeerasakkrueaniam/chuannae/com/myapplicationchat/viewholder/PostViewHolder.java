package rueangyottreematandjeerasakkrueaniam.chuannae.com.myapplicationchat.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import rueangyottreematandjeerasakkrueaniam.chuannae.com.myapplicationchat.R;
import rueangyottreematandjeerasakkrueaniam.chuannae.com.myapplicationchat.models.Post;

public class PostViewHolder extends RecyclerView.ViewHolder {

    public TextView titleView;
    public TextView authorView;
    public ImageView starView;
    public TextView numStarsView;
    public TextView bodyView;
    public ImageView post_author_photo1;
    public ImageView comment_photo1;
    public TextView numCommentsView;


    public PostViewHolder(View itemView) {
        super(itemView);


        titleView = itemView.findViewById(R.id.post_title);
        authorView = itemView.findViewById(R.id.post_author);
        starView = itemView.findViewById(R.id.star);
        numStarsView = itemView.findViewById(R.id.post_num_stars);
        bodyView = itemView.findViewById(R.id.post_body);
        post_author_photo1 = itemView.findViewById(R.id.post_author_photo);
        comment_photo1 = itemView.findViewById(R.id.comment_photo);

    }

    public void bindToPost(Post post, View.OnClickListener starClickListener) {

        titleView.setText(post.title);
        authorView.setText(post.author);
        numStarsView.setText(String.valueOf(post.starCount));
        bodyView.setText(post.body);

        starView.setOnClickListener(starClickListener);
    }
}
